package gnu.trove.impl.sync;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TObjectCharIterator;
import gnu.trove.map.TObjectCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TObjectCharProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TSynchronizedObjectCharMap<K> implements TObjectCharMap<K>, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TObjectCharMap<K> f3635m;
    final Object mutex;
    private transient Set<K> keySet = null;
    private transient TCharCollection values = null;

    public TSynchronizedObjectCharMap(TObjectCharMap<K> tObjectCharMap) {
        Objects.requireNonNull(tObjectCharMap);
        this.f3635m = tObjectCharMap;
        this.mutex = this;
    }

    public TSynchronizedObjectCharMap(TObjectCharMap<K> tObjectCharMap, Object obj) {
        this.f3635m = tObjectCharMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3635m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3635m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3635m.containsKey(obj);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean containsValue(char c) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3635m.containsValue(c);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char get(Object obj) {
        char c;
        synchronized (this.mutex) {
            c = this.f3635m.get(obj);
        }
        return c;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char put(K k, char c) {
        char put;
        synchronized (this.mutex) {
            put = this.f3635m.put(k, c);
        }
        return put;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char remove(Object obj) {
        char remove;
        synchronized (this.mutex) {
            remove = this.f3635m.remove(obj);
        }
        return remove;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public void putAll(Map<? extends K, ? extends Character> map) {
        synchronized (this.mutex) {
            this.f3635m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public void putAll(TObjectCharMap<? extends K> tObjectCharMap) {
        synchronized (this.mutex) {
            this.f3635m.putAll(tObjectCharMap);
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3635m.clear();
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public Set<K> keySet() {
        Set<K> set;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new SynchronizedSet(this.f3635m.keySet(), this.mutex);
            }
            set = this.keySet;
        }
        return set;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public Object[] keys() {
        Object[] keys;
        synchronized (this.mutex) {
            keys = this.f3635m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public K[] keys(K[] kArr) {
        K[] keys;
        synchronized (this.mutex) {
            keys = this.f3635m.keys(kArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public TCharCollection valueCollection() {
        TCharCollection tCharCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedCharCollection(this.f3635m.valueCollection(), this.mutex);
            }
            tCharCollection = this.values;
        }
        return tCharCollection;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char[] values() {
        char[] values;
        synchronized (this.mutex) {
            values = this.f3635m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char[] values(char[] cArr) {
        char[] values;
        synchronized (this.mutex) {
            values = this.f3635m.values(cArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public TObjectCharIterator<K> iterator() {
        return this.f3635m.iterator();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char getNoEntryValue() {
        return this.f3635m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char putIfAbsent(K k, char c) {
        char putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3635m.putIfAbsent(k, c);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3635m.forEachKey(tObjectProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3635m.forEachValue(tCharProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean forEachEntry(TObjectCharProcedure<? super K> tObjectCharProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3635m.forEachEntry(tObjectCharProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public void transformValues(TCharFunction tCharFunction) {
        synchronized (this.mutex) {
            this.f3635m.transformValues(tCharFunction);
        }
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean retainEntries(TObjectCharProcedure<? super K> tObjectCharProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3635m.retainEntries(tObjectCharProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean increment(K k) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3635m.increment(k);
        }
        return increment;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean adjustValue(K k, char c) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3635m.adjustValue(k, c);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char adjustOrPutValue(K k, char c, char c2) {
        char adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3635m.adjustOrPutValue(k, c, c2);
        }
        return adjustOrPutValue;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3635m.equals(obj);
        }
        return equals;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3635m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3635m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}