package gnu.trove.decorator;

import gnu.trove.iterator.TFloatShortIterator;
import gnu.trove.map.TFloatShortMap;
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
public class TFloatShortMapDecorator extends AbstractMap<Float, Short> implements Map<Float, Short>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TFloatShortMap _map;

    public TFloatShortMapDecorator() {
    }

    public TFloatShortMapDecorator(TFloatShortMap tFloatShortMap) {
        Objects.requireNonNull(tFloatShortMap);
        this._map = tFloatShortMap;
    }

    public TFloatShortMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Short put(Float f, Short sh) {
        float unwrapKey;
        short unwrapValue;
        if (f == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(f);
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
        float noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Float)) {
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
        float noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Float)) {
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

    /* renamed from: gnu.trove.decorator.TFloatShortMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Float, Short>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TFloatShortMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TFloatShortMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TFloatShortMapDecorator.this.containsKey(key) && TFloatShortMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Float, Short>> iterator() {
            return new Iterator<Map.Entry<Float, Short>>() { // from class: gnu.trove.decorator.TFloatShortMapDecorator.1.1
                private final TFloatShortIterator it;

                {
                    this.it = TFloatShortMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Float, Short> next() {
                    this.it.advance();
                    float key = this.it.key();
                    Float wrapKey = key == TFloatShortMapDecorator.this._map.getNoEntryKey() ? null : TFloatShortMapDecorator.this.wrapKey(key);
                    short value = this.it.value();
                    return new Map.Entry<Float, Short>(value != TFloatShortMapDecorator.this._map.getNoEntryValue() ? TFloatShortMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TFloatShortMapDecorator.1.1.1
                        private Short val;
                        final /* synthetic */ Float val$key;
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
                        public Float getKey() {
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
                            return TFloatShortMapDecorator.this.put(this.val$key, sh);
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
        public boolean add(Map.Entry<Float, Short> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TFloatShortMapDecorator.this._map.remove(TFloatShortMapDecorator.this.unwrapKey((Float) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Float, Short>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TFloatShortMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Float, Short>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Short) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Float) && this._map.containsKey(unwrapKey(obj));
        }
        TFloatShortMap tFloatShortMap = this._map;
        return tFloatShortMap.containsKey(tFloatShortMap.getNoEntryKey());
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
    public void putAll(Map<? extends Float, ? extends Short> map) {
        Iterator<Map.Entry<? extends Float, ? extends Short>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Float, ? extends Short> next = it.next();
            put(next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Float wrapKey(float f) {
        return Float.valueOf(f);
    }

    protected float unwrapKey(Object obj) {
        return ((Float) obj).floatValue();
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
        this._map = (TFloatShortMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
