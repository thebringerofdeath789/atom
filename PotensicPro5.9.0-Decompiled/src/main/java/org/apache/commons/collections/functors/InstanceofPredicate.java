package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public final class InstanceofPredicate implements Predicate, Serializable {
    private static final long serialVersionUID = -6682656911025165584L;
    private final Class iType;

    public static Predicate getInstance(Class cls) {
        if (cls == null) {
            throw new IllegalArgumentException("The type to check instanceof must not be null");
        }
        return new InstanceofPredicate(cls);
    }

    public InstanceofPredicate(Class cls) {
        this.iType = cls;
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        return this.iType.isInstance(obj);
    }

    public Class getType() {
        return this.iType;
    }
}
