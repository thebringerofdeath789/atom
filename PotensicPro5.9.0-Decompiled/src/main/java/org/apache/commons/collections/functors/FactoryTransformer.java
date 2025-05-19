package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public class FactoryTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = -6817674502475353160L;
    private final Factory iFactory;

    public static Transformer getInstance(Factory factory) {
        if (factory == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        return new FactoryTransformer(factory);
    }

    public FactoryTransformer(Factory factory) {
        this.iFactory = factory;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        return this.iFactory.create();
    }

    public Factory getFactory() {
        return this.iFactory;
    }
}
