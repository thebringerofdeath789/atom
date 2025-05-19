package gnu.trove.decorator;

import gnu.trove.iterator.TDoubleObjectIterator;
import gnu.trove.map.TDoubleObjectMap;
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
public class TDoubleObjectMapDecorator<V> extends AbstractMap<Double, V> implements Map<Double, V>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TDoubleObjectMap<V> _map;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Double d, Object obj) {
        return put2(d, (Double) obj);
    }

    public TDoubleObjectMapDecorator() {
    }

    public TDoubleObjectMapDecorator(TDoubleObjectMap<V> tDoubleObjectMap) {
        Objects.requireNonNull(tDoubleObjectMap);
        this._map = tDoubleObjectMap;
    }

    public TDoubleObjectMap<V> getMap() {
        return this._map;
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(Double d, V v) {
        double unwrapKey;
        if (d == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(d);
        }
        return this._map.put(unwrapKey, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        double noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Double)) {
                return null;
            }
            noEntryKey = unwrapKey((Double) obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        return this._map.get(noEntryKey);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this._map.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        double noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Double)) {
                return null;
            }
            noEntryKey = unwrapKey((Double) obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        return this._map.remove(noEntryKey);
    }

    /* renamed from: gnu.trove.decorator.TDoubleObjectMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Double, V>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TDoubleObjectMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TDoubleObjectMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TDoubleObjectMapDecorator.this.containsKey(key) && TDoubleObjectMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Double, V>> iterator() {
            return new Iterator<Map.Entry<Double, V>>() { // from class: gnu.trove.decorator.TDoubleObjectMapDecorator.1.1
                private final TDoubleObjectIterator<V> it;

                {
                    this.it = TDoubleObjectMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Double, V> next() {
                    this.it.advance();
                    double key = this.it.key();
                    return new Map.Entry<Double, V>(this.it.value(), key == TDoubleObjectMapDecorator.this._map.getNoEntryKey() ? null : TDoubleObjectMapDecorator.this.wrapKey(key)) { // from class: gnu.trove.decorator.TDoubleObjectMapDecorator.1.1.1
                        private V val;
                        final /* synthetic */ Double val$key;
                        final /* synthetic */ Object val$v;

                        /* JADX WARN: Multi-variable type inference failed */
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

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Map.Entry
                        public Double getKey() {
                            return this.val$key;
                        }

                        @Override // java.util.Map.Entry
                        public V getValue() {
                            return this.val;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            return this.val$key.hashCode() + this.val.hashCode();
                        }

                        @Override // java.util.Map.Entry
                        public V setValue(V v) {
                            this.val = v;
                            return (V) TDoubleObjectMapDecorator.this.put2(this.val$key, (Double) v);
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
        public boolean add(Map.Entry<Double, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TDoubleObjectMapDecorator.this._map.remove(TDoubleObjectMapDecorator.this.unwrapKey((Double) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Double, V>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TDoubleObjectMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Double, V>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return this._map.containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Double) && this._map.containsKey(((Double) obj).doubleValue());
        }
        TDoubleObjectMap<V> tDoubleObjectMap = this._map;
        return tDoubleObjectMap.containsKey(tDoubleObjectMap.getNoEntryKey());
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
    public void putAll(Map<? extends Double, ? extends V> map) {
        Iterator<Map.Entry<? extends Double, ? extends V>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Double, ? extends V> next = it.next();
            put2(next.getKey(), (Double) next.getValue());
            size = i;
        }
    }

    protected Double wrapKey(double d) {
        return Double.valueOf(d);
    }

    protected double unwrapKey(Double d) {
        return d.doubleValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TDoubleObjectMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
