package gnu.trove.impl.sync;

import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TByteCharIterator;
import gnu.trove.map.TByteCharMap;
import gnu.trove.procedure.TByteCharProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.set.TByteSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedByteCharMap implements TByteCharMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: m */
    private final TByteCharMap f3581m;
    final Object mutex;
    private transient TByteSet keySet = null;
    private transient TCharCollection values = null;

    public TSynchronizedByteCharMap(TByteCharMap tByteCharMap) {
        Objects.requireNonNull(tByteCharMap);
        this.f3581m = tByteCharMap;
        this.mutex = this;
    }

    public TSynchronizedByteCharMap(TByteCharMap tByteCharMap, Object obj) {
        this.f3581m = tByteCharMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TByteCharMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.f3581m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.f3581m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean containsKey(byte b) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.f3581m.containsKey(b);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean containsValue(char c) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.f3581m.containsValue(c);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char get(byte b) {
        char c;
        synchronized (this.mutex) {
            c = this.f3581m.get(b);
        }
        return c;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char put(byte b, char c) {
        char put;
        synchronized (this.mutex) {
            put = this.f3581m.put(b, c);
        }
        return put;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char remove(byte b) {
        char remove;
        synchronized (this.mutex) {
            remove = this.f3581m.remove(b);
        }
        return remove;
    }

    @Override // gnu.trove.map.TByteCharMap
    public void putAll(Map<? extends Byte, ? extends Character> map) {
        synchronized (this.mutex) {
            this.f3581m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public void putAll(TByteCharMap tByteCharMap) {
        synchronized (this.mutex) {
            this.f3581m.putAll(tByteCharMap);
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public void clear() {
        synchronized (this.mutex) {
            this.f3581m.clear();
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public TByteSet keySet() {
        TByteSet tByteSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedByteSet(this.f3581m.keySet(), this.mutex);
            }
            tByteSet = this.keySet;
        }
        return tByteSet;
    }

    @Override // gnu.trove.map.TByteCharMap
    public byte[] keys() {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3581m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteCharMap
    public byte[] keys(byte[] bArr) {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.f3581m.keys(bArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteCharMap
    public TCharCollection valueCollection() {
        TCharCollection tCharCollection;
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = new TSynchronizedCharCollection(this.f3581m.valueCollection(), this.mutex);
            }
            tCharCollection = this.values;
        }
        return tCharCollection;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char[] values() {
        char[] values;
        synchronized (this.mutex) {
            values = this.f3581m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char[] values(char[] cArr) {
        char[] values;
        synchronized (this.mutex) {
            values = this.f3581m.values(cArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TByteCharMap
    public TByteCharIterator iterator() {
        return this.f3581m.iterator();
    }

    @Override // gnu.trove.map.TByteCharMap
    public byte getNoEntryKey() {
        return this.f3581m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteCharMap
    public char getNoEntryValue() {
        return this.f3581m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteCharMap
    public char putIfAbsent(byte b, char c) {
        char putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.f3581m.putIfAbsent(b, c);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.f3581m.forEachKey(tByteProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.f3581m.forEachValue(tCharProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean forEachEntry(TByteCharProcedure tByteCharProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.f3581m.forEachEntry(tByteCharProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TByteCharMap
    public void transformValues(TCharFunction tCharFunction) {
        synchronized (this.mutex) {
            this.f3581m.transformValues(tCharFunction);
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean retainEntries(TByteCharProcedure tByteCharProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.f3581m.retainEntries(tByteCharProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean increment(byte b) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.f3581m.increment(b);
        }
        return increment;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean adjustValue(byte b, char c) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.f3581m.adjustValue(b, c);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char adjustOrPutValue(byte b, char c, char c2) {
        char adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.f3581m.adjustOrPutValue(b, c, c2);
        }
        return adjustOrPutValue;
    }

    public boolean equals(Object obj) {
        boolean equals;
        synchronized (this.mutex) {
            equals = this.f3581m.equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = this.f3581m.hashCode();
        }
        return hashCode;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.f3581m.toString();
        }
        return obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }
}