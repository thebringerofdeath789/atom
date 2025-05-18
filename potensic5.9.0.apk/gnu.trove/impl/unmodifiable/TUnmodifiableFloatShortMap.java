package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TFloatShortIterator;
import gnu.trove.map.TFloatShortMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TFloatShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TFloatSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableFloatShortMap implements TFloatShortMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TFloatShortMap f3689m;
    private transient TFloatSet keySet = null;
    private transient TShortCollection values = null;

    public TUnmodifiableFloatShortMap(TFloatShortMap tFloatShortMap) {
        Objects.requireNonNull(tFloatShortMap);
        this.f3689m = tFloatShortMap;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public int size() {
        return this.f3689m.size();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean isEmpty() {
        return this.f3689m.isEmpty();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean containsKey(float f) {
        return this.f3689m.containsKey(f);
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean containsValue(short s) {
        return this.f3689m.containsValue(s);
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short get(float f) {
        return this.f3689m.get(f);
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short put(float f, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short remove(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public void putAll(TFloatShortMap tFloatShortMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public void putAll(Map<? extends Float, ? extends Short> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public TFloatSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3689m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public float[] keys() {
        return this.f3689m.keys();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public float[] keys(float[] fArr) {
        return this.f3689m.keys(fArr);
    }

    @Override // gnu.trove.map.TFloatShortMap
    public TShortCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3689m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short[] values() {
        return this.f3689m.values();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short[] values(short[] sArr) {
        return this.f3689m.values(sArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3689m.equals(obj);
    }

    public int hashCode() {
        return this.f3689m.hashCode();
    }

    public String toString() {
        return this.f3689m.toString();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public float getNoEntryKey() {
        return this.f3689m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short getNoEntryValue() {
        return this.f3689m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return this.f3689m.forEachKey(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        return this.f3689m.forEachValue(tShortProcedure);
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean forEachEntry(TFloatShortProcedure tFloatShortProcedure) {
        return this.f3689m.forEachEntry(tFloatShortProcedure);
    }

    @Override // gnu.trove.map.TFloatShortMap
    public TFloatShortIterator iterator() {
        return new TFloatShortIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableFloatShortMap.1
            TFloatShortIterator iter;

            {
                this.iter = TUnmodifiableFloatShortMap.this.f3689m.iterator();
            }

            @Override // gnu.trove.iterator.TFloatShortIterator
            public float key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TFloatShortIterator
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

            @Override // gnu.trove.iterator.TFloatShortIterator
            public short setValue(short s) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short putIfAbsent(float f, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public void transformValues(TShortFunction tShortFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean retainEntries(TFloatShortProcedure tFloatShortProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean increment(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public boolean adjustValue(float f, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatShortMap
    public short adjustOrPutValue(float f, short s, short s2) {
        throw new UnsupportedOperationException();
    }
}