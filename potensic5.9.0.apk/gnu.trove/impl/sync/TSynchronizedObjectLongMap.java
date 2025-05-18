package gnu.trove.impl.sync;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TObjectLongIterator;
import gnu.trove.map.TObjectLongMap;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TObjectLongProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TSynchronizedObjectLongMap<K> implements TObjectLongMap<K>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TObjectLongMap<K> f3639m;
    final Object mutex;
    private transient Set<K> keySet = null;
    private transient TLongCollection values = null;

    public TSynchronizedObjectLongMap(TObjectLongMap<K> tObjectLongMap) {
        Objects.requireNonNull(tObjectLongMap);
        this.f3639m = tObjectLongMap;
        this.mutex = this;
    }

    public TSynchronizedObjectLongMap(TObjectLongMap<K> tObjectLongMap, Object obj) {
        this.f3639m = tObjectLongMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3639m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3639m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3639m.containsKey(obj);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean containsValue(long j) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3639m.containsValue(j);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long get(Object obj) {
        long j;
        synchronized (this.mutex) {
            j = this.f3639m.get(obj);
        }
        return j;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long put(K k, long j) {
        long put;
        synchronized (this.mutex) {
            put = this.f3639m.put(k, j);
        }
        return put;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long remove(Object obj) {
        long remove;
        synchronized (this.mutex) {
            remove = this.f3639m.remove(obj);
        }
        return remove;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public void putAll(Map<? extends K, ? extends Long> map) {
        synchronized (this.mutex) {
            this.f3639m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public void putAll(TObjectLongMap<? extends K> tObjectLongMap) {
        synchronized (this.mutex) {
            this.f3639m.putAll(tObjectLongMap);
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3639m.clear();
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public Set<K> keySet() {
        Set<K> set;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new SynchronizedSet(this.f3639m.keySet(), this.mutex);
            }
            set = this.keySet;
        }
        return set;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public Object[] keys() {
        Object[] keys;
        synchronized (this.mutex) {
            keys = this.f3639m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public K[] keys(K[] kArr) {
        K[] keys;
        synchronized (this.mutex) {
            keys = this.f3639m.keys(kArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public TLongCollection valueCollection() {
        TLongCollection tLongCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedLongCollection(this.f3639m.valueCollection(), this.mutex);
            }
            tLongCollection = this.values;
        }
        return tLongCollection;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long[] values() {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3639m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long[] values(long[] jArr) {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3639m.values(jArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public TObjectLongIterator<K> iterator() {
        return this.f3639m.iterator();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long getNoEntryValue() {
        return this.f3639m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long putIfAbsent(K k, long j) {
        long putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3639m.putIfAbsent(k, j);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3639m.forEachKey(tObjectProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3639m.forEachValue(tLongProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean forEachEntry(TObjectLongProcedure<? super K> tObjectLongProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3639m.forEachEntry(tObjectLongProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public void transformValues(TLongFunction tLongFunction) {
        synchronized (this.mutex) {
            this.f3639m.transformValues(tLongFunction);
        }
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean retainEntries(TObjectLongProcedure<? super K> tObjectLongProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3639m.retainEntries(tObjectLongProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean increment(K k) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3639m.increment(k);
        }
        return increment;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean adjustValue(K k, long j) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3639m.adjustValue(k, j);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long adjustOrPutValue(K k, long j, long j2) {
        long adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3639m.adjustOrPutValue(k, j, j2);
        }
        return adjustOrPutValue;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3639m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3639m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3639m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}