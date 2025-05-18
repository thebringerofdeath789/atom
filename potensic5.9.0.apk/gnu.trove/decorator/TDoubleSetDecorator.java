package gnu.trove.decorator;

import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.set.TDoubleSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TDoubleSetDecorator extends AbstractSet<Double> implements Set<Double>, Externalizable {
    static final long serialVersionUID = 1;
    protected TDoubleSet _set;

    public TDoubleSetDecorator() {
    }

    public TDoubleSetDecorator(TDoubleSet tDoubleSet) {
        Objects.requireNonNull(tDoubleSet);
        this._set = tDoubleSet;
    }

    public TDoubleSet getSet() {
        return this._set;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Double d) {
        return d != null && this._set.add(d.doubleValue());
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
            if (!(next instanceof Double)) {
                break;
            }
            if (!this._set.contains(((Double) next).doubleValue())) {
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
        return (obj instanceof Double) && this._set.remove(((Double) obj).doubleValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Double> iterator() {
        return new Iterator<Double>() { // from class: gnu.trove.decorator.TDoubleSetDecorator.1

            /* renamed from: it */
            private final TDoubleIterator f3534it;

            {
                this.f3534it = TDoubleSetDecorator.this._set.iterator();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Double next() {
                return Double.valueOf(this.f3534it.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f3534it.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f3534it.remove();
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
        if (obj instanceof Double) {
            return this._set.contains(((Double) obj).doubleValue());
        }
        return false;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._set = (TDoubleSet) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._set);
    }
}