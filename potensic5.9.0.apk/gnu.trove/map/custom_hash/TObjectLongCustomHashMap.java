package gnu.trove.map.custom_hash;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TCustomObjectHash;
import gnu.trove.impl.hash.THash;
import gnu.trove.impl.hash.TObjectHash;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.iterator.TObjectLongIterator;
import gnu.trove.iterator.hash.TObjectHashIterator;
import gnu.trove.map.TObjectLongMap;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TObjectLongProcedure;
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
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TObjectLongCustomHashMap<K> extends TCustomObjectHash<K> implements TObjectLongMap<K>, Externalizable {
    static final long serialVersionUID = 1;
    private final TObjectLongProcedure<K> PUT_ALL_PROC;
    protected transient long[] _values;
    protected long no_entry_value;

    public TObjectLongCustomHashMap() {
        this.PUT_ALL_PROC = new TObjectLongProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectLongCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectLongProcedure
            public boolean execute(K k, long j) {
                TObjectLongCustomHashMap.this.put(k, j);
                return true;
            }
        };
    }

    public TObjectLongCustomHashMap(HashingStrategy<? super K> hashingStrategy) {
        super(hashingStrategy);
        this.PUT_ALL_PROC = new TObjectLongProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectLongCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectLongProcedure
            public boolean execute(K k, long j) {
                TObjectLongCustomHashMap.this.put(k, j);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_LONG_NO_ENTRY_VALUE;
    }

    public TObjectLongCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i) {
        super(hashingStrategy, i);
        this.PUT_ALL_PROC = new TObjectLongProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectLongCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectLongProcedure
            public boolean execute(K k, long j) {
                TObjectLongCustomHashMap.this.put(k, j);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_LONG_NO_ENTRY_VALUE;
    }

    public TObjectLongCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i, float f) {
        super(hashingStrategy, i, f);
        this.PUT_ALL_PROC = new TObjectLongProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectLongCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectLongProcedure
            public boolean execute(K k, long j) {
                TObjectLongCustomHashMap.this.put(k, j);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_LONG_NO_ENTRY_VALUE;
    }

    public TObjectLongCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i, float f, long j) {
        super(hashingStrategy, i, f);
        this.PUT_ALL_PROC = new TObjectLongProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectLongCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectLongProcedure
            public boolean execute(K k, long j2) {
                TObjectLongCustomHashMap.this.put(k, j2);
                return true;
            }
        };
        this.no_entry_value = j;
        if (j != 0) {
            Arrays.fill(this._values, j);
        }
    }

    public TObjectLongCustomHashMap(HashingStrategy<? super K> hashingStrategy, TObjectLongMap<? extends K> tObjectLongMap) {
        this(hashingStrategy, tObjectLongMap.size(), 0.5f, tObjectLongMap.getNoEntryValue());
        if (tObjectLongMap instanceof TObjectLongCustomHashMap) {
            TObjectLongCustomHashMap tObjectLongCustomHashMap = (TObjectLongCustomHashMap) tObjectLongMap;
            this._loadFactor = Math.abs(tObjectLongCustomHashMap._loadFactor);
            this.no_entry_value = tObjectLongCustomHashMap.no_entry_value;
            this.strategy = tObjectLongCustomHashMap.strategy;
            long j = this.no_entry_value;
            if (j != 0) {
                Arrays.fill(this._values, j);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tObjectLongMap);
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    public int setUp(int i) {
        int up = super.setUp(i);
        this._values = new long[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        Object[] objArr = this._set;
        long[] jArr = this._values;
        this._set = new Object[i];
        Arrays.fill(this._set, FREE);
        long[] jArr2 = new long[i];
        this._values = jArr2;
        Arrays.fill(jArr2, this.no_entry_value);
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            Object obj = objArr[i2];
            if (obj != FREE && obj != REMOVED) {
                int insertKey = insertKey(obj);
                if (insertKey < 0) {
                    throwObjectContractViolation(this._set[(-insertKey) - 1], obj);
                }
                this._values[insertKey] = jArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean containsKey(Object obj) {
        return contains(obj);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean containsValue(long j) {
        Object[] objArr = this._set;
        long[] jArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && j == jArr[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long get(Object obj) {
        int index = index(obj);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long put(K k, long j) {
        return doPut(j, insertKey(k));
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long putIfAbsent(K k, long j) {
        int insertKey = insertKey(k);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(j, insertKey);
    }

    private long doPut(long j, int i) {
        long j2 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            z = false;
            j2 = this._values[i];
        }
        this._values[i] = j;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return j2;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long remove(Object obj) {
        long j = this.no_entry_value;
        int index = index(obj);
        if (index < 0) {
            return j;
        }
        long j2 = this._values[index];
        removeAt(index);
        return j2;
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public void putAll(Map<? extends K, ? extends Long> map) {
        for (Map.Entry<? extends K, ? extends Long> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().longValue());
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public void putAll(TObjectLongMap<? extends K> tObjectLongMap) {
        tObjectLongMap.forEachEntry(this.PUT_ALL_PROC);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, FREE);
        long[] jArr = this._values;
        Arrays.fill(jArr, 0, jArr.length, this.no_entry_value);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public Set<K> keySet() {
        return new KeyView();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public Object[] keys() {
        Object[] objArr = new Object[size()];
        Object[] objArr2 = this._set;
        int length = objArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return objArr;
            }
            if (objArr2[i2] != FREE && objArr2[i2] != REMOVED) {
                objArr[i] = objArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public K[] keys(K[] kArr) {
        int size = size();
        if (kArr.length < size) {
            kArr = (K[]) ((Object[]) Array.newInstance(kArr.getClass().getComponentType(), size));
        }
        Object[] objArr = this._set;
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return kArr;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                kArr[i] = objArr[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public TLongCollection valueCollection() {
        return new TLongValueCollection();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long[] values() {
        long[] jArr = new long[size()];
        long[] jArr2 = this._values;
        Object[] objArr = this._set;
        int length = jArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return jArr;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                jArr[i] = jArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long[] values(long[] jArr) {
        int size = size();
        if (jArr.length < size) {
            jArr = new long[size];
        }
        long[] jArr2 = this._values;
        Object[] objArr = this._set;
        int length = jArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                jArr[i] = jArr2[i2];
                i++;
            }
            length = i2;
        }
        if (jArr.length > size) {
            jArr[size] = this.no_entry_value;
        }
        return jArr;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public TObjectLongIterator<K> iterator() {
        return new TObjectLongHashIterator(this);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean increment(K k) {
        return adjustValue(k, 1L);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean adjustValue(K k, long j) {
        int index = index(k);
        if (index < 0) {
            return false;
        }
        long[] jArr = this._values;
        jArr[index] = jArr[index] + j;
        return true;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long adjustOrPutValue(K k, long j, long j2) {
        int insertKey = insertKey(k);
        boolean z = true;
        if (insertKey < 0) {
            int i = (-insertKey) - 1;
            long[] jArr = this._values;
            long j3 = j + jArr[i];
            jArr[i] = j3;
            z = false;
            j2 = j3;
        } else {
            this._values[insertKey] = j2;
        }
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.map.TObjectLongMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return forEach(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        Object[] objArr = this._set;
        long[] jArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tLongProcedure.execute(jArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean forEachEntry(TObjectLongProcedure<? super K> tObjectLongProcedure) {
        Object[] objArr = this._set;
        long[] jArr = this._values;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectLongProcedure.execute(objArr[i], jArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean retainEntries(TObjectLongProcedure<? super K> tObjectLongProcedure) {
        Object[] objArr = this._set;
        long[] jArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectLongProcedure.execute(objArr[i], jArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public void transformValues(TLongFunction tLongFunction) {
        Object[] objArr = this._set;
        long[] jArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (objArr[i] != null && objArr[i] != REMOVED) {
                jArr[i] = tLongFunction.execute(jArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean equals(Object obj) {
        if (!(obj instanceof TObjectLongMap)) {
            return false;
        }
        TObjectLongMap tObjectLongMap = (TObjectLongMap) obj;
        if (tObjectLongMap.size() != size()) {
            return false;
        }
        try {
            TObjectLongIterator<K> it = iterator();
            while (it.hasNext()) {
                it.advance();
                K key = it.key();
                long value = it.value();
                if (value == this.no_entry_value) {
                    if (tObjectLongMap.get(key) != tObjectLongMap.getNoEntryValue() || !tObjectLongMap.containsKey(key)) {
                        return false;
                    }
                } else if (value != tObjectLongMap.get(key)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return true;
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public int hashCode() {
        Object[] objArr = this._set;
        long[] jArr = this._values;
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return i;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                i += HashFunctions.hash(jArr[i2]) ^ (objArr[i2] == null ? 0 : objArr[i2].hashCode());
            }
            length = i2;
        }
    }

    protected class KeyView extends TObjectLongCustomHashMap<K>.MapBackedView<K> {
        protected KeyView() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new TObjectHashIterator(TObjectLongCustomHashMap.this);
        }

        @Override // gnu.trove.map.custom_hash.TObjectLongCustomHashMap.MapBackedView
        public boolean removeElement(K k) {
            return TObjectLongCustomHashMap.this.no_entry_value != TObjectLongCustomHashMap.this.remove(k);
        }

        @Override // gnu.trove.map.custom_hash.TObjectLongCustomHashMap.MapBackedView
        public boolean containsElement(K k) {
            return TObjectLongCustomHashMap.this.contains(k);
        }
    }

    private abstract class MapBackedView<E> extends AbstractSet<E> implements Set<E>, Iterable<E> {
        public abstract boolean containsElement(E e);

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
            TObjectLongCustomHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectLongCustomHashMap.this.size();
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
            return TObjectLongCustomHashMap.this.isEmpty();
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

    class TLongValueCollection implements TLongCollection {
        TLongValueCollection() {
        }

        @Override // gnu.trove.TLongCollection
        public TLongIterator iterator() {
            return new TObjectLongValueHashIterator();
        }

        @Override // gnu.trove.TLongCollection
        public long getNoEntryValue() {
            return TObjectLongCustomHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TLongCollection
        public int size() {
            return TObjectLongCustomHashMap.this._size;
        }

        @Override // gnu.trove.TLongCollection
        public boolean isEmpty() {
            return TObjectLongCustomHashMap.this._size == 0;
        }

        @Override // gnu.trove.TLongCollection
        public boolean contains(long j) {
            return TObjectLongCustomHashMap.this.containsValue(j);
        }

        @Override // gnu.trove.TLongCollection
        public long[] toArray() {
            return TObjectLongCustomHashMap.this.values();
        }

        @Override // gnu.trove.TLongCollection
        public long[] toArray(long[] jArr) {
            return TObjectLongCustomHashMap.this.values(jArr);
        }

        @Override // gnu.trove.TLongCollection
        public boolean add(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TLongCollection
        public boolean remove(long j) {
            long[] jArr = TObjectLongCustomHashMap.this._values;
            Object[] objArr = TObjectLongCustomHashMap.this._set;
            int length = jArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && j == jArr[i]) {
                    TObjectLongCustomHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TLongCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Long) {
                    if (!TObjectLongCustomHashMap.this.containsValue(((Long) obj).longValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TLongCollection
        public boolean containsAll(TLongCollection tLongCollection) {
            TLongIterator it = tLongCollection.iterator();
            while (it.hasNext()) {
                if (!TObjectLongCustomHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TLongCollection
        public boolean containsAll(long[] jArr) {
            for (long j : jArr) {
                if (!TObjectLongCustomHashMap.this.containsValue(j)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TLongCollection
        public boolean addAll(Collection<? extends Long> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TLongCollection
        public boolean addAll(TLongCollection tLongCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TLongCollection
        public boolean addAll(long[] jArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TLongCollection
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

        @Override // gnu.trove.TLongCollection
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

        @Override // gnu.trove.TLongCollection
        public boolean retainAll(long[] jArr) {
            Arrays.sort(jArr);
            long[] jArr2 = TObjectLongCustomHashMap.this._values;
            Object[] objArr = TObjectLongCustomHashMap.this._set;
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && Arrays.binarySearch(jArr, jArr2[i]) < 0) {
                    TObjectLongCustomHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TLongCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Long) && remove(((Long) obj).longValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TLongCollection
        public boolean removeAll(TLongCollection tLongCollection) {
            if (this == tLongCollection) {
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

        @Override // gnu.trove.TLongCollection
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

        @Override // gnu.trove.TLongCollection
        public void clear() {
            TObjectLongCustomHashMap.this.clear();
        }

        @Override // gnu.trove.TLongCollection
        public boolean forEach(TLongProcedure tLongProcedure) {
            return TObjectLongCustomHashMap.this.forEachValue(tLongProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TObjectLongCustomHashMap.this.forEachValue(new TLongProcedure() { // from class: gnu.trove.map.custom_hash.TObjectLongCustomHashMap.TLongValueCollection.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TLongProcedure
                public boolean execute(long j) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(j);
                    return true;
                }
            });
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
            return sb.toString();
        }

        class TObjectLongValueHashIterator implements TLongIterator {
            protected int _expectedSize;
            protected THash _hash;
            protected int _index;

            TObjectLongValueHashIterator() {
                TObjectLongCustomHashMap tObjectLongCustomHashMap = TObjectLongCustomHashMap.this;
                this._hash = tObjectLongCustomHashMap;
                this._expectedSize = tObjectLongCustomHashMap.size();
                this._index = this._hash.capacity();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return nextIndex() >= 0;
            }

            @Override // gnu.trove.iterator.TLongIterator
            public long next() {
                moveToNextIndex();
                return TObjectLongCustomHashMap.this._values[this._index];
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                if (this._expectedSize != this._hash.size()) {
                    throw new ConcurrentModificationException();
                }
                try {
                    this._hash.tempDisableAutoCompaction();
                    TObjectLongCustomHashMap.this.removeAt(this._index);
                    this._hash.reenableAutoCompaction(false);
                    this._expectedSize--;
                } catch (Throwable th) {
                    this._hash.reenableAutoCompaction(false);
                    throw th;
                }
            }

            protected final void moveToNextIndex() {
                int nextIndex = nextIndex();
                this._index = nextIndex;
                if (nextIndex < 0) {
                    throw new NoSuchElementException();
                }
            }

            protected final int nextIndex() {
                int i;
                if (this._expectedSize != this._hash.size()) {
                    throw new ConcurrentModificationException();
                }
                Object[] objArr = TObjectLongCustomHashMap.this._set;
                int i2 = this._index;
                while (true) {
                    i = i2 - 1;
                    if (i2 <= 0 || !(objArr[i] == TCustomObjectHash.FREE || objArr[i] == TCustomObjectHash.REMOVED)) {
                        break;
                    }
                    i2 = i;
                }
                return i;
            }
        }
    }

    class TObjectLongHashIterator<K> extends TObjectHashIterator<K> implements TObjectLongIterator<K> {
        private final TObjectLongCustomHashMap<K> _map;

        public TObjectLongHashIterator(TObjectLongCustomHashMap<K> tObjectLongCustomHashMap) {
            super(tObjectLongCustomHashMap);
            this._map = tObjectLongCustomHashMap;
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TObjectLongIterator
        public K key() {
            return (K) this._map._set[this._index];
        }

        @Override // gnu.trove.iterator.TObjectLongIterator
        public long value() {
            return this._map._values[this._index];
        }

        @Override // gnu.trove.iterator.TObjectLongIterator
        public long setValue(long j) {
            long value = value();
            this._map._values[this._index] = j;
            return value;
        }
    }

    @Override // gnu.trove.impl.hash.TCustomObjectHash, gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        super.writeExternal(objectOutput);
        objectOutput.writeObject(this.strategy);
        objectOutput.writeLong(this.no_entry_value);
        objectOutput.writeInt(this._size);
        int length = this._set.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._set[i] != REMOVED && this._set[i] != FREE) {
                objectOutput.writeObject(this._set[i]);
                objectOutput.writeLong(this._values[i]);
            }
            length = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.impl.hash.TCustomObjectHash, gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
        this.strategy = (HashingStrategy) objectInput.readObject();
        this.no_entry_value = objectInput.readLong();
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readObject(), objectInput.readLong());
            readInt = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TObjectLongProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectLongCustomHashMap.2
            private boolean first = true;

            @Override // gnu.trove.procedure.TObjectLongProcedure
            public boolean execute(K k, long j) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(",");
                }
                sb.append(k).append("=").append(j);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }
}