package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.FunctorException;

/* loaded from: classes4.dex */
public final class ExceptionClosure<E> implements Closure<E>, Serializable {
    public static final Closure INSTANCE = new ExceptionClosure();
    private static final long serialVersionUID = 7179106032121985545L;

    public static <E> Closure<E> exceptionClosure() {
        return INSTANCE;
    }

    private ExceptionClosure() {
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e) {
        throw new FunctorException("ExceptionClosure invoked");
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
