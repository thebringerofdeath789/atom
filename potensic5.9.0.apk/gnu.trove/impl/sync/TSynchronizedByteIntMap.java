package gnu.trove.impl.sync;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TByteIntIterator;
import gnu.trove.map.TByteIntMap;
import gnu.trove.procedure.TByteIntProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TByteSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedByteIntMap implements TByteIntMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TByteIntMap f3585m;
    final Object mutex;
    private transient TByteSet keySet = null;
    private transient TIntCollection values = null;

    public TSynchronizedByteIntMap(TByteIntMap tByteIntMap) {
        Objects.requireNonNull(tByteIntMap);
        this.f3585m = tByteIntMap;
        this.mutex = this;
    }

    public TSynchronizedByteIntMap(TByteIntMap tByteIntMap, Object obj) {
        this.f3585m = tByteIntMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TByteIntMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3585m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3585m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean containsKey(byte b) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3585m.containsKey(b);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean containsValue(int i) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3585m.containsValue(i);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TByteIntMap
    public int get(byte b) {
        int i;
        synchronized (this.mutex) {
            i = this.f3585m.get(b);
        }
        return i;
    }

    @Override // gnu.trove.map.TByteIntMap
    public int put(byte b, int i) {
        int put;
        synchronized (this.mutex) {
            put = this.f3585m.put(b, i);
        }
        return put;
    }

    @Override // gnu.trove.map.TByteIntMap
    public int remove(byte b) {
        int remove;
        synchronized (this.mutex) {
            remove = this.f3585m.remove(b);
        }
        return remove;
    }

    @Override // gnu.trove.map.TByteIntMap
    public void putAll(Map<? extends Byte, ? extends Integer> map) {
        synchronized (this.mutex) {
            this.f3585m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public void putAll(TByteIntMap tByteIntMap) {
        synchronized (this.mutex) {
            this.f3585m.putAll(tByteIntMap);
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3585m.clear();
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public TByteSet keySet() {
        TByteSet tByteSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedByteSet(this.f3585m.keySet(), this.mutex);
            }
            tByteSet = this.keySet;
        }
        return tByteSet;
    }

    @Override // gnu.trove.map.TByteIntMap
    public byte[] keys() {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3585m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteIntMap
    public byte[] keys(byte[] bArr) {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3585m.keys(bArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteIntMap
    public TIntCollection valueCollection() {
        TIntCollection tIntCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedIntCollection(this.f3585m.valueCollection(), this.mutex);
            }
            tIntCollection = this.values;
        }
        return tIntCollection;
    }

    @Override // gnu.trove.map.TByteIntMap
    public int[] values() {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3585m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TByteIntMap
    public int[] values(int[] iArr) {
        int[] values;
        synchronized (this.mutex) {
            values = this.f3585m.values(iArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TByteIntMap
    public TByteIntIterator iterator() {
        return this.f3585m.iterator();
    }

    @Override // gnu.trove.map.TByteIntMap
    public byte getNoEntryKey() {
        return this.f3585m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteIntMap
    public int getNoEntryValue() {
        return this.f3585m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteIntMap
    public int putIfAbsent(byte b, int i) {
        int putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3585m.putIfAbsent(b, i);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3585m.forEachKey(tByteProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3585m.forEachValue(tIntProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean forEachEntry(TByteIntProcedure tByteIntProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3585m.forEachEntry(tByteIntProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TByteIntMap
    public void transformValues(TIntFunction tIntFunction) {
        synchronized (this.mutex) {
            this.f3585m.transformValues(tIntFunction);
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean retainEntries(TByteIntProcedure tByteIntProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3585m.retainEntries(tByteIntProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean increment(byte b) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3585m.increment(b);
        }
        return increment;
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean adjustValue(byte b, int i) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3585m.adjustValue(b, i);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TByteIntMap
    public int adjustOrPutValue(byte b, int i, int i2) {
        int adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3585m.adjustOrPutValue(b, i, i2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3585m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3585m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3585m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}