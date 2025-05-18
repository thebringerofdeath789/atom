package gnu.trove.impl.unmodifiable;

import gnu.trove.TShortCollection;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.procedure.TShortProcedure;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableShortCollection implements TShortCollection, Serializable {
    private static final long serialVersionUID = 1820017752578914078L;

    /* renamed from: c */
    final TShortCollection f3719c;

    public TUnmodifiableShortCollection(TShortCollection tShortCollection) {
        Objects.requireNonNull(tShortCollection);
        this.f3719c = tShortCollection;
    }

    @Override // gnu.trove.TShortCollection
    public int size() {
        return this.f3719c.size();
    }

    @Override // gnu.trove.TShortCollection
    public boolean isEmpty() {
        return this.f3719c.isEmpty();
    }

    @Override // gnu.trove.TShortCollection
    public boolean contains(short s) {
        return this.f3719c.contains(s);
    }

    @Override // gnu.trove.TShortCollection
    public short[] toArray() {
        return this.f3719c.toArray();
    }

    @Override // gnu.trove.TShortCollection
    public short[] toArray(short[] sArr) {
        return this.f3719c.toArray(sArr);
    }

    public String toString() {
        return this.f3719c.toString();
    }

    @Override // gnu.trove.TShortCollection
    public short getNoEntryValue() {
        return this.f3719c.getNoEntryValue();
    }

    @Override // gnu.trove.TShortCollection
    public boolean forEach(TShortProcedure tShortProcedure) {
        return this.f3719c.forEach(tShortProcedure);
    }

    @Override // gnu.trove.TShortCollection
    public TShortIterator iterator() {
        return new TShortIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableShortCollection.1

            /* renamed from: i */
            TShortIterator f3720i;

            {
                this.f3720i = TUnmodifiableShortCollection.this.f3719c.iterator();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f3720i.hasNext();
            }

            @Override // gnu.trove.iterator.TShortIterator
            public short next() {
                return this.f3720i.next();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.TShortCollection
    public boolean add(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TShortCollection
    public boolean remove(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TShortCollection
    public boolean containsAll(Collection<?> collection) {
        return this.f3719c.containsAll(collection);
    }

    @Override // gnu.trove.TShortCollection
    public boolean containsAll(TShortCollection tShortCollection) {
        return this.f3719c.containsAll(tShortCollection);
    }

    @Override // gnu.trove.TShortCollection
    public boolean containsAll(short[] sArr) {
        return this.f3719c.containsAll(sArr);
    }

    @Override // gnu.trove.TShortCollection
    public boolean addAll(TShortCollection tShortCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TShortCollection
    public boolean addAll(Collection<? extends Short> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TShortCollection
    public boolean addAll(short[] sArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TShortCollection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TShortCollection
    public boolean removeAll(TShortCollection tShortCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TShortCollection
    public boolean removeAll(short[] sArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TShortCollection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TShortCollection
    public boolean retainAll(TShortCollection tShortCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TShortCollection
    public boolean retainAll(short[] sArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TShortCollection
    public void clear() {
        throw new UnsupportedOperationException();
    }
}