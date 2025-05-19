package gnu.trove.decorator;

import gnu.trove.iterator.TObjectByteIterator;
import gnu.trove.map.TObjectByteMap;
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
public class TObjectByteMapDecorator<K> extends AbstractMap<K, Byte> implements Map<K, Byte>, Externalizable, Cloneable {
    static final long serialVersionUID = 1;
    protected TObjectByteMap<K> _map;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Byte put(Object obj, Byte b) {
        return put2((TObjectByteMapDecorator<K>) obj, b);
    }

    public TObjectByteMapDecorator() {
    }

    public TObjectByteMapDecorator(TObjectByteMap<K> tObjectByteMap) {
        Objects.requireNonNull(tObjectByteMap);
        this._map = tObjectByteMap;
    }

    public TObjectByteMap<K> getMap() {
        return this._map;
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public Byte put2(K k, Byte b) {
        if (b == null) {
            TObjectByteMap<K> tObjectByteMap = this._map;
            return wrapValue(tObjectByteMap.put(k, tObjectByteMap.getNoEntryValue()));
        }
        return wrapValue(this._map.put(k, unwrapValue(b)));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Byte get(Object obj) {
        byte b = this._map.get(obj);
        if (b == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(b);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this._map.clear();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.AbstractMap, java.util.Map
    public Byte remove(Object obj) {
        byte remove = this._map.remove(obj);
        if (remove == this._map.getNoEntryValue()) {
            return null;
        }
        return wrapValue(remove);
    }

    /* renamed from: gnu.trove.decorator.TObjectByteMapDecorator$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSet<Map.Entry<K, Byte>> {
        AnonymousClass1() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectByteMapDecorator.this._map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TObjectByteMapDecorator.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            return TObjectByteMapDecorator.this.containsKey(key) && TObjectByteMapDecorator.this.get(key).equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Byte>> iterator() {
            return new Iterator<Map.Entry<K, Byte>>() { // from class: gnu.trove.decorator.TObjectByteMapDecorator.1.1
                private final TObjectByteIterator<K> it;

                {
                    this.it = TObjectByteMapDecorator.this._map.iterator();
                }

                @Override // java.util.Iterator
                public Map.Entry<K, Byte> next() {
                    this.it.advance();
                    return new Map.Entry<K, Byte>(TObjectByteMapDecorator.this.wrapValue(this.it.value()), this.it.key()) { // from class: gnu.trove.decorator.TObjectByteMapDecorator.1.1.1
                        private Byte val;
                        final /* synthetic */ Object val$key;
                        final /* synthetic */ Byte val$v;

                        {
                            this.val$v = r2;
                            this.val$key = r3;
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
                        public K getKey() {
                            return (K) this.val$key;
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Map.Entry
                        public Byte getValue() {
                            return this.val;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            return this.val$key.hashCode() + this.val.hashCode();
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Map.Entry
                        public Byte setValue(Byte b) {
                            this.val = b;
                            return TObjectByteMapDecorator.this.put2((TObjectByteMapDecorator) this.val$key, b);
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
        public boolean add(Map.Entry<K, Byte> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            TObjectByteMapDecorator.this._map.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, Byte>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TObjectByteMapDecorator.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, Byte>> entrySet() {
        return new AnonymousClass1();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return (obj instanceof Byte) && this._map.containsValue(unwrapValue(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this._map.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this._map.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this._map.size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends Byte> map) {
        Iterator<Map.Entry<? extends K, ? extends Byte>> it = map.entrySet().iterator();
        int size = map.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            Map.Entry<? extends K, ? extends Byte> next = it.next();
            put2((TObjectByteMapDecorator<K>) next.getKey(), next.getValue());
            size = i;
        }
    }

    protected Byte wrapValue(byte b) {
        return Byte.valueOf(b);
    }

    protected byte unwrapValue(Object obj) {
        return ((Byte) obj).byteValue();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._map = (TObjectByteMap) objectInput.readObject();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeObject(this._map);
    }
}
