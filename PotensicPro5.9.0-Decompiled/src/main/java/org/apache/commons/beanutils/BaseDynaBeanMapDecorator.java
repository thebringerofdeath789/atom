package org.apache.commons.beanutils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class BaseDynaBeanMapDecorator<K> implements Map<K, Object> {
    private final DynaBean dynaBean;
    private transient Set<K> keySet;
    private final boolean readOnly;

    protected abstract K convertKey(String str);

    public BaseDynaBeanMapDecorator(DynaBean dynaBean) {
        this(dynaBean, true);
    }

    public BaseDynaBeanMapDecorator(DynaBean dynaBean, boolean z) {
        if (dynaBean == null) {
            throw new IllegalArgumentException("DynaBean is null");
        }
        this.dynaBean = dynaBean;
        this.readOnly = z;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return getDynaBean().getDynaClass().getDynaProperty(toString(obj)) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        for (DynaProperty dynaProperty : getDynaProperties()) {
            Object obj2 = getDynaBean().get(dynaProperty.getName());
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
            } else if (obj.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, Object>> entrySet() {
        DynaProperty[] dynaProperties = getDynaProperties();
        HashSet hashSet = new HashSet(dynaProperties.length);
        for (DynaProperty dynaProperty : dynaProperties) {
            hashSet.add(new MapEntry(convertKey(dynaProperty.getName()), getDynaBean().get(dynaProperty.getName())));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return getDynaBean().get(toString(obj));
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getDynaProperties().length == 0;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        DynaProperty[] dynaProperties = getDynaProperties();
        HashSet hashSet = new HashSet(dynaProperties.length);
        for (DynaProperty dynaProperty : dynaProperties) {
            hashSet.add(convertKey(dynaProperty.getName()));
        }
        Set<K> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        if (!(getDynaBean().getDynaClass() instanceof MutableDynaClass)) {
            this.keySet = unmodifiableSet;
        }
        return unmodifiableSet;
    }

    @Override // java.util.Map
    public Object put(K k, Object obj) {
        if (isReadOnly()) {
            throw new UnsupportedOperationException("Map is read only");
        }
        String baseDynaBeanMapDecorator = toString(k);
        Object obj2 = getDynaBean().get(baseDynaBeanMapDecorator);
        getDynaBean().set(baseDynaBeanMapDecorator, obj);
        return obj2;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends Object> map) {
        if (isReadOnly()) {
            throw new UnsupportedOperationException("Map is read only");
        }
        for (Map.Entry<? extends K, ? extends Object> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return getDynaProperties().length;
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        DynaProperty[] dynaProperties = getDynaProperties();
        ArrayList arrayList = new ArrayList(dynaProperties.length);
        for (DynaProperty dynaProperty : dynaProperties) {
            arrayList.add(getDynaBean().get(dynaProperty.getName()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public DynaBean getDynaBean() {
        return this.dynaBean;
    }

    private DynaProperty[] getDynaProperties() {
        return getDynaBean().getDynaClass().getDynaProperties();
    }

    private String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    private static class MapEntry<K> implements Map.Entry<K, Object> {
        private final K key;
        private final Object value;

        MapEntry(K k, Object obj) {
            this.key = k;
            this.value = obj;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!this.key.equals(entry.getKey())) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!obj2.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode = this.key.hashCode();
            Object obj = this.value;
            return hashCode + (obj == null ? 0 : obj.hashCode());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }
    }
}
