package gnu.trove.impl.hash;

import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.procedure.TCharProcedure;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class TCharHash extends TPrimitiveHash {
    static final long serialVersionUID = 1;
    public transient char[] _set;
    protected boolean consumeFreeSlot;
    protected char no_entry_value;

    public TCharHash() {
        char c = Constants.DEFAULT_CHAR_NO_ENTRY_VALUE;
        this.no_entry_value = c;
        if (c != 0) {
            Arrays.fill(this._set, c);
        }
    }

    public TCharHash(int i) {
        super(i);
        char c = Constants.DEFAULT_CHAR_NO_ENTRY_VALUE;
        this.no_entry_value = c;
        if (c != 0) {
            Arrays.fill(this._set, c);
        }
    }

    public TCharHash(int i, float f) {
        super(i, f);
        char c = Constants.DEFAULT_CHAR_NO_ENTRY_VALUE;
        this.no_entry_value = c;
        if (c != 0) {
            Arrays.fill(this._set, c);
        }
    }

    public TCharHash(int i, float f, char c) {
        super(i, f);
        this.no_entry_value = c;
        if (c != 0) {
            Arrays.fill(this._set, c);
        }
    }

    public char getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._set = new char[up];
        return up;
    }

    public boolean contains(char c) {
        return index(c) >= 0;
    }

    public boolean forEach(TCharProcedure tCharProcedure) {
        byte[] bArr = this._states;
        char[] cArr = this._set;
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tCharProcedure.execute(cArr[i])) {
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

    protected int index(char c) {
        byte[] bArr = this._states;
        char[] cArr = this._set;
        int length = bArr.length;
        int hash = HashFunctions.hash((int) c) & Integer.MAX_VALUE;
        int i = hash % length;
        byte b = bArr[i];
        if (b == 0) {
            return -1;
        }
        return (b == 1 && cArr[i] == c) ? i : indexRehashed(c, i, hash, b);
    }

    int indexRehashed(char c, int i, int i2, byte b) {
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
            if (c == this._set[i4] && b2 != 2) {
                return i4;
            }
        } while (i4 != i);
        return -1;
    }

    protected int insertKey(char c) {
        int hash = HashFunctions.hash((int) c) & Integer.MAX_VALUE;
        int length = hash % this._states.length;
        byte b = this._states[length];
        this.consumeFreeSlot = false;
        if (b != 0) {
            return (b == 1 && this._set[length] == c) ? (-length) - 1 : insertKeyRehash(c, length, hash, b);
        }
        this.consumeFreeSlot = true;
        insertKeyAt(length, c);
        return length;
    }

    int insertKeyRehash(char c, int i, int i2, byte b) {
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
                    insertKeyAt(i5, c);
                    return i5;
                }
                this.consumeFreeSlot = true;
                insertKeyAt(i4, c);
                return i4;
            }
            if (b == 1 && this._set[i4] == c) {
                return (-i4) - 1;
            }
        } while (i4 != i);
        if (i5 != -1) {
            insertKeyAt(i5, c);
            return i5;
        }
        throw new IllegalStateException("No free or removed slots available. Key set full?!!");
    }

    void insertKeyAt(int i, char c) {
        this._set[i] = c;
        this._states[i] = 1;
    }
}