package com.opencsv.bean;

/* loaded from: classes3.dex */
public class FieldMapByNameEntry<T> {
    private final BeanField<T, String> field;
    private final String name;
    private final boolean regexPattern;

    public FieldMapByNameEntry(String str, BeanField<T, String> beanField, boolean z) {
        this.name = str;
        this.field = beanField;
        this.regexPattern = z;
    }

    public String getName() {
        return this.name;
    }

    public BeanField<T, String> getField() {
        return this.field;
    }

    public boolean isRegexPattern() {
        return this.regexPattern;
    }
}
