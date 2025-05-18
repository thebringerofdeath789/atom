package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.iterator.TFloatLongIterator;
import gnu.trove.map.TFloatLongMap;
import gnu.trove.procedure.TFloatLongProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TFloatSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableFloatLongMap implements TFloatLongMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TFloatLongMap f3687m;
    private transient TFloatSet keySet = null;
    private transient TLongCollection values = null;

    public TUnmodifiableFloatLongMap(TFloatLongMap tFloatLongMap) {
        Objects.requireNonNull(tFloatLongMap);
        this.f3687m = tFloatLongMap;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public int size() {
        return this.f3687m.size();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean isEmpty() {
        return this.f3687m.isEmpty();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean containsKey(float f) {
        return this.f3687m.containsKey(f);
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean containsValue(long j) {
        return this.f3687m.containsValue(j);
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long get(float f) {
        return this.f3687m.get(f);
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long put(float f, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long remove(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void putAll(TFloatLongMap tFloatLongMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void putAll(Map<? extends Float, ? extends Long> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public TFloatSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3687m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public float[] keys() {
        return this.f3687m.keys();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public float[] keys(float[] fArr) {
        return this.f3687m.keys(fArr);
    }

    @Override // gnu.trove.map.TFloatLongMap
    public TLongCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3687m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long[] values() {
        return this.f3687m.values();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long[] values(long[] jArr) {
        return this.f3687m.values(jArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3687m.equals(obj);
    }

    public int hashCode() {
        return this.f3687m.hashCode();
    }

    public String toString() {
        return this.f3687m.toString();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public float getNoEntryKey() {
        return this.f3687m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long getNoEntryValue() {
        return this.f3687m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return this.f3687m.forEachKey(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        return this.f3687m.forEachValue(tLongProcedure);
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean forEachEntry(TFloatLongProcedure tFloatLongProcedure) {
        return this.f3687m.forEachEntry(tFloatLongProcedure);
    }

    @Override // gnu.trove.map.TFloatLongMap
    public TFloatLongIterator iterator() {
        return new TFloatLongIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableFloatLongMap.1
            TFloatLongIterator iter;

            {
                this.iter = TUnmodifiableFloatLongMap.this.f3687m.iterator();
            }

            @Override // gnu.trove.iterator.TFloatLongIterator
            public float key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TFloatLongIterator
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

            @Override // gnu.trove.iterator.TFloatLongIterator
            public long setValue(long j) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long putIfAbsent(float f, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void transformValues(TLongFunction tLongFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean retainEntries(TFloatLongProcedure tFloatLongProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean increment(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean adjustValue(float f, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long adjustOrPutValue(float f, long j, long j2) {
        throw new UnsupportedOperationException();
    }
}