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
    private final TFloatLongMap m;
    final Object mutex;
    private transient TFloatSet keySet = null;
    private transient TLongCollection values = null;

    public TSynchronizedFloatLongMap(TFloatLongMap tFloatLongMap) {
        Objects.requireNonNull(tFloatLongMap);
        this.m = tFloatLongMap;
        this.mutex = this;
    }

    public TSynchronizedFloatLongMap(TFloatLongMap tFloatLongMap, Object obj) {
        this.m = tFloatLongMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean containsKey(float f) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(f);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean containsValue(long j) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(j);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long get(float f) {
        long j;
        synchronized (this.mutex) {
            j = this.m.get(f);
        }
        return j;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long put(float f, long j) {
        long put;
        synchronized (this.mutex) {
            put = this.m.put(f, j);
        }
        return put;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long remove(float f) {
        long remove;
        synchronized (this.mutex) {
            remove = this.m.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void putAll(Map<? extends Float, ? extends Long> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void putAll(TFloatLongMap tFloatLongMap) {
        synchronized (this.mutex) {
            this.m.putAll(tFloatLongMap);
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public TFloatSet keySet() {
        TFloatSet tFloatSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedFloatSet(this.m.keySet(), this.mutex);
            }
            tFloatSet = this.keySet;
        }
        return tFloatSet;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public float[] keys() {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public float[] keys(float[] fArr) {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(fArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatLongMap
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

    @Override // gnu.trove.map.TFloatLongMap
    public long[] values() {
        long[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long[] values(long[] jArr) {
        long[] values;
        synchronized (this.mutex) {
            values = this.m.values(jArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public TFloatLongIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public float getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long putIfAbsent(float f, long j) {
        long putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(f, j);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tFloatProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tLongProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean forEachEntry(TFloatLongProcedure tFloatLongProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tFloatLongProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void transformValues(TLongFunction tLongFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tLongFunction);
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean retainEntries(TFloatLongProcedure tFloatLongProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tFloatLongProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean increment(float f) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(f);
        }
        return increment;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean adjustValue(float f, long j) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(f, j);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long adjustOrPutValue(float f, long j, long j2) {
        long adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(f, j, j2);
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
