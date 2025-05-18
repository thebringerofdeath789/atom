package com.opencsv.exceptions;

import java.io.IOException;

/* loaded from: classes3.dex */
public class CsvMultilineLimitBrokenException extends IOException {
    private static final long serialVersionUID = 1;
    private String context;
    private int multilineLimit;
    private long row;

    public int getMultilineLimit() {
        return this.multilineLimit;
    }

    public long getRow() {
        return this.row;
    }

    public String getContext() {
        return this.context;
    }

    public CsvMultilineLimitBrokenException() {
    }

    public CsvMultilineLimitBrokenException(String str, long j, String str2, int i) {
        super(str);
        this.row = j;
        this.context = str2;
        this.multilineLimit = i;
    }
}