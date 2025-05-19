package gnu.trove.impl.unmodifiable;

import gnu.trove.TCharCollection;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.procedure.TCharProcedure;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableCharCollection implements TCharCollection, Serializable {
    private static final long serialVersionUID = 1820017752578914078L;
    final TCharCollection c;

    public TUnmodifiableCharCollection(TCharCollection tCharCollection) {
        Objects.requireNonNull(tCharCollection);
        this.c = tCharCollection;
    }

    @Override // gnu.trove.TCharCollection
    public int size() {
        return this.c.size();
    }

    @Override // gnu.trove.TCharCollection
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // gnu.trove.TCharCollection
    public boolean contains(char c) {
        return this.c.contains(c);
    }

    @Override // gnu.trove.TCharCollection
    public char[] toArray() {
        return this.c.toArray();
    }

    @Override // gnu.trove.TCharCollection
    public char[] toArray(char[] cArr) {
        return this.c.toArray(cArr);
    }

    public String toString() {
        return this.c.toString();
    }

    @Override // gnu.trove.TCharCollection
    public char getNoEntryValue() {
        return this.c.getNoEntryValue();
    }

    @Override // gnu.trove.TCharCollection
    public boolean forEach(TCharProcedure tCharProcedure) {
        return this.c.forEach(tCharProcedure);
    }

    @Override // gnu.trove.TCharCollection
    public TCharIterator iterator() {
        return new TCharIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableCharCollection.1
            TCharIterator i;

            {
                this.i = TUnmodifiableCharCollection.this.c.iterator();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return this.i.hasNext();
            }

            @Override // gnu.trove.iterator.TCharIterator
            public char next() {
                return this.i.next();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.TCharCollection
    public boolean add(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TCharCollection
    public boolean remove(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TCharCollection
    public boolean containsAll(Collection<?> collection) {
        return this.c.containsAll(collection);
    }

    @Override // gnu.trove.TCharCollection
    public boolean containsAll(TCharCollection tCharCollection) {
        return this.c.containsAll(tCharCollection);
    }

    @Override // gnu.trove.TCharCollection
    public boolean containsAll(char[] cArr) {
        return this.c.containsAll(cArr);
    }

    @Override // gnu.trove.TCharCollection
    public boolean addAll(TCharCollection tCharCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TCharCollection
    public boolean addAll(Collection<? extends Character> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TCharCollection
    public boolean addAll(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TCharCollection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TCharCollection
    public boolean removeAll(TCharCollection tCharCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TCharCollection
    public boolean removeAll(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TCharCollection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TCharCollection
    public boolean retainAll(TCharCollection tCharCollection) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TCharCollection
    public boolean retainAll(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.TCharCollection
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
