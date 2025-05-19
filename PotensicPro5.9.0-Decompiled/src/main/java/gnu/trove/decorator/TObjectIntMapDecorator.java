package gnu.trove.decorator;

import gnu.trove.iterator.TObjectIntIterator;
import gnu.trove.map.TObjectIntMap;
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
public class TObjectIntMapDecorator<K> extends AbstractMap<K, Integer> implements Map<K, Integer>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TObjectIntMap<K> _map;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Integer put(Object obj, Integer num) {
        return put2((TObjectIntMapDecorator<K>) obj, num);
    }

    public TObjectIntMapDecorator() {
    }

    public TObjectIntMapDecorator(TObjectIntMap<K> tObjectIntMap) {
        Objects.requireNonNull(tObjectIntMap);
        this._map = tObjectIntMap;
    }

    public TObjectIntMap<K> getMap() {
        return this._map;
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public Integer put2(K k, Integer num) {
        if (num == null) {
            TObjectIntMap<K> tObjectIntMap = this._map;
            return wrapValue(tObjectIntMap.put(k, tObjectIntMap.getNoEntryValue()));
        }
        return wrapValue(this._map.put(k, unwrapValue(num)));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Integer get(Object obj) {
        int i = this._map.get(obj);
        if (i == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this._map.clear();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Integer remove(Object obj) {
        int remove = this._map.remove(obj);
        if (remove == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(remove);
    }

    /* renamed from: gnu.trove.decorator.TObjectIntMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<K, Integer>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectIntMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TObjectIntMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TObjectIntMapDecorator.this.containsKey(key) && TObjectIntMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Integer>> iterator() {
            return new Iterator<Map.Entry<K, Integer>>() { // from class: gnu.trove.decorator.TObjectIntMapDecorator.1.1
                private final TObjectIntIterator<K> it;

                {
                    this.it = TObjectIntMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<K, Integer> next() {
                    this.it.advance();
                    return new Map.Entry<K, Integer>(TObjectIntMapDecorator.this.wrapValue(this.it.value()), this.it.key()) { // from class: gnu.trove.decorator.TObjectIntMapDecorator.1.1.1
                        private Integer val;
                        final /* synthetic */ Object val$key;
                        final /* synthetic */ Integer val$v;

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
                        public Integer getValue() {
                            return this.val;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            return this.val$key.hashCode() + this.val.hashCode();
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Map.Entry
                        public Integer setValue(Integer num) {
                            this.val = num;
                            return TObjectIntMapDecorator.this.put2((TObjectIntMapDecorator) this.val$key, num);
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
        public boolean add(Map.Entry<K, Integer> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TObjectIntMapDecorator.this._map.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, Integer>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TObjectIntMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, Integer>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Integer) && this._map.containsValue(unwrapValue(obj));
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
    public void putAll(Map<? extends K, ? extends Integer> map) {
        Iterator<Map.Entry<? extends K, ? extends Integer>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends K, ? extends Integer> next = it.next();
            put2((TObjectIntMapDecorator<K>) next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Integer wrapValue(int i) {
        return Integer.valueOf(i);
    }

    protected int unwrapValue(Object obj) {
        return ((Integer) obj).intValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TObjectIntMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
