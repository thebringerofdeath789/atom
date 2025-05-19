package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TIntLongIterator;
import gnu.trove.map.TIntLongMap;
import gnu.trove.procedure.TIntLongProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TIntSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableIntLongMap implements TIntLongMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TIntLongMap m;
    private transient TIntSet keySet = null;
    private transient TLongCollection values = null;

    public TUnmodifiableIntLongMap(TIntLongMap tIntLongMap) {
        Objects.requireNonNull(tIntLongMap);
        this.m = tIntLongMap;
    }

    @Override // gnu.trove.map.TIntLongMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean containsKey(int i) {
        return this.m.containsKey(i);
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean containsValue(long j) {
        return this.m.containsValue(j);
    }

    @Override // gnu.trove.map.TIntLongMap
    public long get(int i) {
        return this.m.get(i);
    }

    @Override // gnu.trove.map.TIntLongMap
    public long put(int i, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntLongMap
    public long remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntLongMap
    public void putAll(TIntLongMap tIntLongMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntLongMap
    public void putAll(Map<? extends Integer, ? extends Long> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntLongMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntLongMap
    public TIntSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TIntLongMap
    public int[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TIntLongMap
    public int[] keys(int[] iArr) {
        return this.m.keys(iArr);
    }

    @Override // gnu.trove.map.TIntLongMap
    public TLongCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TIntLongMap
    public long[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TIntLongMap
    public long[] values(long[] jArr) {
        return this.m.values(jArr);
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

    @Override // gnu.trove.map.TIntLongMap
    public int getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntLongMap
    public long getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        return this.m.forEachKey(tIntProcedure);
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        return this.m.forEachValue(tLongProcedure);
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean forEachEntry(TIntLongProcedure tIntLongProcedure) {
        return this.m.forEachEntry(tIntLongProcedure);
    }

    @Override // gnu.trove.map.TIntLongMap
    public TIntLongIterator iterator() {
        return new TIntLongIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableIntLongMap.1
            TIntLongIterator iter;

            {
                this.iter = TUnmodifiableIntLongMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TIntLongIterator
            public int key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TIntLongIterator
            public long value() {
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

            @Override // gnu.trove.iterator.TIntLongIterator
            public long setValue(long j) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TIntLongMap
    public long putIfAbsent(int i, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntLongMap
    public void transformValues(TLongFunction tLongFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean retainEntries(TIntLongProcedure tIntLongProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean increment(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean adjustValue(int i, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntLongMap
    public long adjustOrPutValue(int i, long j, long j2) {
        throw new UnsupportedOperationException();
    }
}
