package com.ipotensic.baselib.utils;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class DataBuffer {
    private ByteBuffer buffer;
    private int size;

    public DataBuffer(int i) {
        this.size = i;
        this.buffer = ByteBuffer.allocate(i);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.buffer.put(bArr, i, i2);
    }

    public void write(byte[] bArr) {
        this.buffer.put(bArr);
    }

    public void clear() {
        this.buffer.clear();
    }

    public int getPosition() {
        return this.buffer.position();
    }

    public int size() {
        return this.size;
    }

    public byte[] readAll() {
        int position = this.buffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(this.buffer.array(), 0, bArr, 0, position);
        return bArr;
    }

    public void discard(int i) {
        byte[] readAll = readAll();
        this.buffer.clear();
        int length = (readAll.length - i) - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(readAll, i + 1, bArr, 0, length);
        this.buffer.put(bArr);
    }
}
