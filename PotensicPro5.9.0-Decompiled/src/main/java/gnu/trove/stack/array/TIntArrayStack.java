package gnu.trove.stack.array;

import gnu.trove.list.array.TIntArrayList;
import gnu.trove.stack.TIntStack;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TIntArrayStack implements TIntStack, Externalizable {
    public static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected TIntArrayList _list;

    public TIntArrayStack() {
        this(10);
    }

    public TIntArrayStack(int i) {
        this._list = new TIntArrayList(i);
    }

    public TIntArrayStack(int i, int i2) {
        this._list = new TIntArrayList(i, i2);
    }

    public TIntArrayStack(TIntStack tIntStack) {
        if (tIntStack instanceof TIntArrayStack) {
            this._list = new TIntArrayList(((TIntArrayStack) tIntStack)._list);
            return;
        }
        throw new UnsupportedOperationException("Only support TIntArrayStack");
    }

    @Override // gnu.trove.stack.TIntStack
    public int getNoEntryValue() {
        return this._list.getNoEntryValue();
    }

    @Override // gnu.trove.stack.TIntStack
    public void push(int i) {
        this._list.add(i);
    }

    @Override // gnu.trove.stack.TIntStack
    public int pop() {
        return this._list.removeAt(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TIntStack
    public int peek() {
        return this._list.get(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TIntStack
    public int size() {
        return this._list.size();
    }

    @Override // gnu.trove.stack.TIntStack
    public void clear() {
        this._list.clear();
    }

    @Override // gnu.trove.stack.TIntStack
    public int[] toArray() {
        int[] array = this._list.toArray();
        reverse(array, 0, size());
        return array;
    }

    @Override // gnu.trove.stack.TIntStack
    public void toArray(int[] iArr) {
        int size = size();
        int length = size - iArr.length;
        if (length < 0) {
            length = 0;
        }
        int min = Math.min(size, iArr.length);
        this._list.toArray(iArr, length, min);
        reverse(iArr, 0, min);
        if (iArr.length > size) {
            iArr[size] = this._list.getNoEntryValue();
        }
    }

    private void reverse(int[] iArr, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i > i2) {
            throw new IllegalArgumentException("from cannot be greater than to");
        }
        for (int i3 = i2 - 1; i < i3; i3--) {
            swap(iArr, i, i3);
            i++;
        }
    }

    private void swap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int size = this._list.size() - 1; size > 0; size--) {
            sb.append(this._list.get(size));
            sb.append(", ");
        }
        if (size() > 0) {
            sb.append(this._list.get(0));
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
        return this._list.equals(((TIntArrayStack) obj)._list);
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
        this._list = (TIntArrayList) objectInput.readObject();
    }
}
