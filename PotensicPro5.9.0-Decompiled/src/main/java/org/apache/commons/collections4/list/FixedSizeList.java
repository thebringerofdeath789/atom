package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

/* loaded from: classes4.dex */
public class FixedSizeList<E> extends AbstractSerializableListDecorator<E> implements BoundedCollection<E> {
    private static final long serialVersionUID = -2218010673611160319L;

    @Override // org.apache.commons.collections4.BoundedCollection
    public boolean isFull() {
        return true;
    }

    public static <E> FixedSizeList<E> fixedSizeList(List<E> list) {
        return new FixedSizeList<>(list);
    }

    protected FixedSizeList(List<E> list) {
        super(list);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        throw unsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public void add(int i, E e) {
        throw unsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw unsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw unsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        throw unsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E get(int i) {
        return (E) decorated().get(i);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public int indexOf(Object obj) {
        return decorated().indexOf(obj);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<E> iterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public int lastIndexOf(Object obj) {
        return decorated().lastIndexOf(obj);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public ListIterator<E> listIterator() {
        return new FixedSizeListIterator(decorated().listIterator(0));
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public ListIterator<E> listIterator(int i) {
        return new FixedSizeListIterator(decorated().listIterator(i));
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E remove(int i) {
        throw unsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        throw unsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        throw unsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        throw unsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        throw unsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E set(int i, E e) {
        return (E) decorated().set(i, e);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int i, int i2) {
        return new FixedSizeList(decorated().subList(i, i2));
    }

    private class FixedSizeListIterator extends AbstractListIteratorDecorator<E> {
        protected FixedSizeListIterator(ListIterator<E> listIterator) {
            super(listIterator);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw FixedSizeList.unsupportedOperationException();
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(Object obj) {
            throw FixedSizeList.unsupportedOperationException();
        }
    }

    @Override // org.apache.commons.collections4.BoundedCollection
    public int maxSize() {
        return size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static UnsupportedOperationException unsupportedOperationException() {
        return new UnsupportedOperationException("List is fixed size");
    }
}
