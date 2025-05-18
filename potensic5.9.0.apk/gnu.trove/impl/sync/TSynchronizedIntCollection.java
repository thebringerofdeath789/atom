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

    /* renamed from: c */
    final TIntCollection f3618c;
    final Object mutex;

    public TSynchronizedIntCollection(TIntCollection tIntCollection) {
        Objects.requireNonNull(tIntCollection);
        this.f3618c = tIntCollection;
        this.mutex = this;
    }

    public TSynchronizedIntCollection(TIntCollection tIntCollection, Object obj) {
        this.f3618c = tIntCollection;
        this.mutex = obj;
    }

    @Override // gnu.trove.TIntCollection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3618c.size();
        }
        return size;
    }

    @Override // gnu.trove.TIntCollection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3618c.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.TIntCollection
    public boolean contains(int i) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.f3618c.contains(i);
        }
        return contains;
    }

    @Override // gnu.trove.TIntCollection
    public int[] toArray() {
        int[] array;
        synchronized (this.mutex) {
            array = this.f3618c.toArray();
        }
        return array;
    }

    @Override // gnu.trove.TIntCollection
    public int[] toArray(int[] iArr) {
        int[] array;
        synchronized (this.mutex) {
            array = this.f3618c.toArray(iArr);
        }
        return array;
    }

    @Override // gnu.trove.TIntCollection
    public TIntIterator iterator() {
        return this.f3618c.iterator();
    }

    @Override // gnu.trove.TIntCollection
    public boolean add(int i) {
        boolean add;
        synchronized (this.mutex) {
            add = this.f3618c.add(i);
        }
        return add;
    }

    @Override // gnu.trove.TIntCollection
    public boolean remove(int i) {
        boolean remove;
        synchronized (this.mutex) {
            remove = this.f3618c.remove(i);
        }
        return remove;
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3618c.containsAll(collection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(TIntCollection tIntCollection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3618c.containsAll(tIntCollection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(int[] iArr) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3618c.containsAll(iArr);
        }
        return containsAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean addAll(Collection<? extends Integer> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3618c.addAll(collection);
        }
        return addAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean addAll(TIntCollection tIntCollection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3618c.addAll(tIntCollection);
        }
        return addAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean addAll(int[] iArr) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3618c.addAll(iArr);
        }
        return addAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3618c.removeAll(collection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean removeAll(TIntCollection tIntCollection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3618c.removeAll(tIntCollection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean removeAll(int[] iArr) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3618c.removeAll(iArr);
        }
        return removeAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3618c.retainAll(collection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean retainAll(TIntCollection tIntCollection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3618c.retainAll(tIntCollection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TIntCollection
    public boolean retainAll(int[] iArr) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3618c.retainAll(iArr);
        }
        return retainAll;
    }

    @Override // gnu.trove.TIntCollection
    public int getNoEntryValue() {
        return this.f3618c.getNoEntryValue();
    }

    @Override // gnu.trove.TIntCollection
    public boolean forEach(TIntProcedure tIntProcedure) {
        boolean forEach;
        synchronized (this.mutex) {
            forEach = this.f3618c.forEach(tIntProcedure);
        }
        return forEach;
    }

    @Override // gnu.trove.TIntCollection
    public void clear() {
        synchronized (this.mutex) {
            this.f3618c.clear();
        }
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3618c.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}