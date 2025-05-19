package org.apache.commons.collections.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes4.dex */
public abstract class AbstractMapBag implements Bag {
    private transient Map map;
    private transient int modCount;
    private int size;
    private transient Set uniqueSet;

    static /* synthetic */ int access$210(AbstractMapBag abstractMapBag) {
        int i = abstractMapBag.size;
        abstractMapBag.size = i - 1;
        return i;
    }

    protected AbstractMapBag() {
    }

    protected AbstractMapBag(Map map) {
        this.map = map;
    }

    protected Map getMap() {
        return this.map;
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // org.apache.commons.collections.Bag
    public int getCount(Object obj) {
        MutableInteger mutableInteger = (MutableInteger) this.map.get(obj);
        if (mutableInteger != null) {
            return mutableInteger.value;
        }
        return 0;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public boolean containsAll(Collection collection) {
        if (collection instanceof Bag) {
            return containsAll((Bag) collection);
        }
        return containsAll((Bag) new HashBag(collection));
    }

    boolean containsAll(Bag bag) {
        boolean z;
        while (true) {
            for (Object obj : bag.uniqueSet()) {
                z = z && (getCount(obj) >= bag.getCount(obj));
            }
            return z;
        }
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new BagIterator(this);
    }

    static class BagIterator implements Iterator {
        private Iterator entryIterator;
        private int itemCount;
        private final int mods;
        private AbstractMapBag parent;
        private Map.Entry current = null;
        private boolean canRemove = false;

        public BagIterator(AbstractMapBag abstractMapBag) {
            this.parent = abstractMapBag;
            this.entryIterator = abstractMapBag.map.entrySet().iterator();
            this.mods = abstractMapBag.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.itemCount > 0 || this.entryIterator.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.parent.modCount != this.mods) {
                throw new ConcurrentModificationException();
            }
            if (this.itemCount == 0) {
                Map.Entry entry = (Map.Entry) this.entryIterator.next();
                this.current = entry;
                this.itemCount = ((MutableInteger) entry.getValue()).value;
            }
            this.canRemove = true;
            this.itemCount--;
            return this.current.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.parent.modCount != this.mods) {
                throw new ConcurrentModificationException();
            }
            if (!this.canRemove) {
                throw new IllegalStateException();
            }
            MutableInteger mutableInteger = (MutableInteger) this.current.getValue();
            if (mutableInteger.value > 1) {
                mutableInteger.value--;
            } else {
                this.entryIterator.remove();
            }
            AbstractMapBag.access$210(this.parent);
            this.canRemove = false;
        }
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public boolean add(Object obj) {
        return add(obj, 1);
    }

    @Override // org.apache.commons.collections.Bag
    public boolean add(Object obj, int i) {
        this.modCount++;
        if (i > 0) {
            MutableInteger mutableInteger = (MutableInteger) this.map.get(obj);
            this.size += i;
            if (mutableInteger == null) {
                this.map.put(obj, new MutableInteger(i));
                return true;
            }
            mutableInteger.value += i;
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                boolean add = add(it.next());
                if (z || add) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.Collection
    public void clear() {
        this.modCount++;
        this.map.clear();
        this.size = 0;
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public boolean remove(Object obj) {
        MutableInteger mutableInteger = (MutableInteger) this.map.get(obj);
        if (mutableInteger == null) {
            return false;
        }
        this.modCount++;
        this.map.remove(obj);
        this.size -= mutableInteger.value;
        return true;
    }

    @Override // org.apache.commons.collections.Bag
    public boolean remove(Object obj, int i) {
        MutableInteger mutableInteger = (MutableInteger) this.map.get(obj);
        if (mutableInteger == null || i <= 0) {
            return false;
        }
        this.modCount++;
        if (i < mutableInteger.value) {
            mutableInteger.value -= i;
            this.size -= i;
        } else {
            this.map.remove(obj);
            this.size -= mutableInteger.value;
        }
        return true;
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public boolean removeAll(Collection collection) {
        if (collection == null) {
            return false;
        }
        Iterator it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                boolean remove = remove(it.next(), 1);
                if (z || remove) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public boolean retainAll(Collection collection) {
        if (collection instanceof Bag) {
            return retainAll((Bag) collection);
        }
        return retainAll((Bag) new HashBag(collection));
    }

    boolean retainAll(Bag bag) {
        HashBag hashBag = new HashBag();
        for (Object obj : uniqueSet()) {
            int count = getCount(obj);
            int count2 = bag.getCount(obj);
            if (1 <= count2 && count2 <= count) {
                hashBag.add(obj, count - count2);
            } else {
                hashBag.add(obj, count);
            }
        }
        if (hashBag.isEmpty()) {
            return false;
        }
        return removeAll(hashBag);
    }

    protected static class MutableInteger {
        protected int value;

        MutableInteger(int i) {
            this.value = i;
        }

        public boolean equals(Object obj) {
            return (obj instanceof MutableInteger) && ((MutableInteger) obj).value == this.value;
        }

        public int hashCode() {
            return this.value;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        int i = 0;
        for (Object obj : this.map.keySet()) {
            int count = getCount(obj);
            while (count > 0) {
                objArr[i] = obj;
                count--;
                i++;
            }
        }
        return objArr;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        int size = size();
        if (objArr.length < size) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
        }
        int i = 0;
        for (Object obj : this.map.keySet()) {
            int count = getCount(obj);
            while (count > 0) {
                objArr[i] = obj;
                count--;
                i++;
            }
        }
        if (objArr.length > size) {
            objArr[size] = null;
        }
        return objArr;
    }

    @Override // org.apache.commons.collections.Bag
    public Set uniqueSet() {
        if (this.uniqueSet == null) {
            this.uniqueSet = UnmodifiableSet.decorate(this.map.keySet());
        }
        return this.uniqueSet;
    }

    protected void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.map.size());
        for (Map.Entry entry : this.map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((MutableInteger) entry.getValue()).value);
        }
    }

    protected void doReadObject(Map map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.map = map;
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            map.put(readObject, new MutableInteger(readInt2));
            this.size += readInt2;
        }
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bag)) {
            return false;
        }
        Bag bag = (Bag) obj;
        if (bag.size() != size()) {
            return false;
        }
        for (Object obj2 : this.map.keySet()) {
            if (bag.getCount(obj2) != getCount(obj2)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public int hashCode() {
        int i = 0;
        for (Map.Entry entry : this.map.entrySet()) {
            Object key = entry.getKey();
            i += ((MutableInteger) entry.getValue()).value ^ (key == null ? 0 : key.hashCode());
        }
        return i;
    }

    public String toString() {
        if (size() == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(PropertyUtils.INDEXED_DELIM);
        Iterator it = uniqueSet().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            stringBuffer.append(getCount(next));
            stringBuffer.append(NameUtil.COLON);
            stringBuffer.append(next);
            if (it.hasNext()) {
                stringBuffer.append(',');
            }
        }
        stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        return stringBuffer.toString();
    }
}
