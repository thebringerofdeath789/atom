package org.apache.commons.collections.map;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;

/* loaded from: classes4.dex */
public abstract class AbstractOrderedMapDecorator extends AbstractMapDecorator implements OrderedMap {
    protected AbstractOrderedMapDecorator() {
    }

    public AbstractOrderedMapDecorator(OrderedMap orderedMap) {
        super(orderedMap);
    }

    protected OrderedMap getOrderedMap() {
        return (OrderedMap) this.map;
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object firstKey() {
        return getOrderedMap().firstKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object lastKey() {
        return getOrderedMap().lastKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object nextKey(Object obj) {
        return getOrderedMap().nextKey(obj);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object previousKey(Object obj) {
        return getOrderedMap().previousKey(obj);
    }

    @Override // org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return getOrderedMap().mapIterator();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        return getOrderedMap().orderedMapIterator();
    }
}
