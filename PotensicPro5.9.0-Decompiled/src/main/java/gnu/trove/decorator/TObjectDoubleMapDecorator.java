package gnu.trove.decorator;

import gnu.trove.iterator.TObjectDoubleIterator;
import gnu.trove.map.TObjectDoubleMap;
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
public class TObjectDoubleMapDecorator<K> extends AbstractMap<K, Double> implements Map<K, Double>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TObjectDoubleMap<K> _map;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Double put(Object obj, Double d) {
        return put2((TObjectDoubleMapDecorator<K>) obj, d);
    }

    public TObjectDoubleMapDecorator() {
    }

    public TObjectDoubleMapDecorator(TObjectDoubleMap<K> tObjectDoubleMap) {
        Objects.requireNonNull(tObjectDoubleMap);
        this._map = tObjectDoubleMap;
    }

    public TObjectDoubleMap<K> getMap() {
        return this._map;
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public Double put2(K k, Double d) {
        if (d == null) {
            TObjectDoubleMap<K> tObjectDoubleMap = this._map;
            return wrapValue(tObjectDoubleMap.put(k, tObjectDoubleMap.getNoEntryValue()));
        }
        return wrapValue(this._map.put(k, unwrapValue(d)));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Double get(Object obj) {
        double d = this._map.get(obj);
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
        double remove = this._map.remove(obj);
        if (remove == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(remove);
    }

    /* renamed from: gnu.trove.decorator.TObjectDoubleMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<K, Double>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectDoubleMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TObjectDoubleMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TObjectDoubleMapDecorator.this.containsKey(key) && TObjectDoubleMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Double>> iterator() {
            return new Iterator<Map.Entry<K, Double>>() { // from class: gnu.trove.decorator.TObjectDoubleMapDecorator.1.1
                private final TObjectDoubleIterator<K> it;

                {
                    this.it = TObjectDoubleMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<K, Double> next() {
                    this.it.advance();
                    return new Map.Entry<K, Double>(TObjectDoubleMapDecorator.this.wrapValue(this.it.value()), this.it.key()) { // from class: gnu.trove.decorator.TObjectDoubleMapDecorator.1.1.1
                        private Double val;
                        final /* synthetic */ Object val$key;
                        final /* synthetic */ Double val$v;

                        {
                            this.val$v = r2;
                            this.val$key = r3;
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

                        @Override // java.util.Map.Entry
                        public K getKey() {
                            return (K) this.val$key;
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

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Map.Entry
                        public Double setValue(Double d) {
                            this.val = d;
                            return TObjectDoubleMapDecorator.this.put2((TObjectDoubleMapDecorator) this.val$key, d);
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
        public boolean add(Map.Entry<K, Double> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TObjectDoubleMapDecorator.this._map.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, Double>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TObjectDoubleMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, Double>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Double) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this._map.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this._map.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this._map.size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends Double> map) {
        Iterator<Map.Entry<? extends K, ? extends Double>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends K, ? extends Double> next = it.next();
            put2((TObjectDoubleMapDecorator<K>) next.getKey(), next.getValue());
            size = i;
        }
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
        this._map = (TObjectDoubleMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
