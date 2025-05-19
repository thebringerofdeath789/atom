package org.apache.commons.collections.bidimap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.keyvalue.AbstractMapEntryDecorator;

/* loaded from: classes4.dex */
public abstract class AbstractDualBidiMap implements BidiMap {
    protected transient Set entrySet;
    protected transient BidiMap inverseBidiMap;
    protected transient Set keySet;
    protected final transient Map[] maps;
    protected transient Collection values;

    protected abstract BidiMap createBidiMap(Map map, Map map2, BidiMap bidiMap);

    protected Map createMap() {
        return null;
    }

    protected AbstractDualBidiMap() {
        this.maps = new Map[]{createMap(), createMap()};
        this.inverseBidiMap = null;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
    }

    protected AbstractDualBidiMap(Map map, Map map2) {
        this.maps = new Map[]{map, map2};
        this.inverseBidiMap = null;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
    }

    protected AbstractDualBidiMap(Map map, Map map2, BidiMap bidiMap) {
        this.maps = new Map[]{map, map2};
        this.inverseBidiMap = null;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
        this.inverseBidiMap = bidiMap;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.maps[0].get(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.maps[0].size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.maps[0].isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.maps[0].containsKey(obj);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.maps[0].equals(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.maps[0].hashCode();
    }

    public String toString() {
        return this.maps[0].toString();
    }

    @Override // org.apache.commons.collections.BidiMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (this.maps[0].containsKey(obj)) {
            Map[] mapArr = this.maps;
            mapArr[1].remove(mapArr[0].get(obj));
        }
        if (this.maps[1].containsKey(obj2)) {
            Map[] mapArr2 = this.maps;
            mapArr2[0].remove(mapArr2[1].get(obj2));
        }
        Object put = this.maps[0].put(obj, obj2);
        this.maps[1].put(obj2, obj);
        return put;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        if (!this.maps[0].containsKey(obj)) {
            return null;
        }
        Object remove = this.maps[0].remove(obj);
        this.maps[1].remove(remove);
        return remove;
    }

    @Override // java.util.Map
    public void clear() {
        this.maps[0].clear();
        this.maps[1].clear();
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.maps[1].containsKey(obj);
    }

    @Override // org.apache.commons.collections.BidiMap, org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return new BidiMapIterator(this);
    }

    @Override // org.apache.commons.collections.BidiMap
    public Object getKey(Object obj) {
        return this.maps[1].get(obj);
    }

    @Override // org.apache.commons.collections.BidiMap
    public Object removeValue(Object obj) {
        if (!this.maps[1].containsKey(obj)) {
            return null;
        }
        Object remove = this.maps[1].remove(obj);
        this.maps[0].remove(remove);
        return remove;
    }

    @Override // org.apache.commons.collections.BidiMap
    public BidiMap inverseBidiMap() {
        if (this.inverseBidiMap == null) {
            Map[] mapArr = this.maps;
            this.inverseBidiMap = createBidiMap(mapArr[1], mapArr[0], this);
        }
        return this.inverseBidiMap;
    }

    @Override // java.util.Map
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new KeySet(this);
        }
        return this.keySet;
    }

    protected Iterator createKeySetIterator(Iterator it) {
        return new KeySetIterator(it, this);
    }

    @Override // java.util.Map
    public Collection values() {
        if (this.values == null) {
            this.values = new Values(this);
        }
        return this.values;
    }

    protected Iterator createValuesIterator(Iterator it) {
        return new ValuesIterator(it, this);
    }

    @Override // java.util.Map
    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet(this);
        }
        return this.entrySet;
    }

    protected Iterator createEntrySetIterator(Iterator it) {
        return new EntrySetIterator(it, this);
    }

    protected static abstract class View extends AbstractCollectionDecorator {
        protected final AbstractDualBidiMap parent;

        protected View(Collection collection, AbstractDualBidiMap abstractDualBidiMap) {
            super(collection);
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
        public boolean removeAll(Collection collection) {
            boolean z = false;
            if (!this.parent.isEmpty() && !collection.isEmpty()) {
                Iterator it = iterator();
                while (it.hasNext()) {
                    if (collection.contains(it.next())) {
                        it.remove();
                        z = true;
                    }
                }
            }
            return z;
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
        public boolean retainAll(Collection collection) {
            boolean z = false;
            if (this.parent.isEmpty()) {
                return false;
            }
            if (collection.isEmpty()) {
                this.parent.clear();
                return true;
            }
            Iterator it = iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
        public void clear() {
            this.parent.clear();
        }
    }

    protected static class KeySet extends View implements Set {
        protected KeySet(AbstractDualBidiMap abstractDualBidiMap) {
            super(abstractDualBidiMap.maps[0].keySet(), abstractDualBidiMap);
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections.Bag
        public Iterator iterator() {
            return this.parent.createKeySetIterator(super.iterator());
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.maps[0].containsKey(obj);
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
        public boolean remove(Object obj) {
            if (!this.parent.maps[0].containsKey(obj)) {
                return false;
            }
            this.parent.maps[1].remove(this.parent.maps[0].remove(obj));
            return true;
        }
    }

    protected static class KeySetIterator extends AbstractIteratorDecorator {
        protected boolean canRemove;
        protected Object lastKey;
        protected final AbstractDualBidiMap parent;

        protected KeySetIterator(Iterator it, AbstractDualBidiMap abstractDualBidiMap) {
            super(it);
            this.lastKey = null;
            this.canRemove = false;
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Object next() {
            Object next = super.next();
            this.lastKey = next;
            this.canRemove = true;
            return next;
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            Object obj = this.parent.maps[0].get(this.lastKey);
            super.remove();
            this.parent.maps[1].remove(obj);
            this.lastKey = null;
            this.canRemove = false;
        }
    }

    protected static class Values extends View implements Set {
        protected Values(AbstractDualBidiMap abstractDualBidiMap) {
            super(abstractDualBidiMap.maps[0].values(), abstractDualBidiMap);
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections.Bag
        public Iterator iterator() {
            return this.parent.createValuesIterator(super.iterator());
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.maps[1].containsKey(obj);
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
        public boolean remove(Object obj) {
            if (!this.parent.maps[1].containsKey(obj)) {
                return false;
            }
            this.parent.maps[0].remove(this.parent.maps[1].remove(obj));
            return true;
        }
    }

    protected static class ValuesIterator extends AbstractIteratorDecorator {
        protected boolean canRemove;
        protected Object lastValue;
        protected final AbstractDualBidiMap parent;

        protected ValuesIterator(Iterator it, AbstractDualBidiMap abstractDualBidiMap) {
            super(it);
            this.lastValue = null;
            this.canRemove = false;
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Object next() {
            Object next = super.next();
            this.lastValue = next;
            this.canRemove = true;
            return next;
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            super.remove();
            this.parent.maps[1].remove(this.lastValue);
            this.lastValue = null;
            this.canRemove = false;
        }
    }

    protected static class EntrySet extends View implements Set {
        protected EntrySet(AbstractDualBidiMap abstractDualBidiMap) {
            super(abstractDualBidiMap.maps[0].entrySet(), abstractDualBidiMap);
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections.Bag
        public Iterator iterator() {
            return this.parent.createEntrySetIterator(super.iterator());
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            if (this.parent.containsKey(key)) {
                Object obj2 = this.parent.maps[0].get(key);
                Object value = entry.getValue();
                if (obj2 != null ? obj2.equals(value) : value == null) {
                    this.parent.maps[0].remove(key);
                    this.parent.maps[1].remove(obj2);
                    return true;
                }
            }
            return false;
        }
    }

    protected static class EntrySetIterator extends AbstractIteratorDecorator {
        protected boolean canRemove;
        protected Map.Entry last;
        protected final AbstractDualBidiMap parent;

        protected EntrySetIterator(Iterator it, AbstractDualBidiMap abstractDualBidiMap) {
            super(it);
            this.last = null;
            this.canRemove = false;
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Object next() {
            MapEntry mapEntry = new MapEntry((Map.Entry) super.next(), this.parent);
            this.last = mapEntry;
            this.canRemove = true;
            return mapEntry;
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            Object value = this.last.getValue();
            super.remove();
            this.parent.maps[1].remove(value);
            this.last = null;
            this.canRemove = false;
        }
    }

    protected static class MapEntry extends AbstractMapEntryDecorator {
        protected final AbstractDualBidiMap parent;

        protected MapEntry(Map.Entry entry, AbstractDualBidiMap abstractDualBidiMap) {
            super(entry);
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections.keyvalue.AbstractMapEntryDecorator, java.util.Map.Entry
        public Object setValue(Object obj) {
            Object key = getKey();
            if (this.parent.maps[1].containsKey(obj) && this.parent.maps[1].get(obj) != key) {
                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
            }
            this.parent.put(key, obj);
            return super.setValue(obj);
        }
    }

    protected static class BidiMapIterator implements MapIterator, ResettableIterator {
        protected Iterator iterator;
        protected final AbstractDualBidiMap parent;
        protected Map.Entry last = null;
        protected boolean canRemove = false;

        protected BidiMapIterator(AbstractDualBidiMap abstractDualBidiMap) {
            this.parent = abstractDualBidiMap;
            this.iterator = abstractDualBidiMap.maps[0].entrySet().iterator();
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public Object next() {
            Map.Entry entry = (Map.Entry) this.iterator.next();
            this.last = entry;
            this.canRemove = true;
            return entry.getKey();
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("Iterator remove() can only be called once after next()");
            }
            Object value = this.last.getValue();
            this.iterator.remove();
            this.parent.maps[1].remove(value);
            this.last = null;
            this.canRemove = false;
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getKey() {
            Map.Entry entry = this.last;
            if (entry == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            return entry.getKey();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getValue() {
            Map.Entry entry = this.last;
            if (entry == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            return entry.getValue();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object setValue(Object obj) {
            if (this.last == null) {
                throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
            }
            if (this.parent.maps[1].containsKey(obj) && this.parent.maps[1].get(obj) != this.last.getKey()) {
                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
            }
            return this.parent.put(this.last.getKey(), obj);
        }

        @Override // org.apache.commons.collections.ResettableIterator
        public void reset() {
            this.iterator = this.parent.maps[0].entrySet().iterator();
            this.last = null;
            this.canRemove = false;
        }

        public String toString() {
            return this.last != null ? new StringBuffer().append("MapIterator[").append(getKey()).append("=").append(getValue()).append("]").toString() : "MapIterator[]";
        }
    }
}
