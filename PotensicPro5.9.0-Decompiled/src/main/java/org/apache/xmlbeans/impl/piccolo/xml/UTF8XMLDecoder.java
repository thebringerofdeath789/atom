package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.CharConversionException;
import okio.Utf8;
import org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder;
import org.apache.xmlbeans.impl.piccolo.io.IllegalCharException;

/* loaded from: classes5.dex */
public final class UTF8XMLDecoder implements XMLDecoder {
    private boolean sawCR = false;

    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public int maxBytesPerChar() {
        return 3;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public int minBytesPerChar() {
        return 1;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public CharsetDecoder newCharsetDecoder() {
        return newXMLDecoder();
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLDecoder
    public XMLDecoder newXMLDecoder() {
        return new UTF8XMLDecoder();
    }

    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public void reset() {
        this.sawCR = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v74 */
    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public void decode(byte[] bArr, int i, int i2, char[] cArr, int i3, int i4, int[] iArr) throws CharConversionException {
        int i5;
        byte b;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i2 && i7 < i4) {
            byte b2 = bArr[i + i6];
            if ((b2 & 128) != 0) {
                i6++;
                if (i6 < i2) {
                    int i8 = i + i6;
                    byte b3 = bArr[i8];
                    if ((b2 & 224) != 192) {
                        int i9 = b2 & 240;
                        if (i9 == 224) {
                            i6++;
                            if (i6 < i2) {
                                int i10 = i + i6;
                                byte b4 = bArr[i10];
                                if ((b3 & 128) != 128 || (b4 & 128) != 128) {
                                    throw new CharConversionException(new StringBuffer().append("Malformed UTF-8 character: 0x").append(Integer.toHexString(b2 & 255)).append(" 0x").append(Integer.toHexString(b3 & 255)).append(" 0x").append(Integer.toHexString(b4 & 255)).toString());
                                }
                                ?? r2 = ((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63);
                                int i11 = 63488 & (r2 == true ? 1 : 0);
                                b = r2;
                                if (i11 == 0) {
                                    throw new CharConversionException(new StringBuffer().append("3-byte UTF-8 character is overlong: 0x").append(Integer.toHexString(bArr[i10 - 2] & 255)).append(" 0x").append(Integer.toHexString(b3 & 255)).append(" 0x").append(Integer.toHexString(b4 & 255)).toString());
                                }
                            } else {
                                iArr[0] = i6 - 2;
                                iArr[1] = i7;
                                return;
                            }
                        } else {
                            if (i9 != 240) {
                                throw new CharConversionException(new StringBuffer().append("Characters larger than 4 bytes are not supported: byte 0x").append(Integer.toHexString(b2 & 255)).append(" implies a length of more than 4 bytes").toString());
                            }
                            if (i6 + 2 < i2) {
                                int i12 = i6 + 1;
                                byte b5 = bArr[i + i12];
                                i6 = i12 + 1;
                                byte b6 = bArr[i + i6];
                                if ((b3 & 128) != 128 || (b5 & 128) != 128 || (b6 & 128) != 128) {
                                    throw new CharConversionException(new StringBuffer().append("Malformed UTF-8 character: 0x").append(Integer.toHexString(b2 & 255)).append(" 0x").append(Integer.toHexString(b3 & 255)).append(" 0x").append(Integer.toHexString(b5 & 255)).append(" 0x").append(Integer.toHexString(b6 & 255)).toString());
                                }
                                int i13 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b5 & 63) << 6) | (b6 & 63);
                                if (i13 < 65536 || i13 > 1114111) {
                                    throw new IllegalCharException(new StringBuffer().append("Illegal XML character: 0x").append(Integer.toHexString(i13)).toString());
                                }
                                int i14 = i13 - 65536;
                                int i15 = i7 + 1;
                                cArr[i3 + i7] = (char) ((i14 >> 10) | 55296);
                                i7 = i15 + 1;
                                cArr[i3 + i15] = (char) ((i14 & 1023) | Utf8.LOG_SURROGATE_HEADER);
                                this.sawCR = false;
                                i6++;
                            } else {
                                iArr[0] = i6 - 2;
                                iArr[1] = i7;
                                return;
                            }
                        }
                    } else {
                        if ((b3 & 128) != 128) {
                            throw new CharConversionException(new StringBuffer().append("Malformed UTF-8 character: 0x").append(Integer.toHexString(b2 & 255)).append(" 0x").append(Integer.toHexString(b3 & 255)).toString());
                        }
                        ?? r22 = ((b2 & 31) << 6) | (b3 & 63);
                        int i16 = (r22 == true ? 1 : 0) & 1920;
                        b = r22;
                        if (i16 == 0) {
                            throw new CharConversionException(new StringBuffer().append("2-byte UTF-8 character is overlong: 0x").append(Integer.toHexString(bArr[i8 - 1] & 255)).append(" 0x").append(Integer.toHexString(b3 & 255)).toString());
                        }
                    }
                    b2 = b;
                    if ((b2 >= 55296 && b2 < 57344) || b2 == 65534 || b2 == 65535) {
                        throw new IllegalCharException(new StringBuffer().append("Illegal XML character: 0x").append(Integer.toHexString(b2)).toString());
                    }
                } else {
                    iArr[0] = i6 - 1;
                    iArr[1] = i7;
                    return;
                }
            }
            if (b2 >= 32) {
                this.sawCR = false;
                cArr[i3 + i7] = (char) b2;
                i7++;
            } else {
                if (b2 == 9) {
                    i5 = i7 + 1;
                    cArr[i3 + i7] = '\t';
                } else if (b2 != 10) {
                    if (b2 == 13) {
                        this.sawCR = true;
                        i5 = i7 + 1;
                        cArr[i3 + i7] = '\n';
                    } else {
                        throw new IllegalCharException(new StringBuffer().append("Illegal XML character: 0x").append(Integer.toHexString(b2)).toString());
                    }
                } else if (this.sawCR) {
                    this.sawCR = false;
                } else {
                    i5 = i7 + 1;
                    cArr[i3 + i7] = '\n';
                }
                i7 = i5;
            }
            i6++;
        }
        iArr[0] = i6;
        iArr[1] = i7;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLDecoder
    public void decodeXMLDecl(byte[] bArr, int i, int i2, char[] cArr, int i3, int i4, int[] iArr) throws CharConversionException {
        int i5;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= i2 || i7 >= i4) {
                break;
            }
            byte b = bArr[i + i6];
            if ((b & 128) != 0) {
                break;
            }
            if (b >= 32) {
                this.sawCR = false;
                int i8 = i7 + 1;
                cArr[i7 + i3] = (char) b;
                if (b == 62) {
                    i6++;
                    i7 = i8;
                    break;
                } else {
                    i7 = i8;
                    i6++;
                }
            } else {
                if (b == 9) {
                    i5 = i7 + 1;
                    cArr[i7 + i3] = '\t';
                } else if (b != 10) {
                    if (b != 13) {
                        break;
                    }
                    this.sawCR = true;
                    i5 = i7 + 1;
                    cArr[i7 + i3] = '\n';
                } else if (this.sawCR) {
                    this.sawCR = false;
                    i6++;
                } else {
                    i5 = i7 + 1;
                    cArr[i7 + i3] = '\n';
                }
                i7 = i5;
                i6++;
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
    }
}
