package org.apache.poi.util;

/* loaded from: classes5.dex */
public final class LittleEndianByteArrayInputStream implements LittleEndianInput {
    private final byte[] _buf;
    private final int _endIndex;
    private int _readIndex;

    public LittleEndianByteArrayInputStream(byte[] bArr, int i, int i2) {
        this._buf = bArr;
        this._readIndex = i;
        this._endIndex = i + i2;
    }

    public LittleEndianByteArrayInputStream(byte[] bArr, int i) {
        this(bArr, i, bArr.length - i);
    }

    public LittleEndianByteArrayInputStream(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int available() {
        return this._endIndex - this._readIndex;
    }

    private void checkPosition(int i) {
        if (i > this._endIndex - this._readIndex) {
            throw new RuntimeException("Buffer overrun");
        }
    }

    public int getReadIndex() {
        return this._readIndex;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        checkPosition(1);
        byte[] bArr = this._buf;
        int i = this._readIndex;
        this._readIndex = i + 1;
        return bArr[i];
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkPosition(4);
        int i = this._readIndex;
        byte[] bArr = this._buf;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        int i4 = i2 + 1;
        int i5 = bArr[i2] & 255;
        int i6 = i4 + 1;
        int i7 = bArr[i4] & 255;
        int i8 = bArr[i6] & 255;
        this._readIndex = i6 + 1;
        return (i8 << 24) + (i7 << 16) + (i5 << 8) + (i3 << 0);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        checkPosition(8);
        int i = this._readIndex;
        byte[] bArr = this._buf;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        int i4 = i2 + 1;
        int i5 = bArr[i2] & 255;
        int i6 = i4 + 1;
        int i7 = bArr[i4] & 255;
        int i8 = i6 + 1;
        int i9 = bArr[i6] & 255;
        int i10 = i8 + 1;
        int i11 = bArr[i8] & 255;
        int i12 = i10 + 1;
        int i13 = bArr[i10] & 255;
        int i14 = i12 + 1;
        int i15 = bArr[i12] & 255;
        int i16 = bArr[i14] & 255;
        this._readIndex = i14 + 1;
        return (i16 << 56) + (i15 << 48) + (i13 << 40) + (i11 << 32) + (i9 << 24) + (i7 << 16) + (i5 << 8) + (i3 << 0);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        return (short) readUShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        checkPosition(1);
        byte[] bArr = this._buf;
        int i = this._readIndex;
        this._readIndex = i + 1;
        return bArr[i] & 255;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        checkPosition(2);
        int i = this._readIndex;
        byte[] bArr = this._buf;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        int i4 = bArr[i2] & 255;
        this._readIndex = i2 + 1;
        return (i4 << 8) + (i3 << 0);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) {
        checkPosition(i2);
        System.arraycopy(this._buf, this._readIndex, bArr, i, i2);
        this._readIndex += i2;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }
}
