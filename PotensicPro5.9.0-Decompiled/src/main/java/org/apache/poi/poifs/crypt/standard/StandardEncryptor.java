package org.apache.poi.poifs.crypt.standard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
import org.apache.poi.poifs.filesystem.POIFSWriterListener;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutputStream;
import org.apache.poi.util.TempFile;

/* loaded from: classes5.dex */
public class StandardEncryptor extends Encryptor {
    private final StandardEncryptionInfoBuilder builder;

    protected StandardEncryptor(StandardEncryptionInfoBuilder standardEncryptionInfoBuilder) {
        this.builder = standardEncryptionInfoBuilder;
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[16];
        secureRandom.nextBytes(bArr);
        secureRandom.nextBytes(bArr2);
        confirmPassword(str, null, null, bArr, bArr2, null);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        StandardEncryptionVerifier verifier = this.builder.getVerifier();
        verifier.setSalt(bArr4);
        SecretKey generateSecretKey = StandardDecryptor.generateSecretKey(str, verifier, getKeySizeInBytes());
        setSecretKey(generateSecretKey);
        Cipher cipher = getCipher(generateSecretKey, null);
        try {
            byte[] doFinal = cipher.doFinal(bArr3);
            byte[] doFinal2 = cipher.doFinal(Arrays.copyOf(CryptoFunctions.getMessageDigest(verifier.getHashAlgorithm()).digest(bArr3), verifier.getCipherAlgorithm().encryptedVerifierHashLength));
            verifier.setEncryptedVerifier(doFinal);
            verifier.setEncryptedVerifierHash(doFinal2);
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException("Password confirmation failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Cipher getCipher(SecretKey secretKey, String str) {
        StandardEncryptionVerifier verifier = this.builder.getVerifier();
        return CryptoFunctions.getCipher(secretKey, verifier.getCipherAlgorithm(), verifier.getChainingMode(), null, 1, str);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public OutputStream getDataStream(DirectoryNode directoryNode) throws IOException, GeneralSecurityException {
        createEncryptionInfoEntry(directoryNode);
        DataSpaceMapUtils.addDefaultDataSpace(directoryNode);
        return new StandardCipherOutputStream(directoryNode);
    }

    protected class StandardCipherOutputStream extends FilterOutputStream implements POIFSWriterListener {
        protected long countBytes;
        protected final DirectoryNode dir;
        protected final File fileOut;

        protected StandardCipherOutputStream(DirectoryNode directoryNode) throws IOException {
            super(null);
            this.dir = directoryNode;
            File createTempFile = TempFile.createTempFile("encrypted_package", "crypt");
            this.fileOut = createTempFile;
            this.out = new CipherOutputStream(new FileOutputStream(createTempFile), StandardEncryptor.this.getCipher(StandardEncryptor.this.getSecretKey(), "PKCS5Padding"));
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.out.write(bArr, i, i2);
            this.countBytes += i2;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            this.out.write(i);
            this.countBytes++;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            writeToPOIFS();
        }

        void writeToPOIFS() throws IOException {
            this.dir.createDocument(Decryptor.DEFAULT_POIFS_ENTRY, (int) (this.fileOut.length() + 8), this);
        }

        @Override // org.apache.poi.poifs.filesystem.POIFSWriterListener
        public void processPOIFSWriterEvent(POIFSWriterEvent pOIFSWriterEvent) {
            try {
                LittleEndianOutputStream littleEndianOutputStream = new LittleEndianOutputStream(pOIFSWriterEvent.getStream());
                littleEndianOutputStream.writeLong(this.countBytes);
                FileInputStream fileInputStream = new FileInputStream(this.fileOut);
                IOUtils.copy(fileInputStream, littleEndianOutputStream);
                fileInputStream.close();
                this.fileOut.delete();
                littleEndianOutputStream.close();
            } catch (IOException e) {
                throw new EncryptedDocumentException(e);
            }
        }
    }

    protected int getKeySizeInBytes() {
        return this.builder.getHeader().getKeySize() / 8;
    }

    protected void createEncryptionInfoEntry(DirectoryNode directoryNode) throws IOException {
        final EncryptionInfo encryptionInfo = this.builder.getEncryptionInfo();
        final StandardEncryptionHeader header = this.builder.getHeader();
        final StandardEncryptionVerifier verifier = this.builder.getVerifier();
        DataSpaceMapUtils.createEncryptionEntry(directoryNode, "EncryptionInfo", new EncryptionRecord() { // from class: org.apache.poi.poifs.crypt.standard.StandardEncryptor.1
            @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
            public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMajor());
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMinor());
                littleEndianByteArrayOutputStream.writeInt(encryptionInfo.getEncryptionFlags());
                header.write(littleEndianByteArrayOutputStream);
                verifier.write(littleEndianByteArrayOutputStream);
            }
        });
    }
}
