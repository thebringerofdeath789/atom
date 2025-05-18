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

    /* renamed from: m */
    private final TShortLongMap f3647m;
    final Object mutex;
    private transient TShortSet keySet = null;
    private transient TLongCollection values = null;

    public TSynchronizedShortLongMap(TShortLongMap tShortLongMap) {
        Objects.requireNonNull(tShortLongMap);
        this.f3647m = tShortLongMap;
        this.mutex = this;
    }

    public TSynchronizedShortLongMap(TShortLongMap tShortLongMap, Object obj) {
        this.f3647m = tShortLongMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TShortLongMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3647m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3647m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean containsKey(short s) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3647m.containsKey(s);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean containsValue(long j) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3647m.containsValue(j);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long get(short s) {
        long j;
        synchronized (this.mutex) {
            j = this.f3647m.get(s);
        }
        return j;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long put(short s, long j) {
        long put;
        synchronized (this.mutex) {
            put = this.f3647m.put(s, j);
        }
        return put;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long remove(short s) {
        long remove;
        synchronized (this.mutex) {
            remove = this.f3647m.remove(s);
        }
        return remove;
    }

    @Override // gnu.trove.map.TShortLongMap
    public void putAll(Map<? extends Short, ? extends Long> map) {
        synchronized (this.mutex) {
            this.f3647m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TShortLongMap
    public void putAll(TShortLongMap tShortLongMap) {
        synchronized (this.mutex) {
            this.f3647m.putAll(tShortLongMap);
        }
    }

    @Override // gnu.trove.map.TShortLongMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3647m.clear();
        }
    }

    @Override // gnu.trove.map.TShortLongMap
    public TShortSet keySet() {
        TShortSet tShortSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedShortSet(this.f3647m.keySet(), this.mutex);
            }
            tShortSet = this.keySet;
        }
        return tShortSet;
    }

    @Override // gnu.trove.map.TShortLongMap
    public short[] keys() {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3647m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortLongMap
    public short[] keys(short[] sArr) {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3647m.keys(sArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortLongMap
    public TLongCollection valueCollection() {
        TLongCollection tLongCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedLongCollection(this.f3647m.valueCollection(), this.mutex);
            }
            tLongCollection = this.values;
        }
        return tLongCollection;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long[] values() {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3647m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long[] values(long[] jArr) {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3647m.values(jArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TShortLongMap
    public TShortLongIterator iterator() {
        return this.f3647m.iterator();
    }

    @Override // gnu.trove.map.TShortLongMap
    public short getNoEntryKey() {
        return this.f3647m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortLongMap
    public long getNoEntryValue() {
        return this.f3647m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortLongMap
    public long putIfAbsent(short s, long j) {
        long putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3647m.putIfAbsent(s, j);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3647m.forEachKey(tShortProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3647m.forEachValue(tLongProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean forEachEntry(TShortLongProcedure tShortLongProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3647m.forEachEntry(tShortLongProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TShortLongMap
    public void transformValues(TLongFunction tLongFunction) {
        synchronized (this.mutex) {
            this.f3647m.transformValues(tLongFunction);
        }
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean retainEntries(TShortLongProcedure tShortLongProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3647m.retainEntries(tShortLongProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean increment(short s) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3647m.increment(s);
        }
        return increment;
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean adjustValue(short s, long j) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3647m.adjustValue(s, j);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long adjustOrPutValue(short s, long j, long j2) {
        long adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3647m.adjustOrPutValue(s, j, j2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3647m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3647m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3647m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}