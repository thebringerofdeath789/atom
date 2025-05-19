package gnu.trove.impl.sync;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TFloatCharIterator;
import gnu.trove.map.TFloatCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TFloatCharProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TFloatSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedFloatCharMap implements TFloatCharMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TFloatCharMap m;
    final Object mutex;
    private transient TFloatSet keySet = null;
    private transient TCharCollection values = null;

    public TSynchronizedFloatCharMap(TFloatCharMap tFloatCharMap) {
        Objects.requireNonNull(tFloatCharMap);
        this.m = tFloatCharMap;
        this.mutex = this;
    }

    public TSynchronizedFloatCharMap(TFloatCharMap tFloatCharMap, Object obj) {
        this.m = tFloatCharMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean containsKey(float f) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(f);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean containsValue(char c) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(c);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char get(float f) {
        char c;
        synchronized (this.mutex) {
            c = this.m.get(f);
        }
        return c;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char put(float f, char c) {
        char put;
        synchronized (this.mutex) {
            put = this.m.put(f, c);
        }
        return put;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char remove(float f) {
        char remove;
        synchronized (this.mutex) {
            remove = this.m.remove(f);
        }
        return remove;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public void putAll(Map<? extends Float, ? extends Character> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TFloatCharMap
    public void putAll(TFloatCharMap tFloatCharMap) {
        synchronized (this.mutex) {
            this.m.putAll(tFloatCharMap);
        }
    }

    @Override // gnu.trove.map.TFloatCharMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TFloatCharMap
    public TFloatSet keySet() {
        TFloatSet tFloatSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedFloatSet(this.m.keySet(), this.mutex);
            }
            tFloatSet = this.keySet;
        }
        return tFloatSet;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public float[] keys() {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public float[] keys(float[] fArr) {
        float[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(fArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public TCharCollection valueCollection() {
        TCharCollection tCharCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedCharCollection(this.m.valueCollection(), this.mutex);
            }
            tCharCollection = this.values;
        }
        return tCharCollection;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char[] values() {
        char[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char[] values(char[] cArr) {
        char[] values;
        synchronized (this.mutex) {
            values = this.m.values(cArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public TFloatCharIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public float getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char putIfAbsent(float f, char c) {
        char putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(f, c);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tFloatProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tCharProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean forEachEntry(TFloatCharProcedure tFloatCharProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tFloatCharProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public void transformValues(TCharFunction tCharFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tCharFunction);
        }
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean retainEntries(TFloatCharProcedure tFloatCharProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tFloatCharProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean increment(float f) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(f);
        }
        return increment;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean adjustValue(float f, char c) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(f, c);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char adjustOrPutValue(float f, char c, char c2) {
        char adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(f, c, c2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}
