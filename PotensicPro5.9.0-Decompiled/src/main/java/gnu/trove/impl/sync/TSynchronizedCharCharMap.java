package gnu.trove.impl.sync;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TCharCharIterator;
import gnu.trove.map.TCharCharMap;
import gnu.trove.procedure.TCharCharProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.set.TCharSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedCharCharMap implements TCharCharMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TCharCharMap m;
    final Object mutex;
    private transient TCharSet keySet = null;
    private transient TCharCollection values = null;

    public TSynchronizedCharCharMap(TCharCharMap tCharCharMap) {
        Objects.requireNonNull(tCharCharMap);
        this.m = tCharCharMap;
        this.mutex = this;
    }

    public TSynchronizedCharCharMap(TCharCharMap tCharCharMap, Object obj) {
        this.m = tCharCharMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TCharCharMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean containsKey(char c) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(c);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean containsValue(char c) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(c);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char get(char c) {
        char c2;
        synchronized (this.mutex) {
            c2 = this.m.get(c);
        }
        return c2;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char put(char c, char c2) {
        char put;
        synchronized (this.mutex) {
            put = this.m.put(c, c2);
        }
        return put;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char remove(char c) {
        char remove;
        synchronized (this.mutex) {
            remove = this.m.remove(c);
        }
        return remove;
    }

    @Override // gnu.trove.map.TCharCharMap
    public void putAll(Map<? extends Character, ? extends Character> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TCharCharMap
    public void putAll(TCharCharMap tCharCharMap) {
        synchronized (this.mutex) {
            this.m.putAll(tCharCharMap);
        }
    }

    @Override // gnu.trove.map.TCharCharMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TCharCharMap
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

    @Override // gnu.trove.map.TCharCharMap
    public char[] keys() {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char[] keys(char[] cArr) {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(cArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharCharMap
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

    @Override // gnu.trove.map.TCharCharMap
    public char[] values() {
        char[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char[] values(char[] cArr) {
        char[] values;
        synchronized (this.mutex) {
            values = this.m.values(cArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TCharCharMap
    public TCharCharIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TCharCharMap
    public char getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharCharMap
    public char getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharCharMap
    public char putIfAbsent(char c, char c2) {
        char putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(c, c2);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tCharProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tCharProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean forEachEntry(TCharCharProcedure tCharCharProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tCharCharProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TCharCharMap
    public void transformValues(TCharFunction tCharFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tCharFunction);
        }
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean retainEntries(TCharCharProcedure tCharCharProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tCharCharProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean increment(char c) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(c);
        }
        return increment;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean adjustValue(char c, char c2) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(c, c2);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char adjustOrPutValue(char c, char c2, char c3) {
        char adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(c, c2, c3);
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
