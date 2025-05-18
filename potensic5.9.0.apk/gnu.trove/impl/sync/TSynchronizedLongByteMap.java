package gnu.trove.impl.sync;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TLongByteIterator;
import gnu.trove.map.TLongByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TLongByteProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedLongByteMap implements TLongByteMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TLongByteMap f3625m;
    final Object mutex;
    private transient TLongSet keySet = null;
    private transient TByteCollection values = null;

    public TSynchronizedLongByteMap(TLongByteMap tLongByteMap) {
        Objects.requireNonNull(tLongByteMap);
        this.f3625m = tLongByteMap;
        this.mutex = this;
    }

    public TSynchronizedLongByteMap(TLongByteMap tLongByteMap, Object obj) {
        this.f3625m = tLongByteMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TLongByteMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3625m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3625m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean containsKey(long j) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3625m.containsKey(j);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean containsValue(byte b) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3625m.containsValue(b);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte get(long j) {
        byte b;
        synchronized (this.mutex) {
            b = this.f3625m.get(j);
        }
        return b;
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte put(long j, byte b) {
        byte put;
        synchronized (this.mutex) {
            put = this.f3625m.put(j, b);
        }
        return put;
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte remove(long j) {
        byte remove;
        synchronized (this.mutex) {
            remove = this.f3625m.remove(j);
        }
        return remove;
    }

    @Override // gnu.trove.map.TLongByteMap
    public void putAll(Map<? extends Long, ? extends Byte> map) {
        synchronized (this.mutex) {
            this.f3625m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TLongByteMap
    public void putAll(TLongByteMap tLongByteMap) {
        synchronized (this.mutex) {
            this.f3625m.putAll(tLongByteMap);
        }
    }

    @Override // gnu.trove.map.TLongByteMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3625m.clear();
        }
    }

    @Override // gnu.trove.map.TLongByteMap
    public TLongSet keySet() {
        TLongSet tLongSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedLongSet(this.f3625m.keySet(), this.mutex);
            }
            tLongSet = this.keySet;
        }
        return tLongSet;
    }

    @Override // gnu.trove.map.TLongByteMap
    public long[] keys() {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.f3625m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongByteMap
    public long[] keys(long[] jArr) {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.f3625m.keys(jArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongByteMap
    public TByteCollection valueCollection() {
        TByteCollection tByteCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedByteCollection(this.f3625m.valueCollection(), this.mutex);
            }
            tByteCollection = this.values;
        }
        return tByteCollection;
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte[] values() {
        byte[] values;
        synchronized (this.mutex) {
            values = this.f3625m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte[] values(byte[] bArr) {
        byte[] values;
        synchronized (this.mutex) {
            values = this.f3625m.values(bArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TLongByteMap
    public TLongByteIterator iterator() {
        return this.f3625m.iterator();
    }

    @Override // gnu.trove.map.TLongByteMap
    public long getNoEntryKey() {
        return this.f3625m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte getNoEntryValue() {
        return this.f3625m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte putIfAbsent(long j, byte b) {
        byte putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3625m.putIfAbsent(j, b);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3625m.forEachKey(tLongProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3625m.forEachValue(tByteProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean forEachEntry(TLongByteProcedure tLongByteProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3625m.forEachEntry(tLongByteProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TLongByteMap
    public void transformValues(TByteFunction tByteFunction) {
        synchronized (this.mutex) {
            this.f3625m.transformValues(tByteFunction);
        }
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean retainEntries(TLongByteProcedure tLongByteProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3625m.retainEntries(tLongByteProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean increment(long j) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3625m.increment(j);
        }
        return increment;
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean adjustValue(long j, byte b) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3625m.adjustValue(j, b);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte adjustOrPutValue(long j, byte b, byte b2) {
        byte adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3625m.adjustOrPutValue(j, b, b2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3625m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3625m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3625m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}