package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TCharObjectIterator;
import gnu.trove.map.TCharObjectMap;
import gnu.trove.procedure.TCharObjectProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TCharSet;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableCharObjectMap<V> implements TCharObjectMap<V>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TCharObjectMap<V> m;
    private transient TCharSet keySet = null;
    private transient Collection<V> values = null;

    public TUnmodifiableCharObjectMap(TCharObjectMap<V> tCharObjectMap) {
        Objects.requireNonNull(tCharObjectMap);
        this.m = tCharObjectMap;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean containsKey(char c) {
        return this.m.containsKey(c);
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean containsValue(Object obj) {
        return this.m.containsValue(obj);
    }

    @Override // gnu.trove.map.TCharObjectMap
    public V get(char c) {
        return this.m.get(c);
    }

    @Override // gnu.trove.map.TCharObjectMap
    public V put(char c, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public V remove(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public void putAll(TCharObjectMap<? extends V> tCharObjectMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public void putAll(Map<? extends Character, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public TCharSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public char[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public char[] keys(char[] cArr) {
        return this.m.keys(cArr);
    }

    @Override // gnu.trove.map.TCharObjectMap
    public Collection<V> valueCollection() {
        if (this.values == null) {
            this.values = Collections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TCharObjectMap
    public Object[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public V[] values(V[] vArr) {
        return this.m.values(vArr);
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean equals(Object obj) {
        return obj == this || this.m.equals(obj);
    }

    @Override // gnu.trove.map.TCharObjectMap
    public int hashCode() {
        return this.m.hashCode();
    }

    public String toString() {
        return this.m.toString();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public char getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        return this.m.forEachKey(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        return this.m.forEachValue(tObjectProcedure);
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean forEachEntry(TCharObjectProcedure<? super V> tCharObjectProcedure) {
        return this.m.forEachEntry(tCharObjectProcedure);
    }

    @Override // gnu.trove.map.TCharObjectMap
    public TCharObjectIterator<V> iterator() {
        return new TCharObjectIterator<V>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableCharObjectMap.1
            TCharObjectIterator<V> iter;

            {
                this.iter = TUnmodifiableCharObjectMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TCharObjectIterator
            public char key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TCharObjectIterator
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

            @Override // gnu.trove.iterator.TCharObjectIterator
            public V setValue(V v) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TCharObjectMap
    public V putIfAbsent(char c, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharObjectMap
    public boolean retainEntries(TCharObjectProcedure<? super V> tCharObjectProcedure) {
        throw new UnsupportedOperationException();
    }
}
