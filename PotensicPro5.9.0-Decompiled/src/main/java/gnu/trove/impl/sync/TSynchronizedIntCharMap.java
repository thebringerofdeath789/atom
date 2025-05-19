package gnu.trove.impl.sync;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TIntCharIterator;
import gnu.trove.map.TIntCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TIntCharProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedIntCharMap implements TIntCharMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TIntCharMap m;
    final Object mutex;
    private transient TIntSet keySet = null;
    private transient TCharCollection values = null;

    public TSynchronizedIntCharMap(TIntCharMap tIntCharMap) {
        Objects.requireNonNull(tIntCharMap);
        this.m = tIntCharMap;
        this.mutex = this;
    }

    public TSynchronizedIntCharMap(TIntCharMap tIntCharMap, Object obj) {
        this.m = tIntCharMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TIntCharMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean containsKey(int i) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(i);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean containsValue(char c) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(c);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TIntCharMap
    public char get(int i) {
        char c;
        synchronized (this.mutex) {
            c = this.m.get(i);
        }
        return c;
    }

    @Override // gnu.trove.map.TIntCharMap
    public char put(int i, char c) {
        char put;
        synchronized (this.mutex) {
            put = this.m.put(i, c);
        }
        return put;
    }

    @Override // gnu.trove.map.TIntCharMap
    public char remove(int i) {
        char remove;
        synchronized (this.mutex) {
            remove = this.m.remove(i);
        }
        return remove;
    }

    @Override // gnu.trove.map.TIntCharMap
    public void putAll(Map<? extends Integer, ? extends Character> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TIntCharMap
    public void putAll(TIntCharMap tIntCharMap) {
        synchronized (this.mutex) {
            this.m.putAll(tIntCharMap);
        }
    }

    @Override // gnu.trove.map.TIntCharMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TIntCharMap
    public TIntSet keySet() {
        TIntSet tIntSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedIntSet(this.m.keySet(), this.mutex);
            }
            tIntSet = this.keySet;
        }
        return tIntSet;
    }

    @Override // gnu.trove.map.TIntCharMap
    public int[] keys() {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntCharMap
    public int[] keys(int[] iArr) {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(iArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntCharMap
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

    @Override // gnu.trove.map.TIntCharMap
    public char[] values() {
        char[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TIntCharMap
    public char[] values(char[] cArr) {
        char[] values;
        synchronized (this.mutex) {
            values = this.m.values(cArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TIntCharMap
    public TIntCharIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TIntCharMap
    public int getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntCharMap
    public char getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntCharMap
    public char putIfAbsent(int i, char c) {
        char putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(i, c);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tIntProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tCharProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean forEachEntry(TIntCharProcedure tIntCharProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tIntCharProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TIntCharMap
    public void transformValues(TCharFunction tCharFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tCharFunction);
        }
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean retainEntries(TIntCharProcedure tIntCharProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tIntCharProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean increment(int i) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(i);
        }
        return increment;
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean adjustValue(int i, char c) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(i, c);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TIntCharMap
    public char adjustOrPutValue(int i, char c, char c2) {
        char adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(i, c, c2);
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
