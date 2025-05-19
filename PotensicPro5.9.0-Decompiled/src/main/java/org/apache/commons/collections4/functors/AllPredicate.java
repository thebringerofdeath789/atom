package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* loaded from: classes4.dex */
public final class AllPredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = -3094696765038308799L;

    public static <T> Predicate<T> allPredicate(Predicate<? super T>... predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return TruePredicate.truePredicate();
        }
        if (predicateArr.length == 1) {
            return FunctorUtils.coerce(predicateArr[0]);
        }
        return new AllPredicate(FunctorUtils.copy(predicateArr));
    }

    public static <T> Predicate<T> allPredicate(Collection<? extends Predicate<? super T>> collection) {
        Predicate[] validate = FunctorUtils.validate(collection);
        if (validate.length == 0) {
            return TruePredicate.truePredicate();
        }
        if (validate.length == 1) {
            return FunctorUtils.coerce(validate[0]);
        }
        return new AllPredicate(validate);
    }

    public AllPredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        for (Predicate<? super T> predicate : this.iPredicates) {
            if (!predicate.evaluate(t)) {
                return false;
            }
        }
        return true;
    }
}
