package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TDoubleLongIterator;
import gnu.trove.map.TDoubleLongMap;
import gnu.trove.procedure.TDoubleLongProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableDoubleLongMap implements TDoubleLongMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TDoubleLongMap f3677m;
    private transient TDoubleSet keySet = null;
    private transient TLongCollection values = null;

    public TUnmodifiableDoubleLongMap(TDoubleLongMap tDoubleLongMap) {
        Objects.requireNonNull(tDoubleLongMap);
        this.f3677m = tDoubleLongMap;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public int size() {
        return this.f3677m.size();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean isEmpty() {
        return this.f3677m.isEmpty();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean containsKey(double d) {
        return this.f3677m.containsKey(d);
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean containsValue(long j) {
        return this.f3677m.containsValue(j);
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long get(double d) {
        return this.f3677m.get(d);
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long put(double d, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long remove(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public void putAll(TDoubleLongMap tDoubleLongMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public void putAll(Map<? extends Double, ? extends Long> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public TDoubleSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3677m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public double[] keys() {
        return this.f3677m.keys();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public double[] keys(double[] dArr) {
        return this.f3677m.keys(dArr);
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public TLongCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3677m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long[] values() {
        return this.f3677m.values();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long[] values(long[] jArr) {
        return this.f3677m.values(jArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3677m.equals(obj);
    }

    public int hashCode() {
        return this.f3677m.hashCode();
    }

    public String toString() {
        return this.f3677m.toString();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public double getNoEntryKey() {
        return this.f3677m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long getNoEntryValue() {
        return this.f3677m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        return this.f3677m.forEachKey(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        return this.f3677m.forEachValue(tLongProcedure);
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean forEachEntry(TDoubleLongProcedure tDoubleLongProcedure) {
        return this.f3677m.forEachEntry(tDoubleLongProcedure);
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public TDoubleLongIterator iterator() {
        return new TDoubleLongIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableDoubleLongMap.1
            TDoubleLongIterator iter;

            {
                this.iter = TUnmodifiableDoubleLongMap.this.f3677m.iterator();
            }

            @Override // gnu.trove.iterator.TDoubleLongIterator
            public double key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TDoubleLongIterator
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

            @Override // gnu.trove.iterator.TDoubleLongIterator
            public long setValue(long j) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long putIfAbsent(double d, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public void transformValues(TLongFunction tLongFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean retainEntries(TDoubleLongProcedure tDoubleLongProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean increment(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public boolean adjustValue(double d, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleLongMap
    public long adjustOrPutValue(double d, long j, long j2) {
        throw new UnsupportedOperationException();
    }
}