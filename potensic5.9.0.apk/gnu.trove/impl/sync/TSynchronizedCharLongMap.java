package gnu.trove.impl.sync;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TCharLongIterator;
import gnu.trove.map.TCharLongMap;
import gnu.trove.procedure.TCharLongProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TCharSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedCharLongMap implements TCharLongMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TCharLongMap f3595m;
    final Object mutex;
    private transient TCharSet keySet = null;
    private transient TLongCollection values = null;

    public TSynchronizedCharLongMap(TCharLongMap tCharLongMap) {
        Objects.requireNonNull(tCharLongMap);
        this.f3595m = tCharLongMap;
        this.mutex = this;
    }

    public TSynchronizedCharLongMap(TCharLongMap tCharLongMap, Object obj) {
        this.f3595m = tCharLongMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TCharLongMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3595m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3595m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean containsKey(char c) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3595m.containsKey(c);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean containsValue(long j) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3595m.containsValue(j);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TCharLongMap
    public long get(char c) {
        long j;
        synchronized (this.mutex) {
            j = this.f3595m.get(c);
        }
        return j;
    }

    @Override // gnu.trove.map.TCharLongMap
    public long put(char c, long j) {
        long put;
        synchronized (this.mutex) {
            put = this.f3595m.put(c, j);
        }
        return put;
    }

    @Override // gnu.trove.map.TCharLongMap
    public long remove(char c) {
        long remove;
        synchronized (this.mutex) {
            remove = this.f3595m.remove(c);
        }
        return remove;
    }

    @Override // gnu.trove.map.TCharLongMap
    public void putAll(Map<? extends Character, ? extends Long> map) {
        synchronized (this.mutex) {
            this.f3595m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TCharLongMap
    public void putAll(TCharLongMap tCharLongMap) {
        synchronized (this.mutex) {
            this.f3595m.putAll(tCharLongMap);
        }
    }

    @Override // gnu.trove.map.TCharLongMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3595m.clear();
        }
    }

    @Override // gnu.trove.map.TCharLongMap
    public TCharSet keySet() {
        TCharSet tCharSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedCharSet(this.f3595m.keySet(), this.mutex);
            }
            tCharSet = this.keySet;
        }
        return tCharSet;
    }

    @Override // gnu.trove.map.TCharLongMap
    public char[] keys() {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.f3595m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharLongMap
    public char[] keys(char[] cArr) {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.f3595m.keys(cArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharLongMap
    public TLongCollection valueCollection() {
        TLongCollection tLongCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedLongCollection(this.f3595m.valueCollection(), this.mutex);
            }
            tLongCollection = this.values;
        }
        return tLongCollection;
    }

    @Override // gnu.trove.map.TCharLongMap
    public long[] values() {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3595m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TCharLongMap
    public long[] values(long[] jArr) {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3595m.values(jArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TCharLongMap
    public TCharLongIterator iterator() {
        return this.f3595m.iterator();
    }

    @Override // gnu.trove.map.TCharLongMap
    public char getNoEntryKey() {
        return this.f3595m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharLongMap
    public long getNoEntryValue() {
        return this.f3595m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharLongMap
    public long putIfAbsent(char c, long j) {
        long putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3595m.putIfAbsent(c, j);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3595m.forEachKey(tCharProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3595m.forEachValue(tLongProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean forEachEntry(TCharLongProcedure tCharLongProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3595m.forEachEntry(tCharLongProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TCharLongMap
    public void transformValues(TLongFunction tLongFunction) {
        synchronized (this.mutex) {
            this.f3595m.transformValues(tLongFunction);
        }
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean retainEntries(TCharLongProcedure tCharLongProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3595m.retainEntries(tCharLongProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean increment(char c) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3595m.increment(c);
        }
        return increment;
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean adjustValue(char c, long j) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3595m.adjustValue(c, j);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TCharLongMap
    public long adjustOrPutValue(char c, long j, long j2) {
        long adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3595m.adjustOrPutValue(c, j, j2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3595m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3595m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3595m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}