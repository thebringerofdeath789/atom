package gnu.trove.impl.hash;

import gnu.trove.impl.HashFunctions;
import gnu.trove.procedure.TLongProcedure;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* loaded from: classes3.dex */
public abstract class TLongByteHash extends TPrimitiveHash {
    static final long serialVersionUID = 1;
    public transient long[] _set;
    protected boolean consumeFreeSlot;
    protected long no_entry_key;
    protected byte no_entry_value;

    public TLongByteHash() {
        this.no_entry_key = 0L;
        this.no_entry_value = (byte) 0;
    }

    public TLongByteHash(int i) {
        super(i);
        this.no_entry_key = 0L;
        this.no_entry_value = (byte) 0;
    }

    public TLongByteHash(int i, float f) {
        super(i, f);
        this.no_entry_key = 0L;
        this.no_entry_value = (byte) 0;
    }

    public TLongByteHash(int i, float f, long j, byte b) {
        super(i, f);
        this.no_entry_key = j;
        this.no_entry_value = b;
    }

    public long getNoEntryKey() {
        return this.no_entry_key;
    }

    public byte getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._set = new long[up];
        return up;
    }

    public boolean contains(long j) {
        return index(j) >= 0;
    }

    public boolean forEach(TLongProcedure tLongProcedure) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tLongProcedure.execute(jArr[i])) {
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

    protected int index(long j) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        int length = bArr.length;
        int hash = HashFunctions.hash(j) & Integer.MAX_VALUE;
        int i = hash % length;
        byte b = bArr[i];
        if (b == 0) {
            return -1;
        }
        return (b == 1 && jArr[i] == j) ? i : indexRehashed(j, i, hash, b);
    }

    int indexRehashed(long j, int i, int i2, byte b) {
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
            if (j == this._set[i4] && b2 != 2) {
                return i4;
            }
        } while (i4 != i);
        return -1;
    }

    protected int insertKey(long j) {
        int hash = HashFunctions.hash(j) & Integer.MAX_VALUE;
        int length = hash % this._states.length;
        byte b = this._states[length];
        this.consumeFreeSlot = false;
        if (b != 0) {
            return (b == 1 && this._set[length] == j) ? (-length) - 1 : insertKeyRehash(j, length, hash, b);
        }
        this.consumeFreeSlot = true;
        insertKeyAt(length, j);
        return length;
    }

    int insertKeyRehash(long j, int i, int i2, byte b) {
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
                    insertKeyAt(i5, j);
                    return i5;
                }
                this.consumeFreeSlot = true;
                insertKeyAt(i4, j);
                return i4;
            }
            if (b == 1 && this._set[i4] == j) {
                return (-i4) - 1;
            }
        } while (i4 != i);
        if (i5 != -1) {
            insertKeyAt(i5, j);
            return i5;
        }
        throw new IllegalStateException("No free or removed slots available. Key set full?!!");
    }

    void insertKeyAt(int i, long j) {
        this._set[i] = j;
        this._states[i] = 1;
    }

    protected int XinsertKey(long j) {
        int i;
        byte[] bArr = this._states;
        long[] jArr = this._set;
        int length = bArr.length;
        int hash = HashFunctions.hash(j) & Integer.MAX_VALUE;
        int i2 = hash % length;
        byte b = bArr[i2];
        this.consumeFreeSlot = false;
        if (b == 0) {
            this.consumeFreeSlot = true;
            jArr[i2] = j;
            bArr[i2] = 1;
            return i2;
        }
        if (b != 1 || jArr[i2] != j) {
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
                } while (jArr[i2] != j);
            }
            if (b == 2) {
                int i4 = i2;
                while (b != 0 && (b == 2 || jArr[i4] != j)) {
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
                jArr[i4] = j;
                bArr[i4] = 1;
                return i2;
            }
            if (b != 1) {
                this.consumeFreeSlot = true;
                jArr[i2] = j;
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
        objectOutput.writeLong(this.no_entry_key);
        objectOutput.writeByte(this.no_entry_value);
    }

    @Override // gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
        this.no_entry_key = objectInput.readLong();
        this.no_entry_value = objectInput.readByte();
    }
}
