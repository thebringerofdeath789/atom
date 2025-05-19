package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* loaded from: classes4.dex */
public final class NonePredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = 2007613066565892961L;

    public static <T> Predicate<T> nonePredicate(Predicate<? super T>... predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return TruePredicate.truePredicate();
        }
        return new NonePredicate(FunctorUtils.copy(predicateArr));
    }

    public static <T> Predicate<T> nonePredicate(Collection<? extends Predicate<? super T>> collection) {
        Predicate[] validate = FunctorUtils.validate(collection);
        if (validate.length == 0) {
            return TruePredicate.truePredicate();
        }
        return new NonePredicate(validate);
    }

    public NonePredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        for (Predicate<? super T> predicate : this.iPredicates) {
            if (predicate.evaluate(t)) {
                return false;
            }
        }
        return true;
    }
}
