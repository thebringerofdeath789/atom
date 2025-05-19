package gnu.trove.impl.sync;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TByteByteIterator;
import gnu.trove.map.TByteByteMap;
import gnu.trove.procedure.TByteByteProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.set.TByteSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedByteByteMap implements TByteByteMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TByteByteMap m;
    final Object mutex;
    private transient TByteSet keySet = null;
    private transient TByteCollection values = null;

    public TSynchronizedByteByteMap(TByteByteMap tByteByteMap) {
        Objects.requireNonNull(tByteByteMap);
        this.m = tByteByteMap;
        this.mutex = this;
    }

    public TSynchronizedByteByteMap(TByteByteMap tByteByteMap, Object obj) {
        this.m = tByteByteMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TByteByteMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean containsKey(byte b) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(b);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean containsValue(byte b) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(b);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte get(byte b) {
        byte b2;
        synchronized (this.mutex) {
            b2 = this.m.get(b);
        }
        return b2;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte put(byte b, byte b2) {
        byte put;
        synchronized (this.mutex) {
            put = this.m.put(b, b2);
        }
        return put;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte remove(byte b) {
        byte remove;
        synchronized (this.mutex) {
            remove = this.m.remove(b);
        }
        return remove;
    }

    @Override // gnu.trove.map.TByteByteMap
    public void putAll(Map<? extends Byte, ? extends Byte> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public void putAll(TByteByteMap tByteByteMap) {
        synchronized (this.mutex) {
            this.m.putAll(tByteByteMap);
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public TByteSet keySet() {
        TByteSet tByteSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedByteSet(this.m.keySet(), this.mutex);
            }
            tByteSet = this.keySet;
        }
        return tByteSet;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] keys() {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] keys(byte[] bArr) {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(bArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteByteMap
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

    @Override // gnu.trove.map.TByteByteMap
    public byte[] values() {
        byte[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] values(byte[] bArr) {
        byte[] values;
        synchronized (this.mutex) {
            values = this.m.values(bArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TByteByteMap
    public TByteByteIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte putIfAbsent(byte b, byte b2) {
        byte putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(b, b2);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tByteProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tByteProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean forEachEntry(TByteByteProcedure tByteByteProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tByteByteProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TByteByteMap
    public void transformValues(TByteFunction tByteFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tByteFunction);
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean retainEntries(TByteByteProcedure tByteByteProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tByteByteProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean increment(byte b) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(b);
        }
        return increment;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean adjustValue(byte b, byte b2) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(b, b2);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte adjustOrPutValue(byte b, byte b2, byte b3) {
        byte adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(b, b2, b3);
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
