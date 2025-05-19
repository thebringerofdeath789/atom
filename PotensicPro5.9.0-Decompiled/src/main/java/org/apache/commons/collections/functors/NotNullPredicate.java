package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public final class NotNullPredicate implements Predicate, Serializable {
    public static final Predicate INSTANCE = new NotNullPredicate();
    private static final long serialVersionUID = 7533784454832764388L;

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        return obj != null;
    }

    public static Predicate getInstance() {
        return INSTANCE;
    }

    private NotNullPredicate() {
    }
}
