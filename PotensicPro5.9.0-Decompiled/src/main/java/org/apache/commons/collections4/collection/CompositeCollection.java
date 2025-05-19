package org.apache.commons.collections4.collection;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

/* loaded from: classes4.dex */
public class CompositeCollection<E> implements Collection<E>, Serializable {
    private static final long serialVersionUID = 8417515734108306801L;
    private final List<Collection<E>> all = new ArrayList();
    private CollectionMutator<E> mutator;

    public interface CollectionMutator<E> extends Serializable {
        boolean add(CompositeCollection<E> compositeCollection, List<Collection<E>> list, E e);

        boolean addAll(CompositeCollection<E> compositeCollection, List<Collection<E>> list, Collection<? extends E> collection);

        boolean remove(CompositeCollection<E> compositeCollection, List<Collection<E>> list, Object obj);
    }

    public CompositeCollection() {
    }

    public CompositeCollection(Collection<E> collection) {
        addComposited(collection);
    }

    public CompositeCollection(Collection<E> collection, Collection<E> collection2) {
        addComposited(collection, collection2);
    }

    public CompositeCollection(Collection<E>... collectionArr) {
        addComposited(collectionArr);
    }

    @Override // java.util.Collection
    public int size() {
        Iterator<Collection<E>> it = this.all.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().size();
        }
        return i;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        Iterator<Collection<E>> it = this.all.iterator();
        while (it.hasNext()) {
            if (!it.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        Iterator<Collection<E>> it = this.all.iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        if (this.all.isEmpty()) {
            return EmptyIterator.emptyIterator();
        }
        IteratorChain iteratorChain = new IteratorChain();
        Iterator<Collection<E>> it = this.all.iterator();
        while (it.hasNext()) {
            iteratorChain.addIterator(it.next().iterator());
        }
        return iteratorChain;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        int length = tArr.length;
        Object[] objArr = tArr;
        if (length < size) {
            objArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        int i = 0;
        Iterator<Collection<E>> it = this.all.iterator();
        while (it.hasNext()) {
            Iterator<E> it2 = it.next().iterator();
            while (it2.hasNext()) {
                objArr[i] = it2.next();
                i++;
            }
        }
        if (objArr.length > size) {
            objArr[size] = null;
        }
        return (T[]) objArr;
    }

    @Override // java.util.Collection
    public boolean add(E e) {
        CollectionMutator<E> collectionMutator = this.mutator;
        if (collectionMutator == null) {
            throw new UnsupportedOperationException("add() is not supported on CompositeCollection without a CollectionMutator strategy");
        }
        return collectionMutator.add(this, this.all, e);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        CollectionMutator<E> collectionMutator = this.mutator;
        if (collectionMutator == null) {
            throw new UnsupportedOperationException("remove() is not supported on CompositeCollection without a CollectionMutator strategy");
        }
        return collectionMutator.remove(this, this.all, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        if (collection == null) {
            return false;
        }
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        CollectionMutator<E> collectionMutator = this.mutator;
        if (collectionMutator == null) {
            throw new UnsupportedOperationException("addAll() is not supported on CompositeCollection without a CollectionMutator strategy");
        }
        return collectionMutator.addAll(this, this.all, collection);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        if (CollectionUtils.isEmpty(collection)) {
            return false;
        }
        Iterator<Collection<E>> it = this.all.iterator();
        while (it.hasNext()) {
            z |= it.next().removeAll(collection);
        }
        return z;
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        boolean z = false;
        if (Objects.isNull(predicate)) {
            return false;
        }
        Iterator<Collection<E>> it = this.all.iterator();
        while (it.hasNext()) {
            z |= it.next().removeIf(predicate);
        }
        return z;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        if (collection != null) {
            Iterator<Collection<E>> it = this.all.iterator();
            while (it.hasNext()) {
                z |= it.next().retainAll(collection);
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public void clear() {
        Iterator<Collection<E>> it = this.all.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public void setMutator(CollectionMutator<E> collectionMutator) {
        this.mutator = collectionMutator;
    }

    public void addComposited(Collection<E> collection) {
        if (collection != null) {
            this.all.add(collection);
        }
    }

    public void addComposited(Collection<E> collection, Collection<E> collection2) {
        if (collection != null) {
            this.all.add(collection);
        }
        if (collection2 != null) {
            this.all.add(collection2);
        }
    }

    public void addComposited(Collection<E>... collectionArr) {
        for (Collection<E> collection : collectionArr) {
            if (collection != null) {
                this.all.add(collection);
            }
        }
    }

    public void removeComposited(Collection<E> collection) {
        this.all.remove(collection);
    }

    public Collection<E> toCollection() {
        return new ArrayList(this);
    }

    public List<Collection<E>> getCollections() {
        return UnmodifiableList.unmodifiableList(this.all);
    }

    protected CollectionMutator<E> getMutator() {
        return this.mutator;
    }
}
