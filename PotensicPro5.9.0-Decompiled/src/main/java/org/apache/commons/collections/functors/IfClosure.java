package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public class IfClosure implements Closure, Serializable {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure iFalseClosure;
    private final Predicate iPredicate;
    private final Closure iTrueClosure;

    public static Closure getInstance(Predicate predicate, Closure closure) {
        return getInstance(predicate, closure, NOPClosure.INSTANCE);
    }

    public static Closure getInstance(Predicate predicate, Closure closure, Closure closure2) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        }
        if (closure == null || closure2 == null) {
            throw new IllegalArgumentException("Closures must not be null");
        }
        return new IfClosure(predicate, closure, closure2);
    }

    public IfClosure(Predicate predicate, Closure closure) {
        this(predicate, closure, NOPClosure.INSTANCE);
    }

    public IfClosure(Predicate predicate, Closure closure, Closure closure2) {
        this.iPredicate = predicate;
        this.iTrueClosure = closure;
        this.iFalseClosure = closure2;
    }

    @Override // org.apache.commons.collections.Closure
    public void execute(Object obj) {
        if (this.iPredicate.evaluate(obj)) {
            this.iTrueClosure.execute(obj);
        } else {
            this.iFalseClosure.execute(obj);
        }
    }

    public Predicate getPredicate() {
        return this.iPredicate;
    }

    public Closure getTrueClosure() {
        return this.iTrueClosure;
    }

    public Closure getFalseClosure() {
        return this.iFalseClosure;
    }
}
