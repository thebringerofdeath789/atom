package gnu.trove.decorator;

import gnu.trove.iterator.TCharShortIterator;
import gnu.trove.map.TCharShortMap;
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
public class TCharShortMapDecorator extends AbstractMap<Character, Short> implements Map<Character, Short>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TCharShortMap _map;

    public TCharShortMapDecorator() {
    }

    public TCharShortMapDecorator(TCharShortMap tCharShortMap) {
        Objects.requireNonNull(tCharShortMap);
        this._map = tCharShortMap;
    }

    public TCharShortMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Short put(Character ch, Short sh) {
        char unwrapKey;
        short unwrapValue;
        if (ch == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(ch);
        }
        if (sh == null) {
            unwrapValue = this._map.getNoEntryValue();
        } else {
            unwrapValue = unwrapValue(sh);
        }
        short put = this._map.put(unwrapKey, unwrapValue);
        if (put == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(put);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Short get(Object obj) {
        char noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Character)) {
                return null;
            }
            noEntryKey = unwrapKey(obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        short s = this._map.get(noEntryKey);
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
        char noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Character)) {
                return null;
            }
            noEntryKey = unwrapKey(obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        short remove = this._map.remove(noEntryKey);
        if (remove == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(remove);
    }

    /* renamed from: gnu.trove.decorator.TCharShortMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Character, Short>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TCharShortMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TCharShortMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TCharShortMapDecorator.this.containsKey(key) && TCharShortMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Character, Short>> iterator() {
            return new Iterator<Map.Entry<Character, Short>>() { // from class: gnu.trove.decorator.TCharShortMapDecorator.1.1
                private final TCharShortIterator it;

                {
                    this.it = TCharShortMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Character, Short> next() {
                    this.it.advance();
                    char key = this.it.key();
                    Character wrapKey = key == TCharShortMapDecorator.this._map.getNoEntryKey() ? null : TCharShortMapDecorator.this.wrapKey(key);
                    short value = this.it.value();
                    return new Map.Entry<Character, Short>(value != TCharShortMapDecorator.this._map.getNoEntryValue() ? TCharShortMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TCharShortMapDecorator.1.1.1
                        private Short val;
                        final /* synthetic */ Character val$key;
                        final /* synthetic */ Short val$v;

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
                        public Character getKey() {
                            return this.val$key;
                        }

                        @Override // java.util.Map.Entry
                        public Short getValue() {
                            return this.val;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            return this.val$key.hashCode() + this.val.hashCode();
                        }

                        @Override // java.util.Map.Entry
                        public Short setValue(Short sh) {
                            this.val = sh;
                            return TCharShortMapDecorator.this.put(this.val$key, sh);
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
        public boolean add(Map.Entry<Character, Short> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TCharShortMapDecorator.this._map.remove(TCharShortMapDecorator.this.unwrapKey((Character) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Character, Short>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TCharShortMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Character, Short>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Short) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Character) && this._map.containsKey(unwrapKey(obj));
        }
        TCharShortMap tCharShortMap = this._map;
        return tCharShortMap.containsKey(tCharShortMap.getNoEntryKey());
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
    public void putAll(Map<? extends Character, ? extends Short> map) {
        Iterator<Map.Entry<? extends Character, ? extends Short>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Character, ? extends Short> next = it.next();
            put(next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Character wrapKey(char c) {
        return Character.valueOf(c);
    }

    protected char unwrapKey(Object obj) {
        return ((Character) obj).charValue();
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
        this._map = (TCharShortMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
