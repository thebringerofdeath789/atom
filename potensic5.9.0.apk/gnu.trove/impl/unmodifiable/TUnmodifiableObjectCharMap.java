package gnu.trove.impl.unmodifiable;

import gnu.trove.TCharCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TObjectCharIterator;
import gnu.trove.map.TObjectCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TObjectCharProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TUnmodifiableObjectCharMap<K> implements TObjectCharMap<K>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TObjectCharMap<K> f3711m;
    private transient Set<K> keySet = null;
    private transient TCharCollection values = null;

    public TUnmodifiableObjectCharMap(TObjectCharMap<K> tObjectCharMap) {
        Objects.requireNonNull(tObjectCharMap);
        this.f3711m = tObjectCharMap;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public int size() {
        return this.f3711m.size();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean isEmpty() {
        return this.f3711m.isEmpty();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean containsKey(Object obj) {
        return this.f3711m.containsKey(obj);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean containsValue(char c) {
        return this.f3711m.containsValue(c);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char get(Object obj) {
        return this.f3711m.get(obj);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char put(K k, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public void putAll(TObjectCharMap<? extends K> tObjectCharMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public void putAll(Map<? extends K, ? extends Character> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = Collections.unmodifiableSet(this.f3711m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public Object[] keys() {
        return this.f3711m.keys();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public K[] keys(K[] kArr) {
        return this.f3711m.keys(kArr);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public TCharCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3711m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char[] values() {
        return this.f3711m.values();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char[] values(char[] cArr) {
        return this.f3711m.values(cArr);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean equals(Object obj) {
        return obj == this || this.f3711m.equals(obj);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public int hashCode() {
        return this.f3711m.hashCode();
    }

    public String toString() {
        return this.f3711m.toString();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char getNoEntryValue() {
        return this.f3711m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return this.f3711m.forEachKey(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        return this.f3711m.forEachValue(tCharProcedure);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean forEachEntry(TObjectCharProcedure<? super K> tObjectCharProcedure) {
        return this.f3711m.forEachEntry(tObjectCharProcedure);
    }

    @Override // gnu.trove.map.TObjectCharMap
    public TObjectCharIterator<K> iterator() {
        return new TObjectCharIterator<K>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableObjectCharMap.1
            TObjectCharIterator<K> iter;

            {
                this.iter = TUnmodifiableObjectCharMap.this.f3711m.iterator();
            }

            @Override // gnu.trove.iterator.TObjectCharIterator
            public K key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TObjectCharIterator
            public char value() {
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

            @Override // gnu.trove.iterator.TObjectCharIterator
            public char setValue(char c) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char putIfAbsent(K k, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public void transformValues(TCharFunction tCharFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean retainEntries(TObjectCharProcedure<? super K> tObjectCharProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean increment(K k) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public boolean adjustValue(K k, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectCharMap
    public char adjustOrPutValue(K k, char c, char c2) {
        throw new UnsupportedOperationException();
    }
}