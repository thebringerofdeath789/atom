package com.opencsv.bean;

/* loaded from: classes3.dex */
public class HeaderColumnNameMappingStrategyBuilder<T> {
    private boolean forceCorrectRecordLength = false;

    public HeaderColumnNameMappingStrategy<T> build() {
        return new HeaderColumnNameMappingStrategy<>(this.forceCorrectRecordLength);
    }

    public HeaderColumnNameMappingStrategyBuilder<T> withForceCorrectRecordLength(boolean z) {
        this.forceCorrectRecordLength = z;
        return this;
    }
}