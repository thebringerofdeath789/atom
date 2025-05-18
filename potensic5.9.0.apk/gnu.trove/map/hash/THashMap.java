package gnu.trove.map.hash;

import gnu.trove.function.TObjectFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TObjectHash;
import gnu.trove.iterator.hash.TObjectHashIterator;
import gnu.trove.map.TMap;
import gnu.trove.procedure.TObjectObjectProcedure;
import gnu.trove.procedure.TObjectProcedure;
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
public class THashMap<K, V> extends TObjectHash<K> implements TMap<K, V>, Externalizable {
    static final long serialVersionUID = 1;
    protected transient V[] _values;

    public THashMap() {
    }

    public THashMap(int i) {
        super(i);
    }

    public THashMap(int i, float f) {
        super(i, f);
    }

    public THashMap(Map<? extends K, ? extends V> map) {
        this(map.size());
        putAll(map);
    }

    public THashMap(THashMap<? extends K, ? extends V> tHashMap) {
        this(tHashMap.size());
        putAll(tHashMap);
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
        forEachEntry(new TObjectObjectProcedure<K, V>() { // from class: gnu.trove.map.hash.THashMap.1
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

        /* renamed from: h */
        private int f3728h;

        private HashProcedure() {
            this.f3728h = 0;
        }

        public int getHashCode() {
            return this.f3728h;
        }

        @Override // gnu.trove.procedure.TObjectObjectProcedure
        public final boolean execute(K k, V v) {
            this.f3728h += HashFunctions.hash(k) ^ (v == null ? 0 : v.hashCode());
            return true;
        }
    }

    private final class EqProcedure<K, V> implements TObjectObjectProcedure<K, V> {
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
            return v2 == v || (v2 != null && THashMap.this.equals(v2, v));
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
            if (length > 0) {
                Object obj = objArr[i2];
                if (obj != FREE && obj != REMOVED) {
                    int insertKey = insertKey(obj);
                    if (insertKey < 0) {
                        throwObjectContractViolation(this._set[(-insertKey) - 1], obj, size(), size, objArr);
                    }
                    this._values[insertKey] = vArr[i2];
                }
                length = i2;
            } else {
                reportPotentialConcurrentMod(size(), size);
                return;
            }
        }
    }

    @Override // java.util.Map
    public V get(Object obj) {
        int index = index(obj);
        if (index < 0) {
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
                if (objArr[i2] == FREE || objArr[i2] == REMOVED || (obj != vArr[i2] && !equals(obj, vArr[i2]))) {
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

    protected class ValueView extends THashMap<K, V>.MapBackedView<V> {
        protected ValueView() {
            super();
        }

        @Override // gnu.trove.map.hash.THashMap.MapBackedView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new TObjectHashIterator(THashMap.this) { // from class: gnu.trove.map.hash.THashMap.ValueView.1
                @Override // gnu.trove.iterator.hash.TObjectHashIterator, gnu.trove.impl.hash.THashIterator
                protected V objectAtIndex(int i) {
                    return THashMap.this._values[i];
                }
            };
        }

        @Override // gnu.trove.map.hash.THashMap.MapBackedView
        public boolean containsElement(V v) {
            return THashMap.this.containsValue(v);
        }

        @Override // gnu.trove.map.hash.THashMap.MapBackedView
        public boolean removeElement(V v) {
            int i;
            V[] vArr = THashMap.this._values;
            Object[] objArr = THashMap.this._set;
            int length = vArr.length;
            while (true) {
                i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if ((objArr[i] == TObjectHash.FREE || objArr[i] == TObjectHash.REMOVED || v != vArr[i]) && (vArr[i] == null || !THashMap.this.equals(vArr[i], v))) {
                    length = i;
                }
            }
            THashMap.this.removeAt(i);
            return true;
        }
    }

    protected class EntryView extends THashMap<K, V>.MapBackedView<Map.Entry<K, V>> {
        protected EntryView() {
            super();
        }

        private final class EntryIterator extends TObjectHashIterator {
            EntryIterator(THashMap<K, V> tHashMap) {
                super(tHashMap);
            }

            @Override // gnu.trove.iterator.hash.TObjectHashIterator, gnu.trove.impl.hash.THashIterator
            public THashMap<K, V>.Entry objectAtIndex(int i) {
                return new Entry(THashMap.this._set[i], THashMap.this._values[i], i);
            }
        }

        @Override // gnu.trove.map.hash.THashMap.MapBackedView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(THashMap.this);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        
            if (r2.equals(r5, r2._values[r1]) != false) goto L12;
         */
        @Override // gnu.trove.map.hash.THashMap.MapBackedView
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean removeElement(java.util.Map.Entry<K, V> r5) {
            /*
                r4 = this;
                r0 = 0
                if (r5 != 0) goto L4
                return r0
            L4:
                java.lang.Object r1 = r4.keyForEntry(r5)
                gnu.trove.map.hash.THashMap r2 = gnu.trove.map.hash.THashMap.this
                int r1 = gnu.trove.map.hash.THashMap.access$400(r2, r1)
                if (r1 < 0) goto L31
                java.lang.Object r5 = r4.valueForEntry(r5)
                gnu.trove.map.hash.THashMap r2 = gnu.trove.map.hash.THashMap.this
                V[] r2 = r2._values
                r2 = r2[r1]
                if (r5 == r2) goto L2a
                if (r5 == 0) goto L31
                gnu.trove.map.hash.THashMap r2 = gnu.trove.map.hash.THashMap.this
                V[] r3 = r2._values
                r3 = r3[r1]
                boolean r5 = gnu.trove.map.hash.THashMap.access$500(r2, r5, r3)
                if (r5 == 0) goto L31
            L2a:
                gnu.trove.map.hash.THashMap r5 = gnu.trove.map.hash.THashMap.this
                r5.removeAt(r1)
                r5 = 1
                return r5
            L31:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: gnu.trove.map.hash.THashMap.EntryView.removeElement(java.util.Map$Entry):boolean");
        }

        @Override // gnu.trove.map.hash.THashMap.MapBackedView
        public boolean containsElement(Map.Entry<K, V> entry) {
            Object obj = THashMap.this.get(keyForEntry(entry));
            V value = entry.getValue();
            return value == obj || (obj != null && THashMap.this.equals(obj, value));
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
            try {
                return removeElement(obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            THashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return THashMap.this.size();
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
            return THashMap.this.isEmpty();
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

    protected class KeyView extends THashMap<K, V>.MapBackedView<K> {
        protected KeyView() {
            super();
        }

        @Override // gnu.trove.map.hash.THashMap.MapBackedView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new TObjectHashIterator(THashMap.this);
        }

        @Override // gnu.trove.map.hash.THashMap.MapBackedView
        public boolean removeElement(K k) {
            return THashMap.this.remove(k) != null;
        }

        @Override // gnu.trove.map.hash.THashMap.MapBackedView
        public boolean containsElement(K k) {
            return THashMap.this.contains(k);
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
            V v2 = THashMap.this._values[this.index];
            V v3 = this.val;
            if (v2 != v3) {
                throw new ConcurrentModificationException();
            }
            THashMap.this._values[this.index] = v;
            this.val = v;
            return v3;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            return (obj instanceof Map.Entry) && THashMap.this.equals(getKey(), ((Map.Entry) obj).getKey()) && THashMap.this.equals(getValue(), getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
        }

        public String toString() {
            return this.key + "=" + this.val;
        }
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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