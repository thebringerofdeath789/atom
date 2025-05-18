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

    /* renamed from: c */
    final TFloatCollection f3609c;
    final Object mutex;

    public TSynchronizedFloatCollection(TFloatCollection tFloatCollection) {
        Objects.requireNonNull(tFloatCollection);
        this.f3609c = tFloatCollection;
        this.mutex = this;
    }

    public TSynchronizedFloatCollection(TFloatCollection tFloatCollection, Object obj) {
        this.f3609c = tFloatCollection;
        this.mutex = obj;
    }

    @Override // gnu.trove.TFloatCollection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3609c.size();
        }
        return size;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3609c.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean contains(float f) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.f3609c.contains(f);
        }
        return contains;
    }

    @Override // gnu.trove.TFloatCollection
    public float[] toArray() {
        float[] array;
        synchronized (this.mutex) {
            array = this.f3609c.toArray();
        }
        return array;
    }

    @Override // gnu.trove.TFloatCollection
    public float[] toArray(float[] fArr) {
        float[] array;
        synchronized (this.mutex) {
            array = this.f3609c.toArray(fArr);
        }
        return array;
    }

    @Override // gnu.trove.TFloatCollection
    public TFloatIterator iterator() {
        return this.f3609c.iterator();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean add(float f) {
        boolean add;
        synchronized (this.mutex) {
            add = this.f3609c.add(f);
        }
        return add;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean remove(float f) {
        boolean remove;
        synchronized (this.mutex) {
            remove = this.f3609c.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3609c.containsAll(collection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(TFloatCollection tFloatCollection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3609c.containsAll(tFloatCollection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(float[] fArr) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3609c.containsAll(fArr);
        }
        return containsAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean addAll(Collection<? extends Float> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3609c.addAll(collection);
        }
        return addAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean addAll(TFloatCollection tFloatCollection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3609c.addAll(tFloatCollection);
        }
        return addAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean addAll(float[] fArr) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3609c.addAll(fArr);
        }
        return addAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3609c.removeAll(collection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean removeAll(TFloatCollection tFloatCollection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3609c.removeAll(tFloatCollection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean removeAll(float[] fArr) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3609c.removeAll(fArr);
        }
        return removeAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3609c.retainAll(collection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean retainAll(TFloatCollection tFloatCollection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3609c.retainAll(tFloatCollection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean retainAll(float[] fArr) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3609c.retainAll(fArr);
        }
        return retainAll;
    }

    @Override // gnu.trove.TFloatCollection
    public float getNoEntryValue() {
        return this.f3609c.getNoEntryValue();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean forEach(TFloatProcedure tFloatProcedure) {
        boolean forEach;
        synchronized (this.mutex) {
            forEach = this.f3609c.forEach(tFloatProcedure);
        }
        return forEach;
    }

    @Override // gnu.trove.TFloatCollection
    public void clear() {
        synchronized (this.mutex) {
            this.f3609c.clear();
        }
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3609c.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}