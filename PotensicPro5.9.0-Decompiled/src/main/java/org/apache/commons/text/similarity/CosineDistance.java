package org.apache.commons.text.similarity;

/* loaded from: classes4.dex */
public class CosineDistance implements EditDistance<Double> {
    private final Tokenizer<CharSequence> tokenizer = new RegexTokenizer();
    private final CosineSimilarity cosineSimilarity = new CosineSimilarity();

    @Override // org.apache.commons.text.similarity.EditDistance, org.apache.commons.text.similarity.SimilarityScore
    public Double apply(CharSequence charSequence, CharSequence charSequence2) {
        CharSequence[] charSequenceArr = this.tokenizer.tokenize(charSequence);
        CharSequence[] charSequenceArr2 = this.tokenizer.tokenize(charSequence2);
        return Double.valueOf(1.0d - this.cosineSimilarity.cosineSimilarity(Counter.of(charSequenceArr), Counter.of(charSequenceArr2)).doubleValue());
    }
}
