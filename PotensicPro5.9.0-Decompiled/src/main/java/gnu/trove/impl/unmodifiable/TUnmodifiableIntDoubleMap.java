package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TIntDoubleIterator;
import gnu.trove.map.TIntDoubleMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TIntDoubleProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableIntDoubleMap implements TIntDoubleMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TIntDoubleMap m;
    private transient TIntSet keySet = null;
    private transient TDoubleCollection values = null;

    public TUnmodifiableIntDoubleMap(TIntDoubleMap tIntDoubleMap) {
        Objects.requireNonNull(tIntDoubleMap);
        this.m = tIntDoubleMap;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean containsKey(int i) {
        return this.m.containsKey(i);
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean containsValue(double d) {
        return this.m.containsValue(d);
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double get(int i) {
        return this.m.get(i);
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double put(int i, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public void putAll(TIntDoubleMap tIntDoubleMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public void putAll(Map<? extends Integer, ? extends Double> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public TIntSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public int[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public int[] keys(int[] iArr) {
        return this.m.keys(iArr);
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public TDoubleCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TIntDoubleMap
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

    @Override // gnu.trove.map.TIntDoubleMap
    public int getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        return this.m.forEachKey(tIntProcedure);
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        return this.m.forEachValue(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean forEachEntry(TIntDoubleProcedure tIntDoubleProcedure) {
        return this.m.forEachEntry(tIntDoubleProcedure);
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public TIntDoubleIterator iterator() {
        return new TIntDoubleIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableIntDoubleMap.1
            TIntDoubleIterator iter;

            {
                this.iter = TUnmodifiableIntDoubleMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TIntDoubleIterator
            public int key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TIntDoubleIterator
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

            @Override // gnu.trove.iterator.TIntDoubleIterator
            public double setValue(double d) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double putIfAbsent(int i, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean retainEntries(TIntDoubleProcedure tIntDoubleProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean increment(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean adjustValue(int i, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double adjustOrPutValue(int i, double d, double d2) {
        throw new UnsupportedOperationException();
    }
}
