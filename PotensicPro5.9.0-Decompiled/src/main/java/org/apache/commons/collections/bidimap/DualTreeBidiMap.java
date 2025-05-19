package org.apache.commons.collections.bidimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.SortedBidiMap;
import org.apache.commons.collections.map.AbstractSortedMapDecorator;

/* loaded from: classes4.dex */
public class DualTreeBidiMap extends AbstractDualBidiMap implements SortedBidiMap, Serializable {
    private static final long serialVersionUID = 721969328361809L;
    protected final Comparator comparator;

    public DualTreeBidiMap() {
        super(new TreeMap(), new TreeMap());
        this.comparator = null;
    }

    public DualTreeBidiMap(Map map) {
        super(new TreeMap(), new TreeMap());
        putAll(map);
        this.comparator = null;
    }

    public DualTreeBidiMap(Comparator comparator) {
        super(new TreeMap(comparator), new TreeMap(comparator));
        this.comparator = comparator;
    }

    protected DualTreeBidiMap(Map map, Map map2, BidiMap bidiMap) {
        super(map, map2, bidiMap);
        this.comparator = ((SortedMap) map).comparator();
    }

    @Override // org.apache.commons.collections.bidimap.AbstractDualBidiMap
    protected BidiMap createBidiMap(Map map, Map map2, BidiMap bidiMap) {
        return new DualTreeBidiMap(map, map2, bidiMap);
    }

    @Override // java.util.SortedMap
    public Comparator comparator() {
        return ((SortedMap) this.maps[0]).comparator();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object firstKey() {
        return ((SortedMap) this.maps[0]).firstKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object lastKey() {
        return ((SortedMap) this.maps[0]).lastKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object nextKey(Object obj) {
        if (isEmpty()) {
            return null;
        }
        if (this.maps[0] instanceof OrderedMap) {
            return ((OrderedMap) this.maps[0]).nextKey(obj);
        }
        Iterator it = ((SortedMap) this.maps[0]).tailMap(obj).keySet().iterator();
        it.next();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object previousKey(Object obj) {
        if (isEmpty()) {
            return null;
        }
        if (this.maps[0] instanceof OrderedMap) {
            return ((OrderedMap) this.maps[0]).previousKey(obj);
        }
        SortedMap headMap = ((SortedMap) this.maps[0]).headMap(obj);
        if (headMap.isEmpty()) {
            return null;
        }
        return headMap.lastKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        return new BidiOrderedMapIterator(this);
    }

    @Override // org.apache.commons.collections.SortedBidiMap
    public SortedBidiMap inverseSortedBidiMap() {
        return (SortedBidiMap) inverseBidiMap();
    }

    @Override // org.apache.commons.collections.OrderedBidiMap
    public OrderedBidiMap inverseOrderedBidiMap() {
        return (OrderedBidiMap) inverseBidiMap();
    }

    @Override // java.util.SortedMap
    public SortedMap headMap(Object obj) {
        return new ViewMap(this, ((SortedMap) this.maps[0]).headMap(obj));
    }

    @Override // java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        return new ViewMap(this, ((SortedMap) this.maps[0]).tailMap(obj));
    }

    @Override // java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        return new ViewMap(this, ((SortedMap) this.maps[0]).subMap(obj, obj2));
    }

    protected static class ViewMap extends AbstractSortedMapDecorator {
        final DualTreeBidiMap bidi;

        protected ViewMap(DualTreeBidiMap dualTreeBidiMap, SortedMap sortedMap) {
            super((SortedMap) dualTreeBidiMap.createBidiMap(sortedMap, dualTreeBidiMap.maps[1], dualTreeBidiMap.inverseBidiMap));
            this.bidi = (DualTreeBidiMap) this.map;
        }

        @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
        public boolean containsValue(Object obj) {
            return this.bidi.maps[0].containsValue(obj);
        }

        @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
        public void clear() {
            Iterator it = keySet().iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap headMap(Object obj) {
            return new ViewMap(this.bidi, super.headMap(obj));
        }

        @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            return new ViewMap(this.bidi, super.tailMap(obj));
        }

        @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            return new ViewMap(this.bidi, super.subMap(obj, obj2));
        }
    }

    protected static class BidiOrderedMapIterator implements OrderedMapIterator, ResettableIterator {
        protected ListIterator iterator;
        private Map.Entry last = null;
        protected final AbstractDualBidiMap parent;

        protected BidiOrderedMapIterator(AbstractDualBidiMap abstractDualBidiMap) {
            this.parent = abstractDualBidiMap;
            this.iterator = new ArrayList(abstractDualBidiMap.entrySet()).listIterator();
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public Object next() {
            Map.Entry entry = (Map.Entry) this.iterator.next();
            this.last = entry;
            return entry.getKey();
        }

        @Override // org.apache.commons.collections.OrderedMapIterator, org.apache.commons.collections.OrderedIterator
        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        @Override // org.apache.commons.collections.OrderedMapIterator, org.apache.commons.collections.OrderedIterator
        public Object previous() {
            Map.Entry entry = (Map.Entry) this.iterator.previous();
            this.last = entry;
            return entry.getKey();
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public void remove() {
            this.iterator.remove();
            this.parent.remove(this.last.getKey());
            this.last = null;
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
            this.iterator = new ArrayList(this.parent.entrySet()).listIterator();
            this.last = null;
        }

        public String toString() {
            return this.last != null ? new StringBuffer().append("MapIterator[").append(getKey()).append("=").append(getValue()).append("]").toString() : "MapIterator[]";
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.maps[0]);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.maps[0] = new TreeMap(this.comparator);
        this.maps[1] = new TreeMap(this.comparator);
        putAll((Map) objectInputStream.readObject());
    }
}
