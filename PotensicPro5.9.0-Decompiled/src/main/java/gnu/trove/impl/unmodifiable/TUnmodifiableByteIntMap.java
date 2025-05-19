package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TByteIntIterator;
import gnu.trove.map.TByteIntMap;
import gnu.trove.procedure.TByteIntProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TByteSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableByteIntMap implements TByteIntMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TByteIntMap m;
    private transient TByteSet keySet = null;
    private transient TIntCollection values = null;

    public TUnmodifiableByteIntMap(TByteIntMap tByteIntMap) {
        Objects.requireNonNull(tByteIntMap);
        this.m = tByteIntMap;
    }

    @Override // gnu.trove.map.TByteIntMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean containsKey(byte b) {
        return this.m.containsKey(b);
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean containsValue(int i) {
        return this.m.containsValue(i);
    }

    @Override // gnu.trove.map.TByteIntMap
    public int get(byte b) {
        return this.m.get(b);
    }

    @Override // gnu.trove.map.TByteIntMap
    public int put(byte b, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteIntMap
    public int remove(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteIntMap
    public void putAll(TByteIntMap tByteIntMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteIntMap
    public void putAll(Map<? extends Byte, ? extends Integer> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteIntMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteIntMap
    public TByteSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TByteIntMap
    public byte[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TByteIntMap
    public byte[] keys(byte[] bArr) {
        return this.m.keys(bArr);
    }

    @Override // gnu.trove.map.TByteIntMap
    public TIntCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TByteIntMap
    public int[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TByteIntMap
    public int[] values(int[] iArr) {
        return this.m.values(iArr);
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

    @Override // gnu.trove.map.TByteIntMap
    public byte getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteIntMap
    public int getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return this.m.forEachKey(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        return this.m.forEachValue(tIntProcedure);
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean forEachEntry(TByteIntProcedure tByteIntProcedure) {
        return this.m.forEachEntry(tByteIntProcedure);
    }

    @Override // gnu.trove.map.TByteIntMap
    public TByteIntIterator iterator() {
        return new TByteIntIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableByteIntMap.1
            TByteIntIterator iter;

            {
                this.iter = TUnmodifiableByteIntMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TByteIntIterator
            public byte key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TByteIntIterator
            public int value() {
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

            @Override // gnu.trove.iterator.TByteIntIterator
            public int setValue(int i) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TByteIntMap
    public int putIfAbsent(byte b, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteIntMap
    public void transformValues(TIntFunction tIntFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean retainEntries(TByteIntProcedure tByteIntProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean increment(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean adjustValue(byte b, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteIntMap
    public int adjustOrPutValue(byte b, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
