package gnu.trove.decorator;

import gnu.trove.iterator.TObjectFloatIterator;
import gnu.trove.map.TObjectFloatMap;
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
public class TObjectFloatMapDecorator<K> extends AbstractMap<K, Float> implements Map<K, Float>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TObjectFloatMap<K> _map;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Float put(Object obj, Float f) {
        return put2((TObjectFloatMapDecorator<K>) obj, f);
    }

    public TObjectFloatMapDecorator() {
    }

    public TObjectFloatMapDecorator(TObjectFloatMap<K> tObjectFloatMap) {
        Objects.requireNonNull(tObjectFloatMap);
        this._map = tObjectFloatMap;
    }

    public TObjectFloatMap<K> getMap() {
        return this._map;
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public Float put2(K k, Float f) {
        if (f == null) {
            TObjectFloatMap<K> tObjectFloatMap = this._map;
            return wrapValue(tObjectFloatMap.put(k, tObjectFloatMap.getNoEntryValue()));
        }
        return wrapValue(this._map.put(k, unwrapValue(f)));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Float get(Object obj) {
        float f = this._map.get(obj);
        if (f == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(f);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this._map.clear();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Float remove(Object obj) {
        float remove = this._map.remove(obj);
        if (remove == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(remove);
    }

    /* renamed from: gnu.trove.decorator.TObjectFloatMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<K, Float>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectFloatMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TObjectFloatMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TObjectFloatMapDecorator.this.containsKey(key) && TObjectFloatMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Float>> iterator() {
            return new Iterator<Map.Entry<K, Float>>() { // from class: gnu.trove.decorator.TObjectFloatMapDecorator.1.1
                private final TObjectFloatIterator<K> it;

                {
                    this.it = TObjectFloatMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<K, Float> next() {
                    this.it.advance();
                    return new Map.Entry<K, Float>(TObjectFloatMapDecorator.this.wrapValue(this.it.value()), this.it.key()) { // from class: gnu.trove.decorator.TObjectFloatMapDecorator.1.1.1
                        private Float val;
                        final /* synthetic */ Object val$key;
                        final /* synthetic */ Float val$v;

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
                        public Float getValue() {
                            return this.val;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            return this.val$key.hashCode() + this.val.hashCode();
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Map.Entry
                        public Float setValue(Float f) {
                            this.val = f;
                            return TObjectFloatMapDecorator.this.put2((TObjectFloatMapDecorator) this.val$key, f);
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
        public boolean add(Map.Entry<K, Float> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TObjectFloatMapDecorator.this._map.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, Float>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TObjectFloatMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, Float>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Float) && this._map.containsValue(unwrapValue(obj));
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
    public void putAll(Map<? extends K, ? extends Float> map) {
        Iterator<Map.Entry<? extends K, ? extends Float>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends K, ? extends Float> next = it.next();
            put2((TObjectFloatMapDecorator<K>) next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Float wrapValue(float f) {
        return Float.valueOf(f);
    }

    protected float unwrapValue(Object obj) {
        return ((Float) obj).floatValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TObjectFloatMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
