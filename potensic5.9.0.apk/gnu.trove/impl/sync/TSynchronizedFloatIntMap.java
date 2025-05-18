package gnu.trove.impl.sync;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TFloatIntIterator;
import gnu.trove.map.TFloatIntMap;
import gnu.trove.procedure.TFloatIntProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TFloatSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedFloatIntMap implements TFloatIntMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TFloatIntMap f3612m;
    final Object mutex;
    private transient TFloatSet keySet = null;
    private transient TIntCollection values = null;

    public TSynchronizedFloatIntMap(TFloatIntMap tFloatIntMap) {
        Objects.requireNonNull(tFloatIntMap);
        this.f3612m = tFloatIntMap;
        this.mutex = this;
    }

    public TSynchronizedFloatIntMap(TFloatIntMap tFloatIntMap, Object obj) {
        this.f3612m = tFloatIntMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3612m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3612m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean containsKey(float f) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3612m.containsKey(f);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean containsValue(int i) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3612m.containsValue(i);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int get(float f) {
        int i;
        synchronized (this.mutex) {
            i = this.f3612m.get(f);
        }
        return i;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int put(float f, int i) {
        int put;
        synchronized (this.mutex) {
            put = this.f3612m.put(f, i);
        }
        return put;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int remove(float f) {
        int remove;
        synchronized (this.mutex) {
            remove = this.f3612m.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void putAll(Map<? extends Float, ? extends Integer> map) {
        synchronized (this.mutex) {
            this.f3612m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void putAll(TFloatIntMap tFloatIntMap) {
        synchronized (this.mutex) {
            this.f3612m.putAll(tFloatIntMap);
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3612m.clear();
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
    public TFloatSet keySet() {
        TFloatSet tFloatSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedFloatSet(this.f3612m.keySet(), this.mutex);
            }
            tFloatSet = this.keySet;
        }
        return tFloatSet;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public float[] keys() {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.f3612m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public float[] keys(float[] fArr) {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.f3612m.keys(fArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public TIntCollection valueCollection() {
        TIntCollection tIntCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedIntCollection(this.f3612m.valueCollection(), this.mutex);
            }
            tIntCollection = this.values;
        }
        return tIntCollection;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int[] values() {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3612m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int[] values(int[] iArr) {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3612m.values(iArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public TFloatIntIterator iterator() {
        return this.f3612m.iterator();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public float getNoEntryKey() {
        return this.f3612m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int getNoEntryValue() {
        return this.f3612m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int putIfAbsent(float f, int i) {
        int putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3612m.putIfAbsent(f, i);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3612m.forEachKey(tFloatProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3612m.forEachValue(tIntProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean forEachEntry(TFloatIntProcedure tFloatIntProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3612m.forEachEntry(tFloatIntProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void transformValues(TIntFunction tIntFunction) {
        synchronized (this.mutex) {
            this.f3612m.transformValues(tIntFunction);
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean retainEntries(TFloatIntProcedure tFloatIntProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3612m.retainEntries(tFloatIntProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean increment(float f) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3612m.increment(f);
        }
        return increment;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean adjustValue(float f, int i) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3612m.adjustValue(f, i);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int adjustOrPutValue(float f, int i, int i2) {
        int adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3612m.adjustOrPutValue(f, i, i2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3612m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3612m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3612m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}