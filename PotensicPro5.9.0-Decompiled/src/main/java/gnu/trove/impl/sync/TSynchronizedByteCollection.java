package gnu.trove.impl.sync;

import gnu.trove.TByteCollection;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.procedure.TByteProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedByteCollection implements TByteCollection, Serializable {
    private static final long serialVersionUID = 3053995032091335093L;
    final TByteCollection c;
    final Object mutex;

    public TSynchronizedByteCollection(TByteCollection tByteCollection) {
        Objects.requireNonNull(tByteCollection);
        this.c = tByteCollection;
        this.mutex = this;
    }

    public TSynchronizedByteCollection(TByteCollection tByteCollection, Object obj) {
        this.c = tByteCollection;
        this.mutex = obj;
    }

    @Override // gnu.trove.TByteCollection
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.c.size();
        }
        return size;
    }

    @Override // gnu.trove.TByteCollection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.c.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.TByteCollection
    public boolean contains(byte b) {
        boolean contains;
        synchronized (this.mutex) {
            contains = this.c.contains(b);
        }
        return contains;
    }

    @Override // gnu.trove.TByteCollection
    public byte[] toArray() {
        byte[] array;
        synchronized (this.mutex) {
            array = this.c.toArray();
        }
        return array;
    }

    @Override // gnu.trove.TByteCollection
    public byte[] toArray(byte[] bArr) {
        byte[] array;
        synchronized (this.mutex) {
            array = this.c.toArray(bArr);
        }
        return array;
    }

    @Override // gnu.trove.TByteCollection
    public TByteIterator iterator() {
        return this.c.iterator();
    }

    @Override // gnu.trove.TByteCollection
    public boolean add(byte b) {
        boolean add;
        synchronized (this.mutex) {
            add = this.c.add(b);
        }
        return add;
    }

    @Override // gnu.trove.TByteCollection
    public boolean remove(byte b) {
        boolean remove;
        synchronized (this.mutex) {
            remove = this.c.remove(b);
        }
        return remove;
    }

    @Override // gnu.trove.TByteCollection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(collection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TByteCollection
    public boolean containsAll(TByteCollection tByteCollection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(tByteCollection);
        }
        return containsAll;
    }

    @Override // gnu.trove.TByteCollection
    public boolean containsAll(byte[] bArr) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = this.c.containsAll(bArr);
        }
        return containsAll;
    }

    @Override // gnu.trove.TByteCollection
    public boolean addAll(Collection<? extends Byte> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(collection);
        }
        return addAll;
    }

    @Override // gnu.trove.TByteCollection
    public boolean addAll(TByteCollection tByteCollection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(tByteCollection);
        }
        return addAll;
    }

    @Override // gnu.trove.TByteCollection
    public boolean addAll(byte[] bArr) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = this.c.addAll(bArr);
        }
        return addAll;
    }

    @Override // gnu.trove.TByteCollection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(collection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TByteCollection
    public boolean removeAll(TByteCollection tByteCollection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(tByteCollection);
        }
        return removeAll;
    }

    @Override // gnu.trove.TByteCollection
    public boolean removeAll(byte[] bArr) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = this.c.removeAll(bArr);
        }
        return removeAll;
    }

    @Override // gnu.trove.TByteCollection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(collection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TByteCollection
    public boolean retainAll(TByteCollection tByteCollection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(tByteCollection);
        }
        return retainAll;
    }

    @Override // gnu.trove.TByteCollection
    public boolean retainAll(byte[] bArr) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = this.c.retainAll(bArr);
        }
        return retainAll;
    }

    @Override // gnu.trove.TByteCollection
    public byte getNoEntryValue() {
        return this.c.getNoEntryValue();
    }

    @Override // gnu.trove.TByteCollection
    public boolean forEach(TByteProcedure tByteProcedure) {
        boolean forEach;
        synchronized (this.mutex) {
            forEach = this.c.forEach(tByteProcedure);
        }
        return forEach;
    }

    @Override // gnu.trove.TByteCollection
    public void clear() {
        synchronized (this.mutex) {
            this.c.clear();
        }
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.c.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}
