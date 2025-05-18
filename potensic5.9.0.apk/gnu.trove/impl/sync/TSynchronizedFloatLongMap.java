package gnu.trove.impl.sync;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TFloatLongIterator;
import gnu.trove.map.TFloatLongMap;
import gnu.trove.procedure.TFloatLongProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TFloatSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedFloatLongMap implements TFloatLongMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TFloatLongMap f3613m;
    final Object mutex;
    private transient TFloatSet keySet = null;
    private transient TLongCollection values = null;

    public TSynchronizedFloatLongMap(TFloatLongMap tFloatLongMap) {
        Objects.requireNonNull(tFloatLongMap);
        this.f3613m = tFloatLongMap;
        this.mutex = this;
    }

    public TSynchronizedFloatLongMap(TFloatLongMap tFloatLongMap, Object obj) {
        this.f3613m = tFloatLongMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3613m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3613m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean containsKey(float f) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3613m.containsKey(f);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean containsValue(long j) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3613m.containsValue(j);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long get(float f) {
        long j;
        synchronized (this.mutex) {
            j = this.f3613m.get(f);
        }
        return j;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long put(float f, long j) {
        long put;
        synchronized (this.mutex) {
            put = this.f3613m.put(f, j);
        }
        return put;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long remove(float f) {
        long remove;
        synchronized (this.mutex) {
            remove = this.f3613m.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void putAll(Map<? extends Float, ? extends Long> map) {
        synchronized (this.mutex) {
            this.f3613m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void putAll(TFloatLongMap tFloatLongMap) {
        synchronized (this.mutex) {
            this.f3613m.putAll(tFloatLongMap);
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3613m.clear();
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public TFloatSet keySet() {
        TFloatSet tFloatSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedFloatSet(this.f3613m.keySet(), this.mutex);
            }
            tFloatSet = this.keySet;
        }
        return tFloatSet;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public float[] keys() {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.f3613m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public float[] keys(float[] fArr) {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.f3613m.keys(fArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public TLongCollection valueCollection() {
        TLongCollection tLongCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedLongCollection(this.f3613m.valueCollection(), this.mutex);
            }
            tLongCollection = this.values;
        }
        return tLongCollection;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long[] values() {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3613m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long[] values(long[] jArr) {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3613m.values(jArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public TFloatLongIterator iterator() {
        return this.f3613m.iterator();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public float getNoEntryKey() {
        return this.f3613m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long getNoEntryValue() {
        return this.f3613m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long putIfAbsent(float f, long j) {
        long putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3613m.putIfAbsent(f, j);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3613m.forEachKey(tFloatProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3613m.forEachValue(tLongProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean forEachEntry(TFloatLongProcedure tFloatLongProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3613m.forEachEntry(tFloatLongProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void transformValues(TLongFunction tLongFunction) {
        synchronized (this.mutex) {
            this.f3613m.transformValues(tLongFunction);
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean retainEntries(TFloatLongProcedure tFloatLongProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3613m.retainEntries(tFloatLongProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean increment(float f) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3613m.increment(f);
        }
        return increment;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean adjustValue(float f, long j) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3613m.adjustValue(f, j);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long adjustOrPutValue(float f, long j, long j2) {
        long adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3613m.adjustOrPutValue(f, j, j2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3613m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3613m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3613m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}