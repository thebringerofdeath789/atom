package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.Closure;

/* loaded from: classes4.dex */
public class ChainedClosure<E> implements Closure<E>, Serializable {
    private static final long serialVersionUID = -3520677225766901240L;
    private final Closure<? super E>[] iClosures;

    public static <E> Closure<E> chainedClosure(Closure<? super E>... closureArr) {
        FunctorUtils.validate(closureArr);
        if (closureArr.length == 0) {
            return NOPClosure.nopClosure();
        }
        return new ChainedClosure(closureArr);
    }

    public static <E> Closure<E> chainedClosure(Collection<? extends Closure<? super E>> collection) {
        Objects.requireNonNull(collection, "Closure collection must not be null");
        if (collection.size() == 0) {
            return NOPClosure.nopClosure();
        }
        Closure[] closureArr = new Closure[collection.size()];
        Iterator<? extends Closure<? super E>> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            closureArr[i] = it.next();
            i++;
        }
        FunctorUtils.validate((Closure<?>[]) closureArr);
        return new ChainedClosure(false, closureArr);
    }

    private ChainedClosure(boolean z, Closure<? super E>... closureArr) {
        this.iClosures = z ? FunctorUtils.copy(closureArr) : closureArr;
    }

    public ChainedClosure(Closure<? super E>... closureArr) {
        this(true, closureArr);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e) {
        for (Closure<? super E> closure : this.iClosures) {
            closure.execute(e);
        }
    }

    public Closure<? super E>[] getClosures() {
        return FunctorUtils.copy(this.iClosures);
    }
}
