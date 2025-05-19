package org.apache.commons.collections.iterators;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.Unmodifiable;

/* loaded from: classes4.dex */
public final class UnmodifiableMapIterator implements MapIterator, Unmodifiable {
    private MapIterator iterator;

    public static MapIterator decorate(MapIterator mapIterator) {
        if (mapIterator != null) {
            return mapIterator instanceof Unmodifiable ? mapIterator : new UnmodifiableMapIterator(mapIterator);
        }
        throw new IllegalArgumentException("MapIterator must not be null");
    }

    private UnmodifiableMapIterator(MapIterator mapIterator) {
        this.iterator = mapIterator;
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public Object next() {
        return this.iterator.next();
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
