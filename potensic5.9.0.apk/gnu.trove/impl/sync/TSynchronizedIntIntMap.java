package gnu.trove.impl.sync;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TIntIntIterator;
import gnu.trove.map.TIntIntMap;
import gnu.trove.procedure.TIntIntProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedIntIntMap implements TIntIntMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TIntIntMap f3621m;
    final Object mutex;
    private transient TIntSet keySet = null;
    private transient TIntCollection values = null;

    public TSynchronizedIntIntMap(TIntIntMap tIntIntMap) {
        Objects.requireNonNull(tIntIntMap);
        this.f3621m = tIntIntMap;
        this.mutex = this;
    }

    public TSynchronizedIntIntMap(TIntIntMap tIntIntMap, Object obj) {
        this.f3621m = tIntIntMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TIntIntMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3621m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3621m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean containsKey(int i) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3621m.containsKey(i);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean containsValue(int i) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3621m.containsValue(i);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TIntIntMap
    public int get(int i) {
        int i2;
        synchronized (this.mutex) {
            i2 = this.f3621m.get(i);
        }
        return i2;
    }

    @Override // gnu.trove.map.TIntIntMap
    public int put(int i, int i2) {
        int put;
        synchronized (this.mutex) {
            put = this.f3621m.put(i, i2);
        }
        return put;
    }

    @Override // gnu.trove.map.TIntIntMap
    public int remove(int i) {
        int remove;
        synchronized (this.mutex) {
            remove = this.f3621m.remove(i);
        }
        return remove;
    }

    @Override // gnu.trove.map.TIntIntMap
    public void putAll(Map<? extends Integer, ? extends Integer> map) {
        synchronized (this.mutex) {
            this.f3621m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TIntIntMap
    public void putAll(TIntIntMap tIntIntMap) {
        synchronized (this.mutex) {
            this.f3621m.putAll(tIntIntMap);
        }
    }

    @Override // gnu.trove.map.TIntIntMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3621m.clear();
        }
    }

    @Override // gnu.trove.map.TIntIntMap
    public TIntSet keySet() {
        TIntSet tIntSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedIntSet(this.f3621m.keySet(), this.mutex);
            }
            tIntSet = this.keySet;
        }
        return tIntSet;
    }

    @Override // gnu.trove.map.TIntIntMap
    public int[] keys() {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3621m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntIntMap
    public int[] keys(int[] iArr) {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3621m.keys(iArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntIntMap
    public TIntCollection valueCollection() {
        TIntCollection tIntCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedIntCollection(this.f3621m.valueCollection(), this.mutex);
            }
            tIntCollection = this.values;
        }
        return tIntCollection;
    }

    @Override // gnu.trove.map.TIntIntMap
    public int[] values() {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3621m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TIntIntMap
    public int[] values(int[] iArr) {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3621m.values(iArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TIntIntMap
    public TIntIntIterator iterator() {
        return this.f3621m.iterator();
    }

    @Override // gnu.trove.map.TIntIntMap
    public int getNoEntryKey() {
        return this.f3621m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntIntMap
    public int getNoEntryValue() {
        return this.f3621m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntIntMap
    public int putIfAbsent(int i, int i2) {
        int putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3621m.putIfAbsent(i, i2);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3621m.forEachKey(tIntProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3621m.forEachValue(tIntProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean forEachEntry(TIntIntProcedure tIntIntProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3621m.forEachEntry(tIntIntProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TIntIntMap
    public void transformValues(TIntFunction tIntFunction) {
        synchronized (this.mutex) {
            this.f3621m.transformValues(tIntFunction);
        }
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean retainEntries(TIntIntProcedure tIntIntProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3621m.retainEntries(tIntIntProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean increment(int i) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3621m.increment(i);
        }
        return increment;
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean adjustValue(int i, int i2) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3621m.adjustValue(i, i2);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TIntIntMap
    public int adjustOrPutValue(int i, int i2, int i3) {
        int adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3621m.adjustOrPutValue(i, i2, i3);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3621m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3621m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3621m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}