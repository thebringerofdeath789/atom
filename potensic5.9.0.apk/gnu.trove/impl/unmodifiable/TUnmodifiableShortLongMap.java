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

    /* renamed from: m */
    private final TShortLongMap f3724m;
    private transient TShortSet keySet = null;
    private transient TLongCollection values = null;

    public TUnmodifiableShortLongMap(TShortLongMap tShortLongMap) {
        Objects.requireNonNull(tShortLongMap);
        this.f3724m = tShortLongMap;
    }

    @Override // gnu.trove.map.TShortLongMap
    public int size() {
        return this.f3724m.size();
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean isEmpty() {
        return this.f3724m.isEmpty();
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean containsKey(short s) {
        return this.f3724m.containsKey(s);
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean containsValue(long j) {
        return this.f3724m.containsValue(j);
    }

    @Override // gnu.trove.map.TShortLongMap
    public long get(short s) {
        return this.f3724m.get(s);
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
            this.keySet = TCollections.unmodifiableSet(this.f3724m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TShortLongMap
    public short[] keys() {
        return this.f3724m.keys();
    }

    @Override // gnu.trove.map.TShortLongMap
    public short[] keys(short[] sArr) {
        return this.f3724m.keys(sArr);
    }

    @Override // gnu.trove.map.TShortLongMap
    public TLongCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3724m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TShortLongMap
    public long[] values() {
        return this.f3724m.values();
    }

    @Override // gnu.trove.map.TShortLongMap
    public long[] values(long[] jArr) {
        return this.f3724m.values(jArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3724m.equals(obj);
    }

    public int hashCode() {
        return this.f3724m.hashCode();
    }

    public String toString() {
        return this.f3724m.toString();
    }

    @Override // gnu.trove.map.TShortLongMap
    public short getNoEntryKey() {
        return this.f3724m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortLongMap
    public long getNoEntryValue() {
        return this.f3724m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return this.f3724m.forEachKey(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        return this.f3724m.forEachValue(tLongProcedure);
    }

    @Override // gnu.trove.map.TShortLongMap
    public boolean forEachEntry(TShortLongProcedure tShortLongProcedure) {
        return this.f3724m.forEachEntry(tShortLongProcedure);
    }

    @Override // gnu.trove.map.TShortLongMap
    public TShortLongIterator iterator() {
        return new TShortLongIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableShortLongMap.1
            TShortLongIterator iter;

            {
                this.iter = TUnmodifiableShortLongMap.this.f3724m.iterator();
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