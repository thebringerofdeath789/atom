package gnu.trove.impl.unmodifiable;

import gnu.trove.TByteCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TCharByteIterator;
import gnu.trove.map.TCharByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TCharByteProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.set.TCharSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableCharByteMap implements TCharByteMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TCharByteMap m;
    private transient TCharSet keySet = null;
    private transient TByteCollection values = null;

    public TUnmodifiableCharByteMap(TCharByteMap tCharByteMap) {
        Objects.requireNonNull(tCharByteMap);
        this.m = tCharByteMap;
    }

    @Override // gnu.trove.map.TCharByteMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean containsKey(char c) {
        return this.m.containsKey(c);
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean containsValue(byte b) {
        return this.m.containsValue(b);
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte get(char c) {
        return this.m.get(c);
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte put(char c, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte remove(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharByteMap
    public void putAll(TCharByteMap tCharByteMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharByteMap
    public void putAll(Map<? extends Character, ? extends Byte> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharByteMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharByteMap
    public TCharSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TCharByteMap
    public char[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TCharByteMap
    public char[] keys(char[] cArr) {
        return this.m.keys(cArr);
    }

    @Override // gnu.trove.map.TCharByteMap
    public TByteCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte[] values(byte[] bArr) {
        return this.m.values(bArr);
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

    @Override // gnu.trove.map.TCharByteMap
    public char getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        return this.m.forEachKey(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        return this.m.forEachValue(tByteProcedure);
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean forEachEntry(TCharByteProcedure tCharByteProcedure) {
        return this.m.forEachEntry(tCharByteProcedure);
    }

    @Override // gnu.trove.map.TCharByteMap
    public TCharByteIterator iterator() {
        return new TCharByteIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableCharByteMap.1
            TCharByteIterator iter;

            {
                this.iter = TUnmodifiableCharByteMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TCharByteIterator
            public char key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TCharByteIterator
            public byte value() {
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

            @Override // gnu.trove.iterator.TCharByteIterator
            public byte setValue(byte b) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte putIfAbsent(char c, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharByteMap
    public void transformValues(TByteFunction tByteFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean retainEntries(TCharByteProcedure tCharByteProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean increment(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean adjustValue(char c, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte adjustOrPutValue(char c, byte b, byte b2) {
        throw new UnsupportedOperationException();
    }
}
