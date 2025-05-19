package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

@Internal
/* loaded from: classes4.dex */
class Decimal {
    static final int SIZE = 16;
    private short field_1_wReserved;
    private byte field_2_scale;
    private byte field_3_sign;
    private int field_4_hi32;
    private long field_5_lo64;

    Decimal(byte[] bArr, int i) {
        this.field_1_wReserved = LittleEndian.getShort(bArr, i);
        int i2 = i + 2;
        this.field_2_scale = bArr[i2];
        int i3 = i2 + 1;
        this.field_3_sign = bArr[i3];
        int i4 = i3 + 1;
        this.field_4_hi32 = LittleEndian.getInt(bArr, i4);
        this.field_5_lo64 = LittleEndian.getLong(bArr, i4 + 4);
    }
}
