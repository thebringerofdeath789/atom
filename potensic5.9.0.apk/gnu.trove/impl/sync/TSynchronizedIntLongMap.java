package gnu.trove.impl.sync;

import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TIntLongIterator;
import gnu.trove.map.TIntLongMap;
import gnu.trove.procedure.TIntLongProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TIntSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedIntLongMap implements TIntLongMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TIntLongMap f3622m;
    final Object mutex;
    private transient TIntSet keySet = null;
    private transient TLongCollection values = null;

    public TSynchronizedIntLongMap(TIntLongMap tIntLongMap) {
        Objects.requireNonNull(tIntLongMap);
        this.f3622m = tIntLongMap;
        this.mutex = this;
    }

    public TSynchronizedIntLongMap(TIntLongMap tIntLongMap, Object obj) {
        this.f3622m = tIntLongMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TIntLongMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3622m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3622m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean containsKey(int i) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3622m.containsKey(i);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean containsValue(long j) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3622m.containsValue(j);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TIntLongMap
    public long get(int i) {
        long j;
        synchronized (this.mutex) {
            j = this.f3622m.get(i);
        }
        return j;
    }

    @Override // gnu.trove.map.TIntLongMap
    public long put(int i, long j) {
        long put;
        synchronized (this.mutex) {
            put = this.f3622m.put(i, j);
        }
        return put;
    }

    @Override // gnu.trove.map.TIntLongMap
    public long remove(int i) {
        long remove;
        synchronized (this.mutex) {
            remove = this.f3622m.remove(i);
        }
        return remove;
    }

    @Override // gnu.trove.map.TIntLongMap
    public void putAll(Map<? extends Integer, ? extends Long> map) {
        synchronized (this.mutex) {
            this.f3622m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TIntLongMap
    public void putAll(TIntLongMap tIntLongMap) {
        synchronized (this.mutex) {
            this.f3622m.putAll(tIntLongMap);
        }
    }

    @Override // gnu.trove.map.TIntLongMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3622m.clear();
        }
    }

    @Override // gnu.trove.map.TIntLongMap
    public TIntSet keySet() {
        TIntSet tIntSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedIntSet(this.f3622m.keySet(), this.mutex);
            }
            tIntSet = this.keySet;
        }
        return tIntSet;
    }

    @Override // gnu.trove.map.TIntLongMap
    public int[] keys() {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3622m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntLongMap
    public int[] keys(int[] iArr) {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3622m.keys(iArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntLongMap
    public TLongCollection valueCollection() {
        TLongCollection tLongCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedLongCollection(this.f3622m.valueCollection(), this.mutex);
            }
            tLongCollection = this.values;
        }
        return tLongCollection;
    }

    @Override // gnu.trove.map.TIntLongMap
    public long[] values() {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3622m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TIntLongMap
    public long[] values(long[] jArr) {
        long[] values;
        synchronized (this.mutex) {
            values = this.f3622m.values(jArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TIntLongMap
    public TIntLongIterator iterator() {
        return this.f3622m.iterator();
    }

    @Override // gnu.trove.map.TIntLongMap
    public int getNoEntryKey() {
        return this.f3622m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntLongMap
    public long getNoEntryValue() {
        return this.f3622m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntLongMap
    public long putIfAbsent(int i, long j) {
        long putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3622m.putIfAbsent(i, j);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3622m.forEachKey(tIntProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3622m.forEachValue(tLongProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean forEachEntry(TIntLongProcedure tIntLongProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3622m.forEachEntry(tIntLongProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TIntLongMap
    public void transformValues(TLongFunction tLongFunction) {
        synchronized (this.mutex) {
            this.f3622m.transformValues(tLongFunction);
        }
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean retainEntries(TIntLongProcedure tIntLongProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3622m.retainEntries(tIntLongProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean increment(int i) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3622m.increment(i);
        }
        return increment;
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean adjustValue(int i, long j) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3622m.adjustValue(i, j);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TIntLongMap
    public long adjustOrPutValue(int i, long j, long j2) {
        long adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3622m.adjustOrPutValue(i, j, j2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3622m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3622m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3622m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}