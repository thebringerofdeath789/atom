package gnu.trove.impl.hash;

import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.procedure.TDoubleProcedure;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class TDoubleHash extends TPrimitiveHash {
    static final long serialVersionUID = 1;
    public transient double[] _set;
    protected boolean consumeFreeSlot;
    protected double no_entry_value;

    public TDoubleHash() {
        double d = Constants.DEFAULT_DOUBLE_NO_ENTRY_VALUE;
        this.no_entry_value = d;
        if (d != 0.0d) {
            Arrays.fill(this._set, d);
        }
    }

    public TDoubleHash(int i) {
        super(i);
        double d = Constants.DEFAULT_DOUBLE_NO_ENTRY_VALUE;
        this.no_entry_value = d;
        if (d != 0.0d) {
            Arrays.fill(this._set, d);
        }
    }

    public TDoubleHash(int i, float f) {
        super(i, f);
        double d = Constants.DEFAULT_DOUBLE_NO_ENTRY_VALUE;
        this.no_entry_value = d;
        if (d != 0.0d) {
            Arrays.fill(this._set, d);
        }
    }

    public TDoubleHash(int i, float f, double d) {
        super(i, f);
        this.no_entry_value = d;
        if (d != 0.0d) {
            Arrays.fill(this._set, d);
        }
    }

    public double getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._set = new double[up];
        return up;
    }

    public boolean contains(double d) {
        return index(d) >= 0;
    }

    public boolean forEach(TDoubleProcedure tDoubleProcedure) {
        byte[] bArr = this._states;
        double[] dArr = this._set;
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tDoubleProcedure.execute(dArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._set[i] = this.no_entry_value;
        super.removeAt(i);
    }

    protected int index(double d) {
        byte[] bArr = this._states;
        double[] dArr = this._set;
        int length = bArr.length;
        int hash = HashFunctions.hash(d) & Integer.MAX_VALUE;
        int i = hash % length;
        byte b = bArr[i];
        if (b == 0) {
            return -1;
        }
        return (b == 1 && dArr[i] == d) ? i : indexRehashed(d, i, hash, b);
    }

    int indexRehashed(double d, int i, int i2, byte b) {
        int length = this._set.length;
        int i3 = (i2 % (length - 2)) + 1;
        int i4 = i;
        do {
            i4 -= i3;
            if (i4 < 0) {
                i4 += length;
            }
            byte b2 = this._states[i4];
            if (b2 == 0) {
                return -1;
            }
            if (d == this._set[i4] && b2 != 2) {
                return i4;
            }
        } while (i4 != i);
        return -1;
    }

    protected int insertKey(double d) {
        int hash = HashFunctions.hash(d) & Integer.MAX_VALUE;
        int length = hash % this._states.length;
        byte b = this._states[length];
        this.consumeFreeSlot = false;
        if (b != 0) {
            return (b == 1 && this._set[length] == d) ? (-length) - 1 : insertKeyRehash(d, length, hash, b);
        }
        this.consumeFreeSlot = true;
        insertKeyAt(length, d);
        return length;
    }

    int insertKeyRehash(double d, int i, int i2, byte b) {
        int length = this._set.length;
        int i3 = (i2 % (length - 2)) + 1;
        int i4 = i;
        int i5 = -1;
        do {
            if (b == 2 && i5 == -1) {
                i5 = i4;
            }
            i4 -= i3;
            if (i4 < 0) {
                i4 += length;
            }
            b = this._states[i4];
            if (b == 0) {
                if (i5 != -1) {
                    insertKeyAt(i5, d);
                    return i5;
                }
                this.consumeFreeSlot = true;
                insertKeyAt(i4, d);
                return i4;
            }
            if (b == 1 && this._set[i4] == d) {
                return (-i4) - 1;
            }
        } while (i4 != i);
        if (i5 != -1) {
            insertKeyAt(i5, d);
            return i5;
        }
        throw new IllegalStateException("No free or removed slots available. Key set full?!!");
    }

    void insertKeyAt(int i, double d) {
        this._set[i] = d;
        this._states[i] = 1;
    }
}
