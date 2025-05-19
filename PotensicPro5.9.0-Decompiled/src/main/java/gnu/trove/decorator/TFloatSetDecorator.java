package gnu.trove.decorator;

import gnu.trove.iterator.TFloatIterator;
import gnu.trove.set.TFloatSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TFloatSetDecorator extends AbstractSet<Float> implements Set<Float>, Externalizable {
    static final long serialVersionUID = 1;
    protected TFloatSet _set;

    public TFloatSetDecorator() {
    }

    public TFloatSetDecorator(TFloatSet tFloatSet) {
        Objects.requireNonNull(tFloatSet);
        this._set = tFloatSet;
    }

    public TFloatSet getSet() {
        return this._set;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Float f) {
        return f != null && this._set.add(f.floatValue());
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
            if (!(next instanceof Float)) {
                break;
            }
            if (!this._set.contains(((Float) next).floatValue())) {
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
        return (obj instanceof Float) && this._set.remove(((Float) obj).floatValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Float> iterator() {
        return new Iterator<Float>() { // from class: gnu.trove.decorator.TFloatSetDecorator.1
            private final TFloatIterator it;

            {
                this.it = TFloatSetDecorator.this._set.iterator();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Float next() {
                return Float.valueOf(this.it.next());
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
        if (obj instanceof Float) {
            return this._set.contains(((Float) obj).floatValue());
        }
        return false;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._set = (TFloatSet) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._set);
    }
}
