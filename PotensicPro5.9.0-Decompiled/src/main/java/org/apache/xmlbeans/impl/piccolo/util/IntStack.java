package org.apache.xmlbeans.impl.piccolo.util;

/* loaded from: classes5.dex */
public final class IntStack {
    private int pos = -1;
    private int[] stack;

    public IntStack(int i) {
        this.stack = new int[i];
    }

    public int pop() {
        int i = this.pos;
        if (i >= 0) {
            int[] iArr = this.stack;
            this.pos = i - 1;
            return iArr[i];
        }
        throw new ArrayIndexOutOfBoundsException("stack underflow");
    }

    public void push(int i) {
        int i2 = this.pos;
        int i3 = i2 + 1;
        int[] iArr = this.stack;
        if (i3 < iArr.length) {
            int i4 = i2 + 1;
            this.pos = i4;
            iArr[i4] = i;
        } else {
            setSize(iArr.length * 2);
            int[] iArr2 = this.stack;
            int i5 = this.pos + 1;
            this.pos = i5;
            iArr2[i5] = i;
        }
    }

    public void setSize(int i) {
        int[] iArr = this.stack;
        if (i != iArr.length) {
            int[] iArr2 = new int[i];
            System.arraycopy(iArr, 0, iArr2, 0, Math.min(iArr.length, i));
            this.stack = iArr2;
        }
    }

    public void clear() {
        this.pos = -1;
    }

    public int size() {
        return this.pos + 1;
    }
}
