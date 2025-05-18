package com.logan.upgrade.local.camera.ftp;

import com.logan.upgrade.local.camera.ftp.FTPUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class ProgressInputStream extends InputStream {
    private long TEN_KILOBYTES;
    private InputStream inputStream;
    private FTPUtils.UploadProgressListener listener;
    private long size;
    private long progress = 0;
    private long lastUpdate = 0;
    private boolean closed = false;

    public ProgressInputStream(InputStream inputStream, FTPUtils.UploadProgressListener uploadProgressListener, long j) {
        this.inputStream = inputStream;
        this.listener = uploadProgressListener;
        this.size = j;
        this.TEN_KILOBYTES = j / 100;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return incrementCounterAndUpdateDisplay(this.inputStream.read());
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return incrementCounterAndUpdateDisplay(this.inputStream.read(bArr, i, i2));
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.closed) {
            throw new IOException("already closed");
        }
        this.closed = true;
    }

    private int incrementCounterAndUpdateDisplay(int i) {
        if (i > 0) {
            this.progress += i;
        }
        this.lastUpdate = maybeUpdateDisplay(this.progress, this.lastUpdate);
        return i;
    }

    private long maybeUpdateDisplay(long j, long j2) {
        long j3 = j - j2;
        long j4 = this.TEN_KILOBYTES;
        if (j3 <= j4) {
            return j2;
        }
        this.listener.onUploadProgress(j / j4);
        return j;
    }
}