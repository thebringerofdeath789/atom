package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public final class ExceptionTransformer implements Transformer, Serializable {
    public static final Transformer INSTANCE = new ExceptionTransformer();
    private static final long serialVersionUID = 7179106032121985545L;

    public static Transformer getInstance() {
        return INSTANCE;
    }

    private ExceptionTransformer() {
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        throw new FunctorException("ExceptionTransformer invoked");
    }
}
