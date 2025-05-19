package org.apache.xmlbeans.impl.piccolo.io;

import java.io.CharConversionException;

/* loaded from: classes5.dex */
public class IllegalCharException extends CharConversionException {
    protected int column;
    protected int line;

    public IllegalCharException(String str) {
        super(str);
    }
}
