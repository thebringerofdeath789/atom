package org.apache.commons.collections.iterators;

import java.util.ListIterator;
import org.apache.commons.collections.Unmodifiable;

/* loaded from: classes4.dex */
public final class UnmodifiableListIterator implements ListIterator, Unmodifiable {
    private ListIterator iterator;

    public static ListIterator decorate(ListIterator listIterator) {
        if (listIterator != null) {
            return listIterator instanceof Unmodifiable ? listIterator : new UnmodifiableListIterator(listIterator);
        }
        throw new IllegalArgumentException("ListIterator must not be null");
    }

    private UnmodifiableListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
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
        throw new UnsupportedOperationException("remove() is not supported");
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        throw new UnsupportedOperationException("set() is not supported");
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("add() is not supported");
    }
}
