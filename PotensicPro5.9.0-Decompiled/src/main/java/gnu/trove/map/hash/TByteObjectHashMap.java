package gnu.trove.map.hash;

import gnu.trove.TByteCollection;
import gnu.trove.function.TObjectFunction;
import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TByteHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.iterator.TByteObjectIterator;
import gnu.trove.map.TByteObjectMap;
import gnu.trove.procedure.TByteObjectProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TByteSet;
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
public class TByteObjectHashMap<V> extends TByteHash implements TByteObjectMap<V>, Externalizable {
    static final long serialVersionUID = 1;
    private final TByteObjectProcedure<V> PUT_ALL_PROC;
    protected transient V[] _values;
    protected byte no_entry_key;

    public TByteObjectHashMap() {
        this.PUT_ALL_PROC = new TByteObjectProcedure<V>() { // from class: gnu.trove.map.hash.TByteObjectHashMap.1
            @Override // gnu.trove.procedure.TByteObjectProcedure
            public boolean execute(byte b, V v) {
                TByteObjectHashMap.this.put(b, v);
                return true;
            }
        };
    }

    public TByteObjectHashMap(int i) {
        super(i);
        this.PUT_ALL_PROC = new TByteObjectProcedure<V>() { // from class: gnu.trove.map.hash.TByteObjectHashMap.1
            @Override // gnu.trove.procedure.TByteObjectProcedure
            public boolean execute(byte b, V v) {
                TByteObjectHashMap.this.put(b, v);
                return true;
            }
        };
        this.no_entry_key = Constants.DEFAULT_BYTE_NO_ENTRY_VALUE;
    }

    public TByteObjectHashMap(int i, float f) {
        super(i, f);
        this.PUT_ALL_PROC = new TByteObjectProcedure<V>() { // from class: gnu.trove.map.hash.TByteObjectHashMap.1
            @Override // gnu.trove.procedure.TByteObjectProcedure
            public boolean execute(byte b, V v) {
                TByteObjectHashMap.this.put(b, v);
                return true;
            }
        };
        this.no_entry_key = Constants.DEFAULT_BYTE_NO_ENTRY_VALUE;
    }

    public TByteObjectHashMap(int i, float f, byte b) {
        super(i, f);
        this.PUT_ALL_PROC = new TByteObjectProcedure<V>() { // from class: gnu.trove.map.hash.TByteObjectHashMap.1
            @Override // gnu.trove.procedure.TByteObjectProcedure
            public boolean execute(byte b2, V v) {
                TByteObjectHashMap.this.put(b2, v);
                return true;
            }
        };
        this.no_entry_key = b;
    }

    public TByteObjectHashMap(TByteObjectMap<? extends V> tByteObjectMap) {
        this(tByteObjectMap.size(), 0.5f, tByteObjectMap.getNoEntryKey());
        putAll(tByteObjectMap);
    }

    @Override // gnu.trove.impl.hash.TByteHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = (V[]) new Object[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        byte[] bArr = this._set;
        V[] vArr = this._values;
        byte[] bArr2 = this._states;
        this._set = new byte[i];
        this._values = (V[]) new Object[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr2[i2] == 1) {
                this._values[insertKey(bArr[i2])] = vArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteObjectMap
    public byte getNoEntryKey() {
        return this.no_entry_key;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean containsKey(byte b) {
        return contains(b);
    }

    @Override // gnu.trove.map.TByteObjectMap
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

    @Override // gnu.trove.map.TByteObjectMap
    public V get(byte b) {
        int index = index(b);
        if (index < 0) {
            return null;
        }
        return this._values[index];
    }

    @Override // gnu.trove.map.TByteObjectMap
    public V put(byte b, V v) {
        return doPut(v, insertKey(b));
    }

    @Override // gnu.trove.map.TByteObjectMap
    public V putIfAbsent(byte b, V v) {
        int insertKey = insertKey(b);
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

    @Override // gnu.trove.map.TByteObjectMap
    public V remove(byte b) {
        int index = index(b);
        if (index < 0) {
            return null;
        }
        V v = this._values[index];
        removeAt(index);
        return v;
    }

    @Override // gnu.trove.impl.hash.TByteHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = null;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TByteObjectMap
    public void putAll(Map<? extends Byte, ? extends V> map) {
        for (Map.Entry<? extends Byte, ? extends V> entry : map.entrySet()) {
            put(entry.getKey().byteValue(), entry.getValue());
        }
    }

    @Override // gnu.trove.map.TByteObjectMap
    public void putAll(TByteObjectMap<? extends V> tByteObjectMap) {
        tByteObjectMap.forEachEntry(this.PUT_ALL_PROC);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
        V[] vArr = this._values;
        Arrays.fill(vArr, 0, vArr.length, (Object) null);
    }

    @Override // gnu.trove.map.TByteObjectMap
    public TByteSet keySet() {
        return new KeyView();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public byte[] keys() {
        byte[] bArr = new byte[size()];
        byte[] bArr2 = this._set;
        byte[] bArr3 = this._states;
        int length = bArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return bArr;
            }
            if (bArr3[i2] == 1) {
                bArr[i] = bArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteObjectMap
    public byte[] keys(byte[] bArr) {
        if (bArr.length < this._size) {
            bArr = new byte[this._size];
        }
        byte[] bArr2 = this._set;
        byte[] bArr3 = this._states;
        int length = bArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return bArr;
            }
            if (bArr3[i2] == 1) {
                bArr[i] = bArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteObjectMap
    public Collection<V> valueCollection() {
        return new ValueView();
    }

    @Override // gnu.trove.map.TByteObjectMap
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

    @Override // gnu.trove.map.TByteObjectMap
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

    @Override // gnu.trove.map.TByteObjectMap
    public TByteObjectIterator<V> iterator() {
        return new TByteObjectHashIterator(this);
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return forEach(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteObjectMap
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

    @Override // gnu.trove.map.TByteObjectMap
    public boolean forEachEntry(TByteObjectProcedure<? super V> tByteObjectProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        V[] vArr = this._values;
        int length = bArr2.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tByteObjectProcedure.execute(bArr2[i], vArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean retainEntries(TByteObjectProcedure<? super V> tByteObjectProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        V[] vArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tByteObjectProcedure.execute(bArr2[i], vArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TByteObjectMap
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

    @Override // gnu.trove.map.TByteObjectMap
    public boolean equals(Object obj) {
        if (!(obj instanceof TByteObjectMap)) {
            return false;
        }
        TByteObjectMap tByteObjectMap = (TByteObjectMap) obj;
        if (tByteObjectMap.size() != size()) {
            return false;
        }
        try {
            TByteObjectIterator<V> it = iterator();
            while (it.hasNext()) {
                it.advance();
                byte key = it.key();
                V value = it.value();
                if (value == null) {
                    if (tByteObjectMap.get(key) != null || !tByteObjectMap.containsKey(key)) {
                        return false;
                    }
                } else if (!value.equals(tByteObjectMap.get(key))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return true;
        }
    }

    @Override // gnu.trove.map.TByteObjectMap
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

    class KeyView implements TByteSet {
        KeyView() {
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte getNoEntryValue() {
            return TByteObjectHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public int size() {
            return TByteObjectHashMap.this._size;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean isEmpty() {
            return TByteObjectHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean contains(byte b) {
            return TByteObjectHashMap.this.containsKey(b);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public TByteIterator iterator() {
            return new TByteHashIterator(TByteObjectHashMap.this);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte[] toArray() {
            return TByteObjectHashMap.this.keys();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte[] toArray(byte[] bArr) {
            return TByteObjectHashMap.this.keys(bArr);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean add(byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean remove(byte b) {
            return TByteObjectHashMap.this.remove(b) != null;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!TByteObjectHashMap.this.containsKey(((Byte) it.next()).byteValue())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(TByteCollection tByteCollection) {
            if (tByteCollection == this) {
                return true;
            }
            TByteIterator it = tByteCollection.iterator();
            while (it.hasNext()) {
                if (!TByteObjectHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(byte[] bArr) {
            for (byte b : bArr) {
                if (!TByteObjectHashMap.this.containsKey(b)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean addAll(Collection<? extends Byte> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean addAll(TByteCollection tByteCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean addAll(byte[] bArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
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

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
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

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean retainAll(byte[] bArr) {
            Arrays.sort(bArr);
            byte[] bArr2 = TByteObjectHashMap.this._set;
            byte[] bArr3 = TByteObjectHashMap.this._states;
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr3[i] == 1 && Arrays.binarySearch(bArr, bArr2[i]) < 0) {
                    TByteObjectHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Byte) && remove(((Byte) obj).byteValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean removeAll(TByteCollection tByteCollection) {
            if (tByteCollection == this) {
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

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
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

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public void clear() {
            TByteObjectHashMap.this.clear();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean forEach(TByteProcedure tByteProcedure) {
            return TByteObjectHashMap.this.forEachKey(tByteProcedure);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean equals(Object obj) {
            if (!(obj instanceof TByteSet)) {
                return false;
            }
            TByteSet tByteSet = (TByteSet) obj;
            if (tByteSet.size() != size()) {
                return false;
            }
            int length = TByteObjectHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TByteObjectHashMap.this._states[i] == 1 && !tByteSet.contains(TByteObjectHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public int hashCode() {
            int length = TByteObjectHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TByteObjectHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash((int) TByteObjectHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            int length = TByteObjectHashMap.this._states.length;
            boolean z = true;
            while (true) {
                int i = length - 1;
                if (length > 0) {
                    if (TByteObjectHashMap.this._states[i] == 1) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(",");
                        }
                        sb.append((int) TByteObjectHashMap.this._set[i]);
                    }
                    length = i;
                } else {
                    return sb.toString();
                }
            }
        }

        class TByteHashIterator extends THashPrimitiveIterator implements TByteIterator {
            private final TByteHash _hash;

            public TByteHashIterator(TByteHash tByteHash) {
                super(tByteHash);
                this._hash = tByteHash;
            }

            @Override // gnu.trove.iterator.TByteIterator
            public byte next() {
                moveToNextIndex();
                return this._hash._set[this._index];
            }
        }
    }

    protected class ValueView extends TByteObjectHashMap<V>.MapBackedView<V> {
        protected ValueView() {
            super();
        }

        @Override // gnu.trove.map.hash.TByteObjectHashMap.MapBackedView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new TByteObjectHashMap<V>.ValueView.TByteObjectValueHashIterator(TByteObjectHashMap.this) { // from class: gnu.trove.map.hash.TByteObjectHashMap.ValueView.1
                @Override // gnu.trove.map.hash.TByteObjectHashMap.ValueView.TByteObjectValueHashIterator
                protected V objectAtIndex(int i) {
                    return TByteObjectHashMap.this._values[i];
                }
            };
        }

        @Override // gnu.trove.map.hash.TByteObjectHashMap.MapBackedView
        public boolean containsElement(V v) {
            return TByteObjectHashMap.this.containsValue(v);
        }

        @Override // gnu.trove.map.hash.TByteObjectHashMap.MapBackedView
        public boolean removeElement(V v) {
            int i;
            V[] vArr = TByteObjectHashMap.this._values;
            byte[] bArr = TByteObjectHashMap.this._states;
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
            TByteObjectHashMap.this.removeAt(i);
            return true;
        }

        class TByteObjectValueHashIterator extends THashPrimitiveIterator implements Iterator<V> {
            protected final TByteObjectHashMap _map;

            public TByteObjectValueHashIterator(TByteObjectHashMap tByteObjectHashMap) {
                super(tByteObjectHashMap);
                this._map = tByteObjectHashMap;
            }

            protected V objectAtIndex(int i) {
                byte[] bArr = TByteObjectHashMap.this._states;
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
            TByteObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TByteObjectHashMap.this.size();
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
            return TByteObjectHashMap.this.isEmpty();
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

    class TByteObjectHashIterator<V> extends THashPrimitiveIterator implements TByteObjectIterator<V> {
        private final TByteObjectHashMap<V> _map;

        public TByteObjectHashIterator(TByteObjectHashMap<V> tByteObjectHashMap) {
            super(tByteObjectHashMap);
            this._map = tByteObjectHashMap;
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TByteObjectIterator
        public byte key() {
            return this._map._set[this._index];
        }

        @Override // gnu.trove.iterator.TByteObjectIterator
        public V value() {
            return this._map._values[this._index];
        }

        @Override // gnu.trove.iterator.TByteObjectIterator
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
        objectOutput.writeByte(this.no_entry_key);
        objectOutput.writeInt(this._size);
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._states[i] == 1) {
                objectOutput.writeByte(this._set[i]);
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
        this.no_entry_key = objectInput.readByte();
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readByte(), objectInput.readObject());
            readInt = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TByteObjectProcedure<V>() { // from class: gnu.trove.map.hash.TByteObjectHashMap.2
            private boolean first = true;

            @Override // gnu.trove.procedure.TByteObjectProcedure
            public boolean execute(byte b, Object obj) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(",");
                }
                sb.append((int) b);
                sb.append("=");
                sb.append(obj);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }
}
