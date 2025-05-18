package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TDoubleShortIterator;
import gnu.trove.map.TDoubleShortMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TDoubleShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TDoubleSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableDoubleShortMap implements TDoubleShortMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TDoubleShortMap f3679m;
    private transient TDoubleSet keySet = null;
    private transient TShortCollection values = null;

    public TUnmodifiableDoubleShortMap(TDoubleShortMap tDoubleShortMap) {
        Objects.requireNonNull(tDoubleShortMap);
        this.f3679m = tDoubleShortMap;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public int size() {
        return this.f3679m.size();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean isEmpty() {
        return this.f3679m.isEmpty();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean containsKey(double d) {
        return this.f3679m.containsKey(d);
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean containsValue(short s) {
        return this.f3679m.containsValue(s);
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short get(double d) {
        return this.f3679m.get(d);
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short put(double d, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short remove(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void putAll(TDoubleShortMap tDoubleShortMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void putAll(Map<? extends Double, ? extends Short> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public TDoubleSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3679m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public double[] keys() {
        return this.f3679m.keys();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public double[] keys(double[] dArr) {
        return this.f3679m.keys(dArr);
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public TShortCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3679m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short[] values() {
        return this.f3679m.values();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short[] values(short[] sArr) {
        return this.f3679m.values(sArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3679m.equals(obj);
    }

    public int hashCode() {
        return this.f3679m.hashCode();
    }

    public String toString() {
        return this.f3679m.toString();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public double getNoEntryKey() {
        return this.f3679m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short getNoEntryValue() {
        return this.f3679m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        return this.f3679m.forEachKey(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        return this.f3679m.forEachValue(tShortProcedure);
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean forEachEntry(TDoubleShortProcedure tDoubleShortProcedure) {
        return this.f3679m.forEachEntry(tDoubleShortProcedure);
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public TDoubleShortIterator iterator() {
        return new TDoubleShortIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableDoubleShortMap.1
            TDoubleShortIterator iter;

            {
                this.iter = TUnmodifiableDoubleShortMap.this.f3679m.iterator();
            }

            @Override // gnu.trove.iterator.TDoubleShortIterator
            public double key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TDoubleShortIterator
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

            @Override // gnu.trove.iterator.TDoubleShortIterator
            public short setValue(short s) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short putIfAbsent(double d, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void transformValues(TShortFunction tShortFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean retainEntries(TDoubleShortProcedure tDoubleShortProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean increment(double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean adjustValue(double d, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short adjustOrPutValue(double d, short s, short s2) {
        throw new UnsupportedOperationException();
    }
}