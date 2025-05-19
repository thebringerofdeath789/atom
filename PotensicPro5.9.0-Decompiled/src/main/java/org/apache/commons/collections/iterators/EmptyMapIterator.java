package org.apache.commons.collections.iterators;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.ResettableIterator;

/* loaded from: classes4.dex */
public class EmptyMapIterator extends AbstractEmptyIterator implements MapIterator, ResettableIterator {
    public static final MapIterator INSTANCE = new EmptyMapIterator();

    protected EmptyMapIterator() {
    }
}
