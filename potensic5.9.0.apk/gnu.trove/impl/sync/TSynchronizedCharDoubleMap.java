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

    /* renamed from: m */
    private final TCharDoubleMap f3592m;
    final Object mutex;
    private transient TCharSet keySet = null;
    private transient TDoubleCollection values = null;

    public TSynchronizedCharDoubleMap(TCharDoubleMap tCharDoubleMap) {
        Objects.requireNonNull(tCharDoubleMap);
        this.f3592m = tCharDoubleMap;
        this.mutex = this;
    }

    public TSynchronizedCharDoubleMap(TCharDoubleMap tCharDoubleMap, Object obj) {
        this.f3592m = tCharDoubleMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3592m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3592m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean containsKey(char c) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3592m.containsKey(c);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean containsValue(double d) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3592m.containsValue(d);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double get(char c) {
        double d;
        synchronized (this.mutex) {
            d = this.f3592m.get(c);
        }
        return d;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double put(char c, double d) {
        double put;
        synchronized (this.mutex) {
            put = this.f3592m.put(c, d);
        }
        return put;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double remove(char c) {
        double remove;
        synchronized (this.mutex) {
            remove = this.f3592m.remove(c);
        }
        return remove;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public void putAll(Map<? extends Character, ? extends Double> map) {
        synchronized (this.mutex) {
            this.f3592m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public void putAll(TCharDoubleMap tCharDoubleMap) {
        synchronized (this.mutex) {
            this.f3592m.putAll(tCharDoubleMap);
        }
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3592m.clear();
        }
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public TCharSet keySet() {
        TCharSet tCharSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedCharSet(this.f3592m.keySet(), this.mutex);
            }
            tCharSet = this.keySet;
        }
        return tCharSet;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public char[] keys() {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.f3592m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public char[] keys(char[] cArr) {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.f3592m.keys(cArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public TDoubleCollection valueCollection() {
        TDoubleCollection tDoubleCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedDoubleCollection(this.f3592m.valueCollection(), this.mutex);
            }
            tDoubleCollection = this.values;
        }
        return tDoubleCollection;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double[] values() {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3592m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double[] values(double[] dArr) {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3592m.values(dArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public TCharDoubleIterator iterator() {
        return this.f3592m.iterator();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public char getNoEntryKey() {
        return this.f3592m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double getNoEntryValue() {
        return this.f3592m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double putIfAbsent(char c, double d) {
        double putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3592m.putIfAbsent(c, d);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3592m.forEachKey(tCharProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3592m.forEachValue(tDoubleProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean forEachEntry(TCharDoubleProcedure tCharDoubleProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3592m.forEachEntry(tCharDoubleProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        synchronized (this.mutex) {
            this.f3592m.transformValues(tDoubleFunction);
        }
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean retainEntries(TCharDoubleProcedure tCharDoubleProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3592m.retainEntries(tCharDoubleProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean increment(char c) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3592m.increment(c);
        }
        return increment;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean adjustValue(char c, double d) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3592m.adjustValue(c, d);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double adjustOrPutValue(char c, double d, double d2) {
        double adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3592m.adjustOrPutValue(c, d, d2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3592m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3592m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3592m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}