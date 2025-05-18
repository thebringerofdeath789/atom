package gnu.trove.impl.hash;

import gnu.trove.impl.HashFunctions;
import gnu.trove.procedure.TCharProcedure;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* loaded from: classes3.dex */
public abstract class TCharLongHash extends TPrimitiveHash {
    static final long serialVersionUID = 1;
    public transient char[] _set;
    protected boolean consumeFreeSlot;
    protected char no_entry_key;
    protected long no_entry_value;

    public TCharLongHash() {
        this.no_entry_key = (char) 0;
        this.no_entry_value = 0L;
    }

    public TCharLongHash(int i) {
        super(i);
        this.no_entry_key = (char) 0;
        this.no_entry_value = 0L;
    }

    public TCharLongHash(int i, float f) {
        super(i, f);
        this.no_entry_key = (char) 0;
        this.no_entry_value = 0L;
    }

    public TCharLongHash(int i, float f, char c, long j) {
        super(i, f);
        this.no_entry_key = c;
        this.no_entry_value = j;
    }

    public char getNoEntryKey() {
        return this.no_entry_key;
    }

    public long getNoEntryValue() {
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
        this._set[i] = this.no_entry_key;
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

    protected int XinsertKey(char c) {
        int i;
        byte[] bArr = this._states;
        char[] cArr = this._set;
        int length = bArr.length;
        int hash = HashFunctions.hash((int) c) & Integer.MAX_VALUE;
        int i2 = hash % length;
        byte b = bArr[i2];
        this.consumeFreeSlot = false;
        if (b == 0) {
            this.consumeFreeSlot = true;
            cArr[i2] = c;
            bArr[i2] = 1;
            return i2;
        }
        if (b != 1 || cArr[i2] != c) {
            int i3 = (hash % (length - 2)) + 1;
            if (b != 2) {
                do {
                    i2 -= i3;
                    if (i2 < 0) {
                        i2 += length;
                    }
                    b = bArr[i2];
                    if (b != 1) {
                        break;
                    }
                } while (cArr[i2] != c);
            }
            if (b == 2) {
                int i4 = i2;
                while (b != 0 && (b == 2 || cArr[i4] != c)) {
                    i4 -= i3;
                    if (i4 < 0) {
                        i4 += length;
                    }
                    b = bArr[i4];
                }
                if (b == 1) {
                    i = -i4;
                    return i - 1;
                }
                cArr[i4] = c;
                bArr[i4] = 1;
                return i2;
            }
            if (b != 1) {
                this.consumeFreeSlot = true;
                cArr[i2] = c;
                bArr[i2] = 1;
                return i2;
            }
        }
        i = -i2;
        return i - 1;
    }

    @Override // gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        super.writeExternal(objectOutput);
        objectOutput.writeChar(this.no_entry_key);
        objectOutput.writeLong(this.no_entry_value);
    }

    @Override // gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
        this.no_entry_key = objectInput.readChar();
        this.no_entry_value = objectInput.readLong();
    }
}