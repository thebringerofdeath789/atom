package com.opencsv.bean;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvBeanIntrospectionException;
import com.opencsv.exceptions.CsvChainedException;
import com.opencsv.exceptions.CsvFieldAssignmentException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Locale;
import org.apache.commons.collections4.MultiValuedMap;

/* loaded from: classes3.dex */
public interface MappingStrategy<T> {
    void captureHeader(CSVReader cSVReader) throws IOException, CsvRequiredFieldEmptyException;

    String[] generateHeader(T t) throws CsvRequiredFieldEmptyException;

    @Deprecated
    default boolean isAnnotationDriven() {
        return false;
    }

    T populateNewBean(String[] strArr) throws CsvBeanIntrospectionException, CsvFieldAssignmentException, CsvChainedException;

    default void setErrorLocale(Locale locale) {
    }

    void setType(Class<? extends T> cls) throws CsvBadConverterException;

    String[] transmuteBean(T t) throws CsvFieldAssignmentException, CsvChainedException;

    default void setProfile(String str) {
        throw new UnsupportedOperationException();
    }

    default void ignoreFields(MultiValuedMap<Class<?>, Field> multiValuedMap) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }
}
