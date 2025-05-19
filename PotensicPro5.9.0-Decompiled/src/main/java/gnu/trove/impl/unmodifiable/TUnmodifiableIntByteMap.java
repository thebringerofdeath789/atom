package gnu.trove.impl.unmodifiable;

import gnu.trove.TByteCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TIntByteIterator;
import gnu.trove.map.TIntByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TIntByteProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableIntByteMap implements TIntByteMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TIntByteMap m;
    private transient TIntSet keySet = null;
    private transient TByteCollection values = null;

    public TUnmodifiableIntByteMap(TIntByteMap tIntByteMap) {
        Objects.requireNonNull(tIntByteMap);
        this.m = tIntByteMap;
    }

    @Override // gnu.trove.map.TIntByteMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean containsKey(int i) {
        return this.m.containsKey(i);
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean containsValue(byte b) {
        return this.m.containsValue(b);
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte get(int i) {
        return this.m.get(i);
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte put(int i, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntByteMap
    public void putAll(TIntByteMap tIntByteMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntByteMap
    public void putAll(Map<? extends Integer, ? extends Byte> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntByteMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntByteMap
    public TIntSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TIntByteMap
    public int[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TIntByteMap
    public int[] keys(int[] iArr) {
        return this.m.keys(iArr);
    }

    @Override // gnu.trove.map.TIntByteMap
    public TByteCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TIntByteMap
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

    @Override // gnu.trove.map.TIntByteMap
    public int getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        return this.m.forEachKey(tIntProcedure);
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        return this.m.forEachValue(tByteProcedure);
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean forEachEntry(TIntByteProcedure tIntByteProcedure) {
        return this.m.forEachEntry(tIntByteProcedure);
    }

    @Override // gnu.trove.map.TIntByteMap
    public TIntByteIterator iterator() {
        return new TIntByteIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableIntByteMap.1
            TIntByteIterator iter;

            {
                this.iter = TUnmodifiableIntByteMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TIntByteIterator
            public int key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TIntByteIterator
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

            @Override // gnu.trove.iterator.TIntByteIterator
            public byte setValue(byte b) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte putIfAbsent(int i, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntByteMap
    public void transformValues(TByteFunction tByteFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean retainEntries(TIntByteProcedure tIntByteProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean increment(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntByteMap
    public boolean adjustValue(int i, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntByteMap
    public byte adjustOrPutValue(int i, byte b, byte b2) {
        throw new UnsupportedOperationException();
    }
}
