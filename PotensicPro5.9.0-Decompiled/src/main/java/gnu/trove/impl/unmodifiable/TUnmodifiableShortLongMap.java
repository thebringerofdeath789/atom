package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TShortLongIterator;
import gnu.trove.map.TShortLongMap;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TShortLongProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableShortLongMap implements TShortLongMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TShortLongMap m;
    private transient TShortSet keySet = null;
    private transient TLongCollection values = null;

    public TUnmodifiableShortLongMap(TShortLongMap tShortLongMap) {
        Objects.requireNonNull(tShortLongMap);
        this.m = tShortLongMap;
    }

    @Override // gnu.trove.map.TShortLongMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean containsKey(short s) {
        return this.m.containsKey(s);
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean containsValue(long j) {
        return this.m.containsValue(j);
    }

    @Override // gnu.trove.map.TShortLongMap
    public long get(short s) {
        return this.m.get(s);
    }

    @Override // gnu.trove.map.TShortLongMap
    public long put(short s, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortLongMap
    public long remove(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortLongMap
    public void putAll(TShortLongMap tShortLongMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortLongMap
    public void putAll(Map<? extends Short, ? extends Long> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortLongMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortLongMap
    public TShortSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TShortLongMap
    public short[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TShortLongMap
    public short[] keys(short[] sArr) {
        return this.m.keys(sArr);
    }

    @Override // gnu.trove.map.TShortLongMap
    public TLongCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TShortLongMap
    public long[] values(long[] jArr) {
        return this.m.values(jArr);
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

    @Override // gnu.trove.map.TShortLongMap
    public short getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortLongMap
    public long getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return this.m.forEachKey(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        return this.m.forEachValue(tLongProcedure);
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean forEachEntry(TShortLongProcedure tShortLongProcedure) {
        return this.m.forEachEntry(tShortLongProcedure);
    }

    @Override // gnu.trove.map.TShortLongMap
    public TShortLongIterator iterator() {
        return new TShortLongIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableShortLongMap.1
            TShortLongIterator iter;

            {
                this.iter = TUnmodifiableShortLongMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TShortLongIterator
            public short key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TShortLongIterator
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

            @Override // gnu.trove.iterator.TShortLongIterator
            public long setValue(long j) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TShortLongMap
    public long putIfAbsent(short s, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortLongMap
    public void transformValues(TLongFunction tLongFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean retainEntries(TShortLongProcedure tShortLongProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean increment(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean adjustValue(short s, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortLongMap
    public long adjustOrPutValue(short s, long j, long j2) {
        throw new UnsupportedOperationException();
    }
}
