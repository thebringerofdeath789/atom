package gnu.trove.impl.unmodifiable;

import gnu.trove.function.TLongFunction;
import gnu.trove.list.TLongList;
import gnu.trove.procedure.TLongProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableLongList extends TUnmodifiableLongCollection implements TLongList {
    static final long serialVersionUID = -283967356065247728L;
    final TLongList list;

    public TUnmodifiableLongList(TLongList tLongList) {
        super(tLongList);
        this.list = tLongList;
    }

    @Override // gnu.trove.TLongCollection
    public boolean equals(Object obj) {
        return obj == this || this.list.equals(obj);
    }

    @Override // gnu.trove.TLongCollection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // gnu.trove.list.TLongList
    public long get(int i) {
        return this.list.get(i);
    }

    @Override // gnu.trove.list.TLongList
    public int indexOf(long j) {
        return this.list.indexOf(j);
    }

    @Override // gnu.trove.list.TLongList
    public int lastIndexOf(long j) {
        return this.list.lastIndexOf(j);
    }

    @Override // gnu.trove.list.TLongList
    public long[] toArray(int i, int i2) {
        return this.list.toArray(i, i2);
    }

    @Override // gnu.trove.list.TLongList
    public long[] toArray(long[] jArr, int i, int i2) {
        return this.list.toArray(jArr, i, i2);
    }

    @Override // gnu.trove.list.TLongList
    public long[] toArray(long[] jArr, int i, int i2, int i3) {
        return this.list.toArray(jArr, i, i2, i3);
    }

    @Override // gnu.trove.list.TLongList
    public boolean forEachDescending(TLongProcedure tLongProcedure) {
        return this.list.forEachDescending(tLongProcedure);
    }

    @Override // gnu.trove.list.TLongList
    public int binarySearch(long j) {
        return this.list.binarySearch(j);
    }

    @Override // gnu.trove.list.TLongList
    public int binarySearch(long j, int i, int i2) {
        return this.list.binarySearch(j, i, i2);
    }

    @Override // gnu.trove.list.TLongList
    public int indexOf(int i, long j) {
        return this.list.indexOf(i, j);
    }

    @Override // gnu.trove.list.TLongList
    public int lastIndexOf(int i, long j) {
        return this.list.lastIndexOf(i, j);
    }

    @Override // gnu.trove.list.TLongList
    public TLongList grep(TLongProcedure tLongProcedure) {
        return this.list.grep(tLongProcedure);
    }

    @Override // gnu.trove.list.TLongList
    public TLongList inverseGrep(TLongProcedure tLongProcedure) {
        return this.list.inverseGrep(tLongProcedure);
    }

    @Override // gnu.trove.list.TLongList
    public long max() {
        return this.list.max();
    }

    @Override // gnu.trove.list.TLongList
    public long min() {
        return this.list.min();
    }

    @Override // gnu.trove.list.TLongList
    public long sum() {
        return this.list.sum();
    }

    @Override // gnu.trove.list.TLongList
    public TLongList subList(int i, int i2) {
        return new TUnmodifiableLongList(this.list.subList(i, i2));
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TUnmodifiableRandomAccessLongList(this.list) : this;
    }

    @Override // gnu.trove.list.TLongList
    public void add(long[] jArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void add(long[] jArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public long removeAt(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void remove(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void insert(int i, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void insert(int i, long[] jArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void insert(int i, long[] jArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public long set(int i, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void set(int i, long[] jArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void set(int i, long[] jArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public long replace(int i, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void transformValues(TLongFunction tLongFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void reverse() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void reverse(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void shuffle(Random random) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void sort() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void sort(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void fill(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TLongList
    public void fill(int i, int i2, long j) {
        throw new UnsupportedOperationException();
    }
}
