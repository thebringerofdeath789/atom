package gnu.trove.map.hash;

import gnu.trove.TCharCollection;
import gnu.trove.function.TObjectFunction;
import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TCharHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.iterator.TCharObjectIterator;
import gnu.trove.map.TCharObjectMap;
import gnu.trove.procedure.TCharObjectProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TCharSet;
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
public class TCharObjectHashMap<V> extends TCharHash implements TCharObjectMap<V>, Externalizable {
    static final long serialVersionUID = 1;
    private final TCharObjectProcedure<V> PUT_ALL_PROC;
    protected transient V[] _values;
    protected char no_entry_key;

    public TCharObjectHashMap() {
        this.PUT_ALL_PROC = new TCharObjectProcedure<V>() { // from class: gnu.trove.map.hash.TCharObjectHashMap.1
            @Override // gnu.trove.procedure.TCharObjectProcedure
            public boolean execute(char c, V v) {
                TCharObjectHashMap.this.put(c, v);
                return true;
            }
        };
    }

    public TCharObjectHashMap(int i) {
        super(i);
        this.PUT_ALL_PROC = new TCharObjectProcedure<V>() { // from class: gnu.trove.map.hash.TCharObjectHashMap.1
            @Override // gnu.trove.procedure.TCharObjectProcedure
            public boolean execute(char c, V v) {
                TCharObjectHashMap.this.put(c, v);
                return true;
            }
        };
        this.no_entry_key = Constants.DEFAULT_CHAR_NO_ENTRY_VALUE;
    }

    public TCharObjectHashMap(int i, float f) {
        super(i, f);
        this.PUT_ALL_PROC = new TCharObjectProcedure<V>() { // from class: gnu.trove.map.hash.TCharObjectHashMap.1
            @Override // gnu.trove.procedure.TCharObjectProcedure
            public boolean execute(char c, V v) {
                TCharObjectHashMap.this.put(c, v);
                return true;
            }
        };
        this.no_entry_key = Constants.DEFAULT_CHAR_NO_ENTRY_VALUE;
    }

    public TCharObjectHashMap(int i, float f, char c) {
        super(i, f);
        this.PUT_ALL_PROC = new TCharObjectProcedure<V>() { // from class: gnu.trove.map.hash.TCharObjectHashMap.1
            @Override // gnu.trove.procedure.TCharObjectProcedure
            public boolean execute(char c2, V v) {
                TCharObjectHashMap.this.put(c2, v);
                return true;
            }
        };
        this.no_entry_key = c;
    }

    public TCharObjectHashMap(TCharObjectMap<? extends V> tCharObjectMap) {
        this(tCharObjectMap.size(), 0.5f, tCharObjectMap.getNoEntryKey());
        putAll(tCharObjectMap);
    }

    @Override // gnu.trove.impl.hash.TCharHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = (V[]) new Object[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        char[] cArr = this._set;
        V[] vArr = this._values;
        byte[] bArr = this._states;
        this._set = new char[i];
        this._values = (V[]) new Object[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(cArr[i2])] = vArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TCharObjectMap
    public char getNoEntryKey() {
        return this.no_entry_key;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean containsKey(char c) {
        return contains(c);
    }

    @Override // gnu.trove.map.TCharObjectMap
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

    @Override // gnu.trove.map.TCharObjectMap
    public V get(char c) {
        int index = index(c);
        if (index < 0) {
            return null;
        }
        return this._values[index];
    }

    @Override // gnu.trove.map.TCharObjectMap
    public V put(char c, V v) {
        return doPut(v, insertKey(c));
    }

    @Override // gnu.trove.map.TCharObjectMap
    public V putIfAbsent(char c, V v) {
        int insertKey = insertKey(c);
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

    @Override // gnu.trove.map.TCharObjectMap
    public V remove(char c) {
        int index = index(c);
        if (index < 0) {
            return null;
        }
        V v = this._values[index];
        removeAt(index);
        return v;
    }

    @Override // gnu.trove.impl.hash.TCharHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = null;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TCharObjectMap
    public void putAll(Map<? extends Character, ? extends V> map) {
        for (Map.Entry<? extends Character, ? extends V> entry : map.entrySet()) {
            put(entry.getKey().charValue(), entry.getValue());
        }
    }

    @Override // gnu.trove.map.TCharObjectMap
    public void putAll(TCharObjectMap<? extends V> tCharObjectMap) {
        tCharObjectMap.forEachEntry(this.PUT_ALL_PROC);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
        V[] vArr = this._values;
        Arrays.fill(vArr, 0, vArr.length, (Object) null);
    }

    @Override // gnu.trove.map.TCharObjectMap
    public TCharSet keySet() {
        return new KeyView();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public char[] keys() {
        char[] cArr = new char[size()];
        char[] cArr2 = this._set;
        byte[] bArr = this._states;
        int length = cArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return cArr;
            }
            if (bArr[i2] == 1) {
                cArr[i] = cArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TCharObjectMap
    public char[] keys(char[] cArr) {
        if (cArr.length < this._size) {
            cArr = new char[this._size];
        }
        char[] cArr2 = this._set;
        byte[] bArr = this._states;
        int length = cArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return cArr;
            }
            if (bArr[i2] == 1) {
                cArr[i] = cArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TCharObjectMap
    public Collection<V> valueCollection() {
        return new ValueView();
    }

    @Override // gnu.trove.map.TCharObjectMap
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

    @Override // gnu.trove.map.TCharObjectMap
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

    @Override // gnu.trove.map.TCharObjectMap
    public TCharObjectIterator<V> iterator() {
        return new TCharObjectHashIterator(this);
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        return forEach(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharObjectMap
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

    @Override // gnu.trove.map.TCharObjectMap
    public boolean forEachEntry(TCharObjectProcedure<? super V> tCharObjectProcedure) {
        byte[] bArr = this._states;
        char[] cArr = this._set;
        V[] vArr = this._values;
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tCharObjectProcedure.execute(cArr[i], vArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean retainEntries(TCharObjectProcedure<? super V> tCharObjectProcedure) {
        byte[] bArr = this._states;
        char[] cArr = this._set;
        V[] vArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = cArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tCharObjectProcedure.execute(cArr[i], vArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TCharObjectMap
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

    @Override // gnu.trove.map.TCharObjectMap
    public boolean equals(Object obj) {
        if (!(obj instanceof TCharObjectMap)) {
            return false;
        }
        TCharObjectMap tCharObjectMap = (TCharObjectMap) obj;
        if (tCharObjectMap.size() != size()) {
            return false;
        }
        try {
            TCharObjectIterator<V> it = iterator();
            while (it.hasNext()) {
                it.advance();
                char key = it.key();
                V value = it.value();
                if (value == null) {
                    if (tCharObjectMap.get(key) != null || !tCharObjectMap.containsKey(key)) {
                        return false;
                    }
                } else if (!value.equals(tCharObjectMap.get(key))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return true;
        }
    }

    @Override // gnu.trove.map.TCharObjectMap
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
                i += HashFunctions.hash((int) this._set[i2]) ^ (vArr[i2] == null ? 0 : vArr[i2].hashCode());
            }
            length = i2;
        }
    }

    class KeyView implements TCharSet {
        KeyView() {
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public char getNoEntryValue() {
            return TCharObjectHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public int size() {
            return TCharObjectHashMap.this._size;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean isEmpty() {
            return TCharObjectHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean contains(char c) {
            return TCharObjectHashMap.this.containsKey(c);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public TCharIterator iterator() {
            return new TCharHashIterator(TCharObjectHashMap.this);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public char[] toArray() {
            return TCharObjectHashMap.this.keys();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public char[] toArray(char[] cArr) {
            return TCharObjectHashMap.this.keys(cArr);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean add(char c) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean remove(char c) {
            return TCharObjectHashMap.this.remove(c) != null;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!TCharObjectHashMap.this.containsKey(((Character) it.next()).charValue())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean containsAll(TCharCollection tCharCollection) {
            if (tCharCollection == this) {
                return true;
            }
            TCharIterator it = tCharCollection.iterator();
            while (it.hasNext()) {
                if (!TCharObjectHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean containsAll(char[] cArr) {
            for (char c : cArr) {
                if (!TCharObjectHashMap.this.containsKey(c)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean addAll(Collection<? extends Character> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean addAll(TCharCollection tCharCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean addAll(char[] cArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
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

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
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

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean retainAll(char[] cArr) {
            Arrays.sort(cArr);
            char[] cArr2 = TCharObjectHashMap.this._set;
            byte[] bArr = TCharObjectHashMap.this._states;
            int length = cArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(cArr, cArr2[i]) < 0) {
                    TCharObjectHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Character) && remove(((Character) obj).charValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean removeAll(TCharCollection tCharCollection) {
            if (tCharCollection == this) {
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

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
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

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public void clear() {
            TCharObjectHashMap.this.clear();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean forEach(TCharProcedure tCharProcedure) {
            return TCharObjectHashMap.this.forEachKey(tCharProcedure);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean equals(Object obj) {
            if (!(obj instanceof TCharSet)) {
                return false;
            }
            TCharSet tCharSet = (TCharSet) obj;
            if (tCharSet.size() != size()) {
                return false;
            }
            int length = TCharObjectHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TCharObjectHashMap.this._states[i] == 1 && !tCharSet.contains(TCharObjectHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public int hashCode() {
            int length = TCharObjectHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TCharObjectHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash((int) TCharObjectHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            int length = TCharObjectHashMap.this._states.length;
            boolean z = true;
            while (true) {
                int i = length - 1;
                if (length > 0) {
                    if (TCharObjectHashMap.this._states[i] == 1) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(",");
                        }
                        sb.append(TCharObjectHashMap.this._set[i]);
                    }
                    length = i;
                } else {
                    return sb.toString();
                }
            }
        }

        class TCharHashIterator extends THashPrimitiveIterator implements TCharIterator {
            private final TCharHash _hash;

            public TCharHashIterator(TCharHash tCharHash) {
                super(tCharHash);
                this._hash = tCharHash;
            }

            @Override // gnu.trove.iterator.TCharIterator
            public char next() {
                moveToNextIndex();
                return this._hash._set[this._index];
            }
        }
    }

    protected class ValueView extends TCharObjectHashMap<V>.MapBackedView<V> {
        protected ValueView() {
            super();
        }

        @Override // gnu.trove.map.hash.TCharObjectHashMap.MapBackedView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new TCharObjectHashMap<V>.ValueView.TCharObjectValueHashIterator(TCharObjectHashMap.this) { // from class: gnu.trove.map.hash.TCharObjectHashMap.ValueView.1
                @Override // gnu.trove.map.hash.TCharObjectHashMap.ValueView.TCharObjectValueHashIterator
                protected V objectAtIndex(int i) {
                    return TCharObjectHashMap.this._values[i];
                }
            };
        }

        @Override // gnu.trove.map.hash.TCharObjectHashMap.MapBackedView
        public boolean containsElement(V v) {
            return TCharObjectHashMap.this.containsValue(v);
        }

        @Override // gnu.trove.map.hash.TCharObjectHashMap.MapBackedView
        public boolean removeElement(V v) {
            int i;
            V[] vArr = TCharObjectHashMap.this._values;
            byte[] bArr = TCharObjectHashMap.this._states;
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
            TCharObjectHashMap.this.removeAt(i);
            return true;
        }

        class TCharObjectValueHashIterator extends THashPrimitiveIterator implements Iterator<V> {
            protected final TCharObjectHashMap _map;

            public TCharObjectValueHashIterator(TCharObjectHashMap tCharObjectHashMap) {
                super(tCharObjectHashMap);
                this._map = tCharObjectHashMap;
            }

            protected V objectAtIndex(int i) {
                byte[] bArr = TCharObjectHashMap.this._states;
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
            TCharObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TCharObjectHashMap.this.size();
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
            return TCharObjectHashMap.this.isEmpty();
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

    class TCharObjectHashIterator<V> extends THashPrimitiveIterator implements TCharObjectIterator<V> {
        private final TCharObjectHashMap<V> _map;

        public TCharObjectHashIterator(TCharObjectHashMap<V> tCharObjectHashMap) {
            super(tCharObjectHashMap);
            this._map = tCharObjectHashMap;
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TCharObjectIterator
        public char key() {
            return this._map._set[this._index];
        }

        @Override // gnu.trove.iterator.TCharObjectIterator
        public V value() {
            return this._map._values[this._index];
        }

        @Override // gnu.trove.iterator.TCharObjectIterator
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
        objectOutput.writeChar(this.no_entry_key);
        objectOutput.writeInt(this._size);
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._states[i] == 1) {
                objectOutput.writeChar(this._set[i]);
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
        this.no_entry_key = objectInput.readChar();
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readChar(), objectInput.readObject());
            readInt = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TCharObjectProcedure<V>() { // from class: gnu.trove.map.hash.TCharObjectHashMap.2
            private boolean first = true;

            @Override // gnu.trove.procedure.TCharObjectProcedure
            public boolean execute(char c, Object obj) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(",");
                }
                sb.append(c);
                sb.append("=");
                sb.append(obj);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }
}