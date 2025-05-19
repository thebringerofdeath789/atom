package org.apache.commons.collections.iterators;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections.ResettableListIterator;

/* loaded from: classes4.dex */
public class LoopingListIterator implements ResettableListIterator {
    private ListIterator iterator;
    private List list;

    public LoopingListIterator(List list) {
        Objects.requireNonNull(list, "The list must not be null");
        this.list = list;
        reset();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return !this.list.isEmpty();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.iterator.hasNext()) {
            reset();
        }
        return this.iterator.next();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (this.iterator.hasNext()) {
            return this.iterator.nextIndex();
        }
        return 0;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return !this.list.isEmpty();
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.iterator.hasPrevious()) {
            Object obj = null;
            while (this.iterator.hasNext()) {
                obj = this.iterator.next();
            }
            this.iterator.previous();
            return obj;
        }
        return this.iterator.previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.iterator.hasPrevious()) {
            return this.list.size() - 1;
        }
        return this.iterator.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        this.iterator.add(obj);
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        this.iterator.set(obj);
    }

    @Override // org.apache.commons.collections.ResettableListIterator, org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.iterator = this.list.listIterator();
    }

    public int size() {
        return this.list.size();
    }
}
