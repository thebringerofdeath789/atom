package gnu.trove.impl.sync;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TShortObjectIterator;
import gnu.trove.map.TShortObjectMap;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.procedure.TShortObjectProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedShortObjectMap<V> implements TShortObjectMap<V>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TShortObjectMap<V> m;
    final Object mutex;
    private transient TShortSet keySet = null;
    private transient Collection<V> values = null;

    public TSynchronizedShortObjectMap(TShortObjectMap<V> tShortObjectMap) {
        Objects.requireNonNull(tShortObjectMap);
        this.m = tShortObjectMap;
        this.mutex = this;
    }

    public TSynchronizedShortObjectMap(TShortObjectMap<V> tShortObjectMap, Object obj) {
        this.m = tShortObjectMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean containsKey(short s) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(s);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(obj);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V get(short s) {
        V v;
        synchronized (this.mutex) {
            v = this.m.get(s);
        }
        return v;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V put(short s, V v) {
        V put;
        synchronized (this.mutex) {
            put = this.m.put(s, v);
        }
        return put;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V remove(short s) {
        V remove;
        synchronized (this.mutex) {
            remove = this.m.remove(s);
        }
        return remove;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public void putAll(Map<? extends Short, ? extends V> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TShortObjectMap
    public void putAll(TShortObjectMap<? extends V> tShortObjectMap) {
        synchronized (this.mutex) {
            this.m.putAll(tShortObjectMap);
        }
    }

    @Override // gnu.trove.map.TShortObjectMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TShortObjectMap
    public TShortSet keySet() {
        TShortSet tShortSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedShortSet(this.m.keySet(), this.mutex);
            }
            tShortSet = this.keySet;
        }
        return tShortSet;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public short[] keys() {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public short[] keys(short[] sArr) {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(sArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortObjectMap
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

    @Override // gnu.trove.map.TShortObjectMap
    public Object[] values() {
        Object[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V[] values(V[] vArr) {
        V[] values;
        synchronized (this.mutex) {
            values = this.m.values(vArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public TShortObjectIterator<V> iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public short getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V putIfAbsent(short s, V v) {
        V putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(s, v);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tShortProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tObjectProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean forEachEntry(TShortObjectProcedure<? super V> tShortObjectProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tShortObjectProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tObjectFunction);
        }
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean retainEntries(TShortObjectProcedure<? super V> tShortObjectProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tShortObjectProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TShortObjectMap
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
