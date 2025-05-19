package gnu.trove.decorator;

import gnu.trove.list.TShortList;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TShortListDecorator extends AbstractList<Short> implements List<Short>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TShortList list;

    public TShortListDecorator() {
    }

    public TShortListDecorator(TShortList tShortList) {
        Objects.requireNonNull(tShortList);
        this.list = tShortList;
    }

    public TShortList getList() {
        return this.list;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public Short get(int i) {
        short s = this.list.get(i);
        if (s == this.list.getNoEntryValue()) {
            return null;
        }
        return Short.valueOf(s);
    }

    @Override // java.util.AbstractList, java.util.List
    public Short set(int i, Short sh) {
        short s = this.list.set(i, sh.shortValue());
        if (s == this.list.getNoEntryValue()) {
            return null;
        }
        return Short.valueOf(s);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Short sh) {
        this.list.insert(i, sh.shortValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public Short remove(int i) {
        short removeAt = this.list.removeAt(i);
        if (removeAt == this.list.getNoEntryValue()) {
            return null;
        }
        return Short.valueOf(removeAt);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this.list = (TShortList) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this.list);
    }
}
