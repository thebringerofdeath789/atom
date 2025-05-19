package gnu.trove.decorator;

import gnu.trove.iterator.TFloatFloatIterator;
import gnu.trove.map.TFloatFloatMap;
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
public class TFloatFloatMapDecorator extends AbstractMap<Float, Float> implements Map<Float, Float>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TFloatFloatMap _map;

    public TFloatFloatMapDecorator() {
    }

    public TFloatFloatMapDecorator(TFloatFloatMap tFloatFloatMap) {
        Objects.requireNonNull(tFloatFloatMap);
        this._map = tFloatFloatMap;
    }

    public TFloatFloatMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Float put(Float f, Float f2) {
        float unwrapKey;
        float unwrapValue;
        if (f == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(f);
        }
        if (f2 == null) {
            unwrapValue = this._map.getNoEntryValue();
        } else {
            unwrapValue = unwrapValue(f2);
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
        float noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Float)) {
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
        float noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Float)) {
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

    /* renamed from: gnu.trove.decorator.TFloatFloatMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Float, Float>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TFloatFloatMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TFloatFloatMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TFloatFloatMapDecorator.this.containsKey(key) && TFloatFloatMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Float, Float>> iterator() {
            return new Iterator<Map.Entry<Float, Float>>() { // from class: gnu.trove.decorator.TFloatFloatMapDecorator.1.1
                private final TFloatFloatIterator it;

                {
                    this.it = TFloatFloatMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Float, Float> next() {
                    this.it.advance();
                    float key = this.it.key();
                    Float wrapKey = key == TFloatFloatMapDecorator.this._map.getNoEntryKey() ? null : TFloatFloatMapDecorator.this.wrapKey(key);
                    float value = this.it.value();
                    return new Map.Entry<Float, Float>(value != TFloatFloatMapDecorator.this._map.getNoEntryValue() ? TFloatFloatMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TFloatFloatMapDecorator.1.1.1
                        private Float val;
                        final /* synthetic */ Float val$key;
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

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Map.Entry
                        public Float getKey() {
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
                            return TFloatFloatMapDecorator.this.put(this.val$key, f);
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
        public boolean add(Map.Entry<Float, Float> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TFloatFloatMapDecorator.this._map.remove(TFloatFloatMapDecorator.this.unwrapKey((Float) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Float, Float>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TFloatFloatMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Float, Float>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Float) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Float) && this._map.containsKey(unwrapKey(obj));
        }
        TFloatFloatMap tFloatFloatMap = this._map;
        return tFloatFloatMap.containsKey(tFloatFloatMap.getNoEntryKey());
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
    public void putAll(Map<? extends Float, ? extends Float> map) {
        Iterator<Map.Entry<? extends Float, ? extends Float>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Float, ? extends Float> next = it.next();
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

    protected Float wrapValue(float f) {
        return Float.valueOf(f);
    }

    protected float unwrapValue(Object obj) {
        return ((Float) obj).floatValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TFloatFloatMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
