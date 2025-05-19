package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TShortIntIterator;
import gnu.trove.map.TShortIntMap;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TShortIntProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableShortIntMap implements TShortIntMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TShortIntMap m;
    private transient TShortSet keySet = null;
    private transient TIntCollection values = null;

    public TUnmodifiableShortIntMap(TShortIntMap tShortIntMap) {
        Objects.requireNonNull(tShortIntMap);
        this.m = tShortIntMap;
    }

    @Override // gnu.trove.map.TShortIntMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean containsKey(short s) {
        return this.m.containsKey(s);
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean containsValue(int i) {
        return this.m.containsValue(i);
    }

    @Override // gnu.trove.map.TShortIntMap
    public int get(short s) {
        return this.m.get(s);
    }

    @Override // gnu.trove.map.TShortIntMap
    public int put(short s, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortIntMap
    public int remove(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortIntMap
    public void putAll(TShortIntMap tShortIntMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortIntMap
    public void putAll(Map<? extends Short, ? extends Integer> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortIntMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortIntMap
    public TShortSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TShortIntMap
    public short[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TShortIntMap
    public short[] keys(short[] sArr) {
        return this.m.keys(sArr);
    }

    @Override // gnu.trove.map.TShortIntMap
    public TIntCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TShortIntMap
    public int[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TShortIntMap
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

    @Override // gnu.trove.map.TShortIntMap
    public short getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortIntMap
    public int getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return this.m.forEachKey(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        return this.m.forEachValue(tIntProcedure);
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean forEachEntry(TShortIntProcedure tShortIntProcedure) {
        return this.m.forEachEntry(tShortIntProcedure);
    }

    @Override // gnu.trove.map.TShortIntMap
    public TShortIntIterator iterator() {
        return new TShortIntIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableShortIntMap.1
            TShortIntIterator iter;

            {
                this.iter = TUnmodifiableShortIntMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TShortIntIterator
            public short key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TShortIntIterator
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

            @Override // gnu.trove.iterator.TShortIntIterator
            public int setValue(int i) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TShortIntMap
    public int putIfAbsent(short s, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortIntMap
    public void transformValues(TIntFunction tIntFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean retainEntries(TShortIntProcedure tShortIntProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean increment(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortIntMap
    public boolean adjustValue(short s, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortIntMap
    public int adjustOrPutValue(short s, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
