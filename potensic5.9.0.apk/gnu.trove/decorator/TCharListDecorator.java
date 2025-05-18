package gnu.trove.decorator;

import gnu.trove.list.TCharList;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TCharListDecorator extends AbstractList<Character> implements List<Character>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TCharList list;

    public TCharListDecorator() {
    }

    public TCharListDecorator(TCharList tCharList) {
        Objects.requireNonNull(tCharList);
        this.list = tCharList;
    }

    public TCharList getList() {
        return this.list;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public Character get(int i) {
        char c = this.list.get(i);
        if (c == this.list.getNoEntryValue()) {
            return null;
        }
        return Character.valueOf(c);
    }

    @Override // java.util.AbstractList, java.util.List
    public Character set(int i, Character ch) {
        char c = this.list.set(i, ch.charValue());
        if (c == this.list.getNoEntryValue()) {
            return null;
        }
        return Character.valueOf(c);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Character ch) {
        this.list.insert(i, ch.charValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public Character remove(int i) {
        char removeAt = this.list.removeAt(i);
        if (removeAt == this.list.getNoEntryValue()) {
            return null;
        }
        return Character.valueOf(removeAt);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this.list = (TCharList) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this.list);
    }
}