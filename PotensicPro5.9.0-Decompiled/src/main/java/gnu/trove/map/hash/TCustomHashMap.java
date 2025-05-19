package gnu.trove.map.hash;

import gnu.trove.function.TObjectFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TCustomObjectHash;
import gnu.trove.impl.hash.TObjectHash;
import gnu.trove.iterator.hash.TObjectHashIterator;
import gnu.trove.map.TMap;
import gnu.trove.procedure.TObjectObjectProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.strategy.HashingStrategy;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TCustomHashMap<K, V> extends TCustomObjectHash<K> implements TMap<K, V>, Externalizable {
    static final long serialVersionUID = 1;
    protected transient V[] _values;

    public TCustomHashMap() {
    }

    public TCustomHashMap(HashingStrategy<? super K> hashingStrategy) {
        super(hashingStrategy);
    }

    public TCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i) {
        super(hashingStrategy, i);
    }

    public TCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i, float f) {
        super(hashingStrategy, i, f);
    }

    public TCustomHashMap(HashingStrategy<? super K> hashingStrategy, Map<? extends K, ? extends V> map) {
        this(hashingStrategy, map.size());
        putAll(map);
    }

    public TCustomHashMap(HashingStrategy<? super K> hashingStrategy, TCustomHashMap<? extends K, ? extends V> tCustomHashMap) {
        this(hashingStrategy, tCustomHashMap.size());
        putAll(tCustomHashMap);
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    public int setUp(int i) {
        int up = super.setUp(i);
        this._values = (V[]) new Object[up];
        return up;
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        return doPut(v, insertKey(k));
    }

    @Override // gnu.trove.map.TMap, java.util.Map
    public V putIfAbsent(K k, V v) {
        int insertKey = insertKey(k);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(v, insertKey);
    }

    private V doPut(V v, int i) {
        V v2;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            v2 = this._values[i];
            z = false;
        } else {
            v2 = null;
        }
        this._values[i] = v;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return v2;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != size()) {
            return false;
        }
        return forEachEntry(new EqProcedure(map));
    }

    @Override // java.util.Map
    public int hashCode() {
        HashProcedure hashProcedure = new HashProcedure();
        forEachEntry(hashProcedure);
        return hashProcedure.getHashCode();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TObjectObjectProcedure<K, V>() { // from class: gnu.trove.map.hash.TCustomHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TObjectObjectProcedure
            public boolean execute(K k, V v) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(k);
                sb.append("=");
                sb.append(v);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    private final class HashProcedure implements TObjectObjectProcedure<K, V> {
        private int h;

        private HashProcedure() {
            this.h = 0;
        }

        public int getHashCode() {
            return this.h;
        }

        @Override // gnu.trove.procedure.TObjectObjectProcedure
        public final boolean execute(K k, V v) {
            this.h += HashFunctions.hash(k) ^ (v == null ? 0 : v.hashCode());
            return true;
        }
    }

    private static final class EqProcedure<K, V> implements TObjectObjectProcedure<K, V> {
        private final Map<K, V> _otherMap;

        EqProcedure(Map<K, V> map) {
            this._otherMap = map;
        }

        @Override // gnu.trove.procedure.TObjectObjectProcedure
        public final boolean execute(K k, V v) {
            if (v == null && !this._otherMap.containsKey(k)) {
                return false;
            }
            V v2 = this._otherMap.get(k);
            return v2 == v || (v2 != null && v2.equals(v));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.map.TMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return forEach(tObjectProcedure);
    }

    @Override // gnu.trove.map.TMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        V[] vArr = this._values;
        Object[] objArr = this._set;
        int length = vArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectProcedure.execute(vArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TMap
    public boolean forEachEntry(TObjectObjectProcedure<? super K, ? super V> tObjectObjectProcedure) {
        Object[] objArr = this._set;
        V[] vArr = this._values;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectObjectProcedure.execute(objArr[i], vArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TMap
    public boolean retainEntries(TObjectObjectProcedure<? super K, ? super V> tObjectObjectProcedure) {
        Object[] objArr = this._set;
        V[] vArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectObjectProcedure.execute(objArr[i], vArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        V[] vArr = this._values;
        Object[] objArr = this._set;
        int length = vArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED) {
                vArr[i] = tObjectFunction.execute(vArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        int size = size();
        Object[] objArr = this._set;
        V[] vArr = this._values;
        this._set = new Object[i];
        Arrays.fill(this._set, FREE);
        this._values = (V[]) new Object[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            Object obj = objArr[i2];
            if (obj != FREE && obj != REMOVED) {
                int insertKey = insertKey(obj);
                if (insertKey < 0) {
                    throwObjectContractViolation(this._set[(-insertKey) - 1], obj, size(), size, objArr);
                }
                this._values[insertKey] = vArr[i2];
            }
            length = i2;
        }
    }

    @Override // java.util.Map
    public V get(Object obj) {
        int index = index(obj);
        if (index < 0 || !this.strategy.equals(this._set[index], obj)) {
            return null;
        }
        return this._values[index];
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        if (size() == 0) {
            return;
        }
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, FREE);
        V[] vArr = this._values;
        Arrays.fill(vArr, 0, vArr.length, (Object) null);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        int index = index(obj);
        if (index < 0) {
            return null;
        }
        V v = this._values[index];
        removeAt(index);
        return v;
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    public void removeAt(int i) {
        this._values[i] = null;
        super.removeAt(i);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new ValueView();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return new KeyView();
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntryView();
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Object[] objArr = this._set;
        V[] vArr = this._values;
        if (obj == null) {
            int length = vArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (objArr[i] != FREE && objArr[i] != REMOVED && obj == vArr[i]) {
                    return true;
                }
                length = i;
            }
        } else {
            int length2 = vArr.length;
            while (true) {
                int i2 = length2 - 1;
                if (length2 <= 0) {
                    return false;
                }
                if (objArr[i2] == FREE || objArr[i2] == REMOVED || (obj != vArr[i2] && !this.strategy.equals(obj, vArr[i2]))) {
                    length2 = i2;
                }
            }
            return true;
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return contains(obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    protected class ValueView extends TCustomHashMap<K, V>.MapBackedView<V> {
        protected ValueView() {
            super();
        }

        @Override // gnu.trove.map.hash.TCustomHashMap.MapBackedView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new TObjectHashIterator(TCustomHashMap.this) { // from class: gnu.trove.map.hash.TCustomHashMap.ValueView.1
                @Override // gnu.trove.iterator.hash.TObjectHashIterator, gnu.trove.impl.hash.THashIterator
                protected V objectAtIndex(int i) {
                    return TCustomHashMap.this._values[i];
                }
            };
        }

        @Override // gnu.trove.map.hash.TCustomHashMap.MapBackedView
        public boolean containsElement(V v) {
            return TCustomHashMap.this.containsValue(v);
        }

        @Override // gnu.trove.map.hash.TCustomHashMap.MapBackedView
        public boolean removeElement(V v) {
            int i;
            V[] vArr = TCustomHashMap.this._values;
            Object[] objArr = TCustomHashMap.this._set;
            int length = vArr.length;
            while (true) {
                i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if ((objArr[i] == TObjectHash.FREE || objArr[i] == TObjectHash.REMOVED || v != vArr[i]) && (vArr[i] == null || !TCustomHashMap.this.strategy.equals(vArr[i], v))) {
                    length = i;
                }
            }
            TCustomHashMap.this.removeAt(i);
            return true;
        }
    }

    protected class EntryView extends TCustomHashMap<K, V>.MapBackedView<Map.Entry<K, V>> {
        protected EntryView() {
            super();
        }

        private final class EntryIterator extends TObjectHashIterator {
            EntryIterator(TCustomHashMap<K, V> tCustomHashMap) {
                super(tCustomHashMap);
            }

            @Override // gnu.trove.iterator.hash.TObjectHashIterator, gnu.trove.impl.hash.THashIterator
            public TCustomHashMap<K, V>.Entry objectAtIndex(int i) {
                return new Entry(TCustomHashMap.this._set[i], TCustomHashMap.this._values[i], i);
            }
        }

        @Override // gnu.trove.map.hash.TCustomHashMap.MapBackedView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(TCustomHashMap.this);
        }

        @Override // gnu.trove.map.hash.TCustomHashMap.MapBackedView
        public boolean removeElement(Map.Entry<K, V> entry) {
            int index = TCustomHashMap.this.index(keyForEntry(entry));
            if (index < 0) {
                return false;
            }
            Object valueForEntry = valueForEntry(entry);
            if (valueForEntry != TCustomHashMap.this._values[index] && (valueForEntry == null || !TCustomHashMap.this.strategy.equals(valueForEntry, TCustomHashMap.this._values[index]))) {
                return false;
            }
            TCustomHashMap.this.removeAt(index);
            return true;
        }

        @Override // gnu.trove.map.hash.TCustomHashMap.MapBackedView
        public boolean containsElement(Map.Entry<K, V> entry) {
            Object obj = TCustomHashMap.this.get(keyForEntry(entry));
            V value = entry.getValue();
            return value == obj || (obj != null && TCustomHashMap.this.strategy.equals(obj, value));
        }

        protected V valueForEntry(Map.Entry<K, V> entry) {
            return entry.getValue();
        }

        protected K keyForEntry(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    private abstract class MapBackedView<E> extends AbstractSet<E> implements Set<E>, Iterable<E> {
        public abstract boolean containsElement(E e);

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public abstract Iterator<E> iterator();

        public abstract boolean removeElement(E e);

        private MapBackedView() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return containsElement(obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return removeElement(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TCustomHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TCustomHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] objArr = new Object[size()];
            Iterator<E> it = iterator();
            int i = 0;
            while (it.hasNext()) {
                objArr[i] = it.next();
                i++;
            }
            return objArr;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            Iterator<E> it = iterator();
            for (int i = 0; i < size; i++) {
                tArr[i] = it.next();
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TCustomHashMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            Iterator<E> it = iterator();
            if (!it.hasNext()) {
                return "{}";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            while (true) {
                Object next = it.next();
                if (next == this) {
                    next = "(this Collection)";
                }
                sb.append(next);
                if (!it.hasNext()) {
                    return sb.append('}').toString();
                }
                sb.append(", ");
            }
        }
    }

    protected class KeyView extends TCustomHashMap<K, V>.MapBackedView<K> {
        protected KeyView() {
            super();
        }

        @Override // gnu.trove.map.hash.TCustomHashMap.MapBackedView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new TObjectHashIterator(TCustomHashMap.this);
        }

        @Override // gnu.trove.map.hash.TCustomHashMap.MapBackedView
        public boolean removeElement(K k) {
            return TCustomHashMap.this.remove(k) != null;
        }

        @Override // gnu.trove.map.hash.TCustomHashMap.MapBackedView
        public boolean containsElement(K k) {
            return TCustomHashMap.this.contains(k);
        }
    }

    final class Entry implements Map.Entry<K, V> {
        private final int index;
        private K key;
        private V val;

        Entry(K k, V v, int i) {
            this.key = k;
            this.val = v;
            this.index = i;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.val;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = TCustomHashMap.this._values[this.index];
            V v3 = this.val;
            if (v2 != v3) {
                throw new ConcurrentModificationException();
            }
            TCustomHashMap.this._values[this.index] = v;
            this.val = v;
            return v3;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (getKey() == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!TCustomHashMap.this.strategy.equals(getKey(), entry.getKey())) {
                return false;
            }
            if (getValue() == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!getValue().equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
        }

        public String toString() {
            return this.key + "=" + this.val;
        }
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
                objectOutput.writeObject(this._values[i]);
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
            put(objectInput.readObject(), objectInput.readObject());
            readInt = i;
        }
    }
}
