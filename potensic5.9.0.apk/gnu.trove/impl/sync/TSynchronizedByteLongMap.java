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

    /* renamed from: m */
    private final TByteLongMap f3586m;
    final Object mutex;
    private transient TByteSet keySet = null;
    private transient TLongCollection values = null;

    public TSynchronizedByteLongMap(TByteLongMap tByteLongMap) {
        Objects.requireNonNull(tByteLongMap);
        this.f3586m = tByteLongMap;
        this.mutex = this;
    }

    public TSynchronizedByteLongMap(TByteLongMap tByteLongMap, Object obj) {
        this.f3586m = tByteLongMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TByteLongMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3586m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3586m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean containsKey(byte b) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3586m.containsKey(b);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean containsValue(long j) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3586m.containsValue(j);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long get(byte b) {
        long j;
        synchronized (this.mutex) {
            j = this.f3586m.get(b);
        }
        return j;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long put(byte b, long j) {
        long put;
        synchronized (this.mutex) {
            put = this.f3586m.put(b, j);
        }
        return put;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long remove(byte b) {
        long remove;
        synchronized (this.mutex) {
            remove = this.f3586m.remove(b);
        }
        return remove;
    }

    @Override // gnu.trove.map.TByteLongMap
    public void putAll(Map<? extends Byte, ? extends Long> map) {
        synchronized (this.mutex) {
            this.f3586m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public void putAll(TByteLongMap tByteLongMap) {
        synchronized (this.mutex) {
            this.f3586m.putAll(tByteLongMap);
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3586m.clear();
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public TByteSet keySet() {
        TByteSet tByteSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedByteSet(this.f3586m.keySet(), this.mutex);
            }
            tByteSet = this.keySet;
        }
        return tByteSet;
    }

    @Override // gnu.trove.map.TByteLongMap
    public byte[] keys() {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3586m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteLongMap
    public byte[] keys(byte[] bArr) {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3586m.keys(bArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteLongMap
    public TLongCollection valueCollection() {
        TLongCollection tLongCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedLongCollection(this.f3586m.valueCollection(), this.mutex);
            }
            tLongCollection = this.values;
        }
        return tLongCollection;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long[] values() {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3586m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long[] values(long[] jArr) {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3586m.values(jArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TByteLongMap
    public TByteLongIterator iterator() {
        return this.f3586m.iterator();
    }

    @Override // gnu.trove.map.TByteLongMap
    public byte getNoEntryKey() {
        return this.f3586m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteLongMap
    public long getNoEntryValue() {
        return this.f3586m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteLongMap
    public long putIfAbsent(byte b, long j) {
        long putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3586m.putIfAbsent(b, j);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3586m.forEachKey(tByteProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3586m.forEachValue(tLongProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean forEachEntry(TByteLongProcedure tByteLongProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3586m.forEachEntry(tByteLongProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TByteLongMap
    public void transformValues(TLongFunction tLongFunction) {
        synchronized (this.mutex) {
            this.f3586m.transformValues(tLongFunction);
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean retainEntries(TByteLongProcedure tByteLongProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3586m.retainEntries(tByteLongProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean increment(byte b) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3586m.increment(b);
        }
        return increment;
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean adjustValue(byte b, long j) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3586m.adjustValue(b, j);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long adjustOrPutValue(byte b, long j, long j2) {
        long adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3586m.adjustOrPutValue(b, j, j2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3586m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3586m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3586m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}