package gnu.trove.impl.sync;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TLongDoubleIterator;
import gnu.trove.map.TLongDoubleMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TLongDoubleProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedLongDoubleMap implements TLongDoubleMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TLongDoubleMap m;
    final Object mutex;
    private transient TLongSet keySet = null;
    private transient TDoubleCollection values = null;

    public TSynchronizedLongDoubleMap(TLongDoubleMap tLongDoubleMap) {
        Objects.requireNonNull(tLongDoubleMap);
        this.m = tLongDoubleMap;
        this.mutex = this;
    }

    public TSynchronizedLongDoubleMap(TLongDoubleMap tLongDoubleMap, Object obj) {
        this.m = tLongDoubleMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean containsKey(long j) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(j);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean containsValue(double d) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(d);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double get(long j) {
        double d;
        synchronized (this.mutex) {
            d = this.m.get(j);
        }
        return d;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double put(long j, double d) {
        double put;
        synchronized (this.mutex) {
            put = this.m.put(j, d);
        }
        return put;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double remove(long j) {
        double remove;
        synchronized (this.mutex) {
            remove = this.m.remove(j);
        }
        return remove;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public void putAll(Map<? extends Long, ? extends Double> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public void putAll(TLongDoubleMap tLongDoubleMap) {
        synchronized (this.mutex) {
            this.m.putAll(tLongDoubleMap);
        }
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TLongDoubleMap
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

    @Override // gnu.trove.map.TLongDoubleMap
    public long[] keys() {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public long[] keys(long[] jArr) {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(jArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public TDoubleCollection valueCollection() {
        TDoubleCollection tDoubleCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedDoubleCollection(this.m.valueCollection(), this.mutex);
            }
            tDoubleCollection = this.values;
        }
        return tDoubleCollection;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double[] values() {
        double[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double[] values(double[] dArr) {
        double[] values;
        synchronized (this.mutex) {
            values = this.m.values(dArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public TLongDoubleIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public long getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double putIfAbsent(long j, double d) {
        double putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(j, d);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tLongProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tDoubleProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean forEachEntry(TLongDoubleProcedure tLongDoubleProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tLongDoubleProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tDoubleFunction);
        }
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean retainEntries(TLongDoubleProcedure tLongDoubleProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tLongDoubleProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean increment(long j) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(j);
        }
        return increment;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean adjustValue(long j, double d) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(j, d);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double adjustOrPutValue(long j, double d, double d2) {
        double adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(j, d, d2);
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
