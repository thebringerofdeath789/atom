package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* loaded from: classes4.dex */
public final class TransformedPredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = -5596090919668315834L;
    private final Predicate<? super T> iPredicate;
    private final Transformer<? super T, ? extends T> iTransformer;

    public static <T> Predicate<T> transformedPredicate(Transformer<? super T, ? extends T> transformer, Predicate<? super T> predicate) {
        Objects.requireNonNull(transformer, "The transformer to call must not be null");
        Objects.requireNonNull(predicate, "The predicate to call must not be null");
        return new TransformedPredicate(transformer, predicate);
    }

    public TransformedPredicate(Transformer<? super T, ? extends T> transformer, Predicate<? super T> predicate) {
        this.iTransformer = transformer;
        this.iPredicate = predicate;
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        return this.iPredicate.evaluate(this.iTransformer.transform(t));
    }

    @Override // org.apache.commons.collections4.functors.PredicateDecorator
    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }

    public Transformer<? super T, ? extends T> getTransformer() {
        return this.iTransformer;
    }
}
