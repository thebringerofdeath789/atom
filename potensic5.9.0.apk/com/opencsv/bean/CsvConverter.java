package com.opencsv.bean;

import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.util.Locale;

/* loaded from: classes3.dex */
public interface CsvConverter {
    Object convertToRead(String str) throws CsvDataTypeMismatchException, CsvConstraintViolationException;

    String convertToWrite(Object obj) throws CsvDataTypeMismatchException;

    void setErrorLocale(Locale locale);

    void setLocale(String str);

    void setType(Class<?> cls);

    void setWriteLocale(String str);
}