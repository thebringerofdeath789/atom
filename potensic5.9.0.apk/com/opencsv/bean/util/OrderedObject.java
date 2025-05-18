package com.opencsv.bean.util;

/* loaded from: classes3.dex */
public class OrderedObject<E> {
    private final E element;
    private final long ordinal;

    public OrderedObject(long j, E e) {
        this.ordinal = j;
        this.element = e;
    }

    public long getOrdinal() {
        return this.ordinal;
    }

    public E getElement() {
        return this.element;
    }
}