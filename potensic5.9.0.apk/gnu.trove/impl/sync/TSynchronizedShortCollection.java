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

    /* renamed from: c */
    final TShortCollection f3643c;
    final Object mutex;

    public TSynchronizedShortCollection(TShortCollection tShortCollection) {
        Objects.requireNonNull(tShortCollection);
        this.f3643c = tShortCollection;
        this.mutex = this;
    }

    public TSynchronizedShortCollection(TShortCollection tShortCollection, Object obj) {
        this.f3643c = tShortCollection;
        this.mutex = obj;
    }

    @Override // gnu.trove.TShortCollection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3643c.size();
        }
        return size;
    }

    @Override // gnu.trove.TShortCollection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3643c.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.TShortCollection
    public boolean contains(short s) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.f3643c.contains(s);
        }
        return contains;
    }

    @Override // gnu.trove.TShortCollection
    public short[] toArray() {
        short[] array;
        synchronized (this.mutex) {
            array = this.f3643c.toArray();
        }
        return array;
    }

    @Override // gnu.trove.TShortCollection
    public short[] toArray(short[] sArr) {
        short[] array;
        synchronized (this.mutex) {
            array = this.f3643c.toArray(sArr);
        }
        return array;
    }

    @Override // gnu.trove.TShortCollection
    public TShortIterator iterator() {
        return this.f3643c.iterator();
    }

    @Override // gnu.trove.TShortCollection
    public boolean add(short s) {
        boolean add;
        synchronized (this.mutex) {
            add = this.f3643c.add(s);
        }
        return add;
    }

    @Override // gnu.trove.TShortCollection
    public boolean remove(short s) {
        boolean remove;
        synchronized (this.mutex) {
            remove = this.f3643c.remove(s);
        }
        return remove;
    }

    @Override // gnu.trove.TShortCollection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3643c.containsAll(collection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean containsAll(TShortCollection tShortCollection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3643c.containsAll(tShortCollection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean containsAll(short[] sArr) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3643c.containsAll(sArr);
        }
        return containsAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean addAll(Collection<? extends Short> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3643c.addAll(collection);
        }
        return addAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean addAll(TShortCollection tShortCollection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3643c.addAll(tShortCollection);
        }
        return addAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean addAll(short[] sArr) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3643c.addAll(sArr);
        }
        return addAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3643c.removeAll(collection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean removeAll(TShortCollection tShortCollection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3643c.removeAll(tShortCollection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean removeAll(short[] sArr) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3643c.removeAll(sArr);
        }
        return removeAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3643c.retainAll(collection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean retainAll(TShortCollection tShortCollection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3643c.retainAll(tShortCollection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TShortCollection
    public boolean retainAll(short[] sArr) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3643c.retainAll(sArr);
        }
        return retainAll;
    }

    @Override // gnu.trove.TShortCollection
    public short getNoEntryValue() {
        return this.f3643c.getNoEntryValue();
    }

    @Override // gnu.trove.TShortCollection
    public boolean forEach(TShortProcedure tShortProcedure) {
        boolean forEach;
        synchronized (this.mutex) {
            forEach = this.f3643c.forEach(tShortProcedure);
        }
        return forEach;
    }

    @Override // gnu.trove.TShortCollection
    public void clear() {
        synchronized (this.mutex) {
            this.f3643c.clear();
        }
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3643c.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}