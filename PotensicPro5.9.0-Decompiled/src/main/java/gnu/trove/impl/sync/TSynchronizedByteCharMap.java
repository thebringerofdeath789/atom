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
    private final TByteCharMap m;
    final Object mutex;
    private transient TByteSet keySet = null;
    private transient TCharCollection values = null;

    public TSynchronizedByteCharMap(TByteCharMap tByteCharMap) {
        Objects.requireNonNull(tByteCharMap);
        this.m = tByteCharMap;
        this.mutex = this;
    }

    public TSynchronizedByteCharMap(TByteCharMap tByteCharMap, Object obj) {
        this.m = tByteCharMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TByteCharMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean containsKey(byte b) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(b);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean containsValue(char c) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(c);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char get(byte b) {
        char c;
        synchronized (this.mutex) {
            c = this.m.get(b);
        }
        return c;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char put(byte b, char c) {
        char put;
        synchronized (this.mutex) {
            put = this.m.put(b, c);
        }
        return put;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char remove(byte b) {
        char remove;
        synchronized (this.mutex) {
            remove = this.m.remove(b);
        }
        return remove;
    }

    @Override // gnu.trove.map.TByteCharMap
    public void putAll(Map<? extends Byte, ? extends Character> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public void putAll(TByteCharMap tByteCharMap) {
        synchronized (this.mutex) {
            this.m.putAll(tByteCharMap);
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TByteCharMap
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

    @Override // gnu.trove.map.TByteCharMap
    public byte[] keys() {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteCharMap
    public byte[] keys(byte[] bArr) {
        byte[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(bArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TByteCharMap
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

    @Override // gnu.trove.map.TByteCharMap
    public char[] values() {
        char[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char[] values(char[] cArr) {
        char[] values;
        synchronized (this.mutex) {
            values = this.m.values(cArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TByteCharMap
    public TByteCharIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TByteCharMap
    public byte getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteCharMap
    public char getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteCharMap
    public char putIfAbsent(byte b, char c) {
        char putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(b, c);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tByteProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tCharProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean forEachEntry(TByteCharProcedure tByteCharProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tByteCharProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TByteCharMap
    public void transformValues(TCharFunction tCharFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tCharFunction);
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean retainEntries(TByteCharProcedure tByteCharProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tByteCharProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean increment(byte b) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(b);
        }
        return increment;
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean adjustValue(byte b, char c) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(b, c);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char adjustOrPutValue(byte b, char c, char c2) {
        char adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(b, c, c2);
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
