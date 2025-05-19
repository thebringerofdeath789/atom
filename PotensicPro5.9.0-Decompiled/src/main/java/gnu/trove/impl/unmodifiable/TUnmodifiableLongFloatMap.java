package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TLongFloatIterator;
import gnu.trove.map.TLongFloatMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TLongFloatProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableLongFloatMap implements TLongFloatMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TLongFloatMap m;
    private transient TLongSet keySet = null;
    private transient TFloatCollection values = null;

    public TUnmodifiableLongFloatMap(TLongFloatMap tLongFloatMap) {
        Objects.requireNonNull(tLongFloatMap);
        this.m = tLongFloatMap;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean containsKey(long j) {
        return this.m.containsKey(j);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean containsValue(float f) {
        return this.m.containsValue(f);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float get(long j) {
        return this.m.get(j);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float put(long j, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float remove(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public void putAll(TLongFloatMap tLongFloatMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public void putAll(Map<? extends Long, ? extends Float> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public TLongSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public long[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public long[] keys(long[] jArr) {
        return this.m.keys(jArr);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public TFloatCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float[] values(float[] fArr) {
        return this.m.values(fArr);
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

    @Override // gnu.trove.map.TLongFloatMap
    public long getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        return this.m.forEachKey(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        return this.m.forEachValue(tFloatProcedure);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean forEachEntry(TLongFloatProcedure tLongFloatProcedure) {
        return this.m.forEachEntry(tLongFloatProcedure);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public TLongFloatIterator iterator() {
        return new TLongFloatIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableLongFloatMap.1
            TLongFloatIterator iter;

            {
                this.iter = TUnmodifiableLongFloatMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TLongFloatIterator
            public long key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TLongFloatIterator
            public float value() {
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

            @Override // gnu.trove.iterator.TLongFloatIterator
            public float setValue(float f) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float putIfAbsent(long j, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean retainEntries(TLongFloatProcedure tLongFloatProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean increment(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean adjustValue(long j, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float adjustOrPutValue(long j, float f, float f2) {
        throw new UnsupportedOperationException();
    }
}
