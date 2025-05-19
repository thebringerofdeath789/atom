package gnu.trove.impl.sync;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TFloatByteIterator;
import gnu.trove.map.TFloatByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TFloatByteProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TFloatSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedFloatByteMap implements TFloatByteMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TFloatByteMap m;
    final Object mutex;
    private transient TFloatSet keySet = null;
    private transient TByteCollection values = null;

    public TSynchronizedFloatByteMap(TFloatByteMap tFloatByteMap) {
        Objects.requireNonNull(tFloatByteMap);
        this.m = tFloatByteMap;
        this.mutex = this;
    }

    public TSynchronizedFloatByteMap(TFloatByteMap tFloatByteMap, Object obj) {
        this.m = tFloatByteMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean containsKey(float f) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(f);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean containsValue(byte b) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(b);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte get(float f) {
        byte b;
        synchronized (this.mutex) {
            b = this.m.get(f);
        }
        return b;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte put(float f, byte b) {
        byte put;
        synchronized (this.mutex) {
            put = this.m.put(f, b);
        }
        return put;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte remove(float f) {
        byte remove;
        synchronized (this.mutex) {
            remove = this.m.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public void putAll(Map<? extends Float, ? extends Byte> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TFloatByteMap
    public void putAll(TFloatByteMap tFloatByteMap) {
        synchronized (this.mutex) {
            this.m.putAll(tFloatByteMap);
        }
    }

    @Override // gnu.trove.map.TFloatByteMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TFloatByteMap
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

    @Override // gnu.trove.map.TFloatByteMap
    public float[] keys() {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public float[] keys(float[] fArr) {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(fArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public TByteCollection valueCollection() {
        TByteCollection tByteCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedByteCollection(this.m.valueCollection(), this.mutex);
            }
            tByteCollection = this.values;
        }
        return tByteCollection;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte[] values() {
        byte[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte[] values(byte[] bArr) {
        byte[] values;
        synchronized (this.mutex) {
            values = this.m.values(bArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public TFloatByteIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public float getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte putIfAbsent(float f, byte b) {
        byte putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(f, b);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tFloatProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tByteProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean forEachEntry(TFloatByteProcedure tFloatByteProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tFloatByteProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public void transformValues(TByteFunction tByteFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tByteFunction);
        }
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean retainEntries(TFloatByteProcedure tFloatByteProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tFloatByteProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean increment(float f) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(f);
        }
        return increment;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean adjustValue(float f, byte b) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(f, b);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte adjustOrPutValue(float f, byte b, byte b2) {
        byte adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(f, b, b2);
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
