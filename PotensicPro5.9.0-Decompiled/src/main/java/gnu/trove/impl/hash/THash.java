package gnu.trove.impl.hash;

import gnu.trove.impl.PrimeFinder;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* loaded from: classes3.dex */
public abstract class THash implements Externalizable {
    protected static final int DEFAULT_CAPACITY = 10;
    protected static final float DEFAULT_LOAD_FACTOR = 0.5f;
    static final long serialVersionUID = -1792948471915530295L;
    protected int _autoCompactRemovesRemaining;
    protected transient boolean _autoCompactTemporaryDisable;
    protected float _autoCompactionFactor;
    protected transient int _free;
    protected float _loadFactor;
    protected int _maxSize;
    protected transient int _size;

    protected static long fastCeil(double d) {
        long j = (long) d;
        return d - ((double) j) > 0.0d ? j + 1 : j;
    }

    protected static int saturatedCast(long j) {
        int i = (int) (2147483647L & j);
        if (i != j) {
            return Integer.MAX_VALUE;
        }
        return i;
    }

    public abstract int capacity();

    protected abstract void rehash(int i);

    public THash() {
        this(10, 0.5f);
    }

    public THash(int i) {
        this(i, 0.5f);
    }

    public THash(int i, float f) {
        this._autoCompactTemporaryDisable = false;
        if (i < 0) {
            throw new IllegalArgumentException("negative capacity: " + i);
        }
        if (0.0f >= f) {
            throw new IllegalArgumentException("load factor out of range: " + f);
        }
        this._loadFactor = f;
        this._autoCompactionFactor = f;
        setUp(saturatedCast(fastCeil(i / f)));
    }

    public boolean isEmpty() {
        return this._size == 0;
    }

    public int size() {
        return this._size;
    }

    public void ensureCapacity(int i) {
        if (i > this._maxSize - size()) {
            rehash(PrimeFinder.nextPrime(Math.max(this._size + 1, saturatedCast(fastCeil((i + r0) / this._loadFactor) + 1))));
            if (capacity() >= PrimeFinder.largestPrime) {
                this._loadFactor = 1.0f;
            }
            computeMaxSize(capacity());
        }
    }

    public void compact() {
        int i = this._size;
        rehash(PrimeFinder.nextPrime(Math.max(i + 1, saturatedCast(fastCeil(i / this._loadFactor) + 1))));
        computeMaxSize(capacity());
        if (this._autoCompactionFactor != 0.0f) {
            computeNextAutoCompactionAmount(size());
        }
    }

    public void setAutoCompactionFactor(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Factor must be >= 0: " + f);
        }
        this._autoCompactionFactor = f;
    }

    public float getAutoCompactionFactor() {
        return this._autoCompactionFactor;
    }

    public final void trimToSize() {
        compact();
    }

    protected void removeAt(int i) {
        this._size--;
        if (this._autoCompactionFactor != 0.0f) {
            int i2 = this._autoCompactRemovesRemaining - 1;
            this._autoCompactRemovesRemaining = i2;
            if (this._autoCompactTemporaryDisable || i2 > 0) {
                return;
            }
            compact();
        }
    }

    public void clear() {
        this._size = 0;
        this._free = capacity();
    }

    protected int setUp(int i) {
        int nextPrime = PrimeFinder.nextPrime(i);
        if (nextPrime >= PrimeFinder.largestPrime) {
            this._loadFactor = 1.0f;
        }
        computeMaxSize(nextPrime);
        computeNextAutoCompactionAmount(i);
        return nextPrime;
    }

    public void tempDisableAutoCompaction() {
        this._autoCompactTemporaryDisable = true;
    }

    public void reenableAutoCompaction(boolean z) {
        this._autoCompactTemporaryDisable = false;
        if (!z || this._autoCompactRemovesRemaining > 0 || this._autoCompactionFactor == 0.0f) {
            return;
        }
        compact();
    }

    protected void computeMaxSize(int i) {
        this._maxSize = Math.min(i - 1, (int) (i * this._loadFactor));
        this._free = i - this._size;
    }

    protected void computeNextAutoCompactionAmount(int i) {
        float f = this._autoCompactionFactor;
        if (f != 0.0f) {
            this._autoCompactRemovesRemaining = (int) ((i * f) + 0.5f);
        }
    }

    protected final void postInsertHook(boolean z) {
        if (z) {
            this._free--;
        }
        int i = this._size + 1;
        this._size = i;
        int i2 = this._maxSize;
        if (i > i2 || this._free == 0) {
            rehash(i > i2 ? PrimeFinder.nextPrime(capacity() << 1) : capacity());
            computeMaxSize(capacity());
        }
    }

    protected int calculateGrownCapacity() {
        return capacity() << 1;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeFloat(this._loadFactor);
        objectOutput.writeFloat(this._autoCompactionFactor);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        float f = this._loadFactor;
        this._loadFactor = Math.abs(objectInput.readFloat());
        this._autoCompactionFactor = objectInput.readFloat();
        float f2 = this._loadFactor;
        if (f != f2) {
            setUp(saturatedCast((long) Math.ceil(10.0d / f2)));
        }
    }
}
