package org.apache.xmlbeans.impl.piccolo.util;

/* loaded from: classes5.dex */
public final class LongStack {
    private int pos = -1;
    private long[] stack;

    public LongStack(int i) {
        this.stack = new long[i];
    }

    public long pop() {
        int i = this.pos;
        if (i >= 0) {
            long[] jArr = this.stack;
            this.pos = i - 1;
            return jArr[i];
        }
        throw new ArrayIndexOutOfBoundsException("stack underflow");
    }

    public void push(long j) {
        int i = this.pos;
        int i2 = i + 1;
        long[] jArr = this.stack;
        if (i2 < jArr.length) {
            int i3 = i + 1;
            this.pos = i3;
            jArr[i3] = j;
        } else {
            setSize(jArr.length * 2);
            long[] jArr2 = this.stack;
            int i4 = this.pos + 1;
            this.pos = i4;
            jArr2[i4] = j;
        }
    }

    public void setSize(int i) {
        long[] jArr = this.stack;
        if (i != jArr.length) {
            long[] jArr2 = new long[i];
            System.arraycopy(jArr, 0, jArr2, 0, Math.min(jArr.length, i));
            this.stack = jArr2;
        }
    }

    public void clear() {
        this.pos = -1;
    }

    public int size() {
        return this.pos + 1;
    }
}
