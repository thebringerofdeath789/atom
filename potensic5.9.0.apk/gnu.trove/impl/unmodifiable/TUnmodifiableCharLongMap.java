package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TCharLongIterator;
import gnu.trove.map.TCharLongMap;
import gnu.trove.procedure.TCharLongProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TCharSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableCharLongMap implements TCharLongMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TCharLongMap f3667m;
    private transient TCharSet keySet = null;
    private transient TLongCollection values = null;

    public TUnmodifiableCharLongMap(TCharLongMap tCharLongMap) {
        Objects.requireNonNull(tCharLongMap);
        this.f3667m = tCharLongMap;
    }

    @Override // gnu.trove.map.TCharLongMap
    public int size() {
        return this.f3667m.size();
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean isEmpty() {
        return this.f3667m.isEmpty();
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean containsKey(char c) {
        return this.f3667m.containsKey(c);
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean containsValue(long j) {
        return this.f3667m.containsValue(j);
    }

    @Override // gnu.trove.map.TCharLongMap
    public long get(char c) {
        return this.f3667m.get(c);
    }

    @Override // gnu.trove.map.TCharLongMap
    public long put(char c, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharLongMap
    public long remove(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharLongMap
    public void putAll(TCharLongMap tCharLongMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharLongMap
    public void putAll(Map<? extends Character, ? extends Long> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharLongMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharLongMap
    public TCharSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3667m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TCharLongMap
    public char[] keys() {
        return this.f3667m.keys();
    }

    @Override // gnu.trove.map.TCharLongMap
    public char[] keys(char[] cArr) {
        return this.f3667m.keys(cArr);
    }

    @Override // gnu.trove.map.TCharLongMap
    public TLongCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3667m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TCharLongMap
    public long[] values() {
        return this.f3667m.values();
    }

    @Override // gnu.trove.map.TCharLongMap
    public long[] values(long[] jArr) {
        return this.f3667m.values(jArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3667m.equals(obj);
    }

    public int hashCode() {
        return this.f3667m.hashCode();
    }

    public String toString() {
        return this.f3667m.toString();
    }

    @Override // gnu.trove.map.TCharLongMap
    public char getNoEntryKey() {
        return this.f3667m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharLongMap
    public long getNoEntryValue() {
        return this.f3667m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        return this.f3667m.forEachKey(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        return this.f3667m.forEachValue(tLongProcedure);
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean forEachEntry(TCharLongProcedure tCharLongProcedure) {
        return this.f3667m.forEachEntry(tCharLongProcedure);
    }

    @Override // gnu.trove.map.TCharLongMap
    public TCharLongIterator iterator() {
        return new TCharLongIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableCharLongMap.1
            TCharLongIterator iter;

            {
                this.iter = TUnmodifiableCharLongMap.this.f3667m.iterator();
            }

            @Override // gnu.trove.iterator.TCharLongIterator
            public char key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TCharLongIterator
            public long value() {
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

            @Override // gnu.trove.iterator.TCharLongIterator
            public long setValue(long j) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TCharLongMap
    public long putIfAbsent(char c, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharLongMap
    public void transformValues(TLongFunction tLongFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean retainEntries(TCharLongProcedure tCharLongProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean increment(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharLongMap
    public boolean adjustValue(char c, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharLongMap
    public long adjustOrPutValue(char c, long j, long j2) {
        throw new UnsupportedOperationException();
    }
}