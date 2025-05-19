package gnu.trove.impl.sync;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TObjectIntIterator;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TObjectIntProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TSynchronizedObjectIntMap<K> implements TObjectIntMap<K>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TObjectIntMap<K> m;
    final Object mutex;
    private transient Set<K> keySet = null;
    private transient TIntCollection values = null;

    public TSynchronizedObjectIntMap(TObjectIntMap<K> tObjectIntMap) {
        Objects.requireNonNull(tObjectIntMap);
        this.m = tObjectIntMap;
        this.mutex = this;
    }

    public TSynchronizedObjectIntMap(TObjectIntMap<K> tObjectIntMap, Object obj) {
        this.m = tObjectIntMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(obj);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean containsValue(int i) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(i);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int get(Object obj) {
        int i;
        synchronized (this.mutex) {
            i = this.m.get(obj);
        }
        return i;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int put(K k, int i) {
        int put;
        synchronized (this.mutex) {
            put = this.m.put(k, i);
        }
        return put;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int remove(Object obj) {
        int remove;
        synchronized (this.mutex) {
            remove = this.m.remove(obj);
        }
        return remove;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void putAll(Map<? extends K, ? extends Integer> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void putAll(TObjectIntMap<? extends K> tObjectIntMap) {
        synchronized (this.mutex) {
            this.m.putAll(tObjectIntMap);
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public Set<K> keySet() {
        Set<K> set;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new SynchronizedSet(this.m.keySet(), this.mutex);
            }
            set = this.keySet;
        }
        return set;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public Object[] keys() {
        Object[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public K[] keys(K[] kArr) {
        K[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(kArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectIntMap
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

    @Override // gnu.trove.map.TObjectIntMap
    public int[] values() {
        int[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int[] values(int[] iArr) {
        int[] values;
        synchronized (this.mutex) {
            values = this.m.values(iArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public TObjectIntIterator<K> iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int putIfAbsent(K k, int i) {
        int putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(k, i);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tObjectProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tIntProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean forEachEntry(TObjectIntProcedure<? super K> tObjectIntProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tObjectIntProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void transformValues(TIntFunction tIntFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tIntFunction);
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean retainEntries(TObjectIntProcedure<? super K> tObjectIntProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tObjectIntProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean increment(K k) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(k);
        }
        return increment;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean adjustValue(K k, int i) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(k, i);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int adjustOrPutValue(K k, int i, int i2) {
        int adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(k, i, i2);
        }
        return adjustOrPutValue;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TObjectIntMap
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
