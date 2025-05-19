package gnu.trove.impl.sync;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TShortLongIterator;
import gnu.trove.map.TShortLongMap;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TShortLongProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedShortLongMap implements TShortLongMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TShortLongMap m;
    final Object mutex;
    private transient TShortSet keySet = null;
    private transient TLongCollection values = null;

    public TSynchronizedShortLongMap(TShortLongMap tShortLongMap) {
        Objects.requireNonNull(tShortLongMap);
        this.m = tShortLongMap;
        this.mutex = this;
    }

    public TSynchronizedShortLongMap(TShortLongMap tShortLongMap, Object obj) {
        this.m = tShortLongMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TShortLongMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean containsKey(short s) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(s);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean containsValue(long j) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(j);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long get(short s) {
        long j;
        synchronized (this.mutex) {
            j = this.m.get(s);
        }
        return j;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long put(short s, long j) {
        long put;
        synchronized (this.mutex) {
            put = this.m.put(s, j);
        }
        return put;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long remove(short s) {
        long remove;
        synchronized (this.mutex) {
            remove = this.m.remove(s);
        }
        return remove;
    }

    @Override // gnu.trove.map.TShortLongMap
    public void putAll(Map<? extends Short, ? extends Long> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TShortLongMap
    public void putAll(TShortLongMap tShortLongMap) {
        synchronized (this.mutex) {
            this.m.putAll(tShortLongMap);
        }
    }

    @Override // gnu.trove.map.TShortLongMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TShortLongMap
    public TShortSet keySet() {
        TShortSet tShortSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedShortSet(this.m.keySet(), this.mutex);
            }
            tShortSet = this.keySet;
        }
        return tShortSet;
    }

    @Override // gnu.trove.map.TShortLongMap
    public short[] keys() {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortLongMap
    public short[] keys(short[] sArr) {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(sArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortLongMap
    public TLongCollection valueCollection() {
        TLongCollection tLongCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedLongCollection(this.m.valueCollection(), this.mutex);
            }
            tLongCollection = this.values;
        }
        return tLongCollection;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long[] values() {
        long[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long[] values(long[] jArr) {
        long[] values;
        synchronized (this.mutex) {
            values = this.m.values(jArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TShortLongMap
    public TShortLongIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TShortLongMap
    public short getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortLongMap
    public long getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortLongMap
    public long putIfAbsent(short s, long j) {
        long putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(s, j);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tShortProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tLongProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean forEachEntry(TShortLongProcedure tShortLongProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tShortLongProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TShortLongMap
    public void transformValues(TLongFunction tLongFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tLongFunction);
        }
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean retainEntries(TShortLongProcedure tShortLongProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tShortLongProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean increment(short s) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(s);
        }
        return increment;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean adjustValue(short s, long j) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(s, j);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long adjustOrPutValue(short s, long j, long j2) {
        long adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(s, j, j2);
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
