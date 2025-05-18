package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TLongDoubleIterator;
import gnu.trove.map.TLongDoubleMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TLongDoubleProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableLongDoubleMap implements TLongDoubleMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TLongDoubleMap f3704m;
    private transient TLongSet keySet = null;
    private transient TDoubleCollection values = null;

    public TUnmodifiableLongDoubleMap(TLongDoubleMap tLongDoubleMap) {
        Objects.requireNonNull(tLongDoubleMap);
        this.f3704m = tLongDoubleMap;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public int size() {
        return this.f3704m.size();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean isEmpty() {
        return this.f3704m.isEmpty();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean containsKey(long j) {
        return this.f3704m.containsKey(j);
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean containsValue(double d) {
        return this.f3704m.containsValue(d);
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double get(long j) {
        return this.f3704m.get(j);
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double put(long j, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double remove(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public void putAll(TLongDoubleMap tLongDoubleMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public void putAll(Map<? extends Long, ? extends Double> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public TLongSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3704m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public long[] keys() {
        return this.f3704m.keys();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public long[] keys(long[] jArr) {
        return this.f3704m.keys(jArr);
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public TDoubleCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3704m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double[] values() {
        return this.f3704m.values();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double[] values(double[] dArr) {
        return this.f3704m.values(dArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3704m.equals(obj);
    }

    public int hashCode() {
        return this.f3704m.hashCode();
    }

    public String toString() {
        return this.f3704m.toString();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public long getNoEntryKey() {
        return this.f3704m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double getNoEntryValue() {
        return this.f3704m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        return this.f3704m.forEachKey(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        return this.f3704m.forEachValue(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean forEachEntry(TLongDoubleProcedure tLongDoubleProcedure) {
        return this.f3704m.forEachEntry(tLongDoubleProcedure);
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public TLongDoubleIterator iterator() {
        return new TLongDoubleIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableLongDoubleMap.1
            TLongDoubleIterator iter;

            {
                this.iter = TUnmodifiableLongDoubleMap.this.f3704m.iterator();
            }

            @Override // gnu.trove.iterator.TLongDoubleIterator
            public long key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TLongDoubleIterator
            public double value() {
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

            @Override // gnu.trove.iterator.TLongDoubleIterator
            public double setValue(double d) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double putIfAbsent(long j, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean retainEntries(TLongDoubleProcedure tLongDoubleProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean increment(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public boolean adjustValue(long j, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongDoubleMap
    public double adjustOrPutValue(long j, double d, double d2) {
        throw new UnsupportedOperationException();
    }
}