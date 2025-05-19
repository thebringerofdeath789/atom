package org.apache.commons.collections.bidimap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections.map.UnmodifiableEntrySet;
import org.apache.commons.collections.set.UnmodifiableSet;

/* loaded from: classes4.dex */
public final class UnmodifiableBidiMap extends AbstractBidiMapDecorator implements Unmodifiable {
    private UnmodifiableBidiMap inverse;

    public static BidiMap decorate(BidiMap bidiMap) {
        return bidiMap instanceof Unmodifiable ? bidiMap : new UnmodifiableBidiMap(bidiMap);
    }

    private UnmodifiableBidiMap(BidiMap bidiMap) {
        super(bidiMap);
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
        return UnmodifiableMapIterator.decorate(getBidiMap().mapIterator());
    }

    @Override // org.apache.commons.collections.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections.BidiMap
    public BidiMap inverseBidiMap() {
        if (this.inverse == null) {
            UnmodifiableBidiMap unmodifiableBidiMap = new UnmodifiableBidiMap(getBidiMap().inverseBidiMap());
            this.inverse = unmodifiableBidiMap;
            unmodifiableBidiMap.inverse = this;
        }
        return this.inverse;
    }
}
