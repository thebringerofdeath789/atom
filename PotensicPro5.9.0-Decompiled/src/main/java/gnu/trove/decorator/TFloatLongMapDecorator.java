package gnu.trove.decorator;

import gnu.trove.iterator.TFloatLongIterator;
import gnu.trove.map.TFloatLongMap;
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
public class TFloatLongMapDecorator extends AbstractMap<Float, Long> implements Map<Float, Long>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TFloatLongMap _map;

    public TFloatLongMapDecorator() {
    }

    public TFloatLongMapDecorator(TFloatLongMap tFloatLongMap) {
        Objects.requireNonNull(tFloatLongMap);
        this._map = tFloatLongMap;
    }

    public TFloatLongMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Long put(Float f, Long l) {
        float unwrapKey;
        long unwrapValue;
        if (f == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(f);
        }
        if (l == null) {
            unwrapValue = this._map.getNoEntryValue();
        } else {
            unwrapValue = unwrapValue(l);
        }
        long put = this._map.put(unwrapKey, unwrapValue);
        if (put == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(put);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Long get(Object obj) {
        float noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Float)) {
                return null;
            }
            noEntryKey = unwrapKey(obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        long j = this._map.get(noEntryKey);
        if (j == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(j);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this._map.clear();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Long remove(Object obj) {
        float noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Float)) {
                return null;
            }
            noEntryKey = unwrapKey(obj);
        } else {
            noEntryKey = this._map.getNoEntryKey();
        }
        long remove = this._map.remove(noEntryKey);
        if (remove == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(remove);
    }

    /* renamed from: gnu.trove.decorator.TFloatLongMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Float, Long>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TFloatLongMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TFloatLongMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TFloatLongMapDecorator.this.containsKey(key) && TFloatLongMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Float, Long>> iterator() {
            return new Iterator<Map.Entry<Float, Long>>() { // from class: gnu.trove.decorator.TFloatLongMapDecorator.1.1
                private final TFloatLongIterator it;

                {
                    this.it = TFloatLongMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Float, Long> next() {
                    this.it.advance();
                    float key = this.it.key();
                    Float wrapKey = key == TFloatLongMapDecorator.this._map.getNoEntryKey() ? null : TFloatLongMapDecorator.this.wrapKey(key);
                    long value = this.it.value();
                    return new Map.Entry<Float, Long>(value != TFloatLongMapDecorator.this._map.getNoEntryValue() ? TFloatLongMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TFloatLongMapDecorator.1.1.1
                        private Long val;
                        final /* synthetic */ Float val$key;
                        final /* synthetic */ Long val$v;

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
                        public Long getValue() {
                            return this.val;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            return this.val$key.hashCode() + this.val.hashCode();
                        }

                        @Override // java.util.Map.Entry
                        public Long setValue(Long l) {
                            this.val = l;
                            return TFloatLongMapDecorator.this.put(this.val$key, l);
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
        public boolean add(Map.Entry<Float, Long> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TFloatLongMapDecorator.this._map.remove(TFloatLongMapDecorator.this.unwrapKey((Float) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Float, Long>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TFloatLongMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Float, Long>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Long) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Float) && this._map.containsKey(unwrapKey(obj));
        }
        TFloatLongMap tFloatLongMap = this._map;
        return tFloatLongMap.containsKey(tFloatLongMap.getNoEntryKey());
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
    public void putAll(Map<? extends Float, ? extends Long> map) {
        Iterator<Map.Entry<? extends Float, ? extends Long>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Float, ? extends Long> next = it.next();
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

    protected Long wrapValue(long j) {
        return Long.valueOf(j);
    }

    protected long unwrapValue(Object obj) {
        return ((Long) obj).longValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TFloatLongMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
