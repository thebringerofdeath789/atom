package org.apache.commons.collections.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.apache.commons.collections.iterators.IteratorChain;
import org.apache.commons.collections.list.UnmodifiableList;

/* loaded from: classes4.dex */
public class CompositeCollection implements Collection {
    protected Collection[] all;
    protected CollectionMutator mutator;

    public interface CollectionMutator {
        boolean add(CompositeCollection compositeCollection, Collection[] collectionArr, Object obj);

        boolean addAll(CompositeCollection compositeCollection, Collection[] collectionArr, Collection collection);

        boolean remove(CompositeCollection compositeCollection, Collection[] collectionArr, Object obj);
    }

    public CompositeCollection() {
        this.all = new Collection[0];
    }

    public CompositeCollection(Collection collection) {
        this();
        addComposited(collection);
    }

    public CompositeCollection(Collection[] collectionArr) {
        this();
        addComposited(collectionArr);
    }

    @Override // java.util.Collection
    public int size() {
        int i = 0;
        for (int length = this.all.length - 1; length >= 0; length--) {
            i += this.all[length].size();
        }
        return i;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        for (int length = this.all.length - 1; length >= 0; length--) {
            if (!this.all[length].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        for (int length = this.all.length - 1; length >= 0; length--) {
            if (this.all[length].contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        if (this.all.length == 0) {
            return EmptyIterator.INSTANCE;
        }
        IteratorChain iteratorChain = new IteratorChain();
        int i = 0;
        while (true) {
            Collection[] collectionArr = this.all;
            if (i >= collectionArr.length) {
                return iteratorChain;
            }
            iteratorChain.addIterator(collectionArr[i].iterator());
            i++;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        int size = size();
        if (objArr.length < size) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            Collection[] collectionArr = this.all;
            if (i >= collectionArr.length) {
                break;
            }
            Iterator it = collectionArr[i].iterator();
            while (it.hasNext()) {
                objArr[i2] = it.next();
                i2++;
            }
            i++;
        }
        if (objArr.length > size) {
            objArr[size] = null;
        }
        return objArr;
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        CollectionMutator collectionMutator = this.mutator;
        if (collectionMutator == null) {
            throw new UnsupportedOperationException("add() is not supported on CompositeCollection without a CollectionMutator strategy");
        }
        return collectionMutator.add(this, this.all, obj);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        CollectionMutator collectionMutator = this.mutator;
        if (collectionMutator == null) {
            throw new UnsupportedOperationException("remove() is not supported on CompositeCollection without a CollectionMutator strategy");
        }
        return collectionMutator.remove(this, this.all, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        CollectionMutator collectionMutator = this.mutator;
        if (collectionMutator == null) {
            throw new UnsupportedOperationException("addAll() is not supported on CompositeCollection without a CollectionMutator strategy");
        }
        return collectionMutator.addAll(this, this.all, collection);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        if (collection.size() == 0) {
            return false;
        }
        boolean z = false;
        for (int length = this.all.length - 1; length >= 0; length--) {
            z = this.all[length].removeAll(collection) || z;
        }
        return z;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        boolean z = false;
        for (int length = this.all.length - 1; length >= 0; length--) {
            z = this.all[length].retainAll(collection) || z;
        }
        return z;
    }

    @Override // java.util.Collection
    public void clear() {
        int i = 0;
        while (true) {
            Collection[] collectionArr = this.all;
            if (i >= collectionArr.length) {
                return;
            }
            collectionArr[i].clear();
            i++;
        }
    }

    public void setMutator(CollectionMutator collectionMutator) {
        this.mutator = collectionMutator;
    }

    public void addComposited(Collection[] collectionArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(this.all));
        arrayList.addAll(Arrays.asList(collectionArr));
        this.all = (Collection[]) arrayList.toArray(new Collection[arrayList.size()]);
    }

    public void addComposited(Collection collection) {
        addComposited(new Collection[]{collection});
    }

    public void addComposited(Collection collection, Collection collection2) {
        addComposited(new Collection[]{collection, collection2});
    }

    public void removeComposited(Collection collection) {
        ArrayList arrayList = new ArrayList(this.all.length);
        arrayList.addAll(Arrays.asList(this.all));
        arrayList.remove(collection);
        this.all = (Collection[]) arrayList.toArray(new Collection[arrayList.size()]);
    }

    public Collection toCollection() {
        return new ArrayList(this);
    }

    public Collection getCollections() {
        return UnmodifiableList.decorate(Arrays.asList(this.all));
    }
}
