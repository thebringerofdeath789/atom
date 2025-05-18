package gnu.trove.impl.sync;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TCharShortIterator;
import gnu.trove.map.TCharShortMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TCharShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TCharSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedCharShortMap implements TCharShortMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TCharShortMap f3597m;
    final Object mutex;
    private transient TCharSet keySet = null;
    private transient TShortCollection values = null;

    public TSynchronizedCharShortMap(TCharShortMap tCharShortMap) {
        Objects.requireNonNull(tCharShortMap);
        this.f3597m = tCharShortMap;
        this.mutex = this;
    }

    public TSynchronizedCharShortMap(TCharShortMap tCharShortMap, Object obj) {
        this.f3597m = tCharShortMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TCharShortMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3597m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3597m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean containsKey(char c) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3597m.containsKey(c);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean containsValue(short s) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3597m.containsValue(s);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TCharShortMap
    public short get(char c) {
        short s;
        synchronized (this.mutex) {
            s = this.f3597m.get(c);
        }
        return s;
    }

    @Override // gnu.trove.map.TCharShortMap
    public short put(char c, short s) {
        short put;
        synchronized (this.mutex) {
            put = this.f3597m.put(c, s);
        }
        return put;
    }

    @Override // gnu.trove.map.TCharShortMap
    public short remove(char c) {
        short remove;
        synchronized (this.mutex) {
            remove = this.f3597m.remove(c);
        }
        return remove;
    }

    @Override // gnu.trove.map.TCharShortMap
    public void putAll(Map<? extends Character, ? extends Short> map) {
        synchronized (this.mutex) {
            this.f3597m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TCharShortMap
    public void putAll(TCharShortMap tCharShortMap) {
        synchronized (this.mutex) {
            this.f3597m.putAll(tCharShortMap);
        }
    }

    @Override // gnu.trove.map.TCharShortMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3597m.clear();
        }
    }

    @Override // gnu.trove.map.TCharShortMap
    public TCharSet keySet() {
        TCharSet tCharSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedCharSet(this.f3597m.keySet(), this.mutex);
            }
            tCharSet = this.keySet;
        }
        return tCharSet;
    }

    @Override // gnu.trove.map.TCharShortMap
    public char[] keys() {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.f3597m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharShortMap
    public char[] keys(char[] cArr) {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.f3597m.keys(cArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharShortMap
    public TShortCollection valueCollection() {
        TShortCollection tShortCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedShortCollection(this.f3597m.valueCollection(), this.mutex);
            }
            tShortCollection = this.values;
        }
        return tShortCollection;
    }

    @Override // gnu.trove.map.TCharShortMap
    public short[] values() {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3597m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TCharShortMap
    public short[] values(short[] sArr) {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3597m.values(sArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TCharShortMap
    public TCharShortIterator iterator() {
        return this.f3597m.iterator();
    }

    @Override // gnu.trove.map.TCharShortMap
    public char getNoEntryKey() {
        return this.f3597m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharShortMap
    public short getNoEntryValue() {
        return this.f3597m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharShortMap
    public short putIfAbsent(char c, short s) {
        short putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3597m.putIfAbsent(c, s);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3597m.forEachKey(tCharProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3597m.forEachValue(tShortProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean forEachEntry(TCharShortProcedure tCharShortProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3597m.forEachEntry(tCharShortProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TCharShortMap
    public void transformValues(TShortFunction tShortFunction) {
        synchronized (this.mutex) {
            this.f3597m.transformValues(tShortFunction);
        }
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean retainEntries(TCharShortProcedure tCharShortProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3597m.retainEntries(tCharShortProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean increment(char c) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3597m.increment(c);
        }
        return increment;
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean adjustValue(char c, short s) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3597m.adjustValue(c, s);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TCharShortMap
    public short adjustOrPutValue(char c, short s, short s2) {
        short adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3597m.adjustOrPutValue(c, s, s2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3597m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3597m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3597m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}