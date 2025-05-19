package com.lib.bean;

import com.lib.LanguageType;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class TranslateItem {
    public HashMap<LanguageType, String> content = new HashMap<>();
    public String key;

    public String toString() {
        return "TranslateItem{key='" + this.key + "', content=" + this.content + '}';
    }
}
