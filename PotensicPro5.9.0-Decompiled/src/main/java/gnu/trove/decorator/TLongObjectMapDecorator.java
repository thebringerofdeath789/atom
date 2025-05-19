package gnu.trove.decorator;

import gnu.trove.iterator.TLongObjectIterator;
import gnu.trove.map.TLongObjectMap;
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
public class TLongObjectMapDecorator<V> extends AbstractMap<Long, V> implements Map<Long, V>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TLongObjectMap<V> _map;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Long l, Object obj) {
        return put2(l, (Long) obj);
    }

    public TLongObjectMapDecorator() {
    }

    public TLongObjectMapDecorator(TLongObjectMap<V> tLongObjectMap) {
        Objects.requireNonNull(tLongObjectMap);
        this._map = tLongObjectMap;
    }

    public TLongObjectMap<V> getMap() {
        return this._map;
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(Long l, V v) {
        long unwrapKey;
        if (l == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(l);
        }
        return this._map.put(unwrapKey, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        long noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Long)) {
                return null;
            }
            noEntryKey = unwrapKey((Long) obj);
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
        long noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Long)) {
                return null;
            }
            noEntryKey = unwrapKey((Long) obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        return this._map.remove(noEntryKey);
    }

    /* renamed from: gnu.trove.decorator.TLongObjectMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Long, V>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TLongObjectMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TLongObjectMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TLongObjectMapDecorator.this.containsKey(key) && TLongObjectMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Long, V>> iterator() {
            return new Iterator<Map.Entry<Long, V>>() { // from class: gnu.trove.decorator.TLongObjectMapDecorator.1.1
                private final TLongObjectIterator<V> it;

                {
                    this.it = TLongObjectMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Long, V> next() {
                    this.it.advance();
                    long key = this.it.key();
                    return new Map.Entry<Long, V>(this.it.value(), key == TLongObjectMapDecorator.this._map.getNoEntryKey() ? null : TLongObjectMapDecorator.this.wrapKey(key)) { // from class: gnu.trove.decorator.TLongObjectMapDecorator.1.1.1
                        private V val;
                        final /* synthetic */ Long val$key;
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
                        public Long getKey() {
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
                            return (V) TLongObjectMapDecorator.this.put2(this.val$key, (Long) v);
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
        public boolean add(Map.Entry<Long, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TLongObjectMapDecorator.this._map.remove(TLongObjectMapDecorator.this.unwrapKey((Long) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Long, V>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TLongObjectMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Long, V>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return this._map.containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Long) && this._map.containsKey(((Long) obj).longValue());
        }
        TLongObjectMap<V> tLongObjectMap = this._map;
        return tLongObjectMap.containsKey(tLongObjectMap.getNoEntryKey());
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
    public void putAll(Map<? extends Long, ? extends V> map) {
        Iterator<Map.Entry<? extends Long, ? extends V>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Long, ? extends V> next = it.next();
            put2(next.getKey(), (Long) next.getValue());
            size = i;
        }
    }

    protected Long wrapKey(long j) {
        return Long.valueOf(j);
    }

    protected long unwrapKey(Long l) {
        return l.longValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TLongObjectMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
