package org.apache.commons.collections;

/* loaded from: classes4.dex */
public interface OrderedBidiMap extends BidiMap, OrderedMap {
    @Override // org.apache.commons.collections.BidiMap
    BidiMap inverseBidiMap();

    OrderedBidiMap inverseOrderedBidiMap();
}
