package gnu.trove.stack.array;

import gnu.trove.list.array.TLongArrayList;
import gnu.trove.stack.TLongStack;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TLongArrayStack implements TLongStack, Externalizable {
    public static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected TLongArrayList _list;

    public TLongArrayStack() {
        this(10);
    }

    public TLongArrayStack(int i) {
        this._list = new TLongArrayList(i);
    }

    public TLongArrayStack(int i, long j) {
        this._list = new TLongArrayList(i, j);
    }

    public TLongArrayStack(TLongStack tLongStack) {
        if (tLongStack instanceof TLongArrayStack) {
            this._list = new TLongArrayList(((TLongArrayStack) tLongStack)._list);
            return;
        }
        throw new UnsupportedOperationException("Only support TLongArrayStack");
    }

    @Override // gnu.trove.stack.TLongStack
    public long getNoEntryValue() {
        return this._list.getNoEntryValue();
    }

    @Override // gnu.trove.stack.TLongStack
    public void push(long j) {
        this._list.add(j);
    }

    @Override // gnu.trove.stack.TLongStack
    public long pop() {
        return this._list.removeAt(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TLongStack
    public long peek() {
        return this._list.get(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TLongStack
    public int size() {
        return this._list.size();
    }

    @Override // gnu.trove.stack.TLongStack
    public void clear() {
        this._list.clear();
    }

    @Override // gnu.trove.stack.TLongStack
    public long[] toArray() {
        long[] array = this._list.toArray();
        reverse(array, 0, size());
        return array;
    }

    @Override // gnu.trove.stack.TLongStack
    public void toArray(long[] jArr) {
        int size = size();
        int length = size - jArr.length;
        if (length < 0) {
            length = 0;
        }
        int min = Math.min(size, jArr.length);
        this._list.toArray(jArr, length, min);
        reverse(jArr, 0, min);
        if (jArr.length > size) {
            jArr[size] = this._list.getNoEntryValue();
        }
    }

    private void reverse(long[] jArr, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i > i2) {
            throw new IllegalArgumentException("from cannot be greater than to");
        }
        for (int i3 = i2 - 1; i < i3; i3--) {
            swap(jArr, i, i3);
            i++;
        }
    }

    private void swap(long[] jArr, int i, int i2) {
        long j = jArr[i];
        jArr[i] = jArr[i2];
        jArr[i2] = j;
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
        return this._list.equals(((TLongArrayStack) obj)._list);
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
        this._list = (TLongArrayList) objectInput.readObject();
    }
}
