package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.BoundedCollection;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections.iterators.UnmodifiableIterator;

/* loaded from: classes4.dex */
public class FixedSizeList extends AbstractSerializableListDecorator implements BoundedCollection {
    private static final long serialVersionUID = -2218010673611160319L;

    @Override // org.apache.commons.collections.BoundedCollection
    public boolean isFull() {
        return true;
    }

    public static List decorate(List list) {
        return new FixedSizeList(list);
    }

    protected FixedSizeList(List list) {
        super(list);
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public Object get(int i) {
        return getList().get(i);
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public int indexOf(Object obj) {
        return getList().indexOf(obj);
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections.Bag
    public Iterator iterator() {
        return UnmodifiableIterator.decorate(getCollection().iterator());
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public int lastIndexOf(Object obj) {
        return getList().lastIndexOf(obj);
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public ListIterator listIterator() {
        return new FixedSizeListIterator(getList().listIterator(0));
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public ListIterator listIterator(int i) {
        return new FixedSizeListIterator(getList().listIterator(i));
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public Object remove(int i) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public Object set(int i, Object obj) {
        return getList().set(i, obj);
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public List subList(int i, int i2) {
        return new FixedSizeList(getList().subList(i, i2));
    }

    static class FixedSizeListIterator extends AbstractListIteratorDecorator {
        protected FixedSizeListIterator(ListIterator listIterator) {
            super(listIterator);
        }

        @Override // org.apache.commons.collections.iterators.AbstractListIteratorDecorator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("List is fixed size");
        }

        @Override // org.apache.commons.collections.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException("List is fixed size");
        }
    }

    @Override // org.apache.commons.collections.BoundedCollection
    public int maxSize() {
        return size();
    }
}
