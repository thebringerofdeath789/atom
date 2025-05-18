package gnu.trove.impl.sync;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TIntObjectIterator;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.procedure.TIntObjectProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TIntSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedIntObjectMap<V> implements TIntObjectMap<V>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TIntObjectMap<V> f3623m;
    final Object mutex;
    private transient TIntSet keySet = null;
    private transient Collection<V> values = null;

    public TSynchronizedIntObjectMap(TIntObjectMap<V> tIntObjectMap) {
        Objects.requireNonNull(tIntObjectMap);
        this.f3623m = tIntObjectMap;
        this.mutex = this;
    }

    public TSynchronizedIntObjectMap(TIntObjectMap<V> tIntObjectMap, Object obj) {
        this.f3623m = tIntObjectMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3623m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3623m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean containsKey(int i) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3623m.containsKey(i);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3623m.containsValue(obj);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V get(int i) {
        V v;
        synchronized (this.mutex) {
            v = this.f3623m.get(i);
        }
        return v;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V put(int i, V v) {
        V put;
        synchronized (this.mutex) {
            put = this.f3623m.put(i, v);
        }
        return put;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V remove(int i) {
        V remove;
        synchronized (this.mutex) {
            remove = this.f3623m.remove(i);
        }
        return remove;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public void putAll(Map<? extends Integer, ? extends V> map) {
        synchronized (this.mutex) {
            this.f3623m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TIntObjectMap
    public void putAll(TIntObjectMap<? extends V> tIntObjectMap) {
        synchronized (this.mutex) {
            this.f3623m.putAll(tIntObjectMap);
        }
    }

    @Override // gnu.trove.map.TIntObjectMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3623m.clear();
        }
    }

    @Override // gnu.trove.map.TIntObjectMap
    public TIntSet keySet() {
        TIntSet tIntSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedIntSet(this.f3623m.keySet(), this.mutex);
            }
            tIntSet = this.keySet;
        }
        return tIntSet;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int[] keys() {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3623m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int[] keys(int[] iArr) {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3623m.keys(iArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public Collection<V> valueCollection() {
        Collection<V> collection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new SynchronizedCollection(this.f3623m.valueCollection(), this.mutex);
            }
            collection = this.values;
        }
        return collection;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public Object[] values() {
        Object[] values;
        synchronized (this.mutex) {
            values = this.f3623m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V[] values(V[] vArr) {
        V[] values;
        synchronized (this.mutex) {
            values = this.f3623m.values(vArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public TIntObjectIterator<V> iterator() {
        return this.f3623m.iterator();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int getNoEntryKey() {
        return this.f3623m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V putIfAbsent(int i, V v) {
        V putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3623m.putIfAbsent(i, v);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3623m.forEachKey(tIntProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3623m.forEachValue(tObjectProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean forEachEntry(TIntObjectProcedure<? super V> tIntObjectProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3623m.forEachEntry(tIntObjectProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        synchronized (this.mutex) {
            this.f3623m.transformValues(tObjectFunction);
        }
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean retainEntries(TIntObjectProcedure<? super V> tIntObjectProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3623m.retainEntries(tIntObjectProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3623m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3623m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3623m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}