package gnu.trove.impl.sync;

import gnu.trove.TDoubleCollection;
import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.procedure.TDoubleProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedDoubleCollection implements TDoubleCollection, Serializable {
    private static final long serialVersionUID = 3053995032091335093L;

    /* renamed from: c */
    final TDoubleCollection f3600c;
    final Object mutex;

    public TSynchronizedDoubleCollection(TDoubleCollection tDoubleCollection) {
        Objects.requireNonNull(tDoubleCollection);
        this.f3600c = tDoubleCollection;
        this.mutex = this;
    }

    public TSynchronizedDoubleCollection(TDoubleCollection tDoubleCollection, Object obj) {
        this.f3600c = tDoubleCollection;
        this.mutex = obj;
    }

    @Override // gnu.trove.TDoubleCollection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3600c.size();
        }
        return size;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3600c.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean contains(double d) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.f3600c.contains(d);
        }
        return contains;
    }

    @Override // gnu.trove.TDoubleCollection
    public double[] toArray() {
        double[] array;
        synchronized (this.mutex) {
            array = this.f3600c.toArray();
        }
        return array;
    }

    @Override // gnu.trove.TDoubleCollection
    public double[] toArray(double[] dArr) {
        double[] array;
        synchronized (this.mutex) {
            array = this.f3600c.toArray(dArr);
        }
        return array;
    }

    @Override // gnu.trove.TDoubleCollection
    public TDoubleIterator iterator() {
        return this.f3600c.iterator();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean add(double d) {
        boolean add;
        synchronized (this.mutex) {
            add = this.f3600c.add(d);
        }
        return add;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean remove(double d) {
        boolean remove;
        synchronized (this.mutex) {
            remove = this.f3600c.remove(d);
        }
        return remove;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3600c.containsAll(collection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean containsAll(TDoubleCollection tDoubleCollection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3600c.containsAll(tDoubleCollection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean containsAll(double[] dArr) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3600c.containsAll(dArr);
        }
        return containsAll;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean addAll(Collection<? extends Double> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3600c.addAll(collection);
        }
        return addAll;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean addAll(TDoubleCollection tDoubleCollection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3600c.addAll(tDoubleCollection);
        }
        return addAll;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean addAll(double[] dArr) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3600c.addAll(dArr);
        }
        return addAll;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3600c.removeAll(collection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean removeAll(TDoubleCollection tDoubleCollection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3600c.removeAll(tDoubleCollection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean removeAll(double[] dArr) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3600c.removeAll(dArr);
        }
        return removeAll;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3600c.retainAll(collection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean retainAll(TDoubleCollection tDoubleCollection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3600c.retainAll(tDoubleCollection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean retainAll(double[] dArr) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3600c.retainAll(dArr);
        }
        return retainAll;
    }

    @Override // gnu.trove.TDoubleCollection
    public double getNoEntryValue() {
        return this.f3600c.getNoEntryValue();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean forEach(TDoubleProcedure tDoubleProcedure) {
        boolean forEach;
        synchronized (this.mutex) {
            forEach = this.f3600c.forEach(tDoubleProcedure);
        }
        return forEach;
    }

    @Override // gnu.trove.TDoubleCollection
    public void clear() {
        synchronized (this.mutex) {
            this.f3600c.clear();
        }
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3600c.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}