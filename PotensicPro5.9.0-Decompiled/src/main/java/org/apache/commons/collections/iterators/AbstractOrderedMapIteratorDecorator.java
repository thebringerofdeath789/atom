package org.apache.commons.collections.iterators;

import org.apache.commons.collections.OrderedMapIterator;

/* loaded from: classes4.dex */
public class AbstractOrderedMapIteratorDecorator implements OrderedMapIterator {
    protected final OrderedMapIterator iterator;

    public AbstractOrderedMapIteratorDecorator(OrderedMapIterator orderedMapIterator) {
        if (orderedMapIterator == null) {
            throw new IllegalArgumentException("OrderedMapIterator must not be null");
        }
        this.iterator = orderedMapIterator;
    }

    protected OrderedMapIterator getOrderedMapIterator() {
        return this.iterator;
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

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
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
        return this.iterator.setValue(obj);
    }
}
