package com.opencsv.bean;

/* loaded from: classes3.dex */
public class FieldMapByPositionEntry<T> {
    private final BeanField<T, Integer> field;
    private final int position;

    public FieldMapByPositionEntry(int i, BeanField<T, Integer> beanField) {
        this.position = i;
        this.field = beanField;
    }

    public int getPosition() {
        return this.position;
    }

    public BeanField<T, Integer> getField() {
        return this.field;
    }
}
