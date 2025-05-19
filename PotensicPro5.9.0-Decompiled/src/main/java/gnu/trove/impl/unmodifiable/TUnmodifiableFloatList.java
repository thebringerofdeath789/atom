package gnu.trove.impl.unmodifiable;

import gnu.trove.function.TFloatFunction;
import gnu.trove.list.TFloatList;
import gnu.trove.procedure.TFloatProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableFloatList extends TUnmodifiableFloatCollection implements TFloatList {
    static final long serialVersionUID = -283967356065247728L;
    final TFloatList list;

    public TUnmodifiableFloatList(TFloatList tFloatList) {
        super(tFloatList);
        this.list = tFloatList;
    }

    @Override // gnu.trove.TFloatCollection
    public boolean equals(Object obj) {
        return obj == this || this.list.equals(obj);
    }

    @Override // gnu.trove.TFloatCollection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // gnu.trove.list.TFloatList
    public float get(int i) {
        return this.list.get(i);
    }

    @Override // gnu.trove.list.TFloatList
    public int indexOf(float f) {
        return this.list.indexOf(f);
    }

    @Override // gnu.trove.list.TFloatList
    public int lastIndexOf(float f) {
        return this.list.lastIndexOf(f);
    }

    @Override // gnu.trove.list.TFloatList
    public float[] toArray(int i, int i2) {
        return this.list.toArray(i, i2);
    }

    @Override // gnu.trove.list.TFloatList
    public float[] toArray(float[] fArr, int i, int i2) {
        return this.list.toArray(fArr, i, i2);
    }

    @Override // gnu.trove.list.TFloatList
    public float[] toArray(float[] fArr, int i, int i2, int i3) {
        return this.list.toArray(fArr, i, i2, i3);
    }

    @Override // gnu.trove.list.TFloatList
    public boolean forEachDescending(TFloatProcedure tFloatProcedure) {
        return this.list.forEachDescending(tFloatProcedure);
    }

    @Override // gnu.trove.list.TFloatList
    public int binarySearch(float f) {
        return this.list.binarySearch(f);
    }

    @Override // gnu.trove.list.TFloatList
    public int binarySearch(float f, int i, int i2) {
        return this.list.binarySearch(f, i, i2);
    }

    @Override // gnu.trove.list.TFloatList
    public int indexOf(int i, float f) {
        return this.list.indexOf(i, f);
    }

    @Override // gnu.trove.list.TFloatList
    public int lastIndexOf(int i, float f) {
        return this.list.lastIndexOf(i, f);
    }

    @Override // gnu.trove.list.TFloatList
    public TFloatList grep(TFloatProcedure tFloatProcedure) {
        return this.list.grep(tFloatProcedure);
    }

    @Override // gnu.trove.list.TFloatList
    public TFloatList inverseGrep(TFloatProcedure tFloatProcedure) {
        return this.list.inverseGrep(tFloatProcedure);
    }

    @Override // gnu.trove.list.TFloatList
    public float max() {
        return this.list.max();
    }

    @Override // gnu.trove.list.TFloatList
    public float min() {
        return this.list.min();
    }

    @Override // gnu.trove.list.TFloatList
    public float sum() {
        return this.list.sum();
    }

    @Override // gnu.trove.list.TFloatList
    public TFloatList subList(int i, int i2) {
        return new TUnmodifiableFloatList(this.list.subList(i, i2));
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TUnmodifiableRandomAccessFloatList(this.list) : this;
    }

    @Override // gnu.trove.list.TFloatList
    public void add(float[] fArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void add(float[] fArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public float removeAt(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void remove(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void insert(int i, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void insert(int i, float[] fArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void insert(int i, float[] fArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public float set(int i, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void set(int i, float[] fArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void set(int i, float[] fArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public float replace(int i, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void transformValues(TFloatFunction tFloatFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void reverse() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void reverse(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void shuffle(Random random) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void sort() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void sort(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void fill(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TFloatList
    public void fill(int i, int i2, float f) {
        throw new UnsupportedOperationException();
    }
}
