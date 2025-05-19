package gnu.trove.decorator;

import gnu.trove.iterator.TIntShortIterator;
import gnu.trove.map.TIntShortMap;
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
public class TIntShortMapDecorator extends AbstractMap<Integer, Short> implements Map<Integer, Short>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TIntShortMap _map;

    public TIntShortMapDecorator() {
    }

    public TIntShortMapDecorator(TIntShortMap tIntShortMap) {
        Objects.requireNonNull(tIntShortMap);
        this._map = tIntShortMap;
    }

    public TIntShortMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Short put(Integer num, Short sh) {
        int unwrapKey;
        short unwrapValue;
        if (num == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(num);
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
        int noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Integer)) {
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
        int noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Integer)) {
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

    /* renamed from: gnu.trove.decorator.TIntShortMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Integer, Short>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TIntShortMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TIntShortMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TIntShortMapDecorator.this.containsKey(key) && TIntShortMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Integer, Short>> iterator() {
            return new Iterator<Map.Entry<Integer, Short>>() { // from class: gnu.trove.decorator.TIntShortMapDecorator.1.1
                private final TIntShortIterator it;

                {
                    this.it = TIntShortMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Integer, Short> next() {
                    this.it.advance();
                    int key = this.it.key();
                    Integer wrapKey = key == TIntShortMapDecorator.this._map.getNoEntryKey() ? null : TIntShortMapDecorator.this.wrapKey(key);
                    short value = this.it.value();
                    return new Map.Entry<Integer, Short>(value != TIntShortMapDecorator.this._map.getNoEntryValue() ? TIntShortMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TIntShortMapDecorator.1.1.1
                        private Short val;
                        final /* synthetic */ Integer val$key;
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
                        public Integer getKey() {
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
                            return TIntShortMapDecorator.this.put(this.val$key, sh);
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
        public boolean add(Map.Entry<Integer, Short> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TIntShortMapDecorator.this._map.remove(TIntShortMapDecorator.this.unwrapKey((Integer) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Integer, Short>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TIntShortMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Integer, Short>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Short) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Integer) && this._map.containsKey(unwrapKey(obj));
        }
        TIntShortMap tIntShortMap = this._map;
        return tIntShortMap.containsKey(tIntShortMap.getNoEntryKey());
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
    public void putAll(Map<? extends Integer, ? extends Short> map) {
        Iterator<Map.Entry<? extends Integer, ? extends Short>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Integer, ? extends Short> next = it.next();
            put(next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Integer wrapKey(int i) {
        return Integer.valueOf(i);
    }

    protected int unwrapKey(Object obj) {
        return ((Integer) obj).intValue();
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
        this._map = (TIntShortMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
