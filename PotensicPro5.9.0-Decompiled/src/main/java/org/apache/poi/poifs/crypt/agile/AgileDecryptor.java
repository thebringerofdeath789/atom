package org.apache.poi.poifs.crypt.agile;

import com.ipotensic.baselib.configs.UsbConfig;
import com.logan.flight.FlightConfig;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.agile.AgileEncryptionVerifier;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes5.dex */
public class AgileDecryptor extends Decryptor {
    private long _length;
    protected static final byte[] kVerifierInputBlock = {-2, FlightConfig.P1_SELF_A, -46, 118, 59, 75, -98, 121};
    protected static final byte[] kHashedVerifierBlock = {-41, FlightConfig.P3_SE_V0, 15, 109, 48, 97, UsbConfig.REV_REMOTER_MUTE_CODE, 78};
    protected static final byte[] kCryptoKeyBlock = {20, 110, 11, -25, -85, -84, -48, -42};
    protected static final byte[] kIntegrityKeyBlock = {95, FlightConfig.ATOM_LT, -83, 1, 12, -71, -31, -10};
    protected static final byte[] kIntegrityValueBlock = {FlightConfig.P1_SELF, 103, Byte.MAX_VALUE, 2, FlightConfig.ATOM_LT, 44, -124, UsbConfig.REV_REMOTER_STATE};

    protected static int getNextBlockSize(int i, int i2) {
        int i3 = i2;
        while (i3 < i) {
            i3 += i2;
        }
        return i3;
    }

    protected AgileDecryptor(AgileEncryptionInfoBuilder agileEncryptionInfoBuilder) {
        super(agileEncryptionInfoBuilder);
        this._length = -1L;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String str) throws GeneralSecurityException {
        AgileEncryptionVerifier agileEncryptionVerifier = (AgileEncryptionVerifier) this.builder.getVerifier();
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) this.builder.getHeader();
        HashAlgorithm hashAlgorithmEx = agileEncryptionHeader.getHashAlgorithmEx();
        CipherAlgorithm cipherAlgorithm = agileEncryptionHeader.getCipherAlgorithm();
        int blockSize = agileEncryptionHeader.getBlockSize();
        int keySize = agileEncryptionHeader.getKeySize() / 8;
        byte[] hashPassword = CryptoFunctions.hashPassword(str, agileEncryptionVerifier.getHashAlgorithm(), agileEncryptionVerifier.getSalt(), agileEncryptionVerifier.getSpinCount());
        byte[] hashInput = hashInput(this.builder, hashPassword, kVerifierInputBlock, agileEncryptionVerifier.getEncryptedVerifier(), 2);
        setVerifier(hashInput);
        byte[] digest = CryptoFunctions.getMessageDigest(hashAlgorithmEx).digest(hashInput);
        byte[] block0 = CryptoFunctions.getBlock0(hashInput(this.builder, hashPassword, kHashedVerifierBlock, agileEncryptionVerifier.getEncryptedVerifierHash(), 2), hashAlgorithmEx.hashSize);
        SecretKeySpec secretKeySpec = new SecretKeySpec(CryptoFunctions.getBlock0(hashInput(this.builder, hashPassword, kCryptoKeyBlock, agileEncryptionVerifier.getEncryptedKey(), 2), keySize), agileEncryptionVerifier.getCipherAlgorithm().jceId);
        byte[] block02 = CryptoFunctions.getBlock0(CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionVerifier.getChainingMode(), CryptoFunctions.generateIv(hashAlgorithmEx, agileEncryptionHeader.getKeySalt(), kIntegrityKeyBlock, blockSize), 2).doFinal(agileEncryptionHeader.getEncryptedHmacKey()), hashAlgorithmEx.hashSize);
        byte[] block03 = CryptoFunctions.getBlock0(CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionVerifier.getChainingMode(), CryptoFunctions.generateIv(hashAlgorithmEx, agileEncryptionHeader.getKeySalt(), kIntegrityValueBlock, blockSize), 2).doFinal(agileEncryptionHeader.getEncryptedHmacValue()), hashAlgorithmEx.hashSize);
        if (!Arrays.equals(block0, digest)) {
            return false;
        }
        setSecretKey(secretKeySpec);
        setIntegrityHmacKey(block02);
        setIntegrityHmacValue(block03);
        return true;
    }

    public boolean verifyPassword(KeyPair keyPair, X509Certificate x509Certificate) throws GeneralSecurityException {
        AgileEncryptionVerifier.AgileCertificateEntry agileCertificateEntry;
        AgileEncryptionVerifier agileEncryptionVerifier = (AgileEncryptionVerifier) this.builder.getVerifier();
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) this.builder.getHeader();
        HashAlgorithm hashAlgorithmEx = agileEncryptionHeader.getHashAlgorithmEx();
        CipherAlgorithm cipherAlgorithm = agileEncryptionHeader.getCipherAlgorithm();
        int blockSize = agileEncryptionHeader.getBlockSize();
        Iterator<AgileEncryptionVerifier.AgileCertificateEntry> it = agileEncryptionVerifier.getCertificates().iterator();
        while (true) {
            if (!it.hasNext()) {
                agileCertificateEntry = null;
                break;
            }
            agileCertificateEntry = it.next();
            if (x509Certificate.equals(agileCertificateEntry.x509)) {
                break;
            }
        }
        if (agileCertificateEntry == null) {
            return false;
        }
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, keyPair.getPrivate());
        SecretKeySpec secretKeySpec = new SecretKeySpec(cipher.doFinal(agileCertificateEntry.encryptedKey), agileEncryptionVerifier.getCipherAlgorithm().jceId);
        Mac mac = CryptoFunctions.getMac(hashAlgorithmEx);
        mac.init(secretKeySpec);
        byte[] doFinal = mac.doFinal(agileCertificateEntry.x509.getEncoded());
        byte[] block0 = CryptoFunctions.getBlock0(CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionVerifier.getChainingMode(), CryptoFunctions.generateIv(hashAlgorithmEx, agileEncryptionHeader.getKeySalt(), kIntegrityKeyBlock, blockSize), 2).doFinal(agileEncryptionHeader.getEncryptedHmacKey()), hashAlgorithmEx.hashSize);
        byte[] block02 = CryptoFunctions.getBlock0(CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionVerifier.getChainingMode(), CryptoFunctions.generateIv(hashAlgorithmEx, agileEncryptionHeader.getKeySalt(), kIntegrityValueBlock, blockSize), 2).doFinal(agileEncryptionHeader.getEncryptedHmacValue()), hashAlgorithmEx.hashSize);
        if (!Arrays.equals(agileCertificateEntry.certVerifier, doFinal)) {
            return false;
        }
        setSecretKey(secretKeySpec);
        setIntegrityHmacKey(block0);
        setIntegrityHmacValue(block02);
        return true;
    }

    protected static byte[] hashInput(EncryptionInfoBuilder encryptionInfoBuilder, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        EncryptionVerifier verifier = encryptionInfoBuilder.getVerifier();
        AgileDecryptor agileDecryptor = (AgileDecryptor) encryptionInfoBuilder.getDecryptor();
        int keySizeInBytes = agileDecryptor.getKeySizeInBytes();
        int blockSizeInBytes = agileDecryptor.getBlockSizeInBytes();
        HashAlgorithm hashAlgorithm = verifier.getHashAlgorithm();
        byte[] salt = verifier.getSalt();
        try {
            return CryptoFunctions.getCipher(new SecretKeySpec(CryptoFunctions.generateKey(bArr, hashAlgorithm, bArr2, keySizeInBytes), verifier.getCipherAlgorithm().jceId), verifier.getCipherAlgorithm(), verifier.getChainingMode(), CryptoFunctions.generateIv(hashAlgorithm, salt, null, blockSizeInBytes), i).doFinal(CryptoFunctions.getBlock0(bArr3, getNextBlockSize(bArr3.length, blockSizeInBytes)));
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(DirectoryNode directoryNode) throws IOException, GeneralSecurityException {
        DocumentInputStream createDocumentInputStream = directoryNode.createDocumentInputStream(Decryptor.DEFAULT_POIFS_ENTRY);
        this._length = createDocumentInputStream.readLong();
        return new AgileCipherInputStream(createDocumentInputStream, this._length);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public long getLength() {
        long j = this._length;
        if (j != -1) {
            return j;
        }
        throw new IllegalStateException("EcmaDecryptor.getDataStream() was not called");
    }

    protected static Cipher initCipherForBlock(Cipher cipher, int i, boolean z, EncryptionInfoBuilder encryptionInfoBuilder, SecretKey secretKey, int i2) throws GeneralSecurityException {
        AlgorithmParameterSpec ivParameterSpec;
        EncryptionHeader header = encryptionInfoBuilder.getHeader();
        if (cipher == null || z) {
            cipher = CryptoFunctions.getCipher(secretKey, header.getCipherAlgorithm(), header.getChainingMode(), header.getKeySalt(), i2, z ? "PKCS5Padding" : "NoPadding");
        }
        byte[] bArr = new byte[4];
        LittleEndian.putInt(bArr, 0, i);
        byte[] generateIv = CryptoFunctions.generateIv(header.getHashAlgorithmEx(), header.getKeySalt(), bArr, header.getBlockSize());
        if (header.getCipherAlgorithm() == CipherAlgorithm.rc2) {
            ivParameterSpec = new RC2ParameterSpec(secretKey.getEncoded().length * 8, generateIv);
        } else {
            ivParameterSpec = new IvParameterSpec(generateIv);
        }
        cipher.init(i2, secretKey, ivParameterSpec);
        return cipher;
    }

    private class AgileCipherInputStream extends ChunkedCipherInputStream {
        public AgileCipherInputStream(DocumentInputStream documentInputStream, long j) throws GeneralSecurityException {
            super(documentInputStream, j, 4096);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        protected Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException {
            return AgileDecryptor.initCipherForBlock(cipher, i, false, AgileDecryptor.this.builder, AgileDecryptor.this.getSecretKey(), 2);
        }
    }
}
