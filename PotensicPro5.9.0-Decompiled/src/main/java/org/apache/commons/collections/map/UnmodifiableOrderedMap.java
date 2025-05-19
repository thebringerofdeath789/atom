package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections.set.UnmodifiableSet;

/* loaded from: classes4.dex */
public final class UnmodifiableOrderedMap extends AbstractOrderedMapDecorator implements Unmodifiable, Serializable {
    private static final long serialVersionUID = 8136428161720526266L;

    public static OrderedMap decorate(OrderedMap orderedMap) {
        return orderedMap instanceof Unmodifiable ? orderedMap : new UnmodifiableOrderedMap(orderedMap);
    }

    private UnmodifiableOrderedMap(OrderedMap orderedMap) {
        super(orderedMap);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    @Override // org.apache.commons.collections.map.AbstractOrderedMapDecorator, org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return UnmodifiableMapIterator.decorate(getOrderedMap().mapIterator());
    }

    @Override // org.apache.commons.collections.map.AbstractOrderedMapDecorator, org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        return UnmodifiableOrderedMapIterator.decorate(getOrderedMap().orderedMapIterator());
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
}
