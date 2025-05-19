package org.apache.commons.collections.set;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.iterators.UnmodifiableIterator;

/* loaded from: classes4.dex */
public final class UnmodifiableSortedSet extends AbstractSortedSetDecorator implements Unmodifiable, Serializable {
    private static final long serialVersionUID = -725356885467962424L;

    public static SortedSet decorate(SortedSet sortedSet) {
        return sortedSet instanceof Unmodifiable ? sortedSet : new UnmodifiableSortedSet(sortedSet);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.collection);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.collection = (Collection) objectInputStream.readObject();
    }

    private UnmodifiableSortedSet(SortedSet sortedSet) {
        super(sortedSet);
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

    @Override // org.apache.commons.collections.set.AbstractSortedSetDecorator, java.util.SortedSet
    public SortedSet subSet(Object obj, Object obj2) {
        return new UnmodifiableSortedSet(getSortedSet().subSet(obj, obj2));
    }

    @Override // org.apache.commons.collections.set.AbstractSortedSetDecorator, java.util.SortedSet
    public SortedSet headSet(Object obj) {
        return new UnmodifiableSortedSet(getSortedSet().headSet(obj));
    }

    @Override // org.apache.commons.collections.set.AbstractSortedSetDecorator, java.util.SortedSet
    public SortedSet tailSet(Object obj) {
        return new UnmodifiableSortedSet(getSortedSet().tailSet(obj));
    }
}
