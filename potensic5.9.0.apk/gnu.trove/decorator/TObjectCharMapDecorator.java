package gnu.trove.decorator;

import gnu.trove.iterator.TObjectCharIterator;
import gnu.trove.map.TObjectCharMap;
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
public class TObjectCharMapDecorator<K> extends AbstractMap<K, Character> implements Map<K, Character>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TObjectCharMap<K> _map;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Character put(Object obj, Character ch) {
        return put2((TObjectCharMapDecorator<K>) obj, ch);
    }

    public TObjectCharMapDecorator() {
    }

    public TObjectCharMapDecorator(TObjectCharMap<K> tObjectCharMap) {
        Objects.requireNonNull(tObjectCharMap);
        this._map = tObjectCharMap;
    }

    public TObjectCharMap<K> getMap() {
        return this._map;
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public Character put2(K k, Character ch) {
        if (ch == null) {
            TObjectCharMap<K> tObjectCharMap = this._map;
            return wrapValue(tObjectCharMap.put(k, tObjectCharMap.getNoEntryValue()));
        }
        return wrapValue(this._map.put(k, unwrapValue(ch)));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Character get(Object obj) {
        char c = this._map.get(obj);
        if (c == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(c);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this._map.clear();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Character remove(Object obj) {
        char remove = this._map.remove(obj);
        if (remove == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(remove);
    }

    /* renamed from: gnu.trove.decorator.TObjectCharMapDecorator$1 */
    class C34891 extends AbstractSet<Map.Entry<K, Character>> {
        C34891() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectCharMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TObjectCharMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TObjectCharMapDecorator.this.containsKey(key) && TObjectCharMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Character>> iterator() {
            return new Iterator<Map.Entry<K, Character>>() { // from class: gnu.trove.decorator.TObjectCharMapDecorator.1.1

                /* renamed from: it */
                private final TObjectCharIterator<K> f3564it;

                {
                    this.f3564it = TObjectCharMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<K, Character> next() {
                    this.f3564it.advance();
                    return new Map.Entry<K, Character>(TObjectCharMapDecorator.this.wrapValue(this.f3564it.value()), this.f3564it.key()) { // from class: gnu.trove.decorator.TObjectCharMapDecorator.1.1.1
                        private Character val;
                        final /* synthetic */ Object val$key;
                        final /* synthetic */ Character val$v;

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
                        public Character getValue() {
                            return this.val;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            return this.val$key.hashCode() + this.val.hashCode();
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Map.Entry
                        public Character setValue(Character ch) {
                            this.val = ch;
                            return TObjectCharMapDecorator.this.put2((TObjectCharMapDecorator) this.val$key, ch);
                        }
                    };
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f3564it.hasNext();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.f3564it.remove();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<K, Character> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TObjectCharMapDecorator.this._map.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, Character>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TObjectCharMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, Character>> entrySet() {
        return new C34891();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Character) && this._map.containsValue(unwrapValue(obj));
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
    public void putAll(Map<? extends K, ? extends Character> map) {
        Iterator<Map.Entry<? extends K, ? extends Character>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends K, ? extends Character> next = it.next();
            put2((TObjectCharMapDecorator<K>) next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Character wrapValue(char c) {
        return Character.valueOf(c);
    }

    protected char unwrapValue(Object obj) {
        return ((Character) obj).charValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TObjectCharMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}