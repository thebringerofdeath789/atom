package org.apache.commons.collections.bidimap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections.map.UnmodifiableEntrySet;
import org.apache.commons.collections.set.UnmodifiableSet;

/* loaded from: classes4.dex */
public final class UnmodifiableOrderedBidiMap extends AbstractOrderedBidiMapDecorator implements Unmodifiable {
    private UnmodifiableOrderedBidiMap inverse;

    public static OrderedBidiMap decorate(OrderedBidiMap orderedBidiMap) {
        return orderedBidiMap instanceof Unmodifiable ? orderedBidiMap : new UnmodifiableOrderedBidiMap(orderedBidiMap);
    }

    private UnmodifiableOrderedBidiMap(OrderedBidiMap orderedBidiMap) {
        super(orderedBidiMap);
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections.BidiMap
    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Set entrySet() {
        return UnmodifiableEntrySet.decorate(super.entrySet());
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Set keySet() {
        return UnmodifiableSet.decorate(super.keySet());
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Collection values() {
        return UnmodifiableCollection.decorate(super.values());
    }

    @Override // org.apache.commons.collections.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections.BidiMap
    public Object removeValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections.BidiMap, org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return orderedMapIterator();
    }

    @Override // org.apache.commons.collections.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections.BidiMap
    public BidiMap inverseBidiMap() {
        return inverseOrderedBidiMap();
    }

    @Override // org.apache.commons.collections.bidimap.AbstractOrderedBidiMapDecorator, org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        return UnmodifiableOrderedMapIterator.decorate(getOrderedBidiMap().orderedMapIterator());
    }

    @Override // org.apache.commons.collections.bidimap.AbstractOrderedBidiMapDecorator, org.apache.commons.collections.OrderedBidiMap
    public OrderedBidiMap inverseOrderedBidiMap() {
        if (this.inverse == null) {
            UnmodifiableOrderedBidiMap unmodifiableOrderedBidiMap = new UnmodifiableOrderedBidiMap(getOrderedBidiMap().inverseOrderedBidiMap());
            this.inverse = unmodifiableOrderedBidiMap;
            unmodifiableOrderedBidiMap.inverse = this;
        }
        return this.inverse;
    }
}
