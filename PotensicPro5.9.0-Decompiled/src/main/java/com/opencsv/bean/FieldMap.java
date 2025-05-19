package com.opencsv.bean;

import com.opencsv.bean.ComplexFieldMapEntry;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Locale;

/* loaded from: classes3.dex */
public interface FieldMap<I, K extends Comparable<K>, C extends ComplexFieldMapEntry<I, K, T>, T> {
    String[] generateHeader(T t) throws CsvRequiredFieldEmptyException;

    BeanField<T, K> get(K k);

    BeanField<T, K> put(K k, BeanField<T, K> beanField);

    void putComplex(I i, BeanField<T, K> beanField);

    void setErrorLocale(Locale locale);

    Collection<BeanField<T, K>> values();
}
