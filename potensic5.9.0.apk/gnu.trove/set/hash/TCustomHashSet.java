package gnu.trove.set.hash;

import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TCustomObjectHash;
import gnu.trove.iterator.hash.TObjectHashIterator;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.procedure.array.ToObjectArrayProceedure;
import gnu.trove.strategy.HashingStrategy;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TCustomHashSet<E> extends TCustomObjectHash<E> implements Set<E>, Iterable<E>, Externalizable {
    static final long serialVersionUID = 1;

    public TCustomHashSet() {
    }

    public TCustomHashSet(HashingStrategy<? super E> hashingStrategy) {
        super(hashingStrategy);
    }

    public TCustomHashSet(HashingStrategy<? super E> hashingStrategy, int i) {
        super(hashingStrategy, i);
    }

    public TCustomHashSet(HashingStrategy<? super E> hashingStrategy, int i, float f) {
        super(hashingStrategy, i, f);
    }

    public TCustomHashSet(HashingStrategy<? super E> hashingStrategy, Collection<? extends E> collection) {
        this(hashingStrategy, collection.size());
        addAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(E e) {
        if (insertKey(e) < 0) {
            return false;
        }
        postInsertHook(this.consumeFreeSlot);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.size() != size()) {
            return false;
        }
        return containsAll(set);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        HashProcedure hashProcedure = new HashProcedure();
        forEach(hashProcedure);
        return hashProcedure.getHashCode();
    }

    private final class HashProcedure implements TObjectProcedure<E> {

        /* renamed from: h */
        private int f3729h;

        private HashProcedure() {
            this.f3729h = 0;
        }

        public int getHashCode() {
            return this.f3729h;
        }

        @Override // gnu.trove.procedure.TObjectProcedure
        public final boolean execute(E e) {
            this.f3729h += HashFunctions.hash(e);
            return true;
        }
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int insertKey;
        int length = this._set.length;
        int size = size();
        Object[] objArr = this._set;
        this._set = new Object[i];
        Arrays.fill(this._set, FREE);
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            Object obj = objArr[i2];
            if (obj != FREE && obj != REMOVED && (insertKey = insertKey(obj)) < 0) {
                throwObjectContractViolation(this._set[(-insertKey) - 1], obj, size(), size, objArr);
            }
            length = i2;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        forEach(new ToObjectArrayProceedure(objArr));
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        forEach(new ToObjectArrayProceedure(tArr));
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, FREE);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        int index = index(obj);
        if (index < 0) {
            return false;
        }
        removeAt(index);
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public TObjectHashIterator<E> iterator() {
        return new TObjectHashIterator<>(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        ensureCapacity(size);
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return z;
            }
            if (add(it.next())) {
                z = true;
            }
            size = i;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        int size = collection.size();
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return z;
            }
            if (remove(it.next())) {
                z = true;
            }
            size = i;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        int size = size();
        TObjectHashIterator<E> it = iterator();
        boolean z = false;
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return z;
            }
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
            size = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEach(new TObjectProcedure<E>() { // from class: gnu.trove.set.hash.TCustomHashSet.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TObjectProcedure
            public boolean execute(Object obj) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(obj);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TCustomObjectHash, gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(1);
        super.writeExternal(objectOutput);
        objectOutput.writeInt(this._size);
        int length = this._set.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._set[i] != REMOVED && this._set[i] != FREE) {
                objectOutput.writeObject(this._set[i]);
            }
            length = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.impl.hash.TCustomObjectHash, gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        if (objectInput.readByte() != 0) {
            super.readExternal(objectInput);
        }
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            add(objectInput.readObject());
            readInt = i;
        }
    }
}