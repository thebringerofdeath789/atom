package com.opencsv.exceptions;

import com.opencsv.ICSVParser;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.ResourceBundle;

/* loaded from: classes3.dex */
public class CsvBeanIntrospectionException extends CsvRuntimeException {
    private static final long serialVersionUID = 1;
    private final transient Object bean;
    private final transient Field field;

    public CsvBeanIntrospectionException() {
        this.bean = null;
        this.field = null;
    }

    public CsvBeanIntrospectionException(String str) {
        super(str);
        this.bean = null;
        this.field = null;
    }

    public CsvBeanIntrospectionException(Object obj, Field field) {
        this.bean = obj;
        this.field = field;
    }

    public CsvBeanIntrospectionException(Object obj, Field field, String str) {
        super(str);
        this.bean = obj;
        this.field = field;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return getMessageFromLocale(Locale.US);
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return getMessageFromLocale(Locale.getDefault());
    }

    private String getMessageFromLocale(Locale locale) {
        String message = super.getMessage();
        return (message != null || getBean() == null || getField() == null) ? message : String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, locale).getString("error.introspecting.field"), getField().getName(), getBean().getClass().getCanonicalName());
    }

    public Object getBean() {
        return this.bean;
    }

    public Field getField() {
        return this.field;
    }
}
