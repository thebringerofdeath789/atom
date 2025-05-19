package gnu.trove.decorator;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.set.TIntSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TIntSetDecorator extends AbstractSet<Integer> implements Set<Integer>, Externalizable {
    static final long serialVersionUID = 1;
    protected TIntSet _set;

    public TIntSetDecorator() {
    }

    public TIntSetDecorator(TIntSet tIntSet) {
        Objects.requireNonNull(tIntSet);
        this._set = tIntSet;
    }

    public TIntSet getSet() {
        return this._set;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Integer num) {
        return num != null && this._set.add(num.intValue());
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
            if (!(next instanceof Integer)) {
                break;
            }
            if (!this._set.contains(((Integer) next).intValue())) {
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
        return (obj instanceof Integer) && this._set.remove(((Integer) obj).intValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() { // from class: gnu.trove.decorator.TIntSetDecorator.1
            private final TIntIterator it;

            {
                this.it = TIntSetDecorator.this._set.iterator();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Integer next() {
                return Integer.valueOf(this.it.next());
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
        if (obj instanceof Integer) {
            return this._set.contains(((Integer) obj).intValue());
        }
        return false;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._set = (TIntSet) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._set);
    }
}
