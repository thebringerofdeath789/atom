package gnu.trove.impl.sync;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TFloatFloatIterator;
import gnu.trove.map.TFloatFloatMap;
import gnu.trove.procedure.TFloatFloatProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TFloatSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedFloatFloatMap implements TFloatFloatMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TFloatFloatMap f3611m;
    final Object mutex;
    private transient TFloatSet keySet = null;
    private transient TFloatCollection values = null;

    public TSynchronizedFloatFloatMap(TFloatFloatMap tFloatFloatMap) {
        Objects.requireNonNull(tFloatFloatMap);
        this.f3611m = tFloatFloatMap;
        this.mutex = this;
    }

    public TSynchronizedFloatFloatMap(TFloatFloatMap tFloatFloatMap, Object obj) {
        this.f3611m = tFloatFloatMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3611m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3611m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean containsKey(float f) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3611m.containsKey(f);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean containsValue(float f) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3611m.containsValue(f);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float get(float f) {
        float f2;
        synchronized (this.mutex) {
            f2 = this.f3611m.get(f);
        }
        return f2;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float put(float f, float f2) {
        float put;
        synchronized (this.mutex) {
            put = this.f3611m.put(f, f2);
        }
        return put;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float remove(float f) {
        float remove;
        synchronized (this.mutex) {
            remove = this.f3611m.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public void putAll(Map<? extends Float, ? extends Float> map) {
        synchronized (this.mutex) {
            this.f3611m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public void putAll(TFloatFloatMap tFloatFloatMap) {
        synchronized (this.mutex) {
            this.f3611m.putAll(tFloatFloatMap);
        }
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3611m.clear();
        }
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public TFloatSet keySet() {
        TFloatSet tFloatSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedFloatSet(this.f3611m.keySet(), this.mutex);
            }
            tFloatSet = this.keySet;
        }
        return tFloatSet;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float[] keys() {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.f3611m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float[] keys(float[] fArr) {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.f3611m.keys(fArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public TFloatCollection valueCollection() {
        TFloatCollection tFloatCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedFloatCollection(this.f3611m.valueCollection(), this.mutex);
            }
            tFloatCollection = this.values;
        }
        return tFloatCollection;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float[] values() {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3611m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float[] values(float[] fArr) {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3611m.values(fArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public TFloatFloatIterator iterator() {
        return this.f3611m.iterator();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float getNoEntryKey() {
        return this.f3611m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float getNoEntryValue() {
        return this.f3611m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float putIfAbsent(float f, float f2) {
        float putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3611m.putIfAbsent(f, f2);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3611m.forEachKey(tFloatProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3611m.forEachValue(tFloatProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean forEachEntry(TFloatFloatProcedure tFloatFloatProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3611m.forEachEntry(tFloatFloatProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        synchronized (this.mutex) {
            this.f3611m.transformValues(tFloatFunction);
        }
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean retainEntries(TFloatFloatProcedure tFloatFloatProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3611m.retainEntries(tFloatFloatProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean increment(float f) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3611m.increment(f);
        }
        return increment;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean adjustValue(float f, float f2) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3611m.adjustValue(f, f2);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float adjustOrPutValue(float f, float f2, float f3) {
        float adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3611m.adjustOrPutValue(f, f2, f3);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3611m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3611m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3611m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}