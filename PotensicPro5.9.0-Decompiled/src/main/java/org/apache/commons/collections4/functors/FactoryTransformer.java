package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

/* loaded from: classes4.dex */
public class FactoryTransformer<I, O> implements Transformer<I, O>, Serializable {
    private static final long serialVersionUID = -6817674502475353160L;
    private final Factory<? extends O> iFactory;

    public static <I, O> Transformer<I, O> factoryTransformer(Factory<? extends O> factory) {
        Objects.requireNonNull(factory, "Factory must not be null");
        return new FactoryTransformer(factory);
    }

    public FactoryTransformer(Factory<? extends O> factory) {
        this.iFactory = factory;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i) {
        return this.iFactory.create();
    }

    public Factory<? extends O> getFactory() {
        return this.iFactory;
    }
}
