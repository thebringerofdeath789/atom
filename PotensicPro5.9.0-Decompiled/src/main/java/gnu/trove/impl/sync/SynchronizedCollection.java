package gnu.trove.impl.sync;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
class SynchronizedCollection<E> implements Collection<E>, Serializable {
    private static final long serialVersionUID = 3053995032091335093L;
    final Collection<E> c;
    final Object mutex;

    SynchronizedCollection(Collection<E> collection, Object obj) {
        this.c = collection;
        this.mutex = obj;
    }

    @Override // java.util.Collection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.c.size();
        }
        return size;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.c.isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.c.contains(obj);
        }
        return contains;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] array;
        synchronized (this.mutex) {
            array = this.c.toArray();
        }
        return array;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        synchronized (this.mutex) {
            tArr2 = (T[]) this.c.toArray(tArr);
        }
        return tArr2;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.c.iterator();
    }

    @Override // java.util.Collection
    public boolean add(E e) {
        boolean add;
        synchronized (this.mutex) {
            add = this.c.add(e);
        }
        return add;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.mutex) {
            remove = this.c.remove(obj);
        }
        return remove;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(collection);
        }
        return containsAll;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(collection);
        }
        return addAll;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(collection);
        }
        return removeAll;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(collection);
        }
        return retainAll;
    }

    @Override // java.util.Collection
    public void clear() {
        synchronized (this.mutex) {
            this.c.clear();
        }
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.c.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}
