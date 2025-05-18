package gnu.trove.map.custom_hash;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TCustomObjectHash;
import gnu.trove.impl.hash.THash;
import gnu.trove.impl.hash.TObjectHash;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.iterator.TObjectIntIterator;
import gnu.trove.iterator.hash.TObjectHashIterator;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TObjectIntProcedure;
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
public class TObjectIntCustomHashMap<K> extends TCustomObjectHash<K> implements TObjectIntMap<K>, Externalizable {
    static final long serialVersionUID = 1;
    private final TObjectIntProcedure<K> PUT_ALL_PROC;
    protected transient int[] _values;
    protected int no_entry_value;

    public TObjectIntCustomHashMap() {
        this.PUT_ALL_PROC = new TObjectIntProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectIntCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectIntProcedure
            public boolean execute(K k, int i) {
                TObjectIntCustomHashMap.this.put(k, i);
                return true;
            }
        };
    }

    public TObjectIntCustomHashMap(HashingStrategy<? super K> hashingStrategy) {
        super(hashingStrategy);
        this.PUT_ALL_PROC = new TObjectIntProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectIntCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectIntProcedure
            public boolean execute(K k, int i) {
                TObjectIntCustomHashMap.this.put(k, i);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_INT_NO_ENTRY_VALUE;
    }

    public TObjectIntCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i) {
        super(hashingStrategy, i);
        this.PUT_ALL_PROC = new TObjectIntProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectIntCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectIntProcedure
            public boolean execute(K k, int i2) {
                TObjectIntCustomHashMap.this.put(k, i2);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_INT_NO_ENTRY_VALUE;
    }

    public TObjectIntCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i, float f) {
        super(hashingStrategy, i, f);
        this.PUT_ALL_PROC = new TObjectIntProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectIntCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectIntProcedure
            public boolean execute(K k, int i2) {
                TObjectIntCustomHashMap.this.put(k, i2);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_INT_NO_ENTRY_VALUE;
    }

    public TObjectIntCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i, float f, int i2) {
        super(hashingStrategy, i, f);
        this.PUT_ALL_PROC = new TObjectIntProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectIntCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectIntProcedure
            public boolean execute(K k, int i22) {
                TObjectIntCustomHashMap.this.put(k, i22);
                return true;
            }
        };
        this.no_entry_value = i2;
        if (i2 != 0) {
            Arrays.fill(this._values, i2);
        }
    }

    public TObjectIntCustomHashMap(HashingStrategy<? super K> hashingStrategy, TObjectIntMap<? extends K> tObjectIntMap) {
        this(hashingStrategy, tObjectIntMap.size(), 0.5f, tObjectIntMap.getNoEntryValue());
        if (tObjectIntMap instanceof TObjectIntCustomHashMap) {
            TObjectIntCustomHashMap tObjectIntCustomHashMap = (TObjectIntCustomHashMap) tObjectIntMap;
            this._loadFactor = Math.abs(tObjectIntCustomHashMap._loadFactor);
            this.no_entry_value = tObjectIntCustomHashMap.no_entry_value;
            this.strategy = tObjectIntCustomHashMap.strategy;
            int i = this.no_entry_value;
            if (i != 0) {
                Arrays.fill(this._values, i);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tObjectIntMap);
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    public int setUp(int i) {
        int up = super.setUp(i);
        this._values = new int[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        Object[] objArr = this._set;
        int[] iArr = this._values;
        this._set = new Object[i];
        Arrays.fill(this._set, FREE);
        int[] iArr2 = new int[i];
        this._values = iArr2;
        Arrays.fill(iArr2, this.no_entry_value);
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
                this._values[insertKey] = iArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean containsKey(Object obj) {
        return contains(obj);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean containsValue(int i) {
        Object[] objArr = this._set;
        int[] iArr = this._values;
        int length = iArr.length;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return false;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED && i == iArr[i2]) {
                return true;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int get(Object obj) {
        int index = index(obj);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int put(K k, int i) {
        return doPut(i, insertKey(k));
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int putIfAbsent(K k, int i) {
        int insertKey = insertKey(k);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(i, insertKey);
    }

    private int doPut(int i, int i2) {
        int i3 = this.no_entry_value;
        boolean z = true;
        if (i2 < 0) {
            i2 = (-i2) - 1;
            i3 = this._values[i2];
            z = false;
        }
        this._values[i2] = i;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return i3;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int remove(Object obj) {
        int i = this.no_entry_value;
        int index = index(obj);
        if (index < 0) {
            return i;
        }
        int i2 = this._values[index];
        removeAt(index);
        return i2;
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void putAll(Map<? extends K, ? extends Integer> map) {
        for (Map.Entry<? extends K, ? extends Integer> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().intValue());
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void putAll(TObjectIntMap<? extends K> tObjectIntMap) {
        tObjectIntMap.forEachEntry(this.PUT_ALL_PROC);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, FREE);
        int[] iArr = this._values;
        Arrays.fill(iArr, 0, iArr.length, this.no_entry_value);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public Set<K> keySet() {
        return new KeyView();
    }

    @Override // gnu.trove.map.TObjectIntMap
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

    @Override // gnu.trove.map.TObjectIntMap
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

    @Override // gnu.trove.map.TObjectIntMap
    public TIntCollection valueCollection() {
        return new TIntValueCollection();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int[] values() {
        int[] iArr = new int[size()];
        int[] iArr2 = this._values;
        Object[] objArr = this._set;
        int length = iArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return iArr;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                iArr[i] = iArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int[] values(int[] iArr) {
        int size = size();
        if (iArr.length < size) {
            iArr = new int[size];
        }
        int[] iArr2 = this._values;
        Object[] objArr = this._set;
        int length = iArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                iArr[i] = iArr2[i2];
                i++;
            }
            length = i2;
        }
        if (iArr.length > size) {
            iArr[size] = this.no_entry_value;
        }
        return iArr;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public TObjectIntIterator<K> iterator() {
        return new TObjectIntHashIterator(this);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean increment(K k) {
        return adjustValue(k, 1);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean adjustValue(K k, int i) {
        int index = index(k);
        if (index < 0) {
            return false;
        }
        int[] iArr = this._values;
        iArr[index] = iArr[index] + i;
        return true;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int adjustOrPutValue(K k, int i, int i2) {
        int insertKey = insertKey(k);
        boolean z = true;
        if (insertKey < 0) {
            int i3 = (-insertKey) - 1;
            int[] iArr = this._values;
            int i4 = i + iArr[i3];
            iArr[i3] = i4;
            z = false;
            i2 = i4;
        } else {
            this._values[insertKey] = i2;
        }
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.map.TObjectIntMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return forEach(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        Object[] objArr = this._set;
        int[] iArr = this._values;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tIntProcedure.execute(iArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean forEachEntry(TObjectIntProcedure<? super K> tObjectIntProcedure) {
        Object[] objArr = this._set;
        int[] iArr = this._values;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectIntProcedure.execute(objArr[i], iArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean retainEntries(TObjectIntProcedure<? super K> tObjectIntProcedure) {
        Object[] objArr = this._set;
        int[] iArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectIntProcedure.execute(objArr[i], iArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void transformValues(TIntFunction tIntFunction) {
        Object[] objArr = this._set;
        int[] iArr = this._values;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (objArr[i] != null && objArr[i] != REMOVED) {
                iArr[i] = tIntFunction.execute(iArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean equals(Object obj) {
        if (!(obj instanceof TObjectIntMap)) {
            return false;
        }
        TObjectIntMap tObjectIntMap = (TObjectIntMap) obj;
        if (tObjectIntMap.size() != size()) {
            return false;
        }
        try {
            TObjectIntIterator<K> it = iterator();
            while (it.hasNext()) {
                it.advance();
                K key = it.key();
                int value = it.value();
                if (value == this.no_entry_value) {
                    if (tObjectIntMap.get(key) != tObjectIntMap.getNoEntryValue() || !tObjectIntMap.containsKey(key)) {
                        return false;
                    }
                } else if (value != tObjectIntMap.get(key)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return true;
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int hashCode() {
        Object[] objArr = this._set;
        int[] iArr = this._values;
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return i;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                i += HashFunctions.hash(iArr[i2]) ^ (objArr[i2] == null ? 0 : objArr[i2].hashCode());
            }
            length = i2;
        }
    }

    protected class KeyView extends TObjectIntCustomHashMap<K>.MapBackedView<K> {
        protected KeyView() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new TObjectHashIterator(TObjectIntCustomHashMap.this);
        }

        @Override // gnu.trove.map.custom_hash.TObjectIntCustomHashMap.MapBackedView
        public boolean removeElement(K k) {
            return TObjectIntCustomHashMap.this.no_entry_value != TObjectIntCustomHashMap.this.remove(k);
        }

        @Override // gnu.trove.map.custom_hash.TObjectIntCustomHashMap.MapBackedView
        public boolean containsElement(K k) {
            return TObjectIntCustomHashMap.this.contains(k);
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
            TObjectIntCustomHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectIntCustomHashMap.this.size();
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
            return TObjectIntCustomHashMap.this.isEmpty();
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

    class TIntValueCollection implements TIntCollection {
        TIntValueCollection() {
        }

        @Override // gnu.trove.TIntCollection
        public TIntIterator iterator() {
            return new TObjectIntValueHashIterator();
        }

        @Override // gnu.trove.TIntCollection
        public int getNoEntryValue() {
            return TObjectIntCustomHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TIntCollection
        public int size() {
            return TObjectIntCustomHashMap.this._size;
        }

        @Override // gnu.trove.TIntCollection
        public boolean isEmpty() {
            return TObjectIntCustomHashMap.this._size == 0;
        }

        @Override // gnu.trove.TIntCollection
        public boolean contains(int i) {
            return TObjectIntCustomHashMap.this.containsValue(i);
        }

        @Override // gnu.trove.TIntCollection
        public int[] toArray() {
            return TObjectIntCustomHashMap.this.values();
        }

        @Override // gnu.trove.TIntCollection
        public int[] toArray(int[] iArr) {
            return TObjectIntCustomHashMap.this.values(iArr);
        }

        @Override // gnu.trove.TIntCollection
        public boolean add(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TIntCollection
        public boolean remove(int i) {
            int[] iArr = TObjectIntCustomHashMap.this._values;
            Object[] objArr = TObjectIntCustomHashMap.this._set;
            int length = iArr.length;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (objArr[i2] != TObjectHash.FREE && objArr[i2] != TObjectHash.REMOVED && i == iArr[i2]) {
                    TObjectIntCustomHashMap.this.removeAt(i2);
                    return true;
                }
                length = i2;
            }
        }

        @Override // gnu.trove.TIntCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Integer) {
                    if (!TObjectIntCustomHashMap.this.containsValue(((Integer) obj).intValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TIntCollection
        public boolean containsAll(TIntCollection tIntCollection) {
            TIntIterator it = tIntCollection.iterator();
            while (it.hasNext()) {
                if (!TObjectIntCustomHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TIntCollection
        public boolean containsAll(int[] iArr) {
            for (int i : iArr) {
                if (!TObjectIntCustomHashMap.this.containsValue(i)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TIntCollection
        public boolean addAll(Collection<? extends Integer> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TIntCollection
        public boolean addAll(TIntCollection tIntCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TIntCollection
        public boolean addAll(int[] iArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TIntCollection
        public boolean retainAll(Collection<?> collection) {
            TIntIterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Integer.valueOf(it.next()))) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TIntCollection
        public boolean retainAll(TIntCollection tIntCollection) {
            boolean z = false;
            if (this == tIntCollection) {
                return false;
            }
            TIntIterator it = iterator();
            while (it.hasNext()) {
                if (!tIntCollection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TIntCollection
        public boolean retainAll(int[] iArr) {
            Arrays.sort(iArr);
            int[] iArr2 = TObjectIntCustomHashMap.this._values;
            Object[] objArr = TObjectIntCustomHashMap.this._set;
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && Arrays.binarySearch(iArr, iArr2[i]) < 0) {
                    TObjectIntCustomHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TIntCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Integer) && remove(((Integer) obj).intValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TIntCollection
        public boolean removeAll(TIntCollection tIntCollection) {
            if (this == tIntCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TIntIterator it = tIntCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TIntCollection
        public boolean removeAll(int[] iArr) {
            int length = iArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (remove(iArr[i])) {
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TIntCollection
        public void clear() {
            TObjectIntCustomHashMap.this.clear();
        }

        @Override // gnu.trove.TIntCollection
        public boolean forEach(TIntProcedure tIntProcedure) {
            return TObjectIntCustomHashMap.this.forEachValue(tIntProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TObjectIntCustomHashMap.this.forEachValue(new TIntProcedure() { // from class: gnu.trove.map.custom_hash.TObjectIntCustomHashMap.TIntValueCollection.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TIntProcedure
                public boolean execute(int i) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                    return true;
                }
            });
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
            return sb.toString();
        }

        class TObjectIntValueHashIterator implements TIntIterator {
            protected int _expectedSize;
            protected THash _hash;
            protected int _index;

            TObjectIntValueHashIterator() {
                TObjectIntCustomHashMap tObjectIntCustomHashMap = TObjectIntCustomHashMap.this;
                this._hash = tObjectIntCustomHashMap;
                this._expectedSize = tObjectIntCustomHashMap.size();
                this._index = this._hash.capacity();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return nextIndex() >= 0;
            }

            @Override // gnu.trove.iterator.TIntIterator
            public int next() {
                moveToNextIndex();
                return TObjectIntCustomHashMap.this._values[this._index];
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                if (this._expectedSize != this._hash.size()) {
                    throw new ConcurrentModificationException();
                }
                try {
                    this._hash.tempDisableAutoCompaction();
                    TObjectIntCustomHashMap.this.removeAt(this._index);
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
                Object[] objArr = TObjectIntCustomHashMap.this._set;
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

    class TObjectIntHashIterator<K> extends TObjectHashIterator<K> implements TObjectIntIterator<K> {
        private final TObjectIntCustomHashMap<K> _map;

        public TObjectIntHashIterator(TObjectIntCustomHashMap<K> tObjectIntCustomHashMap) {
            super(tObjectIntCustomHashMap);
            this._map = tObjectIntCustomHashMap;
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TObjectIntIterator
        public K key() {
            return (K) this._map._set[this._index];
        }

        @Override // gnu.trove.iterator.TObjectIntIterator
        public int value() {
            return this._map._values[this._index];
        }

        @Override // gnu.trove.iterator.TObjectIntIterator
        public int setValue(int i) {
            int value = value();
            this._map._values[this._index] = i;
            return value;
        }
    }

    @Override // gnu.trove.impl.hash.TCustomObjectHash, gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        super.writeExternal(objectOutput);
        objectOutput.writeObject(this.strategy);
        objectOutput.writeInt(this.no_entry_value);
        objectOutput.writeInt(this._size);
        int length = this._set.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._set[i] != REMOVED && this._set[i] != FREE) {
                objectOutput.writeObject(this._set[i]);
                objectOutput.writeInt(this._values[i]);
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
        this.no_entry_value = objectInput.readInt();
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readObject(), objectInput.readInt());
            readInt = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TObjectIntProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectIntCustomHashMap.2
            private boolean first = true;

            @Override // gnu.trove.procedure.TObjectIntProcedure
            public boolean execute(K k, int i) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(",");
                }
                sb.append(k).append("=").append(i);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }
}