package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public final class UniquePredicate implements Predicate, Serializable {
    private static final long serialVersionUID = -3319417438027438040L;
    private final Set iSet = new HashSet();

    public static Predicate getInstance() {
        return new UniquePredicate();
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        return this.iSet.add(obj);
    }
}
