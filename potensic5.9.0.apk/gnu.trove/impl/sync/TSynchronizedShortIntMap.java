package gnu.trove.impl.sync;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TShortIntIterator;
import gnu.trove.map.TShortIntMap;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TShortIntProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedShortIntMap implements TShortIntMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TShortIntMap f3646m;
    final Object mutex;
    private transient TShortSet keySet = null;
    private transient TIntCollection values = null;

    public TSynchronizedShortIntMap(TShortIntMap tShortIntMap) {
        Objects.requireNonNull(tShortIntMap);
        this.f3646m = tShortIntMap;
        this.mutex = this;
    }

    public TSynchronizedShortIntMap(TShortIntMap tShortIntMap, Object obj) {
        this.f3646m = tShortIntMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TShortIntMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3646m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3646m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean containsKey(short s) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3646m.containsKey(s);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean containsValue(int i) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3646m.containsValue(i);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TShortIntMap
    public int get(short s) {
        int i;
        synchronized (this.mutex) {
            i = this.f3646m.get(s);
        }
        return i;
    }

    @Override // gnu.trove.map.TShortIntMap
    public int put(short s, int i) {
        int put;
        synchronized (this.mutex) {
            put = this.f3646m.put(s, i);
        }
        return put;
    }

    @Override // gnu.trove.map.TShortIntMap
    public int remove(short s) {
        int remove;
        synchronized (this.mutex) {
            remove = this.f3646m.remove(s);
        }
        return remove;
    }

    @Override // gnu.trove.map.TShortIntMap
    public void putAll(Map<? extends Short, ? extends Integer> map) {
        synchronized (this.mutex) {
            this.f3646m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TShortIntMap
    public void putAll(TShortIntMap tShortIntMap) {
        synchronized (this.mutex) {
            this.f3646m.putAll(tShortIntMap);
        }
    }

    @Override // gnu.trove.map.TShortIntMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3646m.clear();
        }
    }

    @Override // gnu.trove.map.TShortIntMap
    public TShortSet keySet() {
        TShortSet tShortSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedShortSet(this.f3646m.keySet(), this.mutex);
            }
            tShortSet = this.keySet;
        }
        return tShortSet;
    }

    @Override // gnu.trove.map.TShortIntMap
    public short[] keys() {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3646m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortIntMap
    public short[] keys(short[] sArr) {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3646m.keys(sArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortIntMap
    public TIntCollection valueCollection() {
        TIntCollection tIntCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedIntCollection(this.f3646m.valueCollection(), this.mutex);
            }
            tIntCollection = this.values;
        }
        return tIntCollection;
    }

    @Override // gnu.trove.map.TShortIntMap
    public int[] values() {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3646m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TShortIntMap
    public int[] values(int[] iArr) {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3646m.values(iArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TShortIntMap
    public TShortIntIterator iterator() {
        return this.f3646m.iterator();
    }

    @Override // gnu.trove.map.TShortIntMap
    public short getNoEntryKey() {
        return this.f3646m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortIntMap
    public int getNoEntryValue() {
        return this.f3646m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortIntMap
    public int putIfAbsent(short s, int i) {
        int putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3646m.putIfAbsent(s, i);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3646m.forEachKey(tShortProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3646m.forEachValue(tIntProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean forEachEntry(TShortIntProcedure tShortIntProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3646m.forEachEntry(tShortIntProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TShortIntMap
    public void transformValues(TIntFunction tIntFunction) {
        synchronized (this.mutex) {
            this.f3646m.transformValues(tIntFunction);
        }
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean retainEntries(TShortIntProcedure tShortIntProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3646m.retainEntries(tShortIntProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean increment(short s) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3646m.increment(s);
        }
        return increment;
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean adjustValue(short s, int i) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3646m.adjustValue(s, i);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TShortIntMap
    public int adjustOrPutValue(short s, int i, int i2) {
        int adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3646m.adjustOrPutValue(s, i, i2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3646m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3646m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3646m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}