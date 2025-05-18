package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TShortShortIterator;
import gnu.trove.map.TShortShortMap;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.procedure.TShortShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableShortShortMap implements TShortShortMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TShortShortMap f3726m;
    private transient TShortSet keySet = null;
    private transient TShortCollection values = null;

    public TUnmodifiableShortShortMap(TShortShortMap tShortShortMap) {
        Objects.requireNonNull(tShortShortMap);
        this.f3726m = tShortShortMap;
    }

    @Override // gnu.trove.map.TShortShortMap
    public int size() {
        return this.f3726m.size();
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean isEmpty() {
        return this.f3726m.isEmpty();
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean containsKey(short s) {
        return this.f3726m.containsKey(s);
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean containsValue(short s) {
        return this.f3726m.containsValue(s);
    }

    @Override // gnu.trove.map.TShortShortMap
    public short get(short s) {
        return this.f3726m.get(s);
    }

    @Override // gnu.trove.map.TShortShortMap
    public short put(short s, short s2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortShortMap
    public short remove(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortShortMap
    public void putAll(TShortShortMap tShortShortMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortShortMap
    public void putAll(Map<? extends Short, ? extends Short> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortShortMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortShortMap
    public TShortSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3726m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TShortShortMap
    public short[] keys() {
        return this.f3726m.keys();
    }

    @Override // gnu.trove.map.TShortShortMap
    public short[] keys(short[] sArr) {
        return this.f3726m.keys(sArr);
    }

    @Override // gnu.trove.map.TShortShortMap
    public TShortCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3726m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TShortShortMap
    public short[] values() {
        return this.f3726m.values();
    }

    @Override // gnu.trove.map.TShortShortMap
    public short[] values(short[] sArr) {
        return this.f3726m.values(sArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3726m.equals(obj);
    }

    public int hashCode() {
        return this.f3726m.hashCode();
    }

    public String toString() {
        return this.f3726m.toString();
    }

    @Override // gnu.trove.map.TShortShortMap
    public short getNoEntryKey() {
        return this.f3726m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortShortMap
    public short getNoEntryValue() {
        return this.f3726m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return this.f3726m.forEachKey(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        return this.f3726m.forEachValue(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean forEachEntry(TShortShortProcedure tShortShortProcedure) {
        return this.f3726m.forEachEntry(tShortShortProcedure);
    }

    @Override // gnu.trove.map.TShortShortMap
    public TShortShortIterator iterator() {
        return new TShortShortIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableShortShortMap.1
            TShortShortIterator iter;

            {
                this.iter = TUnmodifiableShortShortMap.this.f3726m.iterator();
            }

            @Override // gnu.trove.iterator.TShortShortIterator
            public short key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TShortShortIterator
            public short value() {
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

            @Override // gnu.trove.iterator.TShortShortIterator
            public short setValue(short s) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TShortShortMap
    public short putIfAbsent(short s, short s2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortShortMap
    public void transformValues(TShortFunction tShortFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean retainEntries(TShortShortProcedure tShortShortProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean increment(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean adjustValue(short s, short s2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortShortMap
    public short adjustOrPutValue(short s, short s2, short s3) {
        throw new UnsupportedOperationException();
    }
}