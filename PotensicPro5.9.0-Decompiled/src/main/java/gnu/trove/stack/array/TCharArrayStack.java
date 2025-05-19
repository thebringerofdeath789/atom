package gnu.trove.stack.array;

import gnu.trove.list.array.TCharArrayList;
import gnu.trove.stack.TCharStack;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TCharArrayStack implements TCharStack, Externalizable {
    public static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected TCharArrayList _list;

    public TCharArrayStack() {
        this(10);
    }

    public TCharArrayStack(int i) {
        this._list = new TCharArrayList(i);
    }

    public TCharArrayStack(int i, char c) {
        this._list = new TCharArrayList(i, c);
    }

    public TCharArrayStack(TCharStack tCharStack) {
        if (tCharStack instanceof TCharArrayStack) {
            this._list = new TCharArrayList(((TCharArrayStack) tCharStack)._list);
            return;
        }
        throw new UnsupportedOperationException("Only support TCharArrayStack");
    }

    @Override // gnu.trove.stack.TCharStack
    public char getNoEntryValue() {
        return this._list.getNoEntryValue();
    }

    @Override // gnu.trove.stack.TCharStack
    public void push(char c) {
        this._list.add(c);
    }

    @Override // gnu.trove.stack.TCharStack
    public char pop() {
        return this._list.removeAt(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TCharStack
    public char peek() {
        return this._list.get(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TCharStack
    public int size() {
        return this._list.size();
    }

    @Override // gnu.trove.stack.TCharStack
    public void clear() {
        this._list.clear();
    }

    @Override // gnu.trove.stack.TCharStack
    public char[] toArray() {
        char[] array = this._list.toArray();
        reverse(array, 0, size());
        return array;
    }

    @Override // gnu.trove.stack.TCharStack
    public void toArray(char[] cArr) {
        int size = size();
        int length = size - cArr.length;
        if (length < 0) {
            length = 0;
        }
        int min = Math.min(size, cArr.length);
        this._list.toArray(cArr, length, min);
        reverse(cArr, 0, min);
        if (cArr.length > size) {
            cArr[size] = this._list.getNoEntryValue();
        }
    }

    private void reverse(char[] cArr, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i > i2) {
            throw new IllegalArgumentException("from cannot be greater than to");
        }
        for (int i3 = i2 - 1; i < i3; i3--) {
            swap(cArr, i, i3);
            i++;
        }
    }

    private void swap(char[] cArr, int i, int i2) {
        char c = cArr[i];
        cArr[i] = cArr[i2];
        cArr[i2] = c;
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
        return this._list.equals(((TCharArrayStack) obj)._list);
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
        this._list = (TCharArrayList) objectInput.readObject();
    }
}
