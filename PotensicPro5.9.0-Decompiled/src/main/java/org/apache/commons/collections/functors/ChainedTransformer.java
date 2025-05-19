package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public class ChainedTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = 3514945074733160196L;
    private final Transformer[] iTransformers;

    public static Transformer getInstance(Transformer[] transformerArr) {
        FunctorUtils.validate(transformerArr);
        if (transformerArr.length == 0) {
            return NOPTransformer.INSTANCE;
        }
        return new ChainedTransformer(FunctorUtils.copy(transformerArr));
    }

    public static Transformer getInstance(Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Transformer collection must not be null");
        }
        if (collection.size() == 0) {
            return NOPTransformer.INSTANCE;
        }
        Transformer[] transformerArr = new Transformer[collection.size()];
        int i = 0;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            transformerArr[i] = (Transformer) it.next();
            i++;
        }
        FunctorUtils.validate(transformerArr);
        return new ChainedTransformer(transformerArr);
    }

    public static Transformer getInstance(Transformer transformer, Transformer transformer2) {
        if (transformer == null || transformer2 == null) {
            throw new IllegalArgumentException("Transformers must not be null");
        }
        return new ChainedTransformer(new Transformer[]{transformer, transformer2});
    }

    public ChainedTransformer(Transformer[] transformerArr) {
        this.iTransformers = transformerArr;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        int i = 0;
        while (true) {
            Transformer[] transformerArr = this.iTransformers;
            if (i >= transformerArr.length) {
                return obj;
            }
            obj = transformerArr[i].transform(obj);
            i++;
        }
    }

    public Transformer[] getTransformers() {
        return this.iTransformers;
    }
}
