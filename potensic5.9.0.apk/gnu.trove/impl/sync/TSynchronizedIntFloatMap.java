package gnu.trove.impl.sync;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TIntFloatIterator;
import gnu.trove.map.TIntFloatMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TIntFloatProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedIntFloatMap implements TIntFloatMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TIntFloatMap f3620m;
    final Object mutex;
    private transient TIntSet keySet = null;
    private transient TFloatCollection values = null;

    public TSynchronizedIntFloatMap(TIntFloatMap tIntFloatMap) {
        Objects.requireNonNull(tIntFloatMap);
        this.f3620m = tIntFloatMap;
        this.mutex = this;
    }

    public TSynchronizedIntFloatMap(TIntFloatMap tIntFloatMap, Object obj) {
        this.f3620m = tIntFloatMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3620m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3620m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean containsKey(int i) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3620m.containsKey(i);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean containsValue(float f) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3620m.containsValue(f);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float get(int i) {
        float f;
        synchronized (this.mutex) {
            f = this.f3620m.get(i);
        }
        return f;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float put(int i, float f) {
        float put;
        synchronized (this.mutex) {
            put = this.f3620m.put(i, f);
        }
        return put;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float remove(int i) {
        float remove;
        synchronized (this.mutex) {
            remove = this.f3620m.remove(i);
        }
        return remove;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public void putAll(Map<? extends Integer, ? extends Float> map) {
        synchronized (this.mutex) {
            this.f3620m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TIntFloatMap
    public void putAll(TIntFloatMap tIntFloatMap) {
        synchronized (this.mutex) {
            this.f3620m.putAll(tIntFloatMap);
        }
    }

    @Override // gnu.trove.map.TIntFloatMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3620m.clear();
        }
    }

    @Override // gnu.trove.map.TIntFloatMap
    public TIntSet keySet() {
        TIntSet tIntSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedIntSet(this.f3620m.keySet(), this.mutex);
            }
            tIntSet = this.keySet;
        }
        return tIntSet;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public int[] keys() {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3620m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public int[] keys(int[] iArr) {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3620m.keys(iArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public TFloatCollection valueCollection() {
        TFloatCollection tFloatCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedFloatCollection(this.f3620m.valueCollection(), this.mutex);
            }
            tFloatCollection = this.values;
        }
        return tFloatCollection;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float[] values() {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3620m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float[] values(float[] fArr) {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3620m.values(fArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public TIntFloatIterator iterator() {
        return this.f3620m.iterator();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public int getNoEntryKey() {
        return this.f3620m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float getNoEntryValue() {
        return this.f3620m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float putIfAbsent(int i, float f) {
        float putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3620m.putIfAbsent(i, f);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3620m.forEachKey(tIntProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3620m.forEachValue(tFloatProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean forEachEntry(TIntFloatProcedure tIntFloatProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3620m.forEachEntry(tIntFloatProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        synchronized (this.mutex) {
            this.f3620m.transformValues(tFloatFunction);
        }
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean retainEntries(TIntFloatProcedure tIntFloatProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3620m.retainEntries(tIntFloatProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean increment(int i) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3620m.increment(i);
        }
        return increment;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean adjustValue(int i, float f) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3620m.adjustValue(i, f);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float adjustOrPutValue(int i, float f, float f2) {
        float adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3620m.adjustOrPutValue(i, f, f2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3620m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3620m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3620m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}