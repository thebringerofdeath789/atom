package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TIntShortIterator;
import gnu.trove.map.TIntShortMap;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TIntShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TIntSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableIntShortMap implements TIntShortMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TIntShortMap f3699m;
    private transient TIntSet keySet = null;
    private transient TShortCollection values = null;

    public TUnmodifiableIntShortMap(TIntShortMap tIntShortMap) {
        Objects.requireNonNull(tIntShortMap);
        this.f3699m = tIntShortMap;
    }

    @Override // gnu.trove.map.TIntShortMap
    public int size() {
        return this.f3699m.size();
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean isEmpty() {
        return this.f3699m.isEmpty();
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean containsKey(int i) {
        return this.f3699m.containsKey(i);
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean containsValue(short s) {
        return this.f3699m.containsValue(s);
    }

    @Override // gnu.trove.map.TIntShortMap
    public short get(int i) {
        return this.f3699m.get(i);
    }

    @Override // gnu.trove.map.TIntShortMap
    public short put(int i, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntShortMap
    public short remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntShortMap
    public void putAll(TIntShortMap tIntShortMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntShortMap
    public void putAll(Map<? extends Integer, ? extends Short> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntShortMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntShortMap
    public TIntSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3699m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TIntShortMap
    public int[] keys() {
        return this.f3699m.keys();
    }

    @Override // gnu.trove.map.TIntShortMap
    public int[] keys(int[] iArr) {
        return this.f3699m.keys(iArr);
    }

    @Override // gnu.trove.map.TIntShortMap
    public TShortCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3699m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TIntShortMap
    public short[] values() {
        return this.f3699m.values();
    }

    @Override // gnu.trove.map.TIntShortMap
    public short[] values(short[] sArr) {
        return this.f3699m.values(sArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3699m.equals(obj);
    }

    public int hashCode() {
        return this.f3699m.hashCode();
    }

    public String toString() {
        return this.f3699m.toString();
    }

    @Override // gnu.trove.map.TIntShortMap
    public int getNoEntryKey() {
        return this.f3699m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TIntShortMap
    public short getNoEntryValue() {
        return this.f3699m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        return this.f3699m.forEachKey(tIntProcedure);
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        return this.f3699m.forEachValue(tShortProcedure);
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean forEachEntry(TIntShortProcedure tIntShortProcedure) {
        return this.f3699m.forEachEntry(tIntShortProcedure);
    }

    @Override // gnu.trove.map.TIntShortMap
    public TIntShortIterator iterator() {
        return new TIntShortIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableIntShortMap.1
            TIntShortIterator iter;

            {
                this.iter = TUnmodifiableIntShortMap.this.f3699m.iterator();
            }

            @Override // gnu.trove.iterator.TIntShortIterator
            public int key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TIntShortIterator
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

            @Override // gnu.trove.iterator.TIntShortIterator
            public short setValue(short s) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TIntShortMap
    public short putIfAbsent(int i, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntShortMap
    public void transformValues(TShortFunction tShortFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean retainEntries(TIntShortProcedure tIntShortProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean increment(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntShortMap
    public boolean adjustValue(int i, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TIntShortMap
    public short adjustOrPutValue(int i, short s, short s2) {
        throw new UnsupportedOperationException();
    }
}