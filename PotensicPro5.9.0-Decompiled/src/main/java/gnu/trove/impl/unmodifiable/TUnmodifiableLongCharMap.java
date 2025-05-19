package gnu.trove.impl.unmodifiable;

import gnu.trove.TCharCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TLongCharIterator;
import gnu.trove.map.TLongCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TLongCharProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableLongCharMap implements TLongCharMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TLongCharMap m;
    private transient TLongSet keySet = null;
    private transient TCharCollection values = null;

    public TUnmodifiableLongCharMap(TLongCharMap tLongCharMap) {
        Objects.requireNonNull(tLongCharMap);
        this.m = tLongCharMap;
    }

    @Override // gnu.trove.map.TLongCharMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean containsKey(long j) {
        return this.m.containsKey(j);
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean containsValue(char c) {
        return this.m.containsValue(c);
    }

    @Override // gnu.trove.map.TLongCharMap
    public char get(long j) {
        return this.m.get(j);
    }

    @Override // gnu.trove.map.TLongCharMap
    public char put(long j, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongCharMap
    public char remove(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongCharMap
    public void putAll(TLongCharMap tLongCharMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongCharMap
    public void putAll(Map<? extends Long, ? extends Character> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongCharMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongCharMap
    public TLongSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TLongCharMap
    public long[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TLongCharMap
    public long[] keys(long[] jArr) {
        return this.m.keys(jArr);
    }

    @Override // gnu.trove.map.TLongCharMap
    public TCharCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TLongCharMap
    public char[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TLongCharMap
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

    @Override // gnu.trove.map.TLongCharMap
    public long getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TLongCharMap
    public char getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        return this.m.forEachKey(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        return this.m.forEachValue(tCharProcedure);
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean forEachEntry(TLongCharProcedure tLongCharProcedure) {
        return this.m.forEachEntry(tLongCharProcedure);
    }

    @Override // gnu.trove.map.TLongCharMap
    public TLongCharIterator iterator() {
        return new TLongCharIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableLongCharMap.1
            TLongCharIterator iter;

            {
                this.iter = TUnmodifiableLongCharMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TLongCharIterator
            public long key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TLongCharIterator
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

            @Override // gnu.trove.iterator.TLongCharIterator
            public char setValue(char c) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TLongCharMap
    public char putIfAbsent(long j, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongCharMap
    public void transformValues(TCharFunction tCharFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean retainEntries(TLongCharProcedure tLongCharProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean increment(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean adjustValue(long j, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TLongCharMap
    public char adjustOrPutValue(long j, char c, char c2) {
        throw new UnsupportedOperationException();
    }
}
