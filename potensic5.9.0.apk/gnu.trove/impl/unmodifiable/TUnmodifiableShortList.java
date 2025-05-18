package gnu.trove.impl.unmodifiable;

import gnu.trove.function.TShortFunction;
import gnu.trove.list.TShortList;
import gnu.trove.procedure.TShortProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableShortList extends TUnmodifiableShortCollection implements TShortList {
    static final long serialVersionUID = -283967356065247728L;
    final TShortList list;

    public TUnmodifiableShortList(TShortList tShortList) {
        super(tShortList);
        this.list = tShortList;
    }

    @Override // gnu.trove.TShortCollection
    public boolean equals(Object obj) {
        return obj == this || this.list.equals(obj);
    }

    @Override // gnu.trove.TShortCollection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // gnu.trove.list.TShortList
    public short get(int i) {
        return this.list.get(i);
    }

    @Override // gnu.trove.list.TShortList
    public int indexOf(short s) {
        return this.list.indexOf(s);
    }

    @Override // gnu.trove.list.TShortList
    public int lastIndexOf(short s) {
        return this.list.lastIndexOf(s);
    }

    @Override // gnu.trove.list.TShortList
    public short[] toArray(int i, int i2) {
        return this.list.toArray(i, i2);
    }

    @Override // gnu.trove.list.TShortList
    public short[] toArray(short[] sArr, int i, int i2) {
        return this.list.toArray(sArr, i, i2);
    }

    @Override // gnu.trove.list.TShortList
    public short[] toArray(short[] sArr, int i, int i2, int i3) {
        return this.list.toArray(sArr, i, i2, i3);
    }

    @Override // gnu.trove.list.TShortList
    public boolean forEachDescending(TShortProcedure tShortProcedure) {
        return this.list.forEachDescending(tShortProcedure);
    }

    @Override // gnu.trove.list.TShortList
    public int binarySearch(short s) {
        return this.list.binarySearch(s);
    }

    @Override // gnu.trove.list.TShortList
    public int binarySearch(short s, int i, int i2) {
        return this.list.binarySearch(s, i, i2);
    }

    @Override // gnu.trove.list.TShortList
    public int indexOf(int i, short s) {
        return this.list.indexOf(i, s);
    }

    @Override // gnu.trove.list.TShortList
    public int lastIndexOf(int i, short s) {
        return this.list.lastIndexOf(i, s);
    }

    @Override // gnu.trove.list.TShortList
    public TShortList grep(TShortProcedure tShortProcedure) {
        return this.list.grep(tShortProcedure);
    }

    @Override // gnu.trove.list.TShortList
    public TShortList inverseGrep(TShortProcedure tShortProcedure) {
        return this.list.inverseGrep(tShortProcedure);
    }

    @Override // gnu.trove.list.TShortList
    public short max() {
        return this.list.max();
    }

    @Override // gnu.trove.list.TShortList
    public short min() {
        return this.list.min();
    }

    @Override // gnu.trove.list.TShortList
    public short sum() {
        return this.list.sum();
    }

    public TShortList subList(int i, int i2) {
        return new TUnmodifiableShortList(this.list.subList(i, i2));
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TUnmodifiableRandomAccessShortList(this.list) : this;
    }

    @Override // gnu.trove.list.TShortList
    public void add(short[] sArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void add(short[] sArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public short removeAt(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void remove(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void insert(int i, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void insert(int i, short[] sArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void insert(int i, short[] sArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public short set(int i, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void set(int i, short[] sArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void set(int i, short[] sArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public short replace(int i, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void transformValues(TShortFunction tShortFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void reverse() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void reverse(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void shuffle(Random random) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void sort() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void sort(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void fill(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TShortList
    public void fill(int i, int i2, short s) {
        throw new UnsupportedOperationException();
    }
}