package org.apache.commons.text.similarity;

import java.util.HashSet;

/* loaded from: classes4.dex */
public class JaccardSimilarity implements SimilarityScore<Double> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.text.similarity.SimilarityScore
    public Double apply(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return calculateJaccardSimilarity(charSequence, charSequence2);
    }

    private Double calculateJaccardSimilarity(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        if (length == 0 || length2 == 0) {
            return Double.valueOf(0.0d);
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < length; i++) {
            hashSet.add(Character.valueOf(charSequence.charAt(i)));
        }
        HashSet hashSet2 = new HashSet();
        for (int i2 = 0; i2 < length2; i2++) {
            hashSet2.add(Character.valueOf(charSequence2.charAt(i2)));
        }
        new HashSet(hashSet).addAll(hashSet2);
        return Double.valueOf((((hashSet.size() + hashSet2.size()) - r8.size()) * 1.0d) / r8.size());
    }
}
