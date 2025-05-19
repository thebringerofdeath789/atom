package org.apache.commons.collections.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.iterators.EmptyOrderedIterator;
import org.apache.commons.collections.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections.map.AbstractHashedMap;

/* loaded from: classes4.dex */
public class AbstractLinkedMap extends AbstractHashedMap implements OrderedMap {
    protected transient LinkEntry header;

    protected AbstractLinkedMap() {
    }

    protected AbstractLinkedMap(int i, float f, int i2) {
        super(i, f, i2);
    }

    protected AbstractLinkedMap(int i) {
        super(i);
    }

    protected AbstractLinkedMap(int i, float f) {
        super(i, f);
    }

    protected AbstractLinkedMap(Map map) {
        super(map);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected void init() {
        LinkEntry linkEntry = (LinkEntry) createEntry(null, -1, null, null);
        this.header = linkEntry;
        linkEntry.after = linkEntry;
        linkEntry.before = linkEntry;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            LinkEntry linkEntry = this.header;
            do {
                linkEntry = linkEntry.after;
                if (linkEntry == this.header) {
                    return false;
                }
            } while (linkEntry.getValue() != null);
            return true;
        }
        LinkEntry linkEntry2 = this.header;
        do {
            linkEntry2 = linkEntry2.after;
            if (linkEntry2 == this.header) {
                return false;
            }
        } while (!isEqualValue(obj, linkEntry2.getValue()));
        return true;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        LinkEntry linkEntry = this.header;
        linkEntry.after = linkEntry;
        linkEntry.before = linkEntry;
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object firstKey() {
        if (this.size == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return this.header.after.getKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object lastKey() {
        if (this.size == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return this.header.before.getKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object nextKey(Object obj) {
        LinkEntry linkEntry = (LinkEntry) getEntry(obj);
        if (linkEntry == null || linkEntry.after == this.header) {
            return null;
        }
        return linkEntry.after.getKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object previousKey(Object obj) {
        LinkEntry linkEntry = (LinkEntry) getEntry(obj);
        if (linkEntry == null || linkEntry.before == this.header) {
            return null;
        }
        return linkEntry.before.getKey();
    }

    protected LinkEntry getEntry(int i) {
        LinkEntry linkEntry;
        if (i < 0) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Index ").append(i).append(" is less than zero").toString());
        }
        if (i >= this.size) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Index ").append(i).append(" is invalid for size ").append(this.size).toString());
        }
        if (i < this.size / 2) {
            linkEntry = this.header.after;
            for (int i2 = 0; i2 < i; i2++) {
                linkEntry = linkEntry.after;
            }
        } else {
            linkEntry = this.header;
            for (int i3 = this.size; i3 > i; i3--) {
                linkEntry = linkEntry.before;
            }
        }
        return linkEntry;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected void addEntry(AbstractHashedMap.HashEntry hashEntry, int i) {
        LinkEntry linkEntry = (LinkEntry) hashEntry;
        linkEntry.after = this.header;
        linkEntry.before = this.header.before;
        this.header.before.after = linkEntry;
        this.header.before = linkEntry;
        this.data[i] = hashEntry;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
        return new LinkEntry(hashEntry, i, obj, obj2);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected void removeEntry(AbstractHashedMap.HashEntry hashEntry, int i, AbstractHashedMap.HashEntry hashEntry2) {
        LinkEntry linkEntry = (LinkEntry) hashEntry;
        linkEntry.before.after = linkEntry.after;
        linkEntry.after.before = linkEntry.before;
        linkEntry.after = null;
        linkEntry.before = null;
        super.removeEntry(hashEntry, i, hashEntry2);
    }

    protected LinkEntry entryBefore(LinkEntry linkEntry) {
        return linkEntry.before;
    }

    protected LinkEntry entryAfter(LinkEntry linkEntry) {
        return linkEntry.after;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        if (this.size == 0) {
            return EmptyOrderedMapIterator.INSTANCE;
        }
        return new LinkMapIterator(this);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        if (this.size == 0) {
            return EmptyOrderedMapIterator.INSTANCE;
        }
        return new LinkMapIterator(this);
    }

    protected static class LinkMapIterator extends LinkIterator implements OrderedMapIterator {
        protected LinkMapIterator(AbstractLinkedMap abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator, org.apache.commons.collections.MapIterator
        public Object next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections.OrderedIterator
        public Object previous() {
            return super.previousEntry().getKey();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getKey() {
            LinkEntry currentEntry = currentEntry();
            if (currentEntry == null) {
                throw new IllegalStateException("getKey() can only be called after next() and before remove()");
            }
            return currentEntry.getKey();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getValue() {
            LinkEntry currentEntry = currentEntry();
            if (currentEntry == null) {
                throw new IllegalStateException("getValue() can only be called after next() and before remove()");
            }
            return currentEntry.getValue();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object setValue(Object obj) {
            LinkEntry currentEntry = currentEntry();
            if (currentEntry == null) {
                throw new IllegalStateException("setValue() can only be called after next() and before remove()");
            }
            return currentEntry.setValue(obj);
        }
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected Iterator createEntrySetIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.INSTANCE;
        }
        return new EntrySetIterator(this);
    }

    protected static class EntrySetIterator extends LinkIterator {
        protected EntrySetIterator(AbstractLinkedMap abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public Object next() {
            return super.nextEntry();
        }

        @Override // org.apache.commons.collections.OrderedIterator
        public Object previous() {
            return super.previousEntry();
        }
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected Iterator createKeySetIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.INSTANCE;
        }
        return new KeySetIterator(this);
    }

    protected static class KeySetIterator extends EntrySetIterator {
        protected KeySetIterator(AbstractLinkedMap abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // org.apache.commons.collections.map.AbstractLinkedMap.EntrySetIterator, java.util.Iterator
        public Object next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections.map.AbstractLinkedMap.EntrySetIterator, org.apache.commons.collections.OrderedIterator
        public Object previous() {
            return super.previousEntry().getKey();
        }
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected Iterator createValuesIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.INSTANCE;
        }
        return new ValuesIterator(this);
    }

    protected static class ValuesIterator extends LinkIterator {
        protected ValuesIterator(AbstractLinkedMap abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public Object next() {
            return super.nextEntry().getValue();
        }

        @Override // org.apache.commons.collections.OrderedIterator
        public Object previous() {
            return super.previousEntry().getValue();
        }
    }

    protected static class LinkEntry extends AbstractHashedMap.HashEntry {
        protected LinkEntry after;
        protected LinkEntry before;

        protected LinkEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
            super(hashEntry, i, obj, obj2);
        }
    }

    protected static abstract class LinkIterator implements OrderedIterator, ResettableIterator {
        protected int expectedModCount;
        protected LinkEntry last;
        protected LinkEntry next;
        protected final AbstractLinkedMap parent;

        protected LinkIterator(AbstractLinkedMap abstractLinkedMap) {
            this.parent = abstractLinkedMap;
            this.next = abstractLinkedMap.header.after;
            this.expectedModCount = abstractLinkedMap.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        @Override // org.apache.commons.collections.OrderedIterator
        public boolean hasPrevious() {
            return this.next.before != this.parent.header;
        }

        protected LinkEntry nextEntry() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (this.next == this.parent.header) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            LinkEntry linkEntry = this.next;
            this.last = linkEntry;
            this.next = linkEntry.after;
            return this.last;
        }

        protected LinkEntry previousEntry() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            LinkEntry linkEntry = this.next.before;
            if (linkEntry == this.parent.header) {
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            this.next = linkEntry;
            this.last = linkEntry;
            return linkEntry;
        }

        protected LinkEntry currentEntry() {
            return this.last;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.last == null) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.parent.remove(this.last.getKey());
            this.last = null;
            this.expectedModCount = this.parent.modCount;
        }

        @Override // org.apache.commons.collections.ResettableIterator
        public void reset() {
            this.last = null;
            this.next = this.parent.header.after;
        }

        public String toString() {
            return this.last != null ? new StringBuffer().append("Iterator[").append(this.last.getKey()).append("=").append(this.last.getValue()).append("]").toString() : "Iterator[]";
        }
    }
}
