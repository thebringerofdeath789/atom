package gnu.trove.impl.sync;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TCharDoubleIterator;
import gnu.trove.map.TCharDoubleMap;
import gnu.trove.procedure.TCharDoubleProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TCharSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedCharDoubleMap implements TCharDoubleMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TCharDoubleMap m;
    final Object mutex;
    private transient TCharSet keySet = null;
    private transient TDoubleCollection values = null;

    public TSynchronizedCharDoubleMap(TCharDoubleMap tCharDoubleMap) {
        Objects.requireNonNull(tCharDoubleMap);
        this.m = tCharDoubleMap;
        this.mutex = this;
    }

    public TSynchronizedCharDoubleMap(TCharDoubleMap tCharDoubleMap, Object obj) {
        this.m = tCharDoubleMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean containsKey(char c) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(c);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean containsValue(double d) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(d);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double get(char c) {
        double d;
        synchronized (this.mutex) {
            d = this.m.get(c);
        }
        return d;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double put(char c, double d) {
        double put;
        synchronized (this.mutex) {
            put = this.m.put(c, d);
        }
        return put;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double remove(char c) {
        double remove;
        synchronized (this.mutex) {
            remove = this.m.remove(c);
        }
        return remove;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public void putAll(Map<? extends Character, ? extends Double> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public void putAll(TCharDoubleMap tCharDoubleMap) {
        synchronized (this.mutex) {
            this.m.putAll(tCharDoubleMap);
        }
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public TCharSet keySet() {
        TCharSet tCharSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedCharSet(this.m.keySet(), this.mutex);
            }
            tCharSet = this.keySet;
        }
        return tCharSet;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public char[] keys() {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public char[] keys(char[] cArr) {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(cArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public TDoubleCollection valueCollection() {
        TDoubleCollection tDoubleCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedDoubleCollection(this.m.valueCollection(), this.mutex);
            }
            tDoubleCollection = this.values;
        }
        return tDoubleCollection;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double[] values() {
        double[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double[] values(double[] dArr) {
        double[] values;
        synchronized (this.mutex) {
            values = this.m.values(dArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public TCharDoubleIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public char getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double putIfAbsent(char c, double d) {
        double putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(c, d);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tCharProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tDoubleProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean forEachEntry(TCharDoubleProcedure tCharDoubleProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tCharDoubleProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tDoubleFunction);
        }
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean retainEntries(TCharDoubleProcedure tCharDoubleProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tCharDoubleProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean increment(char c) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(c);
        }
        return increment;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean adjustValue(char c, double d) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(c, d);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double adjustOrPutValue(char c, double d, double d2) {
        double adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(c, d, d2);
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
