package org.ahocorasick.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class IntervalNode {
    private List<Intervalable> intervals = new ArrayList();
    private IntervalNode left;
    private int point;
    private IntervalNode right;

    private enum Direction {
        LEFT,
        RIGHT
    }

    public IntervalNode(List<Intervalable> list) {
        this.left = null;
        this.right = null;
        this.point = determineMedian(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Intervalable intervalable : list) {
            if (intervalable.getEnd() < this.point) {
                arrayList.add(intervalable);
            } else if (intervalable.getStart() > this.point) {
                arrayList2.add(intervalable);
            } else {
                this.intervals.add(intervalable);
            }
        }
        if (arrayList.size() > 0) {
            this.left = new IntervalNode(arrayList);
        }
        if (arrayList2.size() > 0) {
            this.right = new IntervalNode(arrayList2);
        }
    }

    public int determineMedian(List<Intervalable> list) {
        int i = -1;
        int i2 = -1;
        for (Intervalable intervalable : list) {
            int start = intervalable.getStart();
            int end = intervalable.getEnd();
            if (i == -1 || start < i) {
                i = start;
            }
            if (i2 == -1 || end > i2) {
                i2 = end;
            }
        }
        return (i + i2) / 2;
    }

    public List<Intervalable> findOverlaps(Intervalable intervalable) {
        ArrayList arrayList = new ArrayList();
        if (this.point < intervalable.getStart()) {
            addToOverlaps(intervalable, arrayList, findOverlappingRanges(this.right, intervalable));
            addToOverlaps(intervalable, arrayList, checkForOverlapsToTheRight(intervalable));
        } else if (this.point > intervalable.getEnd()) {
            addToOverlaps(intervalable, arrayList, findOverlappingRanges(this.left, intervalable));
            addToOverlaps(intervalable, arrayList, checkForOverlapsToTheLeft(intervalable));
        } else {
            addToOverlaps(intervalable, arrayList, this.intervals);
            addToOverlaps(intervalable, arrayList, findOverlappingRanges(this.left, intervalable));
            addToOverlaps(intervalable, arrayList, findOverlappingRanges(this.right, intervalable));
        }
        return arrayList;
    }

    protected void addToOverlaps(Intervalable intervalable, List<Intervalable> list, List<Intervalable> list2) {
        for (Intervalable intervalable2 : list2) {
            if (!intervalable2.equals(intervalable)) {
                list.add(intervalable2);
            }
        }
    }

    protected List<Intervalable> checkForOverlapsToTheLeft(Intervalable intervalable) {
        return checkForOverlaps(intervalable, Direction.LEFT);
    }

    protected List<Intervalable> checkForOverlapsToTheRight(Intervalable intervalable) {
        return checkForOverlaps(intervalable, Direction.RIGHT);
    }

    protected List<Intervalable> checkForOverlaps(Intervalable intervalable, Direction direction) {
        ArrayList arrayList = new ArrayList();
        for (Intervalable intervalable2 : this.intervals) {
            int i = AnonymousClass1.$SwitchMap$org$ahocorasick$interval$IntervalNode$Direction[direction.ordinal()];
            if (i == 1) {
                if (intervalable2.getStart() <= intervalable.getEnd()) {
                    arrayList.add(intervalable2);
                }
            } else if (i == 2 && intervalable2.getEnd() >= intervalable.getStart()) {
                arrayList.add(intervalable2);
            }
        }
        return arrayList;
    }

    /* renamed from: org.ahocorasick.interval.IntervalNode$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$ahocorasick$interval$IntervalNode$Direction;

        static {
            int[] iArr = new int[Direction.values().length];
            $SwitchMap$org$ahocorasick$interval$IntervalNode$Direction = iArr;
            try {
                iArr[Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$ahocorasick$interval$IntervalNode$Direction[Direction.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected List<Intervalable> findOverlappingRanges(IntervalNode intervalNode, Intervalable intervalable) {
        if (intervalNode != null) {
            return intervalNode.findOverlaps(intervalable);
        }
        return Collections.emptyList();
    }
}
