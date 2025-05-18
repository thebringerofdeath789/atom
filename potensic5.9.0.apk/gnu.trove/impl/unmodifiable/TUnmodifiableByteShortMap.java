package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.iterator.TByteShortIterator;
import gnu.trove.map.TByteShortMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TByteShortProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TByteSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableByteShortMap implements TByteShortMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TByteShortMap f3659m;
    private transient TByteSet keySet = null;
    private transient TShortCollection values = null;

    public TUnmodifiableByteShortMap(TByteShortMap tByteShortMap) {
        Objects.requireNonNull(tByteShortMap);
        this.f3659m = tByteShortMap;
    }

    @Override // gnu.trove.map.TByteShortMap
    public int size() {
        return this.f3659m.size();
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean isEmpty() {
        return this.f3659m.isEmpty();
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean containsKey(byte b) {
        return this.f3659m.containsKey(b);
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean containsValue(short s) {
        return this.f3659m.containsValue(s);
    }

    @Override // gnu.trove.map.TByteShortMap
    public short get(byte b) {
        return this.f3659m.get(b);
    }

    @Override // gnu.trove.map.TByteShortMap
    public short put(byte b, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteShortMap
    public short remove(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteShortMap
    public void putAll(TByteShortMap tByteShortMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteShortMap
    public void putAll(Map<? extends Byte, ? extends Short> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteShortMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteShortMap
    public TByteSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3659m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TByteShortMap
    public byte[] keys() {
        return this.f3659m.keys();
    }

    @Override // gnu.trove.map.TByteShortMap
    public byte[] keys(byte[] bArr) {
        return this.f3659m.keys(bArr);
    }

    @Override // gnu.trove.map.TByteShortMap
    public TShortCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3659m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TByteShortMap
    public short[] values() {
        return this.f3659m.values();
    }

    @Override // gnu.trove.map.TByteShortMap
    public short[] values(short[] sArr) {
        return this.f3659m.values(sArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3659m.equals(obj);
    }

    public int hashCode() {
        return this.f3659m.hashCode();
    }

    public String toString() {
        return this.f3659m.toString();
    }

    @Override // gnu.trove.map.TByteShortMap
    public byte getNoEntryKey() {
        return this.f3659m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteShortMap
    public short getNoEntryValue() {
        return this.f3659m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return this.f3659m.forEachKey(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        return this.f3659m.forEachValue(tShortProcedure);
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean forEachEntry(TByteShortProcedure tByteShortProcedure) {
        return this.f3659m.forEachEntry(tByteShortProcedure);
    }

    @Override // gnu.trove.map.TByteShortMap
    public TByteShortIterator iterator() {
        return new TByteShortIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableByteShortMap.1
            TByteShortIterator iter;

            {
                this.iter = TUnmodifiableByteShortMap.this.f3659m.iterator();
            }

            @Override // gnu.trove.iterator.TByteShortIterator
            public byte key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TByteShortIterator
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

            @Override // gnu.trove.iterator.TByteShortIterator
            public short setValue(short s) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TByteShortMap
    public short putIfAbsent(byte b, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteShortMap
    public void transformValues(TShortFunction tShortFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean retainEntries(TByteShortProcedure tByteShortProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean increment(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteShortMap
    public boolean adjustValue(byte b, short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteShortMap
    public short adjustOrPutValue(byte b, short s, short s2) {
        throw new UnsupportedOperationException();
    }
}