package gnu.trove.decorator;

import gnu.trove.list.TIntList;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TIntListDecorator extends AbstractList<Integer> implements List<Integer>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TIntList list;

    public TIntListDecorator() {
    }

    public TIntListDecorator(TIntList tIntList) {
        Objects.requireNonNull(tIntList);
        this.list = tIntList;
    }

    public TIntList getList() {
        return this.list;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int i) {
        int i2 = this.list.get(i);
        if (i2 == this.list.getNoEntryValue()) {
            return null;
        }
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer set(int i, Integer num) {
        int i2 = this.list.set(i, num.intValue());
        if (i2 == this.list.getNoEntryValue()) {
            return null;
        }
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Integer num) {
        this.list.insert(i, num.intValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer remove(int i) {
        int removeAt = this.list.removeAt(i);
        if (removeAt == this.list.getNoEntryValue()) {
            return null;
        }
        return Integer.valueOf(removeAt);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this.list = (TIntList) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this.list);
    }
}