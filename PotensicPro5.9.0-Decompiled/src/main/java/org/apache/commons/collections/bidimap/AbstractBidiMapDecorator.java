package org.apache.commons.collections.bidimap;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.map.AbstractMapDecorator;

/* loaded from: classes4.dex */
public abstract class AbstractBidiMapDecorator extends AbstractMapDecorator implements BidiMap {
    protected AbstractBidiMapDecorator(BidiMap bidiMap) {
        super(bidiMap);
    }

    protected BidiMap getBidiMap() {
        return (BidiMap) this.map;
    }

    @Override // org.apache.commons.collections.BidiMap, org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return getBidiMap().mapIterator();
    }

    @Override // org.apache.commons.collections.BidiMap
    public Object getKey(Object obj) {
        return getBidiMap().getKey(obj);
    }

    @Override // org.apache.commons.collections.BidiMap
    public Object removeValue(Object obj) {
        return getBidiMap().removeValue(obj);
    }

    @Override // org.apache.commons.collections.BidiMap
    public BidiMap inverseBidiMap() {
        return getBidiMap().inverseBidiMap();
    }
}
