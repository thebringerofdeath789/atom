package org.apache.poi.poifs.storage;

/* loaded from: classes5.dex */
public final class DataInputBlock {
    private final byte[] _buf;
    private int _maxIndex;
    private int _readIndex;

    DataInputBlock(byte[] bArr, int i) {
        this._buf = bArr;
        this._readIndex = i;
        this._maxIndex = bArr.length;
    }

    public int available() {
        return this._maxIndex - this._readIndex;
    }

    public int readUByte() {
        byte[] bArr = this._buf;
        int i = this._readIndex;
        this._readIndex = i + 1;
        return bArr[i] & 255;
    }

    public int readUShortLE() {
        int i = this._readIndex;
        byte[] bArr = this._buf;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        int i4 = bArr[i2] & 255;
        this._readIndex = i2 + 1;
        return (i4 << 8) + (i3 << 0);
    }

    public int readUShortLE(DataInputBlock dataInputBlock) {
        int i = dataInputBlock._buf[r4.length - 1] & 255;
        byte[] bArr = this._buf;
        int i2 = this._readIndex;
        this._readIndex = i2 + 1;
        return ((bArr[i2] & 255) << 8) + (i << 0);
    }

    public int readIntLE() {
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

    public int readIntLE(DataInputBlock dataInputBlock, int i) {
        byte[] bArr = new byte[4];
        readSpanning(dataInputBlock, i, bArr);
        int i2 = bArr[0] & 255;
        int i3 = bArr[1] & 255;
        return ((bArr[3] & 255) << 24) + ((bArr[2] & 255) << 16) + (i3 << 8) + (i2 << 0);
    }

    public long readLongLE() {
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

    public long readLongLE(DataInputBlock dataInputBlock, int i) {
        byte[] bArr = new byte[8];
        readSpanning(dataInputBlock, i, bArr);
        int i2 = bArr[0] & 255;
        int i3 = bArr[1] & 255;
        int i4 = bArr[2] & 255;
        int i5 = bArr[3] & 255;
        int i6 = bArr[4] & 255;
        return ((bArr[7] & 255) << 56) + ((bArr[6] & 255) << 48) + ((bArr[5] & 255) << 40) + (i6 << 32) + (i5 << 24) + (i4 << 16) + (i3 << 8) + (i2 << 0);
    }

    private void readSpanning(DataInputBlock dataInputBlock, int i, byte[] bArr) {
        System.arraycopy(dataInputBlock._buf, dataInputBlock._readIndex, bArr, 0, i);
        int length = bArr.length - i;
        System.arraycopy(this._buf, 0, bArr, i, length);
        this._readIndex = length;
    }

    public void readFully(byte[] bArr, int i, int i2) {
        System.arraycopy(this._buf, this._readIndex, bArr, i, i2);
        this._readIndex += i2;
    }
}
