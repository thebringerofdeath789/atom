package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public final class NullIsFalsePredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = -2997501534564735525L;
    private final Predicate iPredicate;

    public static Predicate getInstance(Predicate predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        }
        return new NullIsFalsePredicate(predicate);
    }

    public NullIsFalsePredicate(Predicate predicate) {
        this.iPredicate = predicate;
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.iPredicate.evaluate(obj);
    }

    @Override // org.apache.commons.collections.functors.PredicateDecorator
    public Predicate[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
