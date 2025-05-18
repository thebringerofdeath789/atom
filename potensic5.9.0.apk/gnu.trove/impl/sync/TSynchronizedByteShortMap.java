package gnu.trove.impl.sync;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TByteShortIterator;
import gnu.trove.map.TByteShortMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TByteShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TByteSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedByteShortMap implements TByteShortMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TByteShortMap f3588m;
    final Object mutex;
    private transient TByteSet keySet = null;
    private transient TShortCollection values = null;

    public TSynchronizedByteShortMap(TByteShortMap tByteShortMap) {
        Objects.requireNonNull(tByteShortMap);
        this.f3588m = tByteShortMap;
        this.mutex = this;
    }

    public TSynchronizedByteShortMap(TByteShortMap tByteShortMap, Object obj) {
        this.f3588m = tByteShortMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TByteShortMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3588m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3588m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean containsKey(byte b) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3588m.containsKey(b);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean containsValue(short s) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3588m.containsValue(s);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TByteShortMap
    public short get(byte b) {
        short s;
        synchronized (this.mutex) {
            s = this.f3588m.get(b);
        }
        return s;
    }

    @Override // gnu.trove.map.TByteShortMap
    public short put(byte b, short s) {
        short put;
        synchronized (this.mutex) {
            put = this.f3588m.put(b, s);
        }
        return put;
    }

    @Override // gnu.trove.map.TByteShortMap
    public short remove(byte b) {
        short remove;
        synchronized (this.mutex) {
            remove = this.f3588m.remove(b);
        }
        return remove;
    }

    @Override // gnu.trove.map.TByteShortMap
    public void putAll(Map<? extends Byte, ? extends Short> map) {
        synchronized (this.mutex) {
            this.f3588m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TByteShortMap
    public void putAll(TByteShortMap tByteShortMap) {
        synchronized (this.mutex) {
            this.f3588m.putAll(tByteShortMap);
        }
    }

    @Override // gnu.trove.map.TByteShortMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3588m.clear();
        }
    }

    @Override // gnu.trove.map.TByteShortMap
    public TByteSet keySet() {
        TByteSet tByteSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedByteSet(this.f3588m.keySet(), this.mutex);
            }
            tByteSet = this.keySet;
        }
        return tByteSet;
    }

    @Override // gnu.trove.map.TByteShortMap
    public byte[] keys() {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3588m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteShortMap
    public byte[] keys(byte[] bArr) {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3588m.keys(bArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteShortMap
    public TShortCollection valueCollection() {
        TShortCollection tShortCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedShortCollection(this.f3588m.valueCollection(), this.mutex);
            }
            tShortCollection = this.values;
        }
        return tShortCollection;
    }

    @Override // gnu.trove.map.TByteShortMap
    public short[] values() {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3588m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TByteShortMap
    public short[] values(short[] sArr) {
        short[] values;
        synchronized (this.mutex) {
            values = this.f3588m.values(sArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TByteShortMap
    public TByteShortIterator iterator() {
        return this.f3588m.iterator();
    }

    @Override // gnu.trove.map.TByteShortMap
    public byte getNoEntryKey() {
        return this.f3588m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteShortMap
    public short getNoEntryValue() {
        return this.f3588m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteShortMap
    public short putIfAbsent(byte b, short s) {
        short putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3588m.putIfAbsent(b, s);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3588m.forEachKey(tByteProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3588m.forEachValue(tShortProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean forEachEntry(TByteShortProcedure tByteShortProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3588m.forEachEntry(tByteShortProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TByteShortMap
    public void transformValues(TShortFunction tShortFunction) {
        synchronized (this.mutex) {
            this.f3588m.transformValues(tShortFunction);
        }
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean retainEntries(TByteShortProcedure tByteShortProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3588m.retainEntries(tByteShortProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean increment(byte b) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3588m.increment(b);
        }
        return increment;
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean adjustValue(byte b, short s) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3588m.adjustValue(b, s);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TByteShortMap
    public short adjustOrPutValue(byte b, short s, short s2) {
        short adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3588m.adjustOrPutValue(b, s, s2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3588m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3588m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3588m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}