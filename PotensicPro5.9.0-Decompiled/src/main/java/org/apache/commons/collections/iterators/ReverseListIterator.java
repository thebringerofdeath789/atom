package org.apache.commons.collections.iterators;

import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.ResettableListIterator;

/* loaded from: classes4.dex */
public class ReverseListIterator implements ResettableListIterator {
    private ListIterator iterator;
    private final List list;
    private boolean validForUpdate = true;

    public ReverseListIterator(List list) {
        this.list = list;
        this.iterator = list.listIterator(list.size());
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        Object previous = this.iterator.previous();
        this.validForUpdate = true;
        return previous;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.iterator.previousIndex();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.iterator.hasNext();
    }

    @Override // java.util.ListIterator
    public Object previous() {
        Object next = this.iterator.next();
        this.validForUpdate = true;
        return next;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.iterator.nextIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        if (!this.validForUpdate) {
            throw new IllegalStateException("Cannot remove from list until next() or previous() called");
        }
        this.iterator.remove();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        if (!this.validForUpdate) {
            throw new IllegalStateException("Cannot set to list until next() or previous() called");
        }
        this.iterator.set(obj);
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        if (!this.validForUpdate) {
            throw new IllegalStateException("Cannot add to list until next() or previous() called");
        }
        this.validForUpdate = false;
        this.iterator.add(obj);
        this.iterator.previous();
    }

    @Override // org.apache.commons.collections.ResettableListIterator, org.apache.commons.collections.ResettableIterator
    public void reset() {
        List list = this.list;
        this.iterator = list.listIterator(list.size());
    }
}
