package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections.IterableMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.apache.commons.collections.iterators.EmptyMapIterator;

/* loaded from: classes4.dex */
public class Flat3Map implements IterableMap, Serializable, Cloneable {
    private static final long serialVersionUID = -6701087419741928296L;
    private transient AbstractHashedMap delegateMap;
    private transient int hash1;
    private transient int hash2;
    private transient int hash3;
    private transient Object key1;
    private transient Object key2;
    private transient Object key3;
    private transient int size;
    private transient Object value1;
    private transient Object value2;
    private transient Object value3;

    public Flat3Map() {
    }

    public Flat3Map(Map map) {
        putAll(map);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.get(obj);
        }
        if (obj == null) {
            int i = this.size;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    if (this.key3 == null) {
                        return this.value3;
                    }
                }
                if (this.key2 == null) {
                    return this.value2;
                }
            }
            if (this.key1 == null) {
                return this.value1;
            }
            return null;
        }
        if (this.size <= 0) {
            return null;
        }
        int hashCode = obj.hashCode();
        int i2 = this.size;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                if (this.hash3 == hashCode && obj.equals(this.key3)) {
                    return this.value3;
                }
            }
            if (this.hash2 == hashCode && obj.equals(this.key2)) {
                return this.value2;
            }
        }
        if (this.hash1 == hashCode && obj.equals(this.key1)) {
            return this.value1;
        }
        return null;
    }

    @Override // java.util.Map
    public int size() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.size();
        }
        return this.size;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.containsKey(obj);
        }
        if (obj == null) {
            int i = this.size;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    if (this.key3 == null) {
                        return true;
                    }
                }
                if (this.key2 == null) {
                    return true;
                }
            }
            return this.key1 == null;
        }
        if (this.size <= 0) {
            return false;
        }
        int hashCode = obj.hashCode();
        int i2 = this.size;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return false;
                }
                if (this.hash3 == hashCode && obj.equals(this.key3)) {
                    return true;
                }
            }
            if (this.hash2 == hashCode && obj.equals(this.key2)) {
                return true;
            }
        }
        return this.hash1 == hashCode && obj.equals(this.key1);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.containsValue(obj);
        }
        if (obj == null) {
            int i = this.size;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    if (this.value3 == null) {
                        return true;
                    }
                }
                if (this.value2 == null) {
                    return true;
                }
            }
            return this.value1 == null;
        }
        int i2 = this.size;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return false;
                }
                if (obj.equals(this.value3)) {
                    return true;
                }
            }
            if (obj.equals(this.value2)) {
                return true;
            }
        }
        return obj.equals(this.value1);
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.put(obj, obj2);
        }
        if (obj == null) {
            int i = this.size;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (this.key3 == null) {
                            Object obj3 = this.value3;
                            this.value3 = obj2;
                            return obj3;
                        }
                    }
                }
                if (this.key2 == null) {
                    Object obj4 = this.value2;
                    this.value2 = obj2;
                    return obj4;
                }
            }
            if (this.key1 == null) {
                Object obj5 = this.value1;
                this.value1 = obj2;
                return obj5;
            }
        } else if (this.size > 0) {
            int hashCode = obj.hashCode();
            int i2 = this.size;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        if (this.hash3 == hashCode && obj.equals(this.key3)) {
                            Object obj6 = this.value3;
                            this.value3 = obj2;
                            return obj6;
                        }
                    }
                }
                if (this.hash2 == hashCode && obj.equals(this.key2)) {
                    Object obj7 = this.value2;
                    this.value2 = obj2;
                    return obj7;
                }
            }
            if (this.hash1 == hashCode && obj.equals(this.key1)) {
                Object obj8 = this.value1;
                this.value1 = obj2;
                return obj8;
            }
        }
        int i3 = this.size;
        if (i3 == 0) {
            this.hash1 = obj != null ? obj.hashCode() : 0;
            this.key1 = obj;
            this.value1 = obj2;
        } else if (i3 == 1) {
            this.hash2 = obj != null ? obj.hashCode() : 0;
            this.key2 = obj;
            this.value2 = obj2;
        } else {
            if (i3 != 2) {
                convertToMap();
                this.delegateMap.put(obj, obj2);
                return null;
            }
            this.hash3 = obj != null ? obj.hashCode() : 0;
            this.key3 = obj;
            this.value3 = obj2;
        }
        this.size++;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        int size = map.size();
        if (size == 0) {
            return;
        }
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            abstractHashedMap.putAll(map);
            return;
        }
        if (size < 4) {
            for (Map.Entry entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return;
        }
        convertToMap();
        this.delegateMap.putAll(map);
    }

    private void convertToMap() {
        AbstractHashedMap createDelegateMap = createDelegateMap();
        this.delegateMap = createDelegateMap;
        int i = this.size;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    createDelegateMap.put(this.key3, this.value3);
                }
                this.size = 0;
                this.hash3 = 0;
                this.hash2 = 0;
                this.hash1 = 0;
                this.key3 = null;
                this.key2 = null;
                this.key1 = null;
                this.value3 = null;
                this.value2 = null;
                this.value1 = null;
            }
            this.delegateMap.put(this.key2, this.value2);
        }
        this.delegateMap.put(this.key1, this.value1);
        this.size = 0;
        this.hash3 = 0;
        this.hash2 = 0;
        this.hash1 = 0;
        this.key3 = null;
        this.key2 = null;
        this.key1 = null;
        this.value3 = null;
        this.value2 = null;
        this.value1 = null;
    }

    protected AbstractHashedMap createDelegateMap() {
        return new HashedMap();
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.remove(obj);
        }
        int i = this.size;
        if (i == 0) {
            return null;
        }
        if (obj == null) {
            if (i != 1) {
                if (i == 2) {
                    Object obj2 = this.key2;
                    if (obj2 == null) {
                        Object obj3 = this.value2;
                        this.hash2 = 0;
                        this.key2 = null;
                        this.value2 = null;
                        this.size = 1;
                        return obj3;
                    }
                    if (this.key1 != null) {
                        return null;
                    }
                    Object obj4 = this.value1;
                    this.hash1 = this.hash2;
                    this.key1 = obj2;
                    this.value1 = this.value2;
                    this.hash2 = 0;
                    this.key2 = null;
                    this.value2 = null;
                    this.size = 1;
                    return obj4;
                }
                if (i == 3) {
                    Object obj5 = this.key3;
                    if (obj5 == null) {
                        Object obj6 = this.value3;
                        this.hash3 = 0;
                        this.key3 = null;
                        this.value3 = null;
                        this.size = 2;
                        return obj6;
                    }
                    if (this.key2 == null) {
                        Object obj7 = this.value2;
                        this.hash2 = this.hash3;
                        this.key2 = obj5;
                        this.value2 = this.value3;
                        this.hash3 = 0;
                        this.key3 = null;
                        this.value3 = null;
                        this.size = 2;
                        return obj7;
                    }
                    if (this.key1 != null) {
                        return null;
                    }
                    Object obj8 = this.value1;
                    this.hash1 = this.hash3;
                    this.key1 = obj5;
                    this.value1 = this.value3;
                    this.hash3 = 0;
                    this.key3 = null;
                    this.value3 = null;
                    this.size = 2;
                    return obj8;
                }
            } else if (this.key1 == null) {
                Object obj9 = this.value1;
                this.hash1 = 0;
                this.key1 = null;
                this.value1 = null;
                this.size = 0;
                return obj9;
            }
        } else if (i > 0) {
            int hashCode = obj.hashCode();
            int i2 = this.size;
            if (i2 != 1) {
                if (i2 == 2) {
                    if (this.hash2 == hashCode && obj.equals(this.key2)) {
                        Object obj10 = this.value2;
                        this.hash2 = 0;
                        this.key2 = null;
                        this.value2 = null;
                        this.size = 1;
                        return obj10;
                    }
                    if (this.hash1 != hashCode || !obj.equals(this.key1)) {
                        return null;
                    }
                    Object obj11 = this.value1;
                    this.hash1 = this.hash2;
                    this.key1 = this.key2;
                    this.value1 = this.value2;
                    this.hash2 = 0;
                    this.key2 = null;
                    this.value2 = null;
                    this.size = 1;
                    return obj11;
                }
                if (i2 == 3) {
                    if (this.hash3 == hashCode && obj.equals(this.key3)) {
                        Object obj12 = this.value3;
                        this.hash3 = 0;
                        this.key3 = null;
                        this.value3 = null;
                        this.size = 2;
                        return obj12;
                    }
                    if (this.hash2 == hashCode && obj.equals(this.key2)) {
                        Object obj13 = this.value2;
                        this.hash2 = this.hash3;
                        this.key2 = this.key3;
                        this.value2 = this.value3;
                        this.hash3 = 0;
                        this.key3 = null;
                        this.value3 = null;
                        this.size = 2;
                        return obj13;
                    }
                    if (this.hash1 != hashCode || !obj.equals(this.key1)) {
                        return null;
                    }
                    Object obj14 = this.value1;
                    this.hash1 = this.hash3;
                    this.key1 = this.key3;
                    this.value1 = this.value3;
                    this.hash3 = 0;
                    this.key3 = null;
                    this.value3 = null;
                    this.size = 2;
                    return obj14;
                }
            } else if (this.hash1 == hashCode && obj.equals(this.key1)) {
                Object obj15 = this.value1;
                this.hash1 = 0;
                this.key1 = null;
                this.value1 = null;
                this.size = 0;
                return obj15;
            }
        }
        return null;
    }

    @Override // java.util.Map
    public void clear() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            abstractHashedMap.clear();
            this.delegateMap = null;
            return;
        }
        this.size = 0;
        this.hash3 = 0;
        this.hash2 = 0;
        this.hash1 = 0;
        this.key3 = null;
        this.key2 = null;
        this.key1 = null;
        this.value3 = null;
        this.value2 = null;
        this.value1 = null;
    }

    @Override // org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.mapIterator();
        }
        if (this.size == 0) {
            return EmptyMapIterator.INSTANCE;
        }
        return new FlatMapIterator(this);
    }

    static class FlatMapIterator implements MapIterator, ResettableIterator {
        private final Flat3Map parent;
        private int nextIndex = 0;
        private boolean canRemove = false;

        FlatMapIterator(Flat3Map flat3Map) {
            this.parent = flat3Map;
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < this.parent.size;
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.canRemove = true;
            this.nextIndex++;
            return getKey();
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            this.parent.remove(getKey());
            this.nextIndex--;
            this.canRemove = false;
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getKey() {
            if (!this.canRemove) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            int i = this.nextIndex;
            if (i == 1) {
                return this.parent.key1;
            }
            if (i == 2) {
                return this.parent.key2;
            }
            if (i == 3) {
                return this.parent.key3;
            }
            throw new IllegalStateException("Invalid map index");
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getValue() {
            if (!this.canRemove) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            int i = this.nextIndex;
            if (i == 1) {
                return this.parent.value1;
            }
            if (i == 2) {
                return this.parent.value2;
            }
            if (i == 3) {
                return this.parent.value3;
            }
            throw new IllegalStateException("Invalid map index");
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object setValue(Object obj) {
            if (!this.canRemove) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            Object value = getValue();
            int i = this.nextIndex;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.parent.value3 = obj;
                    }
                    return value;
                }
                this.parent.value2 = obj;
            }
            this.parent.value1 = obj;
            return value;
        }

        @Override // org.apache.commons.collections.ResettableIterator
        public void reset() {
            this.nextIndex = 0;
            this.canRemove = false;
        }

        public String toString() {
            return this.canRemove ? new StringBuffer().append("Iterator[").append(getKey()).append("=").append(getValue()).append("]").toString() : "Iterator[]";
        }
    }

    @Override // java.util.Map
    public Set entrySet() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.entrySet();
        }
        return new EntrySet(this);
    }

    static class EntrySet extends AbstractSet {
        private final Flat3Map parent;

        EntrySet(Flat3Map flat3Map) {
            this.parent = flat3Map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Object key = ((Map.Entry) obj).getKey();
            boolean containsKey = this.parent.containsKey(key);
            this.parent.remove(key);
            return containsKey;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            if (this.parent.delegateMap != null) {
                return this.parent.delegateMap.entrySet().iterator();
            }
            if (this.parent.size() == 0) {
                return EmptyIterator.INSTANCE;
            }
            return new EntrySetIterator(this.parent);
        }
    }

    static class EntrySetIterator implements Iterator, Map.Entry {
        private final Flat3Map parent;
        private int nextIndex = 0;
        private boolean canRemove = false;

        EntrySetIterator(Flat3Map flat3Map) {
            this.parent = flat3Map;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < this.parent.size;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.canRemove = true;
            this.nextIndex++;
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            this.parent.remove(getKey());
            this.nextIndex--;
            this.canRemove = false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (!this.canRemove) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            int i = this.nextIndex;
            if (i == 1) {
                return this.parent.key1;
            }
            if (i == 2) {
                return this.parent.key2;
            }
            if (i == 3) {
                return this.parent.key3;
            }
            throw new IllegalStateException("Invalid map index");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (!this.canRemove) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            int i = this.nextIndex;
            if (i == 1) {
                return this.parent.value1;
            }
            if (i == 2) {
                return this.parent.value2;
            }
            if (i == 3) {
                return this.parent.value3;
            }
            throw new IllegalStateException("Invalid map index");
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (!this.canRemove) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            Object value = getValue();
            int i = this.nextIndex;
            if (i == 1) {
                this.parent.value1 = obj;
            } else if (i == 2) {
                this.parent.value2 = obj;
            } else if (i == 3) {
                this.parent.value3 = obj;
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.canRemove || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = getKey();
            Object value = getValue();
            if (key == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!key.equals(entry.getKey())) {
                return false;
            }
            Object value2 = entry.getValue();
            if (value == null) {
                if (value2 != null) {
                    return false;
                }
            } else if (!value.equals(value2)) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.canRemove) {
                return 0;
            }
            Object key = getKey();
            Object value = getValue();
            return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
        }

        public String toString() {
            return this.canRemove ? new StringBuffer().append(getKey()).append("=").append(getValue()).toString() : "";
        }
    }

    @Override // java.util.Map
    public Set keySet() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.keySet();
        }
        return new KeySet(this);
    }

    static class KeySet extends AbstractSet {
        private final Flat3Map parent;

        KeySet(Flat3Map flat3Map) {
            this.parent = flat3Map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean containsKey = this.parent.containsKey(obj);
            this.parent.remove(obj);
            return containsKey;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            if (this.parent.delegateMap != null) {
                return this.parent.delegateMap.keySet().iterator();
            }
            if (this.parent.size() == 0) {
                return EmptyIterator.INSTANCE;
            }
            return new KeySetIterator(this.parent);
        }
    }

    static class KeySetIterator extends EntrySetIterator {
        KeySetIterator(Flat3Map flat3Map) {
            super(flat3Map);
        }

        @Override // org.apache.commons.collections.map.Flat3Map.EntrySetIterator, java.util.Iterator
        public Object next() {
            super.next();
            return getKey();
        }
    }

    @Override // java.util.Map
    public Collection values() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.values();
        }
        return new Values(this);
    }

    static class Values extends AbstractCollection {
        private final Flat3Map parent;

        Values(Flat3Map flat3Map) {
            this.parent = flat3Map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            if (this.parent.delegateMap != null) {
                return this.parent.delegateMap.values().iterator();
            }
            if (this.parent.size() == 0) {
                return EmptyIterator.INSTANCE;
            }
            return new ValuesIterator(this.parent);
        }
    }

    static class ValuesIterator extends EntrySetIterator {
        ValuesIterator(Flat3Map flat3Map) {
            super(flat3Map);
        }

        @Override // org.apache.commons.collections.map.Flat3Map.EntrySetIterator, java.util.Iterator
        public Object next() {
            super.next();
            return getValue();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        MapIterator mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt > 3) {
            this.delegateMap = createDelegateMap();
        }
        while (readInt > 0) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
            readInt--;
        }
    }

    public Object clone() {
        try {
            Flat3Map flat3Map = (Flat3Map) super.clone();
            AbstractHashedMap abstractHashedMap = flat3Map.delegateMap;
            if (abstractHashedMap != null) {
                flat3Map.delegateMap = (HashedMap) abstractHashedMap.clone();
            }
            return flat3Map;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.equals(obj);
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this.size != map.size()) {
            return false;
        }
        int i = this.size;
        if (i > 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (!map.containsKey(this.key3)) {
                            return false;
                        }
                        Object obj2 = map.get(this.key3);
                        Object obj3 = this.value3;
                        if (obj3 != null ? !obj3.equals(obj2) : obj2 != null) {
                            return false;
                        }
                    }
                }
                if (!map.containsKey(this.key2)) {
                    return false;
                }
                Object obj4 = map.get(this.key2);
                Object obj5 = this.value2;
                if (obj5 != null ? !obj5.equals(obj4) : obj4 != null) {
                    return false;
                }
            }
            if (!map.containsKey(this.key1)) {
                return false;
            }
            Object obj6 = map.get(this.key1);
            Object obj7 = this.value1;
            if (obj7 != null ? !obj7.equals(obj6) : obj6 != null) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public int hashCode() {
        int i;
        int i2;
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.hashCode();
        }
        int i3 = this.size;
        if (i3 != 1) {
            if (i3 == 2) {
                i2 = 0;
            } else {
                if (i3 != 3) {
                    return 0;
                }
                int i4 = this.hash3;
                Object obj = this.value3;
                i2 = (i4 ^ (obj == null ? 0 : obj.hashCode())) + 0;
            }
            int i5 = this.hash2;
            Object obj2 = this.value2;
            i = i2 + (i5 ^ (obj2 == null ? 0 : obj2.hashCode()));
        } else {
            i = 0;
        }
        int i6 = this.hash1;
        Object obj3 = this.value1;
        return i + (i6 ^ (obj3 != null ? obj3.hashCode() : 0));
    }

    public String toString() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.toString();
        }
        if (this.size == 0) {
            return "{}";
        }
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append('{');
        int i = this.size;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    Object obj = this.key3;
                    if (obj == this) {
                        obj = "(this Map)";
                    }
                    stringBuffer.append(obj);
                    stringBuffer.append('=');
                    Object obj2 = this.value3;
                    if (obj2 == this) {
                        obj2 = "(this Map)";
                    }
                    stringBuffer.append(obj2);
                    stringBuffer.append(',');
                }
                stringBuffer.append('}');
                return stringBuffer.toString();
            }
            Object obj3 = this.key2;
            if (obj3 == this) {
                obj3 = "(this Map)";
            }
            stringBuffer.append(obj3);
            stringBuffer.append('=');
            Object obj4 = this.value2;
            if (obj4 == this) {
                obj4 = "(this Map)";
            }
            stringBuffer.append(obj4);
            stringBuffer.append(',');
        }
        Object obj5 = this.key1;
        if (obj5 == this) {
            obj5 = "(this Map)";
        }
        stringBuffer.append(obj5);
        stringBuffer.append('=');
        Object obj6 = this.value1;
        stringBuffer.append(obj6 != this ? obj6 : "(this Map)");
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
