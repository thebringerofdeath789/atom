package gnu.trove.impl.sync;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TDoubleCharIterator;
import gnu.trove.map.TDoubleCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TDoubleCharProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedDoubleCharMap implements TDoubleCharMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TDoubleCharMap m;
    final Object mutex;
    private transient TDoubleSet keySet = null;
    private transient TCharCollection values = null;

    public TSynchronizedDoubleCharMap(TDoubleCharMap tDoubleCharMap) {
        Objects.requireNonNull(tDoubleCharMap);
        this.m = tDoubleCharMap;
        this.mutex = this;
    }

    public TSynchronizedDoubleCharMap(TDoubleCharMap tDoubleCharMap, Object obj) {
        this.m = tDoubleCharMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean containsKey(double d) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(d);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean containsValue(char c) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(c);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char get(double d) {
        char c;
        synchronized (this.mutex) {
            c = this.m.get(d);
        }
        return c;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char put(double d, char c) {
        char put;
        synchronized (this.mutex) {
            put = this.m.put(d, c);
        }
        return put;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char remove(double d) {
        char remove;
        synchronized (this.mutex) {
            remove = this.m.remove(d);
        }
        return remove;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void putAll(Map<? extends Double, ? extends Character> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void putAll(TDoubleCharMap tDoubleCharMap) {
        synchronized (this.mutex) {
            this.m.putAll(tDoubleCharMap);
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
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

    @Override // gnu.trove.map.TDoubleCharMap
    public double[] keys() {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public double[] keys(double[] dArr) {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(dArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public TCharCollection valueCollection() {
        TCharCollection tCharCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedCharCollection(this.m.valueCollection(), this.mutex);
            }
            tCharCollection = this.values;
        }
        return tCharCollection;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char[] values() {
        char[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char[] values(char[] cArr) {
        char[] values;
        synchronized (this.mutex) {
            values = this.m.values(cArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public TDoubleCharIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public double getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char putIfAbsent(double d, char c) {
        char putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(d, c);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tDoubleProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tCharProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean forEachEntry(TDoubleCharProcedure tDoubleCharProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tDoubleCharProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void transformValues(TCharFunction tCharFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tCharFunction);
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean retainEntries(TDoubleCharProcedure tDoubleCharProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tDoubleCharProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean increment(double d) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(d);
        }
        return increment;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean adjustValue(double d, char c) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(d, c);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char adjustOrPutValue(double d, char c, char c2) {
        char adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(d, c, c2);
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
