package com.ipotensic.baselib.guide.util;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes2.dex */
public class LogUtil {
    private static final int NONE = 8;
    public static final int level = 8;
    private static final String tagPrefix = "NewbieGuide";

    /* renamed from: d */
    public static void m1693d(String str) {
    }

    /* renamed from: d */
    public static void m1694d(String str, Throwable th) {
    }

    /* renamed from: e */
    public static void m1695e(String str) {
    }

    /* renamed from: e */
    public static void m1696e(String str, Throwable th) {
    }

    /* renamed from: i */
    public static void m1697i(String str) {
    }

    /* renamed from: i */
    public static void m1698i(String str, Throwable th) {
    }

    /* renamed from: v */
    public static void m1699v(String str) {
    }

    /* renamed from: v */
    public static void m1700v(String str, Throwable th) {
    }

    /* renamed from: w */
    public static void m1701w(String str) {
    }

    /* renamed from: w */
    public static void m1702w(String str, Throwable th) {
    }

    private static String generateTag() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String format = String.format(Locale.CHINA, "%s.%s(L:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
        return TextUtils.isEmpty("NewbieGuide") ? format : "NewbieGuide:" + format;
    }

    public static String printMethodCaller() {
        try {
            StringBuilder sb = new StringBuilder();
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                if (i != 0) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    sb.append("\n" + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "() line:" + stackTraceElement.getLineNumber());
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return "null";
        }
    }
}