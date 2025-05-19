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
    final TLongCollection c;
    final Object mutex;

    public TSynchronizedLongCollection(TLongCollection tLongCollection) {
        Objects.requireNonNull(tLongCollection);
        this.c = tLongCollection;
        this.mutex = this;
    }

    public TSynchronizedLongCollection(TLongCollection tLongCollection, Object obj) {
        this.c = tLongCollection;
        this.mutex = obj;
    }

    @Override // gnu.trove.TLongCollection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.c.size();
        }
        return size;
    }

    @Override // gnu.trove.TLongCollection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.c.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.TLongCollection
    public boolean contains(long j) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.c.contains(j);
        }
        return contains;
    }

    @Override // gnu.trove.TLongCollection
    public long[] toArray() {
        long[] array;
        synchronized (this.mutex) {
            array = this.c.toArray();
        }
        return array;
    }

    @Override // gnu.trove.TLongCollection
    public long[] toArray(long[] jArr) {
        long[] array;
        synchronized (this.mutex) {
            array = this.c.toArray(jArr);
        }
        return array;
    }

    @Override // gnu.trove.TLongCollection
    public TLongIterator iterator() {
        return this.c.iterator();
    }

    @Override // gnu.trove.TLongCollection
    public boolean add(long j) {
        boolean add;
        synchronized (this.mutex) {
            add = this.c.add(j);
        }
        return add;
    }

    @Override // gnu.trove.TLongCollection
    public boolean remove(long j) {
        boolean remove;
        synchronized (this.mutex) {
            remove = this.c.remove(j);
        }
        return remove;
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(collection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(TLongCollection tLongCollection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(tLongCollection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(long[] jArr) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(jArr);
        }
        return containsAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean addAll(Collection<? extends Long> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(collection);
        }
        return addAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean addAll(TLongCollection tLongCollection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(tLongCollection);
        }
        return addAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean addAll(long[] jArr) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(jArr);
        }
        return addAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(collection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean removeAll(TLongCollection tLongCollection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(tLongCollection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean removeAll(long[] jArr) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(jArr);
        }
        return removeAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(collection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean retainAll(TLongCollection tLongCollection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(tLongCollection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TLongCollection
    public boolean retainAll(long[] jArr) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(jArr);
        }
        return retainAll;
    }

    @Override // gnu.trove.TLongCollection
    public long getNoEntryValue() {
        return this.c.getNoEntryValue();
    }

    @Override // gnu.trove.TLongCollection
    public boolean forEach(TLongProcedure tLongProcedure) {
        boolean forEach;
        synchronized (this.mutex) {
            forEach = this.c.forEach(tLongProcedure);
        }
        return forEach;
    }

    @Override // gnu.trove.TLongCollection
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
