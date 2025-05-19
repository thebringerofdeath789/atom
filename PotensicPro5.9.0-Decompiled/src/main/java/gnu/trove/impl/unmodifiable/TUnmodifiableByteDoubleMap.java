package gnu.trove.impl.unmodifiable;

import gnu.trove.TCollections;
import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.iterator.TByteDoubleIterator;
import gnu.trove.map.TByteDoubleMap;
import gnu.trove.procedure.TByteDoubleProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.set.TByteSet;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TUnmodifiableByteDoubleMap implements TByteDoubleMap, Serializable {
    private static final long serialVersionUID = -1034234728574286014L;
    private final TByteDoubleMap m;
    private transient TByteSet keySet = null;
    private transient TDoubleCollection values = null;

    public TUnmodifiableByteDoubleMap(TByteDoubleMap tByteDoubleMap) {
        Objects.requireNonNull(tByteDoubleMap);
        this.m = tByteDoubleMap;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public int size() {
        return this.m.size();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean isEmpty() {
        return this.m.isEmpty();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean containsKey(byte b) {
        return this.m.containsKey(b);
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean containsValue(double d) {
        return this.m.containsValue(d);
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double get(byte b) {
        return this.m.get(b);
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double put(byte b, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double remove(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public void putAll(TByteDoubleMap tByteDoubleMap) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public void putAll(Map<? extends Byte, ? extends Double> map) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public TByteSet keySet() {
        if (this.keySet == null) {
            this.keySet = TCollections.unmodifiableSet(this.m.keySet());
        }
        return this.keySet;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public byte[] keys() {
        return this.m.keys();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public byte[] keys(byte[] bArr) {
        return this.m.keys(bArr);
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public TDoubleCollection valueCollection() {
        if (this.values == null) {
            this.values = TCollections.unmodifiableCollection(this.m.valueCollection());
        }
        return this.values;
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double[] values() {
        return this.m.values();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double[] values(double[] dArr) {
        return this.m.values(dArr);
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

    @Override // gnu.trove.map.TByteDoubleMap
    public byte getNoEntryKey() {
        return this.m.getNoEntryKey();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double getNoEntryValue() {
        return this.m.getNoEntryValue();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return this.m.forEachKey(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        return this.m.forEachValue(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean forEachEntry(TByteDoubleProcedure tByteDoubleProcedure) {
        return this.m.forEachEntry(tByteDoubleProcedure);
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public TByteDoubleIterator iterator() {
        return new TByteDoubleIterator() { // from class: gnu.trove.impl.unmodifiable.TUnmodifiableByteDoubleMap.1
            TByteDoubleIterator iter;

            {
                this.iter = TUnmodifiableByteDoubleMap.this.m.iterator();
            }

            @Override // gnu.trove.iterator.TByteDoubleIterator
            public byte key() {
                return this.iter.key();
            }

            @Override // gnu.trove.iterator.TByteDoubleIterator
            public double value() {
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

            @Override // gnu.trove.iterator.TByteDoubleIterator
            public double setValue(double d) {
                throw new UnsupportedOperationException();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double putIfAbsent(byte b, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean retainEntries(TByteDoubleProcedure tByteDoubleProcedure) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean increment(byte b) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public boolean adjustValue(byte b, double d) {
        throw new UnsupportedOperationException();
    }

    @Override // gnu.trove.map.TByteDoubleMap
    public double adjustOrPutValue(byte b, double d, double d2) {
        throw new UnsupportedOperationException();
    }
}
