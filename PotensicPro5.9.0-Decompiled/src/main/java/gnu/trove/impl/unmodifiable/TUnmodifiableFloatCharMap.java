package gnu.trove.impl.unmodifiable;

import gnu.trove.TCharCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TFloatCharIterator;
import gnu.trove.map.TFloatCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TFloatCharProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TFloatSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableFloatCharMap implements TFloatCharMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TFloatCharMap m;
    private transient TFloatSet keySet = null;
    private transient TCharCollection values = null;

    public TUnmodifiableFloatCharMap(TFloatCharMap tFloatCharMap) {
        Objects.requireNonNull(tFloatCharMap);
        this.m = tFloatCharMap;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean containsKey(float f) {
        return this.m.containsKey(f);
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean containsValue(char c) {
        return this.m.containsValue(c);
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char get(float f) {
        return this.m.get(f);
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char put(float f, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char remove(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public void putAll(TFloatCharMap tFloatCharMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public void putAll(Map<? extends Float, ? extends Character> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public TFloatSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public float[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public float[] keys(float[] fArr) {
        return this.m.keys(fArr);
    }

    @Override // gnu.trove.map.TFloatCharMap
    public TCharCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TFloatCharMap
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

    @Override // gnu.trove.map.TFloatCharMap
    public float getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return this.m.forEachKey(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        return this.m.forEachValue(tCharProcedure);
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean forEachEntry(TFloatCharProcedure tFloatCharProcedure) {
        return this.m.forEachEntry(tFloatCharProcedure);
    }

    @Override // gnu.trove.map.TFloatCharMap
    public TFloatCharIterator iterator() {
        return new TFloatCharIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableFloatCharMap.1
            TFloatCharIterator iter;

            {
                this.iter = TUnmodifiableFloatCharMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TFloatCharIterator
            public float key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TFloatCharIterator
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

            @Override // gnu.trove.iterator.TFloatCharIterator
            public char setValue(char c) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char putIfAbsent(float f, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public void transformValues(TCharFunction tCharFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean retainEntries(TFloatCharProcedure tFloatCharProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean increment(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean adjustValue(float f, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char adjustOrPutValue(float f, char c, char c2) {
        throw new UnsupportedOperationException();
    }
}
