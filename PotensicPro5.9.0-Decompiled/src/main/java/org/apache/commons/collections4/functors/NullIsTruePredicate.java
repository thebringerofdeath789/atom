package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

/* loaded from: classes4.dex */
public final class NullIsTruePredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = -7625133768987126273L;
    private final Predicate<? super T> iPredicate;

    public static <T> Predicate<T> nullIsTruePredicate(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "Predicate must not be null");
        return new NullIsTruePredicate(predicate);
    }

    public NullIsTruePredicate(Predicate<? super T> predicate) {
        this.iPredicate = predicate;
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        if (t == null) {
            return true;
        }
        return this.iPredicate.evaluate(t);
    }

    @Override // org.apache.commons.collections4.functors.PredicateDecorator
    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
