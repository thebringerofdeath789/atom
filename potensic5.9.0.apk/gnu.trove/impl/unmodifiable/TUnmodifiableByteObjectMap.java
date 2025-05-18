package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.function.TObjectFunction;
import gnu.trove.iterator.TByteObjectIterator;
import gnu.trove.map.TByteObjectMap;
import gnu.trove.procedure.TByteObjectProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TObjectProcedure;
import gnu.trove.set.TByteSet;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableByteObjectMap<V> implements TByteObjectMap<V>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TByteObjectMap<V> f3658m;
    private transient TByteSet keySet = null;
    private transient Collection<V> values = null;

    public TUnmodifiableByteObjectMap(TByteObjectMap<V> tByteObjectMap) {
        Objects.requireNonNull(tByteObjectMap);
        this.f3658m = tByteObjectMap;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public int size() {
        return this.f3658m.size();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean isEmpty() {
        return this.f3658m.isEmpty();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean containsKey(byte b) {
        return this.f3658m.containsKey(b);
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean containsValue(Object obj) {
        return this.f3658m.containsValue(obj);
    }

    @Override // gnu.trove.map.TByteObjectMap
    public V get(byte b) {
        return this.f3658m.get(b);
    }

    @Override // gnu.trove.map.TByteObjectMap
    public V put(byte b, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public V remove(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public void putAll(TByteObjectMap<? extends V> tByteObjectMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public void putAll(Map<? extends Byte, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public TByteSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3658m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public byte[] keys() {
        return this.f3658m.keys();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public byte[] keys(byte[] bArr) {
        return this.f3658m.keys(bArr);
    }

    @Override // gnu.trove.map.TByteObjectMap
    public Collection<V> valueCollection() {
        if (this.values == null) {
            this.values = Collections.unmodifiableCollection(this.f3658m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TByteObjectMap
    public Object[] values() {
        return this.f3658m.values();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public V[] values(V[] vArr) {
        return this.f3658m.values(vArr);
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean equals(Object obj) {
        return obj == this || this.f3658m.equals(obj);
    }

    @Override // gnu.trove.map.TByteObjectMap
    public int hashCode() {
        return this.f3658m.hashCode();
    }

    public String toString() {
        return this.f3658m.toString();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public byte getNoEntryKey() {
        return this.f3658m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return this.f3658m.forEachKey(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean forEachValue(TObjectProcedure<? super V> tObjectProcedure) {
        return this.f3658m.forEachValue(tObjectProcedure);
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean forEachEntry(TByteObjectProcedure<? super V> tByteObjectProcedure) {
        return this.f3658m.forEachEntry(tByteObjectProcedure);
    }

    @Override // gnu.trove.map.TByteObjectMap
    public TByteObjectIterator<V> iterator() {
        return new TByteObjectIterator<V>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableByteObjectMap.1
            TByteObjectIterator<V> iter;

            {
                this.iter = TUnmodifiableByteObjectMap.this.f3658m.iterator();
            }

            @Override // gnu.trove.iterator.TByteObjectIterator
            public byte key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TByteObjectIterator
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

            @Override // gnu.trove.iterator.TByteObjectIterator
            public V setValue(V v) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TByteObjectMap
    public V putIfAbsent(byte b, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteObjectMap
    public boolean retainEntries(TByteObjectProcedure<? super V> tByteObjectProcedure) {
        throw new UnsupportedOperationException();
    }
}