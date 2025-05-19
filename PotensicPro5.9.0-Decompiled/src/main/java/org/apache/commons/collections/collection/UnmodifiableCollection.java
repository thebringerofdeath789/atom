package org.apache.commons.collections.collection;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.iterators.UnmodifiableIterator;

/* loaded from: classes4.dex */
public final class UnmodifiableCollection extends AbstractSerializableCollectionDecorator implements Unmodifiable {
    private static final long serialVersionUID = -239892006883819945L;

    public static Collection decorate(Collection collection) {
        return collection instanceof Unmodifiable ? collection : new UnmodifiableCollection(collection);
    }

    private UnmodifiableCollection(Collection collection) {
        super(collection);
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
}
