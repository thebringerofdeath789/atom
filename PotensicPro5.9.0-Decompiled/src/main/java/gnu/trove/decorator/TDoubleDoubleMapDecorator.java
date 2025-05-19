package gnu.trove.decorator;

import gnu.trove.iterator.TDoubleDoubleIterator;
import gnu.trove.map.TDoubleDoubleMap;
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
public class TDoubleDoubleMapDecorator extends AbstractMap<Double, Double> implements Map<Double, Double>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TDoubleDoubleMap _map;

    public TDoubleDoubleMapDecorator() {
    }

    public TDoubleDoubleMapDecorator(TDoubleDoubleMap tDoubleDoubleMap) {
        Objects.requireNonNull(tDoubleDoubleMap);
        this._map = tDoubleDoubleMap;
    }

    public TDoubleDoubleMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Double put(Double d, Double d2) {
        double unwrapKey;
        double unwrapValue;
        if (d == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(d);
        }
        if (d2 == null) {
            unwrapValue = this._map.getNoEntryValue();
        } else {
            unwrapValue = unwrapValue(d2);
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
        double noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Double)) {
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
        double noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Double)) {
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

    /* renamed from: gnu.trove.decorator.TDoubleDoubleMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Double, Double>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TDoubleDoubleMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TDoubleDoubleMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TDoubleDoubleMapDecorator.this.containsKey(key) && TDoubleDoubleMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Double, Double>> iterator() {
            return new Iterator<Map.Entry<Double, Double>>() { // from class: gnu.trove.decorator.TDoubleDoubleMapDecorator.1.1
                private final TDoubleDoubleIterator it;

                {
                    this.it = TDoubleDoubleMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Double, Double> next() {
                    this.it.advance();
                    double key = this.it.key();
                    Double wrapKey = key == TDoubleDoubleMapDecorator.this._map.getNoEntryKey() ? null : TDoubleDoubleMapDecorator.this.wrapKey(key);
                    double value = this.it.value();
                    return new Map.Entry<Double, Double>(value != TDoubleDoubleMapDecorator.this._map.getNoEntryValue() ? TDoubleDoubleMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TDoubleDoubleMapDecorator.1.1.1
                        private Double val;
                        final /* synthetic */ Double val$key;
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
                        public Double getKey() {
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
                            return TDoubleDoubleMapDecorator.this.put(this.val$key, d);
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
        public boolean add(Map.Entry<Double, Double> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TDoubleDoubleMapDecorator.this._map.remove(TDoubleDoubleMapDecorator.this.unwrapKey((Double) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Double, Double>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TDoubleDoubleMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Double, Double>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Double) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Double) && this._map.containsKey(unwrapKey(obj));
        }
        TDoubleDoubleMap tDoubleDoubleMap = this._map;
        return tDoubleDoubleMap.containsKey(tDoubleDoubleMap.getNoEntryKey());
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
    public void putAll(Map<? extends Double, ? extends Double> map) {
        Iterator<Map.Entry<? extends Double, ? extends Double>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Double, ? extends Double> next = it.next();
            put(next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Double wrapKey(double d) {
        return Double.valueOf(d);
    }

    protected double unwrapKey(Object obj) {
        return ((Double) obj).doubleValue();
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
        this._map = (TDoubleDoubleMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
