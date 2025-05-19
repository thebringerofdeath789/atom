package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Transformer;

/* loaded from: classes4.dex */
public class ClosureTransformer<T> implements Transformer<T, T>, Serializable {
    private static final long serialVersionUID = 478466901448617286L;
    private final Closure<? super T> iClosure;

    public static <T> Transformer<T, T> closureTransformer(Closure<? super T> closure) {
        Objects.requireNonNull(closure, "Closure must not be null");
        return new ClosureTransformer(closure);
    }

    public ClosureTransformer(Closure<? super T> closure) {
        this.iClosure = closure;
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T t) {
        this.iClosure.execute(t);
        return t;
    }

    public Closure<? super T> getClosure() {
        return this.iClosure;
    }
}
