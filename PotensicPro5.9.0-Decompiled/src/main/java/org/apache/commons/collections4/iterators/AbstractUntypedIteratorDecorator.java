package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
public abstract class AbstractUntypedIteratorDecorator<I, O> implements Iterator<O> {
    private final Iterator<I> iterator;

    protected AbstractUntypedIteratorDecorator(Iterator<I> it) {
        Objects.requireNonNull(it, "Iterator must not be null");
        this.iterator = it;
    }

    protected Iterator<I> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }
}
