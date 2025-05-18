package gnu.trove.impl.unmodifiable;

import gnu.trove.TByteCollection;
import gnu.trove.TCollections;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TShortByteIterator;
import gnu.trove.map.TShortByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TShortByteProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableShortByteMap implements TShortByteMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: m */
    private final TShortByteMap f3717m;
    private transient TShortSet keySet = null;
    private transient TByteCollection values = null;

    public TUnmodifiableShortByteMap(TShortByteMap tShortByteMap) {
        Objects.requireNonNull(tShortByteMap);
        this.f3717m = tShortByteMap;
    }

    @Override // gnu.trove.map.TShortByteMap
    public int size() {
        return this.f3717m.size();
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean isEmpty() {
        return this.f3717m.isEmpty();
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean containsKey(short s) {
        return this.f3717m.containsKey(s);
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean containsValue(byte b) {
        return this.f3717m.containsValue(b);
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte get(short s) {
        return this.f3717m.get(s);
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte put(short s, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte remove(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortByteMap
    public void putAll(TShortByteMap tShortByteMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortByteMap
    public void putAll(Map<? extends Short, ? extends Byte> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortByteMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortByteMap
    public TShortSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.f3717m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TShortByteMap
    public short[] keys() {
        return this.f3717m.keys();
    }

    @Override // gnu.trove.map.TShortByteMap
    public short[] keys(short[] sArr) {
        return this.f3717m.keys(sArr);
    }

    @Override // gnu.trove.map.TShortByteMap
    public TByteCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.f3717m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte[] values() {
        return this.f3717m.values();
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte[] values(byte[] bArr) {
        return this.f3717m.values(bArr);
    }

    public boolean equals(Object obj) {
        return obj == this || this.f3717m.equals(obj);
    }

    public int hashCode() {
        return this.f3717m.hashCode();
    }

    public String toString() {
        return this.f3717m.toString();
    }

    @Override // gnu.trove.map.TShortByteMap
    public short getNoEntryKey() {
        return this.f3717m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte getNoEntryValue() {
        return this.f3717m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return this.f3717m.forEachKey(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        return this.f3717m.forEachValue(tByteProcedure);
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean forEachEntry(TShortByteProcedure tShortByteProcedure) {
        return this.f3717m.forEachEntry(tShortByteProcedure);
    }

    @Override // gnu.trove.map.TShortByteMap
    public TShortByteIterator iterator() {
        return new TShortByteIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableShortByteMap.1
            TShortByteIterator iter;

            {
                this.iter = TUnmodifiableShortByteMap.this.f3717m.iterator();
            }

            @Override // gnu.trove.iterator.TShortByteIterator
            public short key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TShortByteIterator
            public byte value() {
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

            @Override // gnu.trove.iterator.TShortByteIterator
            public byte setValue(byte b) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte putIfAbsent(short s, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortByteMap
    public void transformValues(TByteFunction tByteFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean retainEntries(TShortByteProcedure tShortByteProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean increment(short s) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean adjustValue(short s, byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte adjustOrPutValue(short s, byte b, byte b2) {
        throw new UnsupportedOperationException();
    }
}