package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

@Internal
/* loaded from: classes4.dex */
class Currency {
    static final int SIZE = 8;
    private byte[] _value;

    Currency(byte[] bArr, int i) {
        this._value = LittleEndian.getByteArray(bArr, i, 8);
    }
}
