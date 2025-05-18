package gnu.trove.impl.sync;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TDoubleObjectIterator;
import gnu.trove.map.TDoubleObjectMap;
import gnu.trove.procedure.TDoubleObjectProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedDoubleObjectMap<V> implements TDoubleObjectMap<V>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TDoubleObjectMap<V> f3605m;
    final Object mutex;
    private transient TDoubleSet keySet = null;
    private transient Collection<V> values = null;

    public TSynchronizedDoubleObjectMap(TDoubleObjectMap<V> tDoubleObjectMap) {
        Objects.requireNonNull(tDoubleObjectMap);
        this.f3605m = tDoubleObjectMap;
        this.mutex = this;
    }

    public TSynchronizedDoubleObjectMap(TDoubleObjectMap<V> tDoubleObjectMap, Object obj) {
        this.f3605m = tDoubleObjectMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3605m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3605m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean containsKey(double d) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3605m.containsKey(d);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3605m.containsValue(obj);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public V get(double d) {
        V v;
        synchronized (this.mutex) {
            v = this.f3605m.get(d);
        }
        return v;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public V put(double d, V v) {
        V put;
        synchronized (this.mutex) {
            put = this.f3605m.put(d, v);
        }
        return put;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public V remove(double d) {
        V remove;
        synchronized (this.mutex) {
            remove = this.f3605m.remove(d);
        }
        return remove;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public void putAll(Map<? extends Double, ? extends V> map) {
        synchronized (this.mutex) {
            this.f3605m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public void putAll(TDoubleObjectMap<? extends V> tDoubleObjectMap) {
        synchronized (this.mutex) {
            this.f3605m.putAll(tDoubleObjectMap);
        }
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3605m.clear();
        }
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public TDoubleSet keySet() {
        TDoubleSet tDoubleSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedDoubleSet(this.f3605m.keySet(), this.mutex);
            }
            tDoubleSet = this.keySet;
        }
        return tDoubleSet;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public double[] keys() {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.f3605m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public double[] keys(double[] dArr) {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.f3605m.keys(dArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public Collection<V> valueCollection() {
        Collection<V> collection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new SynchronizedCollection(this.f3605m.valueCollection(), this.mutex);
            }
            collection = this.values;
        }
        return collection;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public Object[] values() {
        Object[] values;
        synchronized (this.mutex) {
            values = this.f3605m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public V[] values(V[] vArr) {
        V[] values;
        synchronized (this.mutex) {
            values = this.f3605m.values(vArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public TDoubleObjectIterator<V> iterator() {
        return this.f3605m.iterator();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public double getNoEntryKey() {
        return this.f3605m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public V putIfAbsent(double d, V v) {
        V putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3605m.putIfAbsent(d, v);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3605m.forEachKey(tDoubleProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3605m.forEachValue(tObjectProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean forEachEntry(TDoubleObjectProcedure<? super V> tDoubleObjectProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3605m.forEachEntry(tDoubleObjectProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        synchronized (this.mutex) {
            this.f3605m.transformValues(tObjectFunction);
        }
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean retainEntries(TDoubleObjectProcedure<? super V> tDoubleObjectProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3605m.retainEntries(tDoubleObjectProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3605m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3605m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3605m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}