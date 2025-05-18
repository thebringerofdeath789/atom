package gnu.trove.impl.sync;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TLongShortIterator;
import gnu.trove.map.TLongShortMap;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TLongShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TLongSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedLongShortMap implements TLongShortMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TLongShortMap f3633m;
    final Object mutex;
    private transient TLongSet keySet = null;
    private transient TShortCollection values = null;

    public TSynchronizedLongShortMap(TLongShortMap tLongShortMap) {
        Objects.requireNonNull(tLongShortMap);
        this.f3633m = tLongShortMap;
        this.mutex = this;
    }

    public TSynchronizedLongShortMap(TLongShortMap tLongShortMap, Object obj) {
        this.f3633m = tLongShortMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TLongShortMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3633m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3633m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean containsKey(long j) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3633m.containsKey(j);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean containsValue(short s) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3633m.containsValue(s);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TLongShortMap
    public short get(long j) {
        short s;
        synchronized (this.mutex) {
            s = this.f3633m.get(j);
        }
        return s;
    }

    @Override // gnu.trove.map.TLongShortMap
    public short put(long j, short s) {
        short put;
        synchronized (this.mutex) {
            put = this.f3633m.put(j, s);
        }
        return put;
    }

    @Override // gnu.trove.map.TLongShortMap
    public short remove(long j) {
        short remove;
        synchronized (this.mutex) {
            remove = this.f3633m.remove(j);
        }
        return remove;
    }

    @Override // gnu.trove.map.TLongShortMap
    public void putAll(Map<? extends Long, ? extends Short> map) {
        synchronized (this.mutex) {
            this.f3633m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public void putAll(TLongShortMap tLongShortMap) {
        synchronized (this.mutex) {
            this.f3633m.putAll(tLongShortMap);
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3633m.clear();
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public TLongSet keySet() {
        TLongSet tLongSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedLongSet(this.f3633m.keySet(), this.mutex);
            }
            tLongSet = this.keySet;
        }
        return tLongSet;
    }

    @Override // gnu.trove.map.TLongShortMap
    public long[] keys() {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.f3633m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongShortMap
    public long[] keys(long[] jArr) {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.f3633m.keys(jArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongShortMap
    public TShortCollection valueCollection() {
        TShortCollection tShortCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedShortCollection(this.f3633m.valueCollection(), this.mutex);
            }
            tShortCollection = this.values;
        }
        return tShortCollection;
    }

    @Override // gnu.trove.map.TLongShortMap
    public short[] values() {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3633m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TLongShortMap
    public short[] values(short[] sArr) {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3633m.values(sArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TLongShortMap
    public TLongShortIterator iterator() {
        return this.f3633m.iterator();
    }

    @Override // gnu.trove.map.TLongShortMap
    public long getNoEntryKey() {
        return this.f3633m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongShortMap
    public short getNoEntryValue() {
        return this.f3633m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongShortMap
    public short putIfAbsent(long j, short s) {
        short putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3633m.putIfAbsent(j, s);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3633m.forEachKey(tLongProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3633m.forEachValue(tShortProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean forEachEntry(TLongShortProcedure tLongShortProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3633m.forEachEntry(tLongShortProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TLongShortMap
    public void transformValues(TShortFunction tShortFunction) {
        synchronized (this.mutex) {
            this.f3633m.transformValues(tShortFunction);
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean retainEntries(TLongShortProcedure tLongShortProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3633m.retainEntries(tLongShortProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean increment(long j) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3633m.increment(j);
        }
        return increment;
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean adjustValue(long j, short s) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3633m.adjustValue(j, s);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TLongShortMap
    public short adjustOrPutValue(long j, short s, short s2) {
        short adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3633m.adjustOrPutValue(j, s, s2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3633m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3633m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3633m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}