package org.apache.commons.collections.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections.SortedBag;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.iterators.UnmodifiableIterator;
import org.apache.commons.collections.set.UnmodifiableSet;

/* loaded from: classes4.dex */
public final class UnmodifiableSortedBag extends AbstractSortedBagDecorator implements Unmodifiable, Serializable {
    private static final long serialVersionUID = -3190437252665717841L;

    public static SortedBag decorate(SortedBag sortedBag) {
        return sortedBag instanceof Unmodifiable ? sortedBag : new UnmodifiableSortedBag(sortedBag);
    }

    private UnmodifiableSortedBag(SortedBag sortedBag) {
        super(sortedBag);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.collection);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.collection = (Collection) objectInputStream.readObject();
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

    @Override // org.apache.commons.collections.bag.AbstractBagDecorator, org.apache.commons.collections.Bag
    public boolean add(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.bag.AbstractBagDecorator, org.apache.commons.collections.Bag
    public boolean remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.bag.AbstractBagDecorator, org.apache.commons.collections.Bag
    public Set uniqueSet() {
        return UnmodifiableSet.decorate(getBag().uniqueSet());
    }
}
