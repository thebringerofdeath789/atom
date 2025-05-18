package gnu.trove.stack.array;

import gnu.trove.list.array.TShortArrayList;
import gnu.trove.stack.TShortStack;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TShortArrayStack implements TShortStack, Externalizable {
    public static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected TShortArrayList _list;

    public TShortArrayStack() {
        this(10);
    }

    public TShortArrayStack(int i) {
        this._list = new TShortArrayList(i);
    }

    public TShortArrayStack(int i, short s) {
        this._list = new TShortArrayList(i, s);
    }

    public TShortArrayStack(TShortStack tShortStack) {
        if (tShortStack instanceof TShortArrayStack) {
            this._list = new TShortArrayList(((TShortArrayStack) tShortStack)._list);
            return;
        }
        throw new UnsupportedOperationException("Only support TShortArrayStack");
    }

    @Override // gnu.trove.stack.TShortStack
    public short getNoEntryValue() {
        return this._list.getNoEntryValue();
    }

    @Override // gnu.trove.stack.TShortStack
    public void push(short s) {
        this._list.add(s);
    }

    @Override // gnu.trove.stack.TShortStack
    public short pop() {
        return this._list.removeAt(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TShortStack
    public short peek() {
        return this._list.get(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TShortStack
    public int size() {
        return this._list.size();
    }

    @Override // gnu.trove.stack.TShortStack
    public void clear() {
        this._list.clear();
    }

    @Override // gnu.trove.stack.TShortStack
    public short[] toArray() {
        short[] array = this._list.toArray();
        reverse(array, 0, size());
        return array;
    }

    @Override // gnu.trove.stack.TShortStack
    public void toArray(short[] sArr) {
        int size = size();
        int length = size - sArr.length;
        if (length < 0) {
            length = 0;
        }
        int min = Math.min(size, sArr.length);
        this._list.toArray(sArr, length, min);
        reverse(sArr, 0, min);
        if (sArr.length > size) {
            sArr[size] = this._list.getNoEntryValue();
        }
    }

    private void reverse(short[] sArr, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i > i2) {
            throw new IllegalArgumentException("from cannot be greater than to");
        }
        for (int i3 = i2 - 1; i < i3; i3--) {
            swap(sArr, i, i3);
            i++;
        }
    }

    private void swap(short[] sArr, int i, int i2) {
        short s = sArr[i];
        sArr[i] = sArr[i2];
        sArr[i2] = s;
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
        return this._list.equals(((TShortArrayStack) obj)._list);
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
        this._list = (TShortArrayList) objectInput.readObject();
    }
}