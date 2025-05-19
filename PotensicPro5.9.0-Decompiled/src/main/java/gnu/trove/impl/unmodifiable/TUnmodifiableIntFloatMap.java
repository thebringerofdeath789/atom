package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TIntFloatIterator;
import gnu.trove.map.TIntFloatMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TIntFloatProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableIntFloatMap implements TIntFloatMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TIntFloatMap m;
    private transient TIntSet keySet = null;
    private transient TFloatCollection values = null;

    public TUnmodifiableIntFloatMap(TIntFloatMap tIntFloatMap) {
        Objects.requireNonNull(tIntFloatMap);
        this.m = tIntFloatMap;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean containsKey(int i) {
        return this.m.containsKey(i);
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean containsValue(float f) {
        return this.m.containsValue(f);
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float get(int i) {
        return this.m.get(i);
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float put(int i, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public void putAll(TIntFloatMap tIntFloatMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public void putAll(Map<? extends Integer, ? extends Float> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public TIntSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public int[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public int[] keys(int[] iArr) {
        return this.m.keys(iArr);
    }

    @Override // gnu.trove.map.TIntFloatMap
    public TFloatCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TIntFloatMap
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

    @Override // gnu.trove.map.TIntFloatMap
    public int getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        return this.m.forEachKey(tIntProcedure);
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        return this.m.forEachValue(tFloatProcedure);
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean forEachEntry(TIntFloatProcedure tIntFloatProcedure) {
        return this.m.forEachEntry(tIntFloatProcedure);
    }

    @Override // gnu.trove.map.TIntFloatMap
    public TIntFloatIterator iterator() {
        return new TIntFloatIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableIntFloatMap.1
            TIntFloatIterator iter;

            {
                this.iter = TUnmodifiableIntFloatMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TIntFloatIterator
            public int key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TIntFloatIterator
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

            @Override // gnu.trove.iterator.TIntFloatIterator
            public float setValue(float f) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float putIfAbsent(int i, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean retainEntries(TIntFloatProcedure tIntFloatProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean increment(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public boolean adjustValue(int i, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntFloatMap
    public float adjustOrPutValue(int i, float f, float f2) {
        throw new UnsupportedOperationException();
    }
}
