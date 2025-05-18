package gnu.trove.impl.sync;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TByteDoubleIterator;
import gnu.trove.map.TByteDoubleMap;
import gnu.trove.procedure.TByteDoubleProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TByteSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedByteDoubleMap implements TByteDoubleMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TByteDoubleMap f3583m;
    final Object mutex;
    private transient TByteSet keySet = null;
    private transient TDoubleCollection values = null;

    public TSynchronizedByteDoubleMap(TByteDoubleMap tByteDoubleMap) {
        Objects.requireNonNull(tByteDoubleMap);
        this.f3583m = tByteDoubleMap;
        this.mutex = this;
    }

    public TSynchronizedByteDoubleMap(TByteDoubleMap tByteDoubleMap, Object obj) {
        this.f3583m = tByteDoubleMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3583m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3583m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean containsKey(byte b) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3583m.containsKey(b);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean containsValue(double d) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3583m.containsValue(d);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double get(byte b) {
        double d;
        synchronized (this.mutex) {
            d = this.f3583m.get(b);
        }
        return d;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double put(byte b, double d) {
        double put;
        synchronized (this.mutex) {
            put = this.f3583m.put(b, d);
        }
        return put;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double remove(byte b) {
        double remove;
        synchronized (this.mutex) {
            remove = this.f3583m.remove(b);
        }
        return remove;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public void putAll(Map<? extends Byte, ? extends Double> map) {
        synchronized (this.mutex) {
            this.f3583m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public void putAll(TByteDoubleMap tByteDoubleMap) {
        synchronized (this.mutex) {
            this.f3583m.putAll(tByteDoubleMap);
        }
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3583m.clear();
        }
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public TByteSet keySet() {
        TByteSet tByteSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedByteSet(this.f3583m.keySet(), this.mutex);
            }
            tByteSet = this.keySet;
        }
        return tByteSet;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public byte[] keys() {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3583m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public byte[] keys(byte[] bArr) {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3583m.keys(bArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public TDoubleCollection valueCollection() {
        TDoubleCollection tDoubleCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedDoubleCollection(this.f3583m.valueCollection(), this.mutex);
            }
            tDoubleCollection = this.values;
        }
        return tDoubleCollection;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double[] values() {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3583m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double[] values(double[] dArr) {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3583m.values(dArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public TByteDoubleIterator iterator() {
        return this.f3583m.iterator();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public byte getNoEntryKey() {
        return this.f3583m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double getNoEntryValue() {
        return this.f3583m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double putIfAbsent(byte b, double d) {
        double putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3583m.putIfAbsent(b, d);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3583m.forEachKey(tByteProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3583m.forEachValue(tDoubleProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean forEachEntry(TByteDoubleProcedure tByteDoubleProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3583m.forEachEntry(tByteDoubleProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        synchronized (this.mutex) {
            this.f3583m.transformValues(tDoubleFunction);
        }
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean retainEntries(TByteDoubleProcedure tByteDoubleProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3583m.retainEntries(tByteDoubleProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean increment(byte b) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3583m.increment(b);
        }
        return increment;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean adjustValue(byte b, double d) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3583m.adjustValue(b, d);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double adjustOrPutValue(byte b, double d, double d2) {
        double adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3583m.adjustOrPutValue(b, d, d2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3583m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3583m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3583m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}