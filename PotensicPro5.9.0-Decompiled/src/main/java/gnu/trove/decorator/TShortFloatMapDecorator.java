package gnu.trove.decorator;

import gnu.trove.iterator.TShortFloatIterator;
import gnu.trove.map.TShortFloatMap;
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
public class TShortFloatMapDecorator extends AbstractMap<Short, Float> implements Map<Short, Float>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TShortFloatMap _map;

    public TShortFloatMapDecorator() {
    }

    public TShortFloatMapDecorator(TShortFloatMap tShortFloatMap) {
        Objects.requireNonNull(tShortFloatMap);
        this._map = tShortFloatMap;
    }

    public TShortFloatMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Float put(Short sh, Float f) {
        short unwrapKey;
        float unwrapValue;
        if (sh == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(sh);
        }
        if (f == null) {
            unwrapValue = this._map.getNoEntryValue();
        } else {
            unwrapValue = unwrapValue(f);
        }
        float put = this._map.put(unwrapKey, unwrapValue);
        if (put == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(put);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Float get(Object obj) {
        short noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Short)) {
                return null;
            }
            noEntryKey = unwrapKey(obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        float f = this._map.get(noEntryKey);
        if (f == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(f);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this._map.clear();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Float remove(Object obj) {
        short noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Short)) {
                return null;
            }
            noEntryKey = unwrapKey(obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        float remove = this._map.remove(noEntryKey);
        if (remove == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(remove);
    }

    /* renamed from: gnu.trove.decorator.TShortFloatMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Short, Float>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TShortFloatMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TShortFloatMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TShortFloatMapDecorator.this.containsKey(key) && TShortFloatMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Short, Float>> iterator() {
            return new Iterator<Map.Entry<Short, Float>>() { // from class: gnu.trove.decorator.TShortFloatMapDecorator.1.1
                private final TShortFloatIterator it;

                {
                    this.it = TShortFloatMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Short, Float> next() {
                    this.it.advance();
                    short key = this.it.key();
                    Short wrapKey = key == TShortFloatMapDecorator.this._map.getNoEntryKey() ? null : TShortFloatMapDecorator.this.wrapKey(key);
                    float value = this.it.value();
                    return new Map.Entry<Short, Float>(value != TShortFloatMapDecorator.this._map.getNoEntryValue() ? TShortFloatMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TShortFloatMapDecorator.1.1.1
                        private Float val;
                        final /* synthetic */ Short val$key;
                        final /* synthetic */ Float val$v;

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

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Map.Entry
                        public Float getValue() {
                            return this.val;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            return this.val$key.hashCode() + this.val.hashCode();
                        }

                        @Override // java.util.Map.Entry
                        public Float setValue(Float f) {
                            this.val = f;
                            return TShortFloatMapDecorator.this.put(this.val$key, f);
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
        public boolean add(Map.Entry<Short, Float> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TShortFloatMapDecorator.this._map.remove(TShortFloatMapDecorator.this.unwrapKey((Short) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Short, Float>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TShortFloatMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Short, Float>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Float) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Short) && this._map.containsKey(unwrapKey(obj));
        }
        TShortFloatMap tShortFloatMap = this._map;
        return tShortFloatMap.containsKey(tShortFloatMap.getNoEntryKey());
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
    public void putAll(Map<? extends Short, ? extends Float> map) {
        Iterator<Map.Entry<? extends Short, ? extends Float>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Short, ? extends Float> next = it.next();
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

    protected Float wrapValue(float f) {
        return Float.valueOf(f);
    }

    protected float unwrapValue(Object obj) {
        return ((Float) obj).floatValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TShortFloatMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
