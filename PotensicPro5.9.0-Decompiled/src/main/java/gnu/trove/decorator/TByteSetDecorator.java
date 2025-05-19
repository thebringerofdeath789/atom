package gnu.trove.decorator;

import gnu.trove.iterator.TByteIterator;
import gnu.trove.set.TByteSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TByteSetDecorator extends AbstractSet<Byte> implements Set<Byte>, Externalizable {
    static final long serialVersionUID = 1;
    protected TByteSet _set;

    public TByteSetDecorator() {
    }

    public TByteSetDecorator(TByteSet tByteSet) {
        Objects.requireNonNull(tByteSet);
        this._set = tByteSet;
    }

    public TByteSet getSet() {
        return this._set;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Byte b) {
        return b != null && this._set.add(b.byteValue());
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this._set.equals(obj)) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.size() != this._set.size()) {
            return false;
        }
        Iterator it = set.iterator();
        int size = set.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return true;
            }
            Object next = it.next();
            if (!(next instanceof Byte)) {
                break;
            }
            if (!this._set.contains(((Byte) next).byteValue())) {
                break;
            }
            size = i;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this._set.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return (obj instanceof Byte) && this._set.remove(((Byte) obj).byteValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Byte> iterator() {
        return new Iterator<Byte>() { // from class: gnu.trove.decorator.TByteSetDecorator.1
            private final TByteIterator it;

            {
                this.it = TByteSetDecorator.this._set.iterator();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Byte next() {
                return Byte.valueOf(this.it.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.it.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.it.remove();
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this._set.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this._set.size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj instanceof Byte) {
            return this._set.contains(((Byte) obj).byteValue());
        }
        return false;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._set = (TByteSet) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._set);
    }
}
