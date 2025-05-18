package com.ipotensic.baselib.mediadataretriever.entity;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class MetaDataHashMap extends HashMap<MetadataKey, String> {
    @Override // java.util.AbstractMap
    public String toString() {
        Set<Map.Entry<MetadataKey, String>> entrySet = entrySet();
        StringBuilder sb = new StringBuilder();
        int size = entrySet.size();
        int i = 0;
        for (Map.Entry<MetadataKey, String> entry : entrySet) {
            if (!TextUtils.isEmpty(entry.getValue())) {
                sb.append(entry.getKey().toString()).append(entry.getValue()).append(i == size + (-1) ? "" : "\n");
            }
            i++;
        }
        return sb.toString();
    }
}