package org.apache.commons.collections.map;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections.KeyValue;

/* loaded from: classes4.dex */
public final class StaticBucketMap implements Map {
    private static final int DEFAULT_BUCKETS = 255;
    private Node[] buckets;
    private Lock[] locks;

    public StaticBucketMap() {
        this(255);
    }

    public StaticBucketMap(int i) {
        int max = Math.max(17, i);
        max = max % 2 == 0 ? max - 1 : max;
        this.buckets = new Node[max];
        this.locks = new Lock[max];
        for (int i2 = 0; i2 < max; i2++) {
            this.locks[i2] = new Lock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getHash(Object obj) {
        if (obj == null) {
            return 0;
        }
        int hashCode = obj.hashCode();
        int i = hashCode + (~(hashCode << 15));
        int i2 = i ^ (i >>> 10);
        int i3 = i2 + (i2 << 3);
        int i4 = i3 ^ (i3 >>> 6);
        int i5 = i4 + (~(i4 << 11));
        int length = (i5 ^ (i5 >>> 16)) % this.buckets.length;
        return length < 0 ? length * (-1) : length;
    }

    @Override // java.util.Map
    public int size() {
        int i = 0;
        for (int i2 = 0; i2 < this.buckets.length; i2++) {
            synchronized (this.locks[i2]) {
                i += this.locks[i2].size;
            }
        }
        return i;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            for (Node node = this.buckets[hash]; node != null; node = node.next) {
                if (node.key != obj && (node.key == null || !node.key.equals(obj))) {
                }
                return node.value;
            }
            return null;
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            for (Node node = this.buckets[hash]; node != null; node = node.next) {
                if (node.key != obj && (node.key == null || !node.key.equals(obj))) {
                }
                return true;
            }
            return false;
        }
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        for (int i = 0; i < this.buckets.length; i++) {
            synchronized (this.locks[i]) {
                for (Node node = this.buckets[i]; node != null; node = node.next) {
                    if (node.value != obj && (node.value == null || !node.value.equals(obj))) {
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            Node node = this.buckets[hash];
            if (node == null) {
                Node node2 = new Node();
                node2.key = obj;
                node2.value = obj2;
                this.buckets[hash] = node2;
                this.locks[hash].size++;
                return null;
            }
            Node node3 = node;
            while (node != null) {
                if (node.key != obj && (node.key == null || !node.key.equals(obj))) {
                    node3 = node;
                    node = node.next;
                }
                Object obj3 = node.value;
                node.value = obj2;
                return obj3;
            }
            Node node4 = new Node();
            node4.key = obj;
            node4.value = obj2;
            node3.next = node4;
            this.locks[hash].size++;
            return null;
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            Node node = null;
            for (Node node2 = this.buckets[hash]; node2 != null; node2 = node2.next) {
                if (node2.key != obj && (node2.key == null || !node2.key.equals(obj))) {
                    node = node2;
                }
                if (node == null) {
                    this.buckets[hash] = node2.next;
                } else {
                    node.next = node2.next;
                }
                Lock lock = this.locks[hash];
                lock.size--;
                return node2.value;
            }
            return null;
        }
    }

    @Override // java.util.Map
    public Set keySet() {
        return new KeySet();
    }

    @Override // java.util.Map
    public Collection values() {
        return new Values();
    }

    @Override // java.util.Map
    public Set entrySet() {
        return new EntrySet();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        for (Object obj : map.keySet()) {
            put(obj, map.get(obj));
        }
    }

    @Override // java.util.Map
    public void clear() {
        for (int i = 0; i < this.buckets.length; i++) {
            Lock lock = this.locks[i];
            synchronized (lock) {
                this.buckets[i] = null;
                lock.size = 0;
            }
        }
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.buckets.length; i2++) {
            synchronized (this.locks[i2]) {
                for (Node node = this.buckets[i2]; node != null; node = node.next) {
                    i += node.hashCode();
                }
            }
        }
        return i;
    }

    private static final class Node implements Map.Entry, KeyValue {
        protected Object key;
        protected Node next;
        protected Object value;

        private Node() {
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
        public Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
        public Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.key;
            int hashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.value;
            return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.key;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.value;
                Object value = entry.getValue();
                if (obj3 == null) {
                    if (value == null) {
                        return true;
                    }
                } else if (obj3.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }
    }

    private static final class Lock {
        public int size;

        private Lock() {
        }
    }

    private class EntryIterator implements Iterator {
        private int bucket;
        private ArrayList current;
        private Map.Entry last;

        private EntryIterator() {
            this.current = new ArrayList();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.current.size() > 0) {
                return true;
            }
            while (this.bucket < StaticBucketMap.this.buckets.length) {
                synchronized (StaticBucketMap.this.locks[this.bucket]) {
                    for (Node node = StaticBucketMap.this.buckets[this.bucket]; node != null; node = node.next) {
                        this.current.add(node);
                    }
                    this.bucket++;
                    if (this.current.size() > 0) {
                        return true;
                    }
                }
            }
            return false;
        }

        protected Map.Entry nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Map.Entry entry = (Map.Entry) this.current.remove(r0.size() - 1);
            this.last = entry;
            return entry;
        }

        @Override // java.util.Iterator
        public Object next() {
            return nextEntry();
        }

        @Override // java.util.Iterator
        public void remove() {
            Map.Entry entry = this.last;
            if (entry == null) {
                throw new IllegalStateException();
            }
            StaticBucketMap.this.remove(entry.getKey());
            this.last = null;
        }
    }

    private class ValueIterator extends EntryIterator {
        private final /* synthetic */ StaticBucketMap this$0;

        private ValueIterator(StaticBucketMap staticBucketMap) {
            super();
            this.this$0 = staticBucketMap;
        }

        @Override // org.apache.commons.collections.map.StaticBucketMap.EntryIterator, java.util.Iterator
        public Object next() {
            return nextEntry().getValue();
        }
    }

    private class KeyIterator extends EntryIterator {
        private final /* synthetic */ StaticBucketMap this$0;

        private KeyIterator(StaticBucketMap staticBucketMap) {
            super();
            this.this$0 = staticBucketMap;
        }

        @Override // org.apache.commons.collections.map.StaticBucketMap.EntryIterator, java.util.Iterator
        public Object next() {
            return nextEntry().getKey();
        }
    }

    private class EntrySet extends AbstractSet {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    if (node.equals(entry)) {
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    if (node.equals(entry)) {
                        StaticBucketMap.this.remove(node.getKey());
                        return true;
                    }
                }
                return false;
            }
        }
    }

    private class KeySet extends AbstractSet {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StaticBucketMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int hash = StaticBucketMap.this.getHash(obj);
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    Object key = node.getKey();
                    if (key != obj && (key == null || !key.equals(obj))) {
                    }
                    StaticBucketMap.this.remove(key);
                    return true;
                }
                return false;
            }
        }
    }

    private class Values extends AbstractCollection {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return StaticBucketMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new ValueIterator();
        }
    }

    public void atomic(Runnable runnable) {
        Objects.requireNonNull(runnable);
        atomic(runnable, 0);
    }

    private void atomic(Runnable runnable, int i) {
        if (i >= this.buckets.length) {
            runnable.run();
            return;
        }
        synchronized (this.locks[i]) {
            atomic(runnable, i + 1);
        }
    }
}
