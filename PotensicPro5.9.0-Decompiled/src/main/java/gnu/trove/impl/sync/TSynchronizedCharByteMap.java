package gnu.trove.impl.sync;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TCharByteIterator;
import gnu.trove.map.TCharByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TCharByteProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.set.TCharSet;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TSynchronizedCharByteMap implements TCharByteMap, Serializable {
    private static final long serialVersionUID = 1978198479659022715L;
    private final TCharByteMap m;
    final Object mutex;
    private transient TCharSet keySet = null;
    private transient TByteCollection values = null;

    public TSynchronizedCharByteMap(TCharByteMap tCharByteMap) {
        Objects.requireNonNull(tCharByteMap);
        this.m = tCharByteMap;
        this.mutex = this;
    }

    public TSynchronizedCharByteMap(TCharByteMap tCharByteMap, Object obj) {
        this.m = tCharByteMap;
        this.mutex = obj;
    }

    @Override // gnu.trove.map.TCharByteMap
    public int size() {
        int size;
        synchronized (this.mutex) {
            size = this.m.size();
        }
        return size;
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = this.m.isEmpty();
        }
        return isEmpty;
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean containsKey(char c) {
        boolean containsKey;
        synchronized (this.mutex) {
            containsKey = this.m.containsKey(c);
        }
        return containsKey;
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean containsValue(byte b) {
        boolean containsValue;
        synchronized (this.mutex) {
            containsValue = this.m.containsValue(b);
        }
        return containsValue;
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte get(char c) {
        byte b;
        synchronized (this.mutex) {
            b = this.m.get(c);
        }
        return b;
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte put(char c, byte b) {
        byte put;
        synchronized (this.mutex) {
            put = this.m.put(c, b);
        }
        return put;
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte remove(char c) {
        byte remove;
        synchronized (this.mutex) {
            remove = this.m.remove(c);
        }
        return remove;
    }

    @Override // gnu.trove.map.TCharByteMap
    public void putAll(Map<? extends Character, ? extends Byte> map) {
        synchronized (this.mutex) {
            this.m.putAll(map);
        }
    }

    @Override // gnu.trove.map.TCharByteMap
    public void putAll(TCharByteMap tCharByteMap) {
        synchronized (this.mutex) {
            this.m.putAll(tCharByteMap);
        }
    }

    @Override // gnu.trove.map.TCharByteMap
    public void clear() {
        synchronized (this.mutex) {
            this.m.clear();
        }
    }

    @Override // gnu.trove.map.TCharByteMap
    public TCharSet keySet() {
        TCharSet tCharSet;
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = new TSynchronizedCharSet(this.m.keySet(), this.mutex);
            }
            tCharSet = this.keySet;
        }
        return tCharSet;
    }

    @Override // gnu.trove.map.TCharByteMap
    public char[] keys() {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys();
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharByteMap
    public char[] keys(char[] cArr) {
        char[] keys;
        synchronized (this.mutex) {
            keys = this.m.keys(cArr);
        }
        return keys;
    }

    @Override // gnu.trove.map.TCharByteMap
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

    @Override // gnu.trove.map.TCharByteMap
    public byte[] values() {
        byte[] values;
        synchronized (this.mutex) {
            values = this.m.values();
        }
        return values;
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte[] values(byte[] bArr) {
        byte[] values;
        synchronized (this.mutex) {
            values = this.m.values(bArr);
        }
        return values;
    }

    @Override // gnu.trove.map.TCharByteMap
    public TCharByteIterator iterator() {
        return this.m.iterator();
    }

    @Override // gnu.trove.map.TCharByteMap
    public char getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte putIfAbsent(char c, byte b) {
        byte putIfAbsent;
        synchronized (this.mutex) {
            putIfAbsent = this.m.putIfAbsent(c, b);
        }
        return putIfAbsent;
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        boolean forEachKey;
        synchronized (this.mutex) {
            forEachKey = this.m.forEachKey(tCharProcedure);
        }
        return forEachKey;
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        boolean forEachValue;
        synchronized (this.mutex) {
            forEachValue = this.m.forEachValue(tByteProcedure);
        }
        return forEachValue;
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean forEachEntry(TCharByteProcedure tCharByteProcedure) {
        boolean forEachEntry;
        synchronized (this.mutex) {
            forEachEntry = this.m.forEachEntry(tCharByteProcedure);
        }
        return forEachEntry;
    }

    @Override // gnu.trove.map.TCharByteMap
    public void transformValues(TByteFunction tByteFunction) {
        synchronized (this.mutex) {
            this.m.transformValues(tByteFunction);
        }
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean retainEntries(TCharByteProcedure tCharByteProcedure) {
        boolean retainEntries;
        synchronized (this.mutex) {
            retainEntries = this.m.retainEntries(tCharByteProcedure);
        }
        return retainEntries;
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean increment(char c) {
        boolean increment;
        synchronized (this.mutex) {
            increment = this.m.increment(c);
        }
        return increment;
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean adjustValue(char c, byte b) {
        boolean adjustValue;
        synchronized (this.mutex) {
            adjustValue = this.m.adjustValue(c, b);
        }
        return adjustValue;
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte adjustOrPutValue(char c, byte b, byte b2) {
        byte adjustOrPutValue;
        synchronized (this.mutex) {
            adjustOrPutValue = this.m.adjustOrPutValue(c, b, b2);
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
