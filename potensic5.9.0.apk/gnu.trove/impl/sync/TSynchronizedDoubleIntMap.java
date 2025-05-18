package gnu.trove.impl.sync;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TDoubleIntIterator;
import gnu.trove.map.TDoubleIntMap;
import gnu.trove.procedure.TDoubleIntProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedDoubleIntMap implements TDoubleIntMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TDoubleIntMap f3603m;
    final Object mutex;
    private transient TDoubleSet keySet = null;
    private transient TIntCollection values = null;

    public TSynchronizedDoubleIntMap(TDoubleIntMap tDoubleIntMap) {
        Objects.requireNonNull(tDoubleIntMap);
        this.f3603m = tDoubleIntMap;
        this.mutex = this;
    }

    public TSynchronizedDoubleIntMap(TDoubleIntMap tDoubleIntMap, Object obj) {
        this.f3603m = tDoubleIntMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3603m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3603m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean containsKey(double d) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3603m.containsKey(d);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean containsValue(int i) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3603m.containsValue(i);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int get(double d) {
        int i;
        synchronized (this.mutex) {
            i = this.f3603m.get(d);
        }
        return i;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int put(double d, int i) {
        int put;
        synchronized (this.mutex) {
            put = this.f3603m.put(d, i);
        }
        return put;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int remove(double d) {
        int remove;
        synchronized (this.mutex) {
            remove = this.f3603m.remove(d);
        }
        return remove;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public void putAll(Map<? extends Double, ? extends Integer> map) {
        synchronized (this.mutex) {
            this.f3603m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public void putAll(TDoubleIntMap tDoubleIntMap) {
        synchronized (this.mutex) {
            this.f3603m.putAll(tDoubleIntMap);
        }
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3603m.clear();
        }
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public TDoubleSet keySet() {
        TDoubleSet tDoubleSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedDoubleSet(this.f3603m.keySet(), this.mutex);
            }
            tDoubleSet = this.keySet;
        }
        return tDoubleSet;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public double[] keys() {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.f3603m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public double[] keys(double[] dArr) {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.f3603m.keys(dArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public TIntCollection valueCollection() {
        TIntCollection tIntCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedIntCollection(this.f3603m.valueCollection(), this.mutex);
            }
            tIntCollection = this.values;
        }
        return tIntCollection;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int[] values() {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3603m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int[] values(int[] iArr) {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3603m.values(iArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public TDoubleIntIterator iterator() {
        return this.f3603m.iterator();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public double getNoEntryKey() {
        return this.f3603m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int getNoEntryValue() {
        return this.f3603m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int putIfAbsent(double d, int i) {
        int putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3603m.putIfAbsent(d, i);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3603m.forEachKey(tDoubleProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3603m.forEachValue(tIntProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean forEachEntry(TDoubleIntProcedure tDoubleIntProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3603m.forEachEntry(tDoubleIntProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public void transformValues(TIntFunction tIntFunction) {
        synchronized (this.mutex) {
            this.f3603m.transformValues(tIntFunction);
        }
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean retainEntries(TDoubleIntProcedure tDoubleIntProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3603m.retainEntries(tDoubleIntProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean increment(double d) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3603m.increment(d);
        }
        return increment;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean adjustValue(double d, int i) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3603m.adjustValue(d, i);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int adjustOrPutValue(double d, int i, int i2) {
        int adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3603m.adjustOrPutValue(d, i, i2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3603m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3603m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3603m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}