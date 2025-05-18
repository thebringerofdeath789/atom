package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TIntIntIterator;
import gnu.trove.map.TIntIntMap;
import gnu.trove.procedure.TIntIntProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableIntIntMap implements TIntIntMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TIntIntMap f3696m;
    private transient TIntSet keySet = null;
    private transient TIntCollection values = null;

    public TUnmodifiableIntIntMap(TIntIntMap tIntIntMap) {
        Objects.requireNonNull(tIntIntMap);
        this.f3696m = tIntIntMap;
    }

    @Override // gnu.trove.map.TIntIntMap
    public int size() {
        return this.f3696m.size();
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean isEmpty() {
        return this.f3696m.isEmpty();
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean containsKey(int i) {
        return this.f3696m.containsKey(i);
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean containsValue(int i) {
        return this.f3696m.containsValue(i);
    }

    @Override // gnu.trove.map.TIntIntMap
    public int get(int i) {
        return this.f3696m.get(i);
    }

    @Override // gnu.trove.map.TIntIntMap
    public int put(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntIntMap
    public int remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntIntMap
    public void putAll(TIntIntMap tIntIntMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntIntMap
    public void putAll(Map<? extends Integer, ? extends Integer> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntIntMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntIntMap
    public TIntSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3696m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TIntIntMap
    public int[] keys() {
        return this.f3696m.keys();
    }

    @Override // gnu.trove.map.TIntIntMap
    public int[] keys(int[] iArr) {
        return this.f3696m.keys(iArr);
    }

    @Override // gnu.trove.map.TIntIntMap
    public TIntCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3696m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TIntIntMap
    public int[] values() {
        return this.f3696m.values();
    }

    @Override // gnu.trove.map.TIntIntMap
    public int[] values(int[] iArr) {
        return this.f3696m.values(iArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3696m.equals(obj);
    }

    public int hashCode() {
        return this.f3696m.hashCode();
    }

    public String toString() {
        return this.f3696m.toString();
    }

    @Override // gnu.trove.map.TIntIntMap
    public int getNoEntryKey() {
        return this.f3696m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntIntMap
    public int getNoEntryValue() {
        return this.f3696m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        return this.f3696m.forEachKey(tIntProcedure);
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        return this.f3696m.forEachValue(tIntProcedure);
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean forEachEntry(TIntIntProcedure tIntIntProcedure) {
        return this.f3696m.forEachEntry(tIntIntProcedure);
    }

    @Override // gnu.trove.map.TIntIntMap
    public TIntIntIterator iterator() {
        return new TIntIntIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableIntIntMap.1
            TIntIntIterator iter;

            {
                this.iter = TUnmodifiableIntIntMap.this.f3696m.iterator();
            }

            @Override // gnu.trove.iterator.TIntIntIterator
            public int key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TIntIntIterator
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

            @Override // gnu.trove.iterator.TIntIntIterator
            public int setValue(int i) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TIntIntMap
    public int putIfAbsent(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntIntMap
    public void transformValues(TIntFunction tIntFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean retainEntries(TIntIntProcedure tIntIntProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean increment(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntIntMap
    public boolean adjustValue(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntIntMap
    public int adjustOrPutValue(int i, int i2, int i3) {
        throw new UnsupportedOperationException();
    }
}