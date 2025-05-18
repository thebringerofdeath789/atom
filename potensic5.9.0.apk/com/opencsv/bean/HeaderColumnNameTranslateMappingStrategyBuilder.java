package com.opencsv.bean;

/* loaded from: classes3.dex */
public class HeaderColumnNameTranslateMappingStrategyBuilder<T> {
    private boolean forceCorrectRecordLength = false;

    public HeaderColumnNameTranslateMappingStrategy<T> build() {
        return new HeaderColumnNameTranslateMappingStrategy<>(this.forceCorrectRecordLength);
    }

    public HeaderColumnNameTranslateMappingStrategyBuilder<T> withForceCorrectRecordLength(boolean z) {
        this.forceCorrectRecordLength = z;
        return this;
    }
}