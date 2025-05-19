package org.apache.poi.hssf.record.crypto;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes5.dex */
public class Biff8XOR implements Biff8Cipher {
    private final int _initialOffset;
    private final Biff8XORKey _key;
    private boolean _shouldSkipEncryptionOnCurrentRecord;
    private ByteBuffer _buffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
    private int _dataLength = 0;
    private int _xorArrayIndex = 0;

    private static boolean isNeverEncryptedRecord(int i) {
        return i == 47 || i == 225 || i == 2057;
    }

    private static byte rotateLeft(byte b, int i) {
        int i2 = b & 255;
        return (byte) ((i2 >>> (8 - i)) | (i2 << i));
    }

    public Biff8XOR(int i, Biff8XORKey biff8XORKey) {
        this._key = biff8XORKey;
        this._initialOffset = i;
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8Cipher
    public void startRecord(int i) {
        this._shouldSkipEncryptionOnCurrentRecord = isNeverEncryptedRecord(i);
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8Cipher
    public void setNextRecordSize(int i) {
        this._xorArrayIndex = ((this._initialOffset + this._dataLength) + i) % 16;
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8Cipher
    public void skipTwoBytes() {
        this._dataLength += 2;
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8Cipher
    public void xor(byte[] bArr, int i, int i2) {
        if (this._shouldSkipEncryptionOnCurrentRecord) {
            this._dataLength += i2;
            return;
        }
        byte[] encoded = this._key._secretKey.getEncoded();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i + i3;
            byte rotateLeft = rotateLeft(bArr[i4], 3);
            int i5 = this._xorArrayIndex;
            bArr[i4] = (byte) (rotateLeft ^ encoded[i5]);
            this._xorArrayIndex = (i5 + 1) % 16;
            this._dataLength++;
        }
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8Cipher
    public int xorByte(int i) {
        this._buffer.put(0, (byte) i);
        xor(this._buffer.array(), 0, 1);
        return this._buffer.get(0);
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8Cipher
    public int xorShort(int i) {
        this._buffer.putShort(0, (short) i);
        xor(this._buffer.array(), 0, 2);
        return this._buffer.getShort(0);
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8Cipher
    public int xorInt(int i) {
        this._buffer.putInt(0, i);
        xor(this._buffer.array(), 0, 4);
        return this._buffer.getInt(0);
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8Cipher
    public long xorLong(long j) {
        this._buffer.putLong(0, j);
        xor(this._buffer.array(), 0, 8);
        return this._buffer.getLong(0);
    }
}
