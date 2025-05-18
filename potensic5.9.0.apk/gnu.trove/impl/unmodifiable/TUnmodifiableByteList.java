package gnu.trove.impl.unmodifiable;

import gnu.trove.function.TByteFunction;
import gnu.trove.list.TByteList;
import gnu.trove.procedure.TByteProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableByteList extends TUnmodifiableByteCollection implements TByteList {
    static final long serialVersionUID = -283967356065247728L;
    final TByteList list;

    public TUnmodifiableByteList(TByteList tByteList) {
        super(tByteList);
        this.list = tByteList;
    }

    @Override // gnu.trove.TByteCollection
    public boolean equals(Object obj) {
        return obj == this || this.list.equals(obj);
    }

    @Override // gnu.trove.TByteCollection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // gnu.trove.list.TByteList
    public byte get(int i) {
        return this.list.get(i);
    }

    @Override // gnu.trove.list.TByteList
    public int indexOf(byte b) {
        return this.list.indexOf(b);
    }

    @Override // gnu.trove.list.TByteList
    public int lastIndexOf(byte b) {
        return this.list.lastIndexOf(b);
    }

    @Override // gnu.trove.list.TByteList
    public byte[] toArray(int i, int i2) {
        return this.list.toArray(i, i2);
    }

    @Override // gnu.trove.list.TByteList
    public byte[] toArray(byte[] bArr, int i, int i2) {
        return this.list.toArray(bArr, i, i2);
    }

    @Override // gnu.trove.list.TByteList
    public byte[] toArray(byte[] bArr, int i, int i2, int i3) {
        return this.list.toArray(bArr, i, i2, i3);
    }

    @Override // gnu.trove.list.TByteList
    public boolean forEachDescending(TByteProcedure tByteProcedure) {
        return this.list.forEachDescending(tByteProcedure);
    }

    @Override // gnu.trove.list.TByteList
    public int binarySearch(byte b) {
        return this.list.binarySearch(b);
    }

    @Override // gnu.trove.list.TByteList
    public int binarySearch(byte b, int i, int i2) {
        return this.list.binarySearch(b, i, i2);
    }

    @Override // gnu.trove.list.TByteList
    public int indexOf(int i, byte b) {
        return this.list.indexOf(i, b);
    }

    @Override // gnu.trove.list.TByteList
    public int lastIndexOf(int i, byte b) {
        return this.list.lastIndexOf(i, b);
    }

    @Override // gnu.trove.list.TByteList
    public TByteList grep(TByteProcedure tByteProcedure) {
        return this.list.grep(tByteProcedure);
    }

    @Override // gnu.trove.list.TByteList
    public TByteList inverseGrep(TByteProcedure tByteProcedure) {
        return this.list.inverseGrep(tByteProcedure);
    }

    @Override // gnu.trove.list.TByteList
    public byte max() {
        return this.list.max();
    }

    @Override // gnu.trove.list.TByteList
    public byte min() {
        return this.list.min();
    }

    @Override // gnu.trove.list.TByteList
    public byte sum() {
        return this.list.sum();
    }

    @Override // gnu.trove.list.TByteList
    public TByteList subList(int i, int i2) {
        return new TUnmodifiableByteList(this.list.subList(i, i2));
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TUnmodifiableRandomAccessByteList(this.list) : this;
    }

    @Override // gnu.trove.list.TByteList
    public void add(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void add(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public byte removeAt(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void remove(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void insert(int i, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void insert(int i, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void insert(int i, byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public byte set(int i, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void set(int i, byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void set(int i, byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public byte replace(int i, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void transformValues(TByteFunction tByteFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void reverse() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void reverse(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void shuffle(Random random) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void sort() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void sort(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void fill(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TByteList
    public void fill(int i, int i2, byte b) {
        throw new UnsupportedOperationException();
    }
}