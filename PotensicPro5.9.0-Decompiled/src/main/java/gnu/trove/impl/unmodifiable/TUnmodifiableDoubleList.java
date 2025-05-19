package gnu.trove.impl.unmodifiable;

import gnu.trove.function.TDoubleFunction;
import gnu.trove.list.TDoubleList;
import gnu.trove.procedure.TDoubleProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableDoubleList extends TUnmodifiableDoubleCollection implements TDoubleList {
    static final long serialVersionUID = -283967356065247728L;
    final TDoubleList list;

    public TUnmodifiableDoubleList(TDoubleList tDoubleList) {
        super(tDoubleList);
        this.list = tDoubleList;
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean equals(Object obj) {
        return obj == this || this.list.equals(obj);
    }

    @Override // gnu.trove.TDoubleCollection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // gnu.trove.list.TDoubleList
    public double get(int i) {
        return this.list.get(i);
    }

    @Override // gnu.trove.list.TDoubleList
    public int indexOf(double d) {
        return this.list.indexOf(d);
    }

    @Override // gnu.trove.list.TDoubleList
    public int lastIndexOf(double d) {
        return this.list.lastIndexOf(d);
    }

    @Override // gnu.trove.list.TDoubleList
    public double[] toArray(int i, int i2) {
        return this.list.toArray(i, i2);
    }

    @Override // gnu.trove.list.TDoubleList
    public double[] toArray(double[] dArr, int i, int i2) {
        return this.list.toArray(dArr, i, i2);
    }

    @Override // gnu.trove.list.TDoubleList
    public double[] toArray(double[] dArr, int i, int i2, int i3) {
        return this.list.toArray(dArr, i, i2, i3);
    }

    @Override // gnu.trove.list.TDoubleList
    public boolean forEachDescending(TDoubleProcedure tDoubleProcedure) {
        return this.list.forEachDescending(tDoubleProcedure);
    }

    @Override // gnu.trove.list.TDoubleList
    public int binarySearch(double d) {
        return this.list.binarySearch(d);
    }

    @Override // gnu.trove.list.TDoubleList
    public int binarySearch(double d, int i, int i2) {
        return this.list.binarySearch(d, i, i2);
    }

    @Override // gnu.trove.list.TDoubleList
    public int indexOf(int i, double d) {
        return this.list.indexOf(i, d);
    }

    @Override // gnu.trove.list.TDoubleList
    public int lastIndexOf(int i, double d) {
        return this.list.lastIndexOf(i, d);
    }

    @Override // gnu.trove.list.TDoubleList
    public TDoubleList grep(TDoubleProcedure tDoubleProcedure) {
        return this.list.grep(tDoubleProcedure);
    }

    @Override // gnu.trove.list.TDoubleList
    public TDoubleList inverseGrep(TDoubleProcedure tDoubleProcedure) {
        return this.list.inverseGrep(tDoubleProcedure);
    }

    @Override // gnu.trove.list.TDoubleList
    public double max() {
        return this.list.max();
    }

    @Override // gnu.trove.list.TDoubleList
    public double min() {
        return this.list.min();
    }

    @Override // gnu.trove.list.TDoubleList
    public double sum() {
        return this.list.sum();
    }

    @Override // gnu.trove.list.TDoubleList
    public TDoubleList subList(int i, int i2) {
        return new TUnmodifiableDoubleList(this.list.subList(i, i2));
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TUnmodifiableRandomAccessDoubleList(this.list) : this;
    }

    @Override // gnu.trove.list.TDoubleList
    public void add(double[] dArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void add(double[] dArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public double removeAt(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void remove(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void insert(int i, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void insert(int i, double[] dArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void insert(int i, double[] dArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public double set(int i, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void set(int i, double[] dArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void set(int i, double[] dArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public double replace(int i, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void transformValues(TDoubleFunction tDoubleFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void reverse() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void reverse(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void shuffle(Random random) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void sort() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void sort(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void fill(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TDoubleList
    public void fill(int i, int i2, double d) {
        throw new UnsupportedOperationException();
    }
}
