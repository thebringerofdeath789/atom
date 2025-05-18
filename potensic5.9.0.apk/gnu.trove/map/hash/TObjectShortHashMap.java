package gnu.trove.map.hash;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THash;
import gnu.trove.impl.hash.TObjectHash;
import gnu.trove.iterator.TObjectShortIterator;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.iterator.hash.TObjectHashIterator;
import gnu.trove.map.TObjectShortMap;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.procedure.TObjectShortProcedure;
import gnu.trove.procedure.TShortProcedure;
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
public class TObjectShortHashMap<K> extends TObjectHash<K> implements TObjectShortMap<K>, Externalizable {
    static final long serialVersionUID = 1;
    private final TObjectShortProcedure<K> PUT_ALL_PROC;
    protected transient short[] _values;
    protected short no_entry_value;

    public TObjectShortHashMap() {
        this.PUT_ALL_PROC = new TObjectShortProcedure<K>() { // from class: gnu.trove.map.hash.TObjectShortHashMap.1
            @Override // gnu.trove.procedure.TObjectShortProcedure
            public boolean execute(K k, short s) {
                TObjectShortHashMap.this.put(k, s);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_SHORT_NO_ENTRY_VALUE;
    }

    public TObjectShortHashMap(int i) {
        super(i);
        this.PUT_ALL_PROC = new TObjectShortProcedure<K>() { // from class: gnu.trove.map.hash.TObjectShortHashMap.1
            @Override // gnu.trove.procedure.TObjectShortProcedure
            public boolean execute(K k, short s) {
                TObjectShortHashMap.this.put(k, s);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_SHORT_NO_ENTRY_VALUE;
    }

    public TObjectShortHashMap(int i, float f) {
        super(i, f);
        this.PUT_ALL_PROC = new TObjectShortProcedure<K>() { // from class: gnu.trove.map.hash.TObjectShortHashMap.1
            @Override // gnu.trove.procedure.TObjectShortProcedure
            public boolean execute(K k, short s) {
                TObjectShortHashMap.this.put(k, s);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_SHORT_NO_ENTRY_VALUE;
    }

    public TObjectShortHashMap(int i, float f, short s) {
        super(i, f);
        this.PUT_ALL_PROC = new TObjectShortProcedure<K>() { // from class: gnu.trove.map.hash.TObjectShortHashMap.1
            @Override // gnu.trove.procedure.TObjectShortProcedure
            public boolean execute(K k, short s2) {
                TObjectShortHashMap.this.put(k, s2);
                return true;
            }
        };
        this.no_entry_value = s;
        if (s != 0) {
            Arrays.fill(this._values, s);
        }
    }

    public TObjectShortHashMap(TObjectShortMap<? extends K> tObjectShortMap) {
        this(tObjectShortMap.size(), 0.5f, tObjectShortMap.getNoEntryValue());
        if (tObjectShortMap instanceof TObjectShortHashMap) {
            TObjectShortHashMap tObjectShortHashMap = (TObjectShortHashMap) tObjectShortMap;
            this._loadFactor = Math.abs(tObjectShortHashMap._loadFactor);
            short s = tObjectShortHashMap.no_entry_value;
            this.no_entry_value = s;
            if (s != 0) {
                Arrays.fill(this._values, s);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tObjectShortMap);
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    public int setUp(int i) {
        int up = super.setUp(i);
        this._values = new short[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        Object[] objArr = this._set;
        short[] sArr = this._values;
        this._set = new Object[i];
        Arrays.fill(this._set, FREE);
        short[] sArr2 = new short[i];
        this._values = sArr2;
        Arrays.fill(sArr2, this.no_entry_value);
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                Object obj = objArr[i2];
                int insertKey = insertKey(obj);
                if (insertKey < 0) {
                    throwObjectContractViolation(this._set[(-insertKey) - 1], obj);
                }
                this._set[insertKey] = obj;
                this._values[insertKey] = sArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean containsKey(Object obj) {
        return contains(obj);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean containsValue(short s) {
        Object[] objArr = this._set;
        short[] sArr = this._values;
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && s == sArr[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short get(Object obj) {
        int index = index(obj);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short put(K k, short s) {
        return doPut(s, insertKey(k));
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short putIfAbsent(K k, short s) {
        int insertKey = insertKey(k);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(s, insertKey);
    }

    private short doPut(short s, int i) {
        short s2 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            s2 = this._values[i];
            z = false;
        }
        this._values[i] = s;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return s2;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short remove(Object obj) {
        short s = this.no_entry_value;
        int index = index(obj);
        if (index < 0) {
            return s;
        }
        short s2 = this._values[index];
        removeAt(index);
        return s2;
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public void putAll(Map<? extends K, ? extends Short> map) {
        for (Map.Entry<? extends K, ? extends Short> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().shortValue());
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public void putAll(TObjectShortMap<? extends K> tObjectShortMap) {
        tObjectShortMap.forEachEntry(this.PUT_ALL_PROC);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, FREE);
        short[] sArr = this._values;
        Arrays.fill(sArr, 0, sArr.length, this.no_entry_value);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public Set<K> keySet() {
        return new KeyView();
    }

    @Override // gnu.trove.map.TObjectShortMap
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

    @Override // gnu.trove.map.TObjectShortMap
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

    @Override // gnu.trove.map.TObjectShortMap
    public TShortCollection valueCollection() {
        return new TShortValueCollection();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short[] values() {
        short[] sArr = new short[size()];
        short[] sArr2 = this._values;
        Object[] objArr = this._set;
        int length = sArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return sArr;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                sArr[i] = sArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short[] values(short[] sArr) {
        int size = size();
        if (sArr.length < size) {
            sArr = new short[size];
        }
        short[] sArr2 = this._values;
        Object[] objArr = this._set;
        int length = sArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                sArr[i] = sArr2[i2];
                i++;
            }
            length = i2;
        }
        if (sArr.length > size) {
            sArr[size] = this.no_entry_value;
        }
        return sArr;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public TObjectShortIterator<K> iterator() {
        return new TObjectShortHashIterator(this);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean increment(K k) {
        return adjustValue(k, (short) 1);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean adjustValue(K k, short s) {
        int index = index(k);
        if (index < 0) {
            return false;
        }
        short[] sArr = this._values;
        sArr[index] = (short) (sArr[index] + s);
        return true;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short adjustOrPutValue(K k, short s, short s2) {
        int insertKey = insertKey(k);
        boolean z = true;
        if (insertKey < 0) {
            int i = (-insertKey) - 1;
            short[] sArr = this._values;
            short s3 = (short) (sArr[i] + s);
            sArr[i] = s3;
            z = false;
            s2 = s3;
        } else {
            this._values[insertKey] = s2;
        }
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return s2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.map.TObjectShortMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return forEach(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        Object[] objArr = this._set;
        short[] sArr = this._values;
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tShortProcedure.execute(sArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean forEachEntry(TObjectShortProcedure<? super K> tObjectShortProcedure) {
        Object[] objArr = this._set;
        short[] sArr = this._values;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectShortProcedure.execute(objArr[i], sArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean retainEntries(TObjectShortProcedure<? super K> tObjectShortProcedure) {
        Object[] objArr = this._set;
        short[] sArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectShortProcedure.execute(objArr[i], sArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public void transformValues(TShortFunction tShortFunction) {
        Object[] objArr = this._set;
        short[] sArr = this._values;
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (objArr[i] != null && objArr[i] != REMOVED) {
                sArr[i] = tShortFunction.execute(sArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean equals(Object obj) {
        if (!(obj instanceof TObjectShortMap)) {
            return false;
        }
        TObjectShortMap tObjectShortMap = (TObjectShortMap) obj;
        if (tObjectShortMap.size() != size()) {
            return false;
        }
        try {
            TObjectShortIterator<K> it = iterator();
            while (it.hasNext()) {
                it.advance();
                K key = it.key();
                short value = it.value();
                if (value == this.no_entry_value) {
                    if (tObjectShortMap.get(key) != tObjectShortMap.getNoEntryValue() || !tObjectShortMap.containsKey(key)) {
                        return false;
                    }
                } else if (value != tObjectShortMap.get(key)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return true;
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public int hashCode() {
        Object[] objArr = this._set;
        short[] sArr = this._values;
        int length = sArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return i;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                i += HashFunctions.hash((int) sArr[i2]) ^ (objArr[i2] == null ? 0 : objArr[i2].hashCode());
            }
            length = i2;
        }
    }

    protected class KeyView extends TObjectShortHashMap<K>.MapBackedView<K> {
        protected KeyView() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new TObjectHashIterator(TObjectShortHashMap.this);
        }

        @Override // gnu.trove.map.hash.TObjectShortHashMap.MapBackedView
        public boolean removeElement(K k) {
            return TObjectShortHashMap.this.no_entry_value != TObjectShortHashMap.this.remove(k);
        }

        @Override // gnu.trove.map.hash.TObjectShortHashMap.MapBackedView
        public boolean containsElement(K k) {
            return TObjectShortHashMap.this.contains(k);
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
            TObjectShortHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectShortHashMap.this.size();
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
            return TObjectShortHashMap.this.isEmpty();
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

    class TShortValueCollection implements TShortCollection {
        TShortValueCollection() {
        }

        @Override // gnu.trove.TShortCollection
        public TShortIterator iterator() {
            return new TObjectShortValueHashIterator();
        }

        @Override // gnu.trove.TShortCollection
        public short getNoEntryValue() {
            return TObjectShortHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TShortCollection
        public int size() {
            return TObjectShortHashMap.this._size;
        }

        @Override // gnu.trove.TShortCollection
        public boolean isEmpty() {
            return TObjectShortHashMap.this._size == 0;
        }

        @Override // gnu.trove.TShortCollection
        public boolean contains(short s) {
            return TObjectShortHashMap.this.containsValue(s);
        }

        @Override // gnu.trove.TShortCollection
        public short[] toArray() {
            return TObjectShortHashMap.this.values();
        }

        @Override // gnu.trove.TShortCollection
        public short[] toArray(short[] sArr) {
            return TObjectShortHashMap.this.values(sArr);
        }

        @Override // gnu.trove.TShortCollection
        public boolean add(short s) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TShortCollection
        public boolean remove(short s) {
            short[] sArr = TObjectShortHashMap.this._values;
            Object[] objArr = TObjectShortHashMap.this._set;
            int length = sArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && s == sArr[i]) {
                    TObjectShortHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TShortCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Short) {
                    if (!TObjectShortHashMap.this.containsValue(((Short) obj).shortValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TShortCollection
        public boolean containsAll(TShortCollection tShortCollection) {
            TShortIterator it = tShortCollection.iterator();
            while (it.hasNext()) {
                if (!TObjectShortHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TShortCollection
        public boolean containsAll(short[] sArr) {
            for (short s : sArr) {
                if (!TObjectShortHashMap.this.containsValue(s)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TShortCollection
        public boolean addAll(Collection<? extends Short> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TShortCollection
        public boolean addAll(TShortCollection tShortCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TShortCollection
        public boolean addAll(short[] sArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TShortCollection
        public boolean retainAll(Collection<?> collection) {
            TShortIterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Short.valueOf(it.next()))) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TShortCollection
        public boolean retainAll(TShortCollection tShortCollection) {
            boolean z = false;
            if (this == tShortCollection) {
                return false;
            }
            TShortIterator it = iterator();
            while (it.hasNext()) {
                if (!tShortCollection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TShortCollection
        public boolean retainAll(short[] sArr) {
            Arrays.sort(sArr);
            short[] sArr2 = TObjectShortHashMap.this._values;
            Object[] objArr = TObjectShortHashMap.this._set;
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && Arrays.binarySearch(sArr, sArr2[i]) < 0) {
                    TObjectShortHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TShortCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Short) && remove(((Short) obj).shortValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TShortCollection
        public boolean removeAll(TShortCollection tShortCollection) {
            if (this == tShortCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TShortIterator it = tShortCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TShortCollection
        public boolean removeAll(short[] sArr) {
            int length = sArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (remove(sArr[i])) {
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TShortCollection
        public void clear() {
            TObjectShortHashMap.this.clear();
        }

        @Override // gnu.trove.TShortCollection
        public boolean forEach(TShortProcedure tShortProcedure) {
            return TObjectShortHashMap.this.forEachValue(tShortProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TObjectShortHashMap.this.forEachValue(new TShortProcedure() { // from class: gnu.trove.map.hash.TObjectShortHashMap.TShortValueCollection.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TShortProcedure
                public boolean execute(short s) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append((int) s);
                    return true;
                }
            });
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
            return sb.toString();
        }

        class TObjectShortValueHashIterator implements TShortIterator {
            protected int _expectedSize;
            protected THash _hash;
            protected int _index;

            TObjectShortValueHashIterator() {
                TObjectShortHashMap tObjectShortHashMap = TObjectShortHashMap.this;
                this._hash = tObjectShortHashMap;
                this._expectedSize = tObjectShortHashMap.size();
                this._index = this._hash.capacity();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return nextIndex() >= 0;
            }

            @Override // gnu.trove.iterator.TShortIterator
            public short next() {
                moveToNextIndex();
                return TObjectShortHashMap.this._values[this._index];
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                if (this._expectedSize != this._hash.size()) {
                    throw new ConcurrentModificationException();
                }
                try {
                    this._hash.tempDisableAutoCompaction();
                    TObjectShortHashMap.this.removeAt(this._index);
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
                Object[] objArr = TObjectShortHashMap.this._set;
                int i2 = this._index;
                while (true) {
                    i = i2 - 1;
                    if (i2 <= 0 || !(objArr[i] == TObjectHash.FREE || objArr[i] == TObjectHash.REMOVED)) {
                        break;
                    }
                    i2 = i;
                }
                return i;
            }
        }
    }

    class TObjectShortHashIterator<K> extends TObjectHashIterator<K> implements TObjectShortIterator<K> {
        private final TObjectShortHashMap<K> _map;

        public TObjectShortHashIterator(TObjectShortHashMap<K> tObjectShortHashMap) {
            super(tObjectShortHashMap);
            this._map = tObjectShortHashMap;
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TObjectShortIterator
        public K key() {
            return (K) this._map._set[this._index];
        }

        @Override // gnu.trove.iterator.TObjectShortIterator
        public short value() {
            return this._map._values[this._index];
        }

        @Override // gnu.trove.iterator.TObjectShortIterator
        public short setValue(short s) {
            short value = value();
            this._map._values[this._index] = s;
            return value;
        }
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        super.writeExternal(objectOutput);
        objectOutput.writeShort(this.no_entry_value);
        objectOutput.writeInt(this._size);
        int length = this._set.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._set[i] != REMOVED && this._set[i] != FREE) {
                objectOutput.writeObject(this._set[i]);
                objectOutput.writeShort(this._values[i]);
            }
            length = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
        this.no_entry_value = objectInput.readShort();
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readObject(), objectInput.readShort());
            readInt = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TObjectShortProcedure<K>() { // from class: gnu.trove.map.hash.TObjectShortHashMap.2
            private boolean first = true;

            @Override // gnu.trove.procedure.TObjectShortProcedure
            public boolean execute(K k, short s) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(",");
                }
                sb.append(k).append("=").append((int) s);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }
}