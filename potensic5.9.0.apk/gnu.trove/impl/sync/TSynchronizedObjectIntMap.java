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

    /* renamed from: m */
    private final TObjectIntMap<K> f3638m;
    final Object mutex;
    private transient Set<K> keySet = null;
    private transient TIntCollection values = null;

    public TSynchronizedObjectIntMap(TObjectIntMap<K> tObjectIntMap) {
        Objects.requireNonNull(tObjectIntMap);
        this.f3638m = tObjectIntMap;
        this.mutex = this;
    }

    public TSynchronizedObjectIntMap(TObjectIntMap<K> tObjectIntMap, Object obj) {
        this.f3638m = tObjectIntMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3638m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3638m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3638m.containsKey(obj);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean containsValue(int i) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3638m.containsValue(i);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int get(Object obj) {
        int i;
        synchronized (this.mutex) {
            i = this.f3638m.get(obj);
        }
        return i;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int put(K k, int i) {
        int put;
        synchronized (this.mutex) {
            put = this.f3638m.put(k, i);
        }
        return put;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int remove(Object obj) {
        int remove;
        synchronized (this.mutex) {
            remove = this.f3638m.remove(obj);
        }
        return remove;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void putAll(Map<? extends K, ? extends Integer> map) {
        synchronized (this.mutex) {
            this.f3638m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void putAll(TObjectIntMap<? extends K> tObjectIntMap) {
        synchronized (this.mutex) {
            this.f3638m.putAll(tObjectIntMap);
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3638m.clear();
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public Set<K> keySet() {
        Set<K> set;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new SynchronizedSet(this.f3638m.keySet(), this.mutex);
            }
            set = this.keySet;
        }
        return set;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public Object[] keys() {
        Object[] keys;
        synchronized (this.mutex) {
            keys = this.f3638m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public K[] keys(K[] kArr) {
        K[] keys;
        synchronized (this.mutex) {
            keys = this.f3638m.keys(kArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public TIntCollection valueCollection() {
        TIntCollection tIntCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedIntCollection(this.f3638m.valueCollection(), this.mutex);
            }
            tIntCollection = this.values;
        }
        return tIntCollection;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int[] values() {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3638m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int[] values(int[] iArr) {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3638m.values(iArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public TObjectIntIterator<K> iterator() {
        return this.f3638m.iterator();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int getNoEntryValue() {
        return this.f3638m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int putIfAbsent(K k, int i) {
        int putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3638m.putIfAbsent(k, i);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3638m.forEachKey(tObjectProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3638m.forEachValue(tIntProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean forEachEntry(TObjectIntProcedure<? super K> tObjectIntProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3638m.forEachEntry(tObjectIntProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void transformValues(TIntFunction tIntFunction) {
        synchronized (this.mutex) {
            this.f3638m.transformValues(tIntFunction);
        }
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean retainEntries(TObjectIntProcedure<? super K> tObjectIntProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3638m.retainEntries(tObjectIntProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean increment(K k) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3638m.increment(k);
        }
        return increment;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean adjustValue(K k, int i) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3638m.adjustValue(k, i);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int adjustOrPutValue(K k, int i, int i2) {
        int adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3638m.adjustOrPutValue(k, i, i2);
        }
        return adjustOrPutValue;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3638m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3638m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3638m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}