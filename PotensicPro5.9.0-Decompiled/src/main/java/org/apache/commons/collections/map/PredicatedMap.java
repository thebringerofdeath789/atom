package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public class PredicatedMap extends AbstractInputCheckedMapDecorator implements Serializable {
    private static final long serialVersionUID = 7412622456128415156L;
    protected final Predicate keyPredicate;
    protected final Predicate valuePredicate;

    public static Map decorate(Map map, Predicate predicate, Predicate predicate2) {
        return new PredicatedMap(map, predicate, predicate2);
    }

    protected PredicatedMap(Map map, Predicate predicate, Predicate predicate2) {
        super(map);
        this.keyPredicate = predicate;
        this.valuePredicate = predicate2;
        for (Map.Entry entry : map.entrySet()) {
            validate(entry.getKey(), entry.getValue());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    protected void validate(Object obj, Object obj2) {
        Predicate predicate = this.keyPredicate;
        if (predicate != null && !predicate.evaluate(obj)) {
            throw new IllegalArgumentException("Cannot add key - Predicate rejected it");
        }
        Predicate predicate2 = this.valuePredicate;
        if (predicate2 != null && !predicate2.evaluate(obj2)) {
            throw new IllegalArgumentException("Cannot add value - Predicate rejected it");
        }
    }

    @Override // org.apache.commons.collections.map.AbstractInputCheckedMapDecorator
    protected Object checkSetValue(Object obj) {
        if (this.valuePredicate.evaluate(obj)) {
            return obj;
        }
        throw new IllegalArgumentException("Cannot set value - Predicate rejected it");
    }

    @Override // org.apache.commons.collections.map.AbstractInputCheckedMapDecorator
    protected boolean isSetValueChecking() {
        return this.valuePredicate != null;
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections.BidiMap
    public Object put(Object obj, Object obj2) {
        validate(obj, obj2);
        return this.map.put(obj, obj2);
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            validate(entry.getKey(), entry.getValue());
        }
        this.map.putAll(map);
    }
}
