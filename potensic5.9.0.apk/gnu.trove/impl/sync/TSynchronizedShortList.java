package gnu.trove.impl.sync;

import gnu.trove.function.TShortFunction;
import gnu.trove.list.TShortList;
import gnu.trove.procedure.TShortProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedShortList extends TSynchronizedShortCollection implements TShortList {
    static final long serialVersionUID = -7754090372962971524L;
    final TShortList list;

    public TSynchronizedShortList(TShortList tShortList) {
        super(tShortList);
        this.list = tShortList;
    }

    public TSynchronizedShortList(TShortList tShortList, Object obj) {
        super(tShortList, obj);
        this.list = tShortList;
    }

    @Override // gnu.trove.TShortCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.list.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TShortCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.list.hashCode();
        }
        return hashCode;
    }

    @Override // gnu.trove.list.TShortList
    public short get(int i) {
        short s;
        synchronized (this.mutex) {
            s = this.list.get(i);
        }
        return s;
    }

    @Override // gnu.trove.list.TShortList
    public short set(int i, short s) {
        short s2;
        synchronized (this.mutex) {
            s2 = this.list.set(i, s);
        }
        return s2;
    }

    @Override // gnu.trove.list.TShortList
    public void set(int i, short[] sArr) {
        synchronized (this.mutex) {
            this.list.set(i, sArr);
        }
    }

    @Override // gnu.trove.list.TShortList
    public void set(int i, short[] sArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.set(i, sArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TShortList
    public short replace(int i, short s) {
        short replace;
        synchronized (this.mutex) {
            replace = this.list.replace(i, s);
        }
        return replace;
    }

    @Override // gnu.trove.list.TShortList
    public void remove(int i, int i2) {
        synchronized (this.mutex) {
            this.list.remove(i, i2);
        }
    }

    @Override // gnu.trove.list.TShortList
    public short removeAt(int i) {
        short removeAt;
        synchronized (this.mutex) {
            removeAt = this.list.removeAt(i);
        }
        return removeAt;
    }

    @Override // gnu.trove.list.TShortList
    public void add(short[] sArr) {
        synchronized (this.mutex) {
            this.list.add(sArr);
        }
    }

    @Override // gnu.trove.list.TShortList
    public void add(short[] sArr, int i, int i2) {
        synchronized (this.mutex) {
            this.list.add(sArr, i, i2);
        }
    }

    @Override // gnu.trove.list.TShortList
    public void insert(int i, short s) {
        synchronized (this.mutex) {
            this.list.insert(i, s);
        }
    }

    @Override // gnu.trove.list.TShortList
    public void insert(int i, short[] sArr) {
        synchronized (this.mutex) {
            this.list.insert(i, sArr);
        }
    }

    @Override // gnu.trove.list.TShortList
    public void insert(int i, short[] sArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.insert(i, sArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TShortList
    public int indexOf(short s) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(s);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TShortList
    public int lastIndexOf(short s) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(s);
        }
        return lastIndexOf;
    }

    public TShortList subList(int i, int i2) {
        TSynchronizedShortList tSynchronizedShortList;
        synchronized (this.mutex) {
            tSynchronizedShortList = new TSynchronizedShortList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedShortList;
    }

    @Override // gnu.trove.list.TShortList
    public short[] toArray(int i, int i2) {
        short[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TShortList
    public short[] toArray(short[] sArr, int i, int i2) {
        short[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(sArr, i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TShortList
    public short[] toArray(short[] sArr, int i, int i2, int i3) {
        short[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(sArr, i, i2, i3);
        }
        return array;
    }

    @Override // gnu.trove.list.TShortList
    public int indexOf(int i, short s) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(i, s);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TShortList
    public int lastIndexOf(int i, short s) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(i, s);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TShortList
    public void fill(short s) {
        synchronized (this.mutex) {
            this.list.fill(s);
        }
    }

    @Override // gnu.trove.list.TShortList
    public void fill(int i, int i2, short s) {
        synchronized (this.mutex) {
            this.list.fill(i, i2, s);
        }
    }

    @Override // gnu.trove.list.TShortList
    public void reverse() {
        synchronized (this.mutex) {
            this.list.reverse();
        }
    }

    @Override // gnu.trove.list.TShortList
    public void reverse(int i, int i2) {
        synchronized (this.mutex) {
            this.list.reverse(i, i2);
        }
    }

    @Override // gnu.trove.list.TShortList
    public void shuffle(Random random) {
        synchronized (this.mutex) {
            this.list.shuffle(random);
        }
    }

    @Override // gnu.trove.list.TShortList
    public void sort() {
        synchronized (this.mutex) {
            this.list.sort();
        }
    }

    @Override // gnu.trove.list.TShortList
    public void sort(int i, int i2) {
        synchronized (this.mutex) {
            this.list.sort(i, i2);
        }
    }

    @Override // gnu.trove.list.TShortList
    public int binarySearch(short s) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(s);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TShortList
    public int binarySearch(short s, int i, int i2) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(s, i, i2);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TShortList
    public TShortList grep(TShortProcedure tShortProcedure) {
        TShortList grep;
        synchronized (this.mutex) {
            grep = this.list.grep(tShortProcedure);
        }
        return grep;
    }

    @Override // gnu.trove.list.TShortList
    public TShortList inverseGrep(TShortProcedure tShortProcedure) {
        TShortList inverseGrep;
        synchronized (this.mutex) {
            inverseGrep = this.list.inverseGrep(tShortProcedure);
        }
        return inverseGrep;
    }

    @Override // gnu.trove.list.TShortList
    public short max() {
        short max;
        synchronized (this.mutex) {
            max = this.list.max();
        }
        return max;
    }

    @Override // gnu.trove.list.TShortList
    public short min() {
        short min;
        synchronized (this.mutex) {
            min = this.list.min();
        }
        return min;
    }

    @Override // gnu.trove.list.TShortList
    public short sum() {
        short sum;
        synchronized (this.mutex) {
            sum = this.list.sum();
        }
        return sum;
    }

    @Override // gnu.trove.list.TShortList
    public boolean forEachDescending(TShortProcedure tShortProcedure) {
        boolean forEachDescending;
        synchronized (this.mutex) {
            forEachDescending = this.list.forEachDescending(tShortProcedure);
        }
        return forEachDescending;
    }

    @Override // gnu.trove.list.TShortList
    public void transformValues(TShortFunction tShortFunction) {
        synchronized (this.mutex) {
            this.list.transformValues(tShortFunction);
        }
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TSynchronizedRandomAccessShortList(this.list) : this;
    }
}