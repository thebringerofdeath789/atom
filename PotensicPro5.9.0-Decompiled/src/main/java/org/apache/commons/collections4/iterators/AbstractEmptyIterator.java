package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class AbstractEmptyIterator<E> {
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

    public E next() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public E previous() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public void add(E e) {
        throw new UnsupportedOperationException("add() not supported for empty Iterator");
    }

    public void set(E e) {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public void remove() {
        throw new IllegalStateException("Iterator contains no elements");
    }
}
