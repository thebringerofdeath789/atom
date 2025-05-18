package com.github.promeg.pinyinhelper;

import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class PinyinMapDict implements PinyinDict {
    public abstract Map<String, String[]> mapping();

    @Override // com.github.promeg.pinyinhelper.PinyinDict
    public Set<String> words() {
        if (mapping() != null) {
            return mapping().keySet();
        }
        return null;
    }

    @Override // com.github.promeg.pinyinhelper.PinyinDict
    public String[] toPinyin(String str) {
        if (mapping() != null) {
            return mapping().get(str);
        }
        return null;
    }
}