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

    /* renamed from: m */
    private final TCharCharMap f3590m;
    final Object mutex;
    private transient TCharSet keySet = null;
    private transient TCharCollection values = null;

    public TSynchronizedCharCharMap(TCharCharMap tCharCharMap) {
        Objects.requireNonNull(tCharCharMap);
        this.f3590m = tCharCharMap;
        this.mutex = this;
    }

    public TSynchronizedCharCharMap(TCharCharMap tCharCharMap, Object obj) {
        this.f3590m = tCharCharMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TCharCharMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3590m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3590m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean containsKey(char c) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3590m.containsKey(c);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean containsValue(char c) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3590m.containsValue(c);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char get(char c) {
        char c2;
        synchronized (this.mutex) {
            c2 = this.f3590m.get(c);
        }
        return c2;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char put(char c, char c2) {
        char put;
        synchronized (this.mutex) {
            put = this.f3590m.put(c, c2);
        }
        return put;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char remove(char c) {
        char remove;
        synchronized (this.mutex) {
            remove = this.f3590m.remove(c);
        }
        return remove;
    }

    @Override // gnu.trove.map.TCharCharMap
    public void putAll(Map<? extends Character, ? extends Character> map) {
        synchronized (this.mutex) {
            this.f3590m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TCharCharMap
    public void putAll(TCharCharMap tCharCharMap) {
        synchronized (this.mutex) {
            this.f3590m.putAll(tCharCharMap);
        }
    }

    @Override // gnu.trove.map.TCharCharMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3590m.clear();
        }
    }

    @Override // gnu.trove.map.TCharCharMap
    public TCharSet keySet() {
        TCharSet tCharSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedCharSet(this.f3590m.keySet(), this.mutex);
            }
            tCharSet = this.keySet;
        }
        return tCharSet;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char[] keys() {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.f3590m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char[] keys(char[] cArr) {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.f3590m.keys(cArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharCharMap
    public TCharCollection valueCollection() {
        TCharCollection tCharCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedCharCollection(this.f3590m.valueCollection(), this.mutex);
            }
            tCharCollection = this.values;
        }
        return tCharCollection;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char[] values() {
        char[] values;
        synchronized (this.mutex) {
            values = this.f3590m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char[] values(char[] cArr) {
        char[] values;
        synchronized (this.mutex) {
            values = this.f3590m.values(cArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TCharCharMap
    public TCharCharIterator iterator() {
        return this.f3590m.iterator();
    }

    @Override // gnu.trove.map.TCharCharMap
    public char getNoEntryKey() {
        return this.f3590m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharCharMap
    public char getNoEntryValue() {
        return this.f3590m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharCharMap
    public char putIfAbsent(char c, char c2) {
        char putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3590m.putIfAbsent(c, c2);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3590m.forEachKey(tCharProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3590m.forEachValue(tCharProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean forEachEntry(TCharCharProcedure tCharCharProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3590m.forEachEntry(tCharCharProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TCharCharMap
    public void transformValues(TCharFunction tCharFunction) {
        synchronized (this.mutex) {
            this.f3590m.transformValues(tCharFunction);
        }
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean retainEntries(TCharCharProcedure tCharCharProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3590m.retainEntries(tCharCharProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean increment(char c) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3590m.increment(c);
        }
        return increment;
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean adjustValue(char c, char c2) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3590m.adjustValue(c, c2);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char adjustOrPutValue(char c, char c2, char c3) {
        char adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3590m.adjustOrPutValue(c, c2, c3);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3590m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3590m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3590m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}