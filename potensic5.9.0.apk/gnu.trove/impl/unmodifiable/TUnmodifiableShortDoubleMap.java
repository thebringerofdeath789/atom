package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TShortDoubleIterator;
import gnu.trove.map.TShortDoubleMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TShortDoubleProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableShortDoubleMap implements TShortDoubleMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TShortDoubleMap f3721m;
    private transient TShortSet keySet = null;
    private transient TDoubleCollection values = null;

    public TUnmodifiableShortDoubleMap(TShortDoubleMap tShortDoubleMap) {
        Objects.requireNonNull(tShortDoubleMap);
        this.f3721m = tShortDoubleMap;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public int size() {
        return this.f3721m.size();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean isEmpty() {
        return this.f3721m.isEmpty();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean containsKey(short s) {
        return this.f3721m.containsKey(s);
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean containsValue(double d) {
        return this.f3721m.containsValue(d);
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double get(short s) {
        return this.f3721m.get(s);
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double put(short s, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double remove(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public void putAll(TShortDoubleMap tShortDoubleMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public void putAll(Map<? extends Short, ? extends Double> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public TShortSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3721m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public short[] keys() {
        return this.f3721m.keys();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public short[] keys(short[] sArr) {
        return this.f3721m.keys(sArr);
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public TDoubleCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3721m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double[] values() {
        return this.f3721m.values();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double[] values(double[] dArr) {
        return this.f3721m.values(dArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3721m.equals(obj);
    }

    public int hashCode() {
        return this.f3721m.hashCode();
    }

    public String toString() {
        return this.f3721m.toString();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public short getNoEntryKey() {
        return this.f3721m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double getNoEntryValue() {
        return this.f3721m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return this.f3721m.forEachKey(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        return this.f3721m.forEachValue(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean forEachEntry(TShortDoubleProcedure tShortDoubleProcedure) {
        return this.f3721m.forEachEntry(tShortDoubleProcedure);
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public TShortDoubleIterator iterator() {
        return new TShortDoubleIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableShortDoubleMap.1
            TShortDoubleIterator iter;

            {
                this.iter = TUnmodifiableShortDoubleMap.this.f3721m.iterator();
            }

            @Override // gnu.trove.iterator.TShortDoubleIterator
            public short key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TShortDoubleIterator
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

            @Override // gnu.trove.iterator.TShortDoubleIterator
            public double setValue(double d) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double putIfAbsent(short s, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean retainEntries(TShortDoubleProcedure tShortDoubleProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean increment(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public boolean adjustValue(short s, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortDoubleMap
    public double adjustOrPutValue(short s, double d, double d2) {
        throw new UnsupportedOperationException();
    }
}