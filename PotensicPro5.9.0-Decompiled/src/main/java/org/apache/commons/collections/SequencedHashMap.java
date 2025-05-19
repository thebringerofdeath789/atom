package org.apache.commons.collections;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.list.UnmodifiableList;

/* loaded from: classes4.dex */
public class SequencedHashMap implements Map, Cloneable, Externalizable {
    private static final int ENTRY = 2;
    private static final int KEY = 0;
    private static final int REMOVED_MASK = Integer.MIN_VALUE;
    private static final int VALUE = 1;
    private static final long serialVersionUID = 3380552487888102930L;
    private HashMap entries;
    private transient long modCount;
    private Entry sentinel;

    private static class Entry implements Map.Entry, KeyValue {
        private final Object key;
        Entry next = null;
        Entry prev = null;
        private Object value;

        public Entry(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
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
        public Object setValue(Object obj) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
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
            if (getKey() == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!getKey().equals(entry.getKey())) {
                return false;
            }
            if (getValue() == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!getValue().equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public String toString() {
            return new StringBuffer().append("[").append(getKey()).append("=").append(getValue()).append("]").toString();
        }
    }

    private static final Entry createSentinel() {
        Entry entry = new Entry(null, null);
        entry.prev = entry;
        entry.next = entry;
        return entry;
    }

    public SequencedHashMap() {
        this.modCount = 0L;
        this.sentinel = createSentinel();
        this.entries = new HashMap();
    }

    public SequencedHashMap(int i) {
        this.modCount = 0L;
        this.sentinel = createSentinel();
        this.entries = new HashMap(i);
    }

    public SequencedHashMap(int i, float f) {
        this.modCount = 0L;
        this.sentinel = createSentinel();
        this.entries = new HashMap(i, f);
    }

    public SequencedHashMap(Map map) {
        this();
        putAll(map);
    }

    private void removeEntry(Entry entry) {
        entry.next.prev = entry.prev;
        entry.prev.next = entry.next;
    }

    private void insertEntry(Entry entry) {
        entry.next = this.sentinel;
        entry.prev = this.sentinel.prev;
        this.sentinel.prev.next = entry;
        this.sentinel.prev = entry;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.sentinel.next == this.sentinel;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.entries.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            Entry entry = this.sentinel;
            do {
                entry = entry.next;
                if (entry == this.sentinel) {
                    return false;
                }
            } while (entry.getValue() != null);
            return true;
        }
        Entry entry2 = this.sentinel;
        do {
            entry2 = entry2.next;
            if (entry2 == this.sentinel) {
                return false;
            }
        } while (!obj.equals(entry2.getValue()));
        return true;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        Entry entry = (Entry) this.entries.get(obj);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public Map.Entry getFirst() {
        if (isEmpty()) {
            return null;
        }
        return this.sentinel.next;
    }

    public Object getFirstKey() {
        return this.sentinel.next.getKey();
    }

    public Object getFirstValue() {
        return this.sentinel.next.getValue();
    }

    public Map.Entry getLast() {
        if (isEmpty()) {
            return null;
        }
        return this.sentinel.prev;
    }

    public Object getLastKey() {
        return this.sentinel.prev.getKey();
    }

    public Object getLastValue() {
        return this.sentinel.prev.getValue();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        Object obj3;
        this.modCount++;
        Entry entry = (Entry) this.entries.get(obj);
        if (entry != null) {
            removeEntry(entry);
            obj3 = entry.setValue(obj2);
        } else {
            entry = new Entry(obj, obj2);
            this.entries.put(obj, entry);
            obj3 = null;
        }
        insertEntry(entry);
        return obj3;
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        Entry removeImpl = removeImpl(obj);
        if (removeImpl == null) {
            return null;
        }
        return removeImpl.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Entry removeImpl(Object obj) {
        Entry entry = (Entry) this.entries.remove(obj);
        if (entry == null) {
            return null;
        }
        this.modCount++;
        removeEntry(entry);
        return entry;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.modCount++;
        this.entries.clear();
        Entry entry = this.sentinel;
        entry.next = entry;
        Entry entry2 = this.sentinel;
        entry2.prev = entry2;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
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
        return entrySet().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(PropertyUtils.INDEXED_DELIM);
        Entry entry = this.sentinel;
        while (true) {
            entry = entry.next;
            if (entry != this.sentinel) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append('=');
                stringBuffer.append(entry.getValue());
                if (entry.next != this.sentinel) {
                    stringBuffer.append(',');
                }
            } else {
                stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
                return stringBuffer.toString();
            }
        }
    }

    @Override // java.util.Map
    public Set keySet() {
        return new AbstractSet() { // from class: org.apache.commons.collections.SequencedHashMap.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return SequencedHashMap.this.new OrderedIterator(0);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return SequencedHashMap.this.removeImpl(obj) != null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                SequencedHashMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return SequencedHashMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return SequencedHashMap.this.isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return SequencedHashMap.this.containsKey(obj);
            }
        };
    }

    @Override // java.util.Map
    public Collection values() {
        return new AbstractCollection() { // from class: org.apache.commons.collections.SequencedHashMap.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator iterator() {
                return SequencedHashMap.this.new OrderedIterator(1);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                if (obj == null) {
                    Entry entry = SequencedHashMap.this.sentinel;
                    do {
                        entry = entry.next;
                        if (entry == SequencedHashMap.this.sentinel) {
                            return false;
                        }
                    } while (entry.getValue() != null);
                    SequencedHashMap.this.removeImpl(entry.getKey());
                    return true;
                }
                Entry entry2 = SequencedHashMap.this.sentinel;
                do {
                    entry2 = entry2.next;
                    if (entry2 == SequencedHashMap.this.sentinel) {
                        return false;
                    }
                } while (!obj.equals(entry2.getValue()));
                SequencedHashMap.this.removeImpl(entry2.getKey());
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                SequencedHashMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return SequencedHashMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return SequencedHashMap.this.isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean contains(Object obj) {
                return SequencedHashMap.this.containsValue(obj);
            }
        };
    }

    @Override // java.util.Map
    public Set entrySet() {
        return new AbstractSet() { // from class: org.apache.commons.collections.SequencedHashMap.3
            private Entry findEntry(Object obj) {
                if (obj == null || !(obj instanceof Map.Entry)) {
                    return null;
                }
                Map.Entry entry = (Map.Entry) obj;
                Entry entry2 = (Entry) SequencedHashMap.this.entries.get(entry.getKey());
                if (entry2 == null || !entry2.equals(entry)) {
                    return null;
                }
                return entry2;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return SequencedHashMap.this.new OrderedIterator(2);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                Entry findEntry = findEntry(obj);
                return (findEntry == null || SequencedHashMap.this.removeImpl(findEntry.getKey()) == null) ? false : true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                SequencedHashMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return SequencedHashMap.this.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return SequencedHashMap.this.isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return findEntry(obj) != null;
            }
        };
    }

    private class OrderedIterator implements Iterator {
        private transient long expectedModCount;
        private Entry pos;
        private int returnType;

        public OrderedIterator(int i) {
            this.pos = SequencedHashMap.this.sentinel;
            this.expectedModCount = SequencedHashMap.this.modCount;
            this.returnType = Integer.MIN_VALUE | i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos.next != SequencedHashMap.this.sentinel;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (SequencedHashMap.this.modCount == this.expectedModCount) {
                if (this.pos.next == SequencedHashMap.this.sentinel) {
                    throw new NoSuchElementException();
                }
                this.returnType &= Integer.MAX_VALUE;
                Entry entry = this.pos.next;
                this.pos = entry;
                int i = this.returnType;
                if (i == 0) {
                    return entry.getKey();
                }
                if (i == 1) {
                    return entry.getValue();
                }
                if (i == 2) {
                    return entry;
                }
                throw new Error(new StringBuffer().append("bad iterator type: ").append(this.returnType).toString());
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if ((this.returnType & Integer.MIN_VALUE) != 0) {
                throw new IllegalStateException("remove() must follow next()");
            }
            if (SequencedHashMap.this.modCount == this.expectedModCount) {
                SequencedHashMap.this.removeImpl(this.pos.getKey());
                this.expectedModCount++;
                this.returnType |= Integer.MIN_VALUE;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        SequencedHashMap sequencedHashMap = (SequencedHashMap) super.clone();
        sequencedHashMap.sentinel = createSentinel();
        sequencedHashMap.entries = new HashMap();
        sequencedHashMap.putAll(this);
        return sequencedHashMap;
    }

    private Map.Entry getEntry(int i) {
        Entry entry = this.sentinel;
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append(i).append(" < 0").toString());
        }
        int i2 = -1;
        while (i2 < i - 1 && entry.next != this.sentinel) {
            i2++;
            entry = entry.next;
        }
        if (entry.next == this.sentinel) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append(i).append(" >= ").append(i2 + 1).toString());
        }
        return entry.next;
    }

    public Object get(int i) {
        return getEntry(i).getKey();
    }

    public Object getValue(int i) {
        return getEntry(i).getValue();
    }

    public int indexOf(Object obj) {
        Entry entry = (Entry) this.entries.get(obj);
        if (entry == null) {
            return -1;
        }
        int i = 0;
        while (entry.prev != this.sentinel) {
            i++;
            entry = entry.prev;
        }
        return i;
    }

    public Iterator iterator() {
        return keySet().iterator();
    }

    public int lastIndexOf(Object obj) {
        return indexOf(obj);
    }

    public List sequence() {
        ArrayList arrayList = new ArrayList(size());
        Iterator it = keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return UnmodifiableList.decorate(arrayList);
    }

    public Object remove(int i) {
        return remove(get(i));
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        int readInt = objectInput.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInput.readObject(), objectInput.readObject());
        }
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(size());
        Entry entry = this.sentinel;
        while (true) {
            entry = entry.next;
            if (entry == this.sentinel) {
                return;
            }
            objectOutput.writeObject(entry.getKey());
            objectOutput.writeObject(entry.getValue());
        }
    }
}
