package gnu.trove.impl.unmodifiable;

import gnu.trove.TCharCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TByteCharIterator;
import gnu.trove.map.TByteCharMap;
import gnu.trove.procedure.TByteCharProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.set.TByteSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableByteCharMap implements TByteCharMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TByteCharMap m;
    private transient TByteSet keySet = null;
    private transient TCharCollection values = null;

    public TUnmodifiableByteCharMap(TByteCharMap tByteCharMap) {
        Objects.requireNonNull(tByteCharMap);
        this.m = tByteCharMap;
    }

    @Override // gnu.trove.map.TByteCharMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean containsKey(byte b) {
        return this.m.containsKey(b);
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean containsValue(char c) {
        return this.m.containsValue(c);
    }

    @Override // gnu.trove.map.TByteCharMap
    public char get(byte b) {
        return this.m.get(b);
    }

    @Override // gnu.trove.map.TByteCharMap
    public char put(byte b, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteCharMap
    public char remove(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteCharMap
    public void putAll(TByteCharMap tByteCharMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteCharMap
    public void putAll(Map<? extends Byte, ? extends Character> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteCharMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteCharMap
    public TByteSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TByteCharMap
    public byte[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TByteCharMap
    public byte[] keys(byte[] bArr) {
        return this.m.keys(bArr);
    }

    @Override // gnu.trove.map.TByteCharMap
    public TCharCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TByteCharMap
    public char[] values(char[] cArr) {
        return this.m.values(cArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.m.equals(obj);
    }

    public int hashCode() {
        return this.m.hashCode();
    }

    public String toString() {
        return this.m.toString();
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
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return this.m.forEachKey(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        return this.m.forEachValue(tCharProcedure);
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean forEachEntry(TByteCharProcedure tByteCharProcedure) {
        return this.m.forEachEntry(tByteCharProcedure);
    }

    @Override // gnu.trove.map.TByteCharMap
    public TByteCharIterator iterator() {
        return new TByteCharIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableByteCharMap.1
            TByteCharIterator iter;

            {
                this.iter = TUnmodifiableByteCharMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TByteCharIterator
            public byte key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TByteCharIterator
            public char value() {
                return this.iter.value();
            }

            @Override // gnu.trove.iterator.TAdvancingIterator
            public void advance() {
                this.iter.advance();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // gnu.trove.iterator.TByteCharIterator
            public char setValue(char c) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TByteCharMap
    public char putIfAbsent(byte b, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteCharMap
    public void transformValues(TCharFunction tCharFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean retainEntries(TByteCharProcedure tByteCharProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean increment(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean adjustValue(byte b, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteCharMap
    public char adjustOrPutValue(byte b, char c, char c2) {
        throw new UnsupportedOperationException();
    }
}
