package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TDoubleObjectIterator;
import gnu.trove.map.TDoubleObjectMap;
import gnu.trove.procedure.TDoubleObjectProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableDoubleObjectMap<V> implements TDoubleObjectMap<V>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TDoubleObjectMap<V> f3678m;
    private transient TDoubleSet keySet = null;
    private transient Collection<V> values = null;

    public TUnmodifiableDoubleObjectMap(TDoubleObjectMap<V> tDoubleObjectMap) {
        Objects.requireNonNull(tDoubleObjectMap);
        this.f3678m = tDoubleObjectMap;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public int size() {
        return this.f3678m.size();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean isEmpty() {
        return this.f3678m.isEmpty();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean containsKey(double d) {
        return this.f3678m.containsKey(d);
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean containsValue(Object obj) {
        return this.f3678m.containsValue(obj);
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public V get(double d) {
        return this.f3678m.get(d);
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public V put(double d, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public V remove(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public void putAll(TDoubleObjectMap<? extends V> tDoubleObjectMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public void putAll(Map<? extends Double, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public TDoubleSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3678m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public double[] keys() {
        return this.f3678m.keys();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public double[] keys(double[] dArr) {
        return this.f3678m.keys(dArr);
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public Collection<V> valueCollection() {
        if (this.values == null) {
            this.values = Collections.unmodifiableCollection(this.f3678m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public Object[] values() {
        return this.f3678m.values();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public V[] values(V[] vArr) {
        return this.f3678m.values(vArr);
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean equals(Object obj) {
        return obj == this || this.f3678m.equals(obj);
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public int hashCode() {
        return this.f3678m.hashCode();
    }

    public String toString() {
        return this.f3678m.toString();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public double getNoEntryKey() {
        return this.f3678m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        return this.f3678m.forEachKey(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        return this.f3678m.forEachValue(tObjectProcedure);
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean forEachEntry(TDoubleObjectProcedure<? super V> tDoubleObjectProcedure) {
        return this.f3678m.forEachEntry(tDoubleObjectProcedure);
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public TDoubleObjectIterator<V> iterator() {
        return new TDoubleObjectIterator<V>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableDoubleObjectMap.1
            TDoubleObjectIterator<V> iter;

            {
                this.iter = TUnmodifiableDoubleObjectMap.this.f3678m.iterator();
            }

            @Override // gnu.trove.iterator.TDoubleObjectIterator
            public double key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TDoubleObjectIterator
            public V value() {
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

            @Override // gnu.trove.iterator.TDoubleObjectIterator
            public V setValue(V v) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public V putIfAbsent(double d, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleObjectMap
    public boolean retainEntries(TDoubleObjectProcedure<? super V> tDoubleObjectProcedure) {
        throw new UnsupportedOperationException();
    }
}