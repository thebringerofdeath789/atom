package gnu.trove.decorator;

import gnu.trove.iterator.TCharObjectIterator;
import gnu.trove.map.TCharObjectMap;
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
public class TCharObjectMapDecorator<V> extends AbstractMap<Character, V> implements Map<Character, V>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TCharObjectMap<V> _map;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Character ch, Object obj) {
        return put2(ch, (Character) obj);
    }

    public TCharObjectMapDecorator() {
    }

    public TCharObjectMapDecorator(TCharObjectMap<V> tCharObjectMap) {
        Objects.requireNonNull(tCharObjectMap);
        this._map = tCharObjectMap;
    }

    public TCharObjectMap<V> getMap() {
        return this._map;
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(Character ch, V v) {
        char unwrapKey;
        if (ch == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(ch);
        }
        return this._map.put(unwrapKey, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        char noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Character)) {
                return null;
            }
            noEntryKey = unwrapKey((Character) obj);
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
        char noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Character)) {
                return null;
            }
            noEntryKey = unwrapKey((Character) obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        return this._map.remove(noEntryKey);
    }

    /* renamed from: gnu.trove.decorator.TCharObjectMapDecorator$1 */
    class C34491 extends AbstractSet<Map.Entry<Character, V>> {
        C34491() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TCharObjectMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TCharObjectMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TCharObjectMapDecorator.this.containsKey(key) && TCharObjectMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Character, V>> iterator() {
            return new Iterator<Map.Entry<Character, V>>() { // from class: gnu.trove.decorator.TCharObjectMapDecorator.1.1

                /* renamed from: it */
                private final TCharObjectIterator<V> f3524it;

                {
                    this.f3524it = TCharObjectMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Character, V> next() {
                    this.f3524it.advance();
                    char key = this.f3524it.key();
                    return new Map.Entry<Character, V>(this.f3524it.value(), key == TCharObjectMapDecorator.this._map.getNoEntryKey() ? null : TCharObjectMapDecorator.this.wrapKey(key)) { // from class: gnu.trove.decorator.TCharObjectMapDecorator.1.1.1
                        private V val;
                        final /* synthetic */ Character val$key;
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
                        public Character getKey() {
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
                            return (V) TCharObjectMapDecorator.this.put2(this.val$key, (Character) v);
                        }
                    };
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f3524it.hasNext();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.f3524it.remove();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<Character, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TCharObjectMapDecorator.this._map.remove(TCharObjectMapDecorator.this.unwrapKey((Character) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Character, V>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TCharObjectMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Character, V>> entrySet() {
        return new C34491();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return this._map.containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Character) && this._map.containsKey(((Character) obj).charValue());
        }
        TCharObjectMap<V> tCharObjectMap = this._map;
        return tCharObjectMap.containsKey(tCharObjectMap.getNoEntryKey());
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
    public void putAll(Map<? extends Character, ? extends V> map) {
        Iterator<Map.Entry<? extends Character, ? extends V>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Character, ? extends V> next = it.next();
            put2(next.getKey(), (Character) next.getValue());
            size = i;
        }
    }

    protected Character wrapKey(char c) {
        return Character.valueOf(c);
    }

    protected char unwrapKey(Character ch) {
        return ch.charValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TCharObjectMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}