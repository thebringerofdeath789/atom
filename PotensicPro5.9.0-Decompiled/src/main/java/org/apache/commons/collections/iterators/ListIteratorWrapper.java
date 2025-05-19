package org.apache.commons.collections.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections.ResettableListIterator;

/* loaded from: classes4.dex */
public class ListIteratorWrapper implements ResettableListIterator {
    private static final String UNSUPPORTED_OPERATION_MESSAGE = "ListIteratorWrapper does not support optional operations of ListIterator.";
    private final Iterator iterator;
    private final List list = new ArrayList();
    private int currentIndex = 0;
    private int wrappedIteratorIndex = 0;

    public ListIteratorWrapper(Iterator it) {
        Objects.requireNonNull(it, "Iterator must not be null");
        this.iterator = it;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) throws UnsupportedOperationException {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentIndex == this.wrappedIteratorIndex) {
            return this.iterator.hasNext();
        }
        return true;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.currentIndex != 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() throws NoSuchElementException {
        int i = this.currentIndex;
        if (i < this.wrappedIteratorIndex) {
            int i2 = i + 1;
            this.currentIndex = i2;
            return this.list.get(i2 - 1);
        }
        Object next = this.iterator.next();
        this.list.add(next);
        this.currentIndex++;
        this.wrappedIteratorIndex++;
        return next;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.currentIndex;
    }

    @Override // java.util.ListIterator
    public Object previous() throws NoSuchElementException {
        int i = this.currentIndex;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        int i2 = i - 1;
        this.currentIndex = i2;
        return this.list.get(i2);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.currentIndex - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    @Override // java.util.ListIterator
    public void set(Object obj) throws UnsupportedOperationException {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    @Override // org.apache.commons.collections.ResettableListIterator, org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.currentIndex = 0;
    }
}
