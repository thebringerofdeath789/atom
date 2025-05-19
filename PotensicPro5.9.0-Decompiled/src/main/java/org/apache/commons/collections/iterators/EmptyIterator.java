package org.apache.commons.collections.iterators;

import java.util.Iterator;
import org.apache.commons.collections.ResettableIterator;

/* loaded from: classes4.dex */
public class EmptyIterator extends AbstractEmptyIterator implements ResettableIterator {
    public static final Iterator INSTANCE;
    public static final ResettableIterator RESETTABLE_INSTANCE;

    static {
        EmptyIterator emptyIterator = new EmptyIterator();
        RESETTABLE_INSTANCE = emptyIterator;
        INSTANCE = emptyIterator;
    }

    protected EmptyIterator() {
    }
}
