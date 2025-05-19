package org.apache.poi.poifs.crypt.agile;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity;
import com.microsoft.schemas.office.x2006.encryption.CTEncryption;
import com.microsoft.schemas.office.x2006.encryption.CTKeyData;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors;
import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
import com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STCipherChaining;
import com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm;
import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.agile.AgileEncryptionVerifier;
import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.xmlbeans.XmlOptions;

/* loaded from: classes5.dex */
public class AgileEncryptor extends Encryptor {
    private final AgileEncryptionInfoBuilder builder;
    private byte[] integritySalt;
    private byte[] pwHash;
    private final CTKeyEncryptor.Uri.Enum passwordUri = CTKeyEncryptor.Uri.HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_PASSWORD;
    private final CTKeyEncryptor.Uri.Enum certificateUri = CTKeyEncryptor.Uri.HTTP_SCHEMAS_MICROSOFT_COM_OFFICE_2006_KEY_ENCRYPTOR_CERTIFICATE;

    protected AgileEncryptor(AgileEncryptionInfoBuilder agileEncryptionInfoBuilder) {
        this.builder = agileEncryptionInfoBuilder;
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str) {
        SecureRandom secureRandom = new SecureRandom();
        int blockSize = this.builder.getHeader().getBlockSize();
        byte[] bArr = new byte[blockSize];
        byte[] bArr2 = new byte[blockSize];
        byte[] bArr3 = new byte[blockSize];
        byte[] bArr4 = new byte[this.builder.getHeader().getKeySize() / 8];
        byte[] bArr5 = new byte[this.builder.getHeader().getHashAlgorithmEx().hashSize];
        secureRandom.nextBytes(bArr);
        secureRandom.nextBytes(bArr2);
        secureRandom.nextBytes(bArr3);
        secureRandom.nextBytes(bArr4);
        secureRandom.nextBytes(bArr5);
        confirmPassword(str, bArr4, bArr3, bArr, bArr2, bArr5);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        AgileEncryptionVerifier verifier = this.builder.getVerifier();
        verifier.setSalt(bArr4);
        AgileEncryptionHeader header = this.builder.getHeader();
        header.setKeySalt(bArr2);
        HashAlgorithm hashAlgorithm = verifier.getHashAlgorithm();
        int blockSize = header.getBlockSize();
        byte[] hashPassword = CryptoFunctions.hashPassword(str, hashAlgorithm, bArr4, verifier.getSpinCount());
        this.pwHash = hashPassword;
        verifier.setEncryptedVerifier(AgileDecryptor.hashInput(this.builder, hashPassword, AgileDecryptor.kVerifierInputBlock, bArr3, 1));
        verifier.setEncryptedVerifierHash(AgileDecryptor.hashInput(this.builder, this.pwHash, AgileDecryptor.kHashedVerifierBlock, CryptoFunctions.getMessageDigest(hashAlgorithm).digest(bArr3), 1));
        verifier.setEncryptedKey(AgileDecryptor.hashInput(this.builder, this.pwHash, AgileDecryptor.kCryptoKeyBlock, bArr, 1));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, verifier.getCipherAlgorithm().jceId);
        setSecretKey(secretKeySpec);
        this.integritySalt = bArr5;
        try {
            header.setEncryptedHmacKey(CryptoFunctions.getCipher(secretKeySpec, verifier.getCipherAlgorithm(), verifier.getChainingMode(), CryptoFunctions.generateIv(hashAlgorithm, header.getKeySalt(), AgileDecryptor.kIntegrityKeyBlock, header.getBlockSize()), 1).doFinal(CryptoFunctions.getBlock0(bArr5, AgileDecryptor.getNextBlockSize(bArr5.length, blockSize))));
            Cipher cipher = Cipher.getInstance("RSA");
            for (AgileEncryptionVerifier.AgileCertificateEntry agileCertificateEntry : verifier.getCertificates()) {
                cipher.init(1, agileCertificateEntry.x509.getPublicKey());
                agileCertificateEntry.encryptedKey = cipher.doFinal(getSecretKey().getEncoded());
                Mac mac = CryptoFunctions.getMac(hashAlgorithm);
                mac.init(getSecretKey());
                agileCertificateEntry.certVerifier = mac.doFinal(agileCertificateEntry.x509.getEncoded());
            }
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public OutputStream getDataStream(DirectoryNode directoryNode) throws IOException, GeneralSecurityException {
        return new AgileCipherOutputStream(directoryNode);
    }

    protected void updateIntegrityHMAC(File file, int i) throws GeneralSecurityException, IOException {
        HashAlgorithm hashAlgorithm = this.builder.getVerifier().getHashAlgorithm();
        Mac mac = CryptoFunctions.getMac(hashAlgorithm);
        mac.init(new SecretKeySpec(this.integritySalt, hashAlgorithm.jceHmacId));
        byte[] bArr = new byte[1024];
        LittleEndian.putLong(bArr, 0, i);
        mac.update(bArr, 0, 8);
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    mac.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    byte[] doFinal = mac.doFinal();
                    AgileEncryptionHeader header = this.builder.getHeader();
                    int blockSize = header.getBlockSize();
                    header.setEncryptedHmacValue(CryptoFunctions.getCipher(getSecretKey(), header.getCipherAlgorithm(), header.getChainingMode(), CryptoFunctions.generateIv(header.getHashAlgorithmEx(), header.getKeySalt(), AgileDecryptor.kIntegrityValueBlock, blockSize), 1).doFinal(CryptoFunctions.getBlock0(doFinal, AgileDecryptor.getNextBlockSize(doFinal.length, blockSize))));
                    return;
                }
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        }
    }

    protected EncryptionDocument createEncryptionDocument() {
        AgileEncryptionVerifier verifier = this.builder.getVerifier();
        AgileEncryptionHeader header = this.builder.getHeader();
        EncryptionDocument newInstance = EncryptionDocument.Factory.newInstance();
        CTEncryption addNewEncryption = newInstance.addNewEncryption();
        CTKeyData addNewKeyData = addNewEncryption.addNewKeyData();
        CTKeyEncryptors addNewKeyEncryptors = addNewEncryption.addNewKeyEncryptors();
        CTKeyEncryptor addNewKeyEncryptor = addNewKeyEncryptors.addNewKeyEncryptor();
        addNewKeyEncryptor.setUri(this.passwordUri);
        CTPasswordKeyEncryptor addNewEncryptedPasswordKey = addNewKeyEncryptor.addNewEncryptedPasswordKey();
        addNewEncryptedPasswordKey.setSpinCount(verifier.getSpinCount());
        addNewKeyData.setSaltSize(header.getBlockSize());
        addNewEncryptedPasswordKey.setSaltSize(header.getBlockSize());
        addNewKeyData.setBlockSize(header.getBlockSize());
        addNewEncryptedPasswordKey.setBlockSize(header.getBlockSize());
        addNewKeyData.setKeyBits(header.getKeySize());
        addNewEncryptedPasswordKey.setKeyBits(header.getKeySize());
        HashAlgorithm hashAlgorithmEx = header.getHashAlgorithmEx();
        addNewKeyData.setHashSize(hashAlgorithmEx.hashSize);
        addNewEncryptedPasswordKey.setHashSize(hashAlgorithmEx.hashSize);
        STCipherAlgorithm.Enum forString = STCipherAlgorithm.Enum.forString(header.getCipherAlgorithm().xmlId);
        if (forString == null) {
            throw new EncryptedDocumentException("CipherAlgorithm " + header.getCipherAlgorithm() + " not supported.");
        }
        addNewKeyData.setCipherAlgorithm(forString);
        addNewEncryptedPasswordKey.setCipherAlgorithm(forString);
        int i = AnonymousClass2.$SwitchMap$org$apache$poi$poifs$crypt$ChainingMode[header.getChainingMode().ordinal()];
        if (i == 1) {
            addNewKeyData.setCipherChaining(STCipherChaining.CHAINING_MODE_CBC);
            addNewEncryptedPasswordKey.setCipherChaining(STCipherChaining.CHAINING_MODE_CBC);
        } else if (i == 2) {
            addNewKeyData.setCipherChaining(STCipherChaining.CHAINING_MODE_CFB);
            addNewEncryptedPasswordKey.setCipherChaining(STCipherChaining.CHAINING_MODE_CFB);
        } else {
            throw new EncryptedDocumentException("ChainingMode " + header.getChainingMode() + " not supported.");
        }
        STHashAlgorithm.Enum forString2 = STHashAlgorithm.Enum.forString(hashAlgorithmEx.ecmaString);
        if (forString2 == null) {
            throw new EncryptedDocumentException("HashAlgorithm " + hashAlgorithmEx + " not supported.");
        }
        addNewKeyData.setHashAlgorithm(forString2);
        addNewEncryptedPasswordKey.setHashAlgorithm(forString2);
        addNewKeyData.setSaltValue(header.getKeySalt());
        addNewEncryptedPasswordKey.setSaltValue(verifier.getSalt());
        addNewEncryptedPasswordKey.setEncryptedVerifierHashInput(verifier.getEncryptedVerifier());
        addNewEncryptedPasswordKey.setEncryptedVerifierHashValue(verifier.getEncryptedVerifierHash());
        addNewEncryptedPasswordKey.setEncryptedKeyValue(verifier.getEncryptedKey());
        CTDataIntegrity addNewDataIntegrity = addNewEncryption.addNewDataIntegrity();
        addNewDataIntegrity.setEncryptedHmacKey(header.getEncryptedHmacKey());
        addNewDataIntegrity.setEncryptedHmacValue(header.getEncryptedHmacValue());
        for (AgileEncryptionVerifier.AgileCertificateEntry agileCertificateEntry : verifier.getCertificates()) {
            CTKeyEncryptor addNewKeyEncryptor2 = addNewKeyEncryptors.addNewKeyEncryptor();
            addNewKeyEncryptor2.setUri(this.certificateUri);
            CTCertificateKeyEncryptor addNewEncryptedCertificateKey = addNewKeyEncryptor2.addNewEncryptedCertificateKey();
            try {
                addNewEncryptedCertificateKey.setX509Certificate(agileCertificateEntry.x509.getEncoded());
                addNewEncryptedCertificateKey.setEncryptedKeyValue(agileCertificateEntry.encryptedKey);
                addNewEncryptedCertificateKey.setCertVerifier(agileCertificateEntry.certVerifier);
            } catch (CertificateEncodingException e) {
                throw new EncryptedDocumentException(e);
            }
        }
        return newInstance;
    }

    /* renamed from: org.apache.poi.poifs.crypt.agile.AgileEncryptor$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$crypt$ChainingMode;

        static {
            int[] iArr = new int[ChainingMode.values().length];
            $SwitchMap$org$apache$poi$poifs$crypt$ChainingMode = iArr;
            try {
                iArr[ChainingMode.cbc.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$ChainingMode[ChainingMode.cfb.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected void marshallEncryptionDocument(EncryptionDocument encryptionDocument, LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setCharacterEncoding("UTF-8");
        Map hashMap = new HashMap();
        hashMap.put(this.passwordUri.toString(), TtmlNode.TAG_P);
        hashMap.put(this.certificateUri.toString(), "c");
        xmlOptions.setUseDefaultNamespace();
        xmlOptions.setSaveSuggestedPrefixes(hashMap);
        xmlOptions.setSaveNamespacesFirst();
        xmlOptions.setSaveAggressiveNamespaces();
        xmlOptions.setSaveNoXmlDecl();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n".getBytes("UTF-8"));
            encryptionDocument.save(byteArrayOutputStream, xmlOptions);
            littleEndianByteArrayOutputStream.write(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new EncryptedDocumentException("error marshalling encryption info document", e);
        }
    }

    protected void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) throws IOException, GeneralSecurityException {
        DataSpaceMapUtils.addDefaultDataSpace(directoryNode);
        final EncryptionInfo info = this.builder.getInfo();
        DataSpaceMapUtils.createEncryptionEntry(directoryNode, "EncryptionInfo", new EncryptionRecord() { // from class: org.apache.poi.poifs.crypt.agile.AgileEncryptor.1
            @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
            public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
                littleEndianByteArrayOutputStream.writeShort(info.getVersionMajor());
                littleEndianByteArrayOutputStream.writeShort(info.getVersionMinor());
                littleEndianByteArrayOutputStream.writeInt(info.getEncryptionFlags());
                AgileEncryptor.this.marshallEncryptionDocument(AgileEncryptor.this.createEncryptionDocument(), littleEndianByteArrayOutputStream);
            }
        });
    }

    private class AgileCipherOutputStream extends ChunkedCipherOutputStream {
        public AgileCipherOutputStream(DirectoryNode directoryNode) throws IOException, GeneralSecurityException {
            super(directoryNode, 4096);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected Cipher initCipherForBlock(Cipher cipher, int i, boolean z) throws GeneralSecurityException {
            return AgileDecryptor.initCipherForBlock(cipher, i, z, AgileEncryptor.this.builder, AgileEncryptor.this.getSecretKey(), 1);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected void calculateChecksum(File file, int i) throws GeneralSecurityException, IOException {
            AgileEncryptor.this.updateIntegrityHMAC(file, i);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) throws IOException, GeneralSecurityException {
            AgileEncryptor.this.createEncryptionInfoEntry(directoryNode, file);
        }
    }
}
