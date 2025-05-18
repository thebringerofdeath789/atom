package gnu.trove.decorator;

import gnu.trove.list.TByteList;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TByteListDecorator extends AbstractList<Byte> implements List<Byte>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TByteList list;

    public TByteListDecorator() {
    }

    public TByteListDecorator(TByteList tByteList) {
        Objects.requireNonNull(tByteList);
        this.list = tByteList;
    }

    public TByteList getList() {
        return this.list;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public Byte get(int i) {
        byte b = this.list.get(i);
        if (b == this.list.getNoEntryValue()) {
            return null;
        }
        return Byte.valueOf(b);
    }

    @Override // java.util.AbstractList, java.util.List
    public Byte set(int i, Byte b) {
        byte b2 = this.list.set(i, b.byteValue());
        if (b2 == this.list.getNoEntryValue()) {
            return null;
        }
        return Byte.valueOf(b2);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Byte b) {
        this.list.insert(i, b.byteValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public Byte remove(int i) {
        byte removeAt = this.list.removeAt(i);
        if (removeAt == this.list.getNoEntryValue()) {
            return null;
        }
        return Byte.valueOf(removeAt);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this.list = (TByteList) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this.list);
    }
}