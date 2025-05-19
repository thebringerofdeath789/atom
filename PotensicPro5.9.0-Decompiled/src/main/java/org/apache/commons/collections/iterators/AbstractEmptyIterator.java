package org.apache.commons.collections.iterators;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class AbstractEmptyIterator {
    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public int nextIndex() {
        return 0;
    }

    public int previousIndex() {
        return -1;
    }

    public void reset() {
    }

    protected AbstractEmptyIterator() {
    }

    public Object next() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public Object previous() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public void add(Object obj) {
        throw new UnsupportedOperationException("add() not supported for empty Iterator");
    }

    public void set(Object obj) {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public void remove() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public Object getKey() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public Object getValue() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public Object setValue(Object obj) {
        throw new IllegalStateException("Iterator contains no elements");
    }
}
