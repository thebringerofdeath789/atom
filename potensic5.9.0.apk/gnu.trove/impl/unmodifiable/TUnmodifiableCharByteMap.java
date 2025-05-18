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

    /* renamed from: m */
    private final TCharByteMap f3660m;
    private transient TCharSet keySet = null;
    private transient TByteCollection values = null;

    public TUnmodifiableCharByteMap(TCharByteMap tCharByteMap) {
        Objects.requireNonNull(tCharByteMap);
        this.f3660m = tCharByteMap;
    }

    @Override // gnu.trove.map.TCharByteMap
    public int size() {
        return this.f3660m.size();
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean isEmpty() {
        return this.f3660m.isEmpty();
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean containsKey(char c) {
        return this.f3660m.containsKey(c);
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean containsValue(byte b) {
        return this.f3660m.containsValue(b);
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte get(char c) {
        return this.f3660m.get(c);
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
            this.keySet = TCollections.unmodifiableSet(this.f3660m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TCharByteMap
    public char[] keys() {
        return this.f3660m.keys();
    }

    @Override // gnu.trove.map.TCharByteMap
    public char[] keys(char[] cArr) {
        return this.f3660m.keys(cArr);
    }

    @Override // gnu.trove.map.TCharByteMap
    public TByteCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3660m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte[] values() {
        return this.f3660m.values();
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte[] values(byte[] bArr) {
        return this.f3660m.values(bArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3660m.equals(obj);
    }

    public int hashCode() {
        return this.f3660m.hashCode();
    }

    public String toString() {
        return this.f3660m.toString();
    }

    @Override // gnu.trove.map.TCharByteMap
    public char getNoEntryKey() {
        return this.f3660m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte getNoEntryValue() {
        return this.f3660m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        return this.f3660m.forEachKey(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        return this.f3660m.forEachValue(tByteProcedure);
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean forEachEntry(TCharByteProcedure tCharByteProcedure) {
        return this.f3660m.forEachEntry(tCharByteProcedure);
    }

    @Override // gnu.trove.map.TCharByteMap
    public TCharByteIterator iterator() {
        return new TCharByteIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableCharByteMap.1
            TCharByteIterator iter;

            {
                this.iter = TUnmodifiableCharByteMap.this.f3660m.iterator();
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