package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TCharShortIterator;
import gnu.trove.map.TCharShortMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TCharShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TCharSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableCharShortMap implements TCharShortMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TCharShortMap f3669m;
    private transient TCharSet keySet = null;
    private transient TShortCollection values = null;

    public TUnmodifiableCharShortMap(TCharShortMap tCharShortMap) {
        Objects.requireNonNull(tCharShortMap);
        this.f3669m = tCharShortMap;
    }

    @Override // gnu.trove.map.TCharShortMap
    public int size() {
        return this.f3669m.size();
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean isEmpty() {
        return this.f3669m.isEmpty();
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean containsKey(char c) {
        return this.f3669m.containsKey(c);
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean containsValue(short s) {
        return this.f3669m.containsValue(s);
    }

    @Override // gnu.trove.map.TCharShortMap
    public short get(char c) {
        return this.f3669m.get(c);
    }

    @Override // gnu.trove.map.TCharShortMap
    public short put(char c, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharShortMap
    public short remove(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharShortMap
    public void putAll(TCharShortMap tCharShortMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharShortMap
    public void putAll(Map<? extends Character, ? extends Short> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharShortMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharShortMap
    public TCharSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3669m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TCharShortMap
    public char[] keys() {
        return this.f3669m.keys();
    }

    @Override // gnu.trove.map.TCharShortMap
    public char[] keys(char[] cArr) {
        return this.f3669m.keys(cArr);
    }

    @Override // gnu.trove.map.TCharShortMap
    public TShortCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3669m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TCharShortMap
    public short[] values() {
        return this.f3669m.values();
    }

    @Override // gnu.trove.map.TCharShortMap
    public short[] values(short[] sArr) {
        return this.f3669m.values(sArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3669m.equals(obj);
    }

    public int hashCode() {
        return this.f3669m.hashCode();
    }

    public String toString() {
        return this.f3669m.toString();
    }

    @Override // gnu.trove.map.TCharShortMap
    public char getNoEntryKey() {
        return this.f3669m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharShortMap
    public short getNoEntryValue() {
        return this.f3669m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        return this.f3669m.forEachKey(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        return this.f3669m.forEachValue(tShortProcedure);
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean forEachEntry(TCharShortProcedure tCharShortProcedure) {
        return this.f3669m.forEachEntry(tCharShortProcedure);
    }

    @Override // gnu.trove.map.TCharShortMap
    public TCharShortIterator iterator() {
        return new TCharShortIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableCharShortMap.1
            TCharShortIterator iter;

            {
                this.iter = TUnmodifiableCharShortMap.this.f3669m.iterator();
            }

            @Override // gnu.trove.iterator.TCharShortIterator
            public char key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TCharShortIterator
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

            @Override // gnu.trove.iterator.TCharShortIterator
            public short setValue(short s) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TCharShortMap
    public short putIfAbsent(char c, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharShortMap
    public void transformValues(TShortFunction tShortFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean retainEntries(TCharShortProcedure tCharShortProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean increment(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharShortMap
    public boolean adjustValue(char c, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharShortMap
    public short adjustOrPutValue(char c, short s, short s2) {
        throw new UnsupportedOperationException();
    }
}