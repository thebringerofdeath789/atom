package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TFloatIntIterator;
import gnu.trove.map.TFloatIntMap;
import gnu.trove.procedure.TFloatIntProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TFloatSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableFloatIntMap implements TFloatIntMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TFloatIntMap m;
    private transient TFloatSet keySet = null;
    private transient TIntCollection values = null;

    public TUnmodifiableFloatIntMap(TFloatIntMap tFloatIntMap) {
        Objects.requireNonNull(tFloatIntMap);
        this.m = tFloatIntMap;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean containsKey(float f) {
        return this.m.containsKey(f);
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean containsValue(int i) {
        return this.m.containsValue(i);
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int get(float f) {
        return this.m.get(f);
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int put(float f, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int remove(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void putAll(TFloatIntMap tFloatIntMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void putAll(Map<? extends Float, ? extends Integer> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public TFloatSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public float[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public float[] keys(float[] fArr) {
        return this.m.keys(fArr);
    }

    @Override // gnu.trove.map.TFloatIntMap
    public TIntCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int[] values(int[] iArr) {
        return this.m.values(iArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.m.equals(obj);
    }

    public int hashCode() {
        return this.m.hashCode();
    }

    public String toString() {
        return this.m.toString();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public float getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return this.m.forEachKey(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        return this.m.forEachValue(tIntProcedure);
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean forEachEntry(TFloatIntProcedure tFloatIntProcedure) {
        return this.m.forEachEntry(tFloatIntProcedure);
    }

    @Override // gnu.trove.map.TFloatIntMap
    public TFloatIntIterator iterator() {
        return new TFloatIntIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableFloatIntMap.1
            TFloatIntIterator iter;

            {
                this.iter = TUnmodifiableFloatIntMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TFloatIntIterator
            public float key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TFloatIntIterator
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

            @Override // gnu.trove.iterator.TFloatIntIterator
            public int setValue(int i) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int putIfAbsent(float f, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void transformValues(TIntFunction tIntFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean retainEntries(TFloatIntProcedure tFloatIntProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean increment(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean adjustValue(float f, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int adjustOrPutValue(float f, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
