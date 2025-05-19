package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TIntObjectIterator;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.procedure.TIntObjectProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TIntSet;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableIntObjectMap<V> implements TIntObjectMap<V>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TIntObjectMap<V> m;
    private transient TIntSet keySet = null;
    private transient Collection<V> values = null;

    public TUnmodifiableIntObjectMap(TIntObjectMap<V> tIntObjectMap) {
        Objects.requireNonNull(tIntObjectMap);
        this.m = tIntObjectMap;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean containsKey(int i) {
        return this.m.containsKey(i);
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean containsValue(Object obj) {
        return this.m.containsValue(obj);
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V get(int i) {
        return this.m.get(i);
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V put(int i, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public void putAll(TIntObjectMap<? extends V> tIntObjectMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public void putAll(Map<? extends Integer, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public TIntSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int[] keys(int[] iArr) {
        return this.m.keys(iArr);
    }

    @Override // gnu.trove.map.TIntObjectMap
    public Collection<V> valueCollection() {
        if (this.values == null) {
            this.values = Collections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TIntObjectMap
    public Object[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V[] values(V[] vArr) {
        return this.m.values(vArr);
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean equals(Object obj) {
        return obj == this || this.m.equals(obj);
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int hashCode() {
        return this.m.hashCode();
    }

    public String toString() {
        return this.m.toString();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public int getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        return this.m.forEachKey(tIntProcedure);
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        return this.m.forEachValue(tObjectProcedure);
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean forEachEntry(TIntObjectProcedure<? super V> tIntObjectProcedure) {
        return this.m.forEachEntry(tIntObjectProcedure);
    }

    @Override // gnu.trove.map.TIntObjectMap
    public TIntObjectIterator<V> iterator() {
        return new TIntObjectIterator<V>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableIntObjectMap.1
            TIntObjectIterator<V> iter;

            {
                this.iter = TUnmodifiableIntObjectMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TIntObjectIterator
            public int key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TIntObjectIterator
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

            @Override // gnu.trove.iterator.TIntObjectIterator
            public V setValue(V v) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TIntObjectMap
    public V putIfAbsent(int i, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntObjectMap
    public boolean retainEntries(TIntObjectProcedure<? super V> tIntObjectProcedure) {
        throw new UnsupportedOperationException();
    }
}
