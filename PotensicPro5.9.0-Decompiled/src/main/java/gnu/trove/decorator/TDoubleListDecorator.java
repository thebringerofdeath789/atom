package gnu.trove.decorator;

import gnu.trove.list.TDoubleList;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TDoubleListDecorator extends AbstractList<Double> implements List<Double>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TDoubleList list;

    public TDoubleListDecorator() {
    }

    public TDoubleListDecorator(TDoubleList tDoubleList) {
        Objects.requireNonNull(tDoubleList);
        this.list = tDoubleList;
    }

    public TDoubleList getList() {
        return this.list;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public Double get(int i) {
        double d = this.list.get(i);
        if (d == this.list.getNoEntryValue()) {
            return null;
        }
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractList, java.util.List
    public Double set(int i, Double d) {
        double d2 = this.list.set(i, d.doubleValue());
        if (d2 == this.list.getNoEntryValue()) {
            return null;
        }
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Double d) {
        this.list.insert(i, d.doubleValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public Double remove(int i) {
        double removeAt = this.list.removeAt(i);
        if (removeAt == this.list.getNoEntryValue()) {
            return null;
        }
        return Double.valueOf(removeAt);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this.list = (TDoubleList) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this.list);
    }
}
