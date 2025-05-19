package org.apache.commons.collections.iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections.ResettableIterator;

/* loaded from: classes4.dex */
public class LoopingIterator implements ResettableIterator {
    private Collection collection;
    private Iterator iterator;

    public LoopingIterator(Collection collection) {
        Objects.requireNonNull(collection, "The collection must not be null");
        this.collection = collection;
        reset();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.collection.size() > 0;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (this.collection.size() == 0) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.iterator.hasNext()) {
            reset();
        }
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.iterator = this.collection.iterator();
    }

    public int size() {
        return this.collection.size();
    }
}
