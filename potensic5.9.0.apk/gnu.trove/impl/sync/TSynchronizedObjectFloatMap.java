package gnu.trove.impl.sync;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TObjectFloatIterator;
import gnu.trove.map.TObjectFloatMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TObjectFloatProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TSynchronizedObjectFloatMap<K> implements TObjectFloatMap<K>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TObjectFloatMap<K> f3637m;
    final Object mutex;
    private transient Set<K> keySet = null;
    private transient TFloatCollection values = null;

    public TSynchronizedObjectFloatMap(TObjectFloatMap<K> tObjectFloatMap) {
        Objects.requireNonNull(tObjectFloatMap);
        this.f3637m = tObjectFloatMap;
        this.mutex = this;
    }

    public TSynchronizedObjectFloatMap(TObjectFloatMap<K> tObjectFloatMap, Object obj) {
        this.f3637m = tObjectFloatMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3637m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3637m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3637m.containsKey(obj);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean containsValue(float f) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3637m.containsValue(f);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float get(Object obj) {
        float f;
        synchronized (this.mutex) {
            f = this.f3637m.get(obj);
        }
        return f;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float put(K k, float f) {
        float put;
        synchronized (this.mutex) {
            put = this.f3637m.put(k, f);
        }
        return put;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float remove(Object obj) {
        float remove;
        synchronized (this.mutex) {
            remove = this.f3637m.remove(obj);
        }
        return remove;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public void putAll(Map<? extends K, ? extends Float> map) {
        synchronized (this.mutex) {
            this.f3637m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public void putAll(TObjectFloatMap<? extends K> tObjectFloatMap) {
        synchronized (this.mutex) {
            this.f3637m.putAll(tObjectFloatMap);
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3637m.clear();
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public Set<K> keySet() {
        Set<K> set;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new SynchronizedSet(this.f3637m.keySet(), this.mutex);
            }
            set = this.keySet;
        }
        return set;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public Object[] keys() {
        Object[] keys;
        synchronized (this.mutex) {
            keys = this.f3637m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public K[] keys(K[] kArr) {
        K[] keys;
        synchronized (this.mutex) {
            keys = this.f3637m.keys(kArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public TFloatCollection valueCollection() {
        TFloatCollection tFloatCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedFloatCollection(this.f3637m.valueCollection(), this.mutex);
            }
            tFloatCollection = this.values;
        }
        return tFloatCollection;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float[] values() {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3637m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float[] values(float[] fArr) {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3637m.values(fArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public TObjectFloatIterator<K> iterator() {
        return this.f3637m.iterator();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float getNoEntryValue() {
        return this.f3637m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float putIfAbsent(K k, float f) {
        float putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3637m.putIfAbsent(k, f);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3637m.forEachKey(tObjectProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3637m.forEachValue(tFloatProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean forEachEntry(TObjectFloatProcedure<? super K> tObjectFloatProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3637m.forEachEntry(tObjectFloatProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        synchronized (this.mutex) {
            this.f3637m.transformValues(tFloatFunction);
        }
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean retainEntries(TObjectFloatProcedure<? super K> tObjectFloatProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3637m.retainEntries(tObjectFloatProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean increment(K k) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3637m.increment(k);
        }
        return increment;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean adjustValue(K k, float f) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3637m.adjustValue(k, f);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float adjustOrPutValue(K k, float f, float f2) {
        float adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3637m.adjustOrPutValue(k, f, f2);
        }
        return adjustOrPutValue;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3637m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3637m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3637m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}