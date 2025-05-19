package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TFloatObjectIterator;
import gnu.trove.map.TFloatObjectMap;
import gnu.trove.procedure.TFloatObjectProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TFloatSet;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableFloatObjectMap<V> implements TFloatObjectMap<V>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TFloatObjectMap<V> m;
    private transient TFloatSet keySet = null;
    private transient Collection<V> values = null;

    public TUnmodifiableFloatObjectMap(TFloatObjectMap<V> tFloatObjectMap) {
        Objects.requireNonNull(tFloatObjectMap);
        this.m = tFloatObjectMap;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean containsKey(float f) {
        return this.m.containsKey(f);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean containsValue(Object obj) {
        return this.m.containsValue(obj);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V get(float f) {
        return this.m.get(f);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V put(float f, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V remove(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public void putAll(TFloatObjectMap<? extends V> tFloatObjectMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public void putAll(Map<? extends Float, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public TFloatSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public float[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public float[] keys(float[] fArr) {
        return this.m.keys(fArr);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public Collection<V> valueCollection() {
        if (this.values == null) {
            this.values = Collections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public Object[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V[] values(V[] vArr) {
        return this.m.values(vArr);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean equals(Object obj) {
        return obj == this || this.m.equals(obj);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public int hashCode() {
        return this.m.hashCode();
    }

    public String toString() {
        return this.m.toString();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public float getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return this.m.forEachKey(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        return this.m.forEachValue(tObjectProcedure);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean forEachEntry(TFloatObjectProcedure<? super V> tFloatObjectProcedure) {
        return this.m.forEachEntry(tFloatObjectProcedure);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public TFloatObjectIterator<V> iterator() {
        return new TFloatObjectIterator<V>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableFloatObjectMap.1
            TFloatObjectIterator<V> iter;

            {
                this.iter = TUnmodifiableFloatObjectMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TFloatObjectIterator
            public float key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TFloatObjectIterator
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

            @Override // gnu.trove.iterator.TFloatObjectIterator
            public V setValue(V v) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V putIfAbsent(float f, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean retainEntries(TFloatObjectProcedure<? super V> tFloatObjectProcedure) {
        throw new UnsupportedOperationException();
    }
}
