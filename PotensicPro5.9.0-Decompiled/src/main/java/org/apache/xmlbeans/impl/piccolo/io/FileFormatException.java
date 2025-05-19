package org.apache.xmlbeans.impl.piccolo.io;

import java.io.IOException;

/* loaded from: classes5.dex */
public class FileFormatException extends IOException {
    protected int column;
    protected int line;

    public FileFormatException() {
        this(null);
    }

    public FileFormatException(String str) {
        this(str, -1, -1);
    }

    public FileFormatException(String str, int i, int i2) {
        super(str);
        this.line = i;
        this.column = i2;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }
}
