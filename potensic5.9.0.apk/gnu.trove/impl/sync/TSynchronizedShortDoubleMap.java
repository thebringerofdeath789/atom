package gnu.trove.impl.sync;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TShortDoubleIterator;
import gnu.trove.map.TShortDoubleMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TShortDoubleProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedShortDoubleMap implements TShortDoubleMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TShortDoubleMap f3644m;
    final Object mutex;
    private transient TShortSet keySet = null;
    private transient TDoubleCollection values = null;

    public TSynchronizedShortDoubleMap(TShortDoubleMap tShortDoubleMap) {
        Objects.requireNonNull(tShortDoubleMap);
        this.f3644m = tShortDoubleMap;
        this.mutex = this;
    }

    public TSynchronizedShortDoubleMap(TShortDoubleMap tShortDoubleMap, Object obj) {
        this.f3644m = tShortDoubleMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3644m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3644m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean containsKey(short s) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3644m.containsKey(s);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean containsValue(double d) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3644m.containsValue(d);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double get(short s) {
        double d;
        synchronized (this.mutex) {
            d = this.f3644m.get(s);
        }
        return d;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double put(short s, double d) {
        double put;
        synchronized (this.mutex) {
            put = this.f3644m.put(s, d);
        }
        return put;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double remove(short s) {
        double remove;
        synchronized (this.mutex) {
            remove = this.f3644m.remove(s);
        }
        return remove;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public void putAll(Map<? extends Short, ? extends Double> map) {
        synchronized (this.mutex) {
            this.f3644m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public void putAll(TShortDoubleMap tShortDoubleMap) {
        synchronized (this.mutex) {
            this.f3644m.putAll(tShortDoubleMap);
        }
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3644m.clear();
        }
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public TShortSet keySet() {
        TShortSet tShortSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedShortSet(this.f3644m.keySet(), this.mutex);
            }
            tShortSet = this.keySet;
        }
        return tShortSet;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public short[] keys() {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3644m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public short[] keys(short[] sArr) {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3644m.keys(sArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public TDoubleCollection valueCollection() {
        TDoubleCollection tDoubleCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedDoubleCollection(this.f3644m.valueCollection(), this.mutex);
            }
            tDoubleCollection = this.values;
        }
        return tDoubleCollection;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double[] values() {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3644m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double[] values(double[] dArr) {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3644m.values(dArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public TShortDoubleIterator iterator() {
        return this.f3644m.iterator();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public short getNoEntryKey() {
        return this.f3644m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double getNoEntryValue() {
        return this.f3644m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double putIfAbsent(short s, double d) {
        double putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3644m.putIfAbsent(s, d);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3644m.forEachKey(tShortProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3644m.forEachValue(tDoubleProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean forEachEntry(TShortDoubleProcedure tShortDoubleProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3644m.forEachEntry(tShortDoubleProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        synchronized (this.mutex) {
            this.f3644m.transformValues(tDoubleFunction);
        }
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean retainEntries(TShortDoubleProcedure tShortDoubleProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3644m.retainEntries(tShortDoubleProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean increment(short s) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3644m.increment(s);
        }
        return increment;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean adjustValue(short s, double d) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3644m.adjustValue(s, d);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double adjustOrPutValue(short s, double d, double d2) {
        double adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3644m.adjustOrPutValue(s, d, d2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3644m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3644m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3644m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}