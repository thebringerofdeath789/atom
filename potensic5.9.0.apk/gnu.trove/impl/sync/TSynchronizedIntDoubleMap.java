package gnu.trove.impl.sync;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TIntDoubleIterator;
import gnu.trove.map.TIntDoubleMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TIntDoubleProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedIntDoubleMap implements TIntDoubleMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TIntDoubleMap f3619m;
    final Object mutex;
    private transient TIntSet keySet = null;
    private transient TDoubleCollection values = null;

    public TSynchronizedIntDoubleMap(TIntDoubleMap tIntDoubleMap) {
        Objects.requireNonNull(tIntDoubleMap);
        this.f3619m = tIntDoubleMap;
        this.mutex = this;
    }

    public TSynchronizedIntDoubleMap(TIntDoubleMap tIntDoubleMap, Object obj) {
        this.f3619m = tIntDoubleMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3619m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3619m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean containsKey(int i) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3619m.containsKey(i);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean containsValue(double d) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3619m.containsValue(d);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double get(int i) {
        double d;
        synchronized (this.mutex) {
            d = this.f3619m.get(i);
        }
        return d;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double put(int i, double d) {
        double put;
        synchronized (this.mutex) {
            put = this.f3619m.put(i, d);
        }
        return put;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double remove(int i) {
        double remove;
        synchronized (this.mutex) {
            remove = this.f3619m.remove(i);
        }
        return remove;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public void putAll(Map<? extends Integer, ? extends Double> map) {
        synchronized (this.mutex) {
            this.f3619m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public void putAll(TIntDoubleMap tIntDoubleMap) {
        synchronized (this.mutex) {
            this.f3619m.putAll(tIntDoubleMap);
        }
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3619m.clear();
        }
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public TIntSet keySet() {
        TIntSet tIntSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedIntSet(this.f3619m.keySet(), this.mutex);
            }
            tIntSet = this.keySet;
        }
        return tIntSet;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public int[] keys() {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3619m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public int[] keys(int[] iArr) {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3619m.keys(iArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public TDoubleCollection valueCollection() {
        TDoubleCollection tDoubleCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedDoubleCollection(this.f3619m.valueCollection(), this.mutex);
            }
            tDoubleCollection = this.values;
        }
        return tDoubleCollection;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double[] values() {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3619m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double[] values(double[] dArr) {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3619m.values(dArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public TIntDoubleIterator iterator() {
        return this.f3619m.iterator();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public int getNoEntryKey() {
        return this.f3619m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double getNoEntryValue() {
        return this.f3619m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double putIfAbsent(int i, double d) {
        double putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3619m.putIfAbsent(i, d);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3619m.forEachKey(tIntProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3619m.forEachValue(tDoubleProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean forEachEntry(TIntDoubleProcedure tIntDoubleProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3619m.forEachEntry(tIntDoubleProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        synchronized (this.mutex) {
            this.f3619m.transformValues(tDoubleFunction);
        }
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean retainEntries(TIntDoubleProcedure tIntDoubleProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3619m.retainEntries(tIntDoubleProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean increment(int i) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3619m.increment(i);
        }
        return increment;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean adjustValue(int i, double d) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3619m.adjustValue(i, d);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double adjustOrPutValue(int i, double d, double d2) {
        double adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3619m.adjustOrPutValue(i, d, d2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3619m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3619m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3619m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}