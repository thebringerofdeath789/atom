package gnu.trove.impl.sync;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TShortCharIterator;
import gnu.trove.map.TShortCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TShortCharProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedShortCharMap implements TShortCharMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TShortCharMap f3642m;
    final Object mutex;
    private transient TShortSet keySet = null;
    private transient TCharCollection values = null;

    public TSynchronizedShortCharMap(TShortCharMap tShortCharMap) {
        Objects.requireNonNull(tShortCharMap);
        this.f3642m = tShortCharMap;
        this.mutex = this;
    }

    public TSynchronizedShortCharMap(TShortCharMap tShortCharMap, Object obj) {
        this.f3642m = tShortCharMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TShortCharMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3642m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3642m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean containsKey(short s) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3642m.containsKey(s);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean containsValue(char c) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3642m.containsValue(c);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TShortCharMap
    public char get(short s) {
        char c;
        synchronized (this.mutex) {
            c = this.f3642m.get(s);
        }
        return c;
    }

    @Override // gnu.trove.map.TShortCharMap
    public char put(short s, char c) {
        char put;
        synchronized (this.mutex) {
            put = this.f3642m.put(s, c);
        }
        return put;
    }

    @Override // gnu.trove.map.TShortCharMap
    public char remove(short s) {
        char remove;
        synchronized (this.mutex) {
            remove = this.f3642m.remove(s);
        }
        return remove;
    }

    @Override // gnu.trove.map.TShortCharMap
    public void putAll(Map<? extends Short, ? extends Character> map) {
        synchronized (this.mutex) {
            this.f3642m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TShortCharMap
    public void putAll(TShortCharMap tShortCharMap) {
        synchronized (this.mutex) {
            this.f3642m.putAll(tShortCharMap);
        }
    }

    @Override // gnu.trove.map.TShortCharMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3642m.clear();
        }
    }

    @Override // gnu.trove.map.TShortCharMap
    public TShortSet keySet() {
        TShortSet tShortSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedShortSet(this.f3642m.keySet(), this.mutex);
            }
            tShortSet = this.keySet;
        }
        return tShortSet;
    }

    @Override // gnu.trove.map.TShortCharMap
    public short[] keys() {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3642m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortCharMap
    public short[] keys(short[] sArr) {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3642m.keys(sArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortCharMap
    public TCharCollection valueCollection() {
        TCharCollection tCharCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedCharCollection(this.f3642m.valueCollection(), this.mutex);
            }
            tCharCollection = this.values;
        }
        return tCharCollection;
    }

    @Override // gnu.trove.map.TShortCharMap
    public char[] values() {
        char[] values;
        synchronized (this.mutex) {
            values = this.f3642m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TShortCharMap
    public char[] values(char[] cArr) {
        char[] values;
        synchronized (this.mutex) {
            values = this.f3642m.values(cArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TShortCharMap
    public TShortCharIterator iterator() {
        return this.f3642m.iterator();
    }

    @Override // gnu.trove.map.TShortCharMap
    public short getNoEntryKey() {
        return this.f3642m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortCharMap
    public char getNoEntryValue() {
        return this.f3642m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortCharMap
    public char putIfAbsent(short s, char c) {
        char putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3642m.putIfAbsent(s, c);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3642m.forEachKey(tShortProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3642m.forEachValue(tCharProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean forEachEntry(TShortCharProcedure tShortCharProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3642m.forEachEntry(tShortCharProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TShortCharMap
    public void transformValues(TCharFunction tCharFunction) {
        synchronized (this.mutex) {
            this.f3642m.transformValues(tCharFunction);
        }
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean retainEntries(TShortCharProcedure tShortCharProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3642m.retainEntries(tShortCharProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean increment(short s) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3642m.increment(s);
        }
        return increment;
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean adjustValue(short s, char c) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3642m.adjustValue(s, c);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TShortCharMap
    public char adjustOrPutValue(short s, char c, char c2) {
        char adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3642m.adjustOrPutValue(s, c, c2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3642m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3642m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3642m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}