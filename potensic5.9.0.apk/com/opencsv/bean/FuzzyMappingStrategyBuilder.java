package com.opencsv.bean;

/* loaded from: classes3.dex */
public class FuzzyMappingStrategyBuilder<T> {
    private boolean forceCorrectRecordLength = false;

    public FuzzyMappingStrategy<T> build() {
        return new FuzzyMappingStrategy<>(this.forceCorrectRecordLength);
    }

    public FuzzyMappingStrategyBuilder<T> withForceCorrectRecordLength(boolean z) {
        this.forceCorrectRecordLength = z;
        return this;
    }
}