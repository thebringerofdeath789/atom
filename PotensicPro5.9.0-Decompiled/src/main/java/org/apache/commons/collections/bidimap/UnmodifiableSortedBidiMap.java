package org.apache.commons.collections.bidimap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.SortedBidiMap;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections.map.UnmodifiableEntrySet;
import org.apache.commons.collections.map.UnmodifiableSortedMap;
import org.apache.commons.collections.set.UnmodifiableSet;

/* loaded from: classes4.dex */
public final class UnmodifiableSortedBidiMap extends AbstractSortedBidiMapDecorator implements Unmodifiable {
    private UnmodifiableSortedBidiMap inverse;

    public static SortedBidiMap decorate(SortedBidiMap sortedBidiMap) {
        return sortedBidiMap instanceof Unmodifiable ? sortedBidiMap : new UnmodifiableSortedBidiMap(sortedBidiMap);
    }

    private UnmodifiableSortedBidiMap(SortedBidiMap sortedBidiMap) {
        super(sortedBidiMap);
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
        return inverseSortedBidiMap();
    }

    @Override // org.apache.commons.collections.bidimap.AbstractOrderedBidiMapDecorator, org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        return UnmodifiableOrderedMapIterator.decorate(getSortedBidiMap().orderedMapIterator());
    }

    @Override // org.apache.commons.collections.bidimap.AbstractOrderedBidiMapDecorator, org.apache.commons.collections.OrderedBidiMap
    public OrderedBidiMap inverseOrderedBidiMap() {
        return inverseSortedBidiMap();
    }

    @Override // org.apache.commons.collections.bidimap.AbstractSortedBidiMapDecorator, org.apache.commons.collections.SortedBidiMap
    public SortedBidiMap inverseSortedBidiMap() {
        if (this.inverse == null) {
            UnmodifiableSortedBidiMap unmodifiableSortedBidiMap = new UnmodifiableSortedBidiMap(getSortedBidiMap().inverseSortedBidiMap());
            this.inverse = unmodifiableSortedBidiMap;
            unmodifiableSortedBidiMap.inverse = this;
        }
        return this.inverse;
    }

    @Override // org.apache.commons.collections.bidimap.AbstractSortedBidiMapDecorator, java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        return UnmodifiableSortedMap.decorate(getSortedBidiMap().subMap(obj, obj2));
    }

    @Override // org.apache.commons.collections.bidimap.AbstractSortedBidiMapDecorator, java.util.SortedMap
    public SortedMap headMap(Object obj) {
        return UnmodifiableSortedMap.decorate(getSortedBidiMap().headMap(obj));
    }

    @Override // org.apache.commons.collections.bidimap.AbstractSortedBidiMapDecorator, java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        return UnmodifiableSortedMap.decorate(getSortedBidiMap().tailMap(obj));
    }
}
