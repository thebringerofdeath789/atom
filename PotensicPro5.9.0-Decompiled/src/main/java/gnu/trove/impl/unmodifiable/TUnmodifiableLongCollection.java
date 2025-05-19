package gnu.trove.impl.unmodifiable;

import gnu.trove.TLongCollection;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.procedure.TLongProcedure;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableLongCollection implements TLongCollection, Serializable {
    private static final long serialVersionUID = 1820017752578914078L;
    final TLongCollection c;

    public TUnmodifiableLongCollection(TLongCollection tLongCollection) {
        Objects.requireNonNull(tLongCollection);
        this.c = tLongCollection;
    }

    @Override // gnu.trove.TLongCollection
    public int size() {
        return this.c.size();
    }

    @Override // gnu.trove.TLongCollection
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // gnu.trove.TLongCollection
    public boolean contains(long j) {
        return this.c.contains(j);
    }

    @Override // gnu.trove.TLongCollection
    public long[] toArray() {
        return this.c.toArray();
    }

    @Override // gnu.trove.TLongCollection
    public long[] toArray(long[] jArr) {
        return this.c.toArray(jArr);
    }

    public String toString() {
        return this.c.toString();
    }

    @Override // gnu.trove.TLongCollection
    public long getNoEntryValue() {
        return this.c.getNoEntryValue();
    }

    @Override // gnu.trove.TLongCollection
    public boolean forEach(TLongProcedure tLongProcedure) {
        return this.c.forEach(tLongProcedure);
    }

    @Override // gnu.trove.TLongCollection
    public TLongIterator iterator() {
        return new TLongIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableLongCollection.1
            TLongIterator i;

            {
                this.i = TUnmodifiableLongCollection.this.c.iterator();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return this.i.hasNext();
            }

            @Override // gnu.trove.iterator.TLongIterator
            public long next() {
                return this.i.next();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.TLongCollection
    public boolean add(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TLongCollection
    public boolean remove(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(Collection<?> collection) {
        return this.c.containsAll(collection);
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(TLongCollection tLongCollection) {
        return this.c.containsAll(tLongCollection);
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(long[] jArr) {
        return this.c.containsAll(jArr);
    }

    @Override // gnu.trove.TLongCollection
    public boolean addAll(TLongCollection tLongCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TLongCollection
    public boolean addAll(Collection<? extends Long> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TLongCollection
    public boolean addAll(long[] jArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TLongCollection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TLongCollection
    public boolean removeAll(TLongCollection tLongCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TLongCollection
    public boolean removeAll(long[] jArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TLongCollection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TLongCollection
    public boolean retainAll(TLongCollection tLongCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TLongCollection
    public boolean retainAll(long[] jArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TLongCollection
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
