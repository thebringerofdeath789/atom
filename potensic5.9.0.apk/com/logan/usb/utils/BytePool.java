package com.logan.usb.utils;

/* loaded from: classes3.dex */
public class BytePool {
    public byte[] data;
    private int writeIndex = -1;

    public BytePool(int i) {
        this.data = null;
        this.data = new byte[i];
    }

    public synchronized void add(byte[] bArr, int i) {
        System.arraycopy(bArr, 0, this.data, this.writeIndex + 1, i);
        this.writeIndex += i;
    }

    public int getWriteIndex() {
        return this.writeIndex;
    }

    public synchronized void discardIndex(int i) {
        byte[] bArr = this.data;
        System.arraycopy(bArr, i + 1, bArr, 0, this.writeIndex - i);
        this.writeIndex = (this.writeIndex - i) - 1;
    }

    public synchronized byte[] getData() {
        byte[] bArr;
        bArr = new byte[getLength()];
        System.arraycopy(this.data, 0, bArr, 0, getLength());
        return bArr;
    }

    public void clear() {
        this.writeIndex = -1;
    }

    public int getLength() {
        return this.writeIndex + 1;
    }
}