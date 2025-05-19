package gnu.trove.decorator;

import gnu.trove.iterator.TByteCharIterator;
import gnu.trove.map.TByteCharMap;
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
public class TByteCharMapDecorator extends AbstractMap<Byte, Character> implements Map<Byte, Character>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TByteCharMap _map;

    public TByteCharMapDecorator() {
    }

    public TByteCharMapDecorator(TByteCharMap tByteCharMap) {
        Objects.requireNonNull(tByteCharMap);
        this._map = tByteCharMap;
    }

    public TByteCharMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Character put(Byte b, Character ch) {
        byte unwrapKey;
        char unwrapValue;
        if (b == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(b);
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
        byte noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Byte)) {
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
        byte noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Byte)) {
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

    /* renamed from: gnu.trove.decorator.TByteCharMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Byte, Character>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TByteCharMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TByteCharMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TByteCharMapDecorator.this.containsKey(key) && TByteCharMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Byte, Character>> iterator() {
            return new Iterator<Map.Entry<Byte, Character>>() { // from class: gnu.trove.decorator.TByteCharMapDecorator.1.1
                private final TByteCharIterator it;

                {
                    this.it = TByteCharMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Byte, Character> next() {
                    this.it.advance();
                    byte key = this.it.key();
                    Byte wrapKey = key == TByteCharMapDecorator.this._map.getNoEntryKey() ? null : TByteCharMapDecorator.this.wrapKey(key);
                    char value = this.it.value();
                    return new Map.Entry<Byte, Character>(value != TByteCharMapDecorator.this._map.getNoEntryValue() ? TByteCharMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TByteCharMapDecorator.1.1.1
                        private Character val;
                        final /* synthetic */ Byte val$key;
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
                        public Byte getKey() {
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
                            return TByteCharMapDecorator.this.put(this.val$key, ch);
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
        public boolean add(Map.Entry<Byte, Character> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TByteCharMapDecorator.this._map.remove(TByteCharMapDecorator.this.unwrapKey((Byte) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Byte, Character>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TByteCharMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Byte, Character>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Character) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Byte) && this._map.containsKey(unwrapKey(obj));
        }
        TByteCharMap tByteCharMap = this._map;
        return tByteCharMap.containsKey(tByteCharMap.getNoEntryKey());
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
    public void putAll(Map<? extends Byte, ? extends Character> map) {
        Iterator<Map.Entry<? extends Byte, ? extends Character>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Byte, ? extends Character> next = it.next();
            put(next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Byte wrapKey(byte b) {
        return Byte.valueOf(b);
    }

    protected byte unwrapKey(Object obj) {
        return ((Byte) obj).byteValue();
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
        this._map = (TByteCharMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
