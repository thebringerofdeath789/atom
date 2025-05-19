package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public class SwitchTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = -6404460890903469332L;
    private final Transformer iDefault;
    private final Predicate[] iPredicates;
    private final Transformer[] iTransformers;

    public static Transformer getInstance(Predicate[] predicateArr, Transformer[] transformerArr, Transformer transformer) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(transformerArr);
        if (predicateArr.length != transformerArr.length) {
            throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
        }
        if (predicateArr.length == 0) {
            return transformer == null ? ConstantTransformer.NULL_INSTANCE : transformer;
        }
        return new SwitchTransformer(FunctorUtils.copy(predicateArr), FunctorUtils.copy(transformerArr), transformer);
    }

    public static Transformer getInstance(Map map) {
        if (map == null) {
            throw new IllegalArgumentException("The predicate and transformer map must not be null");
        }
        if (map.size() == 0) {
            return ConstantTransformer.NULL_INSTANCE;
        }
        Transformer transformer = (Transformer) map.remove(null);
        int size = map.size();
        if (size == 0) {
            return transformer == null ? ConstantTransformer.NULL_INSTANCE : transformer;
        }
        Transformer[] transformerArr = new Transformer[size];
        Predicate[] predicateArr = new Predicate[size];
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            predicateArr[i] = (Predicate) entry.getKey();
            transformerArr[i] = (Transformer) entry.getValue();
            i++;
        }
        return new SwitchTransformer(predicateArr, transformerArr, transformer);
    }

    public SwitchTransformer(Predicate[] predicateArr, Transformer[] transformerArr, Transformer transformer) {
        this.iPredicates = predicateArr;
        this.iTransformers = transformerArr;
        this.iDefault = transformer == null ? ConstantTransformer.NULL_INSTANCE : transformer;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        int i = 0;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i < predicateArr.length) {
                if (predicateArr[i].evaluate(obj)) {
                    return this.iTransformers[i].transform(obj);
                }
                i++;
            } else {
                return this.iDefault.transform(obj);
            }
        }
    }

    public Predicate[] getPredicates() {
        return this.iPredicates;
    }

    public Transformer[] getTransformers() {
        return this.iTransformers;
    }

    public Transformer getDefaultTransformer() {
        return this.iDefault;
    }
}
