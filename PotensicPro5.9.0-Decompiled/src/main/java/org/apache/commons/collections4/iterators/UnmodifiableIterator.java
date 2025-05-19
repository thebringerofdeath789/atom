package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.Unmodifiable;

/* loaded from: classes4.dex */
public final class UnmodifiableIterator<E> implements Iterator<E>, Unmodifiable {
    private final Iterator<? extends E> iterator;

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Iterator<E> unmodifiableIterator(Iterator<? extends E> it) {
        Objects.requireNonNull(it, "Iterator must not be null");
        return it instanceof Unmodifiable ? it : new UnmodifiableIterator(it);
    }

    private UnmodifiableIterator(Iterator<? extends E> it) {
        this.iterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
