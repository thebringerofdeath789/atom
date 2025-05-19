package org.apache.commons.collections.iterators;

import java.util.ListIterator;

/* loaded from: classes4.dex */
public class AbstractListIteratorDecorator implements ListIterator {
    protected final ListIterator iterator;

    public AbstractListIteratorDecorator(ListIterator listIterator) {
        if (listIterator == null) {
            throw new IllegalArgumentException("ListIterator must not be null");
        }
        this.iterator = listIterator;
    }

    protected ListIterator getListIterator() {
        return this.iterator;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        return this.iterator.next();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.iterator.nextIndex();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.iterator.hasPrevious();
    }

    @Override // java.util.ListIterator
    public Object previous() {
        return this.iterator.previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.iterator.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        this.iterator.set(obj);
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        this.iterator.add(obj);
    }
}
