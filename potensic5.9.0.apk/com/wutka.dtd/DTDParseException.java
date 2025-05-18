package com.wutka.dtd;

import java.io.IOException;

/* loaded from: classes3.dex */
public class DTDParseException extends IOException {
    public int column;
    public int lineNumber;
    public String uriID;

    public DTDParseException() {
        this.uriID = "";
        this.lineNumber = -1;
        this.column = -1;
    }

    public DTDParseException(String str) {
        super(str);
        this.uriID = "";
        this.lineNumber = -1;
        this.column = -1;
    }

    public DTDParseException(String str, int i, int i2) {
        super(new StringBuffer().append("At line ").append(i).append(", column ").append(i2).append(": ").append(str).toString());
        this.uriID = "";
        this.lineNumber = i;
        this.column = i2;
    }

    public DTDParseException(String str, String str2, int i, int i2) {
        super(new StringBuffer().append((str == null || str.length() <= 0) ? "At " : new StringBuffer().append("URI ").append(str).append(" at ").toString()).append("line ").append(i).append(", column ").append(i2).append(": ").append(str2).toString());
        this.uriID = "";
        if (str != null) {
            this.uriID = str;
        }
        this.lineNumber = i;
        this.column = i2;
    }

    public String getId() {
        return this.uriID;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getColumn() {
        return this.column;
    }
}