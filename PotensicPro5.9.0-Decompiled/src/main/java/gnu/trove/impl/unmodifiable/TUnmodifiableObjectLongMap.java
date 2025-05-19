package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TObjectLongIterator;
import gnu.trove.map.TObjectLongMap;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TObjectLongProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TUnmodifiableObjectLongMap<K> implements TObjectLongMap<K>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TObjectLongMap<K> m;
    private transient Set<K> keySet = null;
    private transient TLongCollection values = null;

    public TUnmodifiableObjectLongMap(TObjectLongMap<K> tObjectLongMap) {
        Objects.requireNonNull(tObjectLongMap);
        this.m = tObjectLongMap;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean containsKey(Object obj) {
        return this.m.containsKey(obj);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean containsValue(long j) {
        return this.m.containsValue(j);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long get(Object obj) {
        return this.m.get(obj);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long put(K k, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public void putAll(TObjectLongMap<? extends K> tObjectLongMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public void putAll(Map<? extends K, ? extends Long> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = Collections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public Object[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public K[] keys(K[] kArr) {
        return this.m.keys(kArr);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public TLongCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long[] values(long[] jArr) {
        return this.m.values(jArr);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean equals(Object obj) {
        return obj == this || this.m.equals(obj);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public int hashCode() {
        return this.m.hashCode();
    }

    public String toString() {
        return this.m.toString();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return this.m.forEachKey(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        return this.m.forEachValue(tLongProcedure);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean forEachEntry(TObjectLongProcedure<? super K> tObjectLongProcedure) {
        return this.m.forEachEntry(tObjectLongProcedure);
    }

    @Override // gnu.trove.map.TObjectLongMap
    public TObjectLongIterator<K> iterator() {
        return new TObjectLongIterator<K>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableObjectLongMap.1
            TObjectLongIterator<K> iter;

            {
                this.iter = TUnmodifiableObjectLongMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TObjectLongIterator
            public K key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TObjectLongIterator
            public long value() {
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

            @Override // gnu.trove.iterator.TObjectLongIterator
            public long setValue(long j) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long putIfAbsent(K k, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public void transformValues(TLongFunction tLongFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean retainEntries(TObjectLongProcedure<? super K> tObjectLongProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean increment(K k) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public boolean adjustValue(K k, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectLongMap
    public long adjustOrPutValue(K k, long j, long j2) {
        throw new UnsupportedOperationException();
    }
}
