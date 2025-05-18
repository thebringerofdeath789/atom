package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TShortObjectIterator;
import gnu.trove.map.TShortObjectMap;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.procedure.TShortObjectProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableShortObjectMap<V> implements TShortObjectMap<V>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TShortObjectMap<V> f3725m;
    private transient TShortSet keySet = null;
    private transient Collection<V> values = null;

    public TUnmodifiableShortObjectMap(TShortObjectMap<V> tShortObjectMap) {
        Objects.requireNonNull(tShortObjectMap);
        this.f3725m = tShortObjectMap;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public int size() {
        return this.f3725m.size();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean isEmpty() {
        return this.f3725m.isEmpty();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean containsKey(short s) {
        return this.f3725m.containsKey(s);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean containsValue(Object obj) {
        return this.f3725m.containsValue(obj);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V get(short s) {
        return this.f3725m.get(s);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V put(short s, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V remove(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public void putAll(TShortObjectMap<? extends V> tShortObjectMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public void putAll(Map<? extends Short, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public TShortSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3725m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public short[] keys() {
        return this.f3725m.keys();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public short[] keys(short[] sArr) {
        return this.f3725m.keys(sArr);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public Collection<V> valueCollection() {
        if (this.values == null) {
            this.values = Collections.unmodifiableCollection(this.f3725m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public Object[] values() {
        return this.f3725m.values();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V[] values(V[] vArr) {
        return this.f3725m.values(vArr);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean equals(Object obj) {
        return obj == this || this.f3725m.equals(obj);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public int hashCode() {
        return this.f3725m.hashCode();
    }

    public String toString() {
        return this.f3725m.toString();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public short getNoEntryKey() {
        return this.f3725m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return this.f3725m.forEachKey(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        return this.f3725m.forEachValue(tObjectProcedure);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean forEachEntry(TShortObjectProcedure<? super V> tShortObjectProcedure) {
        return this.f3725m.forEachEntry(tShortObjectProcedure);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public TShortObjectIterator<V> iterator() {
        return new TShortObjectIterator<V>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableShortObjectMap.1
            TShortObjectIterator<V> iter;

            {
                this.iter = TUnmodifiableShortObjectMap.this.f3725m.iterator();
            }

            @Override // gnu.trove.iterator.TShortObjectIterator
            public short key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TShortObjectIterator
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

            @Override // gnu.trove.iterator.TShortObjectIterator
            public V setValue(V v) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V putIfAbsent(short s, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean retainEntries(TShortObjectProcedure<? super V> tShortObjectProcedure) {
        throw new UnsupportedOperationException();
    }
}