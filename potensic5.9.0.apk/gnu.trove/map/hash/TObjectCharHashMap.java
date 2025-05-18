package gnu.trove.map.hash;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THash;
import gnu.trove.impl.hash.TObjectHash;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.iterator.TObjectCharIterator;
import gnu.trove.iterator.hash.TObjectHashIterator;
import gnu.trove.map.TObjectCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TObjectCharProcedure;
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
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TObjectCharHashMap<K> extends TObjectHash<K> implements TObjectCharMap<K>, Externalizable {
    static final long serialVersionUID = 1;
    private final TObjectCharProcedure<K> PUT_ALL_PROC;
    protected transient char[] _values;
    protected char no_entry_value;

    public TObjectCharHashMap() {
        this.PUT_ALL_PROC = new TObjectCharProcedure<K>() { // from class: gnu.trove.map.hash.TObjectCharHashMap.1
            @Override // gnu.trove.procedure.TObjectCharProcedure
            public boolean execute(K k, char c) {
                TObjectCharHashMap.this.put(k, c);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_CHAR_NO_ENTRY_VALUE;
    }

    public TObjectCharHashMap(int i) {
        super(i);
        this.PUT_ALL_PROC = new TObjectCharProcedure<K>() { // from class: gnu.trove.map.hash.TObjectCharHashMap.1
            @Override // gnu.trove.procedure.TObjectCharProcedure
            public boolean execute(K k, char c) {
                TObjectCharHashMap.this.put(k, c);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_CHAR_NO_ENTRY_VALUE;
    }

    public TObjectCharHashMap(int i, float f) {
        super(i, f);
        this.PUT_ALL_PROC = new TObjectCharProcedure<K>() { // from class: gnu.trove.map.hash.TObjectCharHashMap.1
            @Override // gnu.trove.procedure.TObjectCharProcedure
            public boolean execute(K k, char c) {
                TObjectCharHashMap.this.put(k, c);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_CHAR_NO_ENTRY_VALUE;
    }

    public TObjectCharHashMap(int i, float f, char c) {
        super(i, f);
        this.PUT_ALL_PROC = new TObjectCharProcedure<K>() { // from class: gnu.trove.map.hash.TObjectCharHashMap.1
            @Override // gnu.trove.procedure.TObjectCharProcedure
            public boolean execute(K k, char c2) {
                TObjectCharHashMap.this.put(k, c2);
                return true;
            }
        };
        this.no_entry_value = c;
        if (c != 0) {
            Arrays.fill(this._values, c);
        }
    }

    public TObjectCharHashMap(TObjectCharMap<? extends K> tObjectCharMap) {
        this(tObjectCharMap.size(), 0.5f, tObjectCharMap.getNoEntryValue());
        if (tObjectCharMap instanceof TObjectCharHashMap) {
            TObjectCharHashMap tObjectCharHashMap = (TObjectCharHashMap) tObjectCharMap;
            this._loadFactor = Math.abs(tObjectCharHashMap._loadFactor);
            char c = tObjectCharHashMap.no_entry_value;
            this.no_entry_value = c;
            if (c != 0) {
                Arrays.fill(this._values, c);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tObjectCharMap);
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    public int setUp(int i) {
        int up = super.setUp(i);
        this._values = new char[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        Object[] objArr = this._set;
        char[] cArr = this._values;
        this._set = new Object[i];
        Arrays.fill(this._set, FREE);
        char[] cArr2 = new char[i];
        this._values = cArr2;
        Arrays.fill(cArr2, this.no_entry_value);
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
                this._values[insertKey] = cArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean containsKey(Object obj) {
        return contains(obj);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean containsValue(char c) {
        Object[] objArr = this._set;
        char[] cArr = this._values;
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && c == cArr[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char get(Object obj) {
        int index = index(obj);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char put(K k, char c) {
        return doPut(c, insertKey(k));
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char putIfAbsent(K k, char c) {
        int insertKey = insertKey(k);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(c, insertKey);
    }

    private char doPut(char c, int i) {
        char c2 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            c2 = this._values[i];
            z = false;
        }
        this._values[i] = c;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return c2;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char remove(Object obj) {
        char c = this.no_entry_value;
        int index = index(obj);
        if (index < 0) {
            return c;
        }
        char c2 = this._values[index];
        removeAt(index);
        return c2;
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public void putAll(Map<? extends K, ? extends Character> map) {
        for (Map.Entry<? extends K, ? extends Character> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().charValue());
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public void putAll(TObjectCharMap<? extends K> tObjectCharMap) {
        tObjectCharMap.forEachEntry(this.PUT_ALL_PROC);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, FREE);
        char[] cArr = this._values;
        Arrays.fill(cArr, 0, cArr.length, this.no_entry_value);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public Set<K> keySet() {
        return new KeyView();
    }

    @Override // gnu.trove.map.TObjectCharMap
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

    @Override // gnu.trove.map.TObjectCharMap
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

    @Override // gnu.trove.map.TObjectCharMap
    public TCharCollection valueCollection() {
        return new TCharValueCollection();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char[] values() {
        char[] cArr = new char[size()];
        char[] cArr2 = this._values;
        Object[] objArr = this._set;
        int length = cArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return cArr;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                cArr[i] = cArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char[] values(char[] cArr) {
        int size = size();
        if (cArr.length < size) {
            cArr = new char[size];
        }
        char[] cArr2 = this._values;
        Object[] objArr = this._set;
        int length = cArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                cArr[i] = cArr2[i2];
                i++;
            }
            length = i2;
        }
        if (cArr.length > size) {
            cArr[size] = this.no_entry_value;
        }
        return cArr;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public TObjectCharIterator<K> iterator() {
        return new TObjectCharHashIterator(this);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean increment(K k) {
        return adjustValue(k, (char) 1);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean adjustValue(K k, char c) {
        int index = index(k);
        if (index < 0) {
            return false;
        }
        char[] cArr = this._values;
        cArr[index] = (char) (cArr[index] + c);
        return true;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char adjustOrPutValue(K k, char c, char c2) {
        int insertKey = insertKey(k);
        boolean z = true;
        if (insertKey < 0) {
            int i = (-insertKey) - 1;
            char[] cArr = this._values;
            char c3 = (char) (cArr[i] + c);
            cArr[i] = c3;
            z = false;
            c2 = c3;
        } else {
            this._values[insertKey] = c2;
        }
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return c2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.map.TObjectCharMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return forEach(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        Object[] objArr = this._set;
        char[] cArr = this._values;
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tCharProcedure.execute(cArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean forEachEntry(TObjectCharProcedure<? super K> tObjectCharProcedure) {
        Object[] objArr = this._set;
        char[] cArr = this._values;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectCharProcedure.execute(objArr[i], cArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean retainEntries(TObjectCharProcedure<? super K> tObjectCharProcedure) {
        Object[] objArr = this._set;
        char[] cArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectCharProcedure.execute(objArr[i], cArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public void transformValues(TCharFunction tCharFunction) {
        Object[] objArr = this._set;
        char[] cArr = this._values;
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (objArr[i] != null && objArr[i] != REMOVED) {
                cArr[i] = tCharFunction.execute(cArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean equals(Object obj) {
        if (!(obj instanceof TObjectCharMap)) {
            return false;
        }
        TObjectCharMap tObjectCharMap = (TObjectCharMap) obj;
        if (tObjectCharMap.size() != size()) {
            return false;
        }
        try {
            TObjectCharIterator<K> it = iterator();
            while (it.hasNext()) {
                it.advance();
                K key = it.key();
                char value = it.value();
                if (value == this.no_entry_value) {
                    if (tObjectCharMap.get(key) != tObjectCharMap.getNoEntryValue() || !tObjectCharMap.containsKey(key)) {
                        return false;
                    }
                } else if (value != tObjectCharMap.get(key)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return true;
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public int hashCode() {
        Object[] objArr = this._set;
        char[] cArr = this._values;
        int length = cArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return i;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                i += HashFunctions.hash((int) cArr[i2]) ^ (objArr[i2] == null ? 0 : objArr[i2].hashCode());
            }
            length = i2;
        }
    }

    protected class KeyView extends TObjectCharHashMap<K>.MapBackedView<K> {
        protected KeyView() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new TObjectHashIterator(TObjectCharHashMap.this);
        }

        @Override // gnu.trove.map.hash.TObjectCharHashMap.MapBackedView
        public boolean removeElement(K k) {
            return TObjectCharHashMap.this.no_entry_value != TObjectCharHashMap.this.remove(k);
        }

        @Override // gnu.trove.map.hash.TObjectCharHashMap.MapBackedView
        public boolean containsElement(K k) {
            return TObjectCharHashMap.this.contains(k);
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
            TObjectCharHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectCharHashMap.this.size();
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
            return TObjectCharHashMap.this.isEmpty();
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

    class TCharValueCollection implements TCharCollection {
        TCharValueCollection() {
        }

        @Override // gnu.trove.TCharCollection
        public TCharIterator iterator() {
            return new TObjectCharValueHashIterator();
        }

        @Override // gnu.trove.TCharCollection
        public char getNoEntryValue() {
            return TObjectCharHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TCharCollection
        public int size() {
            return TObjectCharHashMap.this._size;
        }

        @Override // gnu.trove.TCharCollection
        public boolean isEmpty() {
            return TObjectCharHashMap.this._size == 0;
        }

        @Override // gnu.trove.TCharCollection
        public boolean contains(char c) {
            return TObjectCharHashMap.this.containsValue(c);
        }

        @Override // gnu.trove.TCharCollection
        public char[] toArray() {
            return TObjectCharHashMap.this.values();
        }

        @Override // gnu.trove.TCharCollection
        public char[] toArray(char[] cArr) {
            return TObjectCharHashMap.this.values(cArr);
        }

        @Override // gnu.trove.TCharCollection
        public boolean add(char c) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TCharCollection
        public boolean remove(char c) {
            char[] cArr = TObjectCharHashMap.this._values;
            Object[] objArr = TObjectCharHashMap.this._set;
            int length = cArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && c == cArr[i]) {
                    TObjectCharHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Character) {
                    if (!TObjectCharHashMap.this.containsValue(((Character) obj).charValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(TCharCollection tCharCollection) {
            TCharIterator it = tCharCollection.iterator();
            while (it.hasNext()) {
                if (!TObjectCharHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(char[] cArr) {
            for (char c : cArr) {
                if (!TObjectCharHashMap.this.containsValue(c)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TCharCollection
        public boolean addAll(Collection<? extends Character> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TCharCollection
        public boolean addAll(TCharCollection tCharCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TCharCollection
        public boolean addAll(char[] cArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TCharCollection
        public boolean retainAll(Collection<?> collection) {
            TCharIterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Character.valueOf(it.next()))) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TCharCollection
        public boolean retainAll(TCharCollection tCharCollection) {
            boolean z = false;
            if (this == tCharCollection) {
                return false;
            }
            TCharIterator it = iterator();
            while (it.hasNext()) {
                if (!tCharCollection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TCharCollection
        public boolean retainAll(char[] cArr) {
            Arrays.sort(cArr);
            char[] cArr2 = TObjectCharHashMap.this._values;
            Object[] objArr = TObjectCharHashMap.this._set;
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && Arrays.binarySearch(cArr, cArr2[i]) < 0) {
                    TObjectCharHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TCharCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Character) && remove(((Character) obj).charValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TCharCollection
        public boolean removeAll(TCharCollection tCharCollection) {
            if (this == tCharCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TCharIterator it = tCharCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TCharCollection
        public boolean removeAll(char[] cArr) {
            int length = cArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (remove(cArr[i])) {
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TCharCollection
        public void clear() {
            TObjectCharHashMap.this.clear();
        }

        @Override // gnu.trove.TCharCollection
        public boolean forEach(TCharProcedure tCharProcedure) {
            return TObjectCharHashMap.this.forEachValue(tCharProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TObjectCharHashMap.this.forEachValue(new TCharProcedure() { // from class: gnu.trove.map.hash.TObjectCharHashMap.TCharValueCollection.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TCharProcedure
                public boolean execute(char c) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(c);
                    return true;
                }
            });
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
            return sb.toString();
        }

        class TObjectCharValueHashIterator implements TCharIterator {
            protected int _expectedSize;
            protected THash _hash;
            protected int _index;

            TObjectCharValueHashIterator() {
                TObjectCharHashMap tObjectCharHashMap = TObjectCharHashMap.this;
                this._hash = tObjectCharHashMap;
                this._expectedSize = tObjectCharHashMap.size();
                this._index = this._hash.capacity();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return nextIndex() >= 0;
            }

            @Override // gnu.trove.iterator.TCharIterator
            public char next() {
                moveToNextIndex();
                return TObjectCharHashMap.this._values[this._index];
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                if (this._expectedSize != this._hash.size()) {
                    throw new ConcurrentModificationException();
                }
                try {
                    this._hash.tempDisableAutoCompaction();
                    TObjectCharHashMap.this.removeAt(this._index);
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
                Object[] objArr = TObjectCharHashMap.this._set;
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

    class TObjectCharHashIterator<K> extends TObjectHashIterator<K> implements TObjectCharIterator<K> {
        private final TObjectCharHashMap<K> _map;

        public TObjectCharHashIterator(TObjectCharHashMap<K> tObjectCharHashMap) {
            super(tObjectCharHashMap);
            this._map = tObjectCharHashMap;
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TObjectCharIterator
        public K key() {
            return (K) this._map._set[this._index];
        }

        @Override // gnu.trove.iterator.TObjectCharIterator
        public char value() {
            return this._map._values[this._index];
        }

        @Override // gnu.trove.iterator.TObjectCharIterator
        public char setValue(char c) {
            char value = value();
            this._map._values[this._index] = c;
            return value;
        }
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        super.writeExternal(objectOutput);
        objectOutput.writeChar(this.no_entry_value);
        objectOutput.writeInt(this._size);
        int length = this._set.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._set[i] != REMOVED && this._set[i] != FREE) {
                objectOutput.writeObject(this._set[i]);
                objectOutput.writeChar(this._values[i]);
            }
            length = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
        this.no_entry_value = objectInput.readChar();
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readObject(), objectInput.readChar());
            readInt = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TObjectCharProcedure<K>() { // from class: gnu.trove.map.hash.TObjectCharHashMap.2
            private boolean first = true;

            @Override // gnu.trove.procedure.TObjectCharProcedure
            public boolean execute(K k, char c) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(",");
                }
                sb.append(k).append("=").append(c);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }
}