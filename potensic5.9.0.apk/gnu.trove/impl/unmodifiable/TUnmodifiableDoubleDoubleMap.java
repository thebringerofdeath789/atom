package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TDoubleDoubleIterator;
import gnu.trove.map.TDoubleDoubleMap;
import gnu.trove.procedure.TDoubleDoubleProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableDoubleDoubleMap implements TDoubleDoubleMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TDoubleDoubleMap f3674m;
    private transient TDoubleSet keySet = null;
    private transient TDoubleCollection values = null;

    public TUnmodifiableDoubleDoubleMap(TDoubleDoubleMap tDoubleDoubleMap) {
        Objects.requireNonNull(tDoubleDoubleMap);
        this.f3674m = tDoubleDoubleMap;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public int size() {
        return this.f3674m.size();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean isEmpty() {
        return this.f3674m.isEmpty();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean containsKey(double d) {
        return this.f3674m.containsKey(d);
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean containsValue(double d) {
        return this.f3674m.containsValue(d);
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double get(double d) {
        return this.f3674m.get(d);
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double put(double d, double d2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double remove(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public void putAll(TDoubleDoubleMap tDoubleDoubleMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public void putAll(Map<? extends Double, ? extends Double> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public TDoubleSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3674m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double[] keys() {
        return this.f3674m.keys();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double[] keys(double[] dArr) {
        return this.f3674m.keys(dArr);
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public TDoubleCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3674m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double[] values() {
        return this.f3674m.values();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double[] values(double[] dArr) {
        return this.f3674m.values(dArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3674m.equals(obj);
    }

    public int hashCode() {
        return this.f3674m.hashCode();
    }

    public String toString() {
        return this.f3674m.toString();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double getNoEntryKey() {
        return this.f3674m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double getNoEntryValue() {
        return this.f3674m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        return this.f3674m.forEachKey(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        return this.f3674m.forEachValue(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean forEachEntry(TDoubleDoubleProcedure tDoubleDoubleProcedure) {
        return this.f3674m.forEachEntry(tDoubleDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public TDoubleDoubleIterator iterator() {
        return new TDoubleDoubleIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableDoubleDoubleMap.1
            TDoubleDoubleIterator iter;

            {
                this.iter = TUnmodifiableDoubleDoubleMap.this.f3674m.iterator();
            }

            @Override // gnu.trove.iterator.TDoubleDoubleIterator
            public double key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TDoubleDoubleIterator
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

            @Override // gnu.trove.iterator.TDoubleDoubleIterator
            public double setValue(double d) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double putIfAbsent(double d, double d2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean retainEntries(TDoubleDoubleProcedure tDoubleDoubleProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean increment(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public boolean adjustValue(double d, double d2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleDoubleMap
    public double adjustOrPutValue(double d, double d2, double d3) {
        throw new UnsupportedOperationException();
    }
}