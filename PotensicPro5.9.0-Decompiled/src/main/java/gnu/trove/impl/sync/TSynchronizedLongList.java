package gnu.trove.impl.sync;

import gnu.trove.function.TLongFunction;
import gnu.trove.list.TLongList;
import gnu.trove.procedure.TLongProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedLongList extends TSynchronizedLongCollection implements TLongList {
    static final long serialVersionUID = -7754090372962971524L;
    final TLongList list;

    public TSynchronizedLongList(TLongList tLongList) {
        super(tLongList);
        this.list = tLongList;
    }

    public TSynchronizedLongList(TLongList tLongList, Object obj) {
        super(tLongList, obj);
        this.list = tLongList;
    }

    @Override // gnu.trove.TLongCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.list.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TLongCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.list.hashCode();
        }
        return hashCode;
    }

    @Override // gnu.trove.list.TLongList
    public long get(int i) {
        long j;
        synchronized (this.mutex) {
            j = this.list.get(i);
        }
        return j;
    }

    @Override // gnu.trove.list.TLongList
    public long set(int i, long j) {
        long j2;
        synchronized (this.mutex) {
            j2 = this.list.set(i, j);
        }
        return j2;
    }

    @Override // gnu.trove.list.TLongList
    public void set(int i, long[] jArr) {
        synchronized (this.mutex) {
            this.list.set(i, jArr);
        }
    }

    @Override // gnu.trove.list.TLongList
    public void set(int i, long[] jArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.set(i, jArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TLongList
    public long replace(int i, long j) {
        long replace;
        synchronized (this.mutex) {
            replace = this.list.replace(i, j);
        }
        return replace;
    }

    @Override // gnu.trove.list.TLongList
    public void remove(int i, int i2) {
        synchronized (this.mutex) {
            this.list.remove(i, i2);
        }
    }

    @Override // gnu.trove.list.TLongList
    public long removeAt(int i) {
        long removeAt;
        synchronized (this.mutex) {
            removeAt = this.list.removeAt(i);
        }
        return removeAt;
    }

    @Override // gnu.trove.list.TLongList
    public void add(long[] jArr) {
        synchronized (this.mutex) {
            this.list.add(jArr);
        }
    }

    @Override // gnu.trove.list.TLongList
    public void add(long[] jArr, int i, int i2) {
        synchronized (this.mutex) {
            this.list.add(jArr, i, i2);
        }
    }

    @Override // gnu.trove.list.TLongList
    public void insert(int i, long j) {
        synchronized (this.mutex) {
            this.list.insert(i, j);
        }
    }

    @Override // gnu.trove.list.TLongList
    public void insert(int i, long[] jArr) {
        synchronized (this.mutex) {
            this.list.insert(i, jArr);
        }
    }

    @Override // gnu.trove.list.TLongList
    public void insert(int i, long[] jArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.insert(i, jArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TLongList
    public int indexOf(long j) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(j);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TLongList
    public int lastIndexOf(long j) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(j);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TLongList
    public TLongList subList(int i, int i2) {
        TSynchronizedLongList tSynchronizedLongList;
        synchronized (this.mutex) {
            tSynchronizedLongList = new TSynchronizedLongList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedLongList;
    }

    @Override // gnu.trove.list.TLongList
    public long[] toArray(int i, int i2) {
        long[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TLongList
    public long[] toArray(long[] jArr, int i, int i2) {
        long[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(jArr, i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TLongList
    public long[] toArray(long[] jArr, int i, int i2, int i3) {
        long[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(jArr, i, i2, i3);
        }
        return array;
    }

    @Override // gnu.trove.list.TLongList
    public int indexOf(int i, long j) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(i, j);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TLongList
    public int lastIndexOf(int i, long j) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(i, j);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TLongList
    public void fill(long j) {
        synchronized (this.mutex) {
            this.list.fill(j);
        }
    }

    @Override // gnu.trove.list.TLongList
    public void fill(int i, int i2, long j) {
        synchronized (this.mutex) {
            this.list.fill(i, i2, j);
        }
    }

    @Override // gnu.trove.list.TLongList
    public void reverse() {
        synchronized (this.mutex) {
            this.list.reverse();
        }
    }

    @Override // gnu.trove.list.TLongList
    public void reverse(int i, int i2) {
        synchronized (this.mutex) {
            this.list.reverse(i, i2);
        }
    }

    @Override // gnu.trove.list.TLongList
    public void shuffle(Random random) {
        synchronized (this.mutex) {
            this.list.shuffle(random);
        }
    }

    @Override // gnu.trove.list.TLongList
    public void sort() {
        synchronized (this.mutex) {
            this.list.sort();
        }
    }

    @Override // gnu.trove.list.TLongList
    public void sort(int i, int i2) {
        synchronized (this.mutex) {
            this.list.sort(i, i2);
        }
    }

    @Override // gnu.trove.list.TLongList
    public int binarySearch(long j) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(j);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TLongList
    public int binarySearch(long j, int i, int i2) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(j, i, i2);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TLongList
    public TLongList grep(TLongProcedure tLongProcedure) {
        TLongList grep;
        synchronized (this.mutex) {
            grep = this.list.grep(tLongProcedure);
        }
        return grep;
    }

    @Override // gnu.trove.list.TLongList
    public TLongList inverseGrep(TLongProcedure tLongProcedure) {
        TLongList inverseGrep;
        synchronized (this.mutex) {
            inverseGrep = this.list.inverseGrep(tLongProcedure);
        }
        return inverseGrep;
    }

    @Override // gnu.trove.list.TLongList
    public long max() {
        long max;
        synchronized (this.mutex) {
            max = this.list.max();
        }
        return max;
    }

    @Override // gnu.trove.list.TLongList
    public long min() {
        long min;
        synchronized (this.mutex) {
            min = this.list.min();
        }
        return min;
    }

    @Override // gnu.trove.list.TLongList
    public long sum() {
        long sum;
        synchronized (this.mutex) {
            sum = this.list.sum();
        }
        return sum;
    }

    @Override // gnu.trove.list.TLongList
    public boolean forEachDescending(TLongProcedure tLongProcedure) {
        boolean forEachDescending;
        synchronized (this.mutex) {
            forEachDescending = this.list.forEachDescending(tLongProcedure);
        }
        return forEachDescending;
    }

    @Override // gnu.trove.list.TLongList
    public void transformValues(TLongFunction tLongFunction) {
        synchronized (this.mutex) {
            this.list.transformValues(tLongFunction);
        }
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TSynchronizedRandomAccessLongList(this.list) : this;
    }
}
