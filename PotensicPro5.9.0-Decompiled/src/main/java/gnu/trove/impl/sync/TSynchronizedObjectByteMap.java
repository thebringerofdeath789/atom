package gnu.trove.impl.sync;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TObjectByteIterator;
import gnu.trove.map.TObjectByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TObjectByteProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TSynchronizedObjectByteMap<K> implements TObjectByteMap<K>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TObjectByteMap<K> m;
    final Object mutex;
    private transient Set<K> keySet = null;
    private transient TByteCollection values = null;

    public TSynchronizedObjectByteMap(TObjectByteMap<K> tObjectByteMap) {
        Objects.requireNonNull(tObjectByteMap);
        this.m = tObjectByteMap;
        this.mutex = this;
    }

    public TSynchronizedObjectByteMap(TObjectByteMap<K> tObjectByteMap, Object obj) {
        this.m = tObjectByteMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(obj);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean containsValue(byte b) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(b);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte get(Object obj) {
        byte b;
        synchronized (this.mutex) {
            b = this.m.get(obj);
        }
        return b;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte put(K k, byte b) {
        byte put;
        synchronized (this.mutex) {
            put = this.m.put(k, b);
        }
        return put;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte remove(Object obj) {
        byte remove;
        synchronized (this.mutex) {
            remove = this.m.remove(obj);
        }
        return remove;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public void putAll(Map<? extends K, ? extends Byte> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public void putAll(TObjectByteMap<? extends K> tObjectByteMap) {
        synchronized (this.mutex) {
            this.m.putAll(tObjectByteMap);
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public Set<K> keySet() {
        Set<K> set;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new SynchronizedSet(this.m.keySet(), this.mutex);
            }
            set = this.keySet;
        }
        return set;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public Object[] keys() {
        Object[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public K[] keys(K[] kArr) {
        K[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(kArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public TByteCollection valueCollection() {
        TByteCollection tByteCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedByteCollection(this.m.valueCollection(), this.mutex);
            }
            tByteCollection = this.values;
        }
        return tByteCollection;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte[] values() {
        byte[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte[] values(byte[] bArr) {
        byte[] values;
        synchronized (this.mutex) {
            values = this.m.values(bArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public TObjectByteIterator<K> iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte putIfAbsent(K k, byte b) {
        byte putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(k, b);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tObjectProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tByteProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean forEachEntry(TObjectByteProcedure<? super K> tObjectByteProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tObjectByteProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public void transformValues(TByteFunction tByteFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tByteFunction);
        }
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean retainEntries(TObjectByteProcedure<? super K> tObjectByteProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tObjectByteProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean increment(K k) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(k);
        }
        return increment;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean adjustValue(K k, byte b) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(k, b);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte adjustOrPutValue(K k, byte b, byte b2) {
        byte adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(k, b, b2);
        }
        return adjustOrPutValue;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TObjectByteMap
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
