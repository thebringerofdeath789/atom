package gnu.trove.map.custom_hash;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TCustomObjectHash;
import gnu.trove.impl.hash.THash;
import gnu.trove.impl.hash.TObjectHash;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.iterator.TObjectByteIterator;
import gnu.trove.iterator.hash.TObjectHashIterator;
import gnu.trove.map.TObjectByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TObjectByteProcedure;
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
public class TObjectByteCustomHashMap<K> extends TCustomObjectHash<K> implements TObjectByteMap<K>, Externalizable {
    static final long serialVersionUID = 1;
    private final TObjectByteProcedure<K> PUT_ALL_PROC;
    protected transient byte[] _values;
    protected byte no_entry_value;

    public TObjectByteCustomHashMap() {
        this.PUT_ALL_PROC = new TObjectByteProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectByteCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectByteProcedure
            public boolean execute(K k, byte b) {
                TObjectByteCustomHashMap.this.put(k, b);
                return true;
            }
        };
    }

    public TObjectByteCustomHashMap(HashingStrategy<? super K> hashingStrategy) {
        super(hashingStrategy);
        this.PUT_ALL_PROC = new TObjectByteProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectByteCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectByteProcedure
            public boolean execute(K k, byte b) {
                TObjectByteCustomHashMap.this.put(k, b);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_BYTE_NO_ENTRY_VALUE;
    }

    public TObjectByteCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i) {
        super(hashingStrategy, i);
        this.PUT_ALL_PROC = new TObjectByteProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectByteCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectByteProcedure
            public boolean execute(K k, byte b) {
                TObjectByteCustomHashMap.this.put(k, b);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_BYTE_NO_ENTRY_VALUE;
    }

    public TObjectByteCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i, float f) {
        super(hashingStrategy, i, f);
        this.PUT_ALL_PROC = new TObjectByteProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectByteCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectByteProcedure
            public boolean execute(K k, byte b) {
                TObjectByteCustomHashMap.this.put(k, b);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_BYTE_NO_ENTRY_VALUE;
    }

    public TObjectByteCustomHashMap(HashingStrategy<? super K> hashingStrategy, int i, float f, byte b) {
        super(hashingStrategy, i, f);
        this.PUT_ALL_PROC = new TObjectByteProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectByteCustomHashMap.1
            @Override // gnu.trove.procedure.TObjectByteProcedure
            public boolean execute(K k, byte b2) {
                TObjectByteCustomHashMap.this.put(k, b2);
                return true;
            }
        };
        this.no_entry_value = b;
        if (b != 0) {
            Arrays.fill(this._values, b);
        }
    }

    public TObjectByteCustomHashMap(HashingStrategy<? super K> hashingStrategy, TObjectByteMap<? extends K> tObjectByteMap) {
        this(hashingStrategy, tObjectByteMap.size(), 0.5f, tObjectByteMap.getNoEntryValue());
        if (tObjectByteMap instanceof TObjectByteCustomHashMap) {
            TObjectByteCustomHashMap tObjectByteCustomHashMap = (TObjectByteCustomHashMap) tObjectByteMap;
            this._loadFactor = Math.abs(tObjectByteCustomHashMap._loadFactor);
            this.no_entry_value = tObjectByteCustomHashMap.no_entry_value;
            this.strategy = tObjectByteCustomHashMap.strategy;
            byte b = this.no_entry_value;
            if (b != 0) {
                Arrays.fill(this._values, b);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tObjectByteMap);
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    public int setUp(int i) {
        int up = super.setUp(i);
        this._values = new byte[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        Object[] objArr = this._set;
        byte[] bArr = this._values;
        this._set = new Object[i];
        Arrays.fill(this._set, FREE);
        byte[] bArr2 = new byte[i];
        this._values = bArr2;
        Arrays.fill(bArr2, this.no_entry_value);
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
                this._values[insertKey] = bArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean containsKey(Object obj) {
        return contains(obj);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean containsValue(byte b) {
        Object[] objArr = this._set;
        byte[] bArr = this._values;
        int length = bArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && b == bArr[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte get(Object obj) {
        int index = index(obj);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte put(K k, byte b) {
        return doPut(b, insertKey(k));
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte putIfAbsent(K k, byte b) {
        int insertKey = insertKey(k);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(b, insertKey);
    }

    private byte doPut(byte b, int i) {
        byte b2 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            b2 = this._values[i];
            z = false;
        }
        this._values[i] = b;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return b2;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte remove(Object obj) {
        byte b = this.no_entry_value;
        int index = index(obj);
        if (index < 0) {
            return b;
        }
        byte b2 = this._values[index];
        removeAt(index);
        return b2;
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public void putAll(Map<? extends K, ? extends Byte> map) {
        for (Map.Entry<? extends K, ? extends Byte> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().byteValue());
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public void putAll(TObjectByteMap<? extends K> tObjectByteMap) {
        tObjectByteMap.forEachEntry(this.PUT_ALL_PROC);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, FREE);
        byte[] bArr = this._values;
        Arrays.fill(bArr, 0, bArr.length, this.no_entry_value);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public Set<K> keySet() {
        return new KeyView();
    }

    @Override // gnu.trove.map.TObjectByteMap
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

    @Override // gnu.trove.map.TObjectByteMap
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

    @Override // gnu.trove.map.TObjectByteMap
    public TByteCollection valueCollection() {
        return new TByteValueCollection();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte[] values() {
        byte[] bArr = new byte[size()];
        byte[] bArr2 = this._values;
        Object[] objArr = this._set;
        int length = bArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return bArr;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                bArr[i] = bArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte[] values(byte[] bArr) {
        int size = size();
        if (bArr.length < size) {
            bArr = new byte[size];
        }
        byte[] bArr2 = this._values;
        Object[] objArr = this._set;
        int length = bArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                bArr[i] = bArr2[i2];
                i++;
            }
            length = i2;
        }
        if (bArr.length > size) {
            bArr[size] = this.no_entry_value;
        }
        return bArr;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public TObjectByteIterator<K> iterator() {
        return new TObjectByteHashIterator(this);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean increment(K k) {
        return adjustValue(k, (byte) 1);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean adjustValue(K k, byte b) {
        int index = index(k);
        if (index < 0) {
            return false;
        }
        byte[] bArr = this._values;
        bArr[index] = (byte) (bArr[index] + b);
        return true;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte adjustOrPutValue(K k, byte b, byte b2) {
        int insertKey = insertKey(k);
        boolean z = true;
        if (insertKey < 0) {
            int i = (-insertKey) - 1;
            byte[] bArr = this._values;
            byte b3 = (byte) (bArr[i] + b);
            bArr[i] = b3;
            z = false;
            b2 = b3;
        } else {
            this._values[insertKey] = b2;
        }
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.map.TObjectByteMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return forEach(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        Object[] objArr = this._set;
        byte[] bArr = this._values;
        int length = bArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tByteProcedure.execute(bArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean forEachEntry(TObjectByteProcedure<? super K> tObjectByteProcedure) {
        Object[] objArr = this._set;
        byte[] bArr = this._values;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectByteProcedure.execute(objArr[i], bArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean retainEntries(TObjectByteProcedure<? super K> tObjectByteProcedure) {
        Object[] objArr = this._set;
        byte[] bArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectByteProcedure.execute(objArr[i], bArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public void transformValues(TByteFunction tByteFunction) {
        Object[] objArr = this._set;
        byte[] bArr = this._values;
        int length = bArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (objArr[i] != null && objArr[i] != REMOVED) {
                bArr[i] = tByteFunction.execute(bArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean equals(Object obj) {
        if (!(obj instanceof TObjectByteMap)) {
            return false;
        }
        TObjectByteMap tObjectByteMap = (TObjectByteMap) obj;
        if (tObjectByteMap.size() != size()) {
            return false;
        }
        try {
            TObjectByteIterator<K> it = iterator();
            while (it.hasNext()) {
                it.advance();
                K key = it.key();
                byte value = it.value();
                if (value == this.no_entry_value) {
                    if (tObjectByteMap.get(key) != tObjectByteMap.getNoEntryValue() || !tObjectByteMap.containsKey(key)) {
                        return false;
                    }
                } else if (value != tObjectByteMap.get(key)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return true;
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public int hashCode() {
        Object[] objArr = this._set;
        byte[] bArr = this._values;
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return i;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                i += HashFunctions.hash((int) bArr[i2]) ^ (objArr[i2] == null ? 0 : objArr[i2].hashCode());
            }
            length = i2;
        }
    }

    protected class KeyView extends TObjectByteCustomHashMap<K>.MapBackedView<K> {
        protected KeyView() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new TObjectHashIterator(TObjectByteCustomHashMap.this);
        }

        @Override // gnu.trove.map.custom_hash.TObjectByteCustomHashMap.MapBackedView
        public boolean removeElement(K k) {
            return TObjectByteCustomHashMap.this.no_entry_value != TObjectByteCustomHashMap.this.remove(k);
        }

        @Override // gnu.trove.map.custom_hash.TObjectByteCustomHashMap.MapBackedView
        public boolean containsElement(K k) {
            return TObjectByteCustomHashMap.this.contains(k);
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
            TObjectByteCustomHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectByteCustomHashMap.this.size();
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
            return TObjectByteCustomHashMap.this.isEmpty();
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

    class TByteValueCollection implements TByteCollection {
        TByteValueCollection() {
        }

        @Override // gnu.trove.TByteCollection
        public TByteIterator iterator() {
            return new TObjectByteValueHashIterator();
        }

        @Override // gnu.trove.TByteCollection
        public byte getNoEntryValue() {
            return TObjectByteCustomHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TByteCollection
        public int size() {
            return TObjectByteCustomHashMap.this._size;
        }

        @Override // gnu.trove.TByteCollection
        public boolean isEmpty() {
            return TObjectByteCustomHashMap.this._size == 0;
        }

        @Override // gnu.trove.TByteCollection
        public boolean contains(byte b) {
            return TObjectByteCustomHashMap.this.containsValue(b);
        }

        @Override // gnu.trove.TByteCollection
        public byte[] toArray() {
            return TObjectByteCustomHashMap.this.values();
        }

        @Override // gnu.trove.TByteCollection
        public byte[] toArray(byte[] bArr) {
            return TObjectByteCustomHashMap.this.values(bArr);
        }

        @Override // gnu.trove.TByteCollection
        public boolean add(byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
        public boolean remove(byte b) {
            byte[] bArr = TObjectByteCustomHashMap.this._values;
            Object[] objArr = TObjectByteCustomHashMap.this._set;
            int length = bArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && b == bArr[i]) {
                    TObjectByteCustomHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TByteCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Byte) {
                    if (!TObjectByteCustomHashMap.this.containsValue(((Byte) obj).byteValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TByteCollection
        public boolean containsAll(TByteCollection tByteCollection) {
            TByteIterator it = tByteCollection.iterator();
            while (it.hasNext()) {
                if (!TObjectByteCustomHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TByteCollection
        public boolean containsAll(byte[] bArr) {
            for (byte b : bArr) {
                if (!TObjectByteCustomHashMap.this.containsValue(b)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TByteCollection
        public boolean addAll(Collection<? extends Byte> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
        public boolean addAll(TByteCollection tByteCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
        public boolean addAll(byte[] bArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
        public boolean retainAll(Collection<?> collection) {
            TByteIterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Byte.valueOf(it.next()))) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TByteCollection
        public boolean retainAll(TByteCollection tByteCollection) {
            boolean z = false;
            if (this == tByteCollection) {
                return false;
            }
            TByteIterator it = iterator();
            while (it.hasNext()) {
                if (!tByteCollection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TByteCollection
        public boolean retainAll(byte[] bArr) {
            Arrays.sort(bArr);
            byte[] bArr2 = TObjectByteCustomHashMap.this._values;
            Object[] objArr = TObjectByteCustomHashMap.this._set;
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && Arrays.binarySearch(bArr, bArr2[i]) < 0) {
                    TObjectByteCustomHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TByteCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Byte) && remove(((Byte) obj).byteValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TByteCollection
        public boolean removeAll(TByteCollection tByteCollection) {
            if (this == tByteCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TByteIterator it = tByteCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TByteCollection
        public boolean removeAll(byte[] bArr) {
            int length = bArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (remove(bArr[i])) {
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TByteCollection
        public void clear() {
            TObjectByteCustomHashMap.this.clear();
        }

        @Override // gnu.trove.TByteCollection
        public boolean forEach(TByteProcedure tByteProcedure) {
            return TObjectByteCustomHashMap.this.forEachValue(tByteProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TObjectByteCustomHashMap.this.forEachValue(new TByteProcedure() { // from class: gnu.trove.map.custom_hash.TObjectByteCustomHashMap.TByteValueCollection.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TByteProcedure
                public boolean execute(byte b) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append((int) b);
                    return true;
                }
            });
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
            return sb.toString();
        }

        class TObjectByteValueHashIterator implements TByteIterator {
            protected int _expectedSize;
            protected THash _hash;
            protected int _index;

            TObjectByteValueHashIterator() {
                TObjectByteCustomHashMap tObjectByteCustomHashMap = TObjectByteCustomHashMap.this;
                this._hash = tObjectByteCustomHashMap;
                this._expectedSize = tObjectByteCustomHashMap.size();
                this._index = this._hash.capacity();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return nextIndex() >= 0;
            }

            @Override // gnu.trove.iterator.TByteIterator
            public byte next() {
                moveToNextIndex();
                return TObjectByteCustomHashMap.this._values[this._index];
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                if (this._expectedSize != this._hash.size()) {
                    throw new ConcurrentModificationException();
                }
                try {
                    this._hash.tempDisableAutoCompaction();
                    TObjectByteCustomHashMap.this.removeAt(this._index);
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
                Object[] objArr = TObjectByteCustomHashMap.this._set;
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

    class TObjectByteHashIterator<K> extends TObjectHashIterator<K> implements TObjectByteIterator<K> {
        private final TObjectByteCustomHashMap<K> _map;

        public TObjectByteHashIterator(TObjectByteCustomHashMap<K> tObjectByteCustomHashMap) {
            super(tObjectByteCustomHashMap);
            this._map = tObjectByteCustomHashMap;
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TObjectByteIterator
        public K key() {
            return (K) this._map._set[this._index];
        }

        @Override // gnu.trove.iterator.TObjectByteIterator
        public byte value() {
            return this._map._values[this._index];
        }

        @Override // gnu.trove.iterator.TObjectByteIterator
        public byte setValue(byte b) {
            byte value = value();
            this._map._values[this._index] = b;
            return value;
        }
    }

    @Override // gnu.trove.impl.hash.TCustomObjectHash, gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        super.writeExternal(objectOutput);
        objectOutput.writeObject(this.strategy);
        objectOutput.writeByte(this.no_entry_value);
        objectOutput.writeInt(this._size);
        int length = this._set.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._set[i] != REMOVED && this._set[i] != FREE) {
                objectOutput.writeObject(this._set[i]);
                objectOutput.writeByte(this._values[i]);
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
        this.no_entry_value = objectInput.readByte();
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readObject(), objectInput.readByte());
            readInt = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TObjectByteProcedure<K>() { // from class: gnu.trove.map.custom_hash.TObjectByteCustomHashMap.2
            private boolean first = true;

            @Override // gnu.trove.procedure.TObjectByteProcedure
            public boolean execute(K k, byte b) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(",");
                }
                sb.append(k).append("=").append((int) b);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }
}