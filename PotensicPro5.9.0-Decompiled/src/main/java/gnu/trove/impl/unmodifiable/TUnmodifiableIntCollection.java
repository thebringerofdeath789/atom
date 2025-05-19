package gnu.trove.impl.unmodifiable;

import gnu.trove.TIntCollection;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.procedure.TIntProcedure;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableIntCollection implements TIntCollection, Serializable {
    private static final long serialVersionUID = 1820017752578914078L;
    final TIntCollection c;

    public TUnmodifiableIntCollection(TIntCollection tIntCollection) {
        Objects.requireNonNull(tIntCollection);
        this.c = tIntCollection;
    }

    @Override // gnu.trove.TIntCollection
    public int size() {
        return this.c.size();
    }

    @Override // gnu.trove.TIntCollection
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // gnu.trove.TIntCollection
    public boolean contains(int i) {
        return this.c.contains(i);
    }

    @Override // gnu.trove.TIntCollection
    public int[] toArray() {
        return this.c.toArray();
    }

    @Override // gnu.trove.TIntCollection
    public int[] toArray(int[] iArr) {
        return this.c.toArray(iArr);
    }

    public String toString() {
        return this.c.toString();
    }

    @Override // gnu.trove.TIntCollection
    public int getNoEntryValue() {
        return this.c.getNoEntryValue();
    }

    @Override // gnu.trove.TIntCollection
    public boolean forEach(TIntProcedure tIntProcedure) {
        return this.c.forEach(tIntProcedure);
    }

    @Override // gnu.trove.TIntCollection
    public TIntIterator iterator() {
        return new TIntIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableIntCollection.1
            TIntIterator i;

            {
                this.i = TUnmodifiableIntCollection.this.c.iterator();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return this.i.hasNext();
            }

            @Override // gnu.trove.iterator.TIntIterator
            public int next() {
                return this.i.next();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.TIntCollection
    public boolean add(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TIntCollection
    public boolean remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(Collection<?> collection) {
        return this.c.containsAll(collection);
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(TIntCollection tIntCollection) {
        return this.c.containsAll(tIntCollection);
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(int[] iArr) {
        return this.c.containsAll(iArr);
    }

    @Override // gnu.trove.TIntCollection
    public boolean addAll(TIntCollection tIntCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TIntCollection
    public boolean addAll(Collection<? extends Integer> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TIntCollection
    public boolean addAll(int[] iArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TIntCollection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TIntCollection
    public boolean removeAll(TIntCollection tIntCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TIntCollection
    public boolean removeAll(int[] iArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TIntCollection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TIntCollection
    public boolean retainAll(TIntCollection tIntCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TIntCollection
    public boolean retainAll(int[] iArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TIntCollection
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
