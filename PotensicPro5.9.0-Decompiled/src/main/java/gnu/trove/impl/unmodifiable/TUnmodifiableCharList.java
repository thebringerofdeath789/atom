package gnu.trove.impl.unmodifiable;

import gnu.trove.function.TCharFunction;
import gnu.trove.list.TCharList;
import gnu.trove.procedure.TCharProcedure;
import java.util.Random;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class TUnmodifiableCharList extends TUnmodifiableCharCollection implements TCharList {
    static final long serialVersionUID = -283967356065247728L;
    final TCharList list;

    public TUnmodifiableCharList(TCharList tCharList) {
        super(tCharList);
        this.list = tCharList;
    }

    @Override // gnu.trove.TCharCollection
    public boolean equals(Object obj) {
        return obj == this || this.list.equals(obj);
    }

    @Override // gnu.trove.TCharCollection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // gnu.trove.list.TCharList
    public char get(int i) {
        return this.list.get(i);
    }

    @Override // gnu.trove.list.TCharList
    public int indexOf(char c) {
        return this.list.indexOf(c);
    }

    @Override // gnu.trove.list.TCharList
    public int lastIndexOf(char c) {
        return this.list.lastIndexOf(c);
    }

    @Override // gnu.trove.list.TCharList
    public char[] toArray(int i, int i2) {
        return this.list.toArray(i, i2);
    }

    @Override // gnu.trove.list.TCharList
    public char[] toArray(char[] cArr, int i, int i2) {
        return this.list.toArray(cArr, i, i2);
    }

    @Override // gnu.trove.list.TCharList
    public char[] toArray(char[] cArr, int i, int i2, int i3) {
        return this.list.toArray(cArr, i, i2, i3);
    }

    @Override // gnu.trove.list.TCharList
    public boolean forEachDescending(TCharProcedure tCharProcedure) {
        return this.list.forEachDescending(tCharProcedure);
    }

    @Override // gnu.trove.list.TCharList
    public int binarySearch(char c) {
        return this.list.binarySearch(c);
    }

    @Override // gnu.trove.list.TCharList
    public int binarySearch(char c, int i, int i2) {
        return this.list.binarySearch(c, i, i2);
    }

    @Override // gnu.trove.list.TCharList
    public int indexOf(int i, char c) {
        return this.list.indexOf(i, c);
    }

    @Override // gnu.trove.list.TCharList
    public int lastIndexOf(int i, char c) {
        return this.list.lastIndexOf(i, c);
    }

    @Override // gnu.trove.list.TCharList
    public TCharList grep(TCharProcedure tCharProcedure) {
        return this.list.grep(tCharProcedure);
    }

    @Override // gnu.trove.list.TCharList
    public TCharList inverseGrep(TCharProcedure tCharProcedure) {
        return this.list.inverseGrep(tCharProcedure);
    }

    @Override // gnu.trove.list.TCharList
    public char max() {
        return this.list.max();
    }

    @Override // gnu.trove.list.TCharList
    public char min() {
        return this.list.min();
    }

    @Override // gnu.trove.list.TCharList
    public char sum() {
        return this.list.sum();
    }

    @Override // gnu.trove.list.TCharList
    public TCharList subList(int i, int i2) {
        return new TUnmodifiableCharList(this.list.subList(i, i2));
    }

    private Object readResolve() {
        return this.list instanceof RandomAccess ? new TUnmodifiableRandomAccessCharList(this.list) : this;
    }

    @Override // gnu.trove.list.TCharList
    public void add(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void add(char[] cArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public char removeAt(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void remove(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void insert(int i, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void insert(int i, char[] cArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void insert(int i, char[] cArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public char set(int i, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void set(int i, char[] cArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void set(int i, char[] cArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public char replace(int i, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void transformValues(TCharFunction tCharFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void reverse() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void reverse(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void shuffle(Random random) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void sort() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void sort(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void fill(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.list.TCharList
    public void fill(int i, int i2, char c) {
        throw new UnsupportedOperationException();
    }
}
