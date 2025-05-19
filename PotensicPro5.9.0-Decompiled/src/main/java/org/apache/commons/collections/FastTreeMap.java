package org.apache.commons.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public class FastTreeMap extends TreeMap {
    protected boolean fast = false;
    protected TreeMap map;

    public FastTreeMap() {
        this.map = null;
        this.map = new TreeMap();
    }

    public FastTreeMap(Comparator comparator) {
        this.map = null;
        this.map = new TreeMap(comparator);
    }

    public FastTreeMap(Map map) {
        this.map = null;
        this.map = new TreeMap(map);
    }

    public FastTreeMap(SortedMap sortedMap) {
        this.map = null;
        this.map = new TreeMap(sortedMap);
    }

    public boolean getFast() {
        return this.fast;
    }

    public void setFast(boolean z) {
        this.fast = z;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
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

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
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

    @Override // java.util.AbstractMap, java.util.Map
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

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
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

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
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

    @Override // java.util.TreeMap, java.util.SortedMap
    public Comparator comparator() {
        Comparator comparator;
        if (this.fast) {
            return this.map.comparator();
        }
        synchronized (this.map) {
            comparator = this.map.comparator();
        }
        return comparator;
    }

    @Override // java.util.TreeMap, java.util.SortedMap
    public Object firstKey() {
        Object firstKey;
        if (this.fast) {
            return this.map.firstKey();
        }
        synchronized (this.map) {
            firstKey = this.map.firstKey();
        }
        return firstKey;
    }

    @Override // java.util.TreeMap, java.util.SortedMap
    public Object lastKey() {
        Object lastKey;
        if (this.fast) {
            return this.map.lastKey();
        }
        synchronized (this.map) {
            lastKey = this.map.lastKey();
        }
        return lastKey;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Object put;
        Object put2;
        if (this.fast) {
            synchronized (this) {
                TreeMap treeMap = (TreeMap) this.map.clone();
                put2 = treeMap.put(obj, obj2);
                this.map = treeMap;
            }
            return put2;
        }
        synchronized (this.map) {
            put = this.map.put(obj, obj2);
        }
        return put;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        if (this.fast) {
            synchronized (this) {
                TreeMap treeMap = (TreeMap) this.map.clone();
                treeMap.putAll(map);
                this.map = treeMap;
            }
            return;
        }
        synchronized (this.map) {
            this.map.putAll(map);
        }
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Object remove;
        Object remove2;
        if (this.fast) {
            synchronized (this) {
                TreeMap treeMap = (TreeMap) this.map.clone();
                remove2 = treeMap.remove(obj);
                this.map = treeMap;
            }
            return remove2;
        }
        synchronized (this.map) {
            remove = this.map.remove(obj);
        }
        return remove;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (this.fast) {
            synchronized (this) {
                this.map = new TreeMap();
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

    @Override // java.util.TreeMap, java.util.AbstractMap
    public Object clone() {
        FastTreeMap fastTreeMap;
        FastTreeMap fastTreeMap2;
        if (this.fast) {
            fastTreeMap2 = new FastTreeMap((SortedMap) this.map);
        } else {
            synchronized (this.map) {
                fastTreeMap = new FastTreeMap((SortedMap) this.map);
            }
            fastTreeMap2 = fastTreeMap;
        }
        fastTreeMap2.setFast(getFast());
        return fastTreeMap2;
    }

    @Override // java.util.TreeMap, java.util.NavigableMap, java.util.SortedMap
    public SortedMap headMap(Object obj) {
        SortedMap headMap;
        if (this.fast) {
            return this.map.headMap(obj);
        }
        synchronized (this.map) {
            headMap = this.map.headMap(obj);
        }
        return headMap;
    }

    @Override // java.util.TreeMap, java.util.NavigableMap, java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        SortedMap subMap;
        if (this.fast) {
            return this.map.subMap(obj, obj2);
        }
        synchronized (this.map) {
            subMap = this.map.subMap(obj, obj2);
        }
        return subMap;
    }

    @Override // java.util.TreeMap, java.util.NavigableMap, java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        SortedMap tailMap;
        if (this.fast) {
            return this.map.tailMap(obj);
        }
        synchronized (this.map) {
            tailMap = this.map.tailMap(obj);
        }
        return tailMap;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set entrySet() {
        return new EntrySet();
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set keySet() {
        return new KeySet();
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map, java.util.SortedMap
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
            if (FastTreeMap.this.fast) {
                synchronized (FastTreeMap.this) {
                    FastTreeMap.this.map = new TreeMap();
                }
                return;
            }
            synchronized (FastTreeMap.this.map) {
                get(FastTreeMap.this.map).clear();
            }
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            boolean remove;
            boolean remove2;
            if (FastTreeMap.this.fast) {
                synchronized (FastTreeMap.this) {
                    TreeMap treeMap = (TreeMap) FastTreeMap.this.map.clone();
                    remove2 = get(treeMap).remove(obj);
                    FastTreeMap.this.map = treeMap;
                }
                return remove2;
            }
            synchronized (FastTreeMap.this.map) {
                remove = get(FastTreeMap.this.map).remove(obj);
            }
            return remove;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            boolean removeAll;
            boolean removeAll2;
            if (FastTreeMap.this.fast) {
                synchronized (FastTreeMap.this) {
                    TreeMap treeMap = (TreeMap) FastTreeMap.this.map.clone();
                    removeAll2 = get(treeMap).removeAll(collection);
                    FastTreeMap.this.map = treeMap;
                }
                return removeAll2;
            }
            synchronized (FastTreeMap.this.map) {
                removeAll = get(FastTreeMap.this.map).removeAll(collection);
            }
            return removeAll;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            boolean retainAll;
            boolean retainAll2;
            if (FastTreeMap.this.fast) {
                synchronized (FastTreeMap.this) {
                    TreeMap treeMap = (TreeMap) FastTreeMap.this.map.clone();
                    retainAll2 = get(treeMap).retainAll(collection);
                    FastTreeMap.this.map = treeMap;
                }
                return retainAll2;
            }
            synchronized (FastTreeMap.this.map) {
                retainAll = get(FastTreeMap.this.map).retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            if (FastTreeMap.this.fast) {
                return get(FastTreeMap.this.map).size();
            }
            synchronized (FastTreeMap.this.map) {
                size = get(FastTreeMap.this.map).size();
            }
            return size;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean isEmpty;
            if (FastTreeMap.this.fast) {
                return get(FastTreeMap.this.map).isEmpty();
            }
            synchronized (FastTreeMap.this.map) {
                isEmpty = get(FastTreeMap.this.map).isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            boolean contains;
            if (FastTreeMap.this.fast) {
                return get(FastTreeMap.this.map).contains(obj);
            }
            synchronized (FastTreeMap.this.map) {
                contains = get(FastTreeMap.this.map).contains(obj);
            }
            return contains;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            boolean containsAll;
            if (FastTreeMap.this.fast) {
                return get(FastTreeMap.this.map).containsAll(collection);
            }
            synchronized (FastTreeMap.this.map) {
                containsAll = get(FastTreeMap.this.map).containsAll(collection);
            }
            return containsAll;
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            Object[] array;
            if (FastTreeMap.this.fast) {
                return get(FastTreeMap.this.map).toArray(objArr);
            }
            synchronized (FastTreeMap.this.map) {
                array = get(FastTreeMap.this.map).toArray(objArr);
            }
            return array;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Object[] array;
            if (FastTreeMap.this.fast) {
                return get(FastTreeMap.this.map).toArray();
            }
            synchronized (FastTreeMap.this.map) {
                array = get(FastTreeMap.this.map).toArray();
            }
            return array;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            if (FastTreeMap.this.fast) {
                return get(FastTreeMap.this.map).equals(obj);
            }
            synchronized (FastTreeMap.this.map) {
                equals = get(FastTreeMap.this.map).equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection
        public int hashCode() {
            int hashCode;
            if (FastTreeMap.this.fast) {
                return get(FastTreeMap.this.map).hashCode();
            }
            synchronized (FastTreeMap.this.map) {
                hashCode = get(FastTreeMap.this.map).hashCode();
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
                TreeMap treeMap = FastTreeMap.this.map;
                this.expected = treeMap;
                this.iterator = treeMap.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.expected != FastTreeMap.this.map) {
                    throw new ConcurrentModificationException();
                }
                return this.iterator.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                if (this.expected != FastTreeMap.this.map) {
                    throw new ConcurrentModificationException();
                }
                Map.Entry entry = (Map.Entry) this.iterator.next();
                this.lastReturned = entry;
                return CollectionView.this.iteratorNext(entry);
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.lastReturned != null) {
                    if (FastTreeMap.this.fast) {
                        synchronized (FastTreeMap.this) {
                            if (this.expected == FastTreeMap.this.map) {
                                FastTreeMap.this.remove(this.lastReturned.getKey());
                                this.lastReturned = null;
                                this.expected = FastTreeMap.this.map;
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
        private final /* synthetic */ FastTreeMap this$0;

        private KeySet(FastTreeMap fastTreeMap) {
            super();
            this.this$0 = fastTreeMap;
        }

        @Override // org.apache.commons.collections.FastTreeMap.CollectionView
        protected Collection get(Map map) {
            return map.keySet();
        }

        @Override // org.apache.commons.collections.FastTreeMap.CollectionView
        protected Object iteratorNext(Map.Entry entry) {
            return entry.getKey();
        }
    }

    private class Values extends CollectionView {
        private final /* synthetic */ FastTreeMap this$0;

        private Values(FastTreeMap fastTreeMap) {
            super();
            this.this$0 = fastTreeMap;
        }

        @Override // org.apache.commons.collections.FastTreeMap.CollectionView
        protected Collection get(Map map) {
            return map.values();
        }

        @Override // org.apache.commons.collections.FastTreeMap.CollectionView
        protected Object iteratorNext(Map.Entry entry) {
            return entry.getValue();
        }
    }

    private class EntrySet extends CollectionView implements Set {
        private final /* synthetic */ FastTreeMap this$0;

        @Override // org.apache.commons.collections.FastTreeMap.CollectionView
        protected Object iteratorNext(Map.Entry entry) {
            return entry;
        }

        private EntrySet(FastTreeMap fastTreeMap) {
            super();
            this.this$0 = fastTreeMap;
        }

        @Override // org.apache.commons.collections.FastTreeMap.CollectionView
        protected Collection get(Map map) {
            return map.entrySet();
        }
    }
}
