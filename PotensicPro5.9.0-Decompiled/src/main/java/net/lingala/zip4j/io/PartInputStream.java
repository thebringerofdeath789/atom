package net.lingala.zip4j.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.unzip.UnzipEngine;

/* loaded from: classes4.dex */
public class PartInputStream extends BaseInputStream {
    private IDecrypter decrypter;
    private boolean isAESEncryptedFile;
    private long length;
    private RandomAccessFile raf;
    private UnzipEngine unzipEngine;
    private byte[] oneByteBuff = new byte[1];
    private byte[] aesBlockByte = new byte[16];
    private int aesBytesReturned = 0;
    private int count = -1;
    private long bytesRead = 0;

    public PartInputStream(RandomAccessFile randomAccessFile, long j, long j2, UnzipEngine unzipEngine) {
        this.isAESEncryptedFile = false;
        this.raf = randomAccessFile;
        this.unzipEngine = unzipEngine;
        this.decrypter = unzipEngine.getDecrypter();
        this.length = j2;
        this.isAESEncryptedFile = unzipEngine.getFileHeader().isEncrypted() && unzipEngine.getFileHeader().getEncryptionMethod() == 99;
    }

    @Override // net.lingala.zip4j.io.BaseInputStream, java.io.InputStream
    public int available() {
        long j = this.length - this.bytesRead;
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    @Override // net.lingala.zip4j.io.BaseInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.bytesRead >= this.length) {
            return -1;
        }
        if (this.isAESEncryptedFile) {
            int i = this.aesBytesReturned;
            if (i == 0 || i == 16) {
                if (read(this.aesBlockByte) == -1) {
                    return -1;
                }
                this.aesBytesReturned = 0;
            }
            byte[] bArr = this.aesBlockByte;
            int i2 = this.aesBytesReturned;
            this.aesBytesReturned = i2 + 1;
            return bArr[i2] & 255;
        }
        if (read(this.oneByteBuff, 0, 1) == -1) {
            return -1;
        }
        return this.oneByteBuff[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = i2;
        long j2 = this.length;
        long j3 = this.bytesRead;
        if (j > j2 - j3 && (i2 = (int) (j2 - j3)) == 0) {
            checkAndReadAESMacBytes();
            return -1;
        }
        if ((this.unzipEngine.getDecrypter() instanceof AESDecrypter) && this.bytesRead + i2 < this.length && (i3 = i2 % 16) != 0) {
            i2 -= i3;
        }
        synchronized (this.raf) {
            int read = this.raf.read(bArr, i, i2);
            this.count = read;
            if (read < i2 && this.unzipEngine.getZipModel().isSplitArchive()) {
                this.raf.close();
                RandomAccessFile startNextSplitFile = this.unzipEngine.startNextSplitFile();
                this.raf = startNextSplitFile;
                if (this.count < 0) {
                    this.count = 0;
                }
                int i4 = this.count;
                int read2 = startNextSplitFile.read(bArr, i4, i2 - i4);
                if (read2 > 0) {
                    this.count += read2;
                }
            }
        }
        int i5 = this.count;
        if (i5 > 0) {
            IDecrypter iDecrypter = this.decrypter;
            if (iDecrypter != null) {
                try {
                    iDecrypter.decryptData(bArr, i, i5);
                } catch (ZipException e) {
                    throw new IOException(e.getMessage());
                }
            }
            this.bytesRead += this.count;
        }
        if (this.bytesRead >= this.length) {
            checkAndReadAESMacBytes();
        }
        return this.count;
    }

    protected void checkAndReadAESMacBytes() throws IOException {
        IDecrypter iDecrypter;
        if (this.isAESEncryptedFile && (iDecrypter = this.decrypter) != null && (iDecrypter instanceof AESDecrypter) && ((AESDecrypter) iDecrypter).getStoredMac() == null) {
            byte[] bArr = new byte[10];
            int read = this.raf.read(bArr);
            if (read != 10) {
                if (this.unzipEngine.getZipModel().isSplitArchive()) {
                    this.raf.close();
                    RandomAccessFile startNextSplitFile = this.unzipEngine.startNextSplitFile();
                    this.raf = startNextSplitFile;
                    startNextSplitFile.read(bArr, read, 10 - read);
                } else {
                    throw new IOException("Error occured while reading stored AES authentication bytes");
                }
            }
            ((AESDecrypter) this.unzipEngine.getDecrypter()).setStoredMac(bArr);
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        long j2 = this.length;
        long j3 = this.bytesRead;
        if (j > j2 - j3) {
            j = j2 - j3;
        }
        this.bytesRead = j3 + j;
        return j;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.raf.close();
    }

    @Override // net.lingala.zip4j.io.BaseInputStream
    public void seek(long j) throws IOException {
        this.raf.seek(j);
    }

    @Override // net.lingala.zip4j.io.BaseInputStream
    public UnzipEngine getUnzipEngine() {
        return this.unzipEngine;
    }
}
