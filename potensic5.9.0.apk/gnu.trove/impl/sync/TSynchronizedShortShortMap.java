package gnu.trove.impl.sync;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TShortShortIterator;
import gnu.trove.map.TShortShortMap;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.procedure.TShortShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedShortShortMap implements TShortShortMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TShortShortMap f3649m;
    final Object mutex;
    private transient TShortSet keySet = null;
    private transient TShortCollection values = null;

    public TSynchronizedShortShortMap(TShortShortMap tShortShortMap) {
        Objects.requireNonNull(tShortShortMap);
        this.f3649m = tShortShortMap;
        this.mutex = this;
    }

    public TSynchronizedShortShortMap(TShortShortMap tShortShortMap, Object obj) {
        this.f3649m = tShortShortMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TShortShortMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3649m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3649m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean containsKey(short s) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3649m.containsKey(s);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean containsValue(short s) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3649m.containsValue(s);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TShortShortMap
    public short get(short s) {
        short s2;
        synchronized (this.mutex) {
            s2 = this.f3649m.get(s);
        }
        return s2;
    }

    @Override // gnu.trove.map.TShortShortMap
    public short put(short s, short s2) {
        short put;
        synchronized (this.mutex) {
            put = this.f3649m.put(s, s2);
        }
        return put;
    }

    @Override // gnu.trove.map.TShortShortMap
    public short remove(short s) {
        short remove;
        synchronized (this.mutex) {
            remove = this.f3649m.remove(s);
        }
        return remove;
    }

    @Override // gnu.trove.map.TShortShortMap
    public void putAll(Map<? extends Short, ? extends Short> map) {
        synchronized (this.mutex) {
            this.f3649m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TShortShortMap
    public void putAll(TShortShortMap tShortShortMap) {
        synchronized (this.mutex) {
            this.f3649m.putAll(tShortShortMap);
        }
    }

    @Override // gnu.trove.map.TShortShortMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3649m.clear();
        }
    }

    @Override // gnu.trove.map.TShortShortMap
    public TShortSet keySet() {
        TShortSet tShortSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedShortSet(this.f3649m.keySet(), this.mutex);
            }
            tShortSet = this.keySet;
        }
        return tShortSet;
    }

    @Override // gnu.trove.map.TShortShortMap
    public short[] keys() {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3649m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortShortMap
    public short[] keys(short[] sArr) {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3649m.keys(sArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortShortMap
    public TShortCollection valueCollection() {
        TShortCollection tShortCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedShortCollection(this.f3649m.valueCollection(), this.mutex);
            }
            tShortCollection = this.values;
        }
        return tShortCollection;
    }

    @Override // gnu.trove.map.TShortShortMap
    public short[] values() {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3649m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TShortShortMap
    public short[] values(short[] sArr) {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3649m.values(sArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TShortShortMap
    public TShortShortIterator iterator() {
        return this.f3649m.iterator();
    }

    @Override // gnu.trove.map.TShortShortMap
    public short getNoEntryKey() {
        return this.f3649m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortShortMap
    public short getNoEntryValue() {
        return this.f3649m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortShortMap
    public short putIfAbsent(short s, short s2) {
        short putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3649m.putIfAbsent(s, s2);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3649m.forEachKey(tShortProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3649m.forEachValue(tShortProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean forEachEntry(TShortShortProcedure tShortShortProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3649m.forEachEntry(tShortShortProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TShortShortMap
    public void transformValues(TShortFunction tShortFunction) {
        synchronized (this.mutex) {
            this.f3649m.transformValues(tShortFunction);
        }
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean retainEntries(TShortShortProcedure tShortShortProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3649m.retainEntries(tShortShortProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean increment(short s) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3649m.increment(s);
        }
        return increment;
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean adjustValue(short s, short s2) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3649m.adjustValue(s, s2);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TShortShortMap
    public short adjustOrPutValue(short s, short s2, short s3) {
        short adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3649m.adjustOrPutValue(s, s2, s3);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3649m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3649m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3649m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}