package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

@Internal
/* loaded from: classes4.dex */
class Blob {
    private byte[] _value;

    Blob(byte[] bArr, int i) {
        int i2 = LittleEndian.getInt(bArr, i);
        if (i2 == 0) {
            this._value = new byte[0];
        } else {
            this._value = LittleEndian.getByteArray(bArr, i + 4, i2);
        }
    }

    int getSize() {
        return this._value.length + 4;
    }
}
