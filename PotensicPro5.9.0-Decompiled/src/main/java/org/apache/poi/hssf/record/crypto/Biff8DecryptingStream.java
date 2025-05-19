package org.apache.poi.hssf.record.crypto;

import java.io.InputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.BiffHeaderInput;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianInputStream;

/* loaded from: classes5.dex */
public final class Biff8DecryptingStream implements BiffHeaderInput, LittleEndianInput {
    private final Biff8Cipher _cipher;
    private final LittleEndianInput _le;

    /* JADX WARN: Multi-variable type inference failed */
    public Biff8DecryptingStream(InputStream inputStream, int i, Biff8EncryptionKey biff8EncryptionKey) {
        if (biff8EncryptionKey instanceof Biff8RC4Key) {
            this._cipher = new Biff8RC4(i, (Biff8RC4Key) biff8EncryptionKey);
        } else if (biff8EncryptionKey instanceof Biff8XORKey) {
            this._cipher = new Biff8XOR(i, (Biff8XORKey) biff8EncryptionKey);
        } else {
            throw new EncryptedDocumentException("Crypto API not supported yet.");
        }
        if (inputStream instanceof LittleEndianInput) {
            this._le = (LittleEndianInput) inputStream;
        } else {
            this._le = new LittleEndianInputStream(inputStream);
        }
    }

    @Override // org.apache.poi.hssf.record.BiffHeaderInput
    public int available() {
        return this._le.available();
    }

    @Override // org.apache.poi.hssf.record.BiffHeaderInput
    public int readRecordSID() {
        int readUShort = this._le.readUShort();
        this._cipher.skipTwoBytes();
        this._cipher.startRecord(readUShort);
        return readUShort;
    }

    @Override // org.apache.poi.hssf.record.BiffHeaderInput
    public int readDataSize() {
        int readUShort = this._le.readUShort();
        this._cipher.skipTwoBytes();
        this._cipher.setNextRecordSize(readUShort);
        return readUShort;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        double longBitsToDouble = Double.longBitsToDouble(readLong());
        if (Double.isNaN(longBitsToDouble)) {
            throw new RuntimeException("Did not expect to read NaN");
        }
        return longBitsToDouble;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i, int i2) {
        this._le.readFully(bArr, i, i2);
        this._cipher.xor(bArr, i, i2);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return this._cipher.xorByte(this._le.readUByte());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        return (byte) this._cipher.xorByte(this._le.readUByte());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        return this._cipher.xorShort(this._le.readUShort());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        return (short) this._cipher.xorShort(this._le.readUShort());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        return this._cipher.xorInt(this._le.readInt());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        return this._cipher.xorLong(this._le.readLong());
    }
}
