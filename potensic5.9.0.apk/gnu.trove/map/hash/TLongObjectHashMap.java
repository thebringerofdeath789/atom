package gnu.trove.map.hash;

import gnu.trove.TLongCollection;
import gnu.trove.function.TObjectFunction;
import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TLongHash;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.iterator.TLongObjectIterator;
import gnu.trove.map.TLongObjectMap;
import gnu.trove.procedure.TLongObjectProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TLongSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TLongObjectHashMap<V> extends TLongHash implements TLongObjectMap<V>, Externalizable {
    static final long serialVersionUID = 1;
    private final TLongObjectProcedure<V> PUT_ALL_PROC;
    protected transient V[] _values;
    protected long no_entry_key;

    public TLongObjectHashMap() {
        this.PUT_ALL_PROC = new TLongObjectProcedure<V>() { // from class: gnu.trove.map.hash.TLongObjectHashMap.1
            @Override // gnu.trove.procedure.TLongObjectProcedure
            public boolean execute(long j, V v) {
                TLongObjectHashMap.this.put(j, v);
                return true;
            }
        };
    }

    public TLongObjectHashMap(int i) {
        super(i);
        this.PUT_ALL_PROC = new TLongObjectProcedure<V>() { // from class: gnu.trove.map.hash.TLongObjectHashMap.1
            @Override // gnu.trove.procedure.TLongObjectProcedure
            public boolean execute(long j, V v) {
                TLongObjectHashMap.this.put(j, v);
                return true;
            }
        };
        this.no_entry_key = Constants.DEFAULT_LONG_NO_ENTRY_VALUE;
    }

    public TLongObjectHashMap(int i, float f) {
        super(i, f);
        this.PUT_ALL_PROC = new TLongObjectProcedure<V>() { // from class: gnu.trove.map.hash.TLongObjectHashMap.1
            @Override // gnu.trove.procedure.TLongObjectProcedure
            public boolean execute(long j, V v) {
                TLongObjectHashMap.this.put(j, v);
                return true;
            }
        };
        this.no_entry_key = Constants.DEFAULT_LONG_NO_ENTRY_VALUE;
    }

    public TLongObjectHashMap(int i, float f, long j) {
        super(i, f);
        this.PUT_ALL_PROC = new TLongObjectProcedure<V>() { // from class: gnu.trove.map.hash.TLongObjectHashMap.1
            @Override // gnu.trove.procedure.TLongObjectProcedure
            public boolean execute(long j2, V v) {
                TLongObjectHashMap.this.put(j2, v);
                return true;
            }
        };
        this.no_entry_key = j;
    }

    public TLongObjectHashMap(TLongObjectMap<? extends V> tLongObjectMap) {
        this(tLongObjectMap.size(), 0.5f, tLongObjectMap.getNoEntryKey());
        putAll(tLongObjectMap);
    }

    @Override // gnu.trove.impl.hash.TLongHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = (V[]) new Object[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        long[] jArr = this._set;
        V[] vArr = this._values;
        byte[] bArr = this._states;
        this._set = new long[i];
        this._values = (V[]) new Object[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(jArr[i2])] = vArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public long getNoEntryKey() {
        return this.no_entry_key;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean containsKey(long j) {
        return contains(j);
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean containsValue(Object obj) {
        byte[] bArr = this._states;
        V[] vArr = this._values;
        if (obj == null) {
            int length = vArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] == 1 && vArr[i] == null) {
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
                if (bArr[i2] != 1 || (obj != vArr[i2] && !obj.equals(vArr[i2]))) {
                    length2 = i2;
                }
            }
            return true;
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public V get(long j) {
        int index = index(j);
        if (index < 0) {
            return null;
        }
        return this._values[index];
    }

    @Override // gnu.trove.map.TLongObjectMap
    public V put(long j, V v) {
        return doPut(v, insertKey(j));
    }

    @Override // gnu.trove.map.TLongObjectMap
    public V putIfAbsent(long j, V v) {
        int insertKey = insertKey(j);
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

    @Override // gnu.trove.map.TLongObjectMap
    public V remove(long j) {
        int index = index(j);
        if (index < 0) {
            return null;
        }
        V v = this._values[index];
        removeAt(index);
        return v;
    }

    @Override // gnu.trove.impl.hash.TLongHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = null;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TLongObjectMap
    public void putAll(Map<? extends Long, ? extends V> map) {
        for (Map.Entry<? extends Long, ? extends V> entry : map.entrySet()) {
            put(entry.getKey().longValue(), entry.getValue());
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public void putAll(TLongObjectMap<? extends V> tLongObjectMap) {
        tLongObjectMap.forEachEntry(this.PUT_ALL_PROC);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
        V[] vArr = this._values;
        Arrays.fill(vArr, 0, vArr.length, (Object) null);
    }

    @Override // gnu.trove.map.TLongObjectMap
    public TLongSet keySet() {
        return new KeyView();
    }

    @Override // gnu.trove.map.TLongObjectMap
    public long[] keys() {
        long[] jArr = new long[size()];
        long[] jArr2 = this._set;
        byte[] bArr = this._states;
        int length = jArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return jArr;
            }
            if (bArr[i2] == 1) {
                jArr[i] = jArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public long[] keys(long[] jArr) {
        if (jArr.length < this._size) {
            jArr = new long[this._size];
        }
        long[] jArr2 = this._set;
        byte[] bArr = this._states;
        int length = jArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return jArr;
            }
            if (bArr[i2] == 1) {
                jArr[i] = jArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public Collection<V> valueCollection() {
        return new ValueView();
    }

    @Override // gnu.trove.map.TLongObjectMap
    public Object[] values() {
        Object[] objArr = new Object[size()];
        V[] vArr = this._values;
        byte[] bArr = this._states;
        int length = vArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return objArr;
            }
            if (bArr[i2] == 1) {
                objArr[i] = vArr[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public V[] values(V[] vArr) {
        if (vArr.length < this._size) {
            vArr = (V[]) ((Object[]) Array.newInstance(vArr.getClass().getComponentType(), this._size));
        }
        V[] vArr2 = this._values;
        byte[] bArr = this._states;
        int length = vArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return vArr;
            }
            if (bArr[i2] == 1) {
                vArr[i] = vArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public TLongObjectIterator<V> iterator() {
        return new TLongObjectHashIterator(this);
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        return forEach(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        byte[] bArr = this._states;
        V[] vArr = this._values;
        int length = vArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tObjectProcedure.execute(vArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean forEachEntry(TLongObjectProcedure<? super V> tLongObjectProcedure) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        V[] vArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tLongObjectProcedure.execute(jArr[i], vArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean retainEntries(TLongObjectProcedure<? super V> tLongObjectProcedure) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        V[] vArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = jArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tLongObjectProcedure.execute(jArr[i], vArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        byte[] bArr = this._states;
        V[] vArr = this._values;
        int length = vArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i] == 1) {
                vArr[i] = tObjectFunction.execute(vArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean equals(Object obj) {
        if (!(obj instanceof TLongObjectMap)) {
            return false;
        }
        TLongObjectMap tLongObjectMap = (TLongObjectMap) obj;
        if (tLongObjectMap.size() != size()) {
            return false;
        }
        try {
            TLongObjectIterator<V> it = iterator();
            while (it.hasNext()) {
                it.advance();
                long key = it.key();
                V value = it.value();
                if (value == null) {
                    if (tLongObjectMap.get(key) != null || !tLongObjectMap.containsKey(key)) {
                        return false;
                    }
                } else if (!value.equals(tLongObjectMap.get(key))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return true;
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public int hashCode() {
        V[] vArr = this._values;
        byte[] bArr = this._states;
        int length = vArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return i;
            }
            if (bArr[i2] == 1) {
                i += HashFunctions.hash(this._set[i2]) ^ (vArr[i2] == null ? 0 : vArr[i2].hashCode());
            }
            length = i2;
        }
    }

    class KeyView implements TLongSet {
        KeyView() {
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public long getNoEntryValue() {
            return TLongObjectHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public int size() {
            return TLongObjectHashMap.this._size;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean isEmpty() {
            return TLongObjectHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean contains(long j) {
            return TLongObjectHashMap.this.containsKey(j);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public TLongIterator iterator() {
            return new TLongHashIterator(TLongObjectHashMap.this);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public long[] toArray() {
            return TLongObjectHashMap.this.keys();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public long[] toArray(long[] jArr) {
            return TLongObjectHashMap.this.keys(jArr);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean add(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean remove(long j) {
            return TLongObjectHashMap.this.remove(j) != null;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!TLongObjectHashMap.this.containsKey(((Long) it.next()).longValue())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean containsAll(TLongCollection tLongCollection) {
            if (tLongCollection == this) {
                return true;
            }
            TLongIterator it = tLongCollection.iterator();
            while (it.hasNext()) {
                if (!TLongObjectHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean containsAll(long[] jArr) {
            for (long j : jArr) {
                if (!TLongObjectHashMap.this.containsKey(j)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean addAll(Collection<? extends Long> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean addAll(TLongCollection tLongCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean addAll(long[] jArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean retainAll(Collection<?> collection) {
            TLongIterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Long.valueOf(it.next()))) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean retainAll(TLongCollection tLongCollection) {
            boolean z = false;
            if (this == tLongCollection) {
                return false;
            }
            TLongIterator it = iterator();
            while (it.hasNext()) {
                if (!tLongCollection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean retainAll(long[] jArr) {
            Arrays.sort(jArr);
            long[] jArr2 = TLongObjectHashMap.this._set;
            byte[] bArr = TLongObjectHashMap.this._states;
            int length = jArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(jArr, jArr2[i]) < 0) {
                    TLongObjectHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Long) && remove(((Long) obj).longValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean removeAll(TLongCollection tLongCollection) {
            if (tLongCollection == this) {
                clear();
                return true;
            }
            boolean z = false;
            TLongIterator it = tLongCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean removeAll(long[] jArr) {
            int length = jArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (remove(jArr[i])) {
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public void clear() {
            TLongObjectHashMap.this.clear();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean forEach(TLongProcedure tLongProcedure) {
            return TLongObjectHashMap.this.forEachKey(tLongProcedure);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean equals(Object obj) {
            if (!(obj instanceof TLongSet)) {
                return false;
            }
            TLongSet tLongSet = (TLongSet) obj;
            if (tLongSet.size() != size()) {
                return false;
            }
            int length = TLongObjectHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TLongObjectHashMap.this._states[i] == 1 && !tLongSet.contains(TLongObjectHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public int hashCode() {
            int length = TLongObjectHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TLongObjectHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TLongObjectHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            int length = TLongObjectHashMap.this._states.length;
            boolean z = true;
            while (true) {
                int i = length - 1;
                if (length > 0) {
                    if (TLongObjectHashMap.this._states[i] == 1) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(",");
                        }
                        sb.append(TLongObjectHashMap.this._set[i]);
                    }
                    length = i;
                } else {
                    return sb.toString();
                }
            }
        }

        class TLongHashIterator extends THashPrimitiveIterator implements TLongIterator {
            private final TLongHash _hash;

            public TLongHashIterator(TLongHash tLongHash) {
                super(tLongHash);
                this._hash = tLongHash;
            }

            @Override // gnu.trove.iterator.TLongIterator
            public long next() {
                moveToNextIndex();
                return this._hash._set[this._index];
            }
        }
    }

    protected class ValueView extends TLongObjectHashMap<V>.MapBackedView<V> {
        protected ValueView() {
            super();
        }

        @Override // gnu.trove.map.hash.TLongObjectHashMap.MapBackedView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new TLongObjectHashMap<V>.ValueView.TLongObjectValueHashIterator(TLongObjectHashMap.this) { // from class: gnu.trove.map.hash.TLongObjectHashMap.ValueView.1
                @Override // gnu.trove.map.hash.TLongObjectHashMap.ValueView.TLongObjectValueHashIterator
                protected V objectAtIndex(int i) {
                    return TLongObjectHashMap.this._values[i];
                }
            };
        }

        @Override // gnu.trove.map.hash.TLongObjectHashMap.MapBackedView
        public boolean containsElement(V v) {
            return TLongObjectHashMap.this.containsValue(v);
        }

        @Override // gnu.trove.map.hash.TLongObjectHashMap.MapBackedView
        public boolean removeElement(V v) {
            int i;
            V[] vArr = TLongObjectHashMap.this._values;
            byte[] bArr = TLongObjectHashMap.this._states;
            int length = vArr.length;
            while (true) {
                i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 1 || (v != vArr[i] && (vArr[i] == null || !vArr[i].equals(v)))) {
                    length = i;
                }
            }
            TLongObjectHashMap.this.removeAt(i);
            return true;
        }

        class TLongObjectValueHashIterator extends THashPrimitiveIterator implements Iterator<V> {
            protected final TLongObjectHashMap _map;

            public TLongObjectValueHashIterator(TLongObjectHashMap tLongObjectHashMap) {
                super(tLongObjectHashMap);
                this._map = tLongObjectHashMap;
            }

            protected V objectAtIndex(int i) {
                byte[] bArr = TLongObjectHashMap.this._states;
                V v = this._map._values[i];
                if (bArr[i] != 1) {
                    return null;
                }
                return v;
            }

            @Override // java.util.Iterator
            public V next() {
                moveToNextIndex();
                return this._map._values[this._index];
            }
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
            TLongObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TLongObjectHashMap.this.size();
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
            return TLongObjectHashMap.this.isEmpty();
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
    }

    class TLongObjectHashIterator<V> extends THashPrimitiveIterator implements TLongObjectIterator<V> {
        private final TLongObjectHashMap<V> _map;

        public TLongObjectHashIterator(TLongObjectHashMap<V> tLongObjectHashMap) {
            super(tLongObjectHashMap);
            this._map = tLongObjectHashMap;
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TLongObjectIterator
        public long key() {
            return this._map._set[this._index];
        }

        @Override // gnu.trove.iterator.TLongObjectIterator
        public V value() {
            return this._map._values[this._index];
        }

        @Override // gnu.trove.iterator.TLongObjectIterator
        public V setValue(V v) {
            V value = value();
            this._map._values[this._index] = v;
            return value;
        }
    }

    @Override // gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        super.writeExternal(objectOutput);
        objectOutput.writeLong(this.no_entry_key);
        objectOutput.writeInt(this._size);
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._states[i] == 1) {
                objectOutput.writeLong(this._set[i]);
                objectOutput.writeObject(this._values[i]);
            }
            length = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
        this.no_entry_key = objectInput.readLong();
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readLong(), objectInput.readObject());
            readInt = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TLongObjectProcedure<V>() { // from class: gnu.trove.map.hash.TLongObjectHashMap.2
            private boolean first = true;

            @Override // gnu.trove.procedure.TLongObjectProcedure
            public boolean execute(long j, Object obj) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(",");
                }
                sb.append(j);
                sb.append("=");
                sb.append(obj);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }
}