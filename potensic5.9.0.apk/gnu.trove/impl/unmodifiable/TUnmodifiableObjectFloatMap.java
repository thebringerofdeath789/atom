package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TObjectFloatIterator;
import gnu.trove.map.TObjectFloatMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TObjectFloatProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TUnmodifiableObjectFloatMap<K> implements TObjectFloatMap<K>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TObjectFloatMap<K> f3713m;
    private transient Set<K> keySet = null;
    private transient TFloatCollection values = null;

    public TUnmodifiableObjectFloatMap(TObjectFloatMap<K> tObjectFloatMap) {
        Objects.requireNonNull(tObjectFloatMap);
        this.f3713m = tObjectFloatMap;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public int size() {
        return this.f3713m.size();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean isEmpty() {
        return this.f3713m.isEmpty();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean containsKey(Object obj) {
        return this.f3713m.containsKey(obj);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean containsValue(float f) {
        return this.f3713m.containsValue(f);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float get(Object obj) {
        return this.f3713m.get(obj);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float put(K k, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public void putAll(TObjectFloatMap<? extends K> tObjectFloatMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public void putAll(Map<? extends K, ? extends Float> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = Collections.unmodifiableSet(this.f3713m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public Object[] keys() {
        return this.f3713m.keys();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public K[] keys(K[] kArr) {
        return this.f3713m.keys(kArr);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public TFloatCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3713m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float[] values() {
        return this.f3713m.values();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float[] values(float[] fArr) {
        return this.f3713m.values(fArr);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean equals(Object obj) {
        return obj == this || this.f3713m.equals(obj);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public int hashCode() {
        return this.f3713m.hashCode();
    }

    public String toString() {
        return this.f3713m.toString();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float getNoEntryValue() {
        return this.f3713m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return this.f3713m.forEachKey(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        return this.f3713m.forEachValue(tFloatProcedure);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean forEachEntry(TObjectFloatProcedure<? super K> tObjectFloatProcedure) {
        return this.f3713m.forEachEntry(tObjectFloatProcedure);
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public TObjectFloatIterator<K> iterator() {
        return new TObjectFloatIterator<K>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableObjectFloatMap.1
            TObjectFloatIterator<K> iter;

            {
                this.iter = TUnmodifiableObjectFloatMap.this.f3713m.iterator();
            }

            @Override // gnu.trove.iterator.TObjectFloatIterator
            public K key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TObjectFloatIterator
            public float value() {
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

            @Override // gnu.trove.iterator.TObjectFloatIterator
            public float setValue(float f) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float putIfAbsent(K k, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean retainEntries(TObjectFloatProcedure<? super K> tObjectFloatProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean increment(K k) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public boolean adjustValue(K k, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectFloatMap
    public float adjustOrPutValue(K k, float f, float f2) {
        throw new UnsupportedOperationException();
    }
}