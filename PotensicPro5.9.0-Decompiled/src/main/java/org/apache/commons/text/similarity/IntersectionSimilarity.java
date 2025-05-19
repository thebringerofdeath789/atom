package org.apache.commons.text.similarity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* loaded from: classes4.dex */
public class IntersectionSimilarity<T> implements SimilarityScore<IntersectionResult> {
    private final Function<CharSequence, Collection<T>> converter;

    private static class BagCount {
        int count;

        private BagCount() {
            this.count = 1;
        }
    }

    private class TinyBag {
        private final Map<T, BagCount> map;

        TinyBag(int i) {
            this.map = new HashMap(i);
        }

        void add(T t) {
            BagCount bagCount = this.map.get(t);
            if (bagCount == null) {
                this.map.put(t, new BagCount());
            } else {
                bagCount.count++;
            }
        }

        int getCount(Object obj) {
            BagCount bagCount = this.map.get(obj);
            if (bagCount != null) {
                return bagCount.count;
            }
            return 0;
        }

        Set<Map.Entry<T, BagCount>> entrySet() {
            return this.map.entrySet();
        }

        int uniqueElementSize() {
            return this.map.size();
        }
    }

    public IntersectionSimilarity(Function<CharSequence, Collection<T>> function) {
        if (function == null) {
            throw new IllegalArgumentException("Converter must not be null");
        }
        this.converter = function;
    }

    @Override // org.apache.commons.text.similarity.SimilarityScore
    public IntersectionResult apply(CharSequence charSequence, CharSequence charSequence2) {
        int intersection;
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        Collection<T> apply = this.converter.apply(charSequence);
        Collection<T> apply2 = this.converter.apply(charSequence2);
        int size = apply.size();
        int size2 = apply2.size();
        if (Math.min(size, size2) == 0) {
            return new IntersectionResult(size, size2, 0);
        }
        if (!(apply instanceof Set) || !(apply2 instanceof Set)) {
            IntersectionSimilarity<T>.TinyBag bag = toBag(apply);
            IntersectionSimilarity<T>.TinyBag bag2 = toBag(apply2);
            if (bag.uniqueElementSize() < bag2.uniqueElementSize()) {
                intersection = getIntersection(bag, bag2);
            } else {
                intersection = getIntersection(bag2, bag);
            }
        } else if (size < size2) {
            intersection = getIntersection((Set) apply, (Set) apply2);
        } else {
            intersection = getIntersection((Set) apply2, (Set) apply);
        }
        return new IntersectionResult(size, size2, intersection);
    }

    private IntersectionSimilarity<T>.TinyBag toBag(Collection<T> collection) {
        IntersectionSimilarity<T>.TinyBag tinyBag = new TinyBag(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            tinyBag.add(it.next());
        }
        return tinyBag;
    }

    private static <T> int getIntersection(Set<T> set, Set<T> set2) {
        Iterator<T> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (set2.contains(it.next())) {
                i++;
            }
        }
        return i;
    }

    private int getIntersection(IntersectionSimilarity<T>.TinyBag tinyBag, IntersectionSimilarity<T>.TinyBag tinyBag2) {
        int i = 0;
        for (Map.Entry<T, BagCount> entry : tinyBag.entrySet()) {
            i += Math.min(entry.getValue().count, tinyBag2.getCount(entry.getKey()));
        }
        return i;
    }
}
