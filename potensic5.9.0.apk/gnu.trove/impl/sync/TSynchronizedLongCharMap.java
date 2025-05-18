package gnu.trove.impl.sync;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TLongCharIterator;
import gnu.trove.map.TLongCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TLongCharProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedLongCharMap implements TLongCharMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TLongCharMap f3626m;
    final Object mutex;
    private transient TLongSet keySet = null;
    private transient TCharCollection values = null;

    public TSynchronizedLongCharMap(TLongCharMap tLongCharMap) {
        Objects.requireNonNull(tLongCharMap);
        this.f3626m = tLongCharMap;
        this.mutex = this;
    }

    public TSynchronizedLongCharMap(TLongCharMap tLongCharMap, Object obj) {
        this.f3626m = tLongCharMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TLongCharMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3626m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3626m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean containsKey(long j) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3626m.containsKey(j);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean containsValue(char c) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3626m.containsValue(c);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TLongCharMap
    public char get(long j) {
        char c;
        synchronized (this.mutex) {
            c = this.f3626m.get(j);
        }
        return c;
    }

    @Override // gnu.trove.map.TLongCharMap
    public char put(long j, char c) {
        char put;
        synchronized (this.mutex) {
            put = this.f3626m.put(j, c);
        }
        return put;
    }

    @Override // gnu.trove.map.TLongCharMap
    public char remove(long j) {
        char remove;
        synchronized (this.mutex) {
            remove = this.f3626m.remove(j);
        }
        return remove;
    }

    @Override // gnu.trove.map.TLongCharMap
    public void putAll(Map<? extends Long, ? extends Character> map) {
        synchronized (this.mutex) {
            this.f3626m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TLongCharMap
    public void putAll(TLongCharMap tLongCharMap) {
        synchronized (this.mutex) {
            this.f3626m.putAll(tLongCharMap);
        }
    }

    @Override // gnu.trove.map.TLongCharMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3626m.clear();
        }
    }

    @Override // gnu.trove.map.TLongCharMap
    public TLongSet keySet() {
        TLongSet tLongSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedLongSet(this.f3626m.keySet(), this.mutex);
            }
            tLongSet = this.keySet;
        }
        return tLongSet;
    }

    @Override // gnu.trove.map.TLongCharMap
    public long[] keys() {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.f3626m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongCharMap
    public long[] keys(long[] jArr) {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.f3626m.keys(jArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongCharMap
    public TCharCollection valueCollection() {
        TCharCollection tCharCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedCharCollection(this.f3626m.valueCollection(), this.mutex);
            }
            tCharCollection = this.values;
        }
        return tCharCollection;
    }

    @Override // gnu.trove.map.TLongCharMap
    public char[] values() {
        char[] values;
        synchronized (this.mutex) {
            values = this.f3626m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TLongCharMap
    public char[] values(char[] cArr) {
        char[] values;
        synchronized (this.mutex) {
            values = this.f3626m.values(cArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TLongCharMap
    public TLongCharIterator iterator() {
        return this.f3626m.iterator();
    }

    @Override // gnu.trove.map.TLongCharMap
    public long getNoEntryKey() {
        return this.f3626m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongCharMap
    public char getNoEntryValue() {
        return this.f3626m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongCharMap
    public char putIfAbsent(long j, char c) {
        char putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3626m.putIfAbsent(j, c);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3626m.forEachKey(tLongProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3626m.forEachValue(tCharProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean forEachEntry(TLongCharProcedure tLongCharProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3626m.forEachEntry(tLongCharProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TLongCharMap
    public void transformValues(TCharFunction tCharFunction) {
        synchronized (this.mutex) {
            this.f3626m.transformValues(tCharFunction);
        }
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean retainEntries(TLongCharProcedure tLongCharProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3626m.retainEntries(tLongCharProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean increment(long j) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3626m.increment(j);
        }
        return increment;
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean adjustValue(long j, char c) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3626m.adjustValue(j, c);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TLongCharMap
    public char adjustOrPutValue(long j, char c, char c2) {
        char adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3626m.adjustOrPutValue(j, c, c2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3626m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3626m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3626m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}