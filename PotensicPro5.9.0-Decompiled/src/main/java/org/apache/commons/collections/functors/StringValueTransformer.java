package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public final class StringValueTransformer implements Transformer, Serializable {
    public static final Transformer INSTANCE = new StringValueTransformer();
    private static final long serialVersionUID = 7511110693171758606L;

    public static Transformer getInstance() {
        return INSTANCE;
    }

    private StringValueTransformer() {
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        return String.valueOf(obj);
    }
}
