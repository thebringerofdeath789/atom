package org.apache.poi.poifs.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class ByteArrayBackedDataSource extends DataSource {
    private byte[] buffer;
    private long size;

    public ByteArrayBackedDataSource(byte[] bArr, int i) {
        this.buffer = bArr;
        this.size = i;
    }

    public ByteArrayBackedDataSource(byte[] bArr) {
        this(bArr, bArr.length);
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public ByteBuffer read(int i, long j) {
        long j2 = this.size;
        if (j >= j2) {
            throw new IndexOutOfBoundsException("Unable to read " + i + " bytes from " + j + " in stream of length " + this.size);
        }
        return ByteBuffer.wrap(this.buffer, (int) j, (int) Math.min(i, j2 - j));
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void write(ByteBuffer byteBuffer, long j) {
        long capacity = byteBuffer.capacity() + j;
        if (capacity > this.buffer.length) {
            extend(capacity);
        }
        byteBuffer.get(this.buffer, (int) j, byteBuffer.capacity());
        if (capacity > this.size) {
            this.size = capacity;
        }
    }

    private void extend(long j) {
        byte[] bArr = this.buffer;
        long length = j - bArr.length;
        if (length < bArr.length * 0.25d) {
            length = (long) (bArr.length * 0.25d);
        }
        if (length < 4096) {
            length = 4096;
        }
        byte[] bArr2 = new byte[(int) (length + bArr.length)];
        System.arraycopy(bArr, 0, bArr2, 0, (int) this.size);
        this.buffer = bArr2;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void copyTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.buffer, 0, (int) this.size);
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public long size() {
        return this.size;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void close() {
        this.buffer = null;
        this.size = -1L;
    }
}
