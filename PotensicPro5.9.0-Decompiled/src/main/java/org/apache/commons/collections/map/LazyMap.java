package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.FactoryTransformer;

/* loaded from: classes4.dex */
public class LazyMap extends AbstractMapDecorator implements Map, Serializable {
    private static final long serialVersionUID = 7990956402564206740L;
    protected final Transformer factory;

    public static Map decorate(Map map, Factory factory) {
        return new LazyMap(map, factory);
    }

    public static Map decorate(Map map, Transformer transformer) {
        return new LazyMap(map, transformer);
    }

    protected LazyMap(Map map, Factory factory) {
        super(map);
        if (factory == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        this.factory = FactoryTransformer.getInstance(factory);
    }

    protected LazyMap(Map map, Transformer transformer) {
        super(map);
        if (transformer == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        this.factory = transformer;
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
            Object transform = this.factory.transform(obj);
            this.map.put(obj, transform);
            return transform;
        }
        return this.map.get(obj);
    }
}
