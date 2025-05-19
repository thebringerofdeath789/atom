package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TObjectIntIterator;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TObjectIntProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TUnmodifiableObjectIntMap<K> implements TObjectIntMap<K>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TObjectIntMap<K> m;
    private transient Set<K> keySet = null;
    private transient TIntCollection values = null;

    public TUnmodifiableObjectIntMap(TObjectIntMap<K> tObjectIntMap) {
        Objects.requireNonNull(tObjectIntMap);
        this.m = tObjectIntMap;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean containsKey(Object obj) {
        return this.m.containsKey(obj);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean containsValue(int i) {
        return this.m.containsValue(i);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int get(Object obj) {
        return this.m.get(obj);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int put(K k, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void putAll(TObjectIntMap<? extends K> tObjectIntMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void putAll(Map<? extends K, ? extends Integer> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = Collections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public Object[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public K[] keys(K[] kArr) {
        return this.m.keys(kArr);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public TIntCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int[] values(int[] iArr) {
        return this.m.values(iArr);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean equals(Object obj) {
        return obj == this || this.m.equals(obj);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int hashCode() {
        return this.m.hashCode();
    }

    public String toString() {
        return this.m.toString();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return this.m.forEachKey(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        return this.m.forEachValue(tIntProcedure);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean forEachEntry(TObjectIntProcedure<? super K> tObjectIntProcedure) {
        return this.m.forEachEntry(tObjectIntProcedure);
    }

    @Override // gnu.trove.map.TObjectIntMap
    public TObjectIntIterator<K> iterator() {
        return new TObjectIntIterator<K>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableObjectIntMap.1
            TObjectIntIterator<K> iter;

            {
                this.iter = TUnmodifiableObjectIntMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TObjectIntIterator
            public K key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TObjectIntIterator
            public int value() {
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

            @Override // gnu.trove.iterator.TObjectIntIterator
            public int setValue(int i) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int putIfAbsent(K k, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public void transformValues(TIntFunction tIntFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean retainEntries(TObjectIntProcedure<? super K> tObjectIntProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean increment(K k) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public boolean adjustValue(K k, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectIntMap
    public int adjustOrPutValue(K k, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
