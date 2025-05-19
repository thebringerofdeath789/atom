package org.apache.commons.collections.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class SynchronizedCollection implements Collection, Serializable {
    private static final long serialVersionUID = 2412805092710877986L;
    protected final Collection collection;
    protected final Object lock;

    public static Collection decorate(Collection collection) {
        return new SynchronizedCollection(collection);
    }

    protected SynchronizedCollection(Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection must not be null");
        }
        this.collection = collection;
        this.lock = this;
    }

    protected SynchronizedCollection(Collection collection, Object obj) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection must not be null");
        }
        this.collection = collection;
        this.lock = obj;
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        boolean add;
        synchronized (this.lock) {
            add = this.collection.add(obj);
        }
        return add;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        boolean addAll;
        synchronized (this.lock) {
            addAll = this.collection.addAll(collection);
        }
        return addAll;
    }

    @Override // java.util.Collection
    public void clear() {
        synchronized (this.lock) {
            this.collection.clear();
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        boolean contains;
        synchronized (this.lock) {
            contains = this.collection.contains(obj);
        }
        return contains;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        boolean containsAll;
        synchronized (this.lock) {
            containsAll = this.collection.containsAll(collection);
        }
        return containsAll;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.lock) {
            isEmpty = this.collection.isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.collection.iterator();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] array;
        synchronized (this.lock) {
            array = this.collection.toArray();
        }
        return array;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        Object[] array;
        synchronized (this.lock) {
            array = this.collection.toArray(objArr);
        }
        return array;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.lock) {
            remove = this.collection.remove(obj);
        }
        return remove;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        boolean removeAll;
        synchronized (this.lock) {
            removeAll = this.collection.removeAll(collection);
        }
        return removeAll;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        boolean retainAll;
        synchronized (this.lock) {
            retainAll = this.collection.retainAll(collection);
        }
        return retainAll;
    }

    @Override // java.util.Collection
    public int size() {
        int size;
        synchronized (this.lock) {
            size = this.collection.size();
        }
        return size;
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        synchronized (this.lock) {
            if (obj == this) {
                return true;
            }
            return this.collection.equals(obj);
        }
    }

    @Override // java.util.Collection
    public int hashCode() {
        int hashCode;
        synchronized (this.lock) {
            hashCode = this.collection.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.lock) {
            obj = this.collection.toString();
        }
        return obj;
    }
}
