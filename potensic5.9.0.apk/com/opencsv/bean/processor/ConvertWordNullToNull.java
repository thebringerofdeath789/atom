package com.opencsv.bean.processor;

/* loaded from: classes3.dex */
public class ConvertWordNullToNull implements StringProcessor {
    @Override // com.opencsv.bean.processor.StringProcessor
    public void setParameterString(String str) {
    }

    @Override // com.opencsv.bean.processor.StringProcessor
    public String processString(String str) {
        if ("null".equalsIgnoreCase(str)) {
            return null;
        }
        return str;
    }
}