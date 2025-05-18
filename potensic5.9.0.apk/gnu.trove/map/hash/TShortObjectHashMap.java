package gnu.trove.map.hash;

import gnu.trove.TShortCollection;
import gnu.trove.function.TObjectFunction;
import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TShortHash;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.iterator.TShortObjectIterator;
import gnu.trove.map.TShortObjectMap;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.procedure.TShortObjectProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
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
public class TShortObjectHashMap<V> extends TShortHash implements TShortObjectMap<V>, Externalizable {
    static final long serialVersionUID = 1;
    private final TShortObjectProcedure<V> PUT_ALL_PROC;
    protected transient V[] _values;
    protected short no_entry_key;

    public TShortObjectHashMap() {
        this.PUT_ALL_PROC = new TShortObjectProcedure<V>() { // from class: gnu.trove.map.hash.TShortObjectHashMap.1
            @Override // gnu.trove.procedure.TShortObjectProcedure
            public boolean execute(short s, V v) {
                TShortObjectHashMap.this.put(s, v);
                return true;
            }
        };
    }

    public TShortObjectHashMap(int i) {
        super(i);
        this.PUT_ALL_PROC = new TShortObjectProcedure<V>() { // from class: gnu.trove.map.hash.TShortObjectHashMap.1
            @Override // gnu.trove.procedure.TShortObjectProcedure
            public boolean execute(short s, V v) {
                TShortObjectHashMap.this.put(s, v);
                return true;
            }
        };
        this.no_entry_key = Constants.DEFAULT_SHORT_NO_ENTRY_VALUE;
    }

    public TShortObjectHashMap(int i, float f) {
        super(i, f);
        this.PUT_ALL_PROC = new TShortObjectProcedure<V>() { // from class: gnu.trove.map.hash.TShortObjectHashMap.1
            @Override // gnu.trove.procedure.TShortObjectProcedure
            public boolean execute(short s, V v) {
                TShortObjectHashMap.this.put(s, v);
                return true;
            }
        };
        this.no_entry_key = Constants.DEFAULT_SHORT_NO_ENTRY_VALUE;
    }

    public TShortObjectHashMap(int i, float f, short s) {
        super(i, f);
        this.PUT_ALL_PROC = new TShortObjectProcedure<V>() { // from class: gnu.trove.map.hash.TShortObjectHashMap.1
            @Override // gnu.trove.procedure.TShortObjectProcedure
            public boolean execute(short s2, V v) {
                TShortObjectHashMap.this.put(s2, v);
                return true;
            }
        };
        this.no_entry_key = s;
    }

    public TShortObjectHashMap(TShortObjectMap<? extends V> tShortObjectMap) {
        this(tShortObjectMap.size(), 0.5f, tShortObjectMap.getNoEntryKey());
        putAll(tShortObjectMap);
    }

    @Override // gnu.trove.impl.hash.TShortHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = (V[]) new Object[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        short[] sArr = this._set;
        V[] vArr = this._values;
        byte[] bArr = this._states;
        this._set = new short[i];
        this._values = (V[]) new Object[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(sArr[i2])] = vArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TShortObjectMap
    public short getNoEntryKey() {
        return this.no_entry_key;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean containsKey(short s) {
        return contains(s);
    }

    @Override // gnu.trove.map.TShortObjectMap
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

    @Override // gnu.trove.map.TShortObjectMap
    public V get(short s) {
        int index = index(s);
        if (index < 0) {
            return null;
        }
        return this._values[index];
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V put(short s, V v) {
        return doPut(v, insertKey(s));
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V putIfAbsent(short s, V v) {
        int insertKey = insertKey(s);
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

    @Override // gnu.trove.map.TShortObjectMap
    public V remove(short s) {
        int index = index(s);
        if (index < 0) {
            return null;
        }
        V v = this._values[index];
        removeAt(index);
        return v;
    }

    @Override // gnu.trove.impl.hash.TShortHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = null;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public void putAll(Map<? extends Short, ? extends V> map) {
        for (Map.Entry<? extends Short, ? extends V> entry : map.entrySet()) {
            put(entry.getKey().shortValue(), entry.getValue());
        }
    }

    @Override // gnu.trove.map.TShortObjectMap
    public void putAll(TShortObjectMap<? extends V> tShortObjectMap) {
        tShortObjectMap.forEachEntry(this.PUT_ALL_PROC);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
        V[] vArr = this._values;
        Arrays.fill(vArr, 0, vArr.length, (Object) null);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public TShortSet keySet() {
        return new KeyView();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public short[] keys() {
        short[] sArr = new short[size()];
        short[] sArr2 = this._set;
        byte[] bArr = this._states;
        int length = sArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return sArr;
            }
            if (bArr[i2] == 1) {
                sArr[i] = sArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TShortObjectMap
    public short[] keys(short[] sArr) {
        if (sArr.length < this._size) {
            sArr = new short[this._size];
        }
        short[] sArr2 = this._set;
        byte[] bArr = this._states;
        int length = sArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return sArr;
            }
            if (bArr[i2] == 1) {
                sArr[i] = sArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TShortObjectMap
    public Collection<V> valueCollection() {
        return new ValueView();
    }

    @Override // gnu.trove.map.TShortObjectMap
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

    @Override // gnu.trove.map.TShortObjectMap
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

    @Override // gnu.trove.map.TShortObjectMap
    public TShortObjectIterator<V> iterator() {
        return new TShortObjectHashIterator(this);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return forEach(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortObjectMap
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

    @Override // gnu.trove.map.TShortObjectMap
    public boolean forEachEntry(TShortObjectProcedure<? super V> tShortObjectProcedure) {
        byte[] bArr = this._states;
        short[] sArr = this._set;
        V[] vArr = this._values;
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tShortObjectProcedure.execute(sArr[i], vArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean retainEntries(TShortObjectProcedure<? super V> tShortObjectProcedure) {
        byte[] bArr = this._states;
        short[] sArr = this._set;
        V[] vArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = sArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tShortObjectProcedure.execute(sArr[i], vArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TShortObjectMap
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

    @Override // gnu.trove.map.TShortObjectMap
    public boolean equals(Object obj) {
        if (!(obj instanceof TShortObjectMap)) {
            return false;
        }
        TShortObjectMap tShortObjectMap = (TShortObjectMap) obj;
        if (tShortObjectMap.size() != size()) {
            return false;
        }
        try {
            TShortObjectIterator<V> it = iterator();
            while (it.hasNext()) {
                it.advance();
                short key = it.key();
                V value = it.value();
                if (value == null) {
                    if (tShortObjectMap.get(key) != null || !tShortObjectMap.containsKey(key)) {
                        return false;
                    }
                } else if (!value.equals(tShortObjectMap.get(key))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return true;
        }
    }

    @Override // gnu.trove.map.TShortObjectMap
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

    class KeyView implements TShortSet {
        KeyView() {
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public short getNoEntryValue() {
            return TShortObjectHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public int size() {
            return TShortObjectHashMap.this._size;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean isEmpty() {
            return TShortObjectHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean contains(short s) {
            return TShortObjectHashMap.this.containsKey(s);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public TShortIterator iterator() {
            return new TShortHashIterator(TShortObjectHashMap.this);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public short[] toArray() {
            return TShortObjectHashMap.this.keys();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public short[] toArray(short[] sArr) {
            return TShortObjectHashMap.this.keys(sArr);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean add(short s) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean remove(short s) {
            return TShortObjectHashMap.this.remove(s) != null;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!TShortObjectHashMap.this.containsKey(((Short) it.next()).shortValue())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean containsAll(TShortCollection tShortCollection) {
            if (tShortCollection == this) {
                return true;
            }
            TShortIterator it = tShortCollection.iterator();
            while (it.hasNext()) {
                if (!TShortObjectHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean containsAll(short[] sArr) {
            for (short s : sArr) {
                if (!TShortObjectHashMap.this.containsKey(s)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean addAll(Collection<? extends Short> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean addAll(TShortCollection tShortCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean addAll(short[] sArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
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

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
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

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean retainAll(short[] sArr) {
            Arrays.sort(sArr);
            short[] sArr2 = TShortObjectHashMap.this._set;
            byte[] bArr = TShortObjectHashMap.this._states;
            int length = sArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(sArr, sArr2[i]) < 0) {
                    TShortObjectHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Short) && remove(((Short) obj).shortValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean removeAll(TShortCollection tShortCollection) {
            if (tShortCollection == this) {
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

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
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

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public void clear() {
            TShortObjectHashMap.this.clear();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean forEach(TShortProcedure tShortProcedure) {
            return TShortObjectHashMap.this.forEachKey(tShortProcedure);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean equals(Object obj) {
            if (!(obj instanceof TShortSet)) {
                return false;
            }
            TShortSet tShortSet = (TShortSet) obj;
            if (tShortSet.size() != size()) {
                return false;
            }
            int length = TShortObjectHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TShortObjectHashMap.this._states[i] == 1 && !tShortSet.contains(TShortObjectHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public int hashCode() {
            int length = TShortObjectHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TShortObjectHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash((int) TShortObjectHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            int length = TShortObjectHashMap.this._states.length;
            boolean z = true;
            while (true) {
                int i = length - 1;
                if (length > 0) {
                    if (TShortObjectHashMap.this._states[i] == 1) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(",");
                        }
                        sb.append((int) TShortObjectHashMap.this._set[i]);
                    }
                    length = i;
                } else {
                    return sb.toString();
                }
            }
        }

        class TShortHashIterator extends THashPrimitiveIterator implements TShortIterator {
            private final TShortHash _hash;

            public TShortHashIterator(TShortHash tShortHash) {
                super(tShortHash);
                this._hash = tShortHash;
            }

            @Override // gnu.trove.iterator.TShortIterator
            public short next() {
                moveToNextIndex();
                return this._hash._set[this._index];
            }
        }
    }

    protected class ValueView extends TShortObjectHashMap<V>.MapBackedView<V> {
        protected ValueView() {
            super();
        }

        @Override // gnu.trove.map.hash.TShortObjectHashMap.MapBackedView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new TShortObjectHashMap<V>.ValueView.TShortObjectValueHashIterator(TShortObjectHashMap.this) { // from class: gnu.trove.map.hash.TShortObjectHashMap.ValueView.1
                @Override // gnu.trove.map.hash.TShortObjectHashMap.ValueView.TShortObjectValueHashIterator
                protected V objectAtIndex(int i) {
                    return TShortObjectHashMap.this._values[i];
                }
            };
        }

        @Override // gnu.trove.map.hash.TShortObjectHashMap.MapBackedView
        public boolean containsElement(V v) {
            return TShortObjectHashMap.this.containsValue(v);
        }

        @Override // gnu.trove.map.hash.TShortObjectHashMap.MapBackedView
        public boolean removeElement(V v) {
            int i;
            V[] vArr = TShortObjectHashMap.this._values;
            byte[] bArr = TShortObjectHashMap.this._states;
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
            TShortObjectHashMap.this.removeAt(i);
            return true;
        }

        class TShortObjectValueHashIterator extends THashPrimitiveIterator implements Iterator<V> {
            protected final TShortObjectHashMap _map;

            public TShortObjectValueHashIterator(TShortObjectHashMap tShortObjectHashMap) {
                super(tShortObjectHashMap);
                this._map = tShortObjectHashMap;
            }

            protected V objectAtIndex(int i) {
                byte[] bArr = TShortObjectHashMap.this._states;
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
            TShortObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TShortObjectHashMap.this.size();
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
            return TShortObjectHashMap.this.isEmpty();
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

    class TShortObjectHashIterator<V> extends THashPrimitiveIterator implements TShortObjectIterator<V> {
        private final TShortObjectHashMap<V> _map;

        public TShortObjectHashIterator(TShortObjectHashMap<V> tShortObjectHashMap) {
            super(tShortObjectHashMap);
            this._map = tShortObjectHashMap;
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TShortObjectIterator
        public short key() {
            return this._map._set[this._index];
        }

        @Override // gnu.trove.iterator.TShortObjectIterator
        public V value() {
            return this._map._values[this._index];
        }

        @Override // gnu.trove.iterator.TShortObjectIterator
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
        objectOutput.writeShort(this.no_entry_key);
        objectOutput.writeInt(this._size);
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._states[i] == 1) {
                objectOutput.writeShort(this._set[i]);
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
        this.no_entry_key = objectInput.readShort();
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readShort(), objectInput.readObject());
            readInt = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TShortObjectProcedure<V>() { // from class: gnu.trove.map.hash.TShortObjectHashMap.2
            private boolean first = true;

            @Override // gnu.trove.procedure.TShortObjectProcedure
            public boolean execute(short s, Object obj) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(",");
                }
                sb.append((int) s);
                sb.append("=");
                sb.append(obj);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }
}