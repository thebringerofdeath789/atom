package gnu.trove.impl.sync;

import gnu.trove.TLongCollection;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.procedure.TLongProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedLongCollection implements TLongCollection, Serializable {
    private static final long serialVersionUID = 3053995032091335093L;

    /* renamed from: c */
    final TLongCollection f3627c;
    final Object mutex;

    public TSynchronizedLongCollection(TLongCollection tLongCollection) {
        Objects.requireNonNull(tLongCollection);
        this.f3627c = tLongCollection;
        this.mutex = this;
    }

    public TSynchronizedLongCollection(TLongCollection tLongCollection, Object obj) {
        this.f3627c = tLongCollection;
        this.mutex = obj;
    }

    @Override // gnu.trove.TLongCollection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3627c.size();
        }
        return size;
    }

    @Override // gnu.trove.TLongCollection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3627c.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.TLongCollection
    public boolean contains(long j) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.f3627c.contains(j);
        }
        return contains;
    }

    @Override // gnu.trove.TLongCollection
    public long[] toArray() {
        long[] array;
        synchronized (this.mutex) {
            array = this.f3627c.toArray();
        }
        return array;
    }

    @Override // gnu.trove.TLongCollection
    public long[] toArray(long[] jArr) {
        long[] array;
        synchronized (this.mutex) {
            array = this.f3627c.toArray(jArr);
        }
        return array;
    }

    @Override // gnu.trove.TLongCollection
    public TLongIterator iterator() {
        return this.f3627c.iterator();
    }

    @Override // gnu.trove.TLongCollection
    public boolean add(long j) {
        boolean add;
        synchronized (this.mutex) {
            add = this.f3627c.add(j);
        }
        return add;
    }

    @Override // gnu.trove.TLongCollection
    public boolean remove(long j) {
        boolean remove;
        synchronized (this.mutex) {
            remove = this.f3627c.remove(j);
        }
        return remove;
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3627c.containsAll(collection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(TLongCollection tLongCollection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3627c.containsAll(tLongCollection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(long[] jArr) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3627c.containsAll(jArr);
        }
        return containsAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean addAll(Collection<? extends Long> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3627c.addAll(collection);
        }
        return addAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean addAll(TLongCollection tLongCollection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3627c.addAll(tLongCollection);
        }
        return addAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean addAll(long[] jArr) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3627c.addAll(jArr);
        }
        return addAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3627c.removeAll(collection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean removeAll(TLongCollection tLongCollection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3627c.removeAll(tLongCollection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean removeAll(long[] jArr) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3627c.removeAll(jArr);
        }
        return removeAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3627c.retainAll(collection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean retainAll(TLongCollection tLongCollection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3627c.retainAll(tLongCollection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean retainAll(long[] jArr) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3627c.retainAll(jArr);
        }
        return retainAll;
    }

    @Override // gnu.trove.TLongCollection
    public long getNoEntryValue() {
        return this.f3627c.getNoEntryValue();
    }

    @Override // gnu.trove.TLongCollection
    public boolean forEach(TLongProcedure tLongProcedure) {
        boolean forEach;
        synchronized (this.mutex) {
            forEach = this.f3627c.forEach(tLongProcedure);
        }
        return forEach;
    }

    @Override // gnu.trove.TLongCollection
    public void clear() {
        synchronized (this.mutex) {
            this.f3627c.clear();
        }
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3627c.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}