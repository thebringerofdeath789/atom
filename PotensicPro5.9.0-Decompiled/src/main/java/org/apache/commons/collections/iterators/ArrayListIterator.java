package org.apache.commons.collections.iterators;

import java.lang.reflect.Array;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableListIterator;

/* loaded from: classes4.dex */
public class ArrayListIterator extends ArrayIterator implements ListIterator, ResettableListIterator {
    protected int lastItemIndex;

    public ArrayListIterator() {
        this.lastItemIndex = -1;
    }

    public ArrayListIterator(Object obj) {
        super(obj);
        this.lastItemIndex = -1;
    }

    public ArrayListIterator(Object obj, int i) {
        super(obj, i);
        this.lastItemIndex = -1;
        this.startIndex = i;
    }

    public ArrayListIterator(Object obj, int i, int i2) {
        super(obj, i, i2);
        this.lastItemIndex = -1;
        this.startIndex = i;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.index > this.startIndex;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.index - 1;
        this.index = i;
        this.lastItemIndex = i;
        return Array.get(this.array, this.index);
    }

    @Override // org.apache.commons.collections.iterators.ArrayIterator, java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.lastItemIndex = this.index;
        Object obj = this.array;
        int i = this.index;
        this.index = i + 1;
        return Array.get(obj, i);
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index - this.startIndex;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return (this.index - this.startIndex) - 1;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        if (this.lastItemIndex == -1) {
            throw new IllegalStateException("must call next() or previous() before a call to set()");
        }
        Array.set(this.array, this.lastItemIndex, obj);
    }

    @Override // org.apache.commons.collections.iterators.ArrayIterator, org.apache.commons.collections.ResettableIterator
    public void reset() {
        super.reset();
        this.lastItemIndex = -1;
    }
}
