package gnu.trove.impl.unmodifiable;

import gnu.trove.TByteCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TObjectByteIterator;
import gnu.trove.map.TObjectByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TObjectByteProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TUnmodifiableObjectByteMap<K> implements TObjectByteMap<K>, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TObjectByteMap<K> m;
    private transient Set<K> keySet = null;
    private transient TByteCollection values = null;

    public TUnmodifiableObjectByteMap(TObjectByteMap<K> tObjectByteMap) {
        Objects.requireNonNull(tObjectByteMap);
        this.m = tObjectByteMap;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean containsKey(Object obj) {
        return this.m.containsKey(obj);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean containsValue(byte b) {
        return this.m.containsValue(b);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte get(Object obj) {
        return this.m.get(obj);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte put(K k, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public void putAll(TObjectByteMap<? extends K> tObjectByteMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public void putAll(Map<? extends K, ? extends Byte> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = Collections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public Object[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public K[] keys(K[] kArr) {
        return this.m.keys(kArr);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public TByteCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte[] values(byte[] bArr) {
        return this.m.values(bArr);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean equals(Object obj) {
        return obj == this || this.m.equals(obj);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public int hashCode() {
        return this.m.hashCode();
    }

    public String toString() {
        return this.m.toString();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return this.m.forEachKey(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        return this.m.forEachValue(tByteProcedure);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean forEachEntry(TObjectByteProcedure<? super K> tObjectByteProcedure) {
        return this.m.forEachEntry(tObjectByteProcedure);
    }

    @Override // gnu.trove.map.TObjectByteMap
    public TObjectByteIterator<K> iterator() {
        return new TObjectByteIterator<K>() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableObjectByteMap.1
            TObjectByteIterator<K> iter;

            {
                this.iter = TUnmodifiableObjectByteMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TObjectByteIterator
            public K key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TObjectByteIterator
            public byte value() {
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

            @Override // gnu.trove.iterator.TObjectByteIterator
            public byte setValue(byte b) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte putIfAbsent(K k, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public void transformValues(TByteFunction tByteFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean retainEntries(TObjectByteProcedure<? super K> tObjectByteProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean increment(K k) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public boolean adjustValue(K k, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TObjectByteMap
    public byte adjustOrPutValue(K k, byte b, byte b2) {
        throw new UnsupportedOperationException();
    }
}
