package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TCharDoubleIterator;
import gnu.trove.map.TCharDoubleMap;
import gnu.trove.procedure.TCharDoubleProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TCharSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableCharDoubleMap implements TCharDoubleMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TCharDoubleMap m;
    private transient TCharSet keySet = null;
    private transient TDoubleCollection values = null;

    public TUnmodifiableCharDoubleMap(TCharDoubleMap tCharDoubleMap) {
        Objects.requireNonNull(tCharDoubleMap);
        this.m = tCharDoubleMap;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean containsKey(char c) {
        return this.m.containsKey(c);
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean containsValue(double d) {
        return this.m.containsValue(d);
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double get(char c) {
        return this.m.get(c);
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double put(char c, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double remove(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public void putAll(TCharDoubleMap tCharDoubleMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public void putAll(Map<? extends Character, ? extends Double> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public TCharSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public char[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public char[] keys(char[] cArr) {
        return this.m.keys(cArr);
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public TDoubleCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TCharDoubleMap
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

    @Override // gnu.trove.map.TCharDoubleMap
    public char getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        return this.m.forEachKey(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        return this.m.forEachValue(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean forEachEntry(TCharDoubleProcedure tCharDoubleProcedure) {
        return this.m.forEachEntry(tCharDoubleProcedure);
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public TCharDoubleIterator iterator() {
        return new TCharDoubleIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableCharDoubleMap.1
            TCharDoubleIterator iter;

            {
                this.iter = TUnmodifiableCharDoubleMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TCharDoubleIterator
            public char key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TCharDoubleIterator
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

            @Override // gnu.trove.iterator.TCharDoubleIterator
            public double setValue(double d) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double putIfAbsent(char c, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean retainEntries(TCharDoubleProcedure tCharDoubleProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean increment(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public boolean adjustValue(char c, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharDoubleMap
    public double adjustOrPutValue(char c, double d, double d2) {
        throw new UnsupportedOperationException();
    }
}
