package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Factory;

/* loaded from: classes4.dex */
public class ConstantFactory<T> implements Factory<T>, Serializable {
    public static final Factory NULL_INSTANCE = new ConstantFactory(null);
    private static final long serialVersionUID = -3520677225766901240L;
    private final T iConstant;

    public static <T> Factory<T> constantFactory(T t) {
        if (t == null) {
            return NULL_INSTANCE;
        }
        return new ConstantFactory(t);
    }

    public ConstantFactory(T t) {
        this.iConstant = t;
    }

    @Override // org.apache.commons.collections4.Factory
    public T create() {
        return this.iConstant;
    }

    public T getConstant() {
        return this.iConstant;
    }
}
