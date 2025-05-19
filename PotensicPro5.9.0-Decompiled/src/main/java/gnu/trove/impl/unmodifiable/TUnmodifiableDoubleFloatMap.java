package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TDoubleFloatIterator;
import gnu.trove.map.TDoubleFloatMap;
import gnu.trove.procedure.TDoubleFloatProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableDoubleFloatMap implements TDoubleFloatMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TDoubleFloatMap m;
    private transient TDoubleSet keySet = null;
    private transient TFloatCollection values = null;

    public TUnmodifiableDoubleFloatMap(TDoubleFloatMap tDoubleFloatMap) {
        Objects.requireNonNull(tDoubleFloatMap);
        this.m = tDoubleFloatMap;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean containsKey(double d) {
        return this.m.containsKey(d);
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean containsValue(float f) {
        return this.m.containsValue(f);
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float get(double d) {
        return this.m.get(d);
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float put(double d, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float remove(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void putAll(TDoubleFloatMap tDoubleFloatMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void putAll(Map<? extends Double, ? extends Float> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public TDoubleSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public double[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public double[] keys(double[] dArr) {
        return this.m.keys(dArr);
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public TFloatCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
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

    @Override // gnu.trove.map.TDoubleFloatMap
    public double getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        return this.m.forEachKey(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        return this.m.forEachValue(tFloatProcedure);
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean forEachEntry(TDoubleFloatProcedure tDoubleFloatProcedure) {
        return this.m.forEachEntry(tDoubleFloatProcedure);
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public TDoubleFloatIterator iterator() {
        return new TDoubleFloatIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableDoubleFloatMap.1
            TDoubleFloatIterator iter;

            {
                this.iter = TUnmodifiableDoubleFloatMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TDoubleFloatIterator
            public double key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TDoubleFloatIterator
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

            @Override // gnu.trove.iterator.TDoubleFloatIterator
            public float setValue(float f) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float putIfAbsent(double d, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean retainEntries(TDoubleFloatProcedure tDoubleFloatProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean increment(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean adjustValue(double d, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float adjustOrPutValue(double d, float f, float f2) {
        throw new UnsupportedOperationException();
    }
}
