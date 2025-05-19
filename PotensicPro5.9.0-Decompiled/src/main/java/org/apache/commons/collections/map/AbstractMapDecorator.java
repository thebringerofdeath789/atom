package org.apache.commons.collections.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class AbstractMapDecorator implements Map {
    protected transient Map map;

    protected AbstractMapDecorator() {
    }

    public AbstractMapDecorator(Map map) {
        if (map == null) {
            throw new IllegalArgumentException("Map must not be null");
        }
        this.map = map;
    }

    protected Map getMap() {
        return this.map;
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.map.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map, org.apache.commons.collections.BidiMap
    public Object put(Object obj, Object obj2) {
        return this.map.put(obj, obj2);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        this.map.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public Collection values() {
        return this.map.values();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.map.equals(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return this.map.toString();
    }
}
