package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TCharFloatIterator;
import gnu.trove.map.TCharFloatMap;
import gnu.trove.procedure.TCharFloatProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TCharSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableCharFloatMap implements TCharFloatMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TCharFloatMap f3665m;
    private transient TCharSet keySet = null;
    private transient TFloatCollection values = null;

    public TUnmodifiableCharFloatMap(TCharFloatMap tCharFloatMap) {
        Objects.requireNonNull(tCharFloatMap);
        this.f3665m = tCharFloatMap;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public int size() {
        return this.f3665m.size();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean isEmpty() {
        return this.f3665m.isEmpty();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean containsKey(char c) {
        return this.f3665m.containsKey(c);
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean containsValue(float f) {
        return this.f3665m.containsValue(f);
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float get(char c) {
        return this.f3665m.get(c);
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float put(char c, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float remove(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public void putAll(TCharFloatMap tCharFloatMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public void putAll(Map<? extends Character, ? extends Float> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public TCharSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3665m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public char[] keys() {
        return this.f3665m.keys();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public char[] keys(char[] cArr) {
        return this.f3665m.keys(cArr);
    }

    @Override // gnu.trove.map.TCharFloatMap
    public TFloatCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3665m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float[] values() {
        return this.f3665m.values();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float[] values(float[] fArr) {
        return this.f3665m.values(fArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3665m.equals(obj);
    }

    public int hashCode() {
        return this.f3665m.hashCode();
    }

    public String toString() {
        return this.f3665m.toString();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public char getNoEntryKey() {
        return this.f3665m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float getNoEntryValue() {
        return this.f3665m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        return this.f3665m.forEachKey(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        return this.f3665m.forEachValue(tFloatProcedure);
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean forEachEntry(TCharFloatProcedure tCharFloatProcedure) {
        return this.f3665m.forEachEntry(tCharFloatProcedure);
    }

    @Override // gnu.trove.map.TCharFloatMap
    public TCharFloatIterator iterator() {
        return new TCharFloatIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableCharFloatMap.1
            TCharFloatIterator iter;

            {
                this.iter = TUnmodifiableCharFloatMap.this.f3665m.iterator();
            }

            @Override // gnu.trove.iterator.TCharFloatIterator
            public char key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TCharFloatIterator
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

            @Override // gnu.trove.iterator.TCharFloatIterator
            public float setValue(float f) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float putIfAbsent(char c, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean retainEntries(TCharFloatProcedure tCharFloatProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean increment(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean adjustValue(char c, float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float adjustOrPutValue(char c, float f, float f2) {
        throw new UnsupportedOperationException();
    }
}