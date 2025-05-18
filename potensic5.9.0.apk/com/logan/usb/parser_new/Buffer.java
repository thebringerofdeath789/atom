package com.logan.usb.parser_new;

/* loaded from: classes3.dex */
public class Buffer {
    private byte[] data;
    private int size;
    private int writeIndex = -1;

    public Buffer(int i) {
        this.data = null;
        this.size = i;
        this.data = new byte[i];
    }

    public int getWriteIndex() {
        return this.writeIndex;
    }

    public byte[] getData() {
        return this.data;
    }

    public void write(byte[] bArr, int i) {
        if (this.writeIndex + i > this.size) {
            this.writeIndex = -1;
        }
        System.arraycopy(bArr, 0, this.data, this.writeIndex + 1, i);
        this.writeIndex += i;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (this.writeIndex + i2 > this.size) {
            this.writeIndex = -1;
        }
        System.arraycopy(bArr, i, this.data, this.writeIndex + 1, i2);
        this.writeIndex += i2;
    }

    public void discard(int i) {
        int i2 = this.writeIndex;
        if (i2 == i) {
            this.writeIndex = -1;
            return;
        }
        byte[] bArr = this.data;
        System.arraycopy(bArr, i + 1, bArr, 0, i2 - i);
        this.writeIndex = (this.writeIndex - i) - 1;
    }

    public void reset() {
        this.writeIndex = -1;
    }
}