package org.apache.poi.hssf.record.crypto;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;
import org.apache.poi.EncryptedDocumentException;

/* loaded from: classes5.dex */
final class Biff8RC4 implements Biff8Cipher {
    private static final int RC4_REKEYING_INTERVAL = 1024;
    private ByteBuffer _buffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
    private int _currentKeyIndex;
    private final Biff8RC4Key _key;
    private int _nextRC4BlockStart;
    private Cipher _rc4;
    private boolean _shouldSkipEncryptionOnCurrentRecord;
    private int _streamPos;

    private static boolean isNeverEncryptedRecord(int i) {
        return i == 47 || i == 225 || i == 2057;
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8Cipher
    public void setNextRecordSize(int i) {
    }

    public Biff8RC4(int i, Biff8RC4Key biff8RC4Key) {
        if (i >= 1024) {
            throw new RuntimeException("initialOffset (" + i + ")>1024 not supported yet");
        }
        this._key = biff8RC4Key;
        this._rc4 = biff8RC4Key.getCipher();
        this._streamPos = 0;
        rekeyForNextBlock();
        this._streamPos = i;
        this._shouldSkipEncryptionOnCurrentRecord = false;
        encryptBytes(new byte[i], 0, i);
    }

    private void rekeyForNextBlock() {
        int i = this._streamPos / 1024;
        this._currentKeyIndex = i;
        this._key.initCipherForBlock(this._rc4, i);
        this._nextRC4BlockStart = (this._currentKeyIndex + 1) * 1024;
    }

    private void encryptBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        int i3;
        if (i2 == 0) {
            return;
        }
        if (this._shouldSkipEncryptionOnCurrentRecord) {
            byte[] bArr3 = new byte[i2];
            System.arraycopy(bArr, i, bArr3, 0, i2);
            bArr2 = bArr3;
            i3 = 0;
        } else {
            bArr2 = bArr;
            i3 = i;
        }
        try {
            this._rc4.update(bArr2, i3, i2, bArr2, i3);
        } catch (ShortBufferException e) {
            throw new EncryptedDocumentException("input buffer too small", e);
        }
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8Cipher
    public void startRecord(int i) {
        this._shouldSkipEncryptionOnCurrentRecord = isNeverEncryptedRecord(i);
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8Cipher
    public void skipTwoBytes() {
        xor(this._buffer.array(), 0, 2);
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8Cipher
    public void xor(byte[] bArr, int i, int i2) {
        int i3 = this._nextRC4BlockStart - this._streamPos;
        if (i2 <= i3) {
            encryptBytes(bArr, i, i2);
            this._streamPos += i2;
            return;
        }
        if (i2 > i3) {
            if (i3 > 0) {
                encryptBytes(bArr, i, i3);
                this._streamPos += i3;
                i += i3;
                i2 -= i3;
            }
            rekeyForNextBlock();
        }
        while (i2 > 1024) {
            encryptBytes(bArr, i, 1024);
            this._streamPos += 1024;
            i += 1024;
            i2 -= 1024;
            rekeyForNextBlock();
        }
        encryptBytes(bArr, i, i2);
        this._streamPos += i2;
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
