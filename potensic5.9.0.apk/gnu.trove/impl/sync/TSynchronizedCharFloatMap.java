package gnu.trove.impl.sync;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TCharFloatIterator;
import gnu.trove.map.TCharFloatMap;
import gnu.trove.procedure.TCharFloatProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TCharSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedCharFloatMap implements TCharFloatMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TCharFloatMap f3593m;
    final Object mutex;
    private transient TCharSet keySet = null;
    private transient TFloatCollection values = null;

    public TSynchronizedCharFloatMap(TCharFloatMap tCharFloatMap) {
        Objects.requireNonNull(tCharFloatMap);
        this.f3593m = tCharFloatMap;
        this.mutex = this;
    }

    public TSynchronizedCharFloatMap(TCharFloatMap tCharFloatMap, Object obj) {
        this.f3593m = tCharFloatMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3593m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3593m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean containsKey(char c) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3593m.containsKey(c);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean containsValue(float f) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3593m.containsValue(f);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float get(char c) {
        float f;
        synchronized (this.mutex) {
            f = this.f3593m.get(c);
        }
        return f;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float put(char c, float f) {
        float put;
        synchronized (this.mutex) {
            put = this.f3593m.put(c, f);
        }
        return put;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float remove(char c) {
        float remove;
        synchronized (this.mutex) {
            remove = this.f3593m.remove(c);
        }
        return remove;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public void putAll(Map<? extends Character, ? extends Float> map) {
        synchronized (this.mutex) {
            this.f3593m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TCharFloatMap
    public void putAll(TCharFloatMap tCharFloatMap) {
        synchronized (this.mutex) {
            this.f3593m.putAll(tCharFloatMap);
        }
    }

    @Override // gnu.trove.map.TCharFloatMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3593m.clear();
        }
    }

    @Override // gnu.trove.map.TCharFloatMap
    public TCharSet keySet() {
        TCharSet tCharSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedCharSet(this.f3593m.keySet(), this.mutex);
            }
            tCharSet = this.keySet;
        }
        return tCharSet;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public char[] keys() {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.f3593m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public char[] keys(char[] cArr) {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.f3593m.keys(cArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public TFloatCollection valueCollection() {
        TFloatCollection tFloatCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedFloatCollection(this.f3593m.valueCollection(), this.mutex);
            }
            tFloatCollection = this.values;
        }
        return tFloatCollection;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float[] values() {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3593m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float[] values(float[] fArr) {
        float[] values;
        synchronized (this.mutex) {
            values = this.f3593m.values(fArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public TCharFloatIterator iterator() {
        return this.f3593m.iterator();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public char getNoEntryKey() {
        return this.f3593m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float getNoEntryValue() {
        return this.f3593m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float putIfAbsent(char c, float f) {
        float putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3593m.putIfAbsent(c, f);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3593m.forEachKey(tCharProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3593m.forEachValue(tFloatProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean forEachEntry(TCharFloatProcedure tCharFloatProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3593m.forEachEntry(tCharFloatProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        synchronized (this.mutex) {
            this.f3593m.transformValues(tFloatFunction);
        }
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean retainEntries(TCharFloatProcedure tCharFloatProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3593m.retainEntries(tCharFloatProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean increment(char c) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3593m.increment(c);
        }
        return increment;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean adjustValue(char c, float f) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3593m.adjustValue(c, f);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float adjustOrPutValue(char c, float f, float f2) {
        float adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3593m.adjustOrPutValue(c, f, f2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3593m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3593m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3593m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}