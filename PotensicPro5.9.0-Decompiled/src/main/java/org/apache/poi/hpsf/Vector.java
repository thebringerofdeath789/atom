package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

@Internal
/* loaded from: classes4.dex */
class Vector {
    private final short _type;
    private TypedPropertyValue[] _values;

    Vector(byte[] bArr, int i, short s) {
        this._type = s;
        read(bArr, i);
    }

    Vector(short s) {
        this._type = s;
    }

    int read(byte[] bArr, int i) {
        long uInt = LittleEndian.getUInt(bArr, i);
        int i2 = i + 4;
        if (uInt > 2147483647L) {
            throw new UnsupportedOperationException("Vector is too long -- " + uInt);
        }
        int i3 = (int) uInt;
        this._values = new TypedPropertyValue[i3];
        int i4 = 0;
        if (this._type == 12) {
            while (i4 < i3) {
                TypedPropertyValue typedPropertyValue = new TypedPropertyValue();
                i2 += typedPropertyValue.read(bArr, i2);
                this._values[i4] = typedPropertyValue;
                i4++;
            }
        } else {
            while (i4 < i3) {
                TypedPropertyValue typedPropertyValue2 = new TypedPropertyValue(this._type, (Object) null);
                i2 += typedPropertyValue2.readValue(bArr, i2);
                this._values[i4] = typedPropertyValue2;
                i4++;
            }
        }
        return i2 - i;
    }

    TypedPropertyValue[] getValues() {
        return this._values;
    }
}
