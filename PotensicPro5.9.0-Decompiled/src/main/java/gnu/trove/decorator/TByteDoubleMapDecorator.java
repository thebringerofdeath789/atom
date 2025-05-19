package gnu.trove.decorator;

import gnu.trove.iterator.TByteDoubleIterator;
import gnu.trove.map.TByteDoubleMap;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class TByteDoubleMapDecorator extends AbstractMap<Byte, Double> implements Map<Byte, Double>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TByteDoubleMap _map;

    public TByteDoubleMapDecorator() {
    }

    public TByteDoubleMapDecorator(TByteDoubleMap tByteDoubleMap) {
        Objects.requireNonNull(tByteDoubleMap);
        this._map = tByteDoubleMap;
    }

    public TByteDoubleMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Double put(Byte b, Double d) {
        byte unwrapKey;
        double unwrapValue;
        if (b == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(b);
        }
        if (d == null) {
            unwrapValue = this._map.getNoEntryValue();
        } else {
            unwrapValue = unwrapValue(d);
        }
        double put = this._map.put(unwrapKey, unwrapValue);
        if (put == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(put);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Double get(Object obj) {
        byte noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Byte)) {
                return null;
            }
            noEntryKey = unwrapKey(obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        double d = this._map.get(noEntryKey);
        if (d == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(d);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this._map.clear();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Double remove(Object obj) {
        byte noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Byte)) {
                return null;
            }
            noEntryKey = unwrapKey(obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        double remove = this._map.remove(noEntryKey);
        if (remove == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(remove);
    }

    /* renamed from: gnu.trove.decorator.TByteDoubleMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Byte, Double>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TByteDoubleMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TByteDoubleMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TByteDoubleMapDecorator.this.containsKey(key) && TByteDoubleMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Byte, Double>> iterator() {
            return new Iterator<Map.Entry<Byte, Double>>() { // from class: gnu.trove.decorator.TByteDoubleMapDecorator.1.1
                private final TByteDoubleIterator it;

                {
                    this.it = TByteDoubleMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Byte, Double> next() {
                    this.it.advance();
                    byte key = this.it.key();
                    Byte wrapKey = key == TByteDoubleMapDecorator.this._map.getNoEntryKey() ? null : TByteDoubleMapDecorator.this.wrapKey(key);
                    double value = this.it.value();
                    return new Map.Entry<Byte, Double>(value != TByteDoubleMapDecorator.this._map.getNoEntryValue() ? TByteDoubleMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TByteDoubleMapDecorator.1.1.1
                        private Double val;
                        final /* synthetic */ Byte val$key;
                        final /* synthetic */ Double val$v;

                        {
                            this.val$v = r2;
                            this.val$key = wrapKey;
                            this.val = r2;
                        }

                        @Override // java.util.Map.Entry
                        public boolean equals(Object obj) {
                            if (obj instanceof Map.Entry) {
                                Map.Entry entry = (Map.Entry) obj;
                                if (entry.getKey().equals(this.val$key) && entry.getValue().equals(this.val)) {
                                    return true;
                                }
                            }
                            return false;
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Map.Entry
                        public Byte getKey() {
                            return this.val$key;
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Map.Entry
                        public Double getValue() {
                            return this.val;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            return this.val$key.hashCode() + this.val.hashCode();
                        }

                        @Override // java.util.Map.Entry
                        public Double setValue(Double d) {
                            this.val = d;
                            return TByteDoubleMapDecorator.this.put(this.val$key, d);
                        }
                    };
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.it.hasNext();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.it.remove();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<Byte, Double> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TByteDoubleMapDecorator.this._map.remove(TByteDoubleMapDecorator.this.unwrapKey((Byte) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Byte, Double>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TByteDoubleMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Byte, Double>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Double) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Byte) && this._map.containsKey(unwrapKey(obj));
        }
        TByteDoubleMap tByteDoubleMap = this._map;
        return tByteDoubleMap.containsKey(tByteDoubleMap.getNoEntryKey());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this._map.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends Byte, ? extends Double> map) {
        Iterator<Map.Entry<? extends Byte, ? extends Double>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Byte, ? extends Double> next = it.next();
            put(next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Byte wrapKey(byte b) {
        return Byte.valueOf(b);
    }

    protected byte unwrapKey(Object obj) {
        return ((Byte) obj).byteValue();
    }

    protected Double wrapValue(double d) {
        return Double.valueOf(d);
    }

    protected double unwrapValue(Object obj) {
        return ((Double) obj).doubleValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TByteDoubleMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
