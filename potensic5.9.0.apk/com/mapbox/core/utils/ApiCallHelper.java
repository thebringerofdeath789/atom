package com.mapbox.core.utils;

import com.mapbox.core.constants.Constants;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class ApiCallHelper {
    private static final String ONLY_PRINTABLE_CHARS = "[^\\p{ASCII}]";

    private ApiCallHelper() {
    }

    public static String getHeaderUserAgent(String str) {
        String property = System.getProperty("os.name");
        String property2 = System.getProperty("os.version");
        String property3 = System.getProperty("os.arch");
        if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2) || TextUtils.isEmpty(property3)) {
            return Constants.HEADER_USER_AGENT;
        }
        return getHeaderUserAgent(str, property, property2, property3);
    }

    public static String getHeaderUserAgent(String str, String str2, String str3, String str4) {
        String format = String.format(Locale.US, "%s %s/%s (%s)", Constants.HEADER_USER_AGENT, str2.replaceAll(ONLY_PRINTABLE_CHARS, ""), str3.replaceAll(ONLY_PRINTABLE_CHARS, ""), str4.replaceAll(ONLY_PRINTABLE_CHARS, ""));
        return TextUtils.isEmpty(str) ? format : String.format(Locale.US, "%s %s", str, format);
    }
}