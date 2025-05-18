package gnu.trove.impl.sync;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TCharIntIterator;
import gnu.trove.map.TCharIntMap;
import gnu.trove.procedure.TCharIntProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TCharSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedCharIntMap implements TCharIntMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TCharIntMap f3594m;
    final Object mutex;
    private transient TCharSet keySet = null;
    private transient TIntCollection values = null;

    public TSynchronizedCharIntMap(TCharIntMap tCharIntMap) {
        Objects.requireNonNull(tCharIntMap);
        this.f3594m = tCharIntMap;
        this.mutex = this;
    }

    public TSynchronizedCharIntMap(TCharIntMap tCharIntMap, Object obj) {
        this.f3594m = tCharIntMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TCharIntMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3594m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3594m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean containsKey(char c) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3594m.containsKey(c);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean containsValue(int i) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3594m.containsValue(i);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TCharIntMap
    public int get(char c) {
        int i;
        synchronized (this.mutex) {
            i = this.f3594m.get(c);
        }
        return i;
    }

    @Override // gnu.trove.map.TCharIntMap
    public int put(char c, int i) {
        int put;
        synchronized (this.mutex) {
            put = this.f3594m.put(c, i);
        }
        return put;
    }

    @Override // gnu.trove.map.TCharIntMap
    public int remove(char c) {
        int remove;
        synchronized (this.mutex) {
            remove = this.f3594m.remove(c);
        }
        return remove;
    }

    @Override // gnu.trove.map.TCharIntMap
    public void putAll(Map<? extends Character, ? extends Integer> map) {
        synchronized (this.mutex) {
            this.f3594m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TCharIntMap
    public void putAll(TCharIntMap tCharIntMap) {
        synchronized (this.mutex) {
            this.f3594m.putAll(tCharIntMap);
        }
    }

    @Override // gnu.trove.map.TCharIntMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3594m.clear();
        }
    }

    @Override // gnu.trove.map.TCharIntMap
    public TCharSet keySet() {
        TCharSet tCharSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedCharSet(this.f3594m.keySet(), this.mutex);
            }
            tCharSet = this.keySet;
        }
        return tCharSet;
    }

    @Override // gnu.trove.map.TCharIntMap
    public char[] keys() {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.f3594m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharIntMap
    public char[] keys(char[] cArr) {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.f3594m.keys(cArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharIntMap
    public TIntCollection valueCollection() {
        TIntCollection tIntCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedIntCollection(this.f3594m.valueCollection(), this.mutex);
            }
            tIntCollection = this.values;
        }
        return tIntCollection;
    }

    @Override // gnu.trove.map.TCharIntMap
    public int[] values() {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3594m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TCharIntMap
    public int[] values(int[] iArr) {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3594m.values(iArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TCharIntMap
    public TCharIntIterator iterator() {
        return this.f3594m.iterator();
    }

    @Override // gnu.trove.map.TCharIntMap
    public char getNoEntryKey() {
        return this.f3594m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharIntMap
    public int getNoEntryValue() {
        return this.f3594m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharIntMap
    public int putIfAbsent(char c, int i) {
        int putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3594m.putIfAbsent(c, i);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3594m.forEachKey(tCharProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3594m.forEachValue(tIntProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean forEachEntry(TCharIntProcedure tCharIntProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3594m.forEachEntry(tCharIntProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TCharIntMap
    public void transformValues(TIntFunction tIntFunction) {
        synchronized (this.mutex) {
            this.f3594m.transformValues(tIntFunction);
        }
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean retainEntries(TCharIntProcedure tCharIntProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3594m.retainEntries(tCharIntProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean increment(char c) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3594m.increment(c);
        }
        return increment;
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean adjustValue(char c, int i) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3594m.adjustValue(c, i);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TCharIntMap
    public int adjustOrPutValue(char c, int i, int i2) {
        int adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3594m.adjustOrPutValue(c, i, i2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3594m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3594m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3594m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}