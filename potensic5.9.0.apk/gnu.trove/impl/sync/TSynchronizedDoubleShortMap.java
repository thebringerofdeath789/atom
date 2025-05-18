package gnu.trove.impl.sync;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TDoubleShortIterator;
import gnu.trove.map.TDoubleShortMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TDoubleShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedDoubleShortMap implements TDoubleShortMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TDoubleShortMap f3606m;
    final Object mutex;
    private transient TDoubleSet keySet = null;
    private transient TShortCollection values = null;

    public TSynchronizedDoubleShortMap(TDoubleShortMap tDoubleShortMap) {
        Objects.requireNonNull(tDoubleShortMap);
        this.f3606m = tDoubleShortMap;
        this.mutex = this;
    }

    public TSynchronizedDoubleShortMap(TDoubleShortMap tDoubleShortMap, Object obj) {
        this.f3606m = tDoubleShortMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3606m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3606m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean containsKey(double d) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3606m.containsKey(d);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean containsValue(short s) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3606m.containsValue(s);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short get(double d) {
        short s;
        synchronized (this.mutex) {
            s = this.f3606m.get(d);
        }
        return s;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short put(double d, short s) {
        short put;
        synchronized (this.mutex) {
            put = this.f3606m.put(d, s);
        }
        return put;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short remove(double d) {
        short remove;
        synchronized (this.mutex) {
            remove = this.f3606m.remove(d);
        }
        return remove;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void putAll(Map<? extends Double, ? extends Short> map) {
        synchronized (this.mutex) {
            this.f3606m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void putAll(TDoubleShortMap tDoubleShortMap) {
        synchronized (this.mutex) {
            this.f3606m.putAll(tDoubleShortMap);
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3606m.clear();
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public TDoubleSet keySet() {
        TDoubleSet tDoubleSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedDoubleSet(this.f3606m.keySet(), this.mutex);
            }
            tDoubleSet = this.keySet;
        }
        return tDoubleSet;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public double[] keys() {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.f3606m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public double[] keys(double[] dArr) {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.f3606m.keys(dArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public TShortCollection valueCollection() {
        TShortCollection tShortCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedShortCollection(this.f3606m.valueCollection(), this.mutex);
            }
            tShortCollection = this.values;
        }
        return tShortCollection;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short[] values() {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3606m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short[] values(short[] sArr) {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3606m.values(sArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public TDoubleShortIterator iterator() {
        return this.f3606m.iterator();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public double getNoEntryKey() {
        return this.f3606m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short getNoEntryValue() {
        return this.f3606m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short putIfAbsent(double d, short s) {
        short putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3606m.putIfAbsent(d, s);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3606m.forEachKey(tDoubleProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3606m.forEachValue(tShortProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean forEachEntry(TDoubleShortProcedure tDoubleShortProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3606m.forEachEntry(tDoubleShortProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void transformValues(TShortFunction tShortFunction) {
        synchronized (this.mutex) {
            this.f3606m.transformValues(tShortFunction);
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean retainEntries(TDoubleShortProcedure tDoubleShortProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3606m.retainEntries(tDoubleShortProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean increment(double d) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3606m.increment(d);
        }
        return increment;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean adjustValue(double d, short s) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3606m.adjustValue(d, s);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short adjustOrPutValue(double d, short s, short s2) {
        short adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3606m.adjustOrPutValue(d, s, s2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3606m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3606m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3606m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}