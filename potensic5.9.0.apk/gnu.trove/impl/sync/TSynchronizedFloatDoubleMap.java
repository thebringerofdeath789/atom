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

    /* renamed from: m */
    private final TFloatDoubleMap f3610m;
    final Object mutex;
    private transient TFloatSet keySet = null;
    private transient TDoubleCollection values = null;

    public TSynchronizedFloatDoubleMap(TFloatDoubleMap tFloatDoubleMap) {
        Objects.requireNonNull(tFloatDoubleMap);
        this.f3610m = tFloatDoubleMap;
        this.mutex = this;
    }

    public TSynchronizedFloatDoubleMap(TFloatDoubleMap tFloatDoubleMap, Object obj) {
        this.f3610m = tFloatDoubleMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3610m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3610m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean containsKey(float f) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3610m.containsKey(f);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean containsValue(double d) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3610m.containsValue(d);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double get(float f) {
        double d;
        synchronized (this.mutex) {
            d = this.f3610m.get(f);
        }
        return d;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double put(float f, double d) {
        double put;
        synchronized (this.mutex) {
            put = this.f3610m.put(f, d);
        }
        return put;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double remove(float f) {
        double remove;
        synchronized (this.mutex) {
            remove = this.f3610m.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public void putAll(Map<? extends Float, ? extends Double> map) {
        synchronized (this.mutex) {
            this.f3610m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public void putAll(TFloatDoubleMap tFloatDoubleMap) {
        synchronized (this.mutex) {
            this.f3610m.putAll(tFloatDoubleMap);
        }
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3610m.clear();
        }
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public TFloatSet keySet() {
        TFloatSet tFloatSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedFloatSet(this.f3610m.keySet(), this.mutex);
            }
            tFloatSet = this.keySet;
        }
        return tFloatSet;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public float[] keys() {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.f3610m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public float[] keys(float[] fArr) {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.f3610m.keys(fArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public TDoubleCollection valueCollection() {
        TDoubleCollection tDoubleCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedDoubleCollection(this.f3610m.valueCollection(), this.mutex);
            }
            tDoubleCollection = this.values;
        }
        return tDoubleCollection;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double[] values() {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3610m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double[] values(double[] dArr) {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3610m.values(dArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public TFloatDoubleIterator iterator() {
        return this.f3610m.iterator();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public float getNoEntryKey() {
        return this.f3610m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double getNoEntryValue() {
        return this.f3610m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double putIfAbsent(float f, double d) {
        double putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3610m.putIfAbsent(f, d);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3610m.forEachKey(tFloatProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3610m.forEachValue(tDoubleProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean forEachEntry(TFloatDoubleProcedure tFloatDoubleProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3610m.forEachEntry(tFloatDoubleProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        synchronized (this.mutex) {
            this.f3610m.transformValues(tDoubleFunction);
        }
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean retainEntries(TFloatDoubleProcedure tFloatDoubleProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3610m.retainEntries(tFloatDoubleProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean increment(float f) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3610m.increment(f);
        }
        return increment;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean adjustValue(float f, double d) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3610m.adjustValue(f, d);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double adjustOrPutValue(float f, double d, double d2) {
        double adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3610m.adjustOrPutValue(f, d, d2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3610m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3610m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3610m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}