package gnu.trove.decorator;

import gnu.trove.iterator.TByteLongIterator;
import gnu.trove.map.TByteLongMap;
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
public class TByteLongMapDecorator extends AbstractMap<Byte, Long> implements Map<Byte, Long>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TByteLongMap _map;

    public TByteLongMapDecorator() {
    }

    public TByteLongMapDecorator(TByteLongMap tByteLongMap) {
        Objects.requireNonNull(tByteLongMap);
        this._map = tByteLongMap;
    }

    public TByteLongMap getMap() {
        return this._map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Long put(Byte b, Long l) {
        byte unwrapKey;
        long unwrapValue;
        if (b == null) {
            unwrapKey = this._map.getNoEntryKey();
        } else {
            unwrapKey = unwrapKey(b);
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
        byte noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Byte)) {
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
        byte noEntryKey;
        if (obj != null) {
            if (!(obj instanceof Byte)) {
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

    /* renamed from: gnu.trove.decorator.TByteLongMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<Byte, Long>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TByteLongMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TByteLongMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TByteLongMapDecorator.this.containsKey(key) && TByteLongMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Byte, Long>> iterator() {
            return new Iterator<Map.Entry<Byte, Long>>() { // from class: gnu.trove.decorator.TByteLongMapDecorator.1.1
                private final TByteLongIterator it;

                {
                    this.it = TByteLongMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<Byte, Long> next() {
                    this.it.advance();
                    byte key = this.it.key();
                    Byte wrapKey = key == TByteLongMapDecorator.this._map.getNoEntryKey() ? null : TByteLongMapDecorator.this.wrapKey(key);
                    long value = this.it.value();
                    return new Map.Entry<Byte, Long>(value != TByteLongMapDecorator.this._map.getNoEntryValue() ? TByteLongMapDecorator.this.wrapValue(value) : null, wrapKey) { // from class: gnu.trove.decorator.TByteLongMapDecorator.1.1.1
                        private Long val;
                        final /* synthetic */ Byte val$key;
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
                        public Byte getKey() {
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
                            return TByteLongMapDecorator.this.put(this.val$key, l);
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
        public boolean add(Map.Entry<Byte, Long> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TByteLongMapDecorator.this._map.remove(TByteLongMapDecorator.this.unwrapKey((Byte) ((Map.Entry) obj).getKey()));
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<Byte, Long>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TByteLongMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Byte, Long>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Long) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj != null) {
            return (obj instanceof Byte) && this._map.containsKey(unwrapKey(obj));
        }
        TByteLongMap tByteLongMap = this._map;
        return tByteLongMap.containsKey(tByteLongMap.getNoEntryKey());
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
    public void putAll(Map<? extends Byte, ? extends Long> map) {
        Iterator<Map.Entry<? extends Byte, ? extends Long>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends Byte, ? extends Long> next = it.next();
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

    protected Long wrapValue(long j) {
        return Long.valueOf(j);
    }

    protected long unwrapValue(Object obj) {
        return ((Long) obj).longValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TByteLongMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
