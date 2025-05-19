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
    private final TFloatIntMap m;
    final Object mutex;
    private transient TFloatSet keySet = null;
    private transient TIntCollection values = null;

    public TSynchronizedFloatIntMap(TFloatIntMap tFloatIntMap) {
        Objects.requireNonNull(tFloatIntMap);
        this.m = tFloatIntMap;
        this.mutex = this;
    }

    public TSynchronizedFloatIntMap(TFloatIntMap tFloatIntMap, Object obj) {
        this.m = tFloatIntMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean containsKey(float f) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(f);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean containsValue(int i) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(i);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int get(float f) {
        int i;
        synchronized (this.mutex) {
            i = this.m.get(f);
        }
        return i;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int put(float f, int i) {
        int put;
        synchronized (this.mutex) {
            put = this.m.put(f, i);
        }
        return put;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int remove(float f) {
        int remove;
        synchronized (this.mutex) {
            remove = this.m.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void putAll(Map<? extends Float, ? extends Integer> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void putAll(TFloatIntMap tFloatIntMap) {
        synchronized (this.mutex) {
            this.m.putAll(tFloatIntMap);
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
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

    @Override // gnu.trove.map.TFloatIntMap
    public float[] keys() {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public float[] keys(float[] fArr) {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(fArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public TIntCollection valueCollection() {
        TIntCollection tIntCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedIntCollection(this.m.valueCollection(), this.mutex);
            }
            tIntCollection = this.values;
        }
        return tIntCollection;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int[] values() {
        int[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int[] values(int[] iArr) {
        int[] values;
        synchronized (this.mutex) {
            values = this.m.values(iArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public TFloatIntIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public float getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int putIfAbsent(float f, int i) {
        int putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(f, i);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tFloatProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tIntProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean forEachEntry(TFloatIntProcedure tFloatIntProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tFloatIntProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void transformValues(TIntFunction tIntFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tIntFunction);
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean retainEntries(TFloatIntProcedure tFloatIntProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tFloatIntProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean increment(float f) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(f);
        }
        return increment;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean adjustValue(float f, int i) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(f, i);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int adjustOrPutValue(float f, int i, int i2) {
        int adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(f, i, i2);
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
