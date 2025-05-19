package org.apache.commons.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections.comparators.BooleanComparator;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.collections.comparators.NullComparator;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.apache.commons.collections.comparators.TransformingComparator;

/* loaded from: classes4.dex */
public class ComparatorUtils {
    public static final Comparator NATURAL_COMPARATOR = ComparableComparator.getInstance();

    public static Comparator naturalComparator() {
        return NATURAL_COMPARATOR;
    }

    public static Comparator chainedComparator(Comparator comparator, Comparator comparator2) {
        return chainedComparator(new Comparator[]{comparator, comparator2});
    }

    public static Comparator chainedComparator(Comparator[] comparatorArr) {
        ComparatorChain comparatorChain = new ComparatorChain();
        for (int i = 0; i < comparatorArr.length; i++) {
            Objects.requireNonNull(comparatorArr[i], "Comparator cannot be null");
            comparatorChain.addComparator(comparatorArr[i]);
        }
        return comparatorChain;
    }

    public static Comparator chainedComparator(Collection collection) {
        return chainedComparator((Comparator[]) collection.toArray(new Comparator[collection.size()]));
    }

    public static Comparator reversedComparator(Comparator comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new ReverseComparator(comparator);
    }

    public static Comparator booleanComparator(boolean z) {
        return BooleanComparator.getBooleanComparator(z);
    }

    public static Comparator nullLowComparator(Comparator comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new NullComparator(comparator, false);
    }

    public static Comparator nullHighComparator(Comparator comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new NullComparator(comparator, true);
    }

    public static Comparator transformedComparator(Comparator comparator, Transformer transformer) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new TransformingComparator(transformer, comparator);
    }

    public static Object min(Object obj, Object obj2, Comparator comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return comparator.compare(obj, obj2) < 0 ? obj : obj2;
    }

    public static Object max(Object obj, Object obj2, Comparator comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return comparator.compare(obj, obj2) > 0 ? obj : obj2;
    }
}
