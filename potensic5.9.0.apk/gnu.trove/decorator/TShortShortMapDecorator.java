package gnu.trove.decorator;

import gnu.trove.iterator.TShortShortIterator;
import gnu.trove.map.TShortShortMap;
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
public class TShortShortMapDecorator extends AbstractMap<Short, Short> implements Map<Short, Short>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TShortShortMap _map;

    public TShortShortMapDecorator() {
    }

    public TShortShortMapDecorator(TShortShortMap tShortShortMap) {
        Objects.requireNonNull(tShortShortMap);
        this._map = tShortShortMap;
    }

    public TShortShortMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Short put(Short sh, Short sh2) {
        short unwrapKey;
        short unwrapValue;
        if (sh == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(sh);
        }
        if (sh2 == null) {
            unwrapValue = this._map.getNoEntryValue();
        } else {
            unwrapValue = unwrapValue(sh2);
        }
        short put = this._map.put(unwrapKey, unwrapValue);
        if (put == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(put);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Short get(Object obj) {
        short noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Short)) {
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
        short noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Short)) {
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

    /* renamed from: gnu.trove.decorator.TShortShortMapDecorator$1 */
    class C35031 extends AbstractSet<Map.Entry<Short, Short>> {
        C35031() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TShortShortMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TShortShortMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TShortShortMapDecorator.this.containsKey(key) && TShortShortMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Short, Short>> iterator() {
            return new Iterator<Map.Entry<Short, Short>>() { // from class: gnu.trove.decorator.TShortShortMapDecorator.1.1

                /* renamed from: it */
                private final TShortShortIterator f3578it;

                {
                    this.f3578it = TShortShortMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Short, Short> next() {
                    this.f3578it.advance();
                    short key = this.f3578it.key();
                    Short wrapKey = key == TShortShortMapDecorator.this._map.getNoEntryKey() ? null : TShortShortMapDecorator.this.wrapKey(key);
                    short value = this.f3578it.value();
                    return new Map.Entry<Short, Short>(value != TShortShortMapDecorator.this._map.getNoEntryValue() ? TShortShortMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TShortShortMapDecorator.1.1.1
                        private Short val;
                        final /* synthetic */ Short val$key;
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

                        @Override // java.util.Map.Entry
                        public Short getKey() {
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
                            return TShortShortMapDecorator.this.put(this.val$key, sh);
                        }
                    };
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f3578it.hasNext();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.f3578it.remove();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<Short, Short> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TShortShortMapDecorator.this._map.remove(TShortShortMapDecorator.this.unwrapKey((Short) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Short, Short>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TShortShortMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Short, Short>> entrySet() {
        return new C35031();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Short) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Short) && this._map.containsKey(unwrapKey(obj));
        }
        TShortShortMap tShortShortMap = this._map;
        return tShortShortMap.containsKey(tShortShortMap.getNoEntryKey());
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
    public void putAll(Map<? extends Short, ? extends Short> map) {
        Iterator<Map.Entry<? extends Short, ? extends Short>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Short, ? extends Short> next = it.next();
            put(next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Short wrapKey(short s) {
        return Short.valueOf(s);
    }

    protected short unwrapKey(Object obj) {
        return ((Short) obj).shortValue();
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
        this._map = (TShortShortMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}