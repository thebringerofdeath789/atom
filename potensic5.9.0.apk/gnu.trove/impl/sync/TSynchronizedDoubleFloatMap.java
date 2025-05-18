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

    /* renamed from: m */
    private final TDoubleFloatMap f3602m;
    final Object mutex;
    private transient TDoubleSet keySet = null;
    private transient TFloatCollection values = null;

    public TSynchronizedDoubleFloatMap(TDoubleFloatMap tDoubleFloatMap) {
        Objects.requireNonNull(tDoubleFloatMap);
        this.f3602m = tDoubleFloatMap;
        this.mutex = this;
    }

    public TSynchronizedDoubleFloatMap(TDoubleFloatMap tDoubleFloatMap, Object obj) {
        this.f3602m = tDoubleFloatMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3602m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3602m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean containsKey(double d) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3602m.containsKey(d);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean containsValue(float f) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3602m.containsValue(f);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float get(double d) {
        float f;
        synchronized (this.mutex) {
            f = this.f3602m.get(d);
        }
        return f;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float put(double d, float f) {
        float put;
        synchronized (this.mutex) {
            put = this.f3602m.put(d, f);
        }
        return put;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float remove(double d) {
        float remove;
        synchronized (this.mutex) {
            remove = this.f3602m.remove(d);
        }
        return remove;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void putAll(Map<? extends Double, ? extends Float> map) {
        synchronized (this.mutex) {
            this.f3602m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void putAll(TDoubleFloatMap tDoubleFloatMap) {
        synchronized (this.mutex) {
            this.f3602m.putAll(tDoubleFloatMap);
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3602m.clear();
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public TDoubleSet keySet() {
        TDoubleSet tDoubleSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedDoubleSet(this.f3602m.keySet(), this.mutex);
            }
            tDoubleSet = this.keySet;
        }
        return tDoubleSet;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public double[] keys() {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.f3602m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public double[] keys(double[] dArr) {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.f3602m.keys(dArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public TFloatCollection valueCollection() {
        TFloatCollection tFloatCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedFloatCollection(this.f3602m.valueCollection(), this.mutex);
            }
            tFloatCollection = this.values;
        }
        return tFloatCollection;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float[] values() {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3602m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float[] values(float[] fArr) {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3602m.values(fArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public TDoubleFloatIterator iterator() {
        return this.f3602m.iterator();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public double getNoEntryKey() {
        return this.f3602m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float getNoEntryValue() {
        return this.f3602m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float putIfAbsent(double d, float f) {
        float putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3602m.putIfAbsent(d, f);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3602m.forEachKey(tDoubleProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3602m.forEachValue(tFloatProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean forEachEntry(TDoubleFloatProcedure tDoubleFloatProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3602m.forEachEntry(tDoubleFloatProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        synchronized (this.mutex) {
            this.f3602m.transformValues(tFloatFunction);
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean retainEntries(TDoubleFloatProcedure tDoubleFloatProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3602m.retainEntries(tDoubleFloatProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean increment(double d) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3602m.increment(d);
        }
        return increment;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean adjustValue(double d, float f) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3602m.adjustValue(d, f);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float adjustOrPutValue(double d, float f, float f2) {
        float adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3602m.adjustOrPutValue(d, f, f2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3602m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3602m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3602m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}