package org.apache.commons.collections.iterators;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableListIterator;

/* loaded from: classes4.dex */
public class SingletonListIterator implements ListIterator, ResettableListIterator {
    private Object object;
    private boolean beforeFirst = true;
    private boolean nextCalled = false;
    private boolean removed = false;

    public SingletonListIterator(Object obj) {
        this.object = obj;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.beforeFirst && !this.removed;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return (this.beforeFirst || this.removed) ? false : true;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return !this.beforeFirst ? 1 : 0;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.beforeFirst ? -1 : 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (!this.beforeFirst || this.removed) {
            throw new NoSuchElementException();
        }
        this.beforeFirst = false;
        this.nextCalled = true;
        return this.object;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (this.beforeFirst || this.removed) {
            throw new NoSuchElementException();
        }
        this.beforeFirst = true;
        return this.object;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        if (!this.nextCalled || this.removed) {
            throw new IllegalStateException();
        }
        this.object = null;
        this.removed = true;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("add() is not supported by this iterator");
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        if (!this.nextCalled || this.removed) {
            throw new IllegalStateException();
        }
        this.object = obj;
    }

    @Override // org.apache.commons.collections.ResettableListIterator, org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.beforeFirst = true;
        this.nextCalled = false;
    }
}
