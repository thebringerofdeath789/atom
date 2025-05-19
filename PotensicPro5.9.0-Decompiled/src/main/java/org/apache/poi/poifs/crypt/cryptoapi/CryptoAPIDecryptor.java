package org.apache.poi.poifs.crypt.cryptoapi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.BoundedInputStream;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianInputStream;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public class CryptoAPIDecryptor extends Decryptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long _length;

    private class SeekableByteArrayInputStream extends ByteArrayInputStream {
        Cipher cipher;
        byte[] oneByte;

        public void seek(int i) {
            if (i > this.count) {
                throw new ArrayIndexOutOfBoundsException(i);
            }
            this.pos = i;
            this.mark = i;
        }

        public void setBlock(int i) throws GeneralSecurityException {
            this.cipher = CryptoAPIDecryptor.this.initCipherForBlock(this.cipher, i);
        }

        @Override // java.io.ByteArrayInputStream, java.io.InputStream
        public synchronized int read() {
            int read = super.read();
            if (read == -1) {
                return -1;
            }
            byte[] bArr = this.oneByte;
            bArr[0] = (byte) read;
            try {
                this.cipher.update(bArr, 0, 1, bArr);
                return this.oneByte[0];
            } catch (ShortBufferException e) {
                throw new EncryptedDocumentException(e);
            }
        }

        @Override // java.io.ByteArrayInputStream, java.io.InputStream
        public synchronized int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read == -1) {
                return -1;
            }
            try {
                this.cipher.update(bArr, i, read, bArr, i);
                return read;
            } catch (ShortBufferException e) {
                throw new EncryptedDocumentException(e);
            }
        }

        public SeekableByteArrayInputStream(byte[] bArr) throws GeneralSecurityException {
            super(bArr);
            this.oneByte = new byte[]{0};
            this.cipher = CryptoAPIDecryptor.this.initCipherForBlock(null, 0);
        }
    }

    static class StreamDescriptorEntry {
        static BitField flagStream = BitFieldFactory.getInstance(1);
        int block;
        int flags;
        int reserved2;
        String streamName;
        int streamOffset;
        int streamSize;

        StreamDescriptorEntry() {
        }
    }

    protected CryptoAPIDecryptor(CryptoAPIEncryptionInfoBuilder cryptoAPIEncryptionInfoBuilder) {
        super(cryptoAPIEncryptionInfoBuilder);
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

    public Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException {
        return initCipherForBlock(cipher, i, this.builder, getSecretKey(), 2);
    }

    protected static Cipher initCipherForBlock(Cipher cipher, int i, EncryptionInfoBuilder encryptionInfoBuilder, SecretKey secretKey, int i2) throws GeneralSecurityException {
        HashAlgorithm hashAlgorithm = encryptionInfoBuilder.getVerifier().getHashAlgorithm();
        byte[] bArr = new byte[4];
        LittleEndian.putUInt(bArr, 0, i);
        MessageDigest messageDigest = CryptoFunctions.getMessageDigest(hashAlgorithm);
        messageDigest.update(secretKey.getEncoded());
        byte[] digest = messageDigest.digest(bArr);
        EncryptionHeader header = encryptionInfoBuilder.getHeader();
        int keySize = header.getKeySize();
        byte[] block0 = CryptoFunctions.getBlock0(digest, keySize / 8);
        if (keySize == 40) {
            block0 = CryptoFunctions.getBlock0(block0, 16);
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(block0, secretKey.getAlgorithm());
        if (cipher == null) {
            return CryptoFunctions.getCipher(secretKeySpec, header.getCipherAlgorithm(), null, null, i2);
        }
        cipher.init(i2, secretKeySpec);
        return cipher;
    }

    protected static SecretKey generateSecretKey(String str, EncryptionVerifier encryptionVerifier) {
        if (str.length() > 255) {
            str = str.substring(0, 255);
        }
        MessageDigest messageDigest = CryptoFunctions.getMessageDigest(encryptionVerifier.getHashAlgorithm());
        messageDigest.update(encryptionVerifier.getSalt());
        return new SecretKeySpec(messageDigest.digest(StringUtil.getToUnicodeLE(str)), encryptionVerifier.getCipherAlgorithm().jceId);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(DirectoryNode directoryNode) throws IOException, GeneralSecurityException {
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem();
        DocumentInputStream createDocumentInputStream = directoryNode.createDocumentInputStream((DocumentNode) directoryNode.getEntry("EncryptedSummary"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(createDocumentInputStream, byteArrayOutputStream);
        createDocumentInputStream.close();
        SeekableByteArrayInputStream seekableByteArrayInputStream = new SeekableByteArrayInputStream(byteArrayOutputStream.toByteArray());
        LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(seekableByteArrayInputStream);
        int readUInt = (int) littleEndianInputStream.readUInt();
        littleEndianInputStream.readUInt();
        seekableByteArrayInputStream.skip(readUInt - 8);
        seekableByteArrayInputStream.setBlock(0);
        int readUInt2 = (int) littleEndianInputStream.readUInt();
        StreamDescriptorEntry[] streamDescriptorEntryArr = new StreamDescriptorEntry[readUInt2];
        for (int i = 0; i < readUInt2; i++) {
            StreamDescriptorEntry streamDescriptorEntry = new StreamDescriptorEntry();
            streamDescriptorEntryArr[i] = streamDescriptorEntry;
            streamDescriptorEntry.streamOffset = (int) littleEndianInputStream.readUInt();
            streamDescriptorEntry.streamSize = (int) littleEndianInputStream.readUInt();
            streamDescriptorEntry.block = littleEndianInputStream.readUShort();
            int readUByte = littleEndianInputStream.readUByte();
            streamDescriptorEntry.flags = littleEndianInputStream.readUByte();
            StreamDescriptorEntry.flagStream.isSet(streamDescriptorEntry.flags);
            streamDescriptorEntry.reserved2 = littleEndianInputStream.readInt();
            streamDescriptorEntry.streamName = StringUtil.readUnicodeLE(littleEndianInputStream, readUByte);
            littleEndianInputStream.readShort();
        }
        for (int i2 = 0; i2 < readUInt2; i2++) {
            StreamDescriptorEntry streamDescriptorEntry2 = streamDescriptorEntryArr[i2];
            seekableByteArrayInputStream.seek(streamDescriptorEntry2.streamOffset);
            seekableByteArrayInputStream.setBlock(streamDescriptorEntry2.block);
            pOIFSFileSystem.createDocument(new BoundedInputStream(seekableByteArrayInputStream, streamDescriptorEntry2.streamSize), streamDescriptorEntry2.streamName);
        }
        littleEndianInputStream.close();
        byteArrayOutputStream.reset();
        pOIFSFileSystem.writeFilesystem(byteArrayOutputStream);
        this._length = byteArrayOutputStream.size();
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
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
