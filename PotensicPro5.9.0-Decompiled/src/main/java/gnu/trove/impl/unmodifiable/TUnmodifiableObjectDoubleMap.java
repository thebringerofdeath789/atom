package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TObjectDoubleIterator;
import gnu.trove.map.TObjectDoubleMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TObjectDoubleProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TUnmodifiableObjectDoubleMap<K> implements TObjectDoubleMap<K>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TObjectDoubleMap<K> m;
    private transient Set<K> keySet = null;
    private transient TDoubleCollection values = null;

    public TUnmodifiableObjectDoubleMap(TObjectDoubleMap<K> tObjectDoubleMap) {
        Objects.requireNonNull(tObjectDoubleMap);
        this.m = tObjectDoubleMap;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean containsKey(Object obj) {
        return this.m.containsKey(obj);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean containsValue(double d) {
        return this.m.containsValue(d);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double get(Object obj) {
        return this.m.get(obj);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double put(K k, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public void putAll(TObjectDoubleMap<? extends K> tObjectDoubleMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public void putAll(Map<? extends K, ? extends Double> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = Collections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public Object[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public K[] keys(K[] kArr) {
        return this.m.keys(kArr);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public TDoubleCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double[] values(double[] dArr) {
        return this.m.values(dArr);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean equals(Object obj) {
        return obj == this || this.m.equals(obj);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public int hashCode() {
        return this.m.hashCode();
    }

    public String toString() {
        return this.m.toString();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return this.m.forEachKey(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        return this.m.forEachValue(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean forEachEntry(TObjectDoubleProcedure<? super K> tObjectDoubleProcedure) {
        return this.m.forEachEntry(tObjectDoubleProcedure);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public TObjectDoubleIterator<K> iterator() {
        return new TObjectDoubleIterator<K>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableObjectDoubleMap.1
            TObjectDoubleIterator<K> iter;

            {
                this.iter = TUnmodifiableObjectDoubleMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TObjectDoubleIterator
            public K key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TObjectDoubleIterator
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

            @Override // gnu.trove.iterator.TObjectDoubleIterator
            public double setValue(double d) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double putIfAbsent(K k, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean retainEntries(TObjectDoubleProcedure<? super K> tObjectDoubleProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean increment(K k) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean adjustValue(K k, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double adjustOrPutValue(K k, double d, double d2) {
        throw new UnsupportedOperationException();
    }
}
