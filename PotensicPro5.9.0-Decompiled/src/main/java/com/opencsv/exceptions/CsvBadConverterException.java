package com.opencsv.exceptions;

/* loaded from: classes3.dex */
public class CsvBadConverterException extends CsvRuntimeException {
    private static final long serialVersionUID = 1;
    private final Class<?> converterClass;

    public CsvBadConverterException() {
        this.converterClass = null;
    }

    public CsvBadConverterException(Class<?> cls) {
        this.converterClass = cls;
    }

    public CsvBadConverterException(String str) {
        super(str);
        this.converterClass = null;
    }

    public CsvBadConverterException(Class<?> cls, String str) {
        super(str);
        this.converterClass = cls;
    }

    public Class<?> getConverterClass() {
        return this.converterClass;
    }
}
