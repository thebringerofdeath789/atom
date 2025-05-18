package com.github.promeg.pinyinhelper;

import java.util.Set;

/* loaded from: classes.dex */
public interface PinyinDict {
    String[] toPinyin(String str);

    Set<String> words();
}