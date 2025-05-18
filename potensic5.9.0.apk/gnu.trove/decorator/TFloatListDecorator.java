package gnu.trove.decorator;

import gnu.trove.list.TFloatList;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TFloatListDecorator extends AbstractList<Float> implements List<Float>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TFloatList list;

    public TFloatListDecorator() {
    }

    public TFloatListDecorator(TFloatList tFloatList) {
        Objects.requireNonNull(tFloatList);
        this.list = tFloatList;
    }

    public TFloatList getList() {
        return this.list;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public Float get(int i) {
        float f = this.list.get(i);
        if (f == this.list.getNoEntryValue()) {
            return null;
        }
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList, java.util.List
    public Float set(int i, Float f) {
        float f2 = this.list.set(i, f.floatValue());
        if (f2 == this.list.getNoEntryValue()) {
            return null;
        }
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Float f) {
        this.list.insert(i, f.floatValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public Float remove(int i) {
        float removeAt = this.list.removeAt(i);
        if (removeAt == this.list.getNoEntryValue()) {
            return null;
        }
        return Float.valueOf(removeAt);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this.list = (TFloatList) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this.list);
    }
}