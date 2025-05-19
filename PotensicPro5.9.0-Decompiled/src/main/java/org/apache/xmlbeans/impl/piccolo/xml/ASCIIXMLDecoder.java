package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.CharConversionException;
import org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder;
import org.apache.xmlbeans.impl.piccolo.io.IllegalCharException;

/* loaded from: classes5.dex */
public final class ASCIIXMLDecoder implements XMLDecoder {
    private boolean sawCR = false;

    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public int maxBytesPerChar() {
        return 1;
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
        return new ASCIIXMLDecoder();
    }

    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public void reset() {
        this.sawCR = false;
    }

    @Override // org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder
    public void decode(byte[] bArr, int i, int i2, char[] cArr, int i3, int i4, int[] iArr) throws CharConversionException {
        internalDecode(bArr, i, i2, cArr, i3, i4, iArr, false);
    }

    @Override // org.apache.xmlbeans.impl.piccolo.xml.XMLDecoder
    public void decodeXMLDecl(byte[] bArr, int i, int i2, char[] cArr, int i3, int i4, int[] iArr) throws CharConversionException {
        internalDecode(bArr, i, i2, cArr, i3, i4, iArr, true);
    }

    private void internalDecode(byte[] bArr, int i, int i2, char[] cArr, int i3, int i4, int[] iArr, boolean z) throws CharConversionException {
        int i5;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= i2 || i7 >= i4) {
                break;
            }
            char c = (char) (bArr[i + i6] & Byte.MAX_VALUE);
            if (c >= ' ') {
                this.sawCR = false;
                i5 = i7 + 1;
                cArr[i7 + i3] = c;
            } else if (c == '\t') {
                i5 = i7 + 1;
                cArr[i7 + i3] = '\t';
            } else if (c != '\n') {
                if (c == '\r') {
                    this.sawCR = true;
                    i5 = i7 + 1;
                    cArr[i7 + i3] = '\n';
                } else if (!z) {
                    throw new IllegalCharException(new StringBuffer().append("Illegal XML character: 0x").append(Integer.toHexString(c)).toString());
                }
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
        iArr[0] = i6;
        iArr[1] = i7;
    }
}
