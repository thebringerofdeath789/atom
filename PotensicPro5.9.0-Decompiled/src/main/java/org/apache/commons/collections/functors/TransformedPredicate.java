package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public final class TransformedPredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = -5596090919668315834L;
    private final Predicate iPredicate;
    private final Transformer iTransformer;

    public static Predicate getInstance(Transformer transformer, Predicate predicate) {
        if (transformer == null) {
            throw new IllegalArgumentException("The transformer to call must not be null");
        }
        if (predicate == null) {
            throw new IllegalArgumentException("The predicate to call must not be null");
        }
        return new TransformedPredicate(transformer, predicate);
    }

    public TransformedPredicate(Transformer transformer, Predicate predicate) {
        this.iTransformer = transformer;
        this.iPredicate = predicate;
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        return this.iPredicate.evaluate(this.iTransformer.transform(obj));
    }

    @Override // org.apache.commons.collections.functors.PredicateDecorator
    public Predicate[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }

    public Transformer getTransformer() {
        return this.iTransformer;
    }
}
