package gnu.trove.impl.unmodifiable;

import gnu.trove.TCharCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TDoubleCharIterator;
import gnu.trove.map.TDoubleCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TDoubleCharProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableDoubleCharMap implements TDoubleCharMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TDoubleCharMap m;
    private transient TDoubleSet keySet = null;
    private transient TCharCollection values = null;

    public TUnmodifiableDoubleCharMap(TDoubleCharMap tDoubleCharMap) {
        Objects.requireNonNull(tDoubleCharMap);
        this.m = tDoubleCharMap;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean containsKey(double d) {
        return this.m.containsKey(d);
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean containsValue(char c) {
        return this.m.containsValue(c);
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char get(double d) {
        return this.m.get(d);
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char put(double d, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char remove(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void putAll(TDoubleCharMap tDoubleCharMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void putAll(Map<? extends Double, ? extends Character> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public TDoubleSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public double[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public double[] keys(double[] dArr) {
        return this.m.keys(dArr);
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public TCharCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char[] values(char[] cArr) {
        return this.m.values(cArr);
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

    @Override // gnu.trove.map.TDoubleCharMap
    public double getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        return this.m.forEachKey(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        return this.m.forEachValue(tCharProcedure);
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean forEachEntry(TDoubleCharProcedure tDoubleCharProcedure) {
        return this.m.forEachEntry(tDoubleCharProcedure);
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public TDoubleCharIterator iterator() {
        return new TDoubleCharIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableDoubleCharMap.1
            TDoubleCharIterator iter;

            {
                this.iter = TUnmodifiableDoubleCharMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TDoubleCharIterator
            public double key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TDoubleCharIterator
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

            @Override // gnu.trove.iterator.TDoubleCharIterator
            public char setValue(char c) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char putIfAbsent(double d, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void transformValues(TCharFunction tCharFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean retainEntries(TDoubleCharProcedure tDoubleCharProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean increment(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean adjustValue(double d, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char adjustOrPutValue(double d, char c, char c2) {
        throw new UnsupportedOperationException();
    }
}
