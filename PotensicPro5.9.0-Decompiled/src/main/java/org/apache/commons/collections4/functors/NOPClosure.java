package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;

/* loaded from: classes4.dex */
public final class NOPClosure<E> implements Closure<E>, Serializable {
    public static final Closure INSTANCE = new NOPClosure();
    private static final long serialVersionUID = 3518477308466486130L;

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e) {
    }

    public static <E> Closure<E> nopClosure() {
        return INSTANCE;
    }

    private NOPClosure() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
