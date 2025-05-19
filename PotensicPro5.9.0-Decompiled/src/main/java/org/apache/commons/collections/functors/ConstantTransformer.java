package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public class ConstantTransformer implements Transformer, Serializable {
    public static final Transformer NULL_INSTANCE = new ConstantTransformer(null);
    private static final long serialVersionUID = 6374440726369055124L;
    private final Object iConstant;

    public static Transformer getInstance(Object obj) {
        if (obj == null) {
            return NULL_INSTANCE;
        }
        return new ConstantTransformer(obj);
    }

    public ConstantTransformer(Object obj) {
        this.iConstant = obj;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        return this.iConstant;
    }

    public Object getConstant() {
        return this.iConstant;
    }
}
