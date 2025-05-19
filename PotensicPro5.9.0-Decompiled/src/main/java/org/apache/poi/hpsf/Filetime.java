package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes4.dex */
class Filetime {
    static final int SIZE = 8;
    private int _dwHighDateTime;
    private int _dwLowDateTime;

    Filetime(byte[] bArr, int i) {
        this._dwLowDateTime = LittleEndian.getInt(bArr, i + 0);
        this._dwHighDateTime = LittleEndian.getInt(bArr, i + 4);
    }

    Filetime(int i, int i2) {
        this._dwLowDateTime = i;
        this._dwHighDateTime = i2;
    }

    long getHigh() {
        return this._dwHighDateTime;
    }

    long getLow() {
        return this._dwLowDateTime;
    }

    byte[] toByteArray() {
        byte[] bArr = new byte[8];
        LittleEndian.putInt(bArr, 0, this._dwLowDateTime);
        LittleEndian.putInt(bArr, 4, this._dwHighDateTime);
        return bArr;
    }

    int write(OutputStream outputStream) throws IOException {
        LittleEndian.putInt(this._dwLowDateTime, outputStream);
        LittleEndian.putInt(this._dwHighDateTime, outputStream);
        return 8;
    }
}
