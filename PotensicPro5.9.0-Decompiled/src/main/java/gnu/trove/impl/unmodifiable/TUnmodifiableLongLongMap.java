package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TLongLongIterator;
import gnu.trove.map.TLongLongMap;
import gnu.trove.procedure.TLongLongProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableLongLongMap implements TLongLongMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TLongLongMap m;
    private transient TLongSet keySet = null;
    private transient TLongCollection values = null;

    public TUnmodifiableLongLongMap(TLongLongMap tLongLongMap) {
        Objects.requireNonNull(tLongLongMap);
        this.m = tLongLongMap;
    }

    @Override // gnu.trove.map.TLongLongMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean containsKey(long j) {
        return this.m.containsKey(j);
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean containsValue(long j) {
        return this.m.containsValue(j);
    }

    @Override // gnu.trove.map.TLongLongMap
    public long get(long j) {
        return this.m.get(j);
    }

    @Override // gnu.trove.map.TLongLongMap
    public long put(long j, long j2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongLongMap
    public long remove(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongLongMap
    public void putAll(TLongLongMap tLongLongMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongLongMap
    public void putAll(Map<? extends Long, ? extends Long> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongLongMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongLongMap
    public TLongSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TLongLongMap
    public long[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TLongLongMap
    public long[] keys(long[] jArr) {
        return this.m.keys(jArr);
    }

    @Override // gnu.trove.map.TLongLongMap
    public TLongCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TLongLongMap
    public long[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TLongLongMap
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

    @Override // gnu.trove.map.TLongLongMap
    public long getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongLongMap
    public long getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        return this.m.forEachKey(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        return this.m.forEachValue(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean forEachEntry(TLongLongProcedure tLongLongProcedure) {
        return this.m.forEachEntry(tLongLongProcedure);
    }

    @Override // gnu.trove.map.TLongLongMap
    public TLongLongIterator iterator() {
        return new TLongLongIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableLongLongMap.1
            TLongLongIterator iter;

            {
                this.iter = TUnmodifiableLongLongMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TLongLongIterator
            public long key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TLongLongIterator
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

            @Override // gnu.trove.iterator.TLongLongIterator
            public long setValue(long j) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TLongLongMap
    public long putIfAbsent(long j, long j2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongLongMap
    public void transformValues(TLongFunction tLongFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean retainEntries(TLongLongProcedure tLongLongProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean increment(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongLongMap
    public boolean adjustValue(long j, long j2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongLongMap
    public long adjustOrPutValue(long j, long j2, long j3) {
        throw new UnsupportedOperationException();
    }
}
