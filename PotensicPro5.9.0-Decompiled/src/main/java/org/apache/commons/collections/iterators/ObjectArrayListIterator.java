package org.apache.commons.collections.iterators;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableListIterator;

/* loaded from: classes4.dex */
public class ObjectArrayListIterator extends ObjectArrayIterator implements ListIterator, ResettableListIterator {
    protected int lastItemIndex;

    public ObjectArrayListIterator() {
        this.lastItemIndex = -1;
    }

    public ObjectArrayListIterator(Object[] objArr) {
        super(objArr);
        this.lastItemIndex = -1;
    }

    public ObjectArrayListIterator(Object[] objArr, int i) {
        super(objArr, i);
        this.lastItemIndex = -1;
    }

    public ObjectArrayListIterator(Object[] objArr, int i, int i2) {
        super(objArr, i, i2);
        this.lastItemIndex = -1;
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
        return this.array[this.index];
    }

    @Override // org.apache.commons.collections.iterators.ObjectArrayIterator, java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.lastItemIndex = this.index;
        Object[] objArr = this.array;
        int i = this.index;
        this.index = i + 1;
        return objArr[i];
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
        this.array[this.lastItemIndex] = obj;
    }

    @Override // org.apache.commons.collections.iterators.ObjectArrayIterator, org.apache.commons.collections.ResettableIterator
    public void reset() {
        super.reset();
        this.lastItemIndex = -1;
    }
}
