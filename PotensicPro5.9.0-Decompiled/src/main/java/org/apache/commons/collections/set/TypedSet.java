package org.apache.commons.collections.set;

import java.util.Set;
import org.apache.commons.collections.functors.InstanceofPredicate;

/* loaded from: classes4.dex */
public class TypedSet {
    public static Set decorate(Set set, Class cls) {
        return new PredicatedSet(set, InstanceofPredicate.getInstance(cls));
    }

    protected TypedSet() {
    }
}
