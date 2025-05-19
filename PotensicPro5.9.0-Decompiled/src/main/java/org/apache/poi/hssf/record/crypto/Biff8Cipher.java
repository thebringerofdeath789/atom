package org.apache.poi.hssf.record.crypto;

/* loaded from: classes5.dex */
public interface Biff8Cipher {
    void setNextRecordSize(int i);

    void skipTwoBytes();

    void startRecord(int i);

    void xor(byte[] bArr, int i, int i2);

    int xorByte(int i);

    int xorInt(int i);

    long xorLong(long j);

    int xorShort(int i);
}
