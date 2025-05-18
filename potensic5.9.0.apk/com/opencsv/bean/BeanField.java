package com.opencsv.bean;

import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
import java.lang.reflect.Field;
import java.util.Locale;

/* loaded from: classes3.dex */
public interface BeanField<T, I> {
    Locale getErrorLocale();

    Field getField();

    Object getFieldValue(Object obj);

    Class<?> getType();

    Object[] indexAndSplitMultivaluedField(Object obj, I i) throws CsvDataTypeMismatchException;

    boolean isRequired();

    void setErrorLocale(Locale locale);

    void setField(Field field);

    void setFieldValue(Object obj, String str, String str2) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, CsvConstraintViolationException, CsvValidationException;

    void setRequired(boolean z);

    void setType(Class<?> cls);

    String[] write(Object obj, I i) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;
}