package com.opencsv.bean;

import java.lang.Comparable;
import java.util.Locale;
import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes3.dex */
public abstract class AbstractFieldMapEntry<I, K extends Comparable<K>, T> implements ComplexFieldMapEntry<I, K, T> {
    protected Locale errorLocale;
    protected final BeanField<T, K> field;

    protected AbstractFieldMapEntry(BeanField<T, K> beanField, Locale locale) {
        this.field = beanField;
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    @Override // com.opencsv.bean.ComplexFieldMapEntry
    public BeanField<T, K> getBeanField() {
        return this.field;
    }

    @Override // com.opencsv.bean.ComplexFieldMapEntry
    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }
}
