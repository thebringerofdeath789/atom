package gnu.trove.impl.sync;

import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TByteObjectIterator;
import gnu.trove.map.TByteObjectMap;
import gnu.trove.procedure.TByteObjectProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TByteSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedByteObjectMap<V> implements TByteObjectMap<V>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TByteObjectMap<V> f3587m;
    final Object mutex;
    private transient TByteSet keySet = null;
    private transient Collection<V> values = null;

    public TSynchronizedByteObjectMap(TByteObjectMap<V> tByteObjectMap) {
        Objects.requireNonNull(tByteObjectMap);
        this.f3587m = tByteObjectMap;
        this.mutex = this;
    }

    public TSynchronizedByteObjectMap(TByteObjectMap<V> tByteObjectMap, Object obj) {
        this.f3587m = tByteObjectMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3587m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3587m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean containsKey(byte b) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3587m.containsKey(b);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3587m.containsValue(obj);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public V get(byte b) {
        V v;
        synchronized (this.mutex) {
            v = this.f3587m.get(b);
        }
        return v;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public V put(byte b, V v) {
        V put;
        synchronized (this.mutex) {
            put = this.f3587m.put(b, v);
        }
        return put;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public V remove(byte b) {
        V remove;
        synchronized (this.mutex) {
            remove = this.f3587m.remove(b);
        }
        return remove;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public void putAll(Map<? extends Byte, ? extends V> map) {
        synchronized (this.mutex) {
            this.f3587m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TByteObjectMap
    public void putAll(TByteObjectMap<? extends V> tByteObjectMap) {
        synchronized (this.mutex) {
            this.f3587m.putAll(tByteObjectMap);
        }
    }

    @Override // gnu.trove.map.TByteObjectMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3587m.clear();
        }
    }

    @Override // gnu.trove.map.TByteObjectMap
    public TByteSet keySet() {
        TByteSet tByteSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedByteSet(this.f3587m.keySet(), this.mutex);
            }
            tByteSet = this.keySet;
        }
        return tByteSet;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public byte[] keys() {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3587m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public byte[] keys(byte[] bArr) {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3587m.keys(bArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public Collection<V> valueCollection() {
        Collection<V> collection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new SynchronizedCollection(this.f3587m.valueCollection(), this.mutex);
            }
            collection = this.values;
        }
        return collection;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public Object[] values() {
        Object[] values;
        synchronized (this.mutex) {
            values = this.f3587m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public V[] values(V[] vArr) {
        V[] values;
        synchronized (this.mutex) {
            values = this.f3587m.values(vArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public TByteObjectIterator<V> iterator() {
        return this.f3587m.iterator();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public byte getNoEntryKey() {
        return this.f3587m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public V putIfAbsent(byte b, V v) {
        V putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3587m.putIfAbsent(b, v);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3587m.forEachKey(tByteProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3587m.forEachValue(tObjectProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean forEachEntry(TByteObjectProcedure<? super V> tByteObjectProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3587m.forEachEntry(tByteObjectProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        synchronized (this.mutex) {
            this.f3587m.transformValues(tObjectFunction);
        }
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean retainEntries(TByteObjectProcedure<? super V> tByteObjectProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3587m.retainEntries(tByteObjectProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3587m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3587m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3587m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}