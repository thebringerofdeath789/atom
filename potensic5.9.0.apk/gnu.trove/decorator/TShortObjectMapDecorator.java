package gnu.trove.decorator;

import gnu.trove.iterator.TShortObjectIterator;
import gnu.trove.map.TShortObjectMap;
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
public class TShortObjectMapDecorator<V> extends AbstractMap<Short, V> implements Map<Short, V>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TShortObjectMap<V> _map;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Short sh, Object obj) {
        return put2(sh, (Short) obj);
    }

    public TShortObjectMapDecorator() {
    }

    public TShortObjectMapDecorator(TShortObjectMap<V> tShortObjectMap) {
        Objects.requireNonNull(tShortObjectMap);
        this._map = tShortObjectMap;
    }

    public TShortObjectMap<V> getMap() {
        return this._map;
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(Short sh, V v) {
        short unwrapKey;
        if (sh == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(sh);
        }
        return this._map.put(unwrapKey, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        short noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Short)) {
                return null;
            }
            noEntryKey = unwrapKey((Short) obj);
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
        short noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Short)) {
                return null;
            }
            noEntryKey = unwrapKey((Short) obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        return this._map.remove(noEntryKey);
    }

    /* renamed from: gnu.trove.decorator.TShortObjectMapDecorator$1 */
    class C35011 extends AbstractSet<Map.Entry<Short, V>> {
        C35011() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TShortObjectMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TShortObjectMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TShortObjectMapDecorator.this.containsKey(key) && TShortObjectMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Short, V>> iterator() {
            return new Iterator<Map.Entry<Short, V>>() { // from class: gnu.trove.decorator.TShortObjectMapDecorator.1.1

                /* renamed from: it */
                private final TShortObjectIterator<V> f3576it;

                {
                    this.f3576it = TShortObjectMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Short, V> next() {
                    this.f3576it.advance();
                    short key = this.f3576it.key();
                    return new Map.Entry<Short, V>(this.f3576it.value(), key == TShortObjectMapDecorator.this._map.getNoEntryKey() ? null : TShortObjectMapDecorator.this.wrapKey(key)) { // from class: gnu.trove.decorator.TShortObjectMapDecorator.1.1.1
                        private V val;
                        final /* synthetic */ Short val$key;
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

                        @Override // java.util.Map.Entry
                        public Short getKey() {
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
                            return (V) TShortObjectMapDecorator.this.put2(this.val$key, (Short) v);
                        }
                    };
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f3576it.hasNext();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.f3576it.remove();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<Short, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TShortObjectMapDecorator.this._map.remove(TShortObjectMapDecorator.this.unwrapKey((Short) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Short, V>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TShortObjectMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Short, V>> entrySet() {
        return new C35011();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return this._map.containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Short) && this._map.containsKey(((Short) obj).shortValue());
        }
        TShortObjectMap<V> tShortObjectMap = this._map;
        return tShortObjectMap.containsKey(tShortObjectMap.getNoEntryKey());
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
    public void putAll(Map<? extends Short, ? extends V> map) {
        Iterator<Map.Entry<? extends Short, ? extends V>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Short, ? extends V> next = it.next();
            put2(next.getKey(), (Short) next.getValue());
            size = i;
        }
    }

    protected Short wrapKey(short s) {
        return Short.valueOf(s);
    }

    protected short unwrapKey(Short sh) {
        return sh.shortValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TShortObjectMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}