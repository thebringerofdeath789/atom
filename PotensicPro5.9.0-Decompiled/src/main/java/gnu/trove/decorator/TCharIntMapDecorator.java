package gnu.trove.decorator;

import gnu.trove.iterator.TCharIntIterator;
import gnu.trove.map.TCharIntMap;
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
public class TCharIntMapDecorator extends AbstractMap<Character, Integer> implements Map<Character, Integer>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TCharIntMap _map;

    public TCharIntMapDecorator() {
    }

    public TCharIntMapDecorator(TCharIntMap tCharIntMap) {
        Objects.requireNonNull(tCharIntMap);
        this._map = tCharIntMap;
    }

    public TCharIntMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Integer put(Character ch, Integer num) {
        char unwrapKey;
        int unwrapValue;
        if (ch == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(ch);
        }
        if (num == null) {
            unwrapValue = this._map.getNoEntryValue();
        } else {
            unwrapValue = unwrapValue(num);
        }
        int put = this._map.put(unwrapKey, unwrapValue);
        if (put == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(put);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Integer get(Object obj) {
        char noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Character)) {
                return null;
            }
            noEntryKey = unwrapKey(obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        int i = this._map.get(noEntryKey);
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
        char noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Character)) {
                return null;
            }
            noEntryKey = unwrapKey(obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        int remove = this._map.remove(noEntryKey);
        if (remove == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(remove);
    }

    /* renamed from: gnu.trove.decorator.TCharIntMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Character, Integer>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TCharIntMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TCharIntMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TCharIntMapDecorator.this.containsKey(key) && TCharIntMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Character, Integer>> iterator() {
            return new Iterator<Map.Entry<Character, Integer>>() { // from class: gnu.trove.decorator.TCharIntMapDecorator.1.1
                private final TCharIntIterator it;

                {
                    this.it = TCharIntMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Character, Integer> next() {
                    this.it.advance();
                    char key = this.it.key();
                    Character wrapKey = key == TCharIntMapDecorator.this._map.getNoEntryKey() ? null : TCharIntMapDecorator.this.wrapKey(key);
                    int value = this.it.value();
                    return new Map.Entry<Character, Integer>(value != TCharIntMapDecorator.this._map.getNoEntryValue() ? TCharIntMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TCharIntMapDecorator.1.1.1
                        private Integer val;
                        final /* synthetic */ Character val$key;
                        final /* synthetic */ Integer val$v;

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

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Map.Entry
                        public Integer getValue() {
                            return this.val;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            return this.val$key.hashCode() + this.val.hashCode();
                        }

                        @Override // java.util.Map.Entry
                        public Integer setValue(Integer num) {
                            this.val = num;
                            return TCharIntMapDecorator.this.put(this.val$key, num);
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
        public boolean add(Map.Entry<Character, Integer> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TCharIntMapDecorator.this._map.remove(TCharIntMapDecorator.this.unwrapKey((Character) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Character, Integer>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TCharIntMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Character, Integer>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Integer) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Character) && this._map.containsKey(unwrapKey(obj));
        }
        TCharIntMap tCharIntMap = this._map;
        return tCharIntMap.containsKey(tCharIntMap.getNoEntryKey());
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
    public void putAll(Map<? extends Character, ? extends Integer> map) {
        Iterator<Map.Entry<? extends Character, ? extends Integer>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Character, ? extends Integer> next = it.next();
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

    protected Integer wrapValue(int i) {
        return Integer.valueOf(i);
    }

    protected int unwrapValue(Object obj) {
        return ((Integer) obj).intValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TCharIntMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
