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

    /* renamed from: m */
    private final TByteByteMap f3580m;
    final Object mutex;
    private transient TByteSet keySet = null;
    private transient TByteCollection values = null;

    public TSynchronizedByteByteMap(TByteByteMap tByteByteMap) {
        Objects.requireNonNull(tByteByteMap);
        this.f3580m = tByteByteMap;
        this.mutex = this;
    }

    public TSynchronizedByteByteMap(TByteByteMap tByteByteMap, Object obj) {
        this.f3580m = tByteByteMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TByteByteMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3580m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3580m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean containsKey(byte b) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3580m.containsKey(b);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean containsValue(byte b) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3580m.containsValue(b);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte get(byte b) {
        byte b2;
        synchronized (this.mutex) {
            b2 = this.f3580m.get(b);
        }
        return b2;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte put(byte b, byte b2) {
        byte put;
        synchronized (this.mutex) {
            put = this.f3580m.put(b, b2);
        }
        return put;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte remove(byte b) {
        byte remove;
        synchronized (this.mutex) {
            remove = this.f3580m.remove(b);
        }
        return remove;
    }

    @Override // gnu.trove.map.TByteByteMap
    public void putAll(Map<? extends Byte, ? extends Byte> map) {
        synchronized (this.mutex) {
            this.f3580m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public void putAll(TByteByteMap tByteByteMap) {
        synchronized (this.mutex) {
            this.f3580m.putAll(tByteByteMap);
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3580m.clear();
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public TByteSet keySet() {
        TByteSet tByteSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedByteSet(this.f3580m.keySet(), this.mutex);
            }
            tByteSet = this.keySet;
        }
        return tByteSet;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] keys() {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3580m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] keys(byte[] bArr) {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3580m.keys(bArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteByteMap
    public TByteCollection valueCollection() {
        TByteCollection tByteCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedByteCollection(this.f3580m.valueCollection(), this.mutex);
            }
            tByteCollection = this.values;
        }
        return tByteCollection;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] values() {
        byte[] values;
        synchronized (this.mutex) {
            values = this.f3580m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] values(byte[] bArr) {
        byte[] values;
        synchronized (this.mutex) {
            values = this.f3580m.values(bArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TByteByteMap
    public TByteByteIterator iterator() {
        return this.f3580m.iterator();
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte getNoEntryKey() {
        return this.f3580m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte getNoEntryValue() {
        return this.f3580m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte putIfAbsent(byte b, byte b2) {
        byte putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3580m.putIfAbsent(b, b2);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3580m.forEachKey(tByteProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3580m.forEachValue(tByteProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean forEachEntry(TByteByteProcedure tByteByteProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3580m.forEachEntry(tByteByteProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TByteByteMap
    public void transformValues(TByteFunction tByteFunction) {
        synchronized (this.mutex) {
            this.f3580m.transformValues(tByteFunction);
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean retainEntries(TByteByteProcedure tByteByteProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3580m.retainEntries(tByteByteProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean increment(byte b) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3580m.increment(b);
        }
        return increment;
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean adjustValue(byte b, byte b2) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3580m.adjustValue(b, b2);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte adjustOrPutValue(byte b, byte b2, byte b3) {
        byte adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3580m.adjustOrPutValue(b, b2, b3);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3580m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3580m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3580m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}