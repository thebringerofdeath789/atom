package gnu.trove.impl.unmodifiable;

import gnu.trove.TByteCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TLongByteIterator;
import gnu.trove.map.TLongByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TLongByteProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableLongByteMap implements TLongByteMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TLongByteMap m;
    private transient TLongSet keySet = null;
    private transient TByteCollection values = null;

    public TUnmodifiableLongByteMap(TLongByteMap tLongByteMap) {
        Objects.requireNonNull(tLongByteMap);
        this.m = tLongByteMap;
    }

    @Override // gnu.trove.map.TLongByteMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean containsKey(long j) {
        return this.m.containsKey(j);
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean containsValue(byte b) {
        return this.m.containsValue(b);
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte get(long j) {
        return this.m.get(j);
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte put(long j, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte remove(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongByteMap
    public void putAll(TLongByteMap tLongByteMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongByteMap
    public void putAll(Map<? extends Long, ? extends Byte> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongByteMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongByteMap
    public TLongSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TLongByteMap
    public long[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TLongByteMap
    public long[] keys(long[] jArr) {
        return this.m.keys(jArr);
    }

    @Override // gnu.trove.map.TLongByteMap
    public TByteCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TLongByteMap
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

    @Override // gnu.trove.map.TLongByteMap
    public long getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        return this.m.forEachKey(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        return this.m.forEachValue(tByteProcedure);
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean forEachEntry(TLongByteProcedure tLongByteProcedure) {
        return this.m.forEachEntry(tLongByteProcedure);
    }

    @Override // gnu.trove.map.TLongByteMap
    public TLongByteIterator iterator() {
        return new TLongByteIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableLongByteMap.1
            TLongByteIterator iter;

            {
                this.iter = TUnmodifiableLongByteMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TLongByteIterator
            public long key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TLongByteIterator
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

            @Override // gnu.trove.iterator.TLongByteIterator
            public byte setValue(byte b) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte putIfAbsent(long j, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongByteMap
    public void transformValues(TByteFunction tByteFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean retainEntries(TLongByteProcedure tLongByteProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean increment(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongByteMap
    public boolean adjustValue(long j, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongByteMap
    public byte adjustOrPutValue(long j, byte b, byte b2) {
        throw new UnsupportedOperationException();
    }
}
