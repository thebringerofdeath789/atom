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

    /* renamed from: m */
    private final TFloatObjectMap<V> f3688m;
    private transient TFloatSet keySet = null;
    private transient Collection<V> values = null;

    public TUnmodifiableFloatObjectMap(TFloatObjectMap<V> tFloatObjectMap) {
        Objects.requireNonNull(tFloatObjectMap);
        this.f3688m = tFloatObjectMap;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public int size() {
        return this.f3688m.size();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean isEmpty() {
        return this.f3688m.isEmpty();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean containsKey(float f) {
        return this.f3688m.containsKey(f);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean containsValue(Object obj) {
        return this.f3688m.containsValue(obj);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V get(float f) {
        return this.f3688m.get(f);
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
            this.keySet = TCollections.unmodifiableSet(this.f3688m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public float[] keys() {
        return this.f3688m.keys();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public float[] keys(float[] fArr) {
        return this.f3688m.keys(fArr);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public Collection<V> valueCollection() {
        if (this.values == null) {
            this.values = Collections.unmodifiableCollection(this.f3688m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public Object[] values() {
        return this.f3688m.values();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public V[] values(V[] vArr) {
        return this.f3688m.values(vArr);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean equals(Object obj) {
        return obj == this || this.f3688m.equals(obj);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public int hashCode() {
        return this.f3688m.hashCode();
    }

    public String toString() {
        return this.f3688m.toString();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public float getNoEntryKey() {
        return this.f3688m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return this.f3688m.forEachKey(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        return this.f3688m.forEachValue(tObjectProcedure);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public boolean forEachEntry(TFloatObjectProcedure<? super V> tFloatObjectProcedure) {
        return this.f3688m.forEachEntry(tFloatObjectProcedure);
    }

    @Override // gnu.trove.map.TFloatObjectMap
    public TFloatObjectIterator<V> iterator() {
        return new TFloatObjectIterator<V>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableFloatObjectMap.1
            TFloatObjectIterator<V> iter;

            {
                this.iter = TUnmodifiableFloatObjectMap.this.f3688m.iterator();
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