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
    private final TIntObjectMap<V> m;
    final Object mutex;
    private transient TIntSet keySet = null;
    private transient Collection<V> values = null;

    public TSynchronizedIntObjectMap(TIntObjectMap<V> tIntObjectMap) {
        Objects.requireNonNull(tIntObjectMap);
        this.m = tIntObjectMap;
        this.mutex = this;
    }

    public TSynchronizedIntObjectMap(TIntObjectMap<V> tIntObjectMap, Object obj) {
        this.m = tIntObjectMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean containsKey(int i) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(i);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(obj);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V get(int i) {
        V v;
        synchronized (this.mutex) {
            v = this.m.get(i);
        }
        return v;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V put(int i, V v) {
        V put;
        synchronized (this.mutex) {
            put = this.m.put(i, v);
        }
        return put;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V remove(int i) {
        V remove;
        synchronized (this.mutex) {
            remove = this.m.remove(i);
        }
        return remove;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public void putAll(Map<? extends Integer, ? extends V> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TIntObjectMap
    public void putAll(TIntObjectMap<? extends V> tIntObjectMap) {
        synchronized (this.mutex) {
            this.m.putAll(tIntObjectMap);
        }
    }

    @Override // gnu.trove.map.TIntObjectMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TIntObjectMap
    public TIntSet keySet() {
        TIntSet tIntSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedIntSet(this.m.keySet(), this.mutex);
            }
            tIntSet = this.keySet;
        }
        return tIntSet;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int[] keys() {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int[] keys(int[] iArr) {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(iArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public Collection<V> valueCollection() {
        Collection<V> collection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new SynchronizedCollection(this.m.valueCollection(), this.mutex);
            }
            collection = this.values;
        }
        return collection;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public Object[] values() {
        Object[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V[] values(V[] vArr) {
        V[] values;
        synchronized (this.mutex) {
            values = this.m.values(vArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public TIntObjectIterator<V> iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V putIfAbsent(int i, V v) {
        V putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(i, v);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tIntProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tObjectProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean forEachEntry(TIntObjectProcedure<? super V> tIntObjectProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tIntObjectProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tObjectFunction);
        }
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean retainEntries(TIntObjectProcedure<? super V> tIntObjectProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tIntObjectProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}
