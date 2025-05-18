package gnu.trove.impl.sync;

import gnu.trove.TCharCollection;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.procedure.TCharProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedCharCollection implements TCharCollection, Serializable {
    private static final long serialVersionUID = 3053995032091335093L;

    /* renamed from: c */
    final TCharCollection f3591c;
    final Object mutex;

    public TSynchronizedCharCollection(TCharCollection tCharCollection) {
        Objects.requireNonNull(tCharCollection);
        this.f3591c = tCharCollection;
        this.mutex = this;
    }

    public TSynchronizedCharCollection(TCharCollection tCharCollection, Object obj) {
        this.f3591c = tCharCollection;
        this.mutex = obj;
    }

    @Override // gnu.trove.TCharCollection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3591c.size();
        }
        return size;
    }

    @Override // gnu.trove.TCharCollection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3591c.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.TCharCollection
    public boolean contains(char c) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.f3591c.contains(c);
        }
        return contains;
    }

    @Override // gnu.trove.TCharCollection
    public char[] toArray() {
        char[] array;
        synchronized (this.mutex) {
            array = this.f3591c.toArray();
        }
        return array;
    }

    @Override // gnu.trove.TCharCollection
    public char[] toArray(char[] cArr) {
        char[] array;
        synchronized (this.mutex) {
            array = this.f3591c.toArray(cArr);
        }
        return array;
    }

    @Override // gnu.trove.TCharCollection
    public TCharIterator iterator() {
        return this.f3591c.iterator();
    }

    @Override // gnu.trove.TCharCollection
    public boolean add(char c) {
        boolean add;
        synchronized (this.mutex) {
            add = this.f3591c.add(c);
        }
        return add;
    }

    @Override // gnu.trove.TCharCollection
    public boolean remove(char c) {
        boolean remove;
        synchronized (this.mutex) {
            remove = this.f3591c.remove(c);
        }
        return remove;
    }

    @Override // gnu.trove.TCharCollection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3591c.containsAll(collection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TCharCollection
    public boolean containsAll(TCharCollection tCharCollection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3591c.containsAll(tCharCollection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TCharCollection
    public boolean containsAll(char[] cArr) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.f3591c.containsAll(cArr);
        }
        return containsAll;
    }

    @Override // gnu.trove.TCharCollection
    public boolean addAll(Collection<? extends Character> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3591c.addAll(collection);
        }
        return addAll;
    }

    @Override // gnu.trove.TCharCollection
    public boolean addAll(TCharCollection tCharCollection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3591c.addAll(tCharCollection);
        }
        return addAll;
    }

    @Override // gnu.trove.TCharCollection
    public boolean addAll(char[] cArr) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.f3591c.addAll(cArr);
        }
        return addAll;
    }

    @Override // gnu.trove.TCharCollection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3591c.removeAll(collection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TCharCollection
    public boolean removeAll(TCharCollection tCharCollection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3591c.removeAll(tCharCollection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TCharCollection
    public boolean removeAll(char[] cArr) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.f3591c.removeAll(cArr);
        }
        return removeAll;
    }

    @Override // gnu.trove.TCharCollection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3591c.retainAll(collection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TCharCollection
    public boolean retainAll(TCharCollection tCharCollection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3591c.retainAll(tCharCollection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TCharCollection
    public boolean retainAll(char[] cArr) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.f3591c.retainAll(cArr);
        }
        return retainAll;
    }

    @Override // gnu.trove.TCharCollection
    public char getNoEntryValue() {
        return this.f3591c.getNoEntryValue();
    }

    @Override // gnu.trove.TCharCollection
    public boolean forEach(TCharProcedure tCharProcedure) {
        boolean forEach;
        synchronized (this.mutex) {
            forEach = this.f3591c.forEach(tCharProcedure);
        }
        return forEach;
    }

    @Override // gnu.trove.TCharCollection
    public void clear() {
        synchronized (this.mutex) {
            this.f3591c.clear();
        }
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3591c.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}