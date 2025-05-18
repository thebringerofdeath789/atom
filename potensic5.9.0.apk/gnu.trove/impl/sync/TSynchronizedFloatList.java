package gnu.trove.impl.sync;

import gnu.trove.function.TFloatFunction;
import gnu.trove.list.TFloatList;
import gnu.trove.procedure.TFloatProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedFloatList extends TSynchronizedFloatCollection implements TFloatList {
    static final long serialVersionUID = -7754090372962971524L;
    final TFloatList list;

    public TSynchronizedFloatList(TFloatList tFloatList) {
        super(tFloatList);
        this.list = tFloatList;
    }

    public TSynchronizedFloatList(TFloatList tFloatList, Object obj) {
        super(tFloatList, obj);
        this.list = tFloatList;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.list.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TFloatCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.list.hashCode();
        }
        return hashCode;
    }

    @Override // gnu.trove.list.TFloatList
    public float get(int i) {
        float f;
        synchronized (this.mutex) {
            f = this.list.get(i);
        }
        return f;
    }

    @Override // gnu.trove.list.TFloatList
    public float set(int i, float f) {
        float f2;
        synchronized (this.mutex) {
            f2 = this.list.set(i, f);
        }
        return f2;
    }

    @Override // gnu.trove.list.TFloatList
    public void set(int i, float[] fArr) {
        synchronized (this.mutex) {
            this.list.set(i, fArr);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void set(int i, float[] fArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.set(i, fArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public float replace(int i, float f) {
        float replace;
        synchronized (this.mutex) {
            replace = this.list.replace(i, f);
        }
        return replace;
    }

    @Override // gnu.trove.list.TFloatList
    public void remove(int i, int i2) {
        synchronized (this.mutex) {
            this.list.remove(i, i2);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public float removeAt(int i) {
        float removeAt;
        synchronized (this.mutex) {
            removeAt = this.list.removeAt(i);
        }
        return removeAt;
    }

    @Override // gnu.trove.list.TFloatList
    public void add(float[] fArr) {
        synchronized (this.mutex) {
            this.list.add(fArr);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void add(float[] fArr, int i, int i2) {
        synchronized (this.mutex) {
            this.list.add(fArr, i, i2);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void insert(int i, float f) {
        synchronized (this.mutex) {
            this.list.insert(i, f);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void insert(int i, float[] fArr) {
        synchronized (this.mutex) {
            this.list.insert(i, fArr);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void insert(int i, float[] fArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.insert(i, fArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public int indexOf(float f) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(f);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TFloatList
    public int lastIndexOf(float f) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(f);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TFloatList
    public TFloatList subList(int i, int i2) {
        TSynchronizedFloatList tSynchronizedFloatList;
        synchronized (this.mutex) {
            tSynchronizedFloatList = new TSynchronizedFloatList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedFloatList;
    }

    @Override // gnu.trove.list.TFloatList
    public float[] toArray(int i, int i2) {
        float[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TFloatList
    public float[] toArray(float[] fArr, int i, int i2) {
        float[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(fArr, i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TFloatList
    public float[] toArray(float[] fArr, int i, int i2, int i3) {
        float[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(fArr, i, i2, i3);
        }
        return array;
    }

    @Override // gnu.trove.list.TFloatList
    public int indexOf(int i, float f) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(i, f);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TFloatList
    public int lastIndexOf(int i, float f) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(i, f);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TFloatList
    public void fill(float f) {
        synchronized (this.mutex) {
            this.list.fill(f);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void fill(int i, int i2, float f) {
        synchronized (this.mutex) {
            this.list.fill(i, i2, f);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void reverse() {
        synchronized (this.mutex) {
            this.list.reverse();
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void reverse(int i, int i2) {
        synchronized (this.mutex) {
            this.list.reverse(i, i2);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void shuffle(Random random) {
        synchronized (this.mutex) {
            this.list.shuffle(random);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void sort() {
        synchronized (this.mutex) {
            this.list.sort();
        }
    }

    @Override // gnu.trove.list.TFloatList
    public void sort(int i, int i2) {
        synchronized (this.mutex) {
            this.list.sort(i, i2);
        }
    }

    @Override // gnu.trove.list.TFloatList
    public int binarySearch(float f) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(f);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TFloatList
    public int binarySearch(float f, int i, int i2) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(f, i, i2);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TFloatList
    public TFloatList grep(TFloatProcedure tFloatProcedure) {
        TFloatList grep;
        synchronized (this.mutex) {
            grep = this.list.grep(tFloatProcedure);
        }
        return grep;
    }

    @Override // gnu.trove.list.TFloatList
    public TFloatList inverseGrep(TFloatProcedure tFloatProcedure) {
        TFloatList inverseGrep;
        synchronized (this.mutex) {
            inverseGrep = this.list.inverseGrep(tFloatProcedure);
        }
        return inverseGrep;
    }

    @Override // gnu.trove.list.TFloatList
    public float max() {
        float max;
        synchronized (this.mutex) {
            max = this.list.max();
        }
        return max;
    }

    @Override // gnu.trove.list.TFloatList
    public float min() {
        float min;
        synchronized (this.mutex) {
            min = this.list.min();
        }
        return min;
    }

    @Override // gnu.trove.list.TFloatList
    public float sum() {
        float sum;
        synchronized (this.mutex) {
            sum = this.list.sum();
        }
        return sum;
    }

    @Override // gnu.trove.list.TFloatList
    public boolean forEachDescending(TFloatProcedure tFloatProcedure) {
        boolean forEachDescending;
        synchronized (this.mutex) {
            forEachDescending = this.list.forEachDescending(tFloatProcedure);
        }
        return forEachDescending;
    }

    @Override // gnu.trove.list.TFloatList
    public void transformValues(TFloatFunction tFloatFunction) {
        synchronized (this.mutex) {
            this.list.transformValues(tFloatFunction);
        }
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TSynchronizedRandomAccessFloatList(this.list) : this;
    }
}