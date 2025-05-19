package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import org.apache.commons.collections4.Transformer;

/* loaded from: classes4.dex */
public class ChainedTransformer<T> implements Transformer<T, T>, Serializable {
    private static final long serialVersionUID = 3514945074733160196L;
    private final Transformer<? super T, ? extends T>[] iTransformers;

    public static <T> Transformer<T, T> chainedTransformer(Transformer<? super T, ? extends T>... transformerArr) {
        FunctorUtils.validate(transformerArr);
        if (transformerArr.length == 0) {
            return NOPTransformer.nopTransformer();
        }
        return new ChainedTransformer(transformerArr);
    }

    public static <T> Transformer<T, T> chainedTransformer(Collection<? extends Transformer<? super T, ? extends T>> collection) {
        Objects.requireNonNull(collection, "Transformer collection must not be null");
        if (collection.size() == 0) {
            return NOPTransformer.nopTransformer();
        }
        Transformer[] transformerArr = (Transformer[]) collection.toArray(new Transformer[collection.size()]);
        FunctorUtils.validate((Transformer<?, ?>[]) transformerArr);
        return new ChainedTransformer(false, transformerArr);
    }

    private ChainedTransformer(boolean z, Transformer<? super T, ? extends T>[] transformerArr) {
        this.iTransformers = z ? FunctorUtils.copy(transformerArr) : transformerArr;
    }

    public ChainedTransformer(Transformer<? super T, ? extends T>... transformerArr) {
        this(true, transformerArr);
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T t) {
        for (Transformer<? super T, ? extends T> transformer : this.iTransformers) {
            t = transformer.transform(t);
        }
        return t;
    }

    public Transformer<? super T, ? extends T>[] getTransformers() {
        return FunctorUtils.copy(this.iTransformers);
    }
}
