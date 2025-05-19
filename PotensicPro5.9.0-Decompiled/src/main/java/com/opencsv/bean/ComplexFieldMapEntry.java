package com.opencsv.bean;

import java.lang.Comparable;
import java.util.Locale;

/* loaded from: classes3.dex */
public interface ComplexFieldMapEntry<I, K extends Comparable<K>, T> {
    boolean contains(K k);

    BeanField<T, K> getBeanField();

    I getInitializer();

    void setErrorLocale(Locale locale);
}
