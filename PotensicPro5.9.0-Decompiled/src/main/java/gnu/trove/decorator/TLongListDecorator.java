package gnu.trove.decorator;

import gnu.trove.list.TLongList;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TLongListDecorator extends AbstractList<Long> implements List<Long>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TLongList list;

    public TLongListDecorator() {
    }

    public TLongListDecorator(TLongList tLongList) {
        Objects.requireNonNull(tLongList);
        this.list = tLongList;
    }

    public TLongList getList() {
        return this.list;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int i) {
        long j = this.list.get(i);
        if (j == this.list.getNoEntryValue()) {
            return null;
        }
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList, java.util.List
    public Long set(int i, Long l) {
        long j = this.list.set(i, l.longValue());
        if (j == this.list.getNoEntryValue()) {
            return null;
        }
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Long l) {
        this.list.insert(i, l.longValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public Long remove(int i) {
        long removeAt = this.list.removeAt(i);
        if (removeAt == this.list.getNoEntryValue()) {
            return null;
        }
        return Long.valueOf(removeAt);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this.list = (TLongList) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this.list);
    }
}
