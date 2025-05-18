package gnu.trove.impl.unmodifiable;

import gnu.trove.function.TIntFunction;
import gnu.trove.list.TIntList;
import gnu.trove.procedure.TIntProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableIntList extends TUnmodifiableIntCollection implements TIntList {
    static final long serialVersionUID = -283967356065247728L;
    final TIntList list;

    public TUnmodifiableIntList(TIntList tIntList) {
        super(tIntList);
        this.list = tIntList;
    }

    @Override // gnu.trove.TIntCollection
    public boolean equals(Object obj) {
        return obj == this || this.list.equals(obj);
    }

    @Override // gnu.trove.TIntCollection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // gnu.trove.list.TIntList
    public int get(int i) {
        return this.list.get(i);
    }

    @Override // gnu.trove.list.TIntList
    public int indexOf(int i) {
        return this.list.indexOf(i);
    }

    @Override // gnu.trove.list.TIntList
    public int lastIndexOf(int i) {
        return this.list.lastIndexOf(i);
    }

    @Override // gnu.trove.list.TIntList
    public int[] toArray(int i, int i2) {
        return this.list.toArray(i, i2);
    }

    @Override // gnu.trove.list.TIntList
    public int[] toArray(int[] iArr, int i, int i2) {
        return this.list.toArray(iArr, i, i2);
    }

    @Override // gnu.trove.list.TIntList
    public int[] toArray(int[] iArr, int i, int i2, int i3) {
        return this.list.toArray(iArr, i, i2, i3);
    }

    @Override // gnu.trove.list.TIntList
    public boolean forEachDescending(TIntProcedure tIntProcedure) {
        return this.list.forEachDescending(tIntProcedure);
    }

    @Override // gnu.trove.list.TIntList
    public int binarySearch(int i) {
        return this.list.binarySearch(i);
    }

    @Override // gnu.trove.list.TIntList
    public int binarySearch(int i, int i2, int i3) {
        return this.list.binarySearch(i, i2, i3);
    }

    @Override // gnu.trove.list.TIntList
    public int indexOf(int i, int i2) {
        return this.list.indexOf(i, i2);
    }

    @Override // gnu.trove.list.TIntList
    public int lastIndexOf(int i, int i2) {
        return this.list.lastIndexOf(i, i2);
    }

    @Override // gnu.trove.list.TIntList
    public TIntList grep(TIntProcedure tIntProcedure) {
        return this.list.grep(tIntProcedure);
    }

    @Override // gnu.trove.list.TIntList
    public TIntList inverseGrep(TIntProcedure tIntProcedure) {
        return this.list.inverseGrep(tIntProcedure);
    }

    @Override // gnu.trove.list.TIntList
    public int max() {
        return this.list.max();
    }

    @Override // gnu.trove.list.TIntList
    public int min() {
        return this.list.min();
    }

    @Override // gnu.trove.list.TIntList
    public int sum() {
        return this.list.sum();
    }

    @Override // gnu.trove.list.TIntList
    public TIntList subList(int i, int i2) {
        return new TUnmodifiableIntList(this.list.subList(i, i2));
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TUnmodifiableRandomAccessIntList(this.list) : this;
    }

    @Override // gnu.trove.list.TIntList
    public void add(int[] iArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void add(int[] iArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public int removeAt(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void remove(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void insert(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void insert(int i, int[] iArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void insert(int i, int[] iArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public int set(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void set(int i, int[] iArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void set(int i, int[] iArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public int replace(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void transformValues(TIntFunction tIntFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void reverse() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void reverse(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void shuffle(Random random) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void sort() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void sort(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void fill(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TIntList
    public void fill(int i, int i2, int i3) {
        throw new UnsupportedOperationException();
    }
}