package gnu.trove.impl.sync;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TIntByteIterator;
import gnu.trove.map.TIntByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TIntByteProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedIntByteMap implements TIntByteMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TIntByteMap m;
    final Object mutex;
    private transient TIntSet keySet = null;
    private transient TByteCollection values = null;

    public TSynchronizedIntByteMap(TIntByteMap tIntByteMap) {
        Objects.requireNonNull(tIntByteMap);
        this.m = tIntByteMap;
        this.mutex = this;
    }

    public TSynchronizedIntByteMap(TIntByteMap tIntByteMap, Object obj) {
        this.m = tIntByteMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TIntByteMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean containsKey(int i) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(i);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean containsValue(byte b) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(b);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte get(int i) {
        byte b;
        synchronized (this.mutex) {
            b = this.m.get(i);
        }
        return b;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte put(int i, byte b) {
        byte put;
        synchronized (this.mutex) {
            put = this.m.put(i, b);
        }
        return put;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte remove(int i) {
        byte remove;
        synchronized (this.mutex) {
            remove = this.m.remove(i);
        }
        return remove;
    }

    @Override // gnu.trove.map.TIntByteMap
    public void putAll(Map<? extends Integer, ? extends Byte> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TIntByteMap
    public void putAll(TIntByteMap tIntByteMap) {
        synchronized (this.mutex) {
            this.m.putAll(tIntByteMap);
        }
    }

    @Override // gnu.trove.map.TIntByteMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TIntByteMap
    public TIntSet keySet() {
        TIntSet tIntSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedIntSet(this.m.keySet(), this.mutex);
            }
            tIntSet = this.keySet;
        }
        return tIntSet;
    }

    @Override // gnu.trove.map.TIntByteMap
    public int[] keys() {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntByteMap
    public int[] keys(int[] iArr) {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(iArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntByteMap
    public TByteCollection valueCollection() {
        TByteCollection tByteCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedByteCollection(this.m.valueCollection(), this.mutex);
            }
            tByteCollection = this.values;
        }
        return tByteCollection;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte[] values() {
        byte[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte[] values(byte[] bArr) {
        byte[] values;
        synchronized (this.mutex) {
            values = this.m.values(bArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TIntByteMap
    public TIntByteIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TIntByteMap
    public int getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte putIfAbsent(int i, byte b) {
        byte putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(i, b);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tIntProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tByteProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean forEachEntry(TIntByteProcedure tIntByteProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tIntByteProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TIntByteMap
    public void transformValues(TByteFunction tByteFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tByteFunction);
        }
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean retainEntries(TIntByteProcedure tIntByteProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tIntByteProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean increment(int i) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(i);
        }
        return increment;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean adjustValue(int i, byte b) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(i, b);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte adjustOrPutValue(int i, byte b, byte b2) {
        byte adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(i, b, b2);
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
