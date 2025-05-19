package gnu.trove.impl.sync;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TFloatObjectIterator;
import gnu.trove.map.TFloatObjectMap;
import gnu.trove.procedure.TFloatObjectProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TFloatSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedFloatObjectMap<V> implements TFloatObjectMap<V>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TFloatObjectMap<V> m;
    final Object mutex;
    private transient TFloatSet keySet = null;
    private transient Collection<V> values = null;

    public TSynchronizedFloatObjectMap(TFloatObjectMap<V> tFloatObjectMap) {
        Objects.requireNonNull(tFloatObjectMap);
        this.m = tFloatObjectMap;
        this.mutex = this;
    }

    public TSynchronizedFloatObjectMap(TFloatObjectMap<V> tFloatObjectMap, Object obj) {
        this.m = tFloatObjectMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean containsKey(float f) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(f);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(obj);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V get(float f) {
        V v;
        synchronized (this.mutex) {
            v = this.m.get(f);
        }
        return v;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V put(float f, V v) {
        V put;
        synchronized (this.mutex) {
            put = this.m.put(f, v);
        }
        return put;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V remove(float f) {
        V remove;
        synchronized (this.mutex) {
            remove = this.m.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public void putAll(Map<? extends Float, ? extends V> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public void putAll(TFloatObjectMap<? extends V> tFloatObjectMap) {
        synchronized (this.mutex) {
            this.m.putAll(tFloatObjectMap);
        }
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public TFloatSet keySet() {
        TFloatSet tFloatSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedFloatSet(this.m.keySet(), this.mutex);
            }
            tFloatSet = this.keySet;
        }
        return tFloatSet;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public float[] keys() {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public float[] keys(float[] fArr) {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(fArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatObjectMap
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

    @Override // gnu.trove.map.TFloatObjectMap
    public Object[] values() {
        Object[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V[] values(V[] vArr) {
        V[] values;
        synchronized (this.mutex) {
            values = this.m.values(vArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public TFloatObjectIterator<V> iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public float getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V putIfAbsent(float f, V v) {
        V putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(f, v);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tFloatProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tObjectProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean forEachEntry(TFloatObjectProcedure<? super V> tFloatObjectProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tFloatObjectProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tObjectFunction);
        }
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean retainEntries(TFloatObjectProcedure<? super V> tFloatObjectProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tFloatObjectProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TFloatObjectMap
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
