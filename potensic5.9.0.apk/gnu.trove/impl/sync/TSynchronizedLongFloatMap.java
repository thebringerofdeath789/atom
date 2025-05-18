package gnu.trove.impl.sync;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TLongFloatIterator;
import gnu.trove.map.TLongFloatMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TLongFloatProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedLongFloatMap implements TLongFloatMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TLongFloatMap f3629m;
    final Object mutex;
    private transient TLongSet keySet = null;
    private transient TFloatCollection values = null;

    public TSynchronizedLongFloatMap(TLongFloatMap tLongFloatMap) {
        Objects.requireNonNull(tLongFloatMap);
        this.f3629m = tLongFloatMap;
        this.mutex = this;
    }

    public TSynchronizedLongFloatMap(TLongFloatMap tLongFloatMap, Object obj) {
        this.f3629m = tLongFloatMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3629m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3629m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean containsKey(long j) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3629m.containsKey(j);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean containsValue(float f) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3629m.containsValue(f);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float get(long j) {
        float f;
        synchronized (this.mutex) {
            f = this.f3629m.get(j);
        }
        return f;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float put(long j, float f) {
        float put;
        synchronized (this.mutex) {
            put = this.f3629m.put(j, f);
        }
        return put;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float remove(long j) {
        float remove;
        synchronized (this.mutex) {
            remove = this.f3629m.remove(j);
        }
        return remove;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public void putAll(Map<? extends Long, ? extends Float> map) {
        synchronized (this.mutex) {
            this.f3629m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TLongFloatMap
    public void putAll(TLongFloatMap tLongFloatMap) {
        synchronized (this.mutex) {
            this.f3629m.putAll(tLongFloatMap);
        }
    }

    @Override // gnu.trove.map.TLongFloatMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3629m.clear();
        }
    }

    @Override // gnu.trove.map.TLongFloatMap
    public TLongSet keySet() {
        TLongSet tLongSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedLongSet(this.f3629m.keySet(), this.mutex);
            }
            tLongSet = this.keySet;
        }
        return tLongSet;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public long[] keys() {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.f3629m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public long[] keys(long[] jArr) {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.f3629m.keys(jArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public TFloatCollection valueCollection() {
        TFloatCollection tFloatCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedFloatCollection(this.f3629m.valueCollection(), this.mutex);
            }
            tFloatCollection = this.values;
        }
        return tFloatCollection;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float[] values() {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3629m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float[] values(float[] fArr) {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3629m.values(fArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public TLongFloatIterator iterator() {
        return this.f3629m.iterator();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public long getNoEntryKey() {
        return this.f3629m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float getNoEntryValue() {
        return this.f3629m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float putIfAbsent(long j, float f) {
        float putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3629m.putIfAbsent(j, f);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3629m.forEachKey(tLongProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3629m.forEachValue(tFloatProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean forEachEntry(TLongFloatProcedure tLongFloatProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3629m.forEachEntry(tLongFloatProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        synchronized (this.mutex) {
            this.f3629m.transformValues(tFloatFunction);
        }
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean retainEntries(TLongFloatProcedure tLongFloatProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3629m.retainEntries(tLongFloatProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean increment(long j) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3629m.increment(j);
        }
        return increment;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean adjustValue(long j, float f) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3629m.adjustValue(j, f);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float adjustOrPutValue(long j, float f, float f2) {
        float adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3629m.adjustOrPutValue(j, f, f2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3629m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3629m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3629m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}