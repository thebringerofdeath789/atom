package gnu.trove.impl.unmodifiable;

import gnu.trove.TByteCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TByteByteIterator;
import gnu.trove.map.TByteByteMap;
import gnu.trove.procedure.TByteByteProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.set.TByteSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableByteByteMap implements TByteByteMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TByteByteMap m;
    private transient TByteSet keySet = null;
    private transient TByteCollection values = null;

    public TUnmodifiableByteByteMap(TByteByteMap tByteByteMap) {
        Objects.requireNonNull(tByteByteMap);
        this.m = tByteByteMap;
    }

    @Override // gnu.trove.map.TByteByteMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean containsKey(byte b) {
        return this.m.containsKey(b);
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean containsValue(byte b) {
        return this.m.containsValue(b);
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte get(byte b) {
        return this.m.get(b);
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte put(byte b, byte b2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte remove(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteByteMap
    public void putAll(TByteByteMap tByteByteMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteByteMap
    public void putAll(Map<? extends Byte, ? extends Byte> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteByteMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteByteMap
    public TByteSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] keys(byte[] bArr) {
        return this.m.keys(bArr);
    }

    @Override // gnu.trove.map.TByteByteMap
    public TByteCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TByteByteMap
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

    @Override // gnu.trove.map.TByteByteMap
    public byte getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return this.m.forEachKey(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        return this.m.forEachValue(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean forEachEntry(TByteByteProcedure tByteByteProcedure) {
        return this.m.forEachEntry(tByteByteProcedure);
    }

    @Override // gnu.trove.map.TByteByteMap
    public TByteByteIterator iterator() {
        return new TByteByteIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableByteByteMap.1
            TByteByteIterator iter;

            {
                this.iter = TUnmodifiableByteByteMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TByteByteIterator
            public byte key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TByteByteIterator
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

            @Override // gnu.trove.iterator.TByteByteIterator
            public byte setValue(byte b) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte putIfAbsent(byte b, byte b2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteByteMap
    public void transformValues(TByteFunction tByteFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean retainEntries(TByteByteProcedure tByteByteProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean increment(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean adjustValue(byte b, byte b2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte adjustOrPutValue(byte b, byte b2, byte b3) {
        throw new UnsupportedOperationException();
    }
}
