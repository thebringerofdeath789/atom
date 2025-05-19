package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.SortedBag;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* loaded from: classes4.dex */
public final class UnmodifiableSortedBag<E> extends AbstractSortedBagDecorator<E> implements Unmodifiable {
    private static final long serialVersionUID = -3190437252665717841L;

    public static <E> SortedBag<E> unmodifiableSortedBag(SortedBag<E> sortedBag) {
        return sortedBag instanceof Unmodifiable ? sortedBag : new UnmodifiableSortedBag(sortedBag);
    }

    private UnmodifiableSortedBag(SortedBag<E> sortedBag) {
        super(sortedBag);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setCollection((Collection) objectInputStream.readObject());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<E> iterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.bag.AbstractBagDecorator, org.apache.commons.collections4.Bag
    public boolean add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.bag.AbstractBagDecorator, org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.bag.AbstractBagDecorator, org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        return UnmodifiableSet.unmodifiableSet(decorated().uniqueSet());
    }
}
