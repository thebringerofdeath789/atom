package gnu.trove.decorator;

import gnu.trove.iterator.TShortIterator;
import gnu.trove.set.TShortSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TShortSetDecorator extends AbstractSet<Short> implements Set<Short>, Externalizable {
    static final long serialVersionUID = 1;
    protected TShortSet _set;

    public TShortSetDecorator() {
    }

    public TShortSetDecorator(TShortSet tShortSet) {
        Objects.requireNonNull(tShortSet);
        this._set = tShortSet;
    }

    public TShortSet getSet() {
        return this._set;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Short sh) {
        return sh != null && this._set.add(sh.shortValue());
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
            if (!(next instanceof Short)) {
                break;
            }
            if (!this._set.contains(((Short) next).shortValue())) {
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
        return (obj instanceof Short) && this._set.remove(((Short) obj).shortValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Short> iterator() {
        return new Iterator<Short>() { // from class: gnu.trove.decorator.TShortSetDecorator.1

            /* renamed from: it */
            private final TShortIterator f3577it;

            {
                this.f3577it = TShortSetDecorator.this._set.iterator();
            }

            @Override // java.util.Iterator
            public Short next() {
                return Short.valueOf(this.f3577it.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f3577it.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f3577it.remove();
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
        if (obj instanceof Short) {
            return this._set.contains(((Short) obj).shortValue());
        }
        return false;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._set = (TShortSet) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._set);
    }
}