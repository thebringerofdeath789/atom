package gnu.trove.impl.unmodifiable;

import gnu.trove.TByteCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TFloatByteIterator;
import gnu.trove.map.TFloatByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TFloatByteProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TFloatSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableFloatByteMap implements TFloatByteMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TFloatByteMap f3680m;
    private transient TFloatSet keySet = null;
    private transient TByteCollection values = null;

    public TUnmodifiableFloatByteMap(TFloatByteMap tFloatByteMap) {
        Objects.requireNonNull(tFloatByteMap);
        this.f3680m = tFloatByteMap;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public int size() {
        return this.f3680m.size();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean isEmpty() {
        return this.f3680m.isEmpty();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean containsKey(float f) {
        return this.f3680m.containsKey(f);
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean containsValue(byte b) {
        return this.f3680m.containsValue(b);
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte get(float f) {
        return this.f3680m.get(f);
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte put(float f, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte remove(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public void putAll(TFloatByteMap tFloatByteMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public void putAll(Map<? extends Float, ? extends Byte> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public TFloatSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3680m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public float[] keys() {
        return this.f3680m.keys();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public float[] keys(float[] fArr) {
        return this.f3680m.keys(fArr);
    }

    @Override // gnu.trove.map.TFloatByteMap
    public TByteCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3680m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte[] values() {
        return this.f3680m.values();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte[] values(byte[] bArr) {
        return this.f3680m.values(bArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3680m.equals(obj);
    }

    public int hashCode() {
        return this.f3680m.hashCode();
    }

    public String toString() {
        return this.f3680m.toString();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public float getNoEntryKey() {
        return this.f3680m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte getNoEntryValue() {
        return this.f3680m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return this.f3680m.forEachKey(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        return this.f3680m.forEachValue(tByteProcedure);
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean forEachEntry(TFloatByteProcedure tFloatByteProcedure) {
        return this.f3680m.forEachEntry(tFloatByteProcedure);
    }

    @Override // gnu.trove.map.TFloatByteMap
    public TFloatByteIterator iterator() {
        return new TFloatByteIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableFloatByteMap.1
            TFloatByteIterator iter;

            {
                this.iter = TUnmodifiableFloatByteMap.this.f3680m.iterator();
            }

            @Override // gnu.trove.iterator.TFloatByteIterator
            public float key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TFloatByteIterator
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

            @Override // gnu.trove.iterator.TFloatByteIterator
            public byte setValue(byte b) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte putIfAbsent(float f, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public void transformValues(TByteFunction tByteFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean retainEntries(TFloatByteProcedure tFloatByteProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean increment(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public boolean adjustValue(float f, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatByteMap
    public byte adjustOrPutValue(float f, byte b, byte b2) {
        throw new UnsupportedOperationException();
    }
}