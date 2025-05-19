package gnu.trove.decorator;

import gnu.trove.iterator.TDoubleShortIterator;
import gnu.trove.map.TDoubleShortMap;
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
public class TDoubleShortMapDecorator extends AbstractMap<Double, Short> implements Map<Double, Short>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TDoubleShortMap _map;

    public TDoubleShortMapDecorator() {
    }

    public TDoubleShortMapDecorator(TDoubleShortMap tDoubleShortMap) {
        Objects.requireNonNull(tDoubleShortMap);
        this._map = tDoubleShortMap;
    }

    public TDoubleShortMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Short put(Double d, Short sh) {
        double unwrapKey;
        short unwrapValue;
        if (d == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(d);
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
        double noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Double)) {
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
        double noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Double)) {
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

    /* renamed from: gnu.trove.decorator.TDoubleShortMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Double, Short>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TDoubleShortMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TDoubleShortMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TDoubleShortMapDecorator.this.containsKey(key) && TDoubleShortMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Double, Short>> iterator() {
            return new Iterator<Map.Entry<Double, Short>>() { // from class: gnu.trove.decorator.TDoubleShortMapDecorator.1.1
                private final TDoubleShortIterator it;

                {
                    this.it = TDoubleShortMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Double, Short> next() {
                    this.it.advance();
                    double key = this.it.key();
                    Double wrapKey = key == TDoubleShortMapDecorator.this._map.getNoEntryKey() ? null : TDoubleShortMapDecorator.this.wrapKey(key);
                    short value = this.it.value();
                    return new Map.Entry<Double, Short>(value != TDoubleShortMapDecorator.this._map.getNoEntryValue() ? TDoubleShortMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TDoubleShortMapDecorator.1.1.1
                        private Short val;
                        final /* synthetic */ Double val$key;
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
                        public Double getKey() {
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
                            return TDoubleShortMapDecorator.this.put(this.val$key, sh);
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
        public boolean add(Map.Entry<Double, Short> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TDoubleShortMapDecorator.this._map.remove(TDoubleShortMapDecorator.this.unwrapKey((Double) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Double, Short>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TDoubleShortMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Double, Short>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Short) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Double) && this._map.containsKey(unwrapKey(obj));
        }
        TDoubleShortMap tDoubleShortMap = this._map;
        return tDoubleShortMap.containsKey(tDoubleShortMap.getNoEntryKey());
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
    public void putAll(Map<? extends Double, ? extends Short> map) {
        Iterator<Map.Entry<? extends Double, ? extends Short>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Double, ? extends Short> next = it.next();
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

    protected Short wrapValue(short s) {
        return Short.valueOf(s);
    }

    protected short unwrapValue(Object obj) {
        return ((Short) obj).shortValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TDoubleShortMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
