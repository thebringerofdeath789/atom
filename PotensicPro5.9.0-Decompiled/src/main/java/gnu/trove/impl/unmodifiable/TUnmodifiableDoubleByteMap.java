package gnu.trove.impl.unmodifiable;

import gnu.trove.TByteCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TDoubleByteIterator;
import gnu.trove.map.TDoubleByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TDoubleByteProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableDoubleByteMap implements TDoubleByteMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TDoubleByteMap m;
    private transient TDoubleSet keySet = null;
    private transient TByteCollection values = null;

    public TUnmodifiableDoubleByteMap(TDoubleByteMap tDoubleByteMap) {
        Objects.requireNonNull(tDoubleByteMap);
        this.m = tDoubleByteMap;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean containsKey(double d) {
        return this.m.containsKey(d);
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean containsValue(byte b) {
        return this.m.containsValue(b);
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte get(double d) {
        return this.m.get(d);
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte put(double d, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte remove(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public void putAll(TDoubleByteMap tDoubleByteMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public void putAll(Map<? extends Double, ? extends Byte> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public TDoubleSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public double[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public double[] keys(double[] dArr) {
        return this.m.keys(dArr);
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public TByteCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TDoubleByteMap
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

    @Override // gnu.trove.map.TDoubleByteMap
    public double getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        return this.m.forEachKey(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        return this.m.forEachValue(tByteProcedure);
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean forEachEntry(TDoubleByteProcedure tDoubleByteProcedure) {
        return this.m.forEachEntry(tDoubleByteProcedure);
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public TDoubleByteIterator iterator() {
        return new TDoubleByteIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableDoubleByteMap.1
            TDoubleByteIterator iter;

            {
                this.iter = TUnmodifiableDoubleByteMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TDoubleByteIterator
            public double key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TDoubleByteIterator
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

            @Override // gnu.trove.iterator.TDoubleByteIterator
            public byte setValue(byte b) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte putIfAbsent(double d, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public void transformValues(TByteFunction tByteFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean retainEntries(TDoubleByteProcedure tDoubleByteProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean increment(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public boolean adjustValue(double d, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleByteMap
    public byte adjustOrPutValue(double d, byte b, byte b2) {
        throw new UnsupportedOperationException();
    }
}
