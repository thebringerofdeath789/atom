package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TDoubleIntIterator;
import gnu.trove.map.TDoubleIntMap;
import gnu.trove.procedure.TDoubleIntProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableDoubleIntMap implements TDoubleIntMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TDoubleIntMap f3676m;
    private transient TDoubleSet keySet = null;
    private transient TIntCollection values = null;

    public TUnmodifiableDoubleIntMap(TDoubleIntMap tDoubleIntMap) {
        Objects.requireNonNull(tDoubleIntMap);
        this.f3676m = tDoubleIntMap;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int size() {
        return this.f3676m.size();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean isEmpty() {
        return this.f3676m.isEmpty();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean containsKey(double d) {
        return this.f3676m.containsKey(d);
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean containsValue(int i) {
        return this.f3676m.containsValue(i);
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int get(double d) {
        return this.f3676m.get(d);
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int put(double d, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int remove(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public void putAll(TDoubleIntMap tDoubleIntMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public void putAll(Map<? extends Double, ? extends Integer> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public TDoubleSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3676m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public double[] keys() {
        return this.f3676m.keys();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public double[] keys(double[] dArr) {
        return this.f3676m.keys(dArr);
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public TIntCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3676m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int[] values() {
        return this.f3676m.values();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int[] values(int[] iArr) {
        return this.f3676m.values(iArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3676m.equals(obj);
    }

    public int hashCode() {
        return this.f3676m.hashCode();
    }

    public String toString() {
        return this.f3676m.toString();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public double getNoEntryKey() {
        return this.f3676m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int getNoEntryValue() {
        return this.f3676m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        return this.f3676m.forEachKey(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        return this.f3676m.forEachValue(tIntProcedure);
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean forEachEntry(TDoubleIntProcedure tDoubleIntProcedure) {
        return this.f3676m.forEachEntry(tDoubleIntProcedure);
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public TDoubleIntIterator iterator() {
        return new TDoubleIntIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableDoubleIntMap.1
            TDoubleIntIterator iter;

            {
                this.iter = TUnmodifiableDoubleIntMap.this.f3676m.iterator();
            }

            @Override // gnu.trove.iterator.TDoubleIntIterator
            public double key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TDoubleIntIterator
            public int value() {
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

            @Override // gnu.trove.iterator.TDoubleIntIterator
            public int setValue(int i) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int putIfAbsent(double d, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public void transformValues(TIntFunction tIntFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean retainEntries(TDoubleIntProcedure tDoubleIntProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean increment(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public boolean adjustValue(double d, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleIntMap
    public int adjustOrPutValue(double d, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}