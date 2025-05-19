package org.apache.commons.collections.iterators;

import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.Unmodifiable;

/* loaded from: classes4.dex */
public final class UnmodifiableOrderedMapIterator implements OrderedMapIterator, Unmodifiable {
    private OrderedMapIterator iterator;

    public static OrderedMapIterator decorate(OrderedMapIterator orderedMapIterator) {
        if (orderedMapIterator != null) {
            return orderedMapIterator instanceof Unmodifiable ? orderedMapIterator : new UnmodifiableOrderedMapIterator(orderedMapIterator);
        }
        throw new IllegalArgumentException("OrderedMapIterator must not be null");
    }

    private UnmodifiableOrderedMapIterator(OrderedMapIterator orderedMapIterator) {
        this.iterator = orderedMapIterator;
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public Object next() {
        return this.iterator.next();
    }

    @Override // org.apache.commons.collections.OrderedMapIterator, org.apache.commons.collections.OrderedIterator
    public boolean hasPrevious() {
        return this.iterator.hasPrevious();
    }

    @Override // org.apache.commons.collections.OrderedMapIterator, org.apache.commons.collections.OrderedIterator
    public Object previous() {
        return this.iterator.previous();
    }

    @Override // org.apache.commons.collections.MapIterator
    public Object getKey() {
        return this.iterator.getKey();
    }

    @Override // org.apache.commons.collections.MapIterator
    public Object getValue() {
        return this.iterator.getValue();
    }

    @Override // org.apache.commons.collections.MapIterator
    public Object setValue(Object obj) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
