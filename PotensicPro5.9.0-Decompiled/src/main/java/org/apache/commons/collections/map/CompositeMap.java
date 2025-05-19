package org.apache.commons.collections.map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.collection.CompositeCollection;
import org.apache.commons.collections.set.CompositeSet;

/* loaded from: classes4.dex */
public class CompositeMap implements Map {
    private Map[] composite;
    private MapMutator mutator;

    public interface MapMutator {
        Object put(CompositeMap compositeMap, Map[] mapArr, Object obj, Object obj2);

        void putAll(CompositeMap compositeMap, Map[] mapArr, Map map);

        void resolveCollision(CompositeMap compositeMap, Map map, Map map2, Collection collection);
    }

    public CompositeMap() {
        this(new Map[0], (MapMutator) null);
    }

    public CompositeMap(Map map, Map map2) {
        this(new Map[]{map, map2}, (MapMutator) null);
    }

    public CompositeMap(Map map, Map map2, MapMutator mapMutator) {
        this(new Map[]{map, map2}, mapMutator);
    }

    public CompositeMap(Map[] mapArr) {
        this(mapArr, (MapMutator) null);
    }

    public CompositeMap(Map[] mapArr, MapMutator mapMutator) {
        this.mutator = mapMutator;
        this.composite = new Map[0];
        for (int length = mapArr.length - 1; length >= 0; length--) {
            addComposited(mapArr[length]);
        }
    }

    public void setMutator(MapMutator mapMutator) {
        this.mutator = mapMutator;
    }

    public synchronized void addComposited(Map map) throws IllegalArgumentException {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            Collection intersection = CollectionUtils.intersection(this.composite[length].keySet(), map.keySet());
            if (intersection.size() != 0) {
                MapMutator mapMutator = this.mutator;
                if (mapMutator == null) {
                    throw new IllegalArgumentException("Key collision adding Map to CompositeMap");
                }
                mapMutator.resolveCollision(this, this.composite[length], map, intersection);
            }
        }
        Map[] mapArr = this.composite;
        int length2 = mapArr.length + 1;
        Map[] mapArr2 = new Map[length2];
        System.arraycopy(mapArr, 0, mapArr2, 0, mapArr.length);
        mapArr2[length2 - 1] = map;
        this.composite = mapArr2;
    }

    public synchronized Map removeComposited(Map map) {
        int length = this.composite.length;
        for (int i = 0; i < length; i++) {
            if (this.composite[i].equals(map)) {
                Map[] mapArr = new Map[length - 1];
                System.arraycopy(this.composite, 0, mapArr, 0, i);
                System.arraycopy(this.composite, i + 1, mapArr, i, (length - i) - 1);
                this.composite = mapArr;
                return map;
            }
        }
        return null;
    }

    @Override // java.util.Map
    public void clear() {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            this.composite[length].clear();
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set entrySet() {
        CompositeSet compositeSet = new CompositeSet();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeSet.addComposited(this.composite[length].entrySet());
        }
        return compositeSet;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return this.composite[length].get(obj);
            }
        }
        return null;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (!this.composite[length].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public Set keySet() {
        CompositeSet compositeSet = new CompositeSet();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeSet.addComposited(this.composite[length].keySet());
        }
        return compositeSet;
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        MapMutator mapMutator = this.mutator;
        if (mapMutator == null) {
            throw new UnsupportedOperationException("No mutator specified");
        }
        return mapMutator.put(this, this.composite, obj, obj2);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        MapMutator mapMutator = this.mutator;
        if (mapMutator == null) {
            throw new UnsupportedOperationException("No mutator specified");
        }
        mapMutator.putAll(this, this.composite, map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return this.composite[length].remove(obj);
            }
        }
        return null;
    }

    @Override // java.util.Map
    public int size() {
        int i = 0;
        for (int length = this.composite.length - 1; length >= 0; length--) {
            i += this.composite[length].size();
        }
        return i;
    }

    @Override // java.util.Map
    public Collection values() {
        CompositeCollection compositeCollection = new CompositeCollection();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeCollection.addComposited(this.composite[length].values());
        }
        return compositeCollection;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public int hashCode() {
        Iterator it = entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }
}
