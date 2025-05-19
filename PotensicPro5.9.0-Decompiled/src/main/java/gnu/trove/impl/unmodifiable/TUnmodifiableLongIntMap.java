package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TLongIntIterator;
import gnu.trove.map.TLongIntMap;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TLongIntProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableLongIntMap implements TLongIntMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TLongIntMap m;
    private transient TLongSet keySet = null;
    private transient TIntCollection values = null;

    public TUnmodifiableLongIntMap(TLongIntMap tLongIntMap) {
        Objects.requireNonNull(tLongIntMap);
        this.m = tLongIntMap;
    }

    @Override // gnu.trove.map.TLongIntMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean containsKey(long j) {
        return this.m.containsKey(j);
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean containsValue(int i) {
        return this.m.containsValue(i);
    }

    @Override // gnu.trove.map.TLongIntMap
    public int get(long j) {
        return this.m.get(j);
    }

    @Override // gnu.trove.map.TLongIntMap
    public int put(long j, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongIntMap
    public int remove(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongIntMap
    public void putAll(TLongIntMap tLongIntMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongIntMap
    public void putAll(Map<? extends Long, ? extends Integer> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongIntMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongIntMap
    public TLongSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TLongIntMap
    public long[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TLongIntMap
    public long[] keys(long[] jArr) {
        return this.m.keys(jArr);
    }

    @Override // gnu.trove.map.TLongIntMap
    public TIntCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TLongIntMap
    public int[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TLongIntMap
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

    @Override // gnu.trove.map.TLongIntMap
    public long getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongIntMap
    public int getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        return this.m.forEachKey(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        return this.m.forEachValue(tIntProcedure);
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean forEachEntry(TLongIntProcedure tLongIntProcedure) {
        return this.m.forEachEntry(tLongIntProcedure);
    }

    @Override // gnu.trove.map.TLongIntMap
    public TLongIntIterator iterator() {
        return new TLongIntIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableLongIntMap.1
            TLongIntIterator iter;

            {
                this.iter = TUnmodifiableLongIntMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TLongIntIterator
            public long key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TLongIntIterator
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

            @Override // gnu.trove.iterator.TLongIntIterator
            public int setValue(int i) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TLongIntMap
    public int putIfAbsent(long j, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongIntMap
    public void transformValues(TIntFunction tIntFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean retainEntries(TLongIntProcedure tLongIntProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean increment(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongIntMap
    public boolean adjustValue(long j, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongIntMap
    public int adjustOrPutValue(long j, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
