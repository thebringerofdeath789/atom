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
    final TFloatCollection c;

    public TUnmodifiableFloatCollection(TFloatCollection tFloatCollection) {
        Objects.requireNonNull(tFloatCollection);
        this.c = tFloatCollection;
    }

    @Override // gnu.trove.TFloatCollection
    public int size() {
        return this.c.size();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean contains(float f) {
        return this.c.contains(f);
    }

    @Override // gnu.trove.TFloatCollection
    public float[] toArray() {
        return this.c.toArray();
    }

    @Override // gnu.trove.TFloatCollection
    public float[] toArray(float[] fArr) {
        return this.c.toArray(fArr);
    }

    public String toString() {
        return this.c.toString();
    }

    @Override // gnu.trove.TFloatCollection
    public float getNoEntryValue() {
        return this.c.getNoEntryValue();
    }

    @Override // gnu.trove.TFloatCollection
    public boolean forEach(TFloatProcedure tFloatProcedure) {
        return this.c.forEach(tFloatProcedure);
    }

    @Override // gnu.trove.TFloatCollection
    public TFloatIterator iterator() {
        return new TFloatIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableFloatCollection.1
            TFloatIterator i;

            {
                this.i = TUnmodifiableFloatCollection.this.c.iterator();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return this.i.hasNext();
            }

            @Override // gnu.trove.iterator.TFloatIterator
            public float next() {
                return this.i.next();
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
        return this.c.containsAll(collection);
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(TFloatCollection tFloatCollection) {
        return this.c.containsAll(tFloatCollection);
    }

    @Override // gnu.trove.TFloatCollection
    public boolean containsAll(float[] fArr) {
        return this.c.containsAll(fArr);
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
