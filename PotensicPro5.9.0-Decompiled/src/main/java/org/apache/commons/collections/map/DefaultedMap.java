package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.FactoryTransformer;

/* loaded from: classes4.dex */
public class DefaultedMap extends AbstractMapDecorator implements Map, Serializable {
    private static final long serialVersionUID = 19698628745827L;
    protected final Object value;

    public static Map decorate(Map map, Object obj) {
        if (obj instanceof Transformer) {
            obj = ConstantTransformer.getInstance(obj);
        }
        return new DefaultedMap(map, obj);
    }

    public static Map decorate(Map map, Factory factory) {
        if (factory == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        return new DefaultedMap(map, FactoryTransformer.getInstance(factory));
    }

    public static Map decorate(Map map, Transformer transformer) {
        if (transformer == null) {
            throw new IllegalArgumentException("Transformer must not be null");
        }
        return new DefaultedMap(map, transformer);
    }

    public DefaultedMap(Object obj) {
        super(new HashMap());
        this.value = obj instanceof Transformer ? ConstantTransformer.getInstance(obj) : obj;
    }

    protected DefaultedMap(Map map, Object obj) {
        super(map);
        this.value = obj;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Object get(Object obj) {
        if (!this.map.containsKey(obj)) {
            Object obj2 = this.value;
            return obj2 instanceof Transformer ? ((Transformer) obj2).transform(obj) : obj2;
        }
        return this.map.get(obj);
    }
}
