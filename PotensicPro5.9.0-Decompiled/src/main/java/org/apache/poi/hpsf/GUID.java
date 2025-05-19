package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

@Internal
/* loaded from: classes4.dex */
class GUID {
    static final int SIZE = 16;
    private int _data1;
    private short _data2;
    private short _data3;
    private long _data4;

    GUID(byte[] bArr, int i) {
        this._data1 = LittleEndian.getInt(bArr, i + 0);
        this._data2 = LittleEndian.getShort(bArr, i + 4);
        this._data3 = LittleEndian.getShort(bArr, i + 6);
        this._data4 = LittleEndian.getLong(bArr, i + 8);
    }
}
