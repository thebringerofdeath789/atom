package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public final class NonePredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = 2007613066565892961L;
    private final Predicate[] iPredicates;

    public static Predicate getInstance(Predicate[] predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return TruePredicate.INSTANCE;
        }
        return new NonePredicate(FunctorUtils.copy(predicateArr));
    }

    public static Predicate getInstance(Collection collection) {
        Predicate[] validate = FunctorUtils.validate(collection);
        if (validate.length == 0) {
            return TruePredicate.INSTANCE;
        }
        return new NonePredicate(validate);
    }

    public NonePredicate(Predicate[] predicateArr) {
        this.iPredicates = predicateArr;
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        int i = 0;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i >= predicateArr.length) {
                return true;
            }
            if (predicateArr[i].evaluate(obj)) {
                return false;
            }
            i++;
        }
    }

    @Override // org.apache.commons.collections.functors.PredicateDecorator
    public Predicate[] getPredicates() {
        return this.iPredicates;
    }
}
