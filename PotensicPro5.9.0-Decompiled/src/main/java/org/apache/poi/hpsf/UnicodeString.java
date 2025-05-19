package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.StringUtil;

@Internal
/* loaded from: classes4.dex */
class UnicodeString {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) UnicodeString.class);
    private byte[] _value;

    UnicodeString(byte[] bArr, int i) {
        boolean z;
        int i2 = LittleEndian.getInt(bArr, i);
        int i3 = i + 4;
        if (!validLength(i2, bArr, i3)) {
            int i4 = i % 4;
            if (i4 != 0) {
                i += i4;
                i2 = LittleEndian.getInt(bArr, i);
                i3 = i + 4;
                z = validLength(i2, bArr, i3);
            } else {
                z = false;
            }
            if (!z) {
                throw new IllegalPropertySetDataException("UnicodeString started at offset #" + i + " is not NULL-terminated");
            }
        }
        if (i2 == 0) {
            this._value = new byte[0];
        } else {
            this._value = LittleEndian.getByteArray(bArr, i3, i2 * 2);
        }
    }

    boolean validLength(int i, byte[] bArr, int i2) {
        if (i == 0) {
            return true;
        }
        int i3 = i2 + (i * 2);
        return i3 <= bArr.length && bArr[i3 + (-1)] == 0 && bArr[i3 + (-2)] == 0;
    }

    int getSize() {
        return this._value.length + 4;
    }

    byte[] getValue() {
        return this._value;
    }

    String toJavaString() {
        byte[] bArr = this._value;
        if (bArr.length == 0) {
            return null;
        }
        String fromUnicodeLE = StringUtil.getFromUnicodeLE(bArr, 0, bArr.length >> 1);
        int indexOf = fromUnicodeLE.indexOf(0);
        if (indexOf == -1) {
            logger.log(5, "String terminator (\\0) for UnicodeString property value not found.Continue without trimming and hope for the best.");
            return fromUnicodeLE;
        }
        if (indexOf != fromUnicodeLE.length() - 1) {
            logger.log(5, "String terminator (\\0) for UnicodeString property value occured before the end of string. Trimming and hope for the best.");
        }
        return fromUnicodeLE.substring(0, indexOf);
    }
}
