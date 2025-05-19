package gnu.trove.impl.sync;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TFloatShortIterator;
import gnu.trove.map.TFloatShortMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TFloatShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TFloatSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedFloatShortMap implements TFloatShortMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TFloatShortMap m;
    final Object mutex;
    private transient TFloatSet keySet = null;
    private transient TShortCollection values = null;

    public TSynchronizedFloatShortMap(TFloatShortMap tFloatShortMap) {
        Objects.requireNonNull(tFloatShortMap);
        this.m = tFloatShortMap;
        this.mutex = this;
    }

    public TSynchronizedFloatShortMap(TFloatShortMap tFloatShortMap, Object obj) {
        this.m = tFloatShortMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean containsKey(float f) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(f);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean containsValue(short s) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(s);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short get(float f) {
        short s;
        synchronized (this.mutex) {
            s = this.m.get(f);
        }
        return s;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short put(float f, short s) {
        short put;
        synchronized (this.mutex) {
            put = this.m.put(f, s);
        }
        return put;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short remove(float f) {
        short remove;
        synchronized (this.mutex) {
            remove = this.m.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public void putAll(Map<? extends Float, ? extends Short> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TFloatShortMap
    public void putAll(TFloatShortMap tFloatShortMap) {
        synchronized (this.mutex) {
            this.m.putAll(tFloatShortMap);
        }
    }

    @Override // gnu.trove.map.TFloatShortMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TFloatShortMap
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

    @Override // gnu.trove.map.TFloatShortMap
    public float[] keys() {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public float[] keys(float[] fArr) {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(fArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public TShortCollection valueCollection() {
        TShortCollection tShortCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedShortCollection(this.m.valueCollection(), this.mutex);
            }
            tShortCollection = this.values;
        }
        return tShortCollection;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short[] values() {
        short[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short[] values(short[] sArr) {
        short[] values;
        synchronized (this.mutex) {
            values = this.m.values(sArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public TFloatShortIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public float getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short putIfAbsent(float f, short s) {
        short putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(f, s);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tFloatProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tShortProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean forEachEntry(TFloatShortProcedure tFloatShortProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tFloatShortProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public void transformValues(TShortFunction tShortFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tShortFunction);
        }
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean retainEntries(TFloatShortProcedure tFloatShortProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tFloatShortProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean increment(float f) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(f);
        }
        return increment;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean adjustValue(float f, short s) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(f, s);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short adjustOrPutValue(float f, short s, short s2) {
        short adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(f, s, s2);
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
