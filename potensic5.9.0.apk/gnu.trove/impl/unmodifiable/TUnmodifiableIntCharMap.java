package gnu.trove.impl.unmodifiable;

import gnu.trove.TCharCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TIntCharIterator;
import gnu.trove.map.TIntCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TIntCharProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableIntCharMap implements TIntCharMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TIntCharMap f3691m;
    private transient TIntSet keySet = null;
    private transient TCharCollection values = null;

    public TUnmodifiableIntCharMap(TIntCharMap tIntCharMap) {
        Objects.requireNonNull(tIntCharMap);
        this.f3691m = tIntCharMap;
    }

    @Override // gnu.trove.map.TIntCharMap
    public int size() {
        return this.f3691m.size();
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean isEmpty() {
        return this.f3691m.isEmpty();
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean containsKey(int i) {
        return this.f3691m.containsKey(i);
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean containsValue(char c) {
        return this.f3691m.containsValue(c);
    }

    @Override // gnu.trove.map.TIntCharMap
    public char get(int i) {
        return this.f3691m.get(i);
    }

    @Override // gnu.trove.map.TIntCharMap
    public char put(int i, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntCharMap
    public char remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntCharMap
    public void putAll(TIntCharMap tIntCharMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntCharMap
    public void putAll(Map<? extends Integer, ? extends Character> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntCharMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntCharMap
    public TIntSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3691m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TIntCharMap
    public int[] keys() {
        return this.f3691m.keys();
    }

    @Override // gnu.trove.map.TIntCharMap
    public int[] keys(int[] iArr) {
        return this.f3691m.keys(iArr);
    }

    @Override // gnu.trove.map.TIntCharMap
    public TCharCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3691m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TIntCharMap
    public char[] values() {
        return this.f3691m.values();
    }

    @Override // gnu.trove.map.TIntCharMap
    public char[] values(char[] cArr) {
        return this.f3691m.values(cArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3691m.equals(obj);
    }

    public int hashCode() {
        return this.f3691m.hashCode();
    }

    public String toString() {
        return this.f3691m.toString();
    }

    @Override // gnu.trove.map.TIntCharMap
    public int getNoEntryKey() {
        return this.f3691m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntCharMap
    public char getNoEntryValue() {
        return this.f3691m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        return this.f3691m.forEachKey(tIntProcedure);
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        return this.f3691m.forEachValue(tCharProcedure);
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean forEachEntry(TIntCharProcedure tIntCharProcedure) {
        return this.f3691m.forEachEntry(tIntCharProcedure);
    }

    @Override // gnu.trove.map.TIntCharMap
    public TIntCharIterator iterator() {
        return new TIntCharIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableIntCharMap.1
            TIntCharIterator iter;

            {
                this.iter = TUnmodifiableIntCharMap.this.f3691m.iterator();
            }

            @Override // gnu.trove.iterator.TIntCharIterator
            public int key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TIntCharIterator
            public char value() {
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

            @Override // gnu.trove.iterator.TIntCharIterator
            public char setValue(char c) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TIntCharMap
    public char putIfAbsent(int i, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntCharMap
    public void transformValues(TCharFunction tCharFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean retainEntries(TIntCharProcedure tIntCharProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean increment(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean adjustValue(int i, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntCharMap
    public char adjustOrPutValue(int i, char c, char c2) {
        throw new UnsupportedOperationException();
    }
}