package org.apache.commons.collections.list;

import java.util.List;
import org.apache.commons.collections.functors.InstanceofPredicate;

/* loaded from: classes4.dex */
public class TypedList {
    public static List decorate(List list, Class cls) {
        return new PredicatedList(list, InstanceofPredicate.getInstance(cls));
    }

    protected TypedList() {
    }
}
