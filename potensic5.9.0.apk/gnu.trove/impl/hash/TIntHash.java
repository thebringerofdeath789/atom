package gnu.trove.impl.hash;

import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.procedure.TIntProcedure;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class TIntHash extends TPrimitiveHash {
    static final long serialVersionUID = 1;
    public transient int[] _set;
    protected boolean consumeFreeSlot;
    protected int no_entry_value;

    public TIntHash() {
        int i = Constants.DEFAULT_INT_NO_ENTRY_VALUE;
        this.no_entry_value = i;
        if (i != 0) {
            Arrays.fill(this._set, i);
        }
    }

    public TIntHash(int i) {
        super(i);
        int i2 = Constants.DEFAULT_INT_NO_ENTRY_VALUE;
        this.no_entry_value = i2;
        if (i2 != 0) {
            Arrays.fill(this._set, i2);
        }
    }

    public TIntHash(int i, float f) {
        super(i, f);
        int i2 = Constants.DEFAULT_INT_NO_ENTRY_VALUE;
        this.no_entry_value = i2;
        if (i2 != 0) {
            Arrays.fill(this._set, i2);
        }
    }

    public TIntHash(int i, float f, int i2) {
        super(i, f);
        this.no_entry_value = i2;
        if (i2 != 0) {
            Arrays.fill(this._set, i2);
        }
    }

    public int getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._set = new int[up];
        return up;
    }

    public boolean contains(int i) {
        return index(i) >= 0;
    }

    public boolean forEach(TIntProcedure tIntProcedure) {
        byte[] bArr = this._states;
        int[] iArr = this._set;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tIntProcedure.execute(iArr[i])) {
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

    protected int index(int i) {
        byte[] bArr = this._states;
        int[] iArr = this._set;
        int length = bArr.length;
        int hash = HashFunctions.hash(i) & Integer.MAX_VALUE;
        int i2 = hash % length;
        byte b = bArr[i2];
        if (b == 0) {
            return -1;
        }
        return (b == 1 && iArr[i2] == i) ? i2 : indexRehashed(i, i2, hash, b);
    }

    int indexRehashed(int i, int i2, int i3, byte b) {
        int length = this._set.length;
        int i4 = (i3 % (length - 2)) + 1;
        int i5 = i2;
        do {
            i5 -= i4;
            if (i5 < 0) {
                i5 += length;
            }
            byte b2 = this._states[i5];
            if (b2 == 0) {
                return -1;
            }
            if (i == this._set[i5] && b2 != 2) {
                return i5;
            }
        } while (i5 != i2);
        return -1;
    }

    protected int insertKey(int i) {
        int hash = HashFunctions.hash(i) & Integer.MAX_VALUE;
        int length = hash % this._states.length;
        byte b = this._states[length];
        this.consumeFreeSlot = false;
        if (b != 0) {
            return (b == 1 && this._set[length] == i) ? (-length) - 1 : insertKeyRehash(i, length, hash, b);
        }
        this.consumeFreeSlot = true;
        insertKeyAt(length, i);
        return length;
    }

    int insertKeyRehash(int i, int i2, int i3, byte b) {
        int length = this._set.length;
        int i4 = (i3 % (length - 2)) + 1;
        int i5 = i2;
        int i6 = -1;
        do {
            if (b == 2 && i6 == -1) {
                i6 = i5;
            }
            i5 -= i4;
            if (i5 < 0) {
                i5 += length;
            }
            b = this._states[i5];
            if (b == 0) {
                if (i6 != -1) {
                    insertKeyAt(i6, i);
                    return i6;
                }
                this.consumeFreeSlot = true;
                insertKeyAt(i5, i);
                return i5;
            }
            if (b == 1 && this._set[i5] == i) {
                return (-i5) - 1;
            }
        } while (i5 != i2);
        if (i6 != -1) {
            insertKeyAt(i6, i);
            return i6;
        }
        throw new IllegalStateException("No free or removed slots available. Key set full?!!");
    }

    void insertKeyAt(int i, int i2) {
        this._set[i] = i2;
        this._states[i] = 1;
    }
}