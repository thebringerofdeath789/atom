package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.iterator.TCharIntIterator;
import gnu.trove.map.TCharIntMap;
import gnu.trove.procedure.TCharIntProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TCharSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableCharIntMap implements TCharIntMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TCharIntMap m;
    private transient TCharSet keySet = null;
    private transient TIntCollection values = null;

    public TUnmodifiableCharIntMap(TCharIntMap tCharIntMap) {
        Objects.requireNonNull(tCharIntMap);
        this.m = tCharIntMap;
    }

    @Override // gnu.trove.map.TCharIntMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean containsKey(char c) {
        return this.m.containsKey(c);
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean containsValue(int i) {
        return this.m.containsValue(i);
    }

    @Override // gnu.trove.map.TCharIntMap
    public int get(char c) {
        return this.m.get(c);
    }

    @Override // gnu.trove.map.TCharIntMap
    public int put(char c, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharIntMap
    public int remove(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharIntMap
    public void putAll(TCharIntMap tCharIntMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharIntMap
    public void putAll(Map<? extends Character, ? extends Integer> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharIntMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharIntMap
    public TCharSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TCharIntMap
    public char[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TCharIntMap
    public char[] keys(char[] cArr) {
        return this.m.keys(cArr);
    }

    @Override // gnu.trove.map.TCharIntMap
    public TIntCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TCharIntMap
    public int[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TCharIntMap
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

    @Override // gnu.trove.map.TCharIntMap
    public char getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharIntMap
    public int getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        return this.m.forEachKey(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        return this.m.forEachValue(tIntProcedure);
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean forEachEntry(TCharIntProcedure tCharIntProcedure) {
        return this.m.forEachEntry(tCharIntProcedure);
    }

    @Override // gnu.trove.map.TCharIntMap
    public TCharIntIterator iterator() {
        return new TCharIntIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableCharIntMap.1
            TCharIntIterator iter;

            {
                this.iter = TUnmodifiableCharIntMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TCharIntIterator
            public char key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TCharIntIterator
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

            @Override // gnu.trove.iterator.TCharIntIterator
            public int setValue(int i) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TCharIntMap
    public int putIfAbsent(char c, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharIntMap
    public void transformValues(TIntFunction tIntFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean retainEntries(TCharIntProcedure tCharIntProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean increment(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharIntMap
    public boolean adjustValue(char c, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharIntMap
    public int adjustOrPutValue(char c, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
