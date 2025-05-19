package org.apache.commons.collections;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes4.dex */
public class ReferenceMap extends AbstractMap {
    public static final int HARD = 0;
    public static final int SOFT = 1;
    public static final int WEAK = 2;
    private static final long serialVersionUID = -3370601314380922368L;
    private transient Set entrySet;
    private transient Set keySet;
    private int keyType;
    private float loadFactor;
    private volatile transient int modCount;
    private boolean purgeValues;
    private transient ReferenceQueue queue;
    private transient int size;
    private transient Entry[] table;
    private transient int threshold;
    private int valueType;
    private transient Collection values;

    public ReferenceMap() {
        this(0, 1);
    }

    public ReferenceMap(int i, int i2, boolean z) {
        this(i, i2);
        this.purgeValues = z;
    }

    public ReferenceMap(int i, int i2) {
        this(i, i2, 16, 0.75f);
    }

    public ReferenceMap(int i, int i2, int i3, float f, boolean z) {
        this(i, i2, i3, f);
        this.purgeValues = z;
    }

    public ReferenceMap(int i, int i2, int i3, float f) {
        this.purgeValues = false;
        this.queue = new ReferenceQueue();
        verify("keyType", i);
        verify("valueType", i2);
        if (i3 <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and less than 1.");
        }
        this.keyType = i;
        this.valueType = i2;
        int i4 = 1;
        while (i4 < i3) {
            i4 *= 2;
        }
        this.table = new Entry[i4];
        this.loadFactor = f;
        this.threshold = (int) (i4 * f);
    }

    private static void verify(String str, int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException(new StringBuffer().append(str).append(" must be HARD, SOFT, WEAK.").toString());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.table.length);
        for (Map.Entry entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
        objectOutputStream.writeObject(null);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.table = new Entry[objectInputStream.readInt()];
        this.threshold = (int) (r0.length * this.loadFactor);
        this.queue = new ReferenceQueue();
        Object readObject = objectInputStream.readObject();
        while (readObject != null) {
            put(readObject, objectInputStream.readObject());
            readObject = objectInputStream.readObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object toReference(int i, Object obj, int i2) {
        if (i == 0) {
            return obj;
        }
        if (i == 1) {
            return new SoftRef(i2, obj, this.queue);
        }
        if (i == 2) {
            return new WeakRef(i2, obj, this.queue);
        }
        throw new Error();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Entry getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        int hashCode = obj.hashCode();
        for (Entry entry = this.table[indexFor(hashCode)]; entry != null; entry = entry.next) {
            if (entry.hash == hashCode && obj.equals(entry.getKey())) {
                return entry;
            }
        }
        return null;
    }

    private int indexFor(int i) {
        int i2 = i + (~(i << 15));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (~(i5 << 11));
        return (i6 ^ (i6 >>> 16)) & (this.table.length - 1);
    }

    private void resize() {
        Entry[] entryArr = this.table;
        this.table = new Entry[entryArr.length * 2];
        for (int i = 0; i < entryArr.length; i++) {
            Entry entry = entryArr[i];
            while (entry != null) {
                Entry entry2 = entry.next;
                int indexFor = indexFor(entry.hash);
                entry.next = this.table[indexFor];
                this.table[indexFor] = entry;
                entry = entry2;
            }
            entryArr[i] = null;
        }
        this.threshold = (int) (this.table.length * this.loadFactor);
    }

    private void purge() {
        Reference poll = this.queue.poll();
        while (poll != null) {
            purge(poll);
            poll = this.queue.poll();
        }
    }

    private void purge(Reference reference) {
        int indexFor = indexFor(reference.hashCode());
        Entry entry = null;
        for (Entry entry2 = this.table[indexFor]; entry2 != null; entry2 = entry2.next) {
            if (entry2.purge(reference)) {
                if (entry == null) {
                    this.table[indexFor] = entry2.next;
                } else {
                    entry.next = entry2.next;
                }
                this.size--;
                return;
            }
            entry = entry2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        purge();
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        purge();
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        purge();
        Entry entry = getEntry(obj);
        return (entry == null || entry.getValue() == null) ? false : true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        purge();
        Entry entry = getEntry(obj);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Objects.requireNonNull(obj, "null keys not allowed");
        Objects.requireNonNull(obj2, "null values not allowed");
        purge();
        if (this.size + 1 > this.threshold) {
            resize();
        }
        int hashCode = obj.hashCode();
        int indexFor = indexFor(hashCode);
        for (Entry entry = this.table[indexFor]; entry != null; entry = entry.next) {
            if (hashCode == entry.hash && obj.equals(entry.getKey())) {
                Object value = entry.getValue();
                entry.setValue(obj2);
                return value;
            }
        }
        this.size++;
        this.modCount++;
        this.table[indexFor] = new Entry(toReference(this.keyType, obj, hashCode), hashCode, toReference(this.valueType, obj2, hashCode), this.table[indexFor]);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        purge();
        int hashCode = obj.hashCode();
        int indexFor = indexFor(hashCode);
        Entry entry = null;
        for (Entry entry2 = this.table[indexFor]; entry2 != null; entry2 = entry2.next) {
            if (hashCode == entry2.hash && obj.equals(entry2.getKey())) {
                if (entry == null) {
                    this.table[indexFor] = entry2.next;
                } else {
                    entry.next = entry2.next;
                }
                this.size--;
                this.modCount++;
                return entry2.getValue();
            }
            entry = entry2;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        while (this.queue.poll() != null) {
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.entrySet;
        if (set != null) {
            return set;
        }
        AbstractSet abstractSet = new AbstractSet() { // from class: org.apache.commons.collections.ReferenceMap.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return ReferenceMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                ReferenceMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj == null || !(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Entry entry2 = ReferenceMap.this.getEntry(entry.getKey());
                return entry2 != null && entry.equals(entry2);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                boolean contains = contains(obj);
                if (contains) {
                    ReferenceMap.this.remove(((Map.Entry) obj).getKey());
                }
                return contains;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return ReferenceMap.this.new EntryIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return toArray(new Object[0]);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray(Object[] objArr) {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    arrayList.add(new org.apache.commons.collections.keyvalue.DefaultMapEntry(entry.getKey(), entry.getValue()));
                }
                return arrayList.toArray(objArr);
            }
        };
        this.entrySet = abstractSet;
        return abstractSet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.keySet;
        if (set != null) {
            return set;
        }
        AbstractSet abstractSet = new AbstractSet() { // from class: org.apache.commons.collections.ReferenceMap.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return ReferenceMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return new KeyIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return ReferenceMap.this.containsKey(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return ReferenceMap.this.remove(obj) != null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                ReferenceMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return toArray(new Object[0]);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray(Object[] objArr) {
                ArrayList arrayList = new ArrayList(size());
                Iterator it = iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                return arrayList.toArray(objArr);
            }
        };
        this.keySet = abstractSet;
        return abstractSet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.values;
        if (collection != null) {
            return collection;
        }
        AbstractCollection abstractCollection = new AbstractCollection() { // from class: org.apache.commons.collections.ReferenceMap.3
            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return ReferenceMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                ReferenceMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator iterator() {
                return new ValueIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public Object[] toArray() {
                return toArray(new Object[0]);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public Object[] toArray(Object[] objArr) {
                ArrayList arrayList = new ArrayList(size());
                Iterator it = iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                return arrayList.toArray(objArr);
            }
        };
        this.values = abstractCollection;
        return abstractCollection;
    }

    private class Entry implements Map.Entry, KeyValue {
        int hash;
        Object key;
        Entry next;
        Object value;

        public Entry(Object obj, int i, Object obj2, Entry entry) {
            this.key = obj;
            this.hash = i;
            this.value = obj2;
            this.next = entry;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
        public Object getKey() {
            return ReferenceMap.this.keyType > 0 ? ((Reference) this.key).get() : this.key;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
        public Object getValue() {
            return ReferenceMap.this.valueType > 0 ? ((Reference) this.value).get() : this.value;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object value = getValue();
            if (ReferenceMap.this.valueType > 0) {
                ((Reference) this.value).clear();
            }
            ReferenceMap referenceMap = ReferenceMap.this;
            this.value = referenceMap.toReference(referenceMap.valueType, obj, this.hash);
            return value;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return key != null && value != null && key.equals(getKey()) && value.equals(getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object value = getValue();
            return (value == null ? 0 : value.hashCode()) ^ this.hash;
        }

        public String toString() {
            return new StringBuffer().append(getKey()).append("=").append(getValue()).toString();
        }

        boolean purge(Reference reference) {
            boolean z = true;
            if (!(ReferenceMap.this.keyType > 0 && this.key == reference) && (ReferenceMap.this.valueType <= 0 || this.value != reference)) {
                z = false;
            }
            if (z) {
                if (ReferenceMap.this.keyType > 0) {
                    ((Reference) this.key).clear();
                }
                if (ReferenceMap.this.valueType <= 0) {
                    if (ReferenceMap.this.purgeValues) {
                        this.value = null;
                    }
                } else {
                    ((Reference) this.value).clear();
                }
            }
            return z;
        }
    }

    private class EntryIterator implements Iterator {
        Object currentKey;
        Object currentValue;
        Entry entry;
        int expectedModCount;
        int index;
        Object nextKey;
        Object nextValue;
        Entry previous;

        public EntryIterator() {
            this.index = ReferenceMap.this.size() != 0 ? ReferenceMap.this.table.length : 0;
            this.expectedModCount = ReferenceMap.this.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkMod();
            while (nextNull()) {
                Entry entry = this.entry;
                int i = this.index;
                while (entry == null && i > 0) {
                    i--;
                    entry = ReferenceMap.this.table[i];
                }
                this.entry = entry;
                this.index = i;
                if (entry == null) {
                    this.currentKey = null;
                    this.currentValue = null;
                    return false;
                }
                this.nextKey = entry.getKey();
                this.nextValue = entry.getValue();
                if (nextNull()) {
                    this.entry = this.entry.next;
                }
            }
            return true;
        }

        private void checkMod() {
            if (ReferenceMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean nextNull() {
            return this.nextKey == null || this.nextValue == null;
        }

        protected Entry nextEntry() {
            checkMod();
            if (nextNull() && !hasNext()) {
                throw new NoSuchElementException();
            }
            Entry entry = this.entry;
            this.previous = entry;
            this.entry = entry.next;
            this.currentKey = this.nextKey;
            this.currentValue = this.nextValue;
            this.nextKey = null;
            this.nextValue = null;
            return this.previous;
        }

        @Override // java.util.Iterator
        public Object next() {
            return nextEntry();
        }

        @Override // java.util.Iterator
        public void remove() {
            checkMod();
            if (this.previous == null) {
                throw new IllegalStateException();
            }
            ReferenceMap.this.remove(this.currentKey);
            this.previous = null;
            this.currentKey = null;
            this.currentValue = null;
            this.expectedModCount = ReferenceMap.this.modCount;
        }
    }

    private class ValueIterator extends EntryIterator {
        private final /* synthetic */ ReferenceMap this$0;

        private ValueIterator(ReferenceMap referenceMap) {
            super();
            this.this$0 = referenceMap;
        }

        @Override // org.apache.commons.collections.ReferenceMap.EntryIterator, java.util.Iterator
        public Object next() {
            return nextEntry().getValue();
        }
    }

    private class KeyIterator extends EntryIterator {
        private final /* synthetic */ ReferenceMap this$0;

        private KeyIterator(ReferenceMap referenceMap) {
            super();
            this.this$0 = referenceMap;
        }

        @Override // org.apache.commons.collections.ReferenceMap.EntryIterator, java.util.Iterator
        public Object next() {
            return nextEntry().getKey();
        }
    }

    private static class SoftRef extends SoftReference {
        private int hash;

        public SoftRef(int i, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.hash = i;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    private static class WeakRef extends WeakReference {
        private int hash;

        public WeakRef(int i, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.hash = i;
        }

        public int hashCode() {
            return this.hash;
        }
    }
}
