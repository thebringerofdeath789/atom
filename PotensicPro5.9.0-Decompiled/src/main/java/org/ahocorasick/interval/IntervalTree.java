package org.ahocorasick.interval;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* loaded from: classes4.dex */
public class IntervalTree {
    private IntervalNode rootNode;

    public IntervalTree(List<Intervalable> list) {
        this.rootNode = null;
        this.rootNode = new IntervalNode(list);
    }

    public List<Intervalable> removeOverlaps(List<Intervalable> list) {
        Collections.sort(list, new IntervalableComparatorBySize());
        TreeSet treeSet = new TreeSet();
        for (Intervalable intervalable : list) {
            if (!treeSet.contains(intervalable)) {
                treeSet.addAll(findOverlaps(intervalable));
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            list.remove((Intervalable) it.next());
        }
        Collections.sort(list, new IntervalableComparatorByPosition());
        return list;
    }

    public List<Intervalable> findOverlaps(Intervalable intervalable) {
        return this.rootNode.findOverlaps(intervalable);
    }
}
