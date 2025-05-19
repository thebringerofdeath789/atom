package org.apache.commons.collections.collection;

import java.util.Collection;
import org.apache.commons.collections.functors.InstanceofPredicate;

/* loaded from: classes4.dex */
public class TypedCollection {
    public static Collection decorate(Collection collection, Class cls) {
        return new PredicatedCollection(collection, InstanceofPredicate.getInstance(cls));
    }

    protected TypedCollection() {
    }
}
