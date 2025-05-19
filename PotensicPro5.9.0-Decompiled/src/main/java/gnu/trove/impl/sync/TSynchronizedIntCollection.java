package gnu.trove.impl.sync;

import gnu.trove.TIntCollection;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.procedure.TIntProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedIntCollection implements TIntCollection, Serializable {
    private static final long serialVersionUID = 3053995032091335093L;
    final TIntCollection c;
    final Object mutex;

    public TSynchronizedIntCollection(TIntCollection tIntCollection) {
        Objects.requireNonNull(tIntCollection);
        this.c = tIntCollection;
        this.mutex = this;
    }

    public TSynchronizedIntCollection(TIntCollection tIntCollection, Object obj) {
        this.c = tIntCollection;
        this.mutex = obj;
    }

    @Override // gnu.trove.TIntCollection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.c.size();
        }
        return size;
    }

    @Override // gnu.trove.TIntCollection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.c.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.TIntCollection
    public boolean contains(int i) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.c.contains(i);
        }
        return contains;
    }

    @Override // gnu.trove.TIntCollection
    public int[] toArray() {
        int[] array;
        synchronized (this.mutex) {
            array = this.c.toArray();
        }
        return array;
    }

    @Override // gnu.trove.TIntCollection
    public int[] toArray(int[] iArr) {
        int[] array;
        synchronized (this.mutex) {
            array = this.c.toArray(iArr);
        }
        return array;
    }

    @Override // gnu.trove.TIntCollection
    public TIntIterator iterator() {
        return this.c.iterator();
    }

    @Override // gnu.trove.TIntCollection
    public boolean add(int i) {
        boolean add;
        synchronized (this.mutex) {
            add = this.c.add(i);
        }
        return add;
    }

    @Override // gnu.trove.TIntCollection
    public boolean remove(int i) {
        boolean remove;
        synchronized (this.mutex) {
            remove = this.c.remove(i);
        }
        return remove;
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(collection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(TIntCollection tIntCollection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(tIntCollection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(int[] iArr) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(iArr);
        }
        return containsAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean addAll(Collection<? extends Integer> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(collection);
        }
        return addAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean addAll(TIntCollection tIntCollection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(tIntCollection);
        }
        return addAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean addAll(int[] iArr) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(iArr);
        }
        return addAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(collection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean removeAll(TIntCollection tIntCollection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(tIntCollection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean removeAll(int[] iArr) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(iArr);
        }
        return removeAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(collection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean retainAll(TIntCollection tIntCollection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(tIntCollection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean retainAll(int[] iArr) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(iArr);
        }
        return retainAll;
    }

    @Override // gnu.trove.TIntCollection
    public int getNoEntryValue() {
        return this.c.getNoEntryValue();
    }

    @Override // gnu.trove.TIntCollection
    public boolean forEach(TIntProcedure tIntProcedure) {
        boolean forEach;
        synchronized (this.mutex) {
            forEach = this.c.forEach(tIntProcedure);
        }
        return forEach;
    }

    @Override // gnu.trove.TIntCollection
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
