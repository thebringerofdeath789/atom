package gnu.trove.stack.array;

import gnu.trove.list.array.TByteArrayList;
import gnu.trove.stack.TByteStack;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TByteArrayStack implements TByteStack, Externalizable {
    public static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected TByteArrayList _list;

    public TByteArrayStack() {
        this(10);
    }

    public TByteArrayStack(int i) {
        this._list = new TByteArrayList(i);
    }

    public TByteArrayStack(int i, byte b) {
        this._list = new TByteArrayList(i, b);
    }

    public TByteArrayStack(TByteStack tByteStack) {
        if (tByteStack instanceof TByteArrayStack) {
            this._list = new TByteArrayList(((TByteArrayStack) tByteStack)._list);
            return;
        }
        throw new UnsupportedOperationException("Only support TByteArrayStack");
    }

    @Override // gnu.trove.stack.TByteStack
    public byte getNoEntryValue() {
        return this._list.getNoEntryValue();
    }

    @Override // gnu.trove.stack.TByteStack
    public void push(byte b) {
        this._list.add(b);
    }

    @Override // gnu.trove.stack.TByteStack
    public byte pop() {
        return this._list.removeAt(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TByteStack
    public byte peek() {
        return this._list.get(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TByteStack
    public int size() {
        return this._list.size();
    }

    @Override // gnu.trove.stack.TByteStack
    public void clear() {
        this._list.clear();
    }

    @Override // gnu.trove.stack.TByteStack
    public byte[] toArray() {
        byte[] array = this._list.toArray();
        reverse(array, 0, size());
        return array;
    }

    @Override // gnu.trove.stack.TByteStack
    public void toArray(byte[] bArr) {
        int size = size();
        int length = size - bArr.length;
        if (length < 0) {
            length = 0;
        }
        int min = Math.min(size, bArr.length);
        this._list.toArray(bArr, length, min);
        reverse(bArr, 0, min);
        if (bArr.length > size) {
            bArr[size] = this._list.getNoEntryValue();
        }
    }

    private void reverse(byte[] bArr, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i > i2) {
            throw new IllegalArgumentException("from cannot be greater than to");
        }
        for (int i3 = i2 - 1; i < i3; i3--) {
            swap(bArr, i, i3);
            i++;
        }
    }

    private void swap(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int size = this._list.size() - 1; size > 0; size--) {
            sb.append((int) this._list.get(size));
            sb.append(", ");
        }
        if (size() > 0) {
            sb.append((int) this._list.get(0));
        }
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this._list.equals(((TByteArrayStack) obj)._list);
    }

    public int hashCode() {
        return this._list.hashCode();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._list);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._list = (TByteArrayList) objectInput.readObject();
    }
}
