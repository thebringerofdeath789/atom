package gnu.trove.impl.sync;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TLongLongIterator;
import gnu.trove.map.TLongLongMap;
import gnu.trove.procedure.TLongLongProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedLongLongMap implements TLongLongMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TLongLongMap m;
    final Object mutex;
    private transient TLongSet keySet = null;
    private transient TLongCollection values = null;

    public TSynchronizedLongLongMap(TLongLongMap tLongLongMap) {
        Objects.requireNonNull(tLongLongMap);
        this.m = tLongLongMap;
        this.mutex = this;
    }

    public TSynchronizedLongLongMap(TLongLongMap tLongLongMap, Object obj) {
        this.m = tLongLongMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TLongLongMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean containsKey(long j) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(j);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean containsValue(long j) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(j);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TLongLongMap
    public long get(long j) {
        long j2;
        synchronized (this.mutex) {
            j2 = this.m.get(j);
        }
        return j2;
    }

    @Override // gnu.trove.map.TLongLongMap
    public long put(long j, long j2) {
        long put;
        synchronized (this.mutex) {
            put = this.m.put(j, j2);
        }
        return put;
    }

    @Override // gnu.trove.map.TLongLongMap
    public long remove(long j) {
        long remove;
        synchronized (this.mutex) {
            remove = this.m.remove(j);
        }
        return remove;
    }

    @Override // gnu.trove.map.TLongLongMap
    public void putAll(Map<? extends Long, ? extends Long> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TLongLongMap
    public void putAll(TLongLongMap tLongLongMap) {
        synchronized (this.mutex) {
            this.m.putAll(tLongLongMap);
        }
    }

    @Override // gnu.trove.map.TLongLongMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TLongLongMap
    public TLongSet keySet() {
        TLongSet tLongSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedLongSet(this.m.keySet(), this.mutex);
            }
            tLongSet = this.keySet;
        }
        return tLongSet;
    }

    @Override // gnu.trove.map.TLongLongMap
    public long[] keys() {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongLongMap
    public long[] keys(long[] jArr) {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(jArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongLongMap
    public TLongCollection valueCollection() {
        TLongCollection tLongCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedLongCollection(this.m.valueCollection(), this.mutex);
            }
            tLongCollection = this.values;
        }
        return tLongCollection;
    }

    @Override // gnu.trove.map.TLongLongMap
    public long[] values() {
        long[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TLongLongMap
    public long[] values(long[] jArr) {
        long[] values;
        synchronized (this.mutex) {
            values = this.m.values(jArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TLongLongMap
    public TLongLongIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TLongLongMap
    public long getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongLongMap
    public long getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongLongMap
    public long putIfAbsent(long j, long j2) {
        long putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(j, j2);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tLongProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tLongProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean forEachEntry(TLongLongProcedure tLongLongProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tLongLongProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TLongLongMap
    public void transformValues(TLongFunction tLongFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tLongFunction);
        }
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean retainEntries(TLongLongProcedure tLongLongProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tLongLongProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean increment(long j) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(j);
        }
        return increment;
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean adjustValue(long j, long j2) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(j, j2);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TLongLongMap
    public long adjustOrPutValue(long j, long j2, long j3) {
        long adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(j, j2, j3);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.m.equals(obj);
        }
        return equals;
    }

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
