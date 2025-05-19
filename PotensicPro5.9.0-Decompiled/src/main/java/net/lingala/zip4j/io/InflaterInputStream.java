package net.lingala.zip4j.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import net.lingala.zip4j.unzip.UnzipEngine;

/* loaded from: classes4.dex */
public class InflaterInputStream extends PartInputStream {
    private byte[] buff;
    private long bytesWritten;
    private Inflater inflater;
    private byte[] oneByteBuff;
    private long uncompressedSize;
    private UnzipEngine unzipEngine;

    public InflaterInputStream(RandomAccessFile randomAccessFile, long j, long j2, UnzipEngine unzipEngine) {
        super(randomAccessFile, j, j2, unzipEngine);
        this.oneByteBuff = new byte[1];
        this.inflater = new Inflater(true);
        this.buff = new byte[4096];
        this.unzipEngine = unzipEngine;
        this.bytesWritten = 0L;
        this.uncompressedSize = unzipEngine.getFileHeader().getUncompressedSize();
    }

    @Override // net.lingala.zip4j.io.PartInputStream, net.lingala.zip4j.io.BaseInputStream, java.io.InputStream
    public int read() throws IOException {
        if (read(this.oneByteBuff, 0, 1) == -1) {
            return -1;
        }
        return this.oneByteBuff[0] & 255;
    }

    @Override // net.lingala.zip4j.io.PartInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        Objects.requireNonNull(bArr, "input buffer is null");
        return read(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.io.PartInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Objects.requireNonNull(bArr, "input buffer is null");
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        try {
            if (this.bytesWritten >= this.uncompressedSize) {
                finishInflating();
                return -1;
            }
            while (true) {
                int inflate = this.inflater.inflate(bArr, i, i2);
                if (inflate == 0) {
                    if (this.inflater.finished() || this.inflater.needsDictionary()) {
                        break;
                    }
                    if (this.inflater.needsInput()) {
                        fill();
                    }
                } else {
                    this.bytesWritten += inflate;
                    return inflate;
                }
            }
            finishInflating();
            return -1;
        } catch (DataFormatException e) {
            String message = e.getMessage() != null ? e.getMessage() : "Invalid ZLIB data format";
            UnzipEngine unzipEngine = this.unzipEngine;
            if (unzipEngine != null && unzipEngine.getLocalFileHeader().isEncrypted() && this.unzipEngine.getLocalFileHeader().getEncryptionMethod() == 0) {
                message = message + " - Wrong Password?";
            }
            throw new IOException(message);
        }
    }

    private void finishInflating() throws IOException {
        while (super.read(new byte[1024], 0, 1024) != -1) {
        }
        checkAndReadAESMacBytes();
    }

    private void fill() throws IOException {
        byte[] bArr = this.buff;
        int read = super.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException("Unexpected end of ZLIB input stream");
        }
        this.inflater.setInput(this.buff, 0, read);
    }

    @Override // net.lingala.zip4j.io.PartInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("negative skip length");
        }
        int min = (int) Math.min(j, 2147483647L);
        byte[] bArr = new byte[512];
        int i = 0;
        while (i < min) {
            int i2 = min - i;
            if (i2 > 512) {
                i2 = 512;
            }
            int read = read(bArr, 0, i2);
            if (read == -1) {
                break;
            }
            i += read;
        }
        return i;
    }

    @Override // net.lingala.zip4j.io.PartInputStream, net.lingala.zip4j.io.BaseInputStream
    public void seek(long j) throws IOException {
        super.seek(j);
    }

    @Override // net.lingala.zip4j.io.PartInputStream, net.lingala.zip4j.io.BaseInputStream, java.io.InputStream
    public int available() {
        return !this.inflater.finished() ? 1 : 0;
    }

    @Override // net.lingala.zip4j.io.PartInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflater.end();
        super.close();
    }

    @Override // net.lingala.zip4j.io.PartInputStream, net.lingala.zip4j.io.BaseInputStream
    public UnzipEngine getUnzipEngine() {
        return super.getUnzipEngine();
    }
}
