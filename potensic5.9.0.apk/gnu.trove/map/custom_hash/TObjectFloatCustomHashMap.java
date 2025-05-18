package gnu.trove.map.custom_hash;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TCustomObjectHash;
import gnu.trove.impl.hash.THash;
import gnu.trove.impl.hash.TObjectHash;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.iterator.TObjectFloatIterator;
import gnu.trove.iterator.hash.TObjectHashIterator;
import gnu.trove.map.TObjectFloatMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TObjectFloatProcedure;
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
public class TObjectFloatCustomHashMap<K> extends TCustomObjectHash<K> implements TObjectFloatMap<K>, Externalizable {
    static final long serialVersionUID = 1;
    private final TObjectFloatProcedure<K> PUT_ALL_PROC;
    protected transient float[] _values;
    protected float no_entry_value;

    public TObjectFloatCustomHashMap() {
        this.PUT_ALL_PROC = new TObjectFloatProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectFloatCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectFloatProcedure
            public boolean execute(K k, float f) {
                TObjectFloatCustomHashMap.this.put(k, f);
                return true;
            }
        };
    }

    public TObjectFloatCustomHashMap(HashingStrategy<? super K> hashingStrategy) {
        super(hashingStrategy);
        this.PUT_ALL_PROC = new TObjectFloatProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectFloatCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectFloatProcedure
            public boolean execute(K k, float f) {
                TObjectFloatCustomHashMap.this.put(k, f);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_FLOAT_NO_ENTRY_VALUE;
    }

    public TObjectFloatCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i) {
        super(hashingStrategy, i);
        this.PUT_ALL_PROC = new TObjectFloatProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectFloatCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectFloatProcedure
            public boolean execute(K k, float f) {
                TObjectFloatCustomHashMap.this.put(k, f);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_FLOAT_NO_ENTRY_VALUE;
    }

    public TObjectFloatCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i, float f) {
        super(hashingStrategy, i, f);
        this.PUT_ALL_PROC = new TObjectFloatProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectFloatCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectFloatProcedure
            public boolean execute(K k, float f2) {
                TObjectFloatCustomHashMap.this.put(k, f2);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_FLOAT_NO_ENTRY_VALUE;
    }

    public TObjectFloatCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i, float f, float f2) {
        super(hashingStrategy, i, f);
        this.PUT_ALL_PROC = new TObjectFloatProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectFloatCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectFloatProcedure
            public boolean execute(K k, float f22) {
                TObjectFloatCustomHashMap.this.put(k, f22);
                return true;
            }
        };
        this.no_entry_value = f2;
        if (f2 != 0.0f) {
            Arrays.fill(this._values, f2);
        }
    }

    public TObjectFloatCustomHashMap(HashingStrategy<? super K> hashingStrategy, TObjectFloatMap<? extends K> tObjectFloatMap) {
        this(hashingStrategy, tObjectFloatMap.size(), 0.5f, tObjectFloatMap.getNoEntryValue());
        if (tObjectFloatMap instanceof TObjectFloatCustomHashMap) {
            TObjectFloatCustomHashMap tObjectFloatCustomHashMap = (TObjectFloatCustomHashMap) tObjectFloatMap;
            this._loadFactor = Math.abs(tObjectFloatCustomHashMap._loadFactor);
            this.no_entry_value = tObjectFloatCustomHashMap.no_entry_value;
            this.strategy = tObjectFloatCustomHashMap.strategy;
            float f = this.no_entry_value;
            if (f != 0.0f) {
                Arrays.fill(this._values, f);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tObjectFloatMap);
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    public int setUp(int i) {
        int up = super.setUp(i);
        this._values = new float[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        Object[] objArr = this._set;
        float[] fArr = this._values;
        this._set = new Object[i];
        Arrays.fill(this._set, FREE);
        float[] fArr2 = new float[i];
        this._values = fArr2;
        Arrays.fill(fArr2, this.no_entry_value);
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
                this._values[insertKey] = fArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean containsKey(Object obj) {
        return contains(obj);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean containsValue(float f) {
        Object[] objArr = this._set;
        float[] fArr = this._values;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && f == fArr[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float get(Object obj) {
        int index = index(obj);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float put(K k, float f) {
        return doPut(f, insertKey(k));
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float putIfAbsent(K k, float f) {
        int insertKey = insertKey(k);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(f, insertKey);
    }

    private float doPut(float f, int i) {
        float f2 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            f2 = this._values[i];
            z = false;
        }
        this._values[i] = f;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return f2;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float remove(Object obj) {
        float f = this.no_entry_value;
        int index = index(obj);
        if (index < 0) {
            return f;
        }
        float f2 = this._values[index];
        removeAt(index);
        return f2;
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public void putAll(Map<? extends K, ? extends Float> map) {
        for (Map.Entry<? extends K, ? extends Float> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().floatValue());
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public void putAll(TObjectFloatMap<? extends K> tObjectFloatMap) {
        tObjectFloatMap.forEachEntry(this.PUT_ALL_PROC);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, FREE);
        float[] fArr = this._values;
        Arrays.fill(fArr, 0, fArr.length, this.no_entry_value);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public Set<K> keySet() {
        return new KeyView();
    }

    @Override // gnu.trove.map.TObjectFloatMap
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

    @Override // gnu.trove.map.TObjectFloatMap
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

    @Override // gnu.trove.map.TObjectFloatMap
    public TFloatCollection valueCollection() {
        return new TFloatValueCollection();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float[] values() {
        float[] fArr = new float[size()];
        float[] fArr2 = this._values;
        Object[] objArr = this._set;
        int length = fArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return fArr;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                fArr[i] = fArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float[] values(float[] fArr) {
        int size = size();
        if (fArr.length < size) {
            fArr = new float[size];
        }
        float[] fArr2 = this._values;
        Object[] objArr = this._set;
        int length = fArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                fArr[i] = fArr2[i2];
                i++;
            }
            length = i2;
        }
        if (fArr.length > size) {
            fArr[size] = this.no_entry_value;
        }
        return fArr;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public TObjectFloatIterator<K> iterator() {
        return new TObjectFloatHashIterator(this);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean increment(K k) {
        return adjustValue(k, 1.0f);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean adjustValue(K k, float f) {
        int index = index(k);
        if (index < 0) {
            return false;
        }
        float[] fArr = this._values;
        fArr[index] = fArr[index] + f;
        return true;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float adjustOrPutValue(K k, float f, float f2) {
        int insertKey = insertKey(k);
        boolean z = true;
        if (insertKey < 0) {
            int i = (-insertKey) - 1;
            float[] fArr = this._values;
            float f3 = f + fArr[i];
            fArr[i] = f3;
            z = false;
            f2 = f3;
        } else {
            this._values[insertKey] = f2;
        }
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.map.TObjectFloatMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return forEach(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        Object[] objArr = this._set;
        float[] fArr = this._values;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tFloatProcedure.execute(fArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean forEachEntry(TObjectFloatProcedure<? super K> tObjectFloatProcedure) {
        Object[] objArr = this._set;
        float[] fArr = this._values;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectFloatProcedure.execute(objArr[i], fArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean retainEntries(TObjectFloatProcedure<? super K> tObjectFloatProcedure) {
        Object[] objArr = this._set;
        float[] fArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectFloatProcedure.execute(objArr[i], fArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        Object[] objArr = this._set;
        float[] fArr = this._values;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (objArr[i] != null && objArr[i] != REMOVED) {
                fArr[i] = tFloatFunction.execute(fArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean equals(Object obj) {
        if (!(obj instanceof TObjectFloatMap)) {
            return false;
        }
        TObjectFloatMap tObjectFloatMap = (TObjectFloatMap) obj;
        if (tObjectFloatMap.size() != size()) {
            return false;
        }
        try {
            TObjectFloatIterator<K> it = iterator();
            while (it.hasNext()) {
                it.advance();
                K key = it.key();
                float value = it.value();
                if (value == this.no_entry_value) {
                    if (tObjectFloatMap.get(key) != tObjectFloatMap.getNoEntryValue() || !tObjectFloatMap.containsKey(key)) {
                        return false;
                    }
                } else if (value != tObjectFloatMap.get(key)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return true;
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public int hashCode() {
        Object[] objArr = this._set;
        float[] fArr = this._values;
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return i;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                i += HashFunctions.hash(fArr[i2]) ^ (objArr[i2] == null ? 0 : objArr[i2].hashCode());
            }
            length = i2;
        }
    }

    protected class KeyView extends TObjectFloatCustomHashMap<K>.MapBackedView<K> {
        protected KeyView() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new TObjectHashIterator(TObjectFloatCustomHashMap.this);
        }

        @Override // gnu.trove.map.custom_hash.TObjectFloatCustomHashMap.MapBackedView
        public boolean removeElement(K k) {
            return TObjectFloatCustomHashMap.this.no_entry_value != TObjectFloatCustomHashMap.this.remove(k);
        }

        @Override // gnu.trove.map.custom_hash.TObjectFloatCustomHashMap.MapBackedView
        public boolean containsElement(K k) {
            return TObjectFloatCustomHashMap.this.contains(k);
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
            TObjectFloatCustomHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectFloatCustomHashMap.this.size();
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
            return TObjectFloatCustomHashMap.this.isEmpty();
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

    class TFloatValueCollection implements TFloatCollection {
        TFloatValueCollection() {
        }

        @Override // gnu.trove.TFloatCollection
        public TFloatIterator iterator() {
            return new TObjectFloatValueHashIterator();
        }

        @Override // gnu.trove.TFloatCollection
        public float getNoEntryValue() {
            return TObjectFloatCustomHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TFloatCollection
        public int size() {
            return TObjectFloatCustomHashMap.this._size;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean isEmpty() {
            return TObjectFloatCustomHashMap.this._size == 0;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean contains(float f) {
            return TObjectFloatCustomHashMap.this.containsValue(f);
        }

        @Override // gnu.trove.TFloatCollection
        public float[] toArray() {
            return TObjectFloatCustomHashMap.this.values();
        }

        @Override // gnu.trove.TFloatCollection
        public float[] toArray(float[] fArr) {
            return TObjectFloatCustomHashMap.this.values(fArr);
        }

        @Override // gnu.trove.TFloatCollection
        public boolean add(float f) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean remove(float f) {
            float[] fArr = TObjectFloatCustomHashMap.this._values;
            Object[] objArr = TObjectFloatCustomHashMap.this._set;
            int length = fArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && f == fArr[i]) {
                    TObjectFloatCustomHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Float) {
                    if (!TObjectFloatCustomHashMap.this.containsValue(((Float) obj).floatValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(TFloatCollection tFloatCollection) {
            TFloatIterator it = tFloatCollection.iterator();
            while (it.hasNext()) {
                if (!TObjectFloatCustomHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(float[] fArr) {
            for (float f : fArr) {
                if (!TObjectFloatCustomHashMap.this.containsValue(f)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean addAll(Collection<? extends Float> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean addAll(TFloatCollection tFloatCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean addAll(float[] fArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean retainAll(Collection<?> collection) {
            TFloatIterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Float.valueOf(it.next()))) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean retainAll(TFloatCollection tFloatCollection) {
            boolean z = false;
            if (this == tFloatCollection) {
                return false;
            }
            TFloatIterator it = iterator();
            while (it.hasNext()) {
                if (!tFloatCollection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean retainAll(float[] fArr) {
            Arrays.sort(fArr);
            float[] fArr2 = TObjectFloatCustomHashMap.this._values;
            Object[] objArr = TObjectFloatCustomHashMap.this._set;
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && Arrays.binarySearch(fArr, fArr2[i]) < 0) {
                    TObjectFloatCustomHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TFloatCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Float) && remove(((Float) obj).floatValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean removeAll(TFloatCollection tFloatCollection) {
            if (this == tFloatCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TFloatIterator it = tFloatCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean removeAll(float[] fArr) {
            int length = fArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (remove(fArr[i])) {
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TFloatCollection
        public void clear() {
            TObjectFloatCustomHashMap.this.clear();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean forEach(TFloatProcedure tFloatProcedure) {
            return TObjectFloatCustomHashMap.this.forEachValue(tFloatProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TObjectFloatCustomHashMap.this.forEachValue(new TFloatProcedure() { // from class: gnu.trove.map.custom_hash.TObjectFloatCustomHashMap.TFloatValueCollection.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TFloatProcedure
                public boolean execute(float f) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(f);
                    return true;
                }
            });
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
            return sb.toString();
        }

        class TObjectFloatValueHashIterator implements TFloatIterator {
            protected int _expectedSize;
            protected THash _hash;
            protected int _index;

            TObjectFloatValueHashIterator() {
                TObjectFloatCustomHashMap tObjectFloatCustomHashMap = TObjectFloatCustomHashMap.this;
                this._hash = tObjectFloatCustomHashMap;
                this._expectedSize = tObjectFloatCustomHashMap.size();
                this._index = this._hash.capacity();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return nextIndex() >= 0;
            }

            @Override // gnu.trove.iterator.TFloatIterator
            public float next() {
                moveToNextIndex();
                return TObjectFloatCustomHashMap.this._values[this._index];
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                if (this._expectedSize != this._hash.size()) {
                    throw new ConcurrentModificationException();
                }
                try {
                    this._hash.tempDisableAutoCompaction();
                    TObjectFloatCustomHashMap.this.removeAt(this._index);
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
                Object[] objArr = TObjectFloatCustomHashMap.this._set;
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

    class TObjectFloatHashIterator<K> extends TObjectHashIterator<K> implements TObjectFloatIterator<K> {
        private final TObjectFloatCustomHashMap<K> _map;

        public TObjectFloatHashIterator(TObjectFloatCustomHashMap<K> tObjectFloatCustomHashMap) {
            super(tObjectFloatCustomHashMap);
            this._map = tObjectFloatCustomHashMap;
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TObjectFloatIterator
        public K key() {
            return (K) this._map._set[this._index];
        }

        @Override // gnu.trove.iterator.TObjectFloatIterator
        public float value() {
            return this._map._values[this._index];
        }

        @Override // gnu.trove.iterator.TObjectFloatIterator
        public float setValue(float f) {
            float value = value();
            this._map._values[this._index] = f;
            return value;
        }
    }

    @Override // gnu.trove.impl.hash.TCustomObjectHash, gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        super.writeExternal(objectOutput);
        objectOutput.writeObject(this.strategy);
        objectOutput.writeFloat(this.no_entry_value);
        objectOutput.writeInt(this._size);
        int length = this._set.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._set[i] != REMOVED && this._set[i] != FREE) {
                objectOutput.writeObject(this._set[i]);
                objectOutput.writeFloat(this._values[i]);
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
        this.no_entry_value = objectInput.readFloat();
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readObject(), objectInput.readFloat());
            readInt = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TObjectFloatProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectFloatCustomHashMap.2
            private boolean first = true;

            @Override // gnu.trove.procedure.TObjectFloatProcedure
            public boolean execute(K k, float f) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(",");
                }
                sb.append(k).append("=").append(f);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }
}