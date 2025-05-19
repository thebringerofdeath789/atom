package org.ahocorasick.interval;

import java.util.Comparator;

/* loaded from: classes4.dex */
public class IntervalableComparatorByPosition implements Comparator<Intervalable> {
    @Override // java.util.Comparator
    public int compare(Intervalable intervalable, Intervalable intervalable2) {
        return intervalable.getStart() - intervalable2.getStart();
    }
}
