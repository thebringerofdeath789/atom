package gnu.trove.impl.sync;

import gnu.trove.function.TIntFunction;
import gnu.trove.list.TIntList;
import gnu.trove.procedure.TIntProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedIntList extends TSynchronizedIntCollection implements TIntList {
    static final long serialVersionUID = -7754090372962971524L;
    final TIntList list;

    public TSynchronizedIntList(TIntList tIntList) {
        super(tIntList);
        this.list = tIntList;
    }

    public TSynchronizedIntList(TIntList tIntList, Object obj) {
        super(tIntList, obj);
        this.list = tIntList;
    }

    @Override // gnu.trove.TIntCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.list.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TIntCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.list.hashCode();
        }
        return hashCode;
    }

    @Override // gnu.trove.list.TIntList
    public int get(int i) {
        int i2;
        synchronized (this.mutex) {
            i2 = this.list.get(i);
        }
        return i2;
    }

    @Override // gnu.trove.list.TIntList
    public int set(int i, int i2) {
        int i3;
        synchronized (this.mutex) {
            i3 = this.list.set(i, i2);
        }
        return i3;
    }

    @Override // gnu.trove.list.TIntList
    public void set(int i, int[] iArr) {
        synchronized (this.mutex) {
            this.list.set(i, iArr);
        }
    }

    @Override // gnu.trove.list.TIntList
    public void set(int i, int[] iArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.set(i, iArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TIntList
    public int replace(int i, int i2) {
        int replace;
        synchronized (this.mutex) {
            replace = this.list.replace(i, i2);
        }
        return replace;
    }

    @Override // gnu.trove.list.TIntList
    public void remove(int i, int i2) {
        synchronized (this.mutex) {
            this.list.remove(i, i2);
        }
    }

    @Override // gnu.trove.list.TIntList
    public int removeAt(int i) {
        int removeAt;
        synchronized (this.mutex) {
            removeAt = this.list.removeAt(i);
        }
        return removeAt;
    }

    @Override // gnu.trove.list.TIntList
    public void add(int[] iArr) {
        synchronized (this.mutex) {
            this.list.add(iArr);
        }
    }

    @Override // gnu.trove.list.TIntList
    public void add(int[] iArr, int i, int i2) {
        synchronized (this.mutex) {
            this.list.add(iArr, i, i2);
        }
    }

    @Override // gnu.trove.list.TIntList
    public void insert(int i, int i2) {
        synchronized (this.mutex) {
            this.list.insert(i, i2);
        }
    }

    @Override // gnu.trove.list.TIntList
    public void insert(int i, int[] iArr) {
        synchronized (this.mutex) {
            this.list.insert(i, iArr);
        }
    }

    @Override // gnu.trove.list.TIntList
    public void insert(int i, int[] iArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.insert(i, iArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TIntList
    public int indexOf(int i) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(i);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TIntList
    public int lastIndexOf(int i) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(i);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TIntList
    public TIntList subList(int i, int i2) {
        TSynchronizedIntList tSynchronizedIntList;
        synchronized (this.mutex) {
            tSynchronizedIntList = new TSynchronizedIntList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedIntList;
    }

    @Override // gnu.trove.list.TIntList
    public int[] toArray(int i, int i2) {
        int[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TIntList
    public int[] toArray(int[] iArr, int i, int i2) {
        int[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(iArr, i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TIntList
    public int[] toArray(int[] iArr, int i, int i2, int i3) {
        int[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(iArr, i, i2, i3);
        }
        return array;
    }

    @Override // gnu.trove.list.TIntList
    public int indexOf(int i, int i2) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(i, i2);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TIntList
    public int lastIndexOf(int i, int i2) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(i, i2);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TIntList
    public void fill(int i) {
        synchronized (this.mutex) {
            this.list.fill(i);
        }
    }

    @Override // gnu.trove.list.TIntList
    public void fill(int i, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.fill(i, i2, i3);
        }
    }

    @Override // gnu.trove.list.TIntList
    public void reverse() {
        synchronized (this.mutex) {
            this.list.reverse();
        }
    }

    @Override // gnu.trove.list.TIntList
    public void reverse(int i, int i2) {
        synchronized (this.mutex) {
            this.list.reverse(i, i2);
        }
    }

    @Override // gnu.trove.list.TIntList
    public void shuffle(Random random) {
        synchronized (this.mutex) {
            this.list.shuffle(random);
        }
    }

    @Override // gnu.trove.list.TIntList
    public void sort() {
        synchronized (this.mutex) {
            this.list.sort();
        }
    }

    @Override // gnu.trove.list.TIntList
    public void sort(int i, int i2) {
        synchronized (this.mutex) {
            this.list.sort(i, i2);
        }
    }

    @Override // gnu.trove.list.TIntList
    public int binarySearch(int i) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(i);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TIntList
    public int binarySearch(int i, int i2, int i3) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(i, i2, i3);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TIntList
    public TIntList grep(TIntProcedure tIntProcedure) {
        TIntList grep;
        synchronized (this.mutex) {
            grep = this.list.grep(tIntProcedure);
        }
        return grep;
    }

    @Override // gnu.trove.list.TIntList
    public TIntList inverseGrep(TIntProcedure tIntProcedure) {
        TIntList inverseGrep;
        synchronized (this.mutex) {
            inverseGrep = this.list.inverseGrep(tIntProcedure);
        }
        return inverseGrep;
    }

    @Override // gnu.trove.list.TIntList
    public int max() {
        int max;
        synchronized (this.mutex) {
            max = this.list.max();
        }
        return max;
    }

    @Override // gnu.trove.list.TIntList
    public int min() {
        int min;
        synchronized (this.mutex) {
            min = this.list.min();
        }
        return min;
    }

    @Override // gnu.trove.list.TIntList
    public int sum() {
        int sum;
        synchronized (this.mutex) {
            sum = this.list.sum();
        }
        return sum;
    }

    @Override // gnu.trove.list.TIntList
    public boolean forEachDescending(TIntProcedure tIntProcedure) {
        boolean forEachDescending;
        synchronized (this.mutex) {
            forEachDescending = this.list.forEachDescending(tIntProcedure);
        }
        return forEachDescending;
    }

    @Override // gnu.trove.list.TIntList
    public void transformValues(TIntFunction tIntFunction) {
        synchronized (this.mutex) {
            this.list.transformValues(tIntFunction);
        }
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TSynchronizedRandomAccessIntList(this.list) : this;
    }
}
