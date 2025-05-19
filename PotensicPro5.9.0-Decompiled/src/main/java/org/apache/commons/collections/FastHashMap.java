package org.apache.commons.collections;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class FastHashMap extends HashMap {
    protected boolean fast = false;
    protected HashMap map;

    public FastHashMap() {
        this.map = null;
        this.map = new HashMap();
    }

    public FastHashMap(int i) {
        this.map = null;
        this.map = new HashMap(i);
    }

    public FastHashMap(int i, float f) {
        this.map = null;
        this.map = new HashMap(i, f);
    }

    public FastHashMap(Map map) {
        this.map = null;
        this.map = new HashMap(map);
    }

    public boolean getFast() {
        return this.fast;
    }

    public void setFast(boolean z) {
        this.fast = z;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Object obj2;
        if (this.fast) {
            return this.map.get(obj);
        }
        synchronized (this.map) {
            obj2 = this.map.get(obj);
        }
        return obj2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public int size() {
        int size;
        if (this.fast) {
            return this.map.size();
        }
        synchronized (this.map) {
            size = this.map.size();
        }
        return size;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        boolean isEmpty;
        if (this.fast) {
            return this.map.isEmpty();
        }
        synchronized (this.map) {
            isEmpty = this.map.isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        boolean containsKey;
        if (this.fast) {
            return this.map.containsKey(obj);
        }
        synchronized (this.map) {
            containsKey = this.map.containsKey(obj);
        }
        return containsKey;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean containsValue;
        if (this.fast) {
            return this.map.containsValue(obj);
        }
        synchronized (this.map) {
            containsValue = this.map.containsValue(obj);
        }
        return containsValue;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Object put;
        Object put2;
        if (this.fast) {
            synchronized (this) {
                HashMap hashMap = (HashMap) this.map.clone();
                put2 = hashMap.put(obj, obj2);
                this.map = hashMap;
            }
            return put2;
        }
        synchronized (this.map) {
            put = this.map.put(obj, obj2);
        }
        return put;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        if (this.fast) {
            synchronized (this) {
                HashMap hashMap = (HashMap) this.map.clone();
                hashMap.putAll(map);
                this.map = hashMap;
            }
            return;
        }
        synchronized (this.map) {
            this.map.putAll(map);
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Object remove;
        Object remove2;
        if (this.fast) {
            synchronized (this) {
                HashMap hashMap = (HashMap) this.map.clone();
                remove2 = hashMap.remove(obj);
                this.map = hashMap;
            }
            return remove2;
        }
        synchronized (this.map) {
            remove = this.map.remove(obj);
        }
        return remove;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (this.fast) {
            synchronized (this) {
                this.map = new HashMap();
            }
        } else {
            synchronized (this.map) {
                this.map.clear();
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this.fast) {
            if (map.size() != this.map.size()) {
                return false;
            }
            for (Map.Entry entry : this.map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    if (map.get(key) != null || !map.containsKey(key)) {
                        return false;
                    }
                } else if (!value.equals(map.get(key))) {
                    return false;
                }
            }
            return true;
        }
        synchronized (this.map) {
            if (map.size() != this.map.size()) {
                return false;
            }
            for (Map.Entry entry2 : this.map.entrySet()) {
                Object key2 = entry2.getKey();
                Object value2 = entry2.getValue();
                if (value2 == null) {
                    if (map.get(key2) != null || !map.containsKey(key2)) {
                        return false;
                    }
                } else if (!value2.equals(map.get(key2))) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int i = 0;
        if (this.fast) {
            Iterator it = this.map.entrySet().iterator();
            while (it.hasNext()) {
                i += it.next().hashCode();
            }
            return i;
        }
        synchronized (this.map) {
            Iterator it2 = this.map.entrySet().iterator();
            while (it2.hasNext()) {
                i += it2.next().hashCode();
            }
        }
        return i;
    }

    @Override // java.util.HashMap, java.util.AbstractMap
    public Object clone() {
        FastHashMap fastHashMap;
        FastHashMap fastHashMap2;
        if (this.fast) {
            fastHashMap2 = new FastHashMap(this.map);
        } else {
            synchronized (this.map) {
                fastHashMap = new FastHashMap(this.map);
            }
            fastHashMap2 = fastHashMap;
        }
        fastHashMap2.setFast(getFast());
        return fastHashMap2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        return new EntrySet();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set keySet() {
        return new KeySet();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Collection values() {
        return new Values();
    }

    private abstract class CollectionView implements Collection {
        protected abstract Collection get(Map map);

        protected abstract Object iteratorNext(Map.Entry entry);

        public CollectionView() {
        }

        @Override // java.util.Collection
        public void clear() {
            if (FastHashMap.this.fast) {
                synchronized (FastHashMap.this) {
                    FastHashMap.this.map = new HashMap();
                }
                return;
            }
            synchronized (FastHashMap.this.map) {
                get(FastHashMap.this.map).clear();
            }
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            boolean remove;
            boolean remove2;
            if (FastHashMap.this.fast) {
                synchronized (FastHashMap.this) {
                    HashMap hashMap = (HashMap) FastHashMap.this.map.clone();
                    remove2 = get(hashMap).remove(obj);
                    FastHashMap.this.map = hashMap;
                }
                return remove2;
            }
            synchronized (FastHashMap.this.map) {
                remove = get(FastHashMap.this.map).remove(obj);
            }
            return remove;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            boolean removeAll;
            boolean removeAll2;
            if (FastHashMap.this.fast) {
                synchronized (FastHashMap.this) {
                    HashMap hashMap = (HashMap) FastHashMap.this.map.clone();
                    removeAll2 = get(hashMap).removeAll(collection);
                    FastHashMap.this.map = hashMap;
                }
                return removeAll2;
            }
            synchronized (FastHashMap.this.map) {
                removeAll = get(FastHashMap.this.map).removeAll(collection);
            }
            return removeAll;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            boolean retainAll;
            boolean retainAll2;
            if (FastHashMap.this.fast) {
                synchronized (FastHashMap.this) {
                    HashMap hashMap = (HashMap) FastHashMap.this.map.clone();
                    retainAll2 = get(hashMap).retainAll(collection);
                    FastHashMap.this.map = hashMap;
                }
                return retainAll2;
            }
            synchronized (FastHashMap.this.map) {
                retainAll = get(FastHashMap.this.map).retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            if (FastHashMap.this.fast) {
                return get(FastHashMap.this.map).size();
            }
            synchronized (FastHashMap.this.map) {
                size = get(FastHashMap.this.map).size();
            }
            return size;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean isEmpty;
            if (FastHashMap.this.fast) {
                return get(FastHashMap.this.map).isEmpty();
            }
            synchronized (FastHashMap.this.map) {
                isEmpty = get(FastHashMap.this.map).isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            boolean contains;
            if (FastHashMap.this.fast) {
                return get(FastHashMap.this.map).contains(obj);
            }
            synchronized (FastHashMap.this.map) {
                contains = get(FastHashMap.this.map).contains(obj);
            }
            return contains;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            boolean containsAll;
            if (FastHashMap.this.fast) {
                return get(FastHashMap.this.map).containsAll(collection);
            }
            synchronized (FastHashMap.this.map) {
                containsAll = get(FastHashMap.this.map).containsAll(collection);
            }
            return containsAll;
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            Object[] array;
            if (FastHashMap.this.fast) {
                return get(FastHashMap.this.map).toArray(objArr);
            }
            synchronized (FastHashMap.this.map) {
                array = get(FastHashMap.this.map).toArray(objArr);
            }
            return array;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Object[] array;
            if (FastHashMap.this.fast) {
                return get(FastHashMap.this.map).toArray();
            }
            synchronized (FastHashMap.this.map) {
                array = get(FastHashMap.this.map).toArray();
            }
            return array;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            if (FastHashMap.this.fast) {
                return get(FastHashMap.this.map).equals(obj);
            }
            synchronized (FastHashMap.this.map) {
                equals = get(FastHashMap.this.map).equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection
        public int hashCode() {
            int hashCode;
            if (FastHashMap.this.fast) {
                return get(FastHashMap.this.map).hashCode();
            }
            synchronized (FastHashMap.this.map) {
                hashCode = get(FastHashMap.this.map).hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new CollectionViewIterator();
        }

        private class CollectionViewIterator implements Iterator {
            private Map expected;
            private Iterator iterator;
            private Map.Entry lastReturned = null;

            public CollectionViewIterator() {
                HashMap hashMap = FastHashMap.this.map;
                this.expected = hashMap;
                this.iterator = hashMap.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.expected != FastHashMap.this.map) {
                    throw new ConcurrentModificationException();
                }
                return this.iterator.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                if (this.expected != FastHashMap.this.map) {
                    throw new ConcurrentModificationException();
                }
                Map.Entry entry = (Map.Entry) this.iterator.next();
                this.lastReturned = entry;
                return CollectionView.this.iteratorNext(entry);
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.lastReturned != null) {
                    if (FastHashMap.this.fast) {
                        synchronized (FastHashMap.this) {
                            if (this.expected == FastHashMap.this.map) {
                                FastHashMap.this.remove(this.lastReturned.getKey());
                                this.lastReturned = null;
                                this.expected = FastHashMap.this.map;
                            } else {
                                throw new ConcurrentModificationException();
                            }
                        }
                        return;
                    }
                    this.iterator.remove();
                    this.lastReturned = null;
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    private class KeySet extends CollectionView implements Set {
        private final /* synthetic */ FastHashMap this$0;

        private KeySet(FastHashMap fastHashMap) {
            super();
            this.this$0 = fastHashMap;
        }

        @Override // org.apache.commons.collections.FastHashMap.CollectionView
        protected Collection get(Map map) {
            return map.keySet();
        }

        @Override // org.apache.commons.collections.FastHashMap.CollectionView
        protected Object iteratorNext(Map.Entry entry) {
            return entry.getKey();
        }
    }

    private class Values extends CollectionView {
        private final /* synthetic */ FastHashMap this$0;

        private Values(FastHashMap fastHashMap) {
            super();
            this.this$0 = fastHashMap;
        }

        @Override // org.apache.commons.collections.FastHashMap.CollectionView
        protected Collection get(Map map) {
            return map.values();
        }

        @Override // org.apache.commons.collections.FastHashMap.CollectionView
        protected Object iteratorNext(Map.Entry entry) {
            return entry.getValue();
        }
    }

    private class EntrySet extends CollectionView implements Set {
        private final /* synthetic */ FastHashMap this$0;

        @Override // org.apache.commons.collections.FastHashMap.CollectionView
        protected Object iteratorNext(Map.Entry entry) {
            return entry;
        }

        private EntrySet(FastHashMap fastHashMap) {
            super();
            this.this$0 = fastHashMap;
        }

        @Override // org.apache.commons.collections.FastHashMap.CollectionView
        protected Collection get(Map map) {
            return map.entrySet();
        }
    }
}
