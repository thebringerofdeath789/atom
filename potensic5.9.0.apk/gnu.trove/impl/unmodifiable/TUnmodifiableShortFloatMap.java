package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TShortFloatIterator;
import gnu.trove.map.TShortFloatMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TShortFloatProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableShortFloatMap implements TShortFloatMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TShortFloatMap f3722m;
    private transient TShortSet keySet = null;
    private transient TFloatCollection values = null;

    public TUnmodifiableShortFloatMap(TShortFloatMap tShortFloatMap) {
        Objects.requireNonNull(tShortFloatMap);
        this.f3722m = tShortFloatMap;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public int size() {
        return this.f3722m.size();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean isEmpty() {
        return this.f3722m.isEmpty();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean containsKey(short s) {
        return this.f3722m.containsKey(s);
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean containsValue(float f) {
        return this.f3722m.containsValue(f);
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float get(short s) {
        return this.f3722m.get(s);
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float put(short s, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float remove(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public void putAll(TShortFloatMap tShortFloatMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public void putAll(Map<? extends Short, ? extends Float> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public TShortSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3722m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public short[] keys() {
        return this.f3722m.keys();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public short[] keys(short[] sArr) {
        return this.f3722m.keys(sArr);
    }

    @Override // gnu.trove.map.TShortFloatMap
    public TFloatCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3722m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float[] values() {
        return this.f3722m.values();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float[] values(float[] fArr) {
        return this.f3722m.values(fArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3722m.equals(obj);
    }

    public int hashCode() {
        return this.f3722m.hashCode();
    }

    public String toString() {
        return this.f3722m.toString();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public short getNoEntryKey() {
        return this.f3722m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float getNoEntryValue() {
        return this.f3722m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return this.f3722m.forEachKey(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        return this.f3722m.forEachValue(tFloatProcedure);
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean forEachEntry(TShortFloatProcedure tShortFloatProcedure) {
        return this.f3722m.forEachEntry(tShortFloatProcedure);
    }

    @Override // gnu.trove.map.TShortFloatMap
    public TShortFloatIterator iterator() {
        return new TShortFloatIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableShortFloatMap.1
            TShortFloatIterator iter;

            {
                this.iter = TUnmodifiableShortFloatMap.this.f3722m.iterator();
            }

            @Override // gnu.trove.iterator.TShortFloatIterator
            public short key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TShortFloatIterator
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

            @Override // gnu.trove.iterator.TShortFloatIterator
            public float setValue(float f) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float putIfAbsent(short s, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean retainEntries(TShortFloatProcedure tShortFloatProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean increment(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean adjustValue(short s, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float adjustOrPutValue(short s, float f, float f2) {
        throw new UnsupportedOperationException();
    }
}