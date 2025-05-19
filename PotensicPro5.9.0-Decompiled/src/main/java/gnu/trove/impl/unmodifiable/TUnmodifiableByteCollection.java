package gnu.trove.impl.unmodifiable;

import gnu.trove.TByteCollection;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.procedure.TByteProcedure;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableByteCollection implements TByteCollection, Serializable {
    private static final long serialVersionUID = 1820017752578914078L;
    final TByteCollection c;

    public TUnmodifiableByteCollection(TByteCollection tByteCollection) {
        Objects.requireNonNull(tByteCollection);
        this.c = tByteCollection;
    }

    @Override // gnu.trove.TByteCollection
    public int size() {
        return this.c.size();
    }

    @Override // gnu.trove.TByteCollection
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // gnu.trove.TByteCollection
    public boolean contains(byte b) {
        return this.c.contains(b);
    }

    @Override // gnu.trove.TByteCollection
    public byte[] toArray() {
        return this.c.toArray();
    }

    @Override // gnu.trove.TByteCollection
    public byte[] toArray(byte[] bArr) {
        return this.c.toArray(bArr);
    }

    public String toString() {
        return this.c.toString();
    }

    @Override // gnu.trove.TByteCollection
    public byte getNoEntryValue() {
        return this.c.getNoEntryValue();
    }

    @Override // gnu.trove.TByteCollection
    public boolean forEach(TByteProcedure tByteProcedure) {
        return this.c.forEach(tByteProcedure);
    }

    @Override // gnu.trove.TByteCollection
    public TByteIterator iterator() {
        return new TByteIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableByteCollection.1
            TByteIterator i;

            {
                this.i = TUnmodifiableByteCollection.this.c.iterator();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return this.i.hasNext();
            }

            @Override // gnu.trove.iterator.TByteIterator
            public byte next() {
                return this.i.next();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.TByteCollection
    public boolean add(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TByteCollection
    public boolean remove(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TByteCollection
    public boolean containsAll(Collection<?> collection) {
        return this.c.containsAll(collection);
    }

    @Override // gnu.trove.TByteCollection
    public boolean containsAll(TByteCollection tByteCollection) {
        return this.c.containsAll(tByteCollection);
    }

    @Override // gnu.trove.TByteCollection
    public boolean containsAll(byte[] bArr) {
        return this.c.containsAll(bArr);
    }

    @Override // gnu.trove.TByteCollection
    public boolean addAll(TByteCollection tByteCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TByteCollection
    public boolean addAll(Collection<? extends Byte> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TByteCollection
    public boolean addAll(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TByteCollection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TByteCollection
    public boolean removeAll(TByteCollection tByteCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TByteCollection
    public boolean removeAll(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TByteCollection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TByteCollection
    public boolean retainAll(TByteCollection tByteCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TByteCollection
    public boolean retainAll(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TByteCollection
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
