package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TLongShortIterator;
import gnu.trove.map.TLongShortMap;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TLongShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TLongSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableLongShortMap implements TLongShortMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TLongShortMap m;
    private transient TLongSet keySet = null;
    private transient TShortCollection values = null;

    public TUnmodifiableLongShortMap(TLongShortMap tLongShortMap) {
        Objects.requireNonNull(tLongShortMap);
        this.m = tLongShortMap;
    }

    @Override // gnu.trove.map.TLongShortMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean containsKey(long j) {
        return this.m.containsKey(j);
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean containsValue(short s) {
        return this.m.containsValue(s);
    }

    @Override // gnu.trove.map.TLongShortMap
    public short get(long j) {
        return this.m.get(j);
    }

    @Override // gnu.trove.map.TLongShortMap
    public short put(long j, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongShortMap
    public short remove(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongShortMap
    public void putAll(TLongShortMap tLongShortMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongShortMap
    public void putAll(Map<? extends Long, ? extends Short> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongShortMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongShortMap
    public TLongSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TLongShortMap
    public long[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TLongShortMap
    public long[] keys(long[] jArr) {
        return this.m.keys(jArr);
    }

    @Override // gnu.trove.map.TLongShortMap
    public TShortCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TLongShortMap
    public short[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TLongShortMap
    public short[] values(short[] sArr) {
        return this.m.values(sArr);
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

    @Override // gnu.trove.map.TLongShortMap
    public long getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongShortMap
    public short getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        return this.m.forEachKey(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        return this.m.forEachValue(tShortProcedure);
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean forEachEntry(TLongShortProcedure tLongShortProcedure) {
        return this.m.forEachEntry(tLongShortProcedure);
    }

    @Override // gnu.trove.map.TLongShortMap
    public TLongShortIterator iterator() {
        return new TLongShortIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableLongShortMap.1
            TLongShortIterator iter;

            {
                this.iter = TUnmodifiableLongShortMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TLongShortIterator
            public long key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TLongShortIterator
            public short value() {
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

            @Override // gnu.trove.iterator.TLongShortIterator
            public short setValue(short s) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TLongShortMap
    public short putIfAbsent(long j, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongShortMap
    public void transformValues(TShortFunction tShortFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean retainEntries(TLongShortProcedure tLongShortProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean increment(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean adjustValue(long j, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongShortMap
    public short adjustOrPutValue(long j, short s, short s2) {
        throw new UnsupportedOperationException();
    }
}
