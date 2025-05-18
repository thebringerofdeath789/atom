package com.opencsv.exceptions;

/* loaded from: classes3.dex */
public class CsvDataTypeMismatchException extends CsvFieldAssignmentException {
    private static final long serialVersionUID = 1;
    private final Class<?> destinationClass;
    private final transient Object sourceObject;

    public CsvDataTypeMismatchException() {
        this.sourceObject = null;
        this.destinationClass = null;
    }

    public CsvDataTypeMismatchException(Object obj, Class<?> cls) {
        this.sourceObject = obj;
        this.destinationClass = cls;
    }

    public CsvDataTypeMismatchException(String str) {
        super(str);
        this.sourceObject = null;
        this.destinationClass = null;
    }

    public CsvDataTypeMismatchException(Object obj, Class<?> cls, String str) {
        super(str);
        this.sourceObject = obj;
        this.destinationClass = cls;
    }

    public Object getSourceObject() {
        return this.sourceObject;
    }

    public Class<?> getDestinationClass() {
        return this.destinationClass;
    }
}