package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections.BoundedMap;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.set.UnmodifiableSet;

/* loaded from: classes4.dex */
public class FixedSizeSortedMap extends AbstractSortedMapDecorator implements SortedMap, BoundedMap, Serializable {
    private static final long serialVersionUID = 3126019624511683653L;

    @Override // org.apache.commons.collections.BoundedMap
    public boolean isFull() {
        return true;
    }

    public static SortedMap decorate(SortedMap sortedMap) {
        return new FixedSizeSortedMap(sortedMap);
    }

    protected FixedSizeSortedMap(SortedMap sortedMap) {
        super(sortedMap);
    }

    @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator
    protected SortedMap getSortedMap() {
        return (SortedMap) this.map;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections.BidiMap
    public Object put(Object obj, Object obj2) {
        if (!this.map.containsKey(obj)) {
            throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
        }
        return this.map.put(obj, obj2);
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map map) {
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
            }
        }
        this.map.putAll(map);
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Set entrySet() {
        return UnmodifiableSet.decorate(this.map.entrySet());
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Set keySet() {
        return UnmodifiableSet.decorate(this.map.keySet());
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Collection values() {
        return UnmodifiableCollection.decorate(this.map.values());
    }

    @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        return new FixedSizeSortedMap(getSortedMap().subMap(obj, obj2));
    }

    @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
    public SortedMap headMap(Object obj) {
        return new FixedSizeSortedMap(getSortedMap().headMap(obj));
    }

    @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        return new FixedSizeSortedMap(getSortedMap().tailMap(obj));
    }

    @Override // org.apache.commons.collections.BoundedMap
    public int maxSize() {
        return size();
    }
}
