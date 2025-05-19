package gnu.trove.impl.sync;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TDoubleDoubleIterator;
import gnu.trove.map.TDoubleDoubleMap;
import gnu.trove.procedure.TDoubleDoubleProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedDoubleDoubleMap implements TDoubleDoubleMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TDoubleDoubleMap m;
    final Object mutex;
    private transient TDoubleSet keySet = null;
    private transient TDoubleCollection values = null;

    public TSynchronizedDoubleDoubleMap(TDoubleDoubleMap tDoubleDoubleMap) {
        Objects.requireNonNull(tDoubleDoubleMap);
        this.m = tDoubleDoubleMap;
        this.mutex = this;
    }

    public TSynchronizedDoubleDoubleMap(TDoubleDoubleMap tDoubleDoubleMap, Object obj) {
        this.m = tDoubleDoubleMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean containsKey(double d) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(d);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean containsValue(double d) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(d);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double get(double d) {
        double d2;
        synchronized (this.mutex) {
            d2 = this.m.get(d);
        }
        return d2;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double put(double d, double d2) {
        double put;
        synchronized (this.mutex) {
            put = this.m.put(d, d2);
        }
        return put;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double remove(double d) {
        double remove;
        synchronized (this.mutex) {
            remove = this.m.remove(d);
        }
        return remove;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public void putAll(Map<? extends Double, ? extends Double> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public void putAll(TDoubleDoubleMap tDoubleDoubleMap) {
        synchronized (this.mutex) {
            this.m.putAll(tDoubleDoubleMap);
        }
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public TDoubleSet keySet() {
        TDoubleSet tDoubleSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedDoubleSet(this.m.keySet(), this.mutex);
            }
            tDoubleSet = this.keySet;
        }
        return tDoubleSet;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double[] keys() {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double[] keys(double[] dArr) {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(dArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
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

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double[] values() {
        double[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double[] values(double[] dArr) {
        double[] values;
        synchronized (this.mutex) {
            values = this.m.values(dArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public TDoubleDoubleIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double putIfAbsent(double d, double d2) {
        double putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(d, d2);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tDoubleProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tDoubleProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean forEachEntry(TDoubleDoubleProcedure tDoubleDoubleProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tDoubleDoubleProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tDoubleFunction);
        }
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean retainEntries(TDoubleDoubleProcedure tDoubleDoubleProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tDoubleDoubleProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean increment(double d) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(d);
        }
        return increment;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean adjustValue(double d, double d2) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(d, d2);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double adjustOrPutValue(double d, double d2, double d3) {
        double adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(d, d2, d3);
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
