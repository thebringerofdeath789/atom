package org.apache.commons.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class ProxyMap implements Map {
    protected Map map;

    public ProxyMap(Map map) {
        this.map = map;
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
    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.map.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
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
}
