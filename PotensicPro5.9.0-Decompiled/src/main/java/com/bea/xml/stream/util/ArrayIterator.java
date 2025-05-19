package com.bea.xml.stream.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class ArrayIterator implements Iterator {
    private final Object[] array;
    private int index;
    private final int maxIndex;

    public ArrayIterator(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }

    public ArrayIterator(Object[] objArr, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i > objArr.length) {
            throw new IllegalArgumentException();
        }
        if (i2 > objArr.length - i) {
            throw new IllegalArgumentException();
        }
        this.array = objArr;
        this.index = i;
        this.maxIndex = i2 + i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.maxIndex;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i = this.index;
        if (i >= this.maxIndex) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.array;
        this.index = i + 1;
        return objArr[i];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
