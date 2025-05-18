package gnu.trove.decorator;

import gnu.trove.iterator.TCharIterator;
import gnu.trove.set.TCharSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TCharSetDecorator extends AbstractSet<Character> implements Set<Character>, Externalizable {
    static final long serialVersionUID = 1;
    protected TCharSet _set;

    public TCharSetDecorator() {
    }

    public TCharSetDecorator(TCharSet tCharSet) {
        Objects.requireNonNull(tCharSet);
        this._set = tCharSet;
    }

    public TCharSet getSet() {
        return this._set;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Character ch) {
        return ch != null && this._set.add(ch.charValue());
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
            if (!(next instanceof Character)) {
                break;
            }
            if (!this._set.contains(((Character) next).charValue())) {
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
        return (obj instanceof Character) && this._set.remove(((Character) obj).charValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Character> iterator() {
        return new Iterator<Character>() { // from class: gnu.trove.decorator.TCharSetDecorator.1

            /* renamed from: it */
            private final TCharIterator f3525it;

            {
                this.f3525it = TCharSetDecorator.this._set.iterator();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Character next() {
                return Character.valueOf(this.f3525it.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f3525it.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f3525it.remove();
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
        if (obj instanceof Character) {
            return this._set.contains(((Character) obj).charValue());
        }
        return false;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._set = (TCharSet) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._set);
    }
}