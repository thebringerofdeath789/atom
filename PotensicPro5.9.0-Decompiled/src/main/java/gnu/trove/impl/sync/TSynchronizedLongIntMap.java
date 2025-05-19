package gnu.trove.impl.sync;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TLongIntIterator;
import gnu.trove.map.TLongIntMap;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TLongIntProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedLongIntMap implements TLongIntMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TLongIntMap m;
    final Object mutex;
    private transient TLongSet keySet = null;
    private transient TIntCollection values = null;

    public TSynchronizedLongIntMap(TLongIntMap tLongIntMap) {
        Objects.requireNonNull(tLongIntMap);
        this.m = tLongIntMap;
        this.mutex = this;
    }

    public TSynchronizedLongIntMap(TLongIntMap tLongIntMap, Object obj) {
        this.m = tLongIntMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TLongIntMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean containsKey(long j) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(j);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean containsValue(int i) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(i);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TLongIntMap
    public int get(long j) {
        int i;
        synchronized (this.mutex) {
            i = this.m.get(j);
        }
        return i;
    }

    @Override // gnu.trove.map.TLongIntMap
    public int put(long j, int i) {
        int put;
        synchronized (this.mutex) {
            put = this.m.put(j, i);
        }
        return put;
    }

    @Override // gnu.trove.map.TLongIntMap
    public int remove(long j) {
        int remove;
        synchronized (this.mutex) {
            remove = this.m.remove(j);
        }
        return remove;
    }

    @Override // gnu.trove.map.TLongIntMap
    public void putAll(Map<? extends Long, ? extends Integer> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TLongIntMap
    public void putAll(TLongIntMap tLongIntMap) {
        synchronized (this.mutex) {
            this.m.putAll(tLongIntMap);
        }
    }

    @Override // gnu.trove.map.TLongIntMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TLongIntMap
    public TLongSet keySet() {
        TLongSet tLongSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedLongSet(this.m.keySet(), this.mutex);
            }
            tLongSet = this.keySet;
        }
        return tLongSet;
    }

    @Override // gnu.trove.map.TLongIntMap
    public long[] keys() {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongIntMap
    public long[] keys(long[] jArr) {
        long[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(jArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TLongIntMap
    public TIntCollection valueCollection() {
        TIntCollection tIntCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedIntCollection(this.m.valueCollection(), this.mutex);
            }
            tIntCollection = this.values;
        }
        return tIntCollection;
    }

    @Override // gnu.trove.map.TLongIntMap
    public int[] values() {
        int[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TLongIntMap
    public int[] values(int[] iArr) {
        int[] values;
        synchronized (this.mutex) {
            values = this.m.values(iArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TLongIntMap
    public TLongIntIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TLongIntMap
    public long getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongIntMap
    public int getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongIntMap
    public int putIfAbsent(long j, int i) {
        int putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(j, i);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tLongProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tIntProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean forEachEntry(TLongIntProcedure tLongIntProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tLongIntProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TLongIntMap
    public void transformValues(TIntFunction tIntFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tIntFunction);
        }
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean retainEntries(TLongIntProcedure tLongIntProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tLongIntProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean increment(long j) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(j);
        }
        return increment;
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean adjustValue(long j, int i) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(j, i);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TLongIntMap
    public int adjustOrPutValue(long j, int i, int i2) {
        int adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(j, i, i2);
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
