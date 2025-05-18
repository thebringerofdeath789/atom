package gnu.trove.impl.sync;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TObjectDoubleIterator;
import gnu.trove.map.TObjectDoubleMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TObjectDoubleProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TSynchronizedObjectDoubleMap<K> implements TObjectDoubleMap<K>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TObjectDoubleMap<K> f3636m;
    final Object mutex;
    private transient Set<K> keySet = null;
    private transient TDoubleCollection values = null;

    public TSynchronizedObjectDoubleMap(TObjectDoubleMap<K> tObjectDoubleMap) {
        Objects.requireNonNull(tObjectDoubleMap);
        this.f3636m = tObjectDoubleMap;
        this.mutex = this;
    }

    public TSynchronizedObjectDoubleMap(TObjectDoubleMap<K> tObjectDoubleMap, Object obj) {
        this.f3636m = tObjectDoubleMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3636m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3636m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3636m.containsKey(obj);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean containsValue(double d) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3636m.containsValue(d);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double get(Object obj) {
        double d;
        synchronized (this.mutex) {
            d = this.f3636m.get(obj);
        }
        return d;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double put(K k, double d) {
        double put;
        synchronized (this.mutex) {
            put = this.f3636m.put(k, d);
        }
        return put;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double remove(Object obj) {
        double remove;
        synchronized (this.mutex) {
            remove = this.f3636m.remove(obj);
        }
        return remove;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public void putAll(Map<? extends K, ? extends Double> map) {
        synchronized (this.mutex) {
            this.f3636m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public void putAll(TObjectDoubleMap<? extends K> tObjectDoubleMap) {
        synchronized (this.mutex) {
            this.f3636m.putAll(tObjectDoubleMap);
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3636m.clear();
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public Set<K> keySet() {
        Set<K> set;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new SynchronizedSet(this.f3636m.keySet(), this.mutex);
            }
            set = this.keySet;
        }
        return set;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public Object[] keys() {
        Object[] keys;
        synchronized (this.mutex) {
            keys = this.f3636m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public K[] keys(K[] kArr) {
        K[] keys;
        synchronized (this.mutex) {
            keys = this.f3636m.keys(kArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public TDoubleCollection valueCollection() {
        TDoubleCollection tDoubleCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedDoubleCollection(this.f3636m.valueCollection(), this.mutex);
            }
            tDoubleCollection = this.values;
        }
        return tDoubleCollection;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double[] values() {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3636m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double[] values(double[] dArr) {
        double[] values;
        synchronized (this.mutex) {
            values = this.f3636m.values(dArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public TObjectDoubleIterator<K> iterator() {
        return this.f3636m.iterator();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double getNoEntryValue() {
        return this.f3636m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double putIfAbsent(K k, double d) {
        double putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3636m.putIfAbsent(k, d);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3636m.forEachKey(tObjectProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3636m.forEachValue(tDoubleProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean forEachEntry(TObjectDoubleProcedure<? super K> tObjectDoubleProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3636m.forEachEntry(tObjectDoubleProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        synchronized (this.mutex) {
            this.f3636m.transformValues(tDoubleFunction);
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean retainEntries(TObjectDoubleProcedure<? super K> tObjectDoubleProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3636m.retainEntries(tObjectDoubleProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean increment(K k) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3636m.increment(k);
        }
        return increment;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean adjustValue(K k, double d) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3636m.adjustValue(k, d);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double adjustOrPutValue(K k, double d, double d2) {
        double adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3636m.adjustOrPutValue(k, d, d2);
        }
        return adjustOrPutValue;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3636m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3636m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3636m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}