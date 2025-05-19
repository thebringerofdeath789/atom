package org.dom4j.tree;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes5.dex */
class ConcurrentReaderHashMap extends AbstractMap implements Map, Cloneable, Serializable {
    public static int DEFAULT_INITIAL_CAPACITY = 32;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final int MINIMUM_CAPACITY = 4;
    protected final BarrierLock barrierLock;
    protected transient int count;
    protected transient Set entrySet;
    protected transient Set keySet;
    protected transient Object lastWrite;
    protected float loadFactor;
    protected transient Entry[] table;
    protected int threshold;
    protected transient Collection values;

    private int p2capacity(int i) {
        int i2 = 1073741824;
        if (i <= 1073741824 && i >= 0) {
            i2 = 4;
            while (i2 < i) {
                i2 <<= 1;
            }
        }
        return i2;
    }

    protected static class BarrierLock implements Serializable {
        protected BarrierLock() {
        }
    }

    protected final void recordModification(Object obj) {
        synchronized (this.barrierLock) {
            this.lastWrite = obj;
        }
    }

    protected final Entry[] getTableForReading() {
        Entry[] entryArr;
        synchronized (this.barrierLock) {
            entryArr = this.table;
        }
        return entryArr;
    }

    private static int hash(Object obj) {
        int hashCode = obj.hashCode();
        return ((hashCode << 7) - hashCode) + (hashCode >>> 9) + (hashCode >>> 17);
    }

    protected boolean eq(Object obj, Object obj2) {
        return obj == obj2 || obj.equals(obj2);
    }

    public ConcurrentReaderHashMap(int i, float f) {
        this.barrierLock = new BarrierLock();
        this.keySet = null;
        this.entrySet = null;
        this.values = null;
        if (f <= 0.0f) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal Load factor: ").append(f).toString());
        }
        this.loadFactor = f;
        int p2capacity = p2capacity(i);
        this.table = new Entry[p2capacity];
        this.threshold = (int) (p2capacity * f);
    }

    public ConcurrentReaderHashMap(int i) {
        this(i, 0.75f);
    }

    public ConcurrentReaderHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, 0.75f);
    }

    public ConcurrentReaderHashMap(Map map) {
        this(Math.max(((int) (map.size() / 0.75f)) + 1, 16), 0.75f);
        putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public synchronized int size() {
        return this.count;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public synchronized boolean isEmpty() {
        return this.count == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        int hash = hash(obj);
        Entry[] entryArr = this.table;
        int length = (entryArr.length - 1) & hash;
        Entry entry = entryArr[length];
        Entry entry2 = entry;
        while (true) {
            if (entry == null) {
                Entry[] tableForReading = getTableForReading();
                if (entryArr == tableForReading && entry2 == entryArr[length]) {
                    return null;
                }
                length = hash & (tableForReading.length - 1);
                entry2 = tableForReading[length];
                entryArr = tableForReading;
            } else if (entry.hash == hash && eq(obj, entry.key)) {
                Object obj2 = entry.value;
                if (obj2 != null) {
                    return obj2;
                }
                synchronized (this) {
                    entryArr = this.table;
                }
                length = (entryArr.length - 1) & hash;
                entry2 = entryArr[length];
            } else {
                entry = entry.next;
            }
            entry = entry2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Objects.requireNonNull(obj2);
        int hash = hash(obj);
        Entry[] entryArr = this.table;
        int length = (entryArr.length - 1) & hash;
        Entry entry = entryArr[length];
        Entry entry2 = entry;
        while (entry2 != null && (entry2.hash != hash || !eq(obj, entry2.key))) {
            entry2 = entry2.next;
        }
        synchronized (this) {
            if (entryArr == this.table) {
                if (entry2 == null) {
                    if (entry == entryArr[length]) {
                        Entry entry3 = new Entry(hash, obj, obj2, entry);
                        entryArr[length] = entry3;
                        int i = this.count + 1;
                        this.count = i;
                        if (i >= this.threshold) {
                            rehash();
                        } else {
                            recordModification(entry3);
                        }
                        return null;
                    }
                } else {
                    Object obj3 = entry2.value;
                    if (entry == entryArr[length] && obj3 != null) {
                        entry2.value = obj2;
                        return obj3;
                    }
                }
            }
            return sput(obj, obj2, hash);
        }
    }

    protected Object sput(Object obj, Object obj2, int i) {
        Entry[] entryArr = this.table;
        int length = (entryArr.length - 1) & i;
        Entry entry = entryArr[length];
        for (Entry entry2 = entry; entry2 != null; entry2 = entry2.next) {
            if (entry2.hash == i && eq(obj, entry2.key)) {
                Object obj3 = entry2.value;
                entry2.value = obj2;
                return obj3;
            }
        }
        Entry entry3 = new Entry(i, obj, obj2, entry);
        entryArr[length] = entry3;
        int i2 = this.count + 1;
        this.count = i2;
        if (i2 >= this.threshold) {
            rehash();
            return null;
        }
        recordModification(entry3);
        return null;
    }

    protected void rehash() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        if (length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i = length << 1;
        int i2 = i - 1;
        this.threshold = (int) (i * this.loadFactor);
        Entry[] entryArr2 = new Entry[i];
        for (Entry entry : entryArr) {
            if (entry != null) {
                int i3 = entry.hash & i2;
                Entry entry2 = entry.next;
                if (entry2 == null) {
                    entryArr2[i3] = entry;
                } else {
                    Entry entry3 = entry;
                    while (entry2 != null) {
                        int i4 = entry2.hash & i2;
                        if (i4 != i3) {
                            entry3 = entry2;
                            i3 = i4;
                        }
                        entry2 = entry2.next;
                    }
                    entryArr2[i3] = entry3;
                    while (entry != entry3) {
                        int i5 = entry.hash & i2;
                        entryArr2[i5] = new Entry(entry.hash, entry.key, entry.value, entryArr2[i5]);
                        entry = entry.next;
                    }
                }
            }
        }
        this.table = entryArr2;
        recordModification(entryArr2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        int hash = hash(obj);
        Entry[] entryArr = this.table;
        int length = (entryArr.length - 1) & hash;
        Entry entry = entryArr[length];
        Entry entry2 = entry;
        while (entry2 != null && (entry2.hash != hash || !eq(obj, entry2.key))) {
            entry2 = entry2.next;
        }
        synchronized (this) {
            if (entryArr == this.table) {
                if (entry2 == null) {
                    if (entry == entryArr[length]) {
                        return null;
                    }
                } else {
                    Object obj2 = entry2.value;
                    if (entry == entryArr[length] && obj2 != null) {
                        entry2.value = null;
                        this.count--;
                        Entry entry3 = entry2.next;
                        while (entry != entry2) {
                            Entry entry4 = new Entry(entry.hash, entry.key, entry.value, entry3);
                            entry = entry.next;
                            entry3 = entry4;
                        }
                        entryArr[length] = entry3;
                        recordModification(entry3);
                        return obj2;
                    }
                }
            }
            return sremove(obj, hash);
        }
    }

    protected Object sremove(Object obj, int i) {
        Entry[] entryArr = this.table;
        int length = (entryArr.length - 1) & i;
        Entry entry = entryArr[length];
        for (Entry entry2 = entry; entry2 != null; entry2 = entry2.next) {
            if (entry2.hash == i && eq(obj, entry2.key)) {
                Object obj2 = entry2.value;
                entry2.value = null;
                this.count--;
                Entry entry3 = entry2.next;
                while (entry != entry2) {
                    Entry entry4 = new Entry(entry.hash, entry.key, entry.value, entry3);
                    entry = entry.next;
                    entry3 = entry4;
                }
                entryArr[length] = entry3;
                recordModification(entry3);
                return obj2;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Objects.requireNonNull(obj);
        for (Entry entry : getTableForReading()) {
            for (; entry != null; entry = entry.next) {
                if (obj.equals(entry.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public synchronized void putAll(Map map) {
        int size = map.size();
        if (size == 0) {
            return;
        }
        while (size >= this.threshold) {
            rehash();
        }
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public synchronized void clear() {
        Entry[] entryArr = this.table;
        for (int i = 0; i < entryArr.length; i++) {
            for (Entry entry = entryArr[i]; entry != null; entry = entry.next) {
                entry.value = null;
            }
            entryArr[i] = null;
        }
        this.count = 0;
        recordModification(entryArr);
    }

    @Override // java.util.AbstractMap
    public synchronized Object clone() {
        ConcurrentReaderHashMap concurrentReaderHashMap;
        try {
            concurrentReaderHashMap = (ConcurrentReaderHashMap) super.clone();
            concurrentReaderHashMap.keySet = null;
            concurrentReaderHashMap.entrySet = null;
            concurrentReaderHashMap.values = null;
            Entry[] entryArr = this.table;
            Entry[] entryArr2 = new Entry[entryArr.length];
            concurrentReaderHashMap.table = entryArr2;
            for (int i = 0; i < entryArr.length; i++) {
                Entry entry = entryArr[i];
                Entry entry2 = null;
                while (entry != null) {
                    Entry entry3 = new Entry(entry.hash, entry.key, entry.value, entry2);
                    entry = entry.next;
                    entry2 = entry3;
                }
                entryArr2[i] = entry2;
            }
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
        return concurrentReaderHashMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    private class KeySet extends AbstractSet {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new KeyIterator(ConcurrentReaderHashMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ConcurrentReaderHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ConcurrentReaderHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return ConcurrentReaderHashMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ConcurrentReaderHashMap.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    private class Values extends AbstractCollection {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new ValueIterator(ConcurrentReaderHashMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ConcurrentReaderHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ConcurrentReaderHashMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ConcurrentReaderHashMap.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    private class EntrySet extends AbstractSet {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return ConcurrentReaderHashMap.this.new HashIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = ConcurrentReaderHashMap.this.get(entry.getKey());
            return obj2 != null && obj2.equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                return ConcurrentReaderHashMap.this.findAndRemoveEntry((Map.Entry) obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ConcurrentReaderHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ConcurrentReaderHashMap.this.clear();
        }
    }

    protected synchronized boolean findAndRemoveEntry(Map.Entry entry) {
        Object key = entry.getKey();
        Object obj = get(key);
        if (obj == null || !obj.equals(entry.getValue())) {
            return false;
        }
        remove(key);
        return true;
    }

    public Enumeration keys() {
        return new KeyIterator(this);
    }

    public Enumeration elements() {
        return new ValueIterator(this);
    }

    protected static class Entry implements Map.Entry {
        protected final int hash;
        protected final Object key;
        protected final Entry next;
        protected volatile Object value;

        Entry(int i, Object obj, Object obj2, Entry entry) {
            this.hash = i;
            this.key = obj;
            this.next = entry;
            this.value = obj2;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Objects.requireNonNull(obj);
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.key.equals(entry.getKey()) && this.value.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.key.hashCode() ^ this.value.hashCode();
        }

        public String toString() {
            return new StringBuffer().append(this.key).append("=").append(this.value).toString();
        }
    }

    protected class HashIterator implements Iterator, Enumeration {
        protected Object currentKey;
        protected Object currentValue;
        protected int index;
        protected final Entry[] tab;
        protected Entry entry = null;
        protected Entry lastReturned = null;

        protected HashIterator() {
            this.tab = ConcurrentReaderHashMap.this.getTableForReading();
            this.index = r2.length - 1;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return hasNext();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Entry entry;
            int i;
            do {
                Entry entry2 = this.entry;
                if (entry2 != null) {
                    Object obj = entry2.value;
                    if (obj != null) {
                        this.currentKey = this.entry.key;
                        this.currentValue = obj;
                        return true;
                    }
                    this.entry = this.entry.next;
                }
                while (true) {
                    entry = this.entry;
                    if (entry != null || (i = this.index) < 0) {
                        break;
                    }
                    Entry[] entryArr = this.tab;
                    this.index = i - 1;
                    this.entry = entryArr[i];
                }
            } while (entry != null);
            this.currentValue = null;
            this.currentKey = null;
            return false;
        }

        protected Object returnValueOfNext() {
            return this.entry;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.currentKey == null && !hasNext()) {
                throw new NoSuchElementException();
            }
            Object returnValueOfNext = returnValueOfNext();
            Entry entry = this.entry;
            this.lastReturned = entry;
            this.currentValue = null;
            this.currentKey = null;
            this.entry = entry.next;
            return returnValueOfNext;
        }

        @Override // java.util.Iterator
        public void remove() {
            Entry entry = this.lastReturned;
            if (entry == null) {
                throw new IllegalStateException();
            }
            ConcurrentReaderHashMap.this.remove(entry.key);
            this.lastReturned = null;
        }
    }

    protected class KeyIterator extends HashIterator {
        private final /* synthetic */ ConcurrentReaderHashMap this$0;

        protected KeyIterator(ConcurrentReaderHashMap concurrentReaderHashMap) {
            super();
            this.this$0 = concurrentReaderHashMap;
        }

        @Override // org.dom4j.tree.ConcurrentReaderHashMap.HashIterator
        protected Object returnValueOfNext() {
            return this.currentKey;
        }
    }

    protected class ValueIterator extends HashIterator {
        private final /* synthetic */ ConcurrentReaderHashMap this$0;

        protected ValueIterator(ConcurrentReaderHashMap concurrentReaderHashMap) {
            super();
            this.this$0 = concurrentReaderHashMap;
        }

        @Override // org.dom4j.tree.ConcurrentReaderHashMap.HashIterator
        protected Object returnValueOfNext() {
            return this.currentValue;
        }
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.table.length);
        objectOutputStream.writeInt(this.count);
        for (int length = this.table.length - 1; length >= 0; length--) {
            for (Entry entry = this.table[length]; entry != null; entry = entry.next) {
                objectOutputStream.writeObject(entry.key);
                objectOutputStream.writeObject(entry.value);
            }
        }
    }

    private synchronized void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.table = new Entry[objectInputStream.readInt()];
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    public synchronized int capacity() {
        return this.table.length;
    }

    public float loadFactor() {
        return this.loadFactor;
    }
}
