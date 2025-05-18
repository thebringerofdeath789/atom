package com.opencsv.bean.comparator;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import org.apache.commons.collections4.comparators.ComparableComparator;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.apache.commons.collections4.comparators.FixedOrderComparator;
import org.apache.commons.collections4.comparators.NullComparator;

@Deprecated
/* loaded from: classes3.dex */
public class LiteralComparator<T extends Comparable<T>> implements Comparator<T>, Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: c */
    private Comparator<T> f2725c;

    public LiteralComparator(T[] tArr) {
        FixedOrderComparator fixedOrderComparator = new FixedOrderComparator(tArr == null ? Collections.emptyList() : Arrays.asList(tArr));
        fixedOrderComparator.setUnknownObjectBehavior(FixedOrderComparator.UnknownObjectBehavior.AFTER);
        this.f2725c = new ComparatorChain(Arrays.asList(fixedOrderComparator, new NullComparator(false), new ComparableComparator()));
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return this.f2725c.compare(t, t2);
    }
}