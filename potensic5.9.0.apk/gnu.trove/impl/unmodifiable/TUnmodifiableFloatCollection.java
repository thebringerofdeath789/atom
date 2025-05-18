package gnu.trove.impl.unmodifiable;

import gnu.trove.TFloatCollection;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.procedure.TFloatProcedure;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableFloatCollection implements TFloatCollection, Serializable {
    private static final long serialVersionUID = 1820017752578914078L;

    /* renamed from: c */
    final TFloatCollection f3682c;

    public TUnmodifiableFloatCollection(TFloatCollection tFloatCollection) {
        Objects.requireNonNull(tFloatCollection);
        this.f3682c = tFloatCollection;
    }

    @Override // gnu.trove.TFloatCollection
    public int size() {
        return this.f3682c.size();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean isEmpty() {
        return this.f3682c.isEmpty();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean contains(float f) {
        return this.f3682c.contains(f);
    }

    @Override // gnu.trove.TFloatCollection
    public float[] toArray() {
        return this.f3682c.toArray();
    }

    @Override // gnu.trove.TFloatCollection
    public float[] toArray(float[] fArr) {
        return this.f3682c.toArray(fArr);
    }

    public String toString() {
        return this.f3682c.toString();
    }

    @Override // gnu.trove.TFloatCollection
    public float getNoEntryValue() {
        return this.f3682c.getNoEntryValue();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean forEach(TFloatProcedure tFloatProcedure) {
        return this.f3682c.forEach(tFloatProcedure);
    }

    @Override // gnu.trove.TFloatCollection
    public TFloatIterator iterator() {
        return new TFloatIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableFloatCollection.1

            /* renamed from: i */
            TFloatIterator f3683i;

            {
                this.f3683i = TUnmodifiableFloatCollection.this.f3682c.iterator();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f3683i.hasNext();
            }

            @Override // gnu.trove.iterator.TFloatIterator
            public float next() {
                return this.f3683i.next();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.TFloatCollection
    public boolean add(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean remove(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(Collection<?> collection) {
        return this.f3682c.containsAll(collection);
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(TFloatCollection tFloatCollection) {
        return this.f3682c.containsAll(tFloatCollection);
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(float[] fArr) {
        return this.f3682c.containsAll(fArr);
    }

    @Override // gnu.trove.TFloatCollection
    public boolean addAll(TFloatCollection tFloatCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean addAll(Collection<? extends Float> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean addAll(float[] fArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean removeAll(TFloatCollection tFloatCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean removeAll(float[] fArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean retainAll(TFloatCollection tFloatCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean retainAll(float[] fArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TFloatCollection
    public void clear() {
        throw new UnsupportedOperationException();
    }
}