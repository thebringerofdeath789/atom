package gnu.trove.decorator;

import gnu.trove.iterator.TDoubleCharIterator;
import gnu.trove.map.TDoubleCharMap;
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
public class TDoubleCharMapDecorator extends AbstractMap<Double, Character> implements Map<Double, Character>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TDoubleCharMap _map;

    public TDoubleCharMapDecorator() {
    }

    public TDoubleCharMapDecorator(TDoubleCharMap tDoubleCharMap) {
        Objects.requireNonNull(tDoubleCharMap);
        this._map = tDoubleCharMap;
    }

    public TDoubleCharMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Character put(Double d, Character ch) {
        double unwrapKey;
        char unwrapValue;
        if (d == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(d);
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
        double noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Double)) {
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
        double noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Double)) {
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

    /* renamed from: gnu.trove.decorator.TDoubleCharMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Double, Character>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TDoubleCharMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TDoubleCharMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TDoubleCharMapDecorator.this.containsKey(key) && TDoubleCharMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Double, Character>> iterator() {
            return new Iterator<Map.Entry<Double, Character>>() { // from class: gnu.trove.decorator.TDoubleCharMapDecorator.1.1
                private final TDoubleCharIterator it;

                {
                    this.it = TDoubleCharMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Double, Character> next() {
                    this.it.advance();
                    double key = this.it.key();
                    Double wrapKey = key == TDoubleCharMapDecorator.this._map.getNoEntryKey() ? null : TDoubleCharMapDecorator.this.wrapKey(key);
                    char value = this.it.value();
                    return new Map.Entry<Double, Character>(value != TDoubleCharMapDecorator.this._map.getNoEntryValue() ? TDoubleCharMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TDoubleCharMapDecorator.1.1.1
                        private Character val;
                        final /* synthetic */ Double val$key;
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
                        public Double getKey() {
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
                            return TDoubleCharMapDecorator.this.put(this.val$key, ch);
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
        public boolean add(Map.Entry<Double, Character> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TDoubleCharMapDecorator.this._map.remove(TDoubleCharMapDecorator.this.unwrapKey((Double) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Double, Character>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TDoubleCharMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Double, Character>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Character) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Double) && this._map.containsKey(unwrapKey(obj));
        }
        TDoubleCharMap tDoubleCharMap = this._map;
        return tDoubleCharMap.containsKey(tDoubleCharMap.getNoEntryKey());
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
    public void putAll(Map<? extends Double, ? extends Character> map) {
        Iterator<Map.Entry<? extends Double, ? extends Character>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Double, ? extends Character> next = it.next();
            put(next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Double wrapKey(double d) {
        return Double.valueOf(d);
    }

    protected double unwrapKey(Object obj) {
        return ((Double) obj).doubleValue();
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
        this._map = (TDoubleCharMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
