package org.apache.commons.text.similarity;

/* loaded from: classes4.dex */
public class JaccardDistance implements EditDistance<Double> {
    private final JaccardSimilarity jaccardSimilarity = new JaccardSimilarity();

    @Override // org.apache.commons.text.similarity.EditDistance, org.apache.commons.text.similarity.SimilarityScore
    public Double apply(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return Double.valueOf(1.0d - this.jaccardSimilarity.apply(charSequence, charSequence2).doubleValue());
    }
}
