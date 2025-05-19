package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

/* loaded from: classes4.dex */
public class EmptyMapIterator<K, V> extends AbstractEmptyMapIterator<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
    public static final MapIterator INSTANCE = new EmptyMapIterator();

    public static <K, V> MapIterator<K, V> emptyMapIterator() {
        return INSTANCE;
    }

    protected EmptyMapIterator() {
    }
}
