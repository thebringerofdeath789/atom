package gnu.trove.impl.unmodifiable;

import gnu.trove.TCharCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TCharFunction;
import gnu.trove.iterator.TCharCharIterator;
import gnu.trove.map.TCharCharMap;
import gnu.trove.procedure.TCharCharProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.set.TCharSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableCharCharMap implements TCharCharMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TCharCharMap f3661m;
    private transient TCharSet keySet = null;
    private transient TCharCollection values = null;

    public TUnmodifiableCharCharMap(TCharCharMap tCharCharMap) {
        Objects.requireNonNull(tCharCharMap);
        this.f3661m = tCharCharMap;
    }

    @Override // gnu.trove.map.TCharCharMap
    public int size() {
        return this.f3661m.size();
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean isEmpty() {
        return this.f3661m.isEmpty();
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean containsKey(char c) {
        return this.f3661m.containsKey(c);
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean containsValue(char c) {
        return this.f3661m.containsValue(c);
    }

    @Override // gnu.trove.map.TCharCharMap
    public char get(char c) {
        return this.f3661m.get(c);
    }

    @Override // gnu.trove.map.TCharCharMap
    public char put(char c, char c2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharCharMap
    public char remove(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharCharMap
    public void putAll(TCharCharMap tCharCharMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharCharMap
    public void putAll(Map<? extends Character, ? extends Character> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharCharMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharCharMap
    public TCharSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3661m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char[] keys() {
        return this.f3661m.keys();
    }

    @Override // gnu.trove.map.TCharCharMap
    public char[] keys(char[] cArr) {
        return this.f3661m.keys(cArr);
    }

    @Override // gnu.trove.map.TCharCharMap
    public TCharCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3661m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TCharCharMap
    public char[] values() {
        return this.f3661m.values();
    }

    @Override // gnu.trove.map.TCharCharMap
    public char[] values(char[] cArr) {
        return this.f3661m.values(cArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3661m.equals(obj);
    }

    public int hashCode() {
        return this.f3661m.hashCode();
    }

    public String toString() {
        return this.f3661m.toString();
    }

    @Override // gnu.trove.map.TCharCharMap
    public char getNoEntryKey() {
        return this.f3661m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TCharCharMap
    public char getNoEntryValue() {
        return this.f3661m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        return this.f3661m.forEachKey(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        return this.f3661m.forEachValue(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean forEachEntry(TCharCharProcedure tCharCharProcedure) {
        return this.f3661m.forEachEntry(tCharCharProcedure);
    }

    @Override // gnu.trove.map.TCharCharMap
    public TCharCharIterator iterator() {
        return new TCharCharIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableCharCharMap.1
            TCharCharIterator iter;

            {
                this.iter = TUnmodifiableCharCharMap.this.f3661m.iterator();
            }

            @Override // gnu.trove.iterator.TCharCharIterator
            public char key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TCharCharIterator
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

            @Override // gnu.trove.iterator.TCharCharIterator
            public char setValue(char c) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TCharCharMap
    public char putIfAbsent(char c, char c2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharCharMap
    public void transformValues(TCharFunction tCharFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean retainEntries(TCharCharProcedure tCharCharProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean increment(char c) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharCharMap
    public boolean adjustValue(char c, char c2) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TCharCharMap
    public char adjustOrPutValue(char c, char c2, char c3) {
        throw new UnsupportedOperationException();
    }
}