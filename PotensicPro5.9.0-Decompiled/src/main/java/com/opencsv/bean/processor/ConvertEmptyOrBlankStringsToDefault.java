package com.opencsv.bean.processor;

/* loaded from: classes3.dex */
public class ConvertEmptyOrBlankStringsToDefault implements StringProcessor {
    String defaultValue;

    @Override // com.opencsv.bean.processor.StringProcessor
    public String processString(String str) {
        return (str == null || str.trim().isEmpty()) ? this.defaultValue : str;
    }

    @Override // com.opencsv.bean.processor.StringProcessor
    public void setParameterString(String str) {
        this.defaultValue = str;
    }
}
