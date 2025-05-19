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
    private final TDoubleShortMap m;
    final Object mutex;
    private transient TDoubleSet keySet = null;
    private transient TShortCollection values = null;

    public TSynchronizedDoubleShortMap(TDoubleShortMap tDoubleShortMap) {
        Objects.requireNonNull(tDoubleShortMap);
        this.m = tDoubleShortMap;
        this.mutex = this;
    }

    public TSynchronizedDoubleShortMap(TDoubleShortMap tDoubleShortMap, Object obj) {
        this.m = tDoubleShortMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean containsKey(double d) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(d);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean containsValue(short s) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(s);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short get(double d) {
        short s;
        synchronized (this.mutex) {
            s = this.m.get(d);
        }
        return s;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short put(double d, short s) {
        short put;
        synchronized (this.mutex) {
            put = this.m.put(d, s);
        }
        return put;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short remove(double d) {
        short remove;
        synchronized (this.mutex) {
            remove = this.m.remove(d);
        }
        return remove;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void putAll(Map<? extends Double, ? extends Short> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void putAll(TDoubleShortMap tDoubleShortMap) {
        synchronized (this.mutex) {
            this.m.putAll(tDoubleShortMap);
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
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

    @Override // gnu.trove.map.TDoubleShortMap
    public double[] keys() {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public double[] keys(double[] dArr) {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(dArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleShortMap
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

    @Override // gnu.trove.map.TDoubleShortMap
    public short[] values() {
        short[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short[] values(short[] sArr) {
        short[] values;
        synchronized (this.mutex) {
            values = this.m.values(sArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public TDoubleShortIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public double getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short putIfAbsent(double d, short s) {
        short putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(d, s);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tDoubleProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tShortProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean forEachEntry(TDoubleShortProcedure tDoubleShortProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tDoubleShortProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void transformValues(TShortFunction tShortFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tShortFunction);
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean retainEntries(TDoubleShortProcedure tDoubleShortProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tDoubleShortProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean increment(double d) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(d);
        }
        return increment;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean adjustValue(double d, short s) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(d, s);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short adjustOrPutValue(double d, short s, short s2) {
        short adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(d, s, s2);
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
