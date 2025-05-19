package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Closure;

/* loaded from: classes4.dex */
public class NOPClosure implements Closure, Serializable {
    public static final Closure INSTANCE = new NOPClosure();
    private static final long serialVersionUID = 3518477308466486130L;

    @Override // org.apache.commons.collections.Closure
    public void execute(Object obj) {
    }

    public static Closure getInstance() {
        return INSTANCE;
    }

    private NOPClosure() {
    }
}
