package gnu.trove.impl.hash;

import gnu.trove.impl.HashFunctions;
import gnu.trove.procedure.TFloatProcedure;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* loaded from: classes3.dex */
public abstract class TFloatDoubleHash extends TPrimitiveHash {
    static final long serialVersionUID = 1;
    public transient float[] _set;
    protected boolean consumeFreeSlot;
    protected float no_entry_key;
    protected double no_entry_value;

    public TFloatDoubleHash() {
        this.no_entry_key = 0.0f;
        this.no_entry_value = 0.0d;
    }

    public TFloatDoubleHash(int i) {
        super(i);
        this.no_entry_key = 0.0f;
        this.no_entry_value = 0.0d;
    }

    public TFloatDoubleHash(int i, float f) {
        super(i, f);
        this.no_entry_key = 0.0f;
        this.no_entry_value = 0.0d;
    }

    public TFloatDoubleHash(int i, float f, float f2, double d) {
        super(i, f);
        this.no_entry_key = f2;
        this.no_entry_value = d;
    }

    public float getNoEntryKey() {
        return this.no_entry_key;
    }

    public double getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._set = new float[up];
        return up;
    }

    public boolean contains(float f) {
        return index(f) >= 0;
    }

    public boolean forEach(TFloatProcedure tFloatProcedure) {
        byte[] bArr = this._states;
        float[] fArr = this._set;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tFloatProcedure.execute(fArr[i])) {
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

    protected int index(float f) {
        byte[] bArr = this._states;
        float[] fArr = this._set;
        int length = bArr.length;
        int hash = HashFunctions.hash(f) & Integer.MAX_VALUE;
        int i = hash % length;
        byte b = bArr[i];
        if (b == 0) {
            return -1;
        }
        return (b == 1 && fArr[i] == f) ? i : indexRehashed(f, i, hash, b);
    }

    int indexRehashed(float f, int i, int i2, byte b) {
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
            if (f == this._set[i4] && b2 != 2) {
                return i4;
            }
        } while (i4 != i);
        return -1;
    }

    protected int insertKey(float f) {
        int hash = HashFunctions.hash(f) & Integer.MAX_VALUE;
        int length = hash % this._states.length;
        byte b = this._states[length];
        this.consumeFreeSlot = false;
        if (b != 0) {
            return (b == 1 && this._set[length] == f) ? (-length) - 1 : insertKeyRehash(f, length, hash, b);
        }
        this.consumeFreeSlot = true;
        insertKeyAt(length, f);
        return length;
    }

    int insertKeyRehash(float f, int i, int i2, byte b) {
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
                    insertKeyAt(i5, f);
                    return i5;
                }
                this.consumeFreeSlot = true;
                insertKeyAt(i4, f);
                return i4;
            }
            if (b == 1 && this._set[i4] == f) {
                return (-i4) - 1;
            }
        } while (i4 != i);
        if (i5 != -1) {
            insertKeyAt(i5, f);
            return i5;
        }
        throw new IllegalStateException("No free or removed slots available. Key set full?!!");
    }

    void insertKeyAt(int i, float f) {
        this._set[i] = f;
        this._states[i] = 1;
    }

    protected int XinsertKey(float f) {
        int i;
        byte[] bArr = this._states;
        float[] fArr = this._set;
        int length = bArr.length;
        int hash = HashFunctions.hash(f) & Integer.MAX_VALUE;
        int i2 = hash % length;
        byte b = bArr[i2];
        this.consumeFreeSlot = false;
        if (b == 0) {
            this.consumeFreeSlot = true;
            fArr[i2] = f;
            bArr[i2] = 1;
            return i2;
        }
        if (b != 1 || fArr[i2] != f) {
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
                } while (fArr[i2] != f);
            }
            if (b == 2) {
                int i4 = i2;
                while (b != 0 && (b == 2 || fArr[i4] != f)) {
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
                fArr[i4] = f;
                bArr[i4] = 1;
                return i2;
            }
            if (b != 1) {
                this.consumeFreeSlot = true;
                fArr[i2] = f;
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
        objectOutput.writeFloat(this.no_entry_key);
        objectOutput.writeDouble(this.no_entry_value);
    }

    @Override // gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
        this.no_entry_key = objectInput.readFloat();
        this.no_entry_value = objectInput.readDouble();
    }
}
