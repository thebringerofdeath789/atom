package gnu.trove.impl.sync;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TLongObjectIterator;
import gnu.trove.map.TLongObjectMap;
import gnu.trove.procedure.TLongObjectProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TLongSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedLongObjectMap<V> implements TLongObjectMap<V>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TLongObjectMap<V> f3632m;
    final Object mutex;
    private transient TLongSet keySet = null;
    private transient Collection<V> values = null;

    public TSynchronizedLongObjectMap(TLongObjectMap<V> tLongObjectMap) {
        Objects.requireNonNull(tLongObjectMap);
        this.f3632m = tLongObjectMap;
        this.mutex = this;
    }

    public TSynchronizedLongObjectMap(TLongObjectMap<V> tLongObjectMap, Object obj) {
        this.f3632m = tLongObjectMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3632m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3632m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean containsKey(long j) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3632m.containsKey(j);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3632m.containsValue(obj);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public V get(long j) {
        V v;
        synchronized (this.mutex) {
            v = this.f3632m.get(j);
        }
        return v;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public V put(long j, V v) {
        V put;
        synchronized (this.mutex) {
            put = this.f3632m.put(j, v);
        }
        return put;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public V remove(long j) {
        V remove;
        synchronized (this.mutex) {
            remove = this.f3632m.remove(j);
        }
        return remove;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public void putAll(Map<? extends Long, ? extends V> map) {
        synchronized (this.mutex) {
            this.f3632m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public void putAll(TLongObjectMap<? extends V> tLongObjectMap) {
        synchronized (this.mutex) {
            this.f3632m.putAll(tLongObjectMap);
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3632m.clear();
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public TLongSet keySet() {
        TLongSet tLongSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedLongSet(this.f3632m.keySet(), this.mutex);
            }
            tLongSet = this.keySet;
        }
        return tLongSet;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public long[] keys() {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.f3632m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public long[] keys(long[] jArr) {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.f3632m.keys(jArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public Collection<V> valueCollection() {
        Collection<V> collection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new SynchronizedCollection(this.f3632m.valueCollection(), this.mutex);
            }
            collection = this.values;
        }
        return collection;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public Object[] values() {
        Object[] values;
        synchronized (this.mutex) {
            values = this.f3632m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public V[] values(V[] vArr) {
        V[] values;
        synchronized (this.mutex) {
            values = this.f3632m.values(vArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public TLongObjectIterator<V> iterator() {
        return this.f3632m.iterator();
    }

    @Override // gnu.trove.map.TLongObjectMap
    public long getNoEntryKey() {
        return this.f3632m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongObjectMap
    public V putIfAbsent(long j, V v) {
        V putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3632m.putIfAbsent(j, v);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3632m.forEachKey(tLongProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3632m.forEachValue(tObjectProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean forEachEntry(TLongObjectProcedure<? super V> tLongObjectProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3632m.forEachEntry(tLongObjectProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        synchronized (this.mutex) {
            this.f3632m.transformValues(tObjectFunction);
        }
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean retainEntries(TLongObjectProcedure<? super V> tLongObjectProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3632m.retainEntries(tLongObjectProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3632m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TLongObjectMap
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3632m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3632m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}