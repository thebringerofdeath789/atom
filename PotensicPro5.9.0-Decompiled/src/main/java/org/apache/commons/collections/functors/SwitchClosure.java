package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public class SwitchClosure implements Closure, Serializable {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure[] iClosures;
    private final Closure iDefault;
    private final Predicate[] iPredicates;

    public static Closure getInstance(Predicate[] predicateArr, Closure[] closureArr, Closure closure) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(closureArr);
        if (predicateArr.length != closureArr.length) {
            throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
        }
        if (predicateArr.length == 0) {
            return closure == null ? NOPClosure.INSTANCE : closure;
        }
        return new SwitchClosure(FunctorUtils.copy(predicateArr), FunctorUtils.copy(closureArr), closure);
    }

    public static Closure getInstance(Map map) {
        if (map == null) {
            throw new IllegalArgumentException("The predicate and closure map must not be null");
        }
        if (map.size() == 0) {
            return NOPClosure.INSTANCE;
        }
        Closure closure = (Closure) map.remove(null);
        int size = map.size();
        if (size == 0) {
            return closure == null ? NOPClosure.INSTANCE : closure;
        }
        Closure[] closureArr = new Closure[size];
        Predicate[] predicateArr = new Predicate[size];
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            predicateArr[i] = (Predicate) entry.getKey();
            closureArr[i] = (Closure) entry.getValue();
            i++;
        }
        return new SwitchClosure(predicateArr, closureArr, closure);
    }

    public SwitchClosure(Predicate[] predicateArr, Closure[] closureArr, Closure closure) {
        this.iPredicates = predicateArr;
        this.iClosures = closureArr;
        this.iDefault = closure == null ? NOPClosure.INSTANCE : closure;
    }

    @Override // org.apache.commons.collections.Closure
    public void execute(Object obj) {
        int i = 0;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i < predicateArr.length) {
                if (predicateArr[i].evaluate(obj)) {
                    this.iClosures[i].execute(obj);
                    return;
                }
                i++;
            } else {
                this.iDefault.execute(obj);
                return;
            }
        }
    }

    public Predicate[] getPredicates() {
        return this.iPredicates;
    }

    public Closure[] getClosures() {
        return this.iClosures;
    }

    public Closure getDefaultClosure() {
        return this.iDefault;
    }
}
