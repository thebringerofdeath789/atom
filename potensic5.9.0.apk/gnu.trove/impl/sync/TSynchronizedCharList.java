package gnu.trove.impl.sync;

import gnu.trove.function.TCharFunction;
import gnu.trove.list.TCharList;
import gnu.trove.procedure.TCharProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedCharList extends TSynchronizedCharCollection implements TCharList {
    static final long serialVersionUID = -7754090372962971524L;
    final TCharList list;

    public TSynchronizedCharList(TCharList tCharList) {
        super(tCharList);
        this.list = tCharList;
    }

    public TSynchronizedCharList(TCharList tCharList, Object obj) {
        super(tCharList, obj);
        this.list = tCharList;
    }

    @Override // gnu.trove.TCharCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.list.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TCharCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.list.hashCode();
        }
        return hashCode;
    }

    @Override // gnu.trove.list.TCharList
    public char get(int i) {
        char c;
        synchronized (this.mutex) {
            c = this.list.get(i);
        }
        return c;
    }

    @Override // gnu.trove.list.TCharList
    public char set(int i, char c) {
        char c2;
        synchronized (this.mutex) {
            c2 = this.list.set(i, c);
        }
        return c2;
    }

    @Override // gnu.trove.list.TCharList
    public void set(int i, char[] cArr) {
        synchronized (this.mutex) {
            this.list.set(i, cArr);
        }
    }

    @Override // gnu.trove.list.TCharList
    public void set(int i, char[] cArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.set(i, cArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TCharList
    public char replace(int i, char c) {
        char replace;
        synchronized (this.mutex) {
            replace = this.list.replace(i, c);
        }
        return replace;
    }

    @Override // gnu.trove.list.TCharList
    public void remove(int i, int i2) {
        synchronized (this.mutex) {
            this.list.remove(i, i2);
        }
    }

    @Override // gnu.trove.list.TCharList
    public char removeAt(int i) {
        char removeAt;
        synchronized (this.mutex) {
            removeAt = this.list.removeAt(i);
        }
        return removeAt;
    }

    @Override // gnu.trove.list.TCharList
    public void add(char[] cArr) {
        synchronized (this.mutex) {
            this.list.add(cArr);
        }
    }

    @Override // gnu.trove.list.TCharList
    public void add(char[] cArr, int i, int i2) {
        synchronized (this.mutex) {
            this.list.add(cArr, i, i2);
        }
    }

    @Override // gnu.trove.list.TCharList
    public void insert(int i, char c) {
        synchronized (this.mutex) {
            this.list.insert(i, c);
        }
    }

    @Override // gnu.trove.list.TCharList
    public void insert(int i, char[] cArr) {
        synchronized (this.mutex) {
            this.list.insert(i, cArr);
        }
    }

    @Override // gnu.trove.list.TCharList
    public void insert(int i, char[] cArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.insert(i, cArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TCharList
    public int indexOf(char c) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(c);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TCharList
    public int lastIndexOf(char c) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(c);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TCharList
    public TCharList subList(int i, int i2) {
        TSynchronizedCharList tSynchronizedCharList;
        synchronized (this.mutex) {
            tSynchronizedCharList = new TSynchronizedCharList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedCharList;
    }

    @Override // gnu.trove.list.TCharList
    public char[] toArray(int i, int i2) {
        char[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TCharList
    public char[] toArray(char[] cArr, int i, int i2) {
        char[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(cArr, i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TCharList
    public char[] toArray(char[] cArr, int i, int i2, int i3) {
        char[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(cArr, i, i2, i3);
        }
        return array;
    }

    @Override // gnu.trove.list.TCharList
    public int indexOf(int i, char c) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(i, c);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TCharList
    public int lastIndexOf(int i, char c) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(i, c);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TCharList
    public void fill(char c) {
        synchronized (this.mutex) {
            this.list.fill(c);
        }
    }

    @Override // gnu.trove.list.TCharList
    public void fill(int i, int i2, char c) {
        synchronized (this.mutex) {
            this.list.fill(i, i2, c);
        }
    }

    @Override // gnu.trove.list.TCharList
    public void reverse() {
        synchronized (this.mutex) {
            this.list.reverse();
        }
    }

    @Override // gnu.trove.list.TCharList
    public void reverse(int i, int i2) {
        synchronized (this.mutex) {
            this.list.reverse(i, i2);
        }
    }

    @Override // gnu.trove.list.TCharList
    public void shuffle(Random random) {
        synchronized (this.mutex) {
            this.list.shuffle(random);
        }
    }

    @Override // gnu.trove.list.TCharList
    public void sort() {
        synchronized (this.mutex) {
            this.list.sort();
        }
    }

    @Override // gnu.trove.list.TCharList
    public void sort(int i, int i2) {
        synchronized (this.mutex) {
            this.list.sort(i, i2);
        }
    }

    @Override // gnu.trove.list.TCharList
    public int binarySearch(char c) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(c);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TCharList
    public int binarySearch(char c, int i, int i2) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(c, i, i2);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TCharList
    public TCharList grep(TCharProcedure tCharProcedure) {
        TCharList grep;
        synchronized (this.mutex) {
            grep = this.list.grep(tCharProcedure);
        }
        return grep;
    }

    @Override // gnu.trove.list.TCharList
    public TCharList inverseGrep(TCharProcedure tCharProcedure) {
        TCharList inverseGrep;
        synchronized (this.mutex) {
            inverseGrep = this.list.inverseGrep(tCharProcedure);
        }
        return inverseGrep;
    }

    @Override // gnu.trove.list.TCharList
    public char max() {
        char max;
        synchronized (this.mutex) {
            max = this.list.max();
        }
        return max;
    }

    @Override // gnu.trove.list.TCharList
    public char min() {
        char min;
        synchronized (this.mutex) {
            min = this.list.min();
        }
        return min;
    }

    @Override // gnu.trove.list.TCharList
    public char sum() {
        char sum;
        synchronized (this.mutex) {
            sum = this.list.sum();
        }
        return sum;
    }

    @Override // gnu.trove.list.TCharList
    public boolean forEachDescending(TCharProcedure tCharProcedure) {
        boolean forEachDescending;
        synchronized (this.mutex) {
            forEachDescending = this.list.forEachDescending(tCharProcedure);
        }
        return forEachDescending;
    }

    @Override // gnu.trove.list.TCharList
    public void transformValues(TCharFunction tCharFunction) {
        synchronized (this.mutex) {
            this.list.transformValues(tCharFunction);
        }
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TSynchronizedRandomAccessCharList(this.list) : this;
    }
}