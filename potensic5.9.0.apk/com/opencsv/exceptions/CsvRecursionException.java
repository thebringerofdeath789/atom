package com.opencsv.exceptions;

/* loaded from: classes3.dex */
public class CsvRecursionException extends CsvRuntimeException {
    private static final long serialVersionUID = 1;
    private final Class<?> offendingType;

    public CsvRecursionException(String str, Class<?> cls) {
        super(str);
        this.offendingType = cls;
    }

    public Class<?> getOffendingType() {
        return this.offendingType;
    }
}