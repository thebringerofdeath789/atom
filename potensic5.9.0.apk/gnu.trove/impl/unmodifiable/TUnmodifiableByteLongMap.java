package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TByteLongIterator;
import gnu.trove.map.TByteLongMap;
import gnu.trove.procedure.TByteLongProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TByteSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableByteLongMap implements TByteLongMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TByteLongMap f3657m;
    private transient TByteSet keySet = null;
    private transient TLongCollection values = null;

    public TUnmodifiableByteLongMap(TByteLongMap tByteLongMap) {
        Objects.requireNonNull(tByteLongMap);
        this.f3657m = tByteLongMap;
    }

    @Override // gnu.trove.map.TByteLongMap
    public int size() {
        return this.f3657m.size();
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean isEmpty() {
        return this.f3657m.isEmpty();
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean containsKey(byte b) {
        return this.f3657m.containsKey(b);
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean containsValue(long j) {
        return this.f3657m.containsValue(j);
    }

    @Override // gnu.trove.map.TByteLongMap
    public long get(byte b) {
        return this.f3657m.get(b);
    }

    @Override // gnu.trove.map.TByteLongMap
    public long put(byte b, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteLongMap
    public long remove(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteLongMap
    public void putAll(TByteLongMap tByteLongMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteLongMap
    public void putAll(Map<? extends Byte, ? extends Long> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteLongMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteLongMap
    public TByteSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3657m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TByteLongMap
    public byte[] keys() {
        return this.f3657m.keys();
    }

    @Override // gnu.trove.map.TByteLongMap
    public byte[] keys(byte[] bArr) {
        return this.f3657m.keys(bArr);
    }

    @Override // gnu.trove.map.TByteLongMap
    public TLongCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3657m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long[] values() {
        return this.f3657m.values();
    }

    @Override // gnu.trove.map.TByteLongMap
    public long[] values(long[] jArr) {
        return this.f3657m.values(jArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3657m.equals(obj);
    }

    public int hashCode() {
        return this.f3657m.hashCode();
    }

    public String toString() {
        return this.f3657m.toString();
    }

    @Override // gnu.trove.map.TByteLongMap
    public byte getNoEntryKey() {
        return this.f3657m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteLongMap
    public long getNoEntryValue() {
        return this.f3657m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return this.f3657m.forEachKey(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        return this.f3657m.forEachValue(tLongProcedure);
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean forEachEntry(TByteLongProcedure tByteLongProcedure) {
        return this.f3657m.forEachEntry(tByteLongProcedure);
    }

    @Override // gnu.trove.map.TByteLongMap
    public TByteLongIterator iterator() {
        return new TByteLongIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableByteLongMap.1
            TByteLongIterator iter;

            {
                this.iter = TUnmodifiableByteLongMap.this.f3657m.iterator();
            }

            @Override // gnu.trove.iterator.TByteLongIterator
            public byte key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TByteLongIterator
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

            @Override // gnu.trove.iterator.TByteLongIterator
            public long setValue(long j) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TByteLongMap
    public long putIfAbsent(byte b, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteLongMap
    public void transformValues(TLongFunction tLongFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean retainEntries(TByteLongProcedure tByteLongProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean increment(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean adjustValue(byte b, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteLongMap
    public long adjustOrPutValue(byte b, long j, long j2) {
        throw new UnsupportedOperationException();
    }
}