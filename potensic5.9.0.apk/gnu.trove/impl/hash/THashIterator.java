package gnu.trove.impl.hash;

import gnu.trove.iterator.TIterator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public abstract class THashIterator<V> implements TIterator, Iterator<V> {
    protected int _expectedSize;
    protected final THash _hash;
    protected int _index;
    private final TObjectHash<V> _object_hash;

    protected abstract V objectAtIndex(int i);

    protected THashIterator(TObjectHash<V> tObjectHash) {
        this._hash = tObjectHash;
        this._expectedSize = tObjectHash.size();
        this._index = tObjectHash.capacity();
        this._object_hash = tObjectHash;
    }

    @Override // java.util.Iterator
    public V next() {
        moveToNextIndex();
        return objectAtIndex(this._index);
    }

    @Override // gnu.trove.iterator.TIterator, java.util.Iterator
    public boolean hasNext() {
        return nextIndex() >= 0;
    }

    @Override // gnu.trove.iterator.TIterator, java.util.Iterator
    public void remove() {
        if (this._expectedSize != this._hash.size()) {
            throw new ConcurrentModificationException();
        }
        try {
            this._hash.tempDisableAutoCompaction();
            this._hash.removeAt(this._index);
            this._hash.reenableAutoCompaction(false);
            this._expectedSize--;
        } catch (Throwable th) {
            this._hash.reenableAutoCompaction(false);
            throw th;
        }
    }

    protected final void moveToNextIndex() {
        int nextIndex = nextIndex();
        this._index = nextIndex;
        if (nextIndex < 0) {
            throw new NoSuchElementException();
        }
    }

    protected final int nextIndex() {
        int i;
        if (this._expectedSize != this._hash.size()) {
            throw new ConcurrentModificationException();
        }
        Object[] objArr = this._object_hash._set;
        int i2 = this._index;
        while (true) {
            i = i2 - 1;
            if (i2 <= 0 || !(objArr[i] == TObjectHash.FREE || objArr[i] == TObjectHash.REMOVED)) {
                break;
            }
            i2 = i;
        }
        return i;
    }
}