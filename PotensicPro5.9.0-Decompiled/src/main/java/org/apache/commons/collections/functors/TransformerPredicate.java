package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public final class TransformerPredicate implements Predicate, Serializable {
    private static final long serialVersionUID = -2407966402920578741L;
    private final Transformer iTransformer;

    public static Predicate getInstance(Transformer transformer) {
        if (transformer == null) {
            throw new IllegalArgumentException("The transformer to call must not be null");
        }
        return new TransformerPredicate(transformer);
    }

    public TransformerPredicate(Transformer transformer) {
        this.iTransformer = transformer;
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        Object transform = this.iTransformer.transform(obj);
        if (!(transform instanceof Boolean)) {
            throw new FunctorException(new StringBuffer().append("Transformer must return an instanceof Boolean, it was a ").append(transform == null ? "null object" : transform.getClass().getName()).toString());
        }
        return ((Boolean) transform).booleanValue();
    }

    public Transformer getTransformer() {
        return this.iTransformer;
    }
}
