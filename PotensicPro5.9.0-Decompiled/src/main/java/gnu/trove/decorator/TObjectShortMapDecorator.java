package gnu.trove.decorator;

import gnu.trove.iterator.TObjectShortIterator;
import gnu.trove.map.TObjectShortMap;
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
public class TObjectShortMapDecorator<K> extends AbstractMap<K, Short> implements Map<K, Short>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TObjectShortMap<K> _map;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Short put(Object obj, Short sh) {
        return put2((TObjectShortMapDecorator<K>) obj, sh);
    }

    public TObjectShortMapDecorator() {
    }

    public TObjectShortMapDecorator(TObjectShortMap<K> tObjectShortMap) {
        Objects.requireNonNull(tObjectShortMap);
        this._map = tObjectShortMap;
    }

    public TObjectShortMap<K> getMap() {
        return this._map;
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public Short put2(K k, Short sh) {
        if (sh == null) {
            TObjectShortMap<K> tObjectShortMap = this._map;
            return wrapValue(tObjectShortMap.put(k, tObjectShortMap.getNoEntryValue()));
        }
        return wrapValue(this._map.put(k, unwrapValue(sh)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Short get(Object obj) {
        short s = this._map.get(obj);
        if (s == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(s);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this._map.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Short remove(Object obj) {
        short remove = this._map.remove(obj);
        if (remove == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(remove);
    }

    /* renamed from: gnu.trove.decorator.TObjectShortMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<K, Short>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectShortMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TObjectShortMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TObjectShortMapDecorator.this.containsKey(key) && TObjectShortMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Short>> iterator() {
            return new Iterator<Map.Entry<K, Short>>() { // from class: gnu.trove.decorator.TObjectShortMapDecorator.1.1
                private final TObjectShortIterator<K> it;

                {
                    this.it = TObjectShortMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<K, Short> next() {
                    this.it.advance();
                    return new Map.Entry<K, Short>(TObjectShortMapDecorator.this.wrapValue(this.it.value()), this.it.key()) { // from class: gnu.trove.decorator.TObjectShortMapDecorator.1.1.1
                        private Short val;
                        final /* synthetic */ Object val$key;
                        final /* synthetic */ Short val$v;

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

                        @Override // java.util.Map.Entry
                        public Short getValue() {
                            return this.val;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            return this.val$key.hashCode() + this.val.hashCode();
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Map.Entry
                        public Short setValue(Short sh) {
                            this.val = sh;
                            return TObjectShortMapDecorator.this.put2((TObjectShortMapDecorator) this.val$key, sh);
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
        public boolean add(Map.Entry<K, Short> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TObjectShortMapDecorator.this._map.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, Short>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TObjectShortMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, Short>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Short) && this._map.containsValue(unwrapValue(obj));
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
    public void putAll(Map<? extends K, ? extends Short> map) {
        Iterator<Map.Entry<? extends K, ? extends Short>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends K, ? extends Short> next = it.next();
            put2((TObjectShortMapDecorator<K>) next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Short wrapValue(short s) {
        return Short.valueOf(s);
    }

    protected short unwrapValue(Object obj) {
        return ((Short) obj).shortValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TObjectShortMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
