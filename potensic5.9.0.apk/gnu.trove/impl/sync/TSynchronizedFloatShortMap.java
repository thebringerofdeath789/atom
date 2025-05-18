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

    /* renamed from: m */
    private final TFloatShortMap f3615m;
    final Object mutex;
    private transient TFloatSet keySet = null;
    private transient TShortCollection values = null;

    public TSynchronizedFloatShortMap(TFloatShortMap tFloatShortMap) {
        Objects.requireNonNull(tFloatShortMap);
        this.f3615m = tFloatShortMap;
        this.mutex = this;
    }

    public TSynchronizedFloatShortMap(TFloatShortMap tFloatShortMap, Object obj) {
        this.f3615m = tFloatShortMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3615m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3615m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean containsKey(float f) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3615m.containsKey(f);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean containsValue(short s) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3615m.containsValue(s);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short get(float f) {
        short s;
        synchronized (this.mutex) {
            s = this.f3615m.get(f);
        }
        return s;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short put(float f, short s) {
        short put;
        synchronized (this.mutex) {
            put = this.f3615m.put(f, s);
        }
        return put;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short remove(float f) {
        short remove;
        synchronized (this.mutex) {
            remove = this.f3615m.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public void putAll(Map<? extends Float, ? extends Short> map) {
        synchronized (this.mutex) {
            this.f3615m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TFloatShortMap
    public void putAll(TFloatShortMap tFloatShortMap) {
        synchronized (this.mutex) {
            this.f3615m.putAll(tFloatShortMap);
        }
    }

    @Override // gnu.trove.map.TFloatShortMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3615m.clear();
        }
    }

    @Override // gnu.trove.map.TFloatShortMap
    public TFloatSet keySet() {
        TFloatSet tFloatSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedFloatSet(this.f3615m.keySet(), this.mutex);
            }
            tFloatSet = this.keySet;
        }
        return tFloatSet;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public float[] keys() {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.f3615m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public float[] keys(float[] fArr) {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.f3615m.keys(fArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public TShortCollection valueCollection() {
        TShortCollection tShortCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedShortCollection(this.f3615m.valueCollection(), this.mutex);
            }
            tShortCollection = this.values;
        }
        return tShortCollection;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short[] values() {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3615m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short[] values(short[] sArr) {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3615m.values(sArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public TFloatShortIterator iterator() {
        return this.f3615m.iterator();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public float getNoEntryKey() {
        return this.f3615m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short getNoEntryValue() {
        return this.f3615m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short putIfAbsent(float f, short s) {
        short putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3615m.putIfAbsent(f, s);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3615m.forEachKey(tFloatProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3615m.forEachValue(tShortProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean forEachEntry(TFloatShortProcedure tFloatShortProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3615m.forEachEntry(tFloatShortProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public void transformValues(TShortFunction tShortFunction) {
        synchronized (this.mutex) {
            this.f3615m.transformValues(tShortFunction);
        }
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean retainEntries(TFloatShortProcedure tFloatShortProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3615m.retainEntries(tFloatShortProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean increment(float f) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3615m.increment(f);
        }
        return increment;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean adjustValue(float f, short s) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3615m.adjustValue(f, s);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short adjustOrPutValue(float f, short s, short s2) {
        short adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3615m.adjustOrPutValue(f, s, s2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3615m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3615m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3615m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}