package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* loaded from: classes4.dex */
public final class AnyPredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = 7429999530934647542L;

    public static <T> Predicate<T> anyPredicate(Predicate<? super T>... predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return FalsePredicate.falsePredicate();
        }
        if (predicateArr.length == 1) {
            return (Predicate<T>) predicateArr[0];
        }
        return new AnyPredicate(FunctorUtils.copy(predicateArr));
    }

    public static <T> Predicate<T> anyPredicate(Collection<? extends Predicate<? super T>> collection) {
        Predicate<T>[] validate = FunctorUtils.validate(collection);
        if (validate.length == 0) {
            return FalsePredicate.falsePredicate();
        }
        if (validate.length == 1) {
            return validate[0];
        }
        return new AnyPredicate(validate);
    }

    public AnyPredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        for (Predicate<? super T> predicate : this.iPredicates) {
            if (predicate.evaluate(t)) {
                return true;
            }
        }
        return false;
    }
}
