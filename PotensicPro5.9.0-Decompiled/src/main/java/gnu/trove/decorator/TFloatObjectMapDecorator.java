package gnu.trove.decorator;

import gnu.trove.iterator.TFloatObjectIterator;
import gnu.trove.map.TFloatObjectMap;
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
public class TFloatObjectMapDecorator<V> extends AbstractMap<Float, V> implements Map<Float, V>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TFloatObjectMap<V> _map;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Float f, Object obj) {
        return put2(f, (Float) obj);
    }

    public TFloatObjectMapDecorator() {
    }

    public TFloatObjectMapDecorator(TFloatObjectMap<V> tFloatObjectMap) {
        Objects.requireNonNull(tFloatObjectMap);
        this._map = tFloatObjectMap;
    }

    public TFloatObjectMap<V> getMap() {
        return this._map;
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(Float f, V v) {
        float unwrapKey;
        if (f == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(f);
        }
        return this._map.put(unwrapKey, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        float noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Float)) {
                return null;
            }
            noEntryKey = unwrapKey((Float) obj);
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
        float noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Float)) {
                return null;
            }
            noEntryKey = unwrapKey((Float) obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        return this._map.remove(noEntryKey);
    }

    /* renamed from: gnu.trove.decorator.TFloatObjectMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Float, V>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TFloatObjectMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TFloatObjectMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TFloatObjectMapDecorator.this.containsKey(key) && TFloatObjectMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Float, V>> iterator() {
            return new Iterator<Map.Entry<Float, V>>() { // from class: gnu.trove.decorator.TFloatObjectMapDecorator.1.1
                private final TFloatObjectIterator<V> it;

                {
                    this.it = TFloatObjectMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Float, V> next() {
                    this.it.advance();
                    float key = this.it.key();
                    return new Map.Entry<Float, V>(this.it.value(), key == TFloatObjectMapDecorator.this._map.getNoEntryKey() ? null : TFloatObjectMapDecorator.this.wrapKey(key)) { // from class: gnu.trove.decorator.TFloatObjectMapDecorator.1.1.1
                        private V val;
                        final /* synthetic */ Float val$key;
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
                        public Float getKey() {
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
                            return (V) TFloatObjectMapDecorator.this.put2(this.val$key, (Float) v);
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
        public boolean add(Map.Entry<Float, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TFloatObjectMapDecorator.this._map.remove(TFloatObjectMapDecorator.this.unwrapKey((Float) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Float, V>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TFloatObjectMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Float, V>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return this._map.containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Float) && this._map.containsKey(((Float) obj).floatValue());
        }
        TFloatObjectMap<V> tFloatObjectMap = this._map;
        return tFloatObjectMap.containsKey(tFloatObjectMap.getNoEntryKey());
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
    public void putAll(Map<? extends Float, ? extends V> map) {
        Iterator<Map.Entry<? extends Float, ? extends V>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Float, ? extends V> next = it.next();
            put2(next.getKey(), (Float) next.getValue());
            size = i;
        }
    }

    protected Float wrapKey(float f) {
        return Float.valueOf(f);
    }

    protected float unwrapKey(Float f) {
        return f.floatValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TFloatObjectMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
