package org.apache.poi.hpsf;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

@Internal
/* loaded from: classes4.dex */
class TypedPropertyValue {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) TypedPropertyValue.class);
    private int _type;
    private Object _value;

    TypedPropertyValue() {
    }

    TypedPropertyValue(byte[] bArr, int i) {
        read(bArr, i);
    }

    TypedPropertyValue(int i, Object obj) {
        this._type = i;
        this._value = obj;
    }

    Object getValue() {
        return this._value;
    }

    int read(byte[] bArr, int i) {
        this._type = LittleEndian.getShort(bArr, i);
        int i2 = i + 2;
        short s = LittleEndian.getShort(bArr, i2);
        int i3 = i2 + 2;
        if (s != 0) {
            logger.log(5, "TypedPropertyValue padding at offset " + i3 + " MUST be 0, but it's value is " + ((int) s));
        }
        return (i3 + readValue(bArr, i3)) - i;
    }

    int readValue(byte[] bArr, int i) {
        int i2 = this._type;
        if (i2 == 10) {
            this._value = Long.valueOf(LittleEndian.getUInt(bArr, i));
            return 4;
        }
        if (i2 == 11) {
            this._value = new VariantBool(bArr, i);
            return 2;
        }
        if (i2 == 30) {
            CodePageString codePageString = new CodePageString(bArr, i);
            this._value = codePageString;
            return codePageString.getSize();
        }
        if (i2 == 31) {
            UnicodeString unicodeString = new UnicodeString(bArr, i);
            this._value = unicodeString;
            return unicodeString.getSize();
        }
        if (i2 != 4126 && i2 != 4127 && i2 != 4167 && i2 != 4168) {
            switch (i2) {
                case 0:
                case 1:
                    this._value = null;
                    return 0;
                case 2:
                    this._value = Short.valueOf(LittleEndian.getShort(bArr, i));
                    return 4;
                case 3:
                    this._value = Integer.valueOf(LittleEndian.getInt(bArr, i));
                    return 4;
                case 4:
                    this._value = Short.valueOf(LittleEndian.getShort(bArr, i));
                    return 4;
                case 5:
                    this._value = Double.valueOf(LittleEndian.getDouble(bArr, i));
                    return 8;
                case 6:
                    this._value = new Currency(bArr, i);
                    return 8;
                case 7:
                    this._value = new Date(bArr, i);
                    return 8;
                case 8:
                    CodePageString codePageString2 = new CodePageString(bArr, i);
                    this._value = codePageString2;
                    return codePageString2.getSize();
                default:
                    switch (i2) {
                        case 14:
                            this._value = new Decimal(bArr, i);
                            return 16;
                        case 64:
                            this._value = new Filetime(bArr, i);
                            return 8;
                        case 65:
                            Blob blob = new Blob(bArr, i);
                            this._value = blob;
                            return blob.getSize();
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                            IndirectPropertyName indirectPropertyName = new IndirectPropertyName(bArr, i);
                            this._value = indirectPropertyName;
                            return indirectPropertyName.getSize();
                        case 70:
                            Blob blob2 = new Blob(bArr, i);
                            this._value = blob2;
                            return blob2.getSize();
                        case 71:
                            ClipboardData clipboardData = new ClipboardData(bArr, i);
                            this._value = clipboardData;
                            return clipboardData.getSize();
                        case 72:
                            this._value = new GUID(bArr, i);
                            return 16;
                        case 73:
                            VersionedStream versionedStream = new VersionedStream(bArr, i);
                            this._value = versionedStream;
                            return versionedStream.getSize();
                        case 4160:
                            break;
                        case 8194:
                        case 8195:
                        case 8196:
                        case 8197:
                        case 8198:
                        case 8199:
                        case 8200:
                        case 8202:
                        case 8203:
                        case 8204:
                        case 8206:
                        case 8208:
                        case 8209:
                        case 8210:
                        case 8211:
                        case 8214:
                        case 8215:
                            Array array = new Array();
                            this._value = array;
                            return array.read(bArr, i);
                        default:
                            switch (i2) {
                                case 16:
                                    this._value = Byte.valueOf(bArr[i]);
                                    return 1;
                                case 17:
                                    this._value = Short.valueOf(LittleEndian.getUByte(bArr, i));
                                    return 2;
                                case 18:
                                    this._value = Integer.valueOf(LittleEndian.getUShort(bArr, i));
                                    return 4;
                                case 19:
                                    this._value = Long.valueOf(LittleEndian.getUInt(bArr, i));
                                    return 4;
                                case 20:
                                    this._value = Long.valueOf(LittleEndian.getLong(bArr, i));
                                    return 8;
                                case 21:
                                    this._value = LittleEndian.getByteArray(bArr, i, 8);
                                    return 8;
                                case 22:
                                    this._value = Integer.valueOf(LittleEndian.getInt(bArr, i));
                                    return 4;
                                case 23:
                                    this._value = Long.valueOf(LittleEndian.getUInt(bArr, i));
                                    return 4;
                                default:
                                    switch (i2) {
                                        case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                                        case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                                        case 4100:
                                        case 4101:
                                        case 4102:
                                        case 4103:
                                        case 4104:
                                            break;
                                        default:
                                            switch (i2) {
                                                case 4106:
                                                case 4107:
                                                case 4108:
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case 4112:
                                                        case 4113:
                                                        case 4114:
                                                        case 4115:
                                                        case 4116:
                                                        case 4117:
                                                            break;
                                                        default:
                                                            throw new UnsupportedOperationException("Unknown (possibly, incorrect) TypedPropertyValue type: " + this._type);
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        Vector vector = new Vector((short) (this._type & 4095));
        this._value = vector;
        return vector.read(bArr, i);
    }

    int readValuePadded(byte[] bArr, int i) {
        int readValue = readValue(bArr, i);
        int i2 = readValue & 3;
        return i2 == 0 ? readValue : readValue + (4 - i2);
    }
}
