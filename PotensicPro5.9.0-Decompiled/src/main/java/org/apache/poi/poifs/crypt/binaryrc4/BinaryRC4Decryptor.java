package org.apache.poi.poifs.crypt.binaryrc4;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public class BinaryRC4Decryptor extends Decryptor {
    private long _length;

    private class BinaryRC4CipherInputStream extends ChunkedCipherInputStream {
        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        protected Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException {
            return BinaryRC4Decryptor.initCipherForBlock(cipher, i, BinaryRC4Decryptor.this.builder, BinaryRC4Decryptor.this.getSecretKey(), 2);
        }

        public BinaryRC4CipherInputStream(DocumentInputStream documentInputStream, long j) throws GeneralSecurityException {
            super(documentInputStream, j, 512);
        }
    }

    protected BinaryRC4Decryptor(BinaryRC4EncryptionInfoBuilder binaryRC4EncryptionInfoBuilder) {
        super(binaryRC4EncryptionInfoBuilder);
        this._length = -1L;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String str) {
        EncryptionVerifier verifier = this.builder.getVerifier();
        SecretKey generateSecretKey = generateSecretKey(str, verifier);
        try {
            Cipher initCipherForBlock = initCipherForBlock(null, 0, this.builder, generateSecretKey, 2);
            byte[] encryptedVerifier = verifier.getEncryptedVerifier();
            byte[] bArr = new byte[encryptedVerifier.length];
            initCipherForBlock.update(encryptedVerifier, 0, encryptedVerifier.length, bArr);
            setVerifier(bArr);
            if (!Arrays.equals(CryptoFunctions.getMessageDigest(verifier.getHashAlgorithm()).digest(bArr), initCipherForBlock.doFinal(verifier.getEncryptedVerifierHash()))) {
                return false;
            }
            setSecretKey(generateSecretKey);
            return true;
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    protected static Cipher initCipherForBlock(Cipher cipher, int i, EncryptionInfoBuilder encryptionInfoBuilder, SecretKey secretKey, int i2) throws GeneralSecurityException {
        HashAlgorithm hashAlgorithm = encryptionInfoBuilder.getVerifier().getHashAlgorithm();
        byte[] bArr = new byte[4];
        LittleEndian.putUInt(bArr, 0, i);
        SecretKeySpec secretKeySpec = new SecretKeySpec(CryptoFunctions.generateKey(secretKey.getEncoded(), hashAlgorithm, bArr, 16), secretKey.getAlgorithm());
        if (cipher == null) {
            return CryptoFunctions.getCipher(secretKeySpec, encryptionInfoBuilder.getHeader().getCipherAlgorithm(), null, null, i2);
        }
        cipher.init(i2, secretKeySpec);
        return cipher;
    }

    protected static SecretKey generateSecretKey(String str, EncryptionVerifier encryptionVerifier) {
        if (str.length() > 255) {
            str = str.substring(0, 255);
        }
        MessageDigest messageDigest = CryptoFunctions.getMessageDigest(encryptionVerifier.getHashAlgorithm());
        byte[] digest = messageDigest.digest(StringUtil.getToUnicodeLE(str));
        byte[] salt = encryptionVerifier.getSalt();
        messageDigest.reset();
        for (int i = 0; i < 16; i++) {
            messageDigest.update(digest, 0, 5);
            messageDigest.update(salt);
        }
        byte[] bArr = new byte[5];
        System.arraycopy(messageDigest.digest(), 0, bArr, 0, 5);
        return new SecretKeySpec(bArr, encryptionVerifier.getCipherAlgorithm().jceId);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(DirectoryNode directoryNode) throws IOException, GeneralSecurityException {
        DocumentInputStream createDocumentInputStream = directoryNode.createDocumentInputStream(Decryptor.DEFAULT_POIFS_ENTRY);
        this._length = createDocumentInputStream.readLong();
        return new BinaryRC4CipherInputStream(createDocumentInputStream, this._length);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public long getLength() {
        long j = this._length;
        if (j != -1) {
            return j;
        }
        throw new IllegalStateException("Decryptor.getDataStream() was not called");
    }
}
