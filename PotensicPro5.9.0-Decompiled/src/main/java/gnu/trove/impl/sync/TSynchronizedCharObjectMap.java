package gnu.trove.impl.sync;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TCharObjectIterator;
import gnu.trove.map.TCharObjectMap;
import gnu.trove.procedure.TCharObjectProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TCharSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedCharObjectMap<V> implements TCharObjectMap<V>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TCharObjectMap<V> m;
    final Object mutex;
    private transient TCharSet keySet = null;
    private transient Collection<V> values = null;

    public TSynchronizedCharObjectMap(TCharObjectMap<V> tCharObjectMap) {
        Objects.requireNonNull(tCharObjectMap);
        this.m = tCharObjectMap;
        this.mutex = this;
    }

    public TSynchronizedCharObjectMap(TCharObjectMap<V> tCharObjectMap, Object obj) {
        this.m = tCharObjectMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean containsKey(char c) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(c);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(obj);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public V get(char c) {
        V v;
        synchronized (this.mutex) {
            v = this.m.get(c);
        }
        return v;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public V put(char c, V v) {
        V put;
        synchronized (this.mutex) {
            put = this.m.put(c, v);
        }
        return put;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public V remove(char c) {
        V remove;
        synchronized (this.mutex) {
            remove = this.m.remove(c);
        }
        return remove;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public void putAll(Map<? extends Character, ? extends V> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TCharObjectMap
    public void putAll(TCharObjectMap<? extends V> tCharObjectMap) {
        synchronized (this.mutex) {
            this.m.putAll(tCharObjectMap);
        }
    }

    @Override // gnu.trove.map.TCharObjectMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TCharObjectMap
    public TCharSet keySet() {
        TCharSet tCharSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedCharSet(this.m.keySet(), this.mutex);
            }
            tCharSet = this.keySet;
        }
        return tCharSet;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public char[] keys() {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public char[] keys(char[] cArr) {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(cArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharObjectMap
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

    @Override // gnu.trove.map.TCharObjectMap
    public Object[] values() {
        Object[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public V[] values(V[] vArr) {
        V[] values;
        synchronized (this.mutex) {
            values = this.m.values(vArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public TCharObjectIterator<V> iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public char getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public V putIfAbsent(char c, V v) {
        V putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(c, v);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tCharProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tObjectProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean forEachEntry(TCharObjectProcedure<? super V> tCharObjectProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tCharObjectProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tObjectFunction);
        }
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean retainEntries(TCharObjectProcedure<? super V> tCharObjectProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tCharObjectProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TCharObjectMap
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
