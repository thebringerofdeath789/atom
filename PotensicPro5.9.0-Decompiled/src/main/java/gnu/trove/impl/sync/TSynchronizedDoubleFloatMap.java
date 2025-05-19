package gnu.trove.impl.sync;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TDoubleFloatIterator;
import gnu.trove.map.TDoubleFloatMap;
import gnu.trove.procedure.TDoubleFloatProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedDoubleFloatMap implements TDoubleFloatMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TDoubleFloatMap m;
    final Object mutex;
    private transient TDoubleSet keySet = null;
    private transient TFloatCollection values = null;

    public TSynchronizedDoubleFloatMap(TDoubleFloatMap tDoubleFloatMap) {
        Objects.requireNonNull(tDoubleFloatMap);
        this.m = tDoubleFloatMap;
        this.mutex = this;
    }

    public TSynchronizedDoubleFloatMap(TDoubleFloatMap tDoubleFloatMap, Object obj) {
        this.m = tDoubleFloatMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean containsKey(double d) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(d);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean containsValue(float f) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(f);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float get(double d) {
        float f;
        synchronized (this.mutex) {
            f = this.m.get(d);
        }
        return f;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float put(double d, float f) {
        float put;
        synchronized (this.mutex) {
            put = this.m.put(d, f);
        }
        return put;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float remove(double d) {
        float remove;
        synchronized (this.mutex) {
            remove = this.m.remove(d);
        }
        return remove;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void putAll(Map<? extends Double, ? extends Float> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void putAll(TDoubleFloatMap tDoubleFloatMap) {
        synchronized (this.mutex) {
            this.m.putAll(tDoubleFloatMap);
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
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

    @Override // gnu.trove.map.TDoubleFloatMap
    public double[] keys() {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public double[] keys(double[] dArr) {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(dArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public TFloatCollection valueCollection() {
        TFloatCollection tFloatCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedFloatCollection(this.m.valueCollection(), this.mutex);
            }
            tFloatCollection = this.values;
        }
        return tFloatCollection;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float[] values() {
        float[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float[] values(float[] fArr) {
        float[] values;
        synchronized (this.mutex) {
            values = this.m.values(fArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public TDoubleFloatIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public double getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float putIfAbsent(double d, float f) {
        float putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(d, f);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tDoubleProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tFloatProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean forEachEntry(TDoubleFloatProcedure tDoubleFloatProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tDoubleFloatProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tFloatFunction);
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean retainEntries(TDoubleFloatProcedure tDoubleFloatProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tDoubleFloatProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean increment(double d) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(d);
        }
        return increment;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean adjustValue(double d, float f) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(d, f);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float adjustOrPutValue(double d, float f, float f2) {
        float adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(d, f, f2);
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
