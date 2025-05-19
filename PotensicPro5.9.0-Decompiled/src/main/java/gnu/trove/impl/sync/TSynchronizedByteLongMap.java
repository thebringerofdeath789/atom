package gnu.trove.impl.sync;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TByteLongIterator;
import gnu.trove.map.TByteLongMap;
import gnu.trove.procedure.TByteLongProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TByteSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedByteLongMap implements TByteLongMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TByteLongMap m;
    final Object mutex;
    private transient TByteSet keySet = null;
    private transient TLongCollection values = null;

    public TSynchronizedByteLongMap(TByteLongMap tByteLongMap) {
        Objects.requireNonNull(tByteLongMap);
        this.m = tByteLongMap;
        this.mutex = this;
    }

    public TSynchronizedByteLongMap(TByteLongMap tByteLongMap, Object obj) {
        this.m = tByteLongMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TByteLongMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean containsKey(byte b) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(b);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean containsValue(long j) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(j);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long get(byte b) {
        long j;
        synchronized (this.mutex) {
            j = this.m.get(b);
        }
        return j;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long put(byte b, long j) {
        long put;
        synchronized (this.mutex) {
            put = this.m.put(b, j);
        }
        return put;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long remove(byte b) {
        long remove;
        synchronized (this.mutex) {
            remove = this.m.remove(b);
        }
        return remove;
    }

    @Override // gnu.trove.map.TByteLongMap
    public void putAll(Map<? extends Byte, ? extends Long> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public void putAll(TByteLongMap tByteLongMap) {
        synchronized (this.mutex) {
            this.m.putAll(tByteLongMap);
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public TByteSet keySet() {
        TByteSet tByteSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedByteSet(this.m.keySet(), this.mutex);
            }
            tByteSet = this.keySet;
        }
        return tByteSet;
    }

    @Override // gnu.trove.map.TByteLongMap
    public byte[] keys() {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteLongMap
    public byte[] keys(byte[] bArr) {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(bArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteLongMap
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

    @Override // gnu.trove.map.TByteLongMap
    public long[] values() {
        long[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long[] values(long[] jArr) {
        long[] values;
        synchronized (this.mutex) {
            values = this.m.values(jArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TByteLongMap
    public TByteLongIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TByteLongMap
    public byte getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteLongMap
    public long getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteLongMap
    public long putIfAbsent(byte b, long j) {
        long putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(b, j);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tByteProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tLongProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean forEachEntry(TByteLongProcedure tByteLongProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tByteLongProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TByteLongMap
    public void transformValues(TLongFunction tLongFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tLongFunction);
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean retainEntries(TByteLongProcedure tByteLongProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tByteLongProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean increment(byte b) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(b);
        }
        return increment;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean adjustValue(byte b, long j) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(b, j);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long adjustOrPutValue(byte b, long j, long j2) {
        long adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(b, j, j2);
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
