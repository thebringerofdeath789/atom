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

    /* renamed from: m */
    private final TLongDoubleMap f3628m;
    final Object mutex;
    private transient TLongSet keySet = null;
    private transient TDoubleCollection values = null;

    public TSynchronizedLongDoubleMap(TLongDoubleMap tLongDoubleMap) {
        Objects.requireNonNull(tLongDoubleMap);
        this.f3628m = tLongDoubleMap;
        this.mutex = this;
    }

    public TSynchronizedLongDoubleMap(TLongDoubleMap tLongDoubleMap, Object obj) {
        this.f3628m = tLongDoubleMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3628m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3628m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean containsKey(long j) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3628m.containsKey(j);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean containsValue(double d) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3628m.containsValue(d);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double get(long j) {
        double d;
        synchronized (this.mutex) {
            d = this.f3628m.get(j);
        }
        return d;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double put(long j, double d) {
        double put;
        synchronized (this.mutex) {
            put = this.f3628m.put(j, d);
        }
        return put;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double remove(long j) {
        double remove;
        synchronized (this.mutex) {
            remove = this.f3628m.remove(j);
        }
        return remove;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public void putAll(Map<? extends Long, ? extends Double> map) {
        synchronized (this.mutex) {
            this.f3628m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public void putAll(TLongDoubleMap tLongDoubleMap) {
        synchronized (this.mutex) {
            this.f3628m.putAll(tLongDoubleMap);
        }
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3628m.clear();
        }
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public TLongSet keySet() {
        TLongSet tLongSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedLongSet(this.f3628m.keySet(), this.mutex);
            }
            tLongSet = this.keySet;
        }
        return tLongSet;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public long[] keys() {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.f3628m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public long[] keys(long[] jArr) {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.f3628m.keys(jArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public TDoubleCollection valueCollection() {
        TDoubleCollection tDoubleCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedDoubleCollection(this.f3628m.valueCollection(), this.mutex);
            }
            tDoubleCollection = this.values;
        }
        return tDoubleCollection;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double[] values() {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3628m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double[] values(double[] dArr) {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3628m.values(dArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public TLongDoubleIterator iterator() {
        return this.f3628m.iterator();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public long getNoEntryKey() {
        return this.f3628m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double getNoEntryValue() {
        return this.f3628m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double putIfAbsent(long j, double d) {
        double putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3628m.putIfAbsent(j, d);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3628m.forEachKey(tLongProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3628m.forEachValue(tDoubleProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean forEachEntry(TLongDoubleProcedure tLongDoubleProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3628m.forEachEntry(tLongDoubleProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        synchronized (this.mutex) {
            this.f3628m.transformValues(tDoubleFunction);
        }
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean retainEntries(TLongDoubleProcedure tLongDoubleProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3628m.retainEntries(tLongDoubleProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean increment(long j) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3628m.increment(j);
        }
        return increment;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean adjustValue(long j, double d) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3628m.adjustValue(j, d);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double adjustOrPutValue(long j, double d, double d2) {
        double adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3628m.adjustOrPutValue(j, d, d2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3628m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3628m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3628m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}