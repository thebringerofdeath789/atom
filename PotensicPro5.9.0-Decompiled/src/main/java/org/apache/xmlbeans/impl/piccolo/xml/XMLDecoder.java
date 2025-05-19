package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.CharConversionException;
import org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder;

/* loaded from: classes5.dex */
public interface XMLDecoder extends CharsetDecoder {
    void decodeXMLDecl(byte[] bArr, int i, int i2, char[] cArr, int i3, int i4, int[] iArr) throws CharConversionException;

    XMLDecoder newXMLDecoder();
}
