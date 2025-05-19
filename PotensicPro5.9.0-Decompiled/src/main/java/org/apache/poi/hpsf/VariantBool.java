package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

@Internal
/* loaded from: classes4.dex */
class VariantBool {
    static final int SIZE = 2;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) VariantBool.class);
    private boolean _value;

    VariantBool(byte[] bArr, int i) {
        short s = LittleEndian.getShort(bArr, i);
        if (s == 0) {
            this._value = false;
        } else if (s == 65535) {
            this._value = true;
        } else {
            logger.log(5, "VARIANT_BOOL value '", Short.valueOf(s), "' is incorrect");
            this._value = s != 0;
        }
    }

    boolean getValue() {
        return this._value;
    }

    void setValue(boolean z) {
        this._value = z;
    }
}
