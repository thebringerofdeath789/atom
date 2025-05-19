package com.opencsv.exceptions;

import org.apache.commons.lang3.ArrayUtils;

/* loaded from: classes3.dex */
public class CsvException extends Exception {
    private static final long serialVersionUID = 1;
    private String[] line;
    private long lineNumber;

    public CsvException() {
        this.lineNumber = -1L;
    }

    public CsvException(String str) {
        super(str);
        this.lineNumber = -1L;
    }

    public long getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(long j) {
        this.lineNumber = j;
    }

    public String[] getLine() {
        return (String[]) ArrayUtils.clone(this.line);
    }

    public void setLine(String[] strArr) {
        this.line = (String[]) ArrayUtils.clone(strArr);
    }
}
