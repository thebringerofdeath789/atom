package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Closure;

/* loaded from: classes4.dex */
public class ChainedClosure implements Closure, Serializable {
    private static final long serialVersionUID = -3520677225766901240L;
    private final Closure[] iClosures;

    public static Closure getInstance(Closure[] closureArr) {
        FunctorUtils.validate(closureArr);
        if (closureArr.length == 0) {
            return NOPClosure.INSTANCE;
        }
        return new ChainedClosure(FunctorUtils.copy(closureArr));
    }

    public static Closure getInstance(Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Closure collection must not be null");
        }
        if (collection.size() == 0) {
            return NOPClosure.INSTANCE;
        }
        Closure[] closureArr = new Closure[collection.size()];
        int i = 0;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            closureArr[i] = (Closure) it.next();
            i++;
        }
        FunctorUtils.validate(closureArr);
        return new ChainedClosure(closureArr);
    }

    public static Closure getInstance(Closure closure, Closure closure2) {
        if (closure == null || closure2 == null) {
            throw new IllegalArgumentException("Closures must not be null");
        }
        return new ChainedClosure(new Closure[]{closure, closure2});
    }

    public ChainedClosure(Closure[] closureArr) {
        this.iClosures = closureArr;
    }

    @Override // org.apache.commons.collections.Closure
    public void execute(Object obj) {
        int i = 0;
        while (true) {
            Closure[] closureArr = this.iClosures;
            if (i >= closureArr.length) {
                return;
            }
            closureArr[i].execute(obj);
            i++;
        }
    }

    public Closure[] getClosures() {
        return this.iClosures;
    }
}
