package gnu.trove.impl.sync;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TObjectShortIterator;
import gnu.trove.map.TObjectShortMap;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.procedure.TObjectShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TSynchronizedObjectShortMap<K> implements TObjectShortMap<K>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TObjectShortMap<K> f3640m;
    final Object mutex;
    private transient Set<K> keySet = null;
    private transient TShortCollection values = null;

    public TSynchronizedObjectShortMap(TObjectShortMap<K> tObjectShortMap) {
        Objects.requireNonNull(tObjectShortMap);
        this.f3640m = tObjectShortMap;
        this.mutex = this;
    }

    public TSynchronizedObjectShortMap(TObjectShortMap<K> tObjectShortMap, Object obj) {
        this.f3640m = tObjectShortMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3640m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3640m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3640m.containsKey(obj);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean containsValue(short s) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3640m.containsValue(s);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short get(Object obj) {
        short s;
        synchronized (this.mutex) {
            s = this.f3640m.get(obj);
        }
        return s;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short put(K k, short s) {
        short put;
        synchronized (this.mutex) {
            put = this.f3640m.put(k, s);
        }
        return put;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short remove(Object obj) {
        short remove;
        synchronized (this.mutex) {
            remove = this.f3640m.remove(obj);
        }
        return remove;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public void putAll(Map<? extends K, ? extends Short> map) {
        synchronized (this.mutex) {
            this.f3640m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public void putAll(TObjectShortMap<? extends K> tObjectShortMap) {
        synchronized (this.mutex) {
            this.f3640m.putAll(tObjectShortMap);
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3640m.clear();
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public Set<K> keySet() {
        Set<K> set;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new SynchronizedSet(this.f3640m.keySet(), this.mutex);
            }
            set = this.keySet;
        }
        return set;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public Object[] keys() {
        Object[] keys;
        synchronized (this.mutex) {
            keys = this.f3640m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public K[] keys(K[] kArr) {
        K[] keys;
        synchronized (this.mutex) {
            keys = this.f3640m.keys(kArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public TShortCollection valueCollection() {
        TShortCollection tShortCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedShortCollection(this.f3640m.valueCollection(), this.mutex);
            }
            tShortCollection = this.values;
        }
        return tShortCollection;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short[] values() {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3640m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short[] values(short[] sArr) {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3640m.values(sArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public TObjectShortIterator<K> iterator() {
        return this.f3640m.iterator();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short getNoEntryValue() {
        return this.f3640m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short putIfAbsent(K k, short s) {
        short putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3640m.putIfAbsent(k, s);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3640m.forEachKey(tObjectProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3640m.forEachValue(tShortProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean forEachEntry(TObjectShortProcedure<? super K> tObjectShortProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3640m.forEachEntry(tObjectShortProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public void transformValues(TShortFunction tShortFunction) {
        synchronized (this.mutex) {
            this.f3640m.transformValues(tShortFunction);
        }
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean retainEntries(TObjectShortProcedure<? super K> tObjectShortProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3640m.retainEntries(tObjectShortProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean increment(K k) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3640m.increment(k);
        }
        return increment;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean adjustValue(K k, short s) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3640m.adjustValue(k, s);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short adjustOrPutValue(K k, short s, short s2) {
        short adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3640m.adjustOrPutValue(k, s, s2);
        }
        return adjustOrPutValue;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3640m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3640m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3640m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}