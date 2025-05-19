package org.apache.commons.collections.comparators;

import java.util.Comparator;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public class TransformingComparator implements Comparator {
    protected Comparator decorated;
    protected Transformer transformer;

    public TransformingComparator(Transformer transformer) {
        this(transformer, new ComparableComparator());
    }

    public TransformingComparator(Transformer transformer, Comparator comparator) {
        this.decorated = comparator;
        this.transformer = transformer;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.decorated.compare(this.transformer.transform(obj), this.transformer.transform(obj2));
    }
}
