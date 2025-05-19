package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* loaded from: classes4.dex */
public final class FalsePredicate<T> implements Predicate<T>, Serializable {
    public static final Predicate INSTANCE = new FalsePredicate();
    private static final long serialVersionUID = 7533784454832764388L;

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        return false;
    }

    public static <T> Predicate<T> falsePredicate() {
        return INSTANCE;
    }

    private FalsePredicate() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
