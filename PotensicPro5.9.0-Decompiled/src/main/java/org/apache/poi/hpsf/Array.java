package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

@Internal
/* loaded from: classes4.dex */
class Array {
    private ArrayHeader _header;
    private TypedPropertyValue[] _values;

    static class ArrayDimension {
        static final int SIZE = 8;
        private int _indexOffset;
        private long _size;

        ArrayDimension(byte[] bArr, int i) {
            this._size = LittleEndian.getUInt(bArr, i);
            this._indexOffset = LittleEndian.getInt(bArr, i + 4);
        }
    }

    static class ArrayHeader {
        private ArrayDimension[] _dimensions;
        private int _type;

        ArrayHeader(byte[] bArr, int i) {
            this._type = LittleEndian.getInt(bArr, i);
            int i2 = i + 4;
            long uInt = LittleEndian.getUInt(bArr, i2);
            int i3 = i2 + 4;
            if (1 > uInt || uInt > 31) {
                throw new IllegalPropertySetDataException("Array dimension number " + uInt + " is not in [1; 31] range");
            }
            int i4 = (int) uInt;
            this._dimensions = new ArrayDimension[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                this._dimensions[i5] = new ArrayDimension(bArr, i3);
                i3 += 8;
            }
        }

        long getNumberOfScalarValues() {
            long j = 1;
            for (ArrayDimension arrayDimension : this._dimensions) {
                j *= arrayDimension._size;
            }
            return j;
        }

        int getSize() {
            return (this._dimensions.length * 8) + 8;
        }

        int getType() {
            return this._type;
        }
    }

    Array() {
    }

    Array(byte[] bArr, int i) {
        read(bArr, i);
    }

    int read(byte[] bArr, int i) {
        ArrayHeader arrayHeader = new ArrayHeader(bArr, i);
        this._header = arrayHeader;
        int size = arrayHeader.getSize() + i;
        long numberOfScalarValues = this._header.getNumberOfScalarValues();
        if (numberOfScalarValues > 2147483647L) {
            throw new UnsupportedOperationException("Sorry, but POI can't store array of properties with size of " + numberOfScalarValues + " in memory");
        }
        int i2 = (int) numberOfScalarValues;
        this._values = new TypedPropertyValue[i2];
        int i3 = this._header._type;
        int i4 = 0;
        if (i3 == 12) {
            while (i4 < i2) {
                size += new TypedPropertyValue().read(bArr, size);
                i4++;
            }
        } else {
            while (i4 < i2) {
                size += new TypedPropertyValue(i3, (Object) null).readValuePadded(bArr, size);
                i4++;
            }
        }
        return size - i;
    }
}
