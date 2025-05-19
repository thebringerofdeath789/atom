package org.apache.commons.collections;

import java.util.Collection;
import java.util.Map;
import org.apache.commons.collections.functors.ChainedClosure;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.ExceptionClosure;
import org.apache.commons.collections.functors.ForClosure;
import org.apache.commons.collections.functors.IfClosure;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.functors.NOPClosure;
import org.apache.commons.collections.functors.SwitchClosure;
import org.apache.commons.collections.functors.TransformerClosure;
import org.apache.commons.collections.functors.WhileClosure;

/* loaded from: classes4.dex */
public class ClosureUtils {
    public static Closure exceptionClosure() {
        return ExceptionClosure.INSTANCE;
    }

    public static Closure nopClosure() {
        return NOPClosure.INSTANCE;
    }

    public static Closure asClosure(Transformer transformer) {
        return TransformerClosure.getInstance(transformer);
    }

    public static Closure forClosure(int i, Closure closure) {
        return ForClosure.getInstance(i, closure);
    }

    public static Closure whileClosure(Predicate predicate, Closure closure) {
        return WhileClosure.getInstance(predicate, closure, false);
    }

    public static Closure doWhileClosure(Closure closure, Predicate predicate) {
        return WhileClosure.getInstance(predicate, closure, true);
    }

    public static Closure invokerClosure(String str) {
        return asClosure(InvokerTransformer.getInstance(str));
    }

    public static Closure invokerClosure(String str, Class[] clsArr, Object[] objArr) {
        return asClosure(InvokerTransformer.getInstance(str, clsArr, objArr));
    }

    public static Closure chainedClosure(Closure closure, Closure closure2) {
        return ChainedClosure.getInstance(closure, closure2);
    }

    public static Closure chainedClosure(Closure[] closureArr) {
        return ChainedClosure.getInstance(closureArr);
    }

    public static Closure chainedClosure(Collection collection) {
        return ChainedClosure.getInstance(collection);
    }

    public static Closure ifClosure(Predicate predicate, Closure closure) {
        return IfClosure.getInstance(predicate, closure);
    }

    public static Closure ifClosure(Predicate predicate, Closure closure, Closure closure2) {
        return IfClosure.getInstance(predicate, closure, closure2);
    }

    public static Closure switchClosure(Predicate[] predicateArr, Closure[] closureArr) {
        return SwitchClosure.getInstance(predicateArr, closureArr, null);
    }

    public static Closure switchClosure(Predicate[] predicateArr, Closure[] closureArr, Closure closure) {
        return SwitchClosure.getInstance(predicateArr, closureArr, closure);
    }

    public static Closure switchClosure(Map map) {
        return SwitchClosure.getInstance(map);
    }

    public static Closure switchMapClosure(Map map) {
        if (map == null) {
            throw new IllegalArgumentException("The object and closure map must not be null");
        }
        Closure closure = (Closure) map.remove(null);
        int size = map.size();
        Closure[] closureArr = new Closure[size];
        Predicate[] predicateArr = new Predicate[size];
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            predicateArr[i] = EqualPredicate.getInstance(entry.getKey());
            closureArr[i] = (Closure) entry.getValue();
            i++;
        }
        return switchClosure(predicateArr, closureArr, closure);
    }
}
