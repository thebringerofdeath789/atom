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

    /* renamed from: m */
    private final TLongFloatMap f3705m;
    private transient TLongSet keySet = null;
    private transient TFloatCollection values = null;

    public TUnmodifiableLongFloatMap(TLongFloatMap tLongFloatMap) {
        Objects.requireNonNull(tLongFloatMap);
        this.f3705m = tLongFloatMap;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public int size() {
        return this.f3705m.size();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean isEmpty() {
        return this.f3705m.isEmpty();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean containsKey(long j) {
        return this.f3705m.containsKey(j);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean containsValue(float f) {
        return this.f3705m.containsValue(f);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float get(long j) {
        return this.f3705m.get(j);
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
            this.keySet = TCollections.unmodifiableSet(this.f3705m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public long[] keys() {
        return this.f3705m.keys();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public long[] keys(long[] jArr) {
        return this.f3705m.keys(jArr);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public TFloatCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3705m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float[] values() {
        return this.f3705m.values();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float[] values(float[] fArr) {
        return this.f3705m.values(fArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3705m.equals(obj);
    }

    public int hashCode() {
        return this.f3705m.hashCode();
    }

    public String toString() {
        return this.f3705m.toString();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public long getNoEntryKey() {
        return this.f3705m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float getNoEntryValue() {
        return this.f3705m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        return this.f3705m.forEachKey(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        return this.f3705m.forEachValue(tFloatProcedure);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean forEachEntry(TLongFloatProcedure tLongFloatProcedure) {
        return this.f3705m.forEachEntry(tLongFloatProcedure);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public TLongFloatIterator iterator() {
        return new TLongFloatIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableLongFloatMap.1
            TLongFloatIterator iter;

            {
                this.iter = TUnmodifiableLongFloatMap.this.f3705m.iterator();
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