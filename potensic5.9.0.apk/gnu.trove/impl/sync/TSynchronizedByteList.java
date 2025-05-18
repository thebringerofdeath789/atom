package gnu.trove.impl.sync;

import gnu.trove.function.TByteFunction;
import gnu.trove.list.TByteList;
import gnu.trove.procedure.TByteProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TSynchronizedByteList extends TSynchronizedByteCollection implements TByteList {
    static final long serialVersionUID = -7754090372962971524L;
    final TByteList list;

    public TSynchronizedByteList(TByteList tByteList) {
        super(tByteList);
        this.list = tByteList;
    }

    public TSynchronizedByteList(TByteList tByteList, Object obj) {
        super(tByteList, obj);
        this.list = tByteList;
    }

    @Override // gnu.trove.TByteCollection
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.list.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.TByteCollection
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.list.hashCode();
        }
        return hashCode;
    }

    @Override // gnu.trove.list.TByteList
    public byte get(int i) {
        byte b;
        synchronized (this.mutex) {
            b = this.list.get(i);
        }
        return b;
    }

    @Override // gnu.trove.list.TByteList
    public byte set(int i, byte b) {
        byte b2;
        synchronized (this.mutex) {
            b2 = this.list.set(i, b);
        }
        return b2;
    }

    @Override // gnu.trove.list.TByteList
    public void set(int i, byte[] bArr) {
        synchronized (this.mutex) {
            this.list.set(i, bArr);
        }
    }

    @Override // gnu.trove.list.TByteList
    public void set(int i, byte[] bArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.set(i, bArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TByteList
    public byte replace(int i, byte b) {
        byte replace;
        synchronized (this.mutex) {
            replace = this.list.replace(i, b);
        }
        return replace;
    }

    @Override // gnu.trove.list.TByteList
    public void remove(int i, int i2) {
        synchronized (this.mutex) {
            this.list.remove(i, i2);
        }
    }

    @Override // gnu.trove.list.TByteList
    public byte removeAt(int i) {
        byte removeAt;
        synchronized (this.mutex) {
            removeAt = this.list.removeAt(i);
        }
        return removeAt;
    }

    @Override // gnu.trove.list.TByteList
    public void add(byte[] bArr) {
        synchronized (this.mutex) {
            this.list.add(bArr);
        }
    }

    @Override // gnu.trove.list.TByteList
    public void add(byte[] bArr, int i, int i2) {
        synchronized (this.mutex) {
            this.list.add(bArr, i, i2);
        }
    }

    @Override // gnu.trove.list.TByteList
    public void insert(int i, byte b) {
        synchronized (this.mutex) {
            this.list.insert(i, b);
        }
    }

    @Override // gnu.trove.list.TByteList
    public void insert(int i, byte[] bArr) {
        synchronized (this.mutex) {
            this.list.insert(i, bArr);
        }
    }

    @Override // gnu.trove.list.TByteList
    public void insert(int i, byte[] bArr, int i2, int i3) {
        synchronized (this.mutex) {
            this.list.insert(i, bArr, i2, i3);
        }
    }

    @Override // gnu.trove.list.TByteList
    public int indexOf(byte b) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(b);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TByteList
    public int lastIndexOf(byte b) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(b);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TByteList
    public TByteList subList(int i, int i2) {
        TSynchronizedByteList tSynchronizedByteList;
        synchronized (this.mutex) {
            tSynchronizedByteList = new TSynchronizedByteList(this.list.subList(i, i2), this.mutex);
        }
        return tSynchronizedByteList;
    }

    @Override // gnu.trove.list.TByteList
    public byte[] toArray(int i, int i2) {
        byte[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TByteList
    public byte[] toArray(byte[] bArr, int i, int i2) {
        byte[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(bArr, i, i2);
        }
        return array;
    }

    @Override // gnu.trove.list.TByteList
    public byte[] toArray(byte[] bArr, int i, int i2, int i3) {
        byte[] array;
        synchronized (this.mutex) {
            array = this.list.toArray(bArr, i, i2, i3);
        }
        return array;
    }

    @Override // gnu.trove.list.TByteList
    public int indexOf(int i, byte b) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = this.list.indexOf(i, b);
        }
        return indexOf;
    }

    @Override // gnu.trove.list.TByteList
    public int lastIndexOf(int i, byte b) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = this.list.lastIndexOf(i, b);
        }
        return lastIndexOf;
    }

    @Override // gnu.trove.list.TByteList
    public void fill(byte b) {
        synchronized (this.mutex) {
            this.list.fill(b);
        }
    }

    @Override // gnu.trove.list.TByteList
    public void fill(int i, int i2, byte b) {
        synchronized (this.mutex) {
            this.list.fill(i, i2, b);
        }
    }

    @Override // gnu.trove.list.TByteList
    public void reverse() {
        synchronized (this.mutex) {
            this.list.reverse();
        }
    }

    @Override // gnu.trove.list.TByteList
    public void reverse(int i, int i2) {
        synchronized (this.mutex) {
            this.list.reverse(i, i2);
        }
    }

    @Override // gnu.trove.list.TByteList
    public void shuffle(Random random) {
        synchronized (this.mutex) {
            this.list.shuffle(random);
        }
    }

    @Override // gnu.trove.list.TByteList
    public void sort() {
        synchronized (this.mutex) {
            this.list.sort();
        }
    }

    @Override // gnu.trove.list.TByteList
    public void sort(int i, int i2) {
        synchronized (this.mutex) {
            this.list.sort(i, i2);
        }
    }

    @Override // gnu.trove.list.TByteList
    public int binarySearch(byte b) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(b);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TByteList
    public int binarySearch(byte b, int i, int i2) {
        int binarySearch;
        synchronized (this.mutex) {
            binarySearch = this.list.binarySearch(b, i, i2);
        }
        return binarySearch;
    }

    @Override // gnu.trove.list.TByteList
    public TByteList grep(TByteProcedure tByteProcedure) {
        TByteList grep;
        synchronized (this.mutex) {
            grep = this.list.grep(tByteProcedure);
        }
        return grep;
    }

    @Override // gnu.trove.list.TByteList
    public TByteList inverseGrep(TByteProcedure tByteProcedure) {
        TByteList inverseGrep;
        synchronized (this.mutex) {
            inverseGrep = this.list.inverseGrep(tByteProcedure);
        }
        return inverseGrep;
    }

    @Override // gnu.trove.list.TByteList
    public byte max() {
        byte max;
        synchronized (this.mutex) {
            max = this.list.max();
        }
        return max;
    }

    @Override // gnu.trove.list.TByteList
    public byte min() {
        byte min;
        synchronized (this.mutex) {
            min = this.list.min();
        }
        return min;
    }

    @Override // gnu.trove.list.TByteList
    public byte sum() {
        byte sum;
        synchronized (this.mutex) {
            sum = this.list.sum();
        }
        return sum;
    }

    @Override // gnu.trove.list.TByteList
    public boolean forEachDescending(TByteProcedure tByteProcedure) {
        boolean forEachDescending;
        synchronized (this.mutex) {
            forEachDescending = this.list.forEachDescending(tByteProcedure);
        }
        return forEachDescending;
    }

    @Override // gnu.trove.list.TByteList
    public void transformValues(TByteFunction tByteFunction) {
        synchronized (this.mutex) {
            this.list.transformValues(tByteFunction);
        }
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TSynchronizedRandomAccessByteList(this.list) : this;
    }
}