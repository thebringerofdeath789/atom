package org.apache.xmlbeans.impl.piccolo.io;

import java.io.CharConversionException;

/* loaded from: classes5.dex */
public interface CharsetDecoder {
    void decode(byte[] bArr, int i, int i2, char[] cArr, int i3, int i4, int[] iArr) throws CharConversionException;

    int maxBytesPerChar();

    int minBytesPerChar();

    CharsetDecoder newCharsetDecoder();

    void reset();
}
