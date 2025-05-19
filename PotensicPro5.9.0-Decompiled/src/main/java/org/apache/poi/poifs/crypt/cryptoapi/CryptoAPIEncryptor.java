package org.apache.poi.poifs.crypt.cryptoapi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.crypto.Cipher;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.PropertySetFactory;
import org.apache.poi.hpsf.WritingNotSupportedException;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIDecryptor;
import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public class CryptoAPIEncryptor extends Encryptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final CryptoAPIEncryptionInfoBuilder builder;

    protected CryptoAPIEncryptor(CryptoAPIEncryptionInfoBuilder cryptoAPIEncryptionInfoBuilder) {
        this.builder = cryptoAPIEncryptionInfoBuilder;
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
        CryptoAPIEncryptionVerifier verifier = this.builder.getVerifier();
        verifier.setSalt(bArr4);
        setSecretKey(CryptoAPIDecryptor.generateSecretKey(str, verifier));
        try {
            Cipher initCipherForBlock = initCipherForBlock(null, 0);
            byte[] bArr6 = new byte[bArr3.length];
            initCipherForBlock.update(bArr3, 0, bArr3.length, bArr6);
            verifier.setEncryptedVerifier(bArr6);
            verifier.setEncryptedVerifierHash(initCipherForBlock.doFinal(CryptoFunctions.getMessageDigest(verifier.getHashAlgorithm()).digest(bArr3)));
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException("Password confirmation failed", e);
        }
    }

    public Cipher initCipherForBlock(Cipher cipher, int i) throws GeneralSecurityException {
        return CryptoAPIDecryptor.initCipherForBlock(cipher, i, this.builder, getSecretKey(), 1);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public OutputStream getDataStream(DirectoryNode directoryNode) throws IOException, GeneralSecurityException {
        CipherByteArrayOutputStream cipherByteArrayOutputStream = new CipherByteArrayOutputStream();
        byte[] bArr = new byte[8];
        cipherByteArrayOutputStream.write(bArr, 0, 8);
        String[] strArr = {"\u0005SummaryInformation", "\u0005DocumentSummaryInformation"};
        ArrayList<CryptoAPIDecryptor.StreamDescriptorEntry> arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            String str = strArr[i2];
            if (directoryNode.hasEntry(str)) {
                CryptoAPIDecryptor.StreamDescriptorEntry streamDescriptorEntry = new CryptoAPIDecryptor.StreamDescriptorEntry();
                streamDescriptorEntry.block = i;
                streamDescriptorEntry.streamOffset = cipherByteArrayOutputStream.size();
                streamDescriptorEntry.streamName = str;
                streamDescriptorEntry.flags = CryptoAPIDecryptor.StreamDescriptorEntry.flagStream.setValue(0, 1);
                streamDescriptorEntry.reserved2 = 0;
                cipherByteArrayOutputStream.setBlock(i);
                DocumentInputStream createDocumentInputStream = directoryNode.createDocumentInputStream(str);
                IOUtils.copy(createDocumentInputStream, cipherByteArrayOutputStream);
                createDocumentInputStream.close();
                streamDescriptorEntry.streamSize = cipherByteArrayOutputStream.size() - streamDescriptorEntry.streamOffset;
                arrayList.add(streamDescriptorEntry);
                directoryNode.getEntry(str).delete();
                i++;
            }
        }
        int size = cipherByteArrayOutputStream.size();
        cipherByteArrayOutputStream.setBlock(0);
        LittleEndian.putUInt(bArr, 0, arrayList.size());
        cipherByteArrayOutputStream.write(bArr, 0, 4);
        for (CryptoAPIDecryptor.StreamDescriptorEntry streamDescriptorEntry2 : arrayList) {
            LittleEndian.putUInt(bArr, 0, streamDescriptorEntry2.streamOffset);
            cipherByteArrayOutputStream.write(bArr, 0, 4);
            LittleEndian.putUInt(bArr, 0, streamDescriptorEntry2.streamSize);
            cipherByteArrayOutputStream.write(bArr, 0, 4);
            LittleEndian.putUShort(bArr, 0, streamDescriptorEntry2.block);
            cipherByteArrayOutputStream.write(bArr, 0, 2);
            LittleEndian.putUByte(bArr, 0, (short) streamDescriptorEntry2.streamName.length());
            cipherByteArrayOutputStream.write(bArr, 0, 1);
            LittleEndian.putUByte(bArr, 0, (short) streamDescriptorEntry2.flags);
            cipherByteArrayOutputStream.write(bArr, 0, 1);
            LittleEndian.putUInt(bArr, 0, streamDescriptorEntry2.reserved2);
            cipherByteArrayOutputStream.write(bArr, 0, 4);
            byte[] toUnicodeLE = StringUtil.getToUnicodeLE(streamDescriptorEntry2.streamName);
            cipherByteArrayOutputStream.write(toUnicodeLE, 0, toUnicodeLE.length);
            LittleEndian.putShort(bArr, 0, (short) 0);
            cipherByteArrayOutputStream.write(bArr, 0, 2);
        }
        int size2 = cipherByteArrayOutputStream.size();
        LittleEndian.putUInt(bArr, 0, size);
        LittleEndian.putUInt(bArr, 4, size2 - size);
        cipherByteArrayOutputStream.reset();
        cipherByteArrayOutputStream.setBlock(0);
        cipherByteArrayOutputStream.write(bArr, 0, 8);
        cipherByteArrayOutputStream.setSize(size2);
        directoryNode.createDocument("EncryptedSummary", new ByteArrayInputStream(cipherByteArrayOutputStream.getBuf(), 0, size2));
        try {
            PropertySetFactory.newDocumentSummaryInformation().write(directoryNode, "\u0005DocumentSummaryInformation");
            return cipherByteArrayOutputStream;
        } catch (WritingNotSupportedException e) {
            throw new IOException(e);
        }
    }

    protected int getKeySizeInBytes() {
        return this.builder.getHeader().getKeySize() / 8;
    }

    protected void createEncryptionInfoEntry(DirectoryNode directoryNode) throws IOException {
        DataSpaceMapUtils.addDefaultDataSpace(directoryNode);
        final EncryptionInfo encryptionInfo = this.builder.getEncryptionInfo();
        final CryptoAPIEncryptionHeader header = this.builder.getHeader();
        final CryptoAPIEncryptionVerifier verifier = this.builder.getVerifier();
        DataSpaceMapUtils.createEncryptionEntry(directoryNode, "EncryptionInfo", new EncryptionRecord() { // from class: org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptor.1
            @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
            public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMajor());
                littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMinor());
                header.write(littleEndianByteArrayOutputStream);
                verifier.write(littleEndianByteArrayOutputStream);
            }
        });
    }

    private class CipherByteArrayOutputStream extends ByteArrayOutputStream {
        Cipher cipher;
        byte[] oneByte = {0};

        public CipherByteArrayOutputStream() throws GeneralSecurityException {
            setBlock(0);
        }

        public byte[] getBuf() {
            return this.buf;
        }

        public void setSize(int i) {
            this.count = i;
        }

        public void setBlock(int i) throws GeneralSecurityException {
            this.cipher = CryptoAPIEncryptor.this.initCipherForBlock(this.cipher, i);
        }

        @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
        public void write(int i) {
            try {
                byte[] bArr = this.oneByte;
                bArr[0] = (byte) i;
                this.cipher.update(bArr, 0, 1, bArr, 0);
                super.write(this.oneByte);
            } catch (Exception e) {
                throw new EncryptedDocumentException(e);
            }
        }

        @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            try {
                this.cipher.update(bArr, i, i2, bArr, i);
                super.write(bArr, i, i2);
            } catch (Exception e) {
                throw new EncryptedDocumentException(e);
            }
        }
    }
}
