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

    /* renamed from: c */
    final TIntCollection f3692c;

    public TUnmodifiableIntCollection(TIntCollection tIntCollection) {
        Objects.requireNonNull(tIntCollection);
        this.f3692c = tIntCollection;
    }

    @Override // gnu.trove.TIntCollection
    public int size() {
        return this.f3692c.size();
    }

    @Override // gnu.trove.TIntCollection
    public boolean isEmpty() {
        return this.f3692c.isEmpty();
    }

    @Override // gnu.trove.TIntCollection
    public boolean contains(int i) {
        return this.f3692c.contains(i);
    }

    @Override // gnu.trove.TIntCollection
    public int[] toArray() {
        return this.f3692c.toArray();
    }

    @Override // gnu.trove.TIntCollection
    public int[] toArray(int[] iArr) {
        return this.f3692c.toArray(iArr);
    }

    public String toString() {
        return this.f3692c.toString();
    }

    @Override // gnu.trove.TIntCollection
    public int getNoEntryValue() {
        return this.f3692c.getNoEntryValue();
    }

    @Override // gnu.trove.TIntCollection
    public boolean forEach(TIntProcedure tIntProcedure) {
        return this.f3692c.forEach(tIntProcedure);
    }

    @Override // gnu.trove.TIntCollection
    public TIntIterator iterator() {
        return new TIntIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableIntCollection.1

            /* renamed from: i */
            TIntIterator f3693i;

            {
                this.f3693i = TUnmodifiableIntCollection.this.f3692c.iterator();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f3693i.hasNext();
            }

            @Override // gnu.trove.iterator.TIntIterator
            public int next() {
                return this.f3693i.next();
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
        return this.f3692c.containsAll(collection);
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(TIntCollection tIntCollection) {
        return this.f3692c.containsAll(tIntCollection);
    }

    @Override // gnu.trove.TIntCollection
    public boolean containsAll(int[] iArr) {
        return this.f3692c.containsAll(iArr);
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