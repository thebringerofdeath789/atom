package gnu.trove.map.hash;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TObjectFunction;
import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TFloatHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.iterator.TFloatObjectIterator;
import gnu.trove.map.TFloatObjectMap;
import gnu.trove.procedure.TFloatObjectProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TFloatSet;
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
public class TFloatObjectHashMap<V> extends TFloatHash implements TFloatObjectMap<V>, Externalizable {
    static final long serialVersionUID = 1;
    private final TFloatObjectProcedure<V> PUT_ALL_PROC;
    protected transient V[] _values;
    protected float no_entry_key;

    public TFloatObjectHashMap() {
        this.PUT_ALL_PROC = new TFloatObjectProcedure<V>() { // from class: gnu.trove.map.hash.TFloatObjectHashMap.1
            @Override // gnu.trove.procedure.TFloatObjectProcedure
            public boolean execute(float f, V v) {
                TFloatObjectHashMap.this.put(f, v);
                return true;
            }
        };
    }

    public TFloatObjectHashMap(int i) {
        super(i);
        this.PUT_ALL_PROC = new TFloatObjectProcedure<V>() { // from class: gnu.trove.map.hash.TFloatObjectHashMap.1
            @Override // gnu.trove.procedure.TFloatObjectProcedure
            public boolean execute(float f, V v) {
                TFloatObjectHashMap.this.put(f, v);
                return true;
            }
        };
        this.no_entry_key = Constants.DEFAULT_FLOAT_NO_ENTRY_VALUE;
    }

    public TFloatObjectHashMap(int i, float f) {
        super(i, f);
        this.PUT_ALL_PROC = new TFloatObjectProcedure<V>() { // from class: gnu.trove.map.hash.TFloatObjectHashMap.1
            @Override // gnu.trove.procedure.TFloatObjectProcedure
            public boolean execute(float f2, V v) {
                TFloatObjectHashMap.this.put(f2, v);
                return true;
            }
        };
        this.no_entry_key = Constants.DEFAULT_FLOAT_NO_ENTRY_VALUE;
    }

    public TFloatObjectHashMap(int i, float f, float f2) {
        super(i, f);
        this.PUT_ALL_PROC = new TFloatObjectProcedure<V>() { // from class: gnu.trove.map.hash.TFloatObjectHashMap.1
            @Override // gnu.trove.procedure.TFloatObjectProcedure
            public boolean execute(float f22, V v) {
                TFloatObjectHashMap.this.put(f22, v);
                return true;
            }
        };
        this.no_entry_key = f2;
    }

    public TFloatObjectHashMap(TFloatObjectMap<? extends V> tFloatObjectMap) {
        this(tFloatObjectMap.size(), 0.5f, tFloatObjectMap.getNoEntryKey());
        putAll(tFloatObjectMap);
    }

    @Override // gnu.trove.impl.hash.TFloatHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = (V[]) new Object[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        float[] fArr = this._set;
        V[] vArr = this._values;
        byte[] bArr = this._states;
        this._set = new float[i];
        this._values = (V[]) new Object[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(fArr[i2])] = vArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public float getNoEntryKey() {
        return this.no_entry_key;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean containsKey(float f) {
        return contains(f);
    }

    @Override // gnu.trove.map.TFloatObjectMap
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

    @Override // gnu.trove.map.TFloatObjectMap
    public V get(float f) {
        int index = index(f);
        if (index < 0) {
            return null;
        }
        return this._values[index];
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V put(float f, V v) {
        return doPut(v, insertKey(f));
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V putIfAbsent(float f, V v) {
        int insertKey = insertKey(f);
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

    @Override // gnu.trove.map.TFloatObjectMap
    public V remove(float f) {
        int index = index(f);
        if (index < 0) {
            return null;
        }
        V v = this._values[index];
        removeAt(index);
        return v;
    }

    @Override // gnu.trove.impl.hash.TFloatHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = null;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public void putAll(Map<? extends Float, ? extends V> map) {
        for (Map.Entry<? extends Float, ? extends V> entry : map.entrySet()) {
            put(entry.getKey().floatValue(), entry.getValue());
        }
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public void putAll(TFloatObjectMap<? extends V> tFloatObjectMap) {
        tFloatObjectMap.forEachEntry(this.PUT_ALL_PROC);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
        V[] vArr = this._values;
        Arrays.fill(vArr, 0, vArr.length, (Object) null);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public TFloatSet keySet() {
        return new KeyView();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public float[] keys() {
        float[] fArr = new float[size()];
        float[] fArr2 = this._set;
        byte[] bArr = this._states;
        int length = fArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return fArr;
            }
            if (bArr[i2] == 1) {
                fArr[i] = fArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public float[] keys(float[] fArr) {
        if (fArr.length < this._size) {
            fArr = new float[this._size];
        }
        float[] fArr2 = this._set;
        byte[] bArr = this._states;
        int length = fArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return fArr;
            }
            if (bArr[i2] == 1) {
                fArr[i] = fArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public Collection<V> valueCollection() {
        return new ValueView();
    }

    @Override // gnu.trove.map.TFloatObjectMap
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

    @Override // gnu.trove.map.TFloatObjectMap
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

    @Override // gnu.trove.map.TFloatObjectMap
    public TFloatObjectIterator<V> iterator() {
        return new TFloatObjectHashIterator(this);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return forEach(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatObjectMap
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

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean forEachEntry(TFloatObjectProcedure<? super V> tFloatObjectProcedure) {
        byte[] bArr = this._states;
        float[] fArr = this._set;
        V[] vArr = this._values;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tFloatObjectProcedure.execute(fArr[i], vArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean retainEntries(TFloatObjectProcedure<? super V> tFloatObjectProcedure) {
        byte[] bArr = this._states;
        float[] fArr = this._set;
        V[] vArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = fArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tFloatObjectProcedure.execute(fArr[i], vArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TFloatObjectMap
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

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean equals(Object obj) {
        if (!(obj instanceof TFloatObjectMap)) {
            return false;
        }
        TFloatObjectMap tFloatObjectMap = (TFloatObjectMap) obj;
        if (tFloatObjectMap.size() != size()) {
            return false;
        }
        try {
            TFloatObjectIterator<V> it = iterator();
            while (it.hasNext()) {
                it.advance();
                float key = it.key();
                V value = it.value();
                if (value == null) {
                    if (tFloatObjectMap.get(key) != null || !tFloatObjectMap.containsKey(key)) {
                        return false;
                    }
                } else if (!value.equals(tFloatObjectMap.get(key))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return true;
        }
    }

    @Override // gnu.trove.map.TFloatObjectMap
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

    class KeyView implements TFloatSet {
        KeyView() {
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float getNoEntryValue() {
            return TFloatObjectHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public int size() {
            return TFloatObjectHashMap.this._size;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean isEmpty() {
            return TFloatObjectHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean contains(float f) {
            return TFloatObjectHashMap.this.containsKey(f);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public TFloatIterator iterator() {
            return new TFloatHashIterator(TFloatObjectHashMap.this);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float[] toArray() {
            return TFloatObjectHashMap.this.keys();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float[] toArray(float[] fArr) {
            return TFloatObjectHashMap.this.keys(fArr);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean add(float f) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean remove(float f) {
            return TFloatObjectHashMap.this.remove(f) != null;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!TFloatObjectHashMap.this.containsKey(((Float) it.next()).floatValue())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean containsAll(TFloatCollection tFloatCollection) {
            if (tFloatCollection == this) {
                return true;
            }
            TFloatIterator it = tFloatCollection.iterator();
            while (it.hasNext()) {
                if (!TFloatObjectHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean containsAll(float[] fArr) {
            for (float f : fArr) {
                if (!TFloatObjectHashMap.this.containsKey(f)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean addAll(Collection<? extends Float> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean addAll(TFloatCollection tFloatCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean addAll(float[] fArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
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

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
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

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean retainAll(float[] fArr) {
            Arrays.sort(fArr);
            float[] fArr2 = TFloatObjectHashMap.this._set;
            byte[] bArr = TFloatObjectHashMap.this._states;
            int length = fArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(fArr, fArr2[i]) < 0) {
                    TFloatObjectHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Float) && remove(((Float) obj).floatValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean removeAll(TFloatCollection tFloatCollection) {
            if (tFloatCollection == this) {
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

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
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

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public void clear() {
            TFloatObjectHashMap.this.clear();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean forEach(TFloatProcedure tFloatProcedure) {
            return TFloatObjectHashMap.this.forEachKey(tFloatProcedure);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean equals(Object obj) {
            if (!(obj instanceof TFloatSet)) {
                return false;
            }
            TFloatSet tFloatSet = (TFloatSet) obj;
            if (tFloatSet.size() != size()) {
                return false;
            }
            int length = TFloatObjectHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TFloatObjectHashMap.this._states[i] == 1 && !tFloatSet.contains(TFloatObjectHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public int hashCode() {
            int length = TFloatObjectHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TFloatObjectHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TFloatObjectHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            int length = TFloatObjectHashMap.this._states.length;
            boolean z = true;
            while (true) {
                int i = length - 1;
                if (length > 0) {
                    if (TFloatObjectHashMap.this._states[i] == 1) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(",");
                        }
                        sb.append(TFloatObjectHashMap.this._set[i]);
                    }
                    length = i;
                } else {
                    return sb.toString();
                }
            }
        }

        class TFloatHashIterator extends THashPrimitiveIterator implements TFloatIterator {
            private final TFloatHash _hash;

            public TFloatHashIterator(TFloatHash tFloatHash) {
                super(tFloatHash);
                this._hash = tFloatHash;
            }

            @Override // gnu.trove.iterator.TFloatIterator
            public float next() {
                moveToNextIndex();
                return this._hash._set[this._index];
            }
        }
    }

    protected class ValueView extends TFloatObjectHashMap<V>.MapBackedView<V> {
        protected ValueView() {
            super();
        }

        @Override // gnu.trove.map.hash.TFloatObjectHashMap.MapBackedView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new TFloatObjectHashMap<V>.ValueView.TFloatObjectValueHashIterator(TFloatObjectHashMap.this) { // from class: gnu.trove.map.hash.TFloatObjectHashMap.ValueView.1
                @Override // gnu.trove.map.hash.TFloatObjectHashMap.ValueView.TFloatObjectValueHashIterator
                protected V objectAtIndex(int i) {
                    return TFloatObjectHashMap.this._values[i];
                }
            };
        }

        @Override // gnu.trove.map.hash.TFloatObjectHashMap.MapBackedView
        public boolean containsElement(V v) {
            return TFloatObjectHashMap.this.containsValue(v);
        }

        @Override // gnu.trove.map.hash.TFloatObjectHashMap.MapBackedView
        public boolean removeElement(V v) {
            int i;
            V[] vArr = TFloatObjectHashMap.this._values;
            byte[] bArr = TFloatObjectHashMap.this._states;
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
            TFloatObjectHashMap.this.removeAt(i);
            return true;
        }

        class TFloatObjectValueHashIterator extends THashPrimitiveIterator implements Iterator<V> {
            protected final TFloatObjectHashMap _map;

            public TFloatObjectValueHashIterator(TFloatObjectHashMap tFloatObjectHashMap) {
                super(tFloatObjectHashMap);
                this._map = tFloatObjectHashMap;
            }

            protected V objectAtIndex(int i) {
                byte[] bArr = TFloatObjectHashMap.this._states;
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
            TFloatObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TFloatObjectHashMap.this.size();
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
            return TFloatObjectHashMap.this.isEmpty();
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

    class TFloatObjectHashIterator<V> extends THashPrimitiveIterator implements TFloatObjectIterator<V> {
        private final TFloatObjectHashMap<V> _map;

        public TFloatObjectHashIterator(TFloatObjectHashMap<V> tFloatObjectHashMap) {
            super(tFloatObjectHashMap);
            this._map = tFloatObjectHashMap;
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TFloatObjectIterator
        public float key() {
            return this._map._set[this._index];
        }

        @Override // gnu.trove.iterator.TFloatObjectIterator
        public V value() {
            return this._map._values[this._index];
        }

        @Override // gnu.trove.iterator.TFloatObjectIterator
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
        objectOutput.writeFloat(this.no_entry_key);
        objectOutput.writeInt(this._size);
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._states[i] == 1) {
                objectOutput.writeFloat(this._set[i]);
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
        this.no_entry_key = objectInput.readFloat();
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readFloat(), objectInput.readObject());
            readInt = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TFloatObjectProcedure<V>() { // from class: gnu.trove.map.hash.TFloatObjectHashMap.2
            private boolean first = true;

            @Override // gnu.trove.procedure.TFloatObjectProcedure
            public boolean execute(float f, Object obj) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(",");
                }
                sb.append(f);
                sb.append("=");
                sb.append(obj);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }
}