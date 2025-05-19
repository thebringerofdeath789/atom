package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TFloatDoubleIterator;
import gnu.trove.map.TFloatDoubleMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TFloatDoubleProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TFloatSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableFloatDoubleMap implements TFloatDoubleMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TFloatDoubleMap m;
    private transient TFloatSet keySet = null;
    private transient TDoubleCollection values = null;

    public TUnmodifiableFloatDoubleMap(TFloatDoubleMap tFloatDoubleMap) {
        Objects.requireNonNull(tFloatDoubleMap);
        this.m = tFloatDoubleMap;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean containsKey(float f) {
        return this.m.containsKey(f);
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean containsValue(double d) {
        return this.m.containsValue(d);
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double get(float f) {
        return this.m.get(f);
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double put(float f, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double remove(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public void putAll(TFloatDoubleMap tFloatDoubleMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public void putAll(Map<? extends Float, ? extends Double> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public TFloatSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public float[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public float[] keys(float[] fArr) {
        return this.m.keys(fArr);
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public TDoubleCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double[] values(double[] dArr) {
        return this.m.values(dArr);
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

    @Override // gnu.trove.map.TFloatDoubleMap
    public float getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return this.m.forEachKey(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        return this.m.forEachValue(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean forEachEntry(TFloatDoubleProcedure tFloatDoubleProcedure) {
        return this.m.forEachEntry(tFloatDoubleProcedure);
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public TFloatDoubleIterator iterator() {
        return new TFloatDoubleIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableFloatDoubleMap.1
            TFloatDoubleIterator iter;

            {
                this.iter = TUnmodifiableFloatDoubleMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TFloatDoubleIterator
            public float key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TFloatDoubleIterator
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

            @Override // gnu.trove.iterator.TFloatDoubleIterator
            public double setValue(double d) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double putIfAbsent(float f, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean retainEntries(TFloatDoubleProcedure tFloatDoubleProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean increment(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public boolean adjustValue(float f, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatDoubleMap
    public double adjustOrPutValue(float f, double d, double d2) {
        throw new UnsupportedOperationException();
    }
}
