package gnu.trove.impl.sync;

import gnu.trove.function.TDoubleFunction;
import gnu.trove.list.TDoubleList;
import gnu.trove.procedure.TDoubleProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedDoubleList extends TSynchronizedDoubleCollection implements TDoubleList {
    static final long serialVersionUID = -7754090372962971524L;
    final TDoubleList list;

    public TSynchronizedDoubleList(TDoubleList tDoubleList) {
        super(tDoubleList);
        this.list = tDoubleList;
    }

    public TSynchronizedDoubleList(TDoubleList tDoubleList, Object obj) {
        super(tDoubleList, obj);
        this.list = tDoubleList;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.list.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TDoubleCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.list.hashCode();
        }
        return hashCode;
    }

    @Override // gnu.trove.list.TDoubleList
    public double get(int i) {
        double d;
        synchronized (this.mutex) {
            d = this.list.get(i);
        }
        return d;
    }

    @Override // gnu.trove.list.TDoubleList
    public double set(int i, double d) {
        double d2;
        synchronized (this.mutex) {
            d2 = this.list.set(i, d);
        }
        return d2;
    }

    @Override // gnu.trove.list.TDoubleList
    public void set(int i, double[] dArr) {
        synchronized (this.mutex) {
            this.list.set(i, dArr);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void set(int i, double[] dArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.set(i, dArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public double replace(int i, double d) {
        double replace;
        synchronized (this.mutex) {
            replace = this.list.replace(i, d);
        }
        return replace;
    }

    @Override // gnu.trove.list.TDoubleList
    public void remove(int i, int i2) {
        synchronized (this.mutex) {
            this.list.remove(i, i2);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public double removeAt(int i) {
        double removeAt;
        synchronized (this.mutex) {
            removeAt = this.list.removeAt(i);
        }
        return removeAt;
    }

    @Override // gnu.trove.list.TDoubleList
    public void add(double[] dArr) {
        synchronized (this.mutex) {
            this.list.add(dArr);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void add(double[] dArr, int i, int i2) {
        synchronized (this.mutex) {
            this.list.add(dArr, i, i2);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void insert(int i, double d) {
        synchronized (this.mutex) {
            this.list.insert(i, d);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void insert(int i, double[] dArr) {
        synchronized (this.mutex) {
            this.list.insert(i, dArr);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void insert(int i, double[] dArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.insert(i, dArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public int indexOf(double d) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(d);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TDoubleList
    public int lastIndexOf(double d) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(d);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TDoubleList
    public TDoubleList subList(int i, int i2) {
        TSynchronizedDoubleList tSynchronizedDoubleList;
        synchronized (this.mutex) {
            tSynchronizedDoubleList = new TSynchronizedDoubleList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedDoubleList;
    }

    @Override // gnu.trove.list.TDoubleList
    public double[] toArray(int i, int i2) {
        double[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TDoubleList
    public double[] toArray(double[] dArr, int i, int i2) {
        double[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(dArr, i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TDoubleList
    public double[] toArray(double[] dArr, int i, int i2, int i3) {
        double[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(dArr, i, i2, i3);
        }
        return array;
    }

    @Override // gnu.trove.list.TDoubleList
    public int indexOf(int i, double d) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(i, d);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TDoubleList
    public int lastIndexOf(int i, double d) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(i, d);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TDoubleList
    public void fill(double d) {
        synchronized (this.mutex) {
            this.list.fill(d);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void fill(int i, int i2, double d) {
        synchronized (this.mutex) {
            this.list.fill(i, i2, d);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void reverse() {
        synchronized (this.mutex) {
            this.list.reverse();
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void reverse(int i, int i2) {
        synchronized (this.mutex) {
            this.list.reverse(i, i2);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void shuffle(Random random) {
        synchronized (this.mutex) {
            this.list.shuffle(random);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void sort() {
        synchronized (this.mutex) {
            this.list.sort();
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public void sort(int i, int i2) {
        synchronized (this.mutex) {
            this.list.sort(i, i2);
        }
    }

    @Override // gnu.trove.list.TDoubleList
    public int binarySearch(double d) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(d);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TDoubleList
    public int binarySearch(double d, int i, int i2) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(d, i, i2);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TDoubleList
    public TDoubleList grep(TDoubleProcedure tDoubleProcedure) {
        TDoubleList grep;
        synchronized (this.mutex) {
            grep = this.list.grep(tDoubleProcedure);
        }
        return grep;
    }

    @Override // gnu.trove.list.TDoubleList
    public TDoubleList inverseGrep(TDoubleProcedure tDoubleProcedure) {
        TDoubleList inverseGrep;
        synchronized (this.mutex) {
            inverseGrep = this.list.inverseGrep(tDoubleProcedure);
        }
        return inverseGrep;
    }

    @Override // gnu.trove.list.TDoubleList
    public double max() {
        double max;
        synchronized (this.mutex) {
            max = this.list.max();
        }
        return max;
    }

    @Override // gnu.trove.list.TDoubleList
    public double min() {
        double min;
        synchronized (this.mutex) {
            min = this.list.min();
        }
        return min;
    }

    @Override // gnu.trove.list.TDoubleList
    public double sum() {
        double sum;
        synchronized (this.mutex) {
            sum = this.list.sum();
        }
        return sum;
    }

    @Override // gnu.trove.list.TDoubleList
    public boolean forEachDescending(TDoubleProcedure tDoubleProcedure) {
        boolean forEachDescending;
        synchronized (this.mutex) {
            forEachDescending = this.list.forEachDescending(tDoubleProcedure);
        }
        return forEachDescending;
    }

    @Override // gnu.trove.list.TDoubleList
    public void transformValues(TDoubleFunction tDoubleFunction) {
        synchronized (this.mutex) {
            this.list.transformValues(tDoubleFunction);
        }
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TSynchronizedRandomAccessDoubleList(this.list) : this;
    }
}
