package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Transformer;

/* loaded from: classes4.dex */
public class CloneTransformer<T> implements Transformer<T, T> {
    public static final Transformer INSTANCE = new CloneTransformer();

    public static <T> Transformer<T, T> cloneTransformer() {
        return INSTANCE;
    }

    private CloneTransformer() {
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T t) {
        if (t == null) {
            return null;
        }
        return (T) PrototypeFactory.prototypeFactory(t).create();
    }
}
