package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TObjectShortIterator;
import gnu.trove.map.TObjectShortMap;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.procedure.TObjectShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TUnmodifiableObjectShortMap<K> implements TObjectShortMap<K>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TObjectShortMap<K> m;
    private transient Set<K> keySet = null;
    private transient TShortCollection values = null;

    public TUnmodifiableObjectShortMap(TObjectShortMap<K> tObjectShortMap) {
        Objects.requireNonNull(tObjectShortMap);
        this.m = tObjectShortMap;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean containsKey(Object obj) {
        return this.m.containsKey(obj);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean containsValue(short s) {
        return this.m.containsValue(s);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short get(Object obj) {
        return this.m.get(obj);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short put(K k, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public void putAll(TObjectShortMap<? extends K> tObjectShortMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public void putAll(Map<? extends K, ? extends Short> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = Collections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public Object[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public K[] keys(K[] kArr) {
        return this.m.keys(kArr);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public TShortCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short[] values(short[] sArr) {
        return this.m.values(sArr);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean equals(Object obj) {
        return obj == this || this.m.equals(obj);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public int hashCode() {
        return this.m.hashCode();
    }

    public String toString() {
        return this.m.toString();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return this.m.forEachKey(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        return this.m.forEachValue(tShortProcedure);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean forEachEntry(TObjectShortProcedure<? super K> tObjectShortProcedure) {
        return this.m.forEachEntry(tObjectShortProcedure);
    }

    @Override // gnu.trove.map.TObjectShortMap
    public TObjectShortIterator<K> iterator() {
        return new TObjectShortIterator<K>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableObjectShortMap.1
            TObjectShortIterator<K> iter;

            {
                this.iter = TUnmodifiableObjectShortMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TObjectShortIterator
            public K key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TObjectShortIterator
            public short value() {
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

            @Override // gnu.trove.iterator.TObjectShortIterator
            public short setValue(short s) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short putIfAbsent(K k, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public void transformValues(TShortFunction tShortFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean retainEntries(TObjectShortProcedure<? super K> tObjectShortProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean increment(K k) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public boolean adjustValue(K k, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectShortMap
    public short adjustOrPutValue(K k, short s, short s2) {
        throw new UnsupportedOperationException();
    }
}
