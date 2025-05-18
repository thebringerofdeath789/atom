package gnu.trove.impl.unmodifiable;

import gnu.trove.TDoubleCollection;
import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.procedure.TDoubleProcedure;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableDoubleCollection implements TDoubleCollection, Serializable {
    private static final long serialVersionUID = 1820017752578914078L;

    /* renamed from: c */
    final TDoubleCollection f3672c;

    public TUnmodifiableDoubleCollection(TDoubleCollection tDoubleCollection) {
        Objects.requireNonNull(tDoubleCollection);
        this.f3672c = tDoubleCollection;
    }

    @Override // gnu.trove.TDoubleCollection
    public int size() {
        return this.f3672c.size();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean isEmpty() {
        return this.f3672c.isEmpty();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean contains(double d) {
        return this.f3672c.contains(d);
    }

    @Override // gnu.trove.TDoubleCollection
    public double[] toArray() {
        return this.f3672c.toArray();
    }

    @Override // gnu.trove.TDoubleCollection
    public double[] toArray(double[] dArr) {
        return this.f3672c.toArray(dArr);
    }

    public String toString() {
        return this.f3672c.toString();
    }

    @Override // gnu.trove.TDoubleCollection
    public double getNoEntryValue() {
        return this.f3672c.getNoEntryValue();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean forEach(TDoubleProcedure tDoubleProcedure) {
        return this.f3672c.forEach(tDoubleProcedure);
    }

    @Override // gnu.trove.TDoubleCollection
    public TDoubleIterator iterator() {
        return new TDoubleIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableDoubleCollection.1

            /* renamed from: i */
            TDoubleIterator f3673i;

            {
                this.f3673i = TUnmodifiableDoubleCollection.this.f3672c.iterator();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f3673i.hasNext();
            }

            @Override // gnu.trove.iterator.TDoubleIterator
            public double next() {
                return this.f3673i.next();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean add(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean remove(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean containsAll(Collection<?> collection) {
        return this.f3672c.containsAll(collection);
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean containsAll(TDoubleCollection tDoubleCollection) {
        return this.f3672c.containsAll(tDoubleCollection);
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean containsAll(double[] dArr) {
        return this.f3672c.containsAll(dArr);
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean addAll(TDoubleCollection tDoubleCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean addAll(Collection<? extends Double> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean addAll(double[] dArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean removeAll(TDoubleCollection tDoubleCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean removeAll(double[] dArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean retainAll(TDoubleCollection tDoubleCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean retainAll(double[] dArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TDoubleCollection
    public void clear() {
        throw new UnsupportedOperationException();
    }
}