package org.apache.commons.collections.iterators;

import java.util.Iterator;
import org.apache.commons.collections.Unmodifiable;

/* loaded from: classes4.dex */
public final class UnmodifiableIterator implements Iterator, Unmodifiable {
    private Iterator iterator;

    public static Iterator decorate(Iterator it) {
        if (it != null) {
            return it instanceof Unmodifiable ? it : new UnmodifiableIterator(it);
        }
        throw new IllegalArgumentException("Iterator must not be null");
    }

    private UnmodifiableIterator(Iterator it) {
        this.iterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
