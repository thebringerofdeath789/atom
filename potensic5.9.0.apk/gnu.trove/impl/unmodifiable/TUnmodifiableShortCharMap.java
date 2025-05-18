package gnu.trove.impl.unmodifiable;

import gnu.trove.TCharCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TShortCharIterator;
import gnu.trove.map.TShortCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TShortCharProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableShortCharMap implements TShortCharMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TShortCharMap f3718m;
    private transient TShortSet keySet = null;
    private transient TCharCollection values = null;

    public TUnmodifiableShortCharMap(TShortCharMap tShortCharMap) {
        Objects.requireNonNull(tShortCharMap);
        this.f3718m = tShortCharMap;
    }

    @Override // gnu.trove.map.TShortCharMap
    public int size() {
        return this.f3718m.size();
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean isEmpty() {
        return this.f3718m.isEmpty();
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean containsKey(short s) {
        return this.f3718m.containsKey(s);
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean containsValue(char c) {
        return this.f3718m.containsValue(c);
    }

    @Override // gnu.trove.map.TShortCharMap
    public char get(short s) {
        return this.f3718m.get(s);
    }

    @Override // gnu.trove.map.TShortCharMap
    public char put(short s, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortCharMap
    public char remove(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortCharMap
    public void putAll(TShortCharMap tShortCharMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortCharMap
    public void putAll(Map<? extends Short, ? extends Character> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortCharMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortCharMap
    public TShortSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3718m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TShortCharMap
    public short[] keys() {
        return this.f3718m.keys();
    }

    @Override // gnu.trove.map.TShortCharMap
    public short[] keys(short[] sArr) {
        return this.f3718m.keys(sArr);
    }

    @Override // gnu.trove.map.TShortCharMap
    public TCharCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3718m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TShortCharMap
    public char[] values() {
        return this.f3718m.values();
    }

    @Override // gnu.trove.map.TShortCharMap
    public char[] values(char[] cArr) {
        return this.f3718m.values(cArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3718m.equals(obj);
    }

    public int hashCode() {
        return this.f3718m.hashCode();
    }

    public String toString() {
        return this.f3718m.toString();
    }

    @Override // gnu.trove.map.TShortCharMap
    public short getNoEntryKey() {
        return this.f3718m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortCharMap
    public char getNoEntryValue() {
        return this.f3718m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return this.f3718m.forEachKey(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        return this.f3718m.forEachValue(tCharProcedure);
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean forEachEntry(TShortCharProcedure tShortCharProcedure) {
        return this.f3718m.forEachEntry(tShortCharProcedure);
    }

    @Override // gnu.trove.map.TShortCharMap
    public TShortCharIterator iterator() {
        return new TShortCharIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableShortCharMap.1
            TShortCharIterator iter;

            {
                this.iter = TUnmodifiableShortCharMap.this.f3718m.iterator();
            }

            @Override // gnu.trove.iterator.TShortCharIterator
            public short key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TShortCharIterator
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

            @Override // gnu.trove.iterator.TShortCharIterator
            public char setValue(char c) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TShortCharMap
    public char putIfAbsent(short s, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortCharMap
    public void transformValues(TCharFunction tCharFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean retainEntries(TShortCharProcedure tShortCharProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean increment(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortCharMap
    public boolean adjustValue(short s, char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortCharMap
    public char adjustOrPutValue(short s, char c, char c2) {
        throw new UnsupportedOperationException();
    }
}