package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Factory;

/* loaded from: classes4.dex */
public class ConstantFactory implements Factory, Serializable {
    public static final Factory NULL_INSTANCE = new ConstantFactory(null);
    private static final long serialVersionUID = -3520677225766901240L;
    private final Object iConstant;

    public static Factory getInstance(Object obj) {
        if (obj == null) {
            return NULL_INSTANCE;
        }
        return new ConstantFactory(obj);
    }

    public ConstantFactory(Object obj) {
        this.iConstant = obj;
    }

    @Override // org.apache.commons.collections.Factory
    public Object create() {
        return this.iConstant;
    }

    public Object getConstant() {
        return this.iConstant;
    }
}
