package gnu.trove.impl.hash;

import gnu.trove.impl.HashFunctions;
import gnu.trove.procedure.TShortProcedure;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* loaded from: classes3.dex */
public abstract class TShortCharHash extends TPrimitiveHash {
    static final long serialVersionUID = 1;
    public transient short[] _set;
    protected boolean consumeFreeSlot;
    protected short no_entry_key;
    protected char no_entry_value;

    public TShortCharHash() {
        this.no_entry_key = (short) 0;
        this.no_entry_value = (char) 0;
    }

    public TShortCharHash(int i) {
        super(i);
        this.no_entry_key = (short) 0;
        this.no_entry_value = (char) 0;
    }

    public TShortCharHash(int i, float f) {
        super(i, f);
        this.no_entry_key = (short) 0;
        this.no_entry_value = (char) 0;
    }

    public TShortCharHash(int i, float f, short s, char c) {
        super(i, f);
        this.no_entry_key = s;
        this.no_entry_value = c;
    }

    public short getNoEntryKey() {
        return this.no_entry_key;
    }

    public char getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._set = new short[up];
        return up;
    }

    public boolean contains(short s) {
        return index(s) >= 0;
    }

    public boolean forEach(TShortProcedure tShortProcedure) {
        byte[] bArr = this._states;
        short[] sArr = this._set;
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tShortProcedure.execute(sArr[i])) {
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

    protected int index(short s) {
        byte[] bArr = this._states;
        short[] sArr = this._set;
        int length = bArr.length;
        int hash = HashFunctions.hash((int) s) & Integer.MAX_VALUE;
        int i = hash % length;
        byte b = bArr[i];
        if (b == 0) {
            return -1;
        }
        return (b == 1 && sArr[i] == s) ? i : indexRehashed(s, i, hash, b);
    }

    int indexRehashed(short s, int i, int i2, byte b) {
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
            if (s == this._set[i4] && b2 != 2) {
                return i4;
            }
        } while (i4 != i);
        return -1;
    }

    protected int insertKey(short s) {
        int hash = HashFunctions.hash((int) s) & Integer.MAX_VALUE;
        int length = hash % this._states.length;
        byte b = this._states[length];
        this.consumeFreeSlot = false;
        if (b != 0) {
            return (b == 1 && this._set[length] == s) ? (-length) - 1 : insertKeyRehash(s, length, hash, b);
        }
        this.consumeFreeSlot = true;
        insertKeyAt(length, s);
        return length;
    }

    int insertKeyRehash(short s, int i, int i2, byte b) {
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
                    insertKeyAt(i5, s);
                    return i5;
                }
                this.consumeFreeSlot = true;
                insertKeyAt(i4, s);
                return i4;
            }
            if (b == 1 && this._set[i4] == s) {
                return (-i4) - 1;
            }
        } while (i4 != i);
        if (i5 != -1) {
            insertKeyAt(i5, s);
            return i5;
        }
        throw new IllegalStateException("No free or removed slots available. Key set full?!!");
    }

    void insertKeyAt(int i, short s) {
        this._set[i] = s;
        this._states[i] = 1;
    }

    protected int XinsertKey(short s) {
        int i;
        byte[] bArr = this._states;
        short[] sArr = this._set;
        int length = bArr.length;
        int hash = HashFunctions.hash((int) s) & Integer.MAX_VALUE;
        int i2 = hash % length;
        byte b = bArr[i2];
        this.consumeFreeSlot = false;
        if (b == 0) {
            this.consumeFreeSlot = true;
            sArr[i2] = s;
            bArr[i2] = 1;
            return i2;
        }
        if (b != 1 || sArr[i2] != s) {
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
                } while (sArr[i2] != s);
            }
            if (b == 2) {
                int i4 = i2;
                while (b != 0 && (b == 2 || sArr[i4] != s)) {
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
                sArr[i4] = s;
                bArr[i4] = 1;
                return i2;
            }
            if (b != 1) {
                this.consumeFreeSlot = true;
                sArr[i2] = s;
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
        objectOutput.writeShort(this.no_entry_key);
        objectOutput.writeChar(this.no_entry_value);
    }

    @Override // gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
        this.no_entry_key = objectInput.readShort();
        this.no_entry_value = objectInput.readChar();
    }
}