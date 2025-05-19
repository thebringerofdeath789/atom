package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public final class OnePredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = -8125389089924745785L;
    private final Predicate[] iPredicates;

    public static Predicate getInstance(Predicate[] predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return FalsePredicate.INSTANCE;
        }
        if (predicateArr.length == 1) {
            return predicateArr[0];
        }
        return new OnePredicate(FunctorUtils.copy(predicateArr));
    }

    public static Predicate getInstance(Collection collection) {
        return new OnePredicate(FunctorUtils.validate(collection));
    }

    public OnePredicate(Predicate[] predicateArr) {
        this.iPredicates = predicateArr;
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        int i = 0;
        boolean z = false;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i >= predicateArr.length) {
                return z;
            }
            if (predicateArr[i].evaluate(obj)) {
                if (z) {
                    return false;
                }
                z = true;
            }
            i++;
        }
    }

    @Override // org.apache.commons.collections.functors.PredicateDecorator
    public Predicate[] getPredicates() {
        return this.iPredicates;
    }
}
