package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public final class AnyPredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = 7429999530934647542L;
    private final Predicate[] iPredicates;

    public static Predicate getInstance(Predicate[] predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return FalsePredicate.INSTANCE;
        }
        if (predicateArr.length == 1) {
            return predicateArr[0];
        }
        return new AnyPredicate(FunctorUtils.copy(predicateArr));
    }

    public static Predicate getInstance(Collection collection) {
        Predicate[] validate = FunctorUtils.validate(collection);
        if (validate.length == 0) {
            return FalsePredicate.INSTANCE;
        }
        if (validate.length == 1) {
            return validate[0];
        }
        return new AnyPredicate(validate);
    }

    public AnyPredicate(Predicate[] predicateArr) {
        this.iPredicates = predicateArr;
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        int i = 0;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i >= predicateArr.length) {
                return false;
            }
            if (predicateArr[i].evaluate(obj)) {
                return true;
            }
            i++;
        }
    }

    @Override // org.apache.commons.collections.functors.PredicateDecorator
    public Predicate[] getPredicates() {
        return this.iPredicates;
    }
}
