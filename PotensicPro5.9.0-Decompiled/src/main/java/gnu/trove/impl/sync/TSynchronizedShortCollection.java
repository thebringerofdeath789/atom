package gnu.trove.impl.sync;

import gnu.trove.TShortCollection;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.procedure.TShortProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedShortCollection implements TShortCollection, Serializable {
    private static final long serialVersionUID = 3053995032091335093L;
    final TShortCollection c;
    final Object mutex;

    public TSynchronizedShortCollection(TShortCollection tShortCollection) {
        Objects.requireNonNull(tShortCollection);
        this.c = tShortCollection;
        this.mutex = this;
    }

    public TSynchronizedShortCollection(TShortCollection tShortCollection, Object obj) {
        this.c = tShortCollection;
        this.mutex = obj;
    }

    @Override // gnu.trove.TShortCollection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.c.size();
        }
        return size;
    }

    @Override // gnu.trove.TShortCollection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.c.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.TShortCollection
    public boolean contains(short s) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.c.contains(s);
        }
        return contains;
    }

    @Override // gnu.trove.TShortCollection
    public short[] toArray() {
        short[] array;
        synchronized (this.mutex) {
            array = this.c.toArray();
        }
        return array;
    }

    @Override // gnu.trove.TShortCollection
    public short[] toArray(short[] sArr) {
        short[] array;
        synchronized (this.mutex) {
            array = this.c.toArray(sArr);
        }
        return array;
    }

    @Override // gnu.trove.TShortCollection
    public TShortIterator iterator() {
        return this.c.iterator();
    }

    @Override // gnu.trove.TShortCollection
    public boolean add(short s) {
        boolean add;
        synchronized (this.mutex) {
            add = this.c.add(s);
        }
        return add;
    }

    @Override // gnu.trove.TShortCollection
    public boolean remove(short s) {
        boolean remove;
        synchronized (this.mutex) {
            remove = this.c.remove(s);
        }
        return remove;
    }

    @Override // gnu.trove.TShortCollection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(collection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean containsAll(TShortCollection tShortCollection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(tShortCollection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean containsAll(short[] sArr) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(sArr);
        }
        return containsAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean addAll(Collection<? extends Short> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(collection);
        }
        return addAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean addAll(TShortCollection tShortCollection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(tShortCollection);
        }
        return addAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean addAll(short[] sArr) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(sArr);
        }
        return addAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(collection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean removeAll(TShortCollection tShortCollection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(tShortCollection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean removeAll(short[] sArr) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(sArr);
        }
        return removeAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(collection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean retainAll(TShortCollection tShortCollection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(tShortCollection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean retainAll(short[] sArr) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(sArr);
        }
        return retainAll;
    }

    @Override // gnu.trove.TShortCollection
    public short getNoEntryValue() {
        return this.c.getNoEntryValue();
    }

    @Override // gnu.trove.TShortCollection
    public boolean forEach(TShortProcedure tShortProcedure) {
        boolean forEach;
        synchronized (this.mutex) {
            forEach = this.c.forEach(tShortProcedure);
        }
        return forEach;
    }

    @Override // gnu.trove.TShortCollection
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
