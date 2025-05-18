package gnu.trove.impl.sync;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TIntShortIterator;
import gnu.trove.map.TIntShortMap;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TIntShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TIntSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedIntShortMap implements TIntShortMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TIntShortMap f3624m;
    final Object mutex;
    private transient TIntSet keySet = null;
    private transient TShortCollection values = null;

    public TSynchronizedIntShortMap(TIntShortMap tIntShortMap) {
        Objects.requireNonNull(tIntShortMap);
        this.f3624m = tIntShortMap;
        this.mutex = this;
    }

    public TSynchronizedIntShortMap(TIntShortMap tIntShortMap, Object obj) {
        this.f3624m = tIntShortMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TIntShortMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3624m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3624m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean containsKey(int i) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3624m.containsKey(i);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean containsValue(short s) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3624m.containsValue(s);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TIntShortMap
    public short get(int i) {
        short s;
        synchronized (this.mutex) {
            s = this.f3624m.get(i);
        }
        return s;
    }

    @Override // gnu.trove.map.TIntShortMap
    public short put(int i, short s) {
        short put;
        synchronized (this.mutex) {
            put = this.f3624m.put(i, s);
        }
        return put;
    }

    @Override // gnu.trove.map.TIntShortMap
    public short remove(int i) {
        short remove;
        synchronized (this.mutex) {
            remove = this.f3624m.remove(i);
        }
        return remove;
    }

    @Override // gnu.trove.map.TIntShortMap
    public void putAll(Map<? extends Integer, ? extends Short> map) {
        synchronized (this.mutex) {
            this.f3624m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TIntShortMap
    public void putAll(TIntShortMap tIntShortMap) {
        synchronized (this.mutex) {
            this.f3624m.putAll(tIntShortMap);
        }
    }

    @Override // gnu.trove.map.TIntShortMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3624m.clear();
        }
    }

    @Override // gnu.trove.map.TIntShortMap
    public TIntSet keySet() {
        TIntSet tIntSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedIntSet(this.f3624m.keySet(), this.mutex);
            }
            tIntSet = this.keySet;
        }
        return tIntSet;
    }

    @Override // gnu.trove.map.TIntShortMap
    public int[] keys() {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3624m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntShortMap
    public int[] keys(int[] iArr) {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3624m.keys(iArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntShortMap
    public TShortCollection valueCollection() {
        TShortCollection tShortCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedShortCollection(this.f3624m.valueCollection(), this.mutex);
            }
            tShortCollection = this.values;
        }
        return tShortCollection;
    }

    @Override // gnu.trove.map.TIntShortMap
    public short[] values() {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3624m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TIntShortMap
    public short[] values(short[] sArr) {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3624m.values(sArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TIntShortMap
    public TIntShortIterator iterator() {
        return this.f3624m.iterator();
    }

    @Override // gnu.trove.map.TIntShortMap
    public int getNoEntryKey() {
        return this.f3624m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntShortMap
    public short getNoEntryValue() {
        return this.f3624m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntShortMap
    public short putIfAbsent(int i, short s) {
        short putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3624m.putIfAbsent(i, s);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3624m.forEachKey(tIntProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3624m.forEachValue(tShortProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean forEachEntry(TIntShortProcedure tIntShortProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3624m.forEachEntry(tIntShortProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TIntShortMap
    public void transformValues(TShortFunction tShortFunction) {
        synchronized (this.mutex) {
            this.f3624m.transformValues(tShortFunction);
        }
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean retainEntries(TIntShortProcedure tIntShortProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3624m.retainEntries(tIntShortProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean increment(int i) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3624m.increment(i);
        }
        return increment;
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean adjustValue(int i, short s) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3624m.adjustValue(i, s);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TIntShortMap
    public short adjustOrPutValue(int i, short s, short s2) {
        short adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3624m.adjustOrPutValue(i, s, s2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3624m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3624m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3624m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}