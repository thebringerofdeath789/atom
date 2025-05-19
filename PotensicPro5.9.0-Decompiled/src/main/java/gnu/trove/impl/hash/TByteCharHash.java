package gnu.trove.impl.hash;

import gnu.trove.impl.HashFunctions;
import gnu.trove.procedure.TByteProcedure;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* loaded from: classes3.dex */
public abstract class TByteCharHash extends TPrimitiveHash {
    static final long serialVersionUID = 1;
    public transient byte[] _set;
    protected boolean consumeFreeSlot;
    protected byte no_entry_key;
    protected char no_entry_value;

    public TByteCharHash() {
        this.no_entry_key = (byte) 0;
        this.no_entry_value = (char) 0;
    }

    public TByteCharHash(int i) {
        super(i);
        this.no_entry_key = (byte) 0;
        this.no_entry_value = (char) 0;
    }

    public TByteCharHash(int i, float f) {
        super(i, f);
        this.no_entry_key = (byte) 0;
        this.no_entry_value = (char) 0;
    }

    public TByteCharHash(int i, float f, byte b, char c) {
        super(i, f);
        this.no_entry_key = b;
        this.no_entry_value = c;
    }

    public byte getNoEntryKey() {
        return this.no_entry_key;
    }

    public char getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._set = new byte[up];
        return up;
    }

    public boolean contains(byte b) {
        return index(b) >= 0;
    }

    public boolean forEach(TByteProcedure tByteProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        int length = bArr2.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tByteProcedure.execute(bArr2[i])) {
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

    protected int index(byte b) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        int length = bArr.length;
        int hash = HashFunctions.hash((int) b) & Integer.MAX_VALUE;
        int i = hash % length;
        byte b2 = bArr[i];
        if (b2 == 0) {
            return -1;
        }
        return (b2 == 1 && bArr2[i] == b) ? i : indexRehashed(b, i, hash, b2);
    }

    int indexRehashed(byte b, int i, int i2, byte b2) {
        int length = this._set.length;
        int i3 = (i2 % (length - 2)) + 1;
        int i4 = i;
        do {
            i4 -= i3;
            if (i4 < 0) {
                i4 += length;
            }
            byte b3 = this._states[i4];
            if (b3 == 0) {
                return -1;
            }
            if (b == this._set[i4] && b3 != 2) {
                return i4;
            }
        } while (i4 != i);
        return -1;
    }

    protected int insertKey(byte b) {
        int hash = HashFunctions.hash((int) b) & Integer.MAX_VALUE;
        int length = hash % this._states.length;
        byte b2 = this._states[length];
        this.consumeFreeSlot = false;
        if (b2 != 0) {
            return (b2 == 1 && this._set[length] == b) ? (-length) - 1 : insertKeyRehash(b, length, hash, b2);
        }
        this.consumeFreeSlot = true;
        insertKeyAt(length, b);
        return length;
    }

    int insertKeyRehash(byte b, int i, int i2, byte b2) {
        int length = this._set.length;
        int i3 = (i2 % (length - 2)) + 1;
        int i4 = i;
        int i5 = -1;
        do {
            if (b2 == 2 && i5 == -1) {
                i5 = i4;
            }
            i4 -= i3;
            if (i4 < 0) {
                i4 += length;
            }
            b2 = this._states[i4];
            if (b2 == 0) {
                if (i5 != -1) {
                    insertKeyAt(i5, b);
                    return i5;
                }
                this.consumeFreeSlot = true;
                insertKeyAt(i4, b);
                return i4;
            }
            if (b2 == 1 && this._set[i4] == b) {
                return (-i4) - 1;
            }
        } while (i4 != i);
        if (i5 != -1) {
            insertKeyAt(i5, b);
            return i5;
        }
        throw new IllegalStateException("No free or removed slots available. Key set full?!!");
    }

    void insertKeyAt(int i, byte b) {
        this._set[i] = b;
        this._states[i] = 1;
    }

    protected int XinsertKey(byte b) {
        int i;
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        int length = bArr.length;
        int hash = HashFunctions.hash((int) b) & Integer.MAX_VALUE;
        int i2 = hash % length;
        byte b2 = bArr[i2];
        this.consumeFreeSlot = false;
        if (b2 == 0) {
            this.consumeFreeSlot = true;
            bArr2[i2] = b;
            bArr[i2] = 1;
            return i2;
        }
        if (b2 != 1 || bArr2[i2] != b) {
            int i3 = (hash % (length - 2)) + 1;
            if (b2 != 2) {
                do {
                    i2 -= i3;
                    if (i2 < 0) {
                        i2 += length;
                    }
                    b2 = bArr[i2];
                    if (b2 != 1) {
                        break;
                    }
                } while (bArr2[i2] != b);
            }
            if (b2 == 2) {
                int i4 = i2;
                while (b2 != 0 && (b2 == 2 || bArr2[i4] != b)) {
                    i4 -= i3;
                    if (i4 < 0) {
                        i4 += length;
                    }
                    b2 = bArr[i4];
                }
                if (b2 == 1) {
                    i = -i4;
                    return i - 1;
                }
                bArr2[i4] = b;
                bArr[i4] = 1;
                return i2;
            }
            if (b2 != 1) {
                this.consumeFreeSlot = true;
                bArr2[i2] = b;
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
        objectOutput.writeByte(this.no_entry_key);
        objectOutput.writeChar(this.no_entry_value);
    }

    @Override // gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
        this.no_entry_key = objectInput.readByte();
        this.no_entry_value = objectInput.readChar();
    }
}
