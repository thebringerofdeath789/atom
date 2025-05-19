package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

/* loaded from: classes4.dex */
public class NOPTransformer<T> implements Transformer<T, T>, Serializable {
    public static final Transformer INSTANCE = new NOPTransformer();
    private static final long serialVersionUID = 2133891748318574490L;

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T t) {
        return t;
    }

    public static <T> Transformer<T, T> nopTransformer() {
        return INSTANCE;
    }

    private NOPTransformer() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
