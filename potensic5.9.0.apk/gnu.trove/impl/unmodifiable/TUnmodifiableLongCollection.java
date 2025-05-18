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

    /* renamed from: c */
    final TLongCollection f3702c;

    public TUnmodifiableLongCollection(TLongCollection tLongCollection) {
        Objects.requireNonNull(tLongCollection);
        this.f3702c = tLongCollection;
    }

    @Override // gnu.trove.TLongCollection
    public int size() {
        return this.f3702c.size();
    }

    @Override // gnu.trove.TLongCollection
    public boolean isEmpty() {
        return this.f3702c.isEmpty();
    }

    @Override // gnu.trove.TLongCollection
    public boolean contains(long j) {
        return this.f3702c.contains(j);
    }

    @Override // gnu.trove.TLongCollection
    public long[] toArray() {
        return this.f3702c.toArray();
    }

    @Override // gnu.trove.TLongCollection
    public long[] toArray(long[] jArr) {
        return this.f3702c.toArray(jArr);
    }

    public String toString() {
        return this.f3702c.toString();
    }

    @Override // gnu.trove.TLongCollection
    public long getNoEntryValue() {
        return this.f3702c.getNoEntryValue();
    }

    @Override // gnu.trove.TLongCollection
    public boolean forEach(TLongProcedure tLongProcedure) {
        return this.f3702c.forEach(tLongProcedure);
    }

    @Override // gnu.trove.TLongCollection
    public TLongIterator iterator() {
        return new TLongIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableLongCollection.1

            /* renamed from: i */
            TLongIterator f3703i;

            {
                this.f3703i = TUnmodifiableLongCollection.this.f3702c.iterator();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f3703i.hasNext();
            }

            @Override // gnu.trove.iterator.TLongIterator
            public long next() {
                return this.f3703i.next();
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
        return this.f3702c.containsAll(collection);
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(TLongCollection tLongCollection) {
        return this.f3702c.containsAll(tLongCollection);
    }

    @Override // gnu.trove.TLongCollection
    public boolean containsAll(long[] jArr) {
        return this.f3702c.containsAll(jArr);
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