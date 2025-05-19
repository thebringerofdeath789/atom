package gnu.trove.impl.sync;

import gnu.trove.TFloatCollection;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.procedure.TFloatProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedFloatCollection implements TFloatCollection, Serializable {
    private static final long serialVersionUID = 3053995032091335093L;
    final TFloatCollection c;
    final Object mutex;

    public TSynchronizedFloatCollection(TFloatCollection tFloatCollection) {
        Objects.requireNonNull(tFloatCollection);
        this.c = tFloatCollection;
        this.mutex = this;
    }

    public TSynchronizedFloatCollection(TFloatCollection tFloatCollection, Object obj) {
        this.c = tFloatCollection;
        this.mutex = obj;
    }

    @Override // gnu.trove.TFloatCollection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.c.size();
        }
        return size;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.c.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean contains(float f) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.c.contains(f);
        }
        return contains;
    }

    @Override // gnu.trove.TFloatCollection
    public float[] toArray() {
        float[] array;
        synchronized (this.mutex) {
            array = this.c.toArray();
        }
        return array;
    }

    @Override // gnu.trove.TFloatCollection
    public float[] toArray(float[] fArr) {
        float[] array;
        synchronized (this.mutex) {
            array = this.c.toArray(fArr);
        }
        return array;
    }

    @Override // gnu.trove.TFloatCollection
    public TFloatIterator iterator() {
        return this.c.iterator();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean add(float f) {
        boolean add;
        synchronized (this.mutex) {
            add = this.c.add(f);
        }
        return add;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean remove(float f) {
        boolean remove;
        synchronized (this.mutex) {
            remove = this.c.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(collection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(TFloatCollection tFloatCollection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(tFloatCollection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(float[] fArr) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(fArr);
        }
        return containsAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean addAll(Collection<? extends Float> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(collection);
        }
        return addAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean addAll(TFloatCollection tFloatCollection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(tFloatCollection);
        }
        return addAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean addAll(float[] fArr) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(fArr);
        }
        return addAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(collection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean removeAll(TFloatCollection tFloatCollection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(tFloatCollection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean removeAll(float[] fArr) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(fArr);
        }
        return removeAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(collection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean retainAll(TFloatCollection tFloatCollection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(tFloatCollection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean retainAll(float[] fArr) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(fArr);
        }
        return retainAll;
    }

    @Override // gnu.trove.TFloatCollection
    public float getNoEntryValue() {
        return this.c.getNoEntryValue();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean forEach(TFloatProcedure tFloatProcedure) {
        boolean forEach;
        synchronized (this.mutex) {
            forEach = this.c.forEach(tFloatProcedure);
        }
        return forEach;
    }

    @Override // gnu.trove.TFloatCollection
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
