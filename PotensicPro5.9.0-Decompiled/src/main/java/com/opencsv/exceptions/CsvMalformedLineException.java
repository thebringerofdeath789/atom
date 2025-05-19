package com.opencsv.exceptions;

import java.io.IOException;

/* loaded from: classes3.dex */
public class CsvMalformedLineException extends IOException {
    private static final long serialVersionUID = 1;
    private String context;
    private long lineNumber;

    public long getLineNumber() {
        return this.lineNumber;
    }

    public String getContext() {
        return this.context;
    }

    public CsvMalformedLineException() {
    }

    public CsvMalformedLineException(String str, long j, String str2) {
        super(str);
        this.lineNumber = j;
        this.context = str2;
    }
}
