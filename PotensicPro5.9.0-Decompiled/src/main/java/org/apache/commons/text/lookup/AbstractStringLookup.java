package org.apache.commons.text.lookup;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
abstract class AbstractStringLookup implements StringLookup {
    protected static final char SPLIT_CH = ':';
    protected static final String SPLIT_STR = String.valueOf(':');

    AbstractStringLookup() {
    }

    static String toLookupKey(String str, String str2) {
        return toLookupKey(str, SPLIT_STR, str2);
    }

    static String toLookupKey(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    @Deprecated
    protected String substringAfter(String str, char c) {
        return StringUtils.substringAfter(str, c);
    }

    @Deprecated
    protected String substringAfter(String str, String str2) {
        return StringUtils.substringAfter(str, str2);
    }

    @Deprecated
    protected String substringAfterLast(String str, char c) {
        return StringUtils.substringAfterLast(str, c);
    }
}
