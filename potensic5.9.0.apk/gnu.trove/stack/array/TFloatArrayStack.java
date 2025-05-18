package gnu.trove.stack.array;

import gnu.trove.list.array.TFloatArrayList;
import gnu.trove.stack.TFloatStack;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TFloatArrayStack implements TFloatStack, Externalizable {
    public static final int DEFAULT_CAPACITY = 10;
    static final long serialVersionUID = 1;
    protected TFloatArrayList _list;

    public TFloatArrayStack() {
        this(10);
    }

    public TFloatArrayStack(int i) {
        this._list = new TFloatArrayList(i);
    }

    public TFloatArrayStack(int i, float f) {
        this._list = new TFloatArrayList(i, f);
    }

    public TFloatArrayStack(TFloatStack tFloatStack) {
        if (tFloatStack instanceof TFloatArrayStack) {
            this._list = new TFloatArrayList(((TFloatArrayStack) tFloatStack)._list);
            return;
        }
        throw new UnsupportedOperationException("Only support TFloatArrayStack");
    }

    @Override // gnu.trove.stack.TFloatStack
    public float getNoEntryValue() {
        return this._list.getNoEntryValue();
    }

    @Override // gnu.trove.stack.TFloatStack
    public void push(float f) {
        this._list.add(f);
    }

    @Override // gnu.trove.stack.TFloatStack
    public float pop() {
        return this._list.removeAt(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TFloatStack
    public float peek() {
        return this._list.get(r0.size() - 1);
    }

    @Override // gnu.trove.stack.TFloatStack
    public int size() {
        return this._list.size();
    }

    @Override // gnu.trove.stack.TFloatStack
    public void clear() {
        this._list.clear();
    }

    @Override // gnu.trove.stack.TFloatStack
    public float[] toArray() {
        float[] array = this._list.toArray();
        reverse(array, 0, size());
        return array;
    }

    @Override // gnu.trove.stack.TFloatStack
    public void toArray(float[] fArr) {
        int size = size();
        int length = size - fArr.length;
        if (length < 0) {
            length = 0;
        }
        int min = Math.min(size, fArr.length);
        this._list.toArray(fArr, length, min);
        reverse(fArr, 0, min);
        if (fArr.length > size) {
            fArr[size] = this._list.getNoEntryValue();
        }
    }

    private void reverse(float[] fArr, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i > i2) {
            throw new IllegalArgumentException("from cannot be greater than to");
        }
        for (int i3 = i2 - 1; i < i3; i3--) {
            swap(fArr, i, i3);
            i++;
        }
    }

    private void swap(float[] fArr, int i, int i2) {
        float f = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f;
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
        return this._list.equals(((TFloatArrayStack) obj)._list);
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
        this._list = (TFloatArrayList) objectInput.readObject();
    }
}