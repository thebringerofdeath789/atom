package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public final class TruePredicate implements Predicate, Serializable {
    public static final Predicate INSTANCE = new TruePredicate();
    private static final long serialVersionUID = 3374767158756189740L;

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        return true;
    }

    public static Predicate getInstance() {
        return INSTANCE;
    }

    private TruePredicate() {
    }
}
