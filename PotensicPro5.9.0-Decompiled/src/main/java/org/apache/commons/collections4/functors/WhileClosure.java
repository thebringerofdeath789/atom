package org.apache.commons.collections4.functors;

import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

/* loaded from: classes4.dex */
public class WhileClosure<E> implements Closure<E> {
    private final Closure<? super E> iClosure;
    private final boolean iDoLoop;
    private final Predicate<? super E> iPredicate;

    public static <E> Closure<E> whileClosure(Predicate<? super E> predicate, Closure<? super E> closure, boolean z) {
        Objects.requireNonNull(predicate, "Predicate must not be null");
        Objects.requireNonNull(closure, "Closure must not be null");
        return new WhileClosure(predicate, closure, z);
    }

    public WhileClosure(Predicate<? super E> predicate, Closure<? super E> closure, boolean z) {
        this.iPredicate = predicate;
        this.iClosure = closure;
        this.iDoLoop = z;
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e) {
        if (this.iDoLoop) {
            this.iClosure.execute(e);
        }
        while (this.iPredicate.evaluate(e)) {
            this.iClosure.execute(e);
        }
    }

    public Predicate<? super E> getPredicate() {
        return this.iPredicate;
    }

    public Closure<? super E> getClosure() {
        return this.iClosure;
    }

    public boolean isDoLoop() {
        return this.iDoLoop;
    }
}
