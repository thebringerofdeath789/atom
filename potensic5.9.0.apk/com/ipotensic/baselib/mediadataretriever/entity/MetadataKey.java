package com.ipotensic.baselib.mediadataretriever.entity;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class MetadataKey {
    public String desc;
    public int keyInt;
    public String keyString;

    public MetadataKey(int i) {
        this.keyInt = i;
    }

    public MetadataKey(String str) {
        this.keyString = str;
    }

    public MetadataKey(int i, String str) {
        this.keyInt = i;
        this.desc = str;
    }

    public MetadataKey(String str, String str2) {
        this.keyString = str;
        this.desc = str2;
    }

    public MetadataKey(int i, String str, String str2) {
        this.keyInt = i;
        this.keyString = str;
        this.desc = str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.desc)) {
            sb.append(this.desc);
        }
        return sb.toString();
    }
}