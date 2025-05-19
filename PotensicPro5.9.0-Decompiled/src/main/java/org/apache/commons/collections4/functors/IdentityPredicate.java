package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* loaded from: classes4.dex */
public final class IdentityPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = -89901658494523293L;
    private final T iValue;

    public static <T> Predicate<T> identityPredicate(T t) {
        if (t == null) {
            return NullPredicate.nullPredicate();
        }
        return new IdentityPredicate(t);
    }

    public IdentityPredicate(T t) {
        this.iValue = t;
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        return this.iValue == t;
    }

    public T getValue() {
        return this.iValue;
    }
}
