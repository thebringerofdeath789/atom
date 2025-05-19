package gnu.trove.impl.sync;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TByteFloatIterator;
import gnu.trove.map.TByteFloatMap;
import gnu.trove.procedure.TByteFloatProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TByteSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedByteFloatMap implements TByteFloatMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TByteFloatMap m;
    final Object mutex;
    private transient TByteSet keySet = null;
    private transient TFloatCollection values = null;

    public TSynchronizedByteFloatMap(TByteFloatMap tByteFloatMap) {
        Objects.requireNonNull(tByteFloatMap);
        this.m = tByteFloatMap;
        this.mutex = this;
    }

    public TSynchronizedByteFloatMap(TByteFloatMap tByteFloatMap, Object obj) {
        this.m = tByteFloatMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean containsKey(byte b) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(b);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean containsValue(float f) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(f);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float get(byte b) {
        float f;
        synchronized (this.mutex) {
            f = this.m.get(b);
        }
        return f;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float put(byte b, float f) {
        float put;
        synchronized (this.mutex) {
            put = this.m.put(b, f);
        }
        return put;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float remove(byte b) {
        float remove;
        synchronized (this.mutex) {
            remove = this.m.remove(b);
        }
        return remove;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public void putAll(Map<? extends Byte, ? extends Float> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TByteFloatMap
    public void putAll(TByteFloatMap tByteFloatMap) {
        synchronized (this.mutex) {
            this.m.putAll(tByteFloatMap);
        }
    }

    @Override // gnu.trove.map.TByteFloatMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TByteFloatMap
    public TByteSet keySet() {
        TByteSet tByteSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedByteSet(this.m.keySet(), this.mutex);
            }
            tByteSet = this.keySet;
        }
        return tByteSet;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public byte[] keys() {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public byte[] keys(byte[] bArr) {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(bArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteFloatMap
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

    @Override // gnu.trove.map.TByteFloatMap
    public float[] values() {
        float[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float[] values(float[] fArr) {
        float[] values;
        synchronized (this.mutex) {
            values = this.m.values(fArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public TByteFloatIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public byte getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float putIfAbsent(byte b, float f) {
        float putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(b, f);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tByteProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tFloatProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean forEachEntry(TByteFloatProcedure tByteFloatProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tByteFloatProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tFloatFunction);
        }
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean retainEntries(TByteFloatProcedure tByteFloatProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tByteFloatProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean increment(byte b) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(b);
        }
        return increment;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean adjustValue(byte b, float f) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(b, f);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float adjustOrPutValue(byte b, float f, float f2) {
        float adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(b, f, f2);
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
