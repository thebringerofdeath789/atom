package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TFloatFloatIterator;
import gnu.trove.map.TFloatFloatMap;
import gnu.trove.procedure.TFloatFloatProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TFloatSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableFloatFloatMap implements TFloatFloatMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TFloatFloatMap m;
    private transient TFloatSet keySet = null;
    private transient TFloatCollection values = null;

    public TUnmodifiableFloatFloatMap(TFloatFloatMap tFloatFloatMap) {
        Objects.requireNonNull(tFloatFloatMap);
        this.m = tFloatFloatMap;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean containsKey(float f) {
        return this.m.containsKey(f);
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean containsValue(float f) {
        return this.m.containsValue(f);
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float get(float f) {
        return this.m.get(f);
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float put(float f, float f2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float remove(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public void putAll(TFloatFloatMap tFloatFloatMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public void putAll(Map<? extends Float, ? extends Float> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public TFloatSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float[] keys(float[] fArr) {
        return this.m.keys(fArr);
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public TFloatCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TFloatFloatMap
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

    @Override // gnu.trove.map.TFloatFloatMap
    public float getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return this.m.forEachKey(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        return this.m.forEachValue(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean forEachEntry(TFloatFloatProcedure tFloatFloatProcedure) {
        return this.m.forEachEntry(tFloatFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public TFloatFloatIterator iterator() {
        return new TFloatFloatIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableFloatFloatMap.1
            TFloatFloatIterator iter;

            {
                this.iter = TUnmodifiableFloatFloatMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TFloatFloatIterator
            public float key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TFloatFloatIterator
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

            @Override // gnu.trove.iterator.TFloatFloatIterator
            public float setValue(float f) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float putIfAbsent(float f, float f2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean retainEntries(TFloatFloatProcedure tFloatFloatProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean increment(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean adjustValue(float f, float f2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float adjustOrPutValue(float f, float f2, float f3) {
        throw new UnsupportedOperationException();
    }
}
