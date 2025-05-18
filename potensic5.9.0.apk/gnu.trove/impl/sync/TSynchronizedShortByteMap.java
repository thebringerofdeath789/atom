package gnu.trove.impl.sync;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TShortByteIterator;
import gnu.trove.map.TShortByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TShortByteProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedShortByteMap implements TShortByteMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TShortByteMap f3641m;
    final Object mutex;
    private transient TShortSet keySet = null;
    private transient TByteCollection values = null;

    public TSynchronizedShortByteMap(TShortByteMap tShortByteMap) {
        Objects.requireNonNull(tShortByteMap);
        this.f3641m = tShortByteMap;
        this.mutex = this;
    }

    public TSynchronizedShortByteMap(TShortByteMap tShortByteMap, Object obj) {
        this.f3641m = tShortByteMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TShortByteMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3641m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3641m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean containsKey(short s) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3641m.containsKey(s);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean containsValue(byte b) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3641m.containsValue(b);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte get(short s) {
        byte b;
        synchronized (this.mutex) {
            b = this.f3641m.get(s);
        }
        return b;
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte put(short s, byte b) {
        byte put;
        synchronized (this.mutex) {
            put = this.f3641m.put(s, b);
        }
        return put;
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte remove(short s) {
        byte remove;
        synchronized (this.mutex) {
            remove = this.f3641m.remove(s);
        }
        return remove;
    }

    @Override // gnu.trove.map.TShortByteMap
    public void putAll(Map<? extends Short, ? extends Byte> map) {
        synchronized (this.mutex) {
            this.f3641m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TShortByteMap
    public void putAll(TShortByteMap tShortByteMap) {
        synchronized (this.mutex) {
            this.f3641m.putAll(tShortByteMap);
        }
    }

    @Override // gnu.trove.map.TShortByteMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3641m.clear();
        }
    }

    @Override // gnu.trove.map.TShortByteMap
    public TShortSet keySet() {
        TShortSet tShortSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedShortSet(this.f3641m.keySet(), this.mutex);
            }
            tShortSet = this.keySet;
        }
        return tShortSet;
    }

    @Override // gnu.trove.map.TShortByteMap
    public short[] keys() {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3641m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortByteMap
    public short[] keys(short[] sArr) {
        short[] keys;
        synchronized (this.mutex) {
            keys = this.f3641m.keys(sArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TShortByteMap
    public TByteCollection valueCollection() {
        TByteCollection tByteCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedByteCollection(this.f3641m.valueCollection(), this.mutex);
            }
            tByteCollection = this.values;
        }
        return tByteCollection;
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte[] values() {
        byte[] values;
        synchronized (this.mutex) {
            values = this.f3641m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte[] values(byte[] bArr) {
        byte[] values;
        synchronized (this.mutex) {
            values = this.f3641m.values(bArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TShortByteMap
    public TShortByteIterator iterator() {
        return this.f3641m.iterator();
    }

    @Override // gnu.trove.map.TShortByteMap
    public short getNoEntryKey() {
        return this.f3641m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte getNoEntryValue() {
        return this.f3641m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte putIfAbsent(short s, byte b) {
        byte putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3641m.putIfAbsent(s, b);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3641m.forEachKey(tShortProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3641m.forEachValue(tByteProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean forEachEntry(TShortByteProcedure tShortByteProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3641m.forEachEntry(tShortByteProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TShortByteMap
    public void transformValues(TByteFunction tByteFunction) {
        synchronized (this.mutex) {
            this.f3641m.transformValues(tByteFunction);
        }
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean retainEntries(TShortByteProcedure tShortByteProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3641m.retainEntries(tShortByteProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean increment(short s) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3641m.increment(s);
        }
        return increment;
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean adjustValue(short s, byte b) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3641m.adjustValue(s, b);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte adjustOrPutValue(short s, byte b, byte b2) {
        byte adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3641m.adjustOrPutValue(s, b, b2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3641m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3641m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3641m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}