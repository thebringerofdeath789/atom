package org.apache.poi.hpsf;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;

/* loaded from: classes4.dex */
public class Property {
    protected long id;
    protected long type;
    protected Object value;

    private boolean typesAreEqual(long j, long j2) {
        if (j == j2) {
            return true;
        }
        if (j == 30 && j2 == 31) {
            return true;
        }
        return j2 == 30 && j == 31;
    }

    public long getID() {
        return this.id;
    }

    public long getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public Property(long j, long j2, Object obj) {
        this.id = j;
        this.type = j2;
        this.value = obj;
    }

    public Property(long j, byte[] bArr, long j2, int i, int i2) throws UnsupportedEncodingException {
        this.id = j;
        if (j == 0) {
            this.value = readDictionary(bArr, j2, i, i2);
            return;
        }
        int i3 = (int) j2;
        this.type = LittleEndian.getUInt(bArr, i3);
        try {
            this.value = VariantSupport.read(bArr, i3 + 4, i, (int) r10, i2);
        } catch (UnsupportedVariantTypeException e) {
            VariantSupport.writeUnsupportedTypeMessage(e);
            this.value = e.getValue();
        }
    }

    protected Property() {
    }

    protected Map<?, ?> readDictionary(byte[] bArr, long j, int i, int i2) throws UnsupportedEncodingException {
        long j2;
        long j3;
        if (j < 0 || j > bArr.length) {
            throw new HPSFRuntimeException("Illegal offset " + j + " while HPSF stream contains " + i + " bytes.");
        }
        int i3 = (int) j;
        long uInt = LittleEndian.getUInt(bArr, i3);
        int i4 = i3 + 4;
        LinkedHashMap linkedHashMap = new LinkedHashMap((int) uInt, 1.0f);
        int i5 = 0;
        while (i5 < uInt) {
            try {
                Long valueOf = Long.valueOf(LittleEndian.getUInt(bArr, i4));
                int i6 = i4 + 4;
                long uInt2 = LittleEndian.getUInt(bArr, i6);
                int i7 = i6 + 4;
                StringBuffer stringBuffer = new StringBuffer();
                if (i2 == -1) {
                    j2 = uInt;
                    stringBuffer.append(new String(bArr, i7, (int) uInt2));
                } else if (i2 == 1200) {
                    j2 = uInt;
                    int i8 = (int) (uInt2 * 2);
                    byte[] bArr2 = new byte[i8];
                    for (int i9 = 0; i9 < i8; i9 += 2) {
                        int i10 = i7 + i9;
                        bArr2[i9] = bArr[i10 + 1];
                        bArr2[i9 + 1] = bArr[i10];
                    }
                    stringBuffer.append(new String(bArr2, 0, i8, CodePageUtil.codepageToEncoding(i2)));
                } else {
                    stringBuffer.append(new String(bArr, i7, (int) uInt2, VariantSupport.codepageToEncoding(i2)));
                    j2 = uInt;
                }
                while (stringBuffer.length() > 0 && stringBuffer.charAt(stringBuffer.length() - 1) == 0) {
                    stringBuffer.setLength(stringBuffer.length() - 1);
                }
                if (i2 == 1200) {
                    if (uInt2 % 2 == 1) {
                        uInt2++;
                    }
                    j3 = i7;
                    uInt2 += uInt2;
                } else {
                    j3 = i7;
                }
                i4 = (int) (j3 + uInt2);
                linkedHashMap.put(valueOf, stringBuffer.toString());
                i5++;
                uInt = j2;
            } catch (RuntimeException e) {
                POILogFactory.getLogger(getClass()).log(5, (Object) ("The property set's dictionary contains bogus data. All dictionary entries starting with the one with ID " + this.id + " will be ignored."), (Throwable) e);
            }
        }
        return linkedHashMap;
    }

    protected int getSize() throws WritingNotSupportedException {
        int variantLength = VariantSupport.getVariantLength(this.type);
        if (variantLength >= 0) {
            return variantLength;
        }
        if (variantLength == -2) {
            throw new WritingNotSupportedException(this.type, null);
        }
        int i = (int) this.type;
        if (i == 0) {
            return variantLength;
        }
        if (i == 30) {
            int length = ((String) this.value).length() + 1;
            int i2 = length % 4;
            if (i2 > 0) {
                length += 4 - i2;
            }
            return variantLength + length;
        }
        throw new WritingNotSupportedException(this.type, this.value);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Property)) {
            return false;
        }
        Property property = (Property) obj;
        Object value = property.getValue();
        long id = property.getID();
        long j = this.id;
        if (j == id && (j == 0 || typesAreEqual(this.type, property.getType()))) {
            Object obj2 = this.value;
            if (obj2 == null && value == null) {
                return true;
            }
            if (obj2 != null && value != null) {
                Class<?> cls = obj2.getClass();
                Class<?> cls2 = value.getClass();
                if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                    return false;
                }
                Object obj3 = this.value;
                if (obj3 instanceof byte[]) {
                    return Util.equal((byte[]) obj3, (byte[]) value);
                }
                return obj3.equals(value);
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.id + 0 + this.type;
        if (this.value != null) {
            j += r2.hashCode();
        }
        return (int) (j & 4294967295L);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName());
        stringBuffer.append(PropertyUtils.INDEXED_DELIM);
        stringBuffer.append("id: ");
        stringBuffer.append(getID());
        stringBuffer.append(", type: ");
        stringBuffer.append(getType());
        Object value = getValue();
        stringBuffer.append(", value: ");
        if (value instanceof String) {
            stringBuffer.append(value.toString());
            String str = (String) value;
            int length = str.length();
            int i = length * 2;
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                int i3 = i2 * 2;
                bArr[i3] = (byte) ((65280 & charAt) >> 8);
                bArr[i3 + 1] = (byte) ((charAt & 255) >> 0);
            }
            stringBuffer.append(" [");
            if (i > 0) {
                stringBuffer.append(HexDump.dump(bArr, 0L, 0));
            }
            stringBuffer.append("]");
        } else if (value instanceof byte[]) {
            byte[] bArr2 = (byte[]) value;
            if (bArr2.length > 0) {
                stringBuffer.append(HexDump.dump(bArr2, 0L, 0));
            }
        } else {
            stringBuffer.append(value.toString());
        }
        stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        return stringBuffer.toString();
    }
}
