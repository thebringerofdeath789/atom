package gnu.trove.decorator;

import gnu.trove.iterator.TLongCharIterator;
import gnu.trove.map.TLongCharMap;
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
public class TLongCharMapDecorator extends AbstractMap<Long, Character> implements Map<Long, Character>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TLongCharMap _map;

    public TLongCharMapDecorator() {
    }

    public TLongCharMapDecorator(TLongCharMap tLongCharMap) {
        Objects.requireNonNull(tLongCharMap);
        this._map = tLongCharMap;
    }

    public TLongCharMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Character put(Long l, Character ch) {
        long unwrapKey;
        char unwrapValue;
        if (l == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(l);
        }
        if (ch == null) {
            unwrapValue = this._map.getNoEntryValue();
        } else {
            unwrapValue = unwrapValue(ch);
        }
        char put = this._map.put(unwrapKey, unwrapValue);
        if (put == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(put);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Character get(Object obj) {
        long noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Long)) {
                return null;
            }
            noEntryKey = unwrapKey(obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        char c = this._map.get(noEntryKey);
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
        long noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Long)) {
                return null;
            }
            noEntryKey = unwrapKey(obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        char remove = this._map.remove(noEntryKey);
        if (remove == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(remove);
    }

    /* renamed from: gnu.trove.decorator.TLongCharMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Long, Character>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TLongCharMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TLongCharMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TLongCharMapDecorator.this.containsKey(key) && TLongCharMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Long, Character>> iterator() {
            return new Iterator<Map.Entry<Long, Character>>() { // from class: gnu.trove.decorator.TLongCharMapDecorator.1.1
                private final TLongCharIterator it;

                {
                    this.it = TLongCharMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Long, Character> next() {
                    this.it.advance();
                    long key = this.it.key();
                    Long wrapKey = key == TLongCharMapDecorator.this._map.getNoEntryKey() ? null : TLongCharMapDecorator.this.wrapKey(key);
                    char value = this.it.value();
                    return new Map.Entry<Long, Character>(value != TLongCharMapDecorator.this._map.getNoEntryValue() ? TLongCharMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TLongCharMapDecorator.1.1.1
                        private Character val;
                        final /* synthetic */ Long val$key;
                        final /* synthetic */ Character val$v;

                        {
                            this.val$v = r2;
                            this.val$key = wrapKey;
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

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Map.Entry
                        public Character getValue() {
                            return this.val;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            return this.val$key.hashCode() + this.val.hashCode();
                        }

                        @Override // java.util.Map.Entry
                        public Character setValue(Character ch) {
                            this.val = ch;
                            return TLongCharMapDecorator.this.put(this.val$key, ch);
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
        public boolean add(Map.Entry<Long, Character> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TLongCharMapDecorator.this._map.remove(TLongCharMapDecorator.this.unwrapKey((Long) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Long, Character>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TLongCharMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Long, Character>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Character) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Long) && this._map.containsKey(unwrapKey(obj));
        }
        TLongCharMap tLongCharMap = this._map;
        return tLongCharMap.containsKey(tLongCharMap.getNoEntryKey());
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
    public void putAll(Map<? extends Long, ? extends Character> map) {
        Iterator<Map.Entry<? extends Long, ? extends Character>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Long, ? extends Character> next = it.next();
            put(next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Long wrapKey(long j) {
        return Long.valueOf(j);
    }

    protected long unwrapKey(Object obj) {
        return ((Long) obj).longValue();
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
        this._map = (TLongCharMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
