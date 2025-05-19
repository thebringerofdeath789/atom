package org.apache.xmlbeans.impl.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public abstract class PushedInputStream extends InputStream {
    private static int defaultBufferSize = 2048;
    protected byte[] buf;
    protected int marklimit;
    protected int markpos;
    protected OutputStream outputStream;
    protected int readpos;
    protected int writepos;

    protected abstract void fill(int i) throws IOException;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public final OutputStream getOutputStream() {
        return this.outputStream;
    }

    public PushedInputStream() {
        this(defaultBufferSize);
    }

    public PushedInputStream(int i) {
        this.markpos = -1;
        this.outputStream = new InternalOutputStream();
        if (i < 0) {
            throw new IllegalArgumentException("Negative initial buffer size");
        }
        this.buf = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void shift(int r6) {
        /*
            r5 = this;
            int r0 = r5.readpos
            int r1 = r5.markpos
            if (r1 <= 0) goto L11
            int r2 = r0 - r1
            int r3 = r5.marklimit
            if (r2 <= r3) goto L10
            r1 = -1
            r5.markpos = r1
            goto L11
        L10:
            r0 = r1
        L11:
            int r1 = r5.writepos
            int r1 = r1 - r0
            r2 = 0
            if (r0 <= 0) goto L23
            byte[] r3 = r5.buf
            int r4 = r3.length
            int r4 = r4 - r1
            if (r4 < r6) goto L23
            if (r1 > r6) goto L23
            java.lang.System.arraycopy(r3, r0, r3, r2, r1)
            goto L36
        L23:
            int r6 = r6 + r1
            byte[] r3 = r5.buf
            int r3 = r3.length
            int r3 = r3 << 1
            int r6 = java.lang.Math.max(r3, r6)
            byte[] r6 = new byte[r6]
            byte[] r3 = r5.buf
            java.lang.System.arraycopy(r3, r0, r6, r2, r1)
            r5.buf = r6
        L36:
            if (r0 <= 0) goto L49
            int r6 = r5.readpos
            int r6 = r6 - r0
            r5.readpos = r6
            int r6 = r5.markpos
            if (r6 <= 0) goto L44
            int r6 = r6 - r0
            r5.markpos = r6
        L44:
            int r6 = r5.writepos
            int r6 = r6 - r0
            r5.writepos = r6
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.common.PushedInputStream.shift(int):void");
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.readpos >= this.writepos) {
            fill(1);
            if (this.readpos >= this.writepos) {
                return -1;
            }
        }
        byte[] bArr = this.buf;
        int i = this.readpos;
        this.readpos = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.writepos - this.readpos;
        if (i3 < i2) {
            fill(i2 - i3);
            i3 = this.writepos - this.readpos;
            if (i3 <= 0) {
                return -1;
            }
        }
        if (i3 < i2) {
            i2 = i3;
        }
        System.arraycopy(this.buf, this.readpos, bArr, i, i2);
        this.readpos += i2;
        return i2;
    }

    @Override // java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        long j2 = this.writepos - this.readpos;
        if (j2 < j) {
            long j3 = j - j2;
            if (j3 > 2147483647L) {
                j3 = 2147483647L;
            }
            fill((int) j3);
            j2 = this.writepos - this.readpos;
            if (j2 <= 0) {
                return 0L;
            }
        }
        if (j2 < j) {
            j = j2;
        }
        this.readpos = (int) (this.readpos + j);
        return j;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return this.writepos - this.readpos;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.marklimit = i;
        this.markpos = this.readpos;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        int i = this.markpos;
        if (i < 0) {
            throw new IOException("Resetting to invalid mark");
        }
        this.readpos = i;
    }

    private class InternalOutputStream extends OutputStream {
        private InternalOutputStream() {
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) throws IOException {
            if (PushedInputStream.this.writepos + 1 > PushedInputStream.this.buf.length) {
                PushedInputStream.this.shift(1);
            }
            PushedInputStream.this.buf[PushedInputStream.this.writepos] = (byte) i;
            PushedInputStream.this.writepos++;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) {
            int i3;
            if (i >= 0) {
                if (i <= bArr.length && i2 >= 0 && (i3 = i + i2) <= bArr.length && i3 >= 0) {
                    if (i2 == 0) {
                        return;
                    }
                    if (PushedInputStream.this.writepos + i2 > PushedInputStream.this.buf.length) {
                        PushedInputStream.this.shift(i2);
                    }
                    System.arraycopy(bArr, i, PushedInputStream.this.buf, PushedInputStream.this.writepos, i2);
                    PushedInputStream.this.writepos += i2;
                    return;
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
