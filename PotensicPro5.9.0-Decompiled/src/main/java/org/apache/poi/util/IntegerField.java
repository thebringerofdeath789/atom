package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes5.dex */
public class IntegerField implements FixedField {
    private final int _offset;
    private int _value;

    public IntegerField(int i) throws ArrayIndexOutOfBoundsException {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("negative offset");
        }
        this._offset = i;
    }

    public IntegerField(int i, int i2) throws ArrayIndexOutOfBoundsException {
        this(i);
        set(i2);
    }

    public IntegerField(int i, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this(i);
        readFromBytes(bArr);
    }

    public IntegerField(int i, int i2, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this(i);
        set(i2, bArr);
    }

    public int get() {
        return this._value;
    }

    public void set(int i) {
        this._value = i;
    }

    public void set(int i, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this._value = i;
        writeToBytes(bArr);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromBytes(byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this._value = LittleEndian.getInt(bArr, this._offset);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromStream(InputStream inputStream) throws IOException, LittleEndian.BufferUnderrunException {
        this._value = LittleEndian.readInt(inputStream);
    }

    @Override // org.apache.poi.util.FixedField
    public void writeToBytes(byte[] bArr) throws ArrayIndexOutOfBoundsException {
        LittleEndian.putInt(bArr, this._offset, this._value);
    }

    @Override // org.apache.poi.util.FixedField
    public String toString() {
        return String.valueOf(this._value);
    }
}
