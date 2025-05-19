package gnu.trove.impl.sync;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TFloatDoubleIterator;
import gnu.trove.map.TFloatDoubleMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TFloatDoubleProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TFloatSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedFloatDoubleMap implements TFloatDoubleMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TFloatDoubleMap m;
    final Object mutex;
    private transient TFloatSet keySet = null;
    private transient TDoubleCollection values = null;

    public TSynchronizedFloatDoubleMap(TFloatDoubleMap tFloatDoubleMap) {
        Objects.requireNonNull(tFloatDoubleMap);
        this.m = tFloatDoubleMap;
        this.mutex = this;
    }

    public TSynchronizedFloatDoubleMap(TFloatDoubleMap tFloatDoubleMap, Object obj) {
        this.m = tFloatDoubleMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean containsKey(float f) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(f);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean containsValue(double d) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(d);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double get(float f) {
        double d;
        synchronized (this.mutex) {
            d = this.m.get(f);
        }
        return d;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double put(float f, double d) {
        double put;
        synchronized (this.mutex) {
            put = this.m.put(f, d);
        }
        return put;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double remove(float f) {
        double remove;
        synchronized (this.mutex) {
            remove = this.m.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public void putAll(Map<? extends Float, ? extends Double> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public void putAll(TFloatDoubleMap tFloatDoubleMap) {
        synchronized (this.mutex) {
            this.m.putAll(tFloatDoubleMap);
        }
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TFloatDoubleMap
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

    @Override // gnu.trove.map.TFloatDoubleMap
    public float[] keys() {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public float[] keys(float[] fArr) {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(fArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
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

    @Override // gnu.trove.map.TFloatDoubleMap
    public double[] values() {
        double[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double[] values(double[] dArr) {
        double[] values;
        synchronized (this.mutex) {
            values = this.m.values(dArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public TFloatDoubleIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public float getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double putIfAbsent(float f, double d) {
        double putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(f, d);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tFloatProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tDoubleProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean forEachEntry(TFloatDoubleProcedure tFloatDoubleProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tFloatDoubleProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tDoubleFunction);
        }
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean retainEntries(TFloatDoubleProcedure tFloatDoubleProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tFloatDoubleProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean increment(float f) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(f);
        }
        return increment;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean adjustValue(float f, double d) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(f, d);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double adjustOrPutValue(float f, double d, double d2) {
        double adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(f, d, d2);
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
