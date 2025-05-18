package gnu.trove.impl.sync;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TShortFloatIterator;
import gnu.trove.map.TShortFloatMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TShortFloatProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedShortFloatMap implements TShortFloatMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TShortFloatMap f3645m;
    final Object mutex;
    private transient TShortSet keySet = null;
    private transient TFloatCollection values = null;

    public TSynchronizedShortFloatMap(TShortFloatMap tShortFloatMap) {
        Objects.requireNonNull(tShortFloatMap);
        this.f3645m = tShortFloatMap;
        this.mutex = this;
    }

    public TSynchronizedShortFloatMap(TShortFloatMap tShortFloatMap, Object obj) {
        this.f3645m = tShortFloatMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3645m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3645m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean containsKey(short s) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3645m.containsKey(s);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean containsValue(float f) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3645m.containsValue(f);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float get(short s) {
        float f;
        synchronized (this.mutex) {
            f = this.f3645m.get(s);
        }
        return f;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float put(short s, float f) {
        float put;
        synchronized (this.mutex) {
            put = this.f3645m.put(s, f);
        }
        return put;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float remove(short s) {
        float remove;
        synchronized (this.mutex) {
            remove = this.f3645m.remove(s);
        }
        return remove;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public void putAll(Map<? extends Short, ? extends Float> map) {
        synchronized (this.mutex) {
            this.f3645m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TShortFloatMap
    public void putAll(TShortFloatMap tShortFloatMap) {
        synchronized (this.mutex) {
            this.f3645m.putAll(tShortFloatMap);
        }
    }

    @Override // gnu.trove.map.TShortFloatMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3645m.clear();
        }
    }

    @Override // gnu.trove.map.TShortFloatMap
    public TShortSet keySet() {
        TShortSet tShortSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedShortSet(this.f3645m.keySet(), this.mutex);
            }
            tShortSet = this.keySet;
        }
        return tShortSet;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public short[] keys() {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3645m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public short[] keys(short[] sArr) {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3645m.keys(sArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public TFloatCollection valueCollection() {
        TFloatCollection tFloatCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedFloatCollection(this.f3645m.valueCollection(), this.mutex);
            }
            tFloatCollection = this.values;
        }
        return tFloatCollection;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float[] values() {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3645m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float[] values(float[] fArr) {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3645m.values(fArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public TShortFloatIterator iterator() {
        return this.f3645m.iterator();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public short getNoEntryKey() {
        return this.f3645m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float getNoEntryValue() {
        return this.f3645m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float putIfAbsent(short s, float f) {
        float putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3645m.putIfAbsent(s, f);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3645m.forEachKey(tShortProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3645m.forEachValue(tFloatProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean forEachEntry(TShortFloatProcedure tShortFloatProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3645m.forEachEntry(tShortFloatProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        synchronized (this.mutex) {
            this.f3645m.transformValues(tFloatFunction);
        }
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean retainEntries(TShortFloatProcedure tShortFloatProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3645m.retainEntries(tShortFloatProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean increment(short s) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3645m.increment(s);
        }
        return increment;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean adjustValue(short s, float f) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3645m.adjustValue(s, f);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float adjustOrPutValue(short s, float f, float f2) {
        float adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3645m.adjustOrPutValue(s, f, f2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3645m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3645m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3645m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}