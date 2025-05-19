package org.apache.commons.collections.map;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections.set.AbstractSetDecorator;

/* loaded from: classes4.dex */
public final class UnmodifiableEntrySet extends AbstractSetDecorator implements Unmodifiable {
    public static Set decorate(Set set) {
        return set instanceof Unmodifiable ? set : new UnmodifiableEntrySet(set);
    }

    private UnmodifiableEntrySet(Set set) {
        super(set);
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections.Bag
    public Iterator iterator() {
        return new UnmodifiableEntrySetIterator(this.collection.iterator());
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public Object[] toArray() {
        Object[] array = this.collection.toArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = new UnmodifiableEntry((Map.Entry) array[i]);
        }
        return array;
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        Object[] array = this.collection.toArray(objArr.length > 0 ? (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 0) : objArr);
        for (int i = 0; i < array.length; i++) {
            array[i] = new UnmodifiableEntry((Map.Entry) array[i]);
        }
        if (array.length > objArr.length) {
            return array;
        }
        System.arraycopy(array, 0, objArr, 0, array.length);
        if (objArr.length > array.length) {
            objArr[array.length] = null;
        }
        return objArr;
    }

    static final class UnmodifiableEntrySetIterator extends AbstractIteratorDecorator {
        protected UnmodifiableEntrySetIterator(Iterator it) {
            super(it);
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Object next() {
            return new UnmodifiableEntry((Map.Entry) this.iterator.next());
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static final class UnmodifiableEntry extends AbstractMapEntryDecorator {
        protected UnmodifiableEntry(Map.Entry entry) {
            super(entry);
        }

        @Override // org.apache.commons.collections.keyvalue.AbstractMapEntryDecorator, java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }
    }
}
