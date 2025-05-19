package gnu.trove.decorator;

import gnu.trove.iterator.TLongIterator;
import gnu.trove.set.TLongSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TLongSetDecorator extends AbstractSet<Long> implements Set<Long>, Externalizable {
    static final long serialVersionUID = 1;
    protected TLongSet _set;

    public TLongSetDecorator() {
    }

    public TLongSetDecorator(TLongSet tLongSet) {
        Objects.requireNonNull(tLongSet);
        this._set = tLongSet;
    }

    public TLongSet getSet() {
        return this._set;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Long l) {
        return l != null && this._set.add(l.longValue());
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
            if (!(next instanceof Long)) {
                break;
            }
            if (!this._set.contains(((Long) next).longValue())) {
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
        return (obj instanceof Long) && this._set.remove(((Long) obj).longValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Long> iterator() {
        return new Iterator<Long>() { // from class: gnu.trove.decorator.TLongSetDecorator.1
            private final TLongIterator it;

            {
                this.it = TLongSetDecorator.this._set.iterator();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Long next() {
                return Long.valueOf(this.it.next());
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
        if (obj instanceof Long) {
            return this._set.contains(((Long) obj).longValue());
        }
        return false;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._set = (TLongSet) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._set);
    }
}
