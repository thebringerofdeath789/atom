package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TByteFloatIterator;
import gnu.trove.map.TByteFloatMap;
import gnu.trove.procedure.TByteFloatProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TByteSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableByteFloatMap implements TByteFloatMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TByteFloatMap f3655m;
    private transient TByteSet keySet = null;
    private transient TFloatCollection values = null;

    public TUnmodifiableByteFloatMap(TByteFloatMap tByteFloatMap) {
        Objects.requireNonNull(tByteFloatMap);
        this.f3655m = tByteFloatMap;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public int size() {
        return this.f3655m.size();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean isEmpty() {
        return this.f3655m.isEmpty();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean containsKey(byte b) {
        return this.f3655m.containsKey(b);
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean containsValue(float f) {
        return this.f3655m.containsValue(f);
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float get(byte b) {
        return this.f3655m.get(b);
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float put(byte b, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float remove(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public void putAll(TByteFloatMap tByteFloatMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public void putAll(Map<? extends Byte, ? extends Float> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public TByteSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3655m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public byte[] keys() {
        return this.f3655m.keys();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public byte[] keys(byte[] bArr) {
        return this.f3655m.keys(bArr);
    }

    @Override // gnu.trove.map.TByteFloatMap
    public TFloatCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3655m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float[] values() {
        return this.f3655m.values();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float[] values(float[] fArr) {
        return this.f3655m.values(fArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3655m.equals(obj);
    }

    public int hashCode() {
        return this.f3655m.hashCode();
    }

    public String toString() {
        return this.f3655m.toString();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public byte getNoEntryKey() {
        return this.f3655m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float getNoEntryValue() {
        return this.f3655m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return this.f3655m.forEachKey(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        return this.f3655m.forEachValue(tFloatProcedure);
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean forEachEntry(TByteFloatProcedure tByteFloatProcedure) {
        return this.f3655m.forEachEntry(tByteFloatProcedure);
    }

    @Override // gnu.trove.map.TByteFloatMap
    public TByteFloatIterator iterator() {
        return new TByteFloatIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableByteFloatMap.1
            TByteFloatIterator iter;

            {
                this.iter = TUnmodifiableByteFloatMap.this.f3655m.iterator();
            }

            @Override // gnu.trove.iterator.TByteFloatIterator
            public byte key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TByteFloatIterator
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

            @Override // gnu.trove.iterator.TByteFloatIterator
            public float setValue(float f) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float putIfAbsent(byte b, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean retainEntries(TByteFloatProcedure tByteFloatProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean increment(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public boolean adjustValue(byte b, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteFloatMap
    public float adjustOrPutValue(byte b, float f, float f2) {
        throw new UnsupportedOperationException();
    }
}