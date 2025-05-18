package gnu.trove.impl.sync;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TDoubleLongIterator;
import gnu.trove.map.TDoubleLongMap;
import gnu.trove.procedure.TDoubleLongProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedDoubleLongMap implements TDoubleLongMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TDoubleLongMap f3604m;
    final Object mutex;
    private transient TDoubleSet keySet = null;
    private transient TLongCollection values = null;

    public TSynchronizedDoubleLongMap(TDoubleLongMap tDoubleLongMap) {
        Objects.requireNonNull(tDoubleLongMap);
        this.f3604m = tDoubleLongMap;
        this.mutex = this;
    }

    public TSynchronizedDoubleLongMap(TDoubleLongMap tDoubleLongMap, Object obj) {
        this.f3604m = tDoubleLongMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3604m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3604m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean containsKey(double d) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3604m.containsKey(d);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean containsValue(long j) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3604m.containsValue(j);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long get(double d) {
        long j;
        synchronized (this.mutex) {
            j = this.f3604m.get(d);
        }
        return j;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long put(double d, long j) {
        long put;
        synchronized (this.mutex) {
            put = this.f3604m.put(d, j);
        }
        return put;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long remove(double d) {
        long remove;
        synchronized (this.mutex) {
            remove = this.f3604m.remove(d);
        }
        return remove;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public void putAll(Map<? extends Double, ? extends Long> map) {
        synchronized (this.mutex) {
            this.f3604m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public void putAll(TDoubleLongMap tDoubleLongMap) {
        synchronized (this.mutex) {
            this.f3604m.putAll(tDoubleLongMap);
        }
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3604m.clear();
        }
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public TDoubleSet keySet() {
        TDoubleSet tDoubleSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedDoubleSet(this.f3604m.keySet(), this.mutex);
            }
            tDoubleSet = this.keySet;
        }
        return tDoubleSet;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public double[] keys() {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.f3604m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public double[] keys(double[] dArr) {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.f3604m.keys(dArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public TLongCollection valueCollection() {
        TLongCollection tLongCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedLongCollection(this.f3604m.valueCollection(), this.mutex);
            }
            tLongCollection = this.values;
        }
        return tLongCollection;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long[] values() {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3604m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long[] values(long[] jArr) {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3604m.values(jArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public TDoubleLongIterator iterator() {
        return this.f3604m.iterator();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public double getNoEntryKey() {
        return this.f3604m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long getNoEntryValue() {
        return this.f3604m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long putIfAbsent(double d, long j) {
        long putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3604m.putIfAbsent(d, j);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3604m.forEachKey(tDoubleProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3604m.forEachValue(tLongProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean forEachEntry(TDoubleLongProcedure tDoubleLongProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3604m.forEachEntry(tDoubleLongProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public void transformValues(TLongFunction tLongFunction) {
        synchronized (this.mutex) {
            this.f3604m.transformValues(tLongFunction);
        }
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean retainEntries(TDoubleLongProcedure tDoubleLongProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3604m.retainEntries(tDoubleLongProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean increment(double d) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3604m.increment(d);
        }
        return increment;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean adjustValue(double d, long j) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3604m.adjustValue(d, j);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long adjustOrPutValue(double d, long j, long j2) {
        long adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3604m.adjustOrPutValue(d, j, j2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3604m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3604m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3604m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}