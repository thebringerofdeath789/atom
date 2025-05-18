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

    /* renamed from: m */
    private final TDoubleCharMap f3599m;
    final Object mutex;
    private transient TDoubleSet keySet = null;
    private transient TCharCollection values = null;

    public TSynchronizedDoubleCharMap(TDoubleCharMap tDoubleCharMap) {
        Objects.requireNonNull(tDoubleCharMap);
        this.f3599m = tDoubleCharMap;
        this.mutex = this;
    }

    public TSynchronizedDoubleCharMap(TDoubleCharMap tDoubleCharMap, Object obj) {
        this.f3599m = tDoubleCharMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3599m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3599m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean containsKey(double d) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3599m.containsKey(d);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean containsValue(char c) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3599m.containsValue(c);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char get(double d) {
        char c;
        synchronized (this.mutex) {
            c = this.f3599m.get(d);
        }
        return c;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char put(double d, char c) {
        char put;
        synchronized (this.mutex) {
            put = this.f3599m.put(d, c);
        }
        return put;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char remove(double d) {
        char remove;
        synchronized (this.mutex) {
            remove = this.f3599m.remove(d);
        }
        return remove;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void putAll(Map<? extends Double, ? extends Character> map) {
        synchronized (this.mutex) {
            this.f3599m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void putAll(TDoubleCharMap tDoubleCharMap) {
        synchronized (this.mutex) {
            this.f3599m.putAll(tDoubleCharMap);
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3599m.clear();
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public TDoubleSet keySet() {
        TDoubleSet tDoubleSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedDoubleSet(this.f3599m.keySet(), this.mutex);
            }
            tDoubleSet = this.keySet;
        }
        return tDoubleSet;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public double[] keys() {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.f3599m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public double[] keys(double[] dArr) {
        double[] keys;
        synchronized (this.mutex) {
            keys = this.f3599m.keys(dArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public TCharCollection valueCollection() {
        TCharCollection tCharCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedCharCollection(this.f3599m.valueCollection(), this.mutex);
            }
            tCharCollection = this.values;
        }
        return tCharCollection;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char[] values() {
        char[] values;
        synchronized (this.mutex) {
            values = this.f3599m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char[] values(char[] cArr) {
        char[] values;
        synchronized (this.mutex) {
            values = this.f3599m.values(cArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public TDoubleCharIterator iterator() {
        return this.f3599m.iterator();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public double getNoEntryKey() {
        return this.f3599m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char getNoEntryValue() {
        return this.f3599m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char putIfAbsent(double d, char c) {
        char putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3599m.putIfAbsent(d, c);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3599m.forEachKey(tDoubleProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3599m.forEachValue(tCharProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean forEachEntry(TDoubleCharProcedure tDoubleCharProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3599m.forEachEntry(tDoubleCharProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void transformValues(TCharFunction tCharFunction) {
        synchronized (this.mutex) {
            this.f3599m.transformValues(tCharFunction);
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean retainEntries(TDoubleCharProcedure tDoubleCharProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3599m.retainEntries(tDoubleCharProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean increment(double d) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3599m.increment(d);
        }
        return increment;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean adjustValue(double d, char c) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3599m.adjustValue(d, c);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char adjustOrPutValue(double d, char c, char c2) {
        char adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3599m.adjustOrPutValue(d, c, c2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3599m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3599m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3599m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}