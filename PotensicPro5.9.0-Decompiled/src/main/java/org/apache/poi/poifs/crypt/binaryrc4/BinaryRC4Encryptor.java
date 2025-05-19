package org.apache.poi.poifs.crypt.binaryrc4;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;

/* loaded from: classes5.dex */
public class BinaryRC4Encryptor extends Encryptor {
    private final BinaryRC4EncryptionInfoBuilder builder;

    protected class BinaryRC4CipherOutputStream extends ChunkedCipherOutputStream {
        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected void calculateChecksum(File file, int i) {
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected Cipher initCipherForBlock(Cipher cipher, int i, boolean z) throws GeneralSecurityException {
            return BinaryRC4Decryptor.initCipherForBlock(cipher, i, BinaryRC4Encryptor.this.builder, BinaryRC4Encryptor.this.getSecretKey(), 1);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        protected void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) throws IOException, GeneralSecurityException {
            BinaryRC4Encryptor.this.createEncryptionInfoEntry(directoryNode);
        }

        public BinaryRC4CipherOutputStream(DirectoryNode directoryNode) throws IOException, GeneralSecurityException {
            super(directoryNode, 512);
        }
    }

    protected BinaryRC4Encryptor(BinaryRC4EncryptionInfoBuilder binaryRC4EncryptionInfoBuilder) {
        this.builder = binaryRC4EncryptionInfoBuilder;
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[16];
        secureRandom.nextBytes(bArr);
        secureRandom.nextBytes(bArr2);
        confirmPassword(str, null, null, bArr2, bArr, null);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        BinaryRC4EncryptionVerifier verifier = this.builder.getVerifier();
        verifier.setSalt(bArr4);
        SecretKey generateSecretKey = BinaryRC4Decryptor.generateSecretKey(str, verifier);
        setSecretKey(generateSecretKey);
        try {
            Cipher initCipherForBlock = BinaryRC4Decryptor.initCipherForBlock(null, 0, this.builder, generateSecretKey, 1);
            byte[] bArr6 = new byte[16];
            initCipherForBlock.update(bArr3, 0, 16, bArr6);
            verifier.setEncryptedVerifier(bArr6);
            verifier.setEncryptedVerifierHash(initCipherForBlock.doFinal(CryptoFunctions.getMessageDigest(verifier.getHashAlgorithm()).digest(bArr3)));
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException("Password confirmation failed", e);
        }
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public OutputStream getDataStream(DirectoryNode directoryNode) throws IOException, GeneralSecurityException {
        return new BinaryRC4CipherOutputStream(directoryNode);
    }

    protected int getKeySizeInBytes() {
        return this.builder.getHeader().getKeySize() / 8;
    }

    protected void createEncryptionInfoEntry(DirectoryNode directoryNode) throws IOException {
        DataSpaceMapUtils.addDefaultDataSpace(directoryNode);
        final EncryptionInfo encryptionInfo = this.builder.getEncryptionInfo();
        final BinaryRC4EncryptionHeader header = this.builder.getHeader();
        final BinaryRC4EncryptionVerifier verifier = this.builder.getVerifier();
        DataSpaceMapUtils.createEncryptionEntry(directoryNode, "EncryptionInfo", new EncryptionRecord() { // from class: org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4Encryptor.1
            @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
            public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMajor());
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMinor());
                header.write(littleEndianByteArrayOutputStream);
                verifier.write(littleEndianByteArrayOutputStream);
            }
        });
    }
}
