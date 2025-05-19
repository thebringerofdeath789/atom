package org.apache.commons.collections;

import java.util.Collection;
import java.util.Map;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.CloneTransformer;
import org.apache.commons.collections.functors.ClosureTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.ExceptionTransformer;
import org.apache.commons.collections.functors.FactoryTransformer;
import org.apache.commons.collections.functors.InstantiateTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.functors.MapTransformer;
import org.apache.commons.collections.functors.NOPTransformer;
import org.apache.commons.collections.functors.PredicateTransformer;
import org.apache.commons.collections.functors.StringValueTransformer;
import org.apache.commons.collections.functors.SwitchTransformer;

/* loaded from: classes4.dex */
public class TransformerUtils {
    public static Transformer exceptionTransformer() {
        return ExceptionTransformer.INSTANCE;
    }

    public static Transformer nullTransformer() {
        return ConstantTransformer.NULL_INSTANCE;
    }

    public static Transformer nopTransformer() {
        return NOPTransformer.INSTANCE;
    }

    public static Transformer cloneTransformer() {
        return CloneTransformer.INSTANCE;
    }

    public static Transformer constantTransformer(Object obj) {
        return ConstantTransformer.getInstance(obj);
    }

    public static Transformer asTransformer(Closure closure) {
        return ClosureTransformer.getInstance(closure);
    }

    public static Transformer asTransformer(Predicate predicate) {
        return PredicateTransformer.getInstance(predicate);
    }

    public static Transformer asTransformer(Factory factory) {
        return FactoryTransformer.getInstance(factory);
    }

    public static Transformer chainedTransformer(Transformer transformer, Transformer transformer2) {
        return ChainedTransformer.getInstance(transformer, transformer2);
    }

    public static Transformer chainedTransformer(Transformer[] transformerArr) {
        return ChainedTransformer.getInstance(transformerArr);
    }

    public static Transformer chainedTransformer(Collection collection) {
        return ChainedTransformer.getInstance(collection);
    }

    public static Transformer switchTransformer(Predicate predicate, Transformer transformer, Transformer transformer2) {
        return SwitchTransformer.getInstance(new Predicate[]{predicate}, new Transformer[]{transformer}, transformer2);
    }

    public static Transformer switchTransformer(Predicate[] predicateArr, Transformer[] transformerArr) {
        return SwitchTransformer.getInstance(predicateArr, transformerArr, null);
    }

    public static Transformer switchTransformer(Predicate[] predicateArr, Transformer[] transformerArr, Transformer transformer) {
        return SwitchTransformer.getInstance(predicateArr, transformerArr, transformer);
    }

    public static Transformer switchTransformer(Map map) {
        return SwitchTransformer.getInstance(map);
    }

    public static Transformer switchMapTransformer(Map map) {
        if (map == null) {
            throw new IllegalArgumentException("The object and transformer map must not be null");
        }
        Transformer transformer = (Transformer) map.remove(null);
        int size = map.size();
        Transformer[] transformerArr = new Transformer[size];
        Predicate[] predicateArr = new Predicate[size];
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            predicateArr[i] = EqualPredicate.getInstance(entry.getKey());
            transformerArr[i] = (Transformer) entry.getValue();
            i++;
        }
        return switchTransformer(predicateArr, transformerArr, transformer);
    }

    public static Transformer instantiateTransformer() {
        return InstantiateTransformer.NO_ARG_INSTANCE;
    }

    public static Transformer instantiateTransformer(Class[] clsArr, Object[] objArr) {
        return InstantiateTransformer.getInstance(clsArr, objArr);
    }

    public static Transformer mapTransformer(Map map) {
        return MapTransformer.getInstance(map);
    }

    public static Transformer invokerTransformer(String str) {
        return InvokerTransformer.getInstance(str, null, null);
    }

    public static Transformer invokerTransformer(String str, Class[] clsArr, Object[] objArr) {
        return InvokerTransformer.getInstance(str, clsArr, objArr);
    }

    public static Transformer stringValueTransformer() {
        return StringValueTransformer.INSTANCE;
    }
}
