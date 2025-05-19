package com.opencsv.processor;

/* loaded from: classes3.dex */
public interface RowProcessor {
    String processColumnItem(String str);

    void processRow(String[] strArr);
}
