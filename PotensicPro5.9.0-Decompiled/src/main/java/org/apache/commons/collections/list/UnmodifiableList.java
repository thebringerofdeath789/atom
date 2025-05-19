package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.iterators.UnmodifiableListIterator;

/* loaded from: classes4.dex */
public final class UnmodifiableList extends AbstractSerializableListDecorator implements Unmodifiable {
    private static final long serialVersionUID = 6595182819922443652L;

    public static List decorate(List list) {
        return list instanceof Unmodifiable ? list : new UnmodifiableList(list);
    }

    private UnmodifiableList(List list) {
        super(list);
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections.Bag
    public Iterator iterator() {
        return UnmodifiableIterator.decorate(getCollection().iterator());
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

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public ListIterator listIterator() {
        return UnmodifiableListIterator.decorate(getList().listIterator());
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public ListIterator listIterator(int i) {
        return UnmodifiableListIterator.decorate(getList().listIterator(i));
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public List subList(int i, int i2) {
        return new UnmodifiableList(getList().subList(i, i2));
    }
}
