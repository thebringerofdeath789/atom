package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.iterators.UnmodifiableListIterator;
import org.apache.commons.collections.list.UnmodifiableList;
import org.apache.commons.collections.map.AbstractLinkedMap;

/* loaded from: classes4.dex */
public class LinkedMap extends AbstractLinkedMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 9077234323521161066L;

    public LinkedMap() {
        super(16, 0.75f, 12);
    }

    public LinkedMap(int i) {
        super(i);
    }

    public LinkedMap(int i, float f) {
        super(i, f);
    }

    public LinkedMap(Map map) {
        super(map);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    public Object get(int i) {
        return getEntry(i).getKey();
    }

    public Object getValue(int i) {
        return getEntry(i).getValue();
    }

    public int indexOf(Object obj) {
        Object convertKey = convertKey(obj);
        AbstractLinkedMap.LinkEntry linkEntry = this.header.after;
        int i = 0;
        while (linkEntry != this.header) {
            if (isEqualKey(convertKey, linkEntry.key)) {
                return i;
            }
            linkEntry = linkEntry.after;
            i++;
        }
        return -1;
    }

    public Object remove(int i) {
        return remove(get(i));
    }

    public List asList() {
        return new LinkedMapList(this);
    }

    static class LinkedMapList extends AbstractList {
        final LinkedMap parent;

        LinkedMapList(LinkedMap linkedMap) {
            this.parent = linkedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            return this.parent.get(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            return this.parent.indexOf(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            return this.parent.indexOf(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean containsAll(Collection collection) {
            return this.parent.keySet().containsAll(collection);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            return this.parent.keySet().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray(Object[] objArr) {
            return this.parent.keySet().toArray(objArr);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return UnmodifiableIterator.decorate(this.parent.keySet().iterator());
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator() {
            return UnmodifiableListIterator.decorate(super.listIterator());
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i) {
            return UnmodifiableListIterator.decorate(super.listIterator(i));
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i, int i2) {
            return UnmodifiableList.decorate(super.subList(i, i2));
        }
    }
}
