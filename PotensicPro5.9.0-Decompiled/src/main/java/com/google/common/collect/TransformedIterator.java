package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

/* loaded from: classes2.dex */
abstract class TransformedIterator<F, T> implements Iterator<T> {
    final Iterator<? extends F> backingIterator;

    abstract T transform(F f);

    TransformedIterator(Iterator<? extends F> it) {
        this.backingIterator = (Iterator) Preconditions.checkNotNull(it);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.backingIterator.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return transform(this.backingIterator.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.backingIterator.remove();
    }
}
