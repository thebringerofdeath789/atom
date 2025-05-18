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

    /* renamed from: m */
    private final TIntByteMap f3616m;
    final Object mutex;
    private transient TIntSet keySet = null;
    private transient TByteCollection values = null;

    public TSynchronizedIntByteMap(TIntByteMap tIntByteMap) {
        Objects.requireNonNull(tIntByteMap);
        this.f3616m = tIntByteMap;
        this.mutex = this;
    }

    public TSynchronizedIntByteMap(TIntByteMap tIntByteMap, Object obj) {
        this.f3616m = tIntByteMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TIntByteMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3616m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3616m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean containsKey(int i) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3616m.containsKey(i);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean containsValue(byte b) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3616m.containsValue(b);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte get(int i) {
        byte b;
        synchronized (this.mutex) {
            b = this.f3616m.get(i);
        }
        return b;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte put(int i, byte b) {
        byte put;
        synchronized (this.mutex) {
            put = this.f3616m.put(i, b);
        }
        return put;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte remove(int i) {
        byte remove;
        synchronized (this.mutex) {
            remove = this.f3616m.remove(i);
        }
        return remove;
    }

    @Override // gnu.trove.map.TIntByteMap
    public void putAll(Map<? extends Integer, ? extends Byte> map) {
        synchronized (this.mutex) {
            this.f3616m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TIntByteMap
    public void putAll(TIntByteMap tIntByteMap) {
        synchronized (this.mutex) {
            this.f3616m.putAll(tIntByteMap);
        }
    }

    @Override // gnu.trove.map.TIntByteMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3616m.clear();
        }
    }

    @Override // gnu.trove.map.TIntByteMap
    public TIntSet keySet() {
        TIntSet tIntSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedIntSet(this.f3616m.keySet(), this.mutex);
            }
            tIntSet = this.keySet;
        }
        return tIntSet;
    }

    @Override // gnu.trove.map.TIntByteMap
    public int[] keys() {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3616m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntByteMap
    public int[] keys(int[] iArr) {
        int[] keys;
        synchronized (this.mutex) {
            keys = this.f3616m.keys(iArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TIntByteMap
    public TByteCollection valueCollection() {
        TByteCollection tByteCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedByteCollection(this.f3616m.valueCollection(), this.mutex);
            }
            tByteCollection = this.values;
        }
        return tByteCollection;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte[] values() {
        byte[] values;
        synchronized (this.mutex) {
            values = this.f3616m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte[] values(byte[] bArr) {
        byte[] values;
        synchronized (this.mutex) {
            values = this.f3616m.values(bArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TIntByteMap
    public TIntByteIterator iterator() {
        return this.f3616m.iterator();
    }

    @Override // gnu.trove.map.TIntByteMap
    public int getNoEntryKey() {
        return this.f3616m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte getNoEntryValue() {
        return this.f3616m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte putIfAbsent(int i, byte b) {
        byte putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3616m.putIfAbsent(i, b);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3616m.forEachKey(tIntProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3616m.forEachValue(tByteProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean forEachEntry(TIntByteProcedure tIntByteProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3616m.forEachEntry(tIntByteProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TIntByteMap
    public void transformValues(TByteFunction tByteFunction) {
        synchronized (this.mutex) {
            this.f3616m.transformValues(tByteFunction);
        }
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean retainEntries(TIntByteProcedure tIntByteProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3616m.retainEntries(tIntByteProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean increment(int i) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3616m.increment(i);
        }
        return increment;
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean adjustValue(int i, byte b) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3616m.adjustValue(i, b);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte adjustOrPutValue(int i, byte b, byte b2) {
        byte adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3616m.adjustOrPutValue(i, b, b2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3616m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3616m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3616m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}