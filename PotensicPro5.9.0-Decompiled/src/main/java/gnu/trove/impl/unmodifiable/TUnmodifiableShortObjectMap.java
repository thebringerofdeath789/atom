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
    private final TShortObjectMap<V> m;
    private transient TShortSet keySet = null;
    private transient Collection<V> values = null;

    public TUnmodifiableShortObjectMap(TShortObjectMap<V> tShortObjectMap) {
        Objects.requireNonNull(tShortObjectMap);
        this.m = tShortObjectMap;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean containsKey(short s) {
        return this.m.containsKey(s);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean containsValue(Object obj) {
        return this.m.containsValue(obj);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V get(short s) {
        return this.m.get(s);
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
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public short[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public short[] keys(short[] sArr) {
        return this.m.keys(sArr);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public Collection<V> valueCollection() {
        if (this.values == null) {
            this.values = Collections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TShortObjectMap
    public Object[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public V[] values(V[] vArr) {
        return this.m.values(vArr);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean equals(Object obj) {
        return obj == this || this.m.equals(obj);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public int hashCode() {
        return this.m.hashCode();
    }

    public String toString() {
        return this.m.toString();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public short getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return this.m.forEachKey(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        return this.m.forEachValue(tObjectProcedure);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public boolean forEachEntry(TShortObjectProcedure<? super V> tShortObjectProcedure) {
        return this.m.forEachEntry(tShortObjectProcedure);
    }

    @Override // gnu.trove.map.TShortObjectMap
    public TShortObjectIterator<V> iterator() {
        return new TShortObjectIterator<V>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableShortObjectMap.1
            TShortObjectIterator<V> iter;

            {
                this.iter = TUnmodifiableShortObjectMap.this.m.iterator();
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
