package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.CharConversionException;
import org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder;
import org.apache.xmlbeans.impl.piccolo.io.IllegalCharException;

/* loaded from: classes5.dex */
public final class UnicodeLittleXMLDecoder implements XMLDecoder {
    private boolean sawCR = false;

    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public int maxBytesPerChar() {
        return 2;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public int minBytesPerChar() {
        return 2;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public CharsetDecoder newCharsetDecoder() {
        return newXMLDecoder();
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLDecoder
    public XMLDecoder newXMLDecoder() {
        return new UnicodeLittleXMLDecoder();
    }

    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public void reset() {
        this.sawCR = false;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public void decode(byte[] bArr, int i, int i2, char[] cArr, int i3, int i4, int[] iArr) throws CharConversionException {
        int i5;
        int i6 = 0;
        int i7 = 0;
        while (i6 + 1 < i2 && i7 < i4) {
            int i8 = i + i6;
            char c = (char) ((bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8));
            if (c < ' ') {
                if (c == '\t') {
                    i5 = i7 + 1;
                    cArr[i7 + i3] = '\t';
                } else if (c != '\n') {
                    if (c == '\r') {
                        this.sawCR = true;
                        i5 = i7 + 1;
                        cArr[i7 + i3] = '\n';
                    } else {
                        throw new IllegalCharException(new StringBuffer().append("Illegal XML character: 0x").append(Integer.toHexString(c)).toString());
                    }
                } else if (this.sawCR) {
                    this.sawCR = false;
                } else {
                    i5 = i7 + 1;
                    cArr[i7 + i3] = '\n';
                }
                i7 = i5;
            } else if (c <= 55295 || ((c >= 57344 && c <= 65533) || (c >= 0 && c <= 65535))) {
                this.sawCR = false;
                cArr[i7 + i3] = c;
                i7++;
            } else {
                throw new IllegalCharException(new StringBuffer().append("Illegal XML Character: 0x").append(Integer.toHexString(c)).toString());
            }
            i6 += 2;
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
            if (i6 + 1 >= i2 || i7 >= i4) {
                break;
            }
            int i8 = i + i6;
            char c = (char) ((bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8));
            if (c < ' ') {
                if (c == '\t') {
                    i5 = i7 + 1;
                    cArr[i7 + i3] = '\t';
                } else if (c != '\n') {
                    if (c != '\r') {
                        break;
                    }
                    this.sawCR = true;
                    i5 = i7 + 1;
                    cArr[i7 + i3] = '\n';
                } else if (this.sawCR) {
                    this.sawCR = false;
                    i6 += 2;
                } else {
                    i5 = i7 + 1;
                    cArr[i7 + i3] = '\n';
                }
                i7 = i5;
                i6 += 2;
            } else {
                if (c > 55295 && ((c < 57344 || c > 65533) && (c < 0 || c > 65535))) {
                    break;
                }
                this.sawCR = false;
                int i9 = i7 + 1;
                cArr[i7 + i3] = c;
                if (c == '>') {
                    i6 += 2;
                    i7 = i9;
                    break;
                } else {
                    i7 = i9;
                    i6 += 2;
                }
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
    }
}
