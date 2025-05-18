package com.opencsv.bean.processor;

/* loaded from: classes3.dex */
public class ConvertEmptyOrBlankStringsToNull implements StringProcessor {
    @Override // com.opencsv.bean.processor.StringProcessor
    public void setParameterString(String str) {
    }

    @Override // com.opencsv.bean.processor.StringProcessor
    public String processString(String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        return str;
    }
}