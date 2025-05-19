package gnu.trove.impl.hash;

import gnu.trove.iterator.TPrimitiveIterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public abstract class THashPrimitiveIterator implements TPrimitiveIterator {
    protected int _expectedSize;
    protected final TPrimitiveHash _hash;
    protected int _index;

    public THashPrimitiveIterator(TPrimitiveHash tPrimitiveHash) {
        this._hash = tPrimitiveHash;
        this._expectedSize = tPrimitiveHash.size();
        this._index = tPrimitiveHash.capacity();
    }

    protected final int nextIndex() {
        int i;
        if (this._expectedSize != this._hash.size()) {
            throw new ConcurrentModificationException();
        }
        byte[] bArr = this._hash._states;
        int i2 = this._index;
        while (true) {
            i = i2 - 1;
            if (i2 <= 0 || bArr[i] == 1) {
                break;
            }
            i2 = i;
        }
        return i;
    }

    @Override // gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
    public boolean hasNext() {
        return nextIndex() >= 0;
    }

    @Override // gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
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
}
