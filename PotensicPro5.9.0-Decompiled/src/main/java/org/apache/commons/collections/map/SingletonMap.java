package org.apache.commons.collections.map;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections.BoundedMap;
import org.apache.commons.collections.KeyValue;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.iterators.SingletonIterator;
import org.apache.commons.collections.keyvalue.TiedMapEntry;

/* loaded from: classes4.dex */
public class SingletonMap implements OrderedMap, BoundedMap, KeyValue, Serializable, Cloneable {
    private static final long serialVersionUID = -8931271118676803261L;
    private final Object key;
    private Object value;

    @Override // java.util.Map
    public boolean isEmpty() {
        return false;
    }

    @Override // org.apache.commons.collections.BoundedMap
    public boolean isFull() {
        return true;
    }

    @Override // org.apache.commons.collections.BoundedMap
    public int maxSize() {
        return 1;
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object nextKey(Object obj) {
        return null;
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object previousKey(Object obj) {
        return null;
    }

    @Override // java.util.Map
    public int size() {
        return 1;
    }

    public SingletonMap() {
        this.key = null;
    }

    public SingletonMap(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    public SingletonMap(KeyValue keyValue) {
        this.key = keyValue.getKey();
        this.value = keyValue.getValue();
    }

    public SingletonMap(Map.Entry entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    public SingletonMap(Map map) {
        if (map.size() != 1) {
            throw new IllegalArgumentException("The map size must be 1");
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    @Override // org.apache.commons.collections.KeyValue
    public Object getKey() {
        return this.key;
    }

    @Override // org.apache.commons.collections.KeyValue
    public Object getValue() {
        return this.value;
    }

    public Object setValue(Object obj) {
        Object obj2 = this.value;
        this.value = obj;
        return obj2;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        if (isEqualKey(obj)) {
            return this.value;
        }
        return null;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return isEqualKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return isEqualValue(obj);
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        if (isEqualKey(obj)) {
            return setValue(obj2);
        }
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size singleton");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        int size = map.size();
        if (size != 0) {
            if (size == 1) {
                Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
                put(entry.getKey(), entry.getValue());
                return;
            }
            throw new IllegalArgumentException("The map size must be 0 or 1");
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Set entrySet() {
        return Collections.singleton(new TiedMapEntry(this, getKey()));
    }

    @Override // java.util.Map
    public Set keySet() {
        return Collections.singleton(this.key);
    }

    @Override // java.util.Map
    public Collection values() {
        return new SingletonValues(this);
    }

    @Override // org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return new SingletonMapIterator(this);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        return new SingletonMapIterator(this);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object firstKey() {
        return getKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object lastKey() {
        return getKey();
    }

    protected boolean isEqualKey(Object obj) {
        return obj == null ? getKey() == null : obj.equals(getKey());
    }

    protected boolean isEqualValue(Object obj) {
        return obj == null ? getValue() == null : obj.equals(getValue());
    }

    static class SingletonMapIterator implements OrderedMapIterator, ResettableIterator {
        private final SingletonMap parent;
        private boolean hasNext = true;
        private boolean canGetSet = false;

        SingletonMapIterator(SingletonMap singletonMap) {
            this.parent = singletonMap;
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public Object next() {
            if (!this.hasNext) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.hasNext = false;
            this.canGetSet = true;
            return this.parent.getKey();
        }

        @Override // org.apache.commons.collections.OrderedMapIterator, org.apache.commons.collections.OrderedIterator
        public boolean hasPrevious() {
            return !this.hasNext;
        }

        @Override // org.apache.commons.collections.OrderedMapIterator, org.apache.commons.collections.OrderedIterator
        public Object previous() {
            if (this.hasNext) {
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            this.hasNext = true;
            return this.parent.getKey();
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getKey() {
            if (!this.canGetSet) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            return this.parent.getKey();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getValue() {
            if (!this.canGetSet) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            return this.parent.getValue();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object setValue(Object obj) {
            if (!this.canGetSet) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            return this.parent.setValue(obj);
        }

        @Override // org.apache.commons.collections.ResettableIterator
        public void reset() {
            this.hasNext = true;
        }

        public String toString() {
            return this.hasNext ? "Iterator[]" : new StringBuffer().append("Iterator[").append(getKey()).append("=").append(getValue()).append("]").toString();
        }
    }

    static class SingletonValues extends AbstractSet implements Serializable {
        private static final long serialVersionUID = -3689524741863047872L;
        private final SingletonMap parent;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        SingletonValues(SingletonMap singletonMap) {
            this.parent = singletonMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new SingletonIterator(this.parent.getValue(), false);
        }
    }

    public Object clone() {
        try {
            return (SingletonMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != 1) {
            return false;
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        return isEqualKey(entry.getKey()) && isEqualValue(entry.getValue());
    }

    @Override // java.util.Map
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    public String toString() {
        return new StringBuffer(128).append('{').append(getKey() == this ? "(this Map)" : getKey()).append('=').append(getValue() != this ? getValue() : "(this Map)").append('}').toString();
    }
}
