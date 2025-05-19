package net.lingala.zip4j.io;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.exception.ZipException;

/* loaded from: classes4.dex */
public class ZipInputStream extends InputStream {
    private BaseInputStream is;

    public ZipInputStream(BaseInputStream baseInputStream) {
        this.is = baseInputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read = this.is.read();
        if (read != -1) {
            this.is.getUnzipEngine().updateCRC(read);
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.is.read(bArr, i, i2);
        if (read > 0 && this.is.getUnzipEngine() != null) {
            this.is.getUnzipEngine().updateCRC(bArr, i, read);
        }
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(false);
    }

    public void close(boolean z) throws IOException {
        try {
            this.is.close();
            if (z || this.is.getUnzipEngine() == null) {
                return;
            }
            this.is.getUnzipEngine().checkCRC();
        } catch (ZipException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.is.available();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.is.skip(j);
    }
}
