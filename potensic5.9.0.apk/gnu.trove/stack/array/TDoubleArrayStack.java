package gnu.trove.stack.array;

import gnu.trove.list.array.TDoubleArrayList;
import gnu.trove.stack.TDoubleStack;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TDoubleArrayStack implements TDoubleStack, Externalizable {
    public static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected TDoubleArrayList _list;

    public TDoubleArrayStack() {
        this(10);
    }

    public TDoubleArrayStack(int i) {
        this._list = new TDoubleArrayList(i);
    }

    public TDoubleArrayStack(int i, double d) {
        this._list = new TDoubleArrayList(i, d);
    }

    public TDoubleArrayStack(TDoubleStack tDoubleStack) {
        if (tDoubleStack instanceof TDoubleArrayStack) {
            this._list = new TDoubleArrayList(((TDoubleArrayStack) tDoubleStack)._list);
            return;
        }
        throw new UnsupportedOperationException("Only support TDoubleArrayStack");
    }

    @Override // gnu.trove.stack.TDoubleStack
    public double getNoEntryValue() {
        return this._list.getNoEntryValue();
    }

    @Override // gnu.trove.stack.TDoubleStack
    public void push(double d) {
        this._list.add(d);
    }

    @Override // gnu.trove.stack.TDoubleStack
    public double pop() {
        return this._list.removeAt(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TDoubleStack
    public double peek() {
        return this._list.get(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TDoubleStack
    public int size() {
        return this._list.size();
    }

    @Override // gnu.trove.stack.TDoubleStack
    public void clear() {
        this._list.clear();
    }

    @Override // gnu.trove.stack.TDoubleStack
    public double[] toArray() {
        double[] array = this._list.toArray();
        reverse(array, 0, size());
        return array;
    }

    @Override // gnu.trove.stack.TDoubleStack
    public void toArray(double[] dArr) {
        int size = size();
        int length = size - dArr.length;
        if (length < 0) {
            length = 0;
        }
        int min = Math.min(size, dArr.length);
        this._list.toArray(dArr, length, min);
        reverse(dArr, 0, min);
        if (dArr.length > size) {
            dArr[size] = this._list.getNoEntryValue();
        }
    }

    private void reverse(double[] dArr, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i > i2) {
            throw new IllegalArgumentException("from cannot be greater than to");
        }
        for (int i3 = i2 - 1; i < i3; i3--) {
            swap(dArr, i, i3);
            i++;
        }
    }

    private void swap(double[] dArr, int i, int i2) {
        double d = dArr[i];
        dArr[i] = dArr[i2];
        dArr[i2] = d;
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
        return this._list.equals(((TDoubleArrayStack) obj)._list);
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
        this._list = (TDoubleArrayList) objectInput.readObject();
    }
}