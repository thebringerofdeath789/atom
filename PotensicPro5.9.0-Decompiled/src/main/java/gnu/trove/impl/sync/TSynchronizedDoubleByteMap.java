package gnu.trove.impl.sync;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TDoubleByteIterator;
import gnu.trove.map.TDoubleByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TDoubleByteProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedDoubleByteMap implements TDoubleByteMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TDoubleByteMap m;
    final Object mutex;
    private transient TDoubleSet keySet = null;
    private transient TByteCollection values = null;

    public TSynchronizedDoubleByteMap(TDoubleByteMap tDoubleByteMap) {
        Objects.requireNonNull(tDoubleByteMap);
        this.m = tDoubleByteMap;
        this.mutex = this;
    }

    public TSynchronizedDoubleByteMap(TDoubleByteMap tDoubleByteMap, Object obj) {
        this.m = tDoubleByteMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean containsKey(double d) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(d);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean containsValue(byte b) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(b);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte get(double d) {
        byte b;
        synchronized (this.mutex) {
            b = this.m.get(d);
        }
        return b;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte put(double d, byte b) {
        byte put;
        synchronized (this.mutex) {
            put = this.m.put(d, b);
        }
        return put;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte remove(double d) {
        byte remove;
        synchronized (this.mutex) {
            remove = this.m.remove(d);
        }
        return remove;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public void putAll(Map<? extends Double, ? extends Byte> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public void putAll(TDoubleByteMap tDoubleByteMap) {
        synchronized (this.mutex) {
            this.m.putAll(tDoubleByteMap);
        }
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public TDoubleSet keySet() {
        TDoubleSet tDoubleSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedDoubleSet(this.m.keySet(), this.mutex);
            }
            tDoubleSet = this.keySet;
        }
        return tDoubleSet;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public double[] keys() {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public double[] keys(double[] dArr) {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(dArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleByteMap
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

    @Override // gnu.trove.map.TDoubleByteMap
    public byte[] values() {
        byte[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte[] values(byte[] bArr) {
        byte[] values;
        synchronized (this.mutex) {
            values = this.m.values(bArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public TDoubleByteIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public double getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte putIfAbsent(double d, byte b) {
        byte putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(d, b);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tDoubleProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tByteProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean forEachEntry(TDoubleByteProcedure tDoubleByteProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tDoubleByteProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public void transformValues(TByteFunction tByteFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tByteFunction);
        }
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean retainEntries(TDoubleByteProcedure tDoubleByteProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tDoubleByteProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean increment(double d) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(d);
        }
        return increment;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean adjustValue(double d, byte b) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(d, b);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte adjustOrPutValue(double d, byte b, byte b2) {
        byte adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(d, b, b2);
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
