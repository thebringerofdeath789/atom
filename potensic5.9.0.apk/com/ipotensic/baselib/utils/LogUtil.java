package com.ipotensic.baselib.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* loaded from: classes2.dex */
public class LogUtil {
    public static String customTagPrefix = "x_log";
    public static boolean isDebug = false;

    private LogUtil() {
    }

    private static String generateTag() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        String className = stackTraceElement.getClassName();
        String format = String.format(Locale.getDefault(), "%s.%s(L:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
        return TextUtils.isEmpty(customTagPrefix) ? format : customTagPrefix + ":" + format;
    }

    /* renamed from: d */
    public static void m1703d(String str) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.d(generateTag(), str);
    }

    /* renamed from: d */
    public static void m1704d(String str, Throwable th) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.d(generateTag(), str, th);
    }

    /* renamed from: e */
    public static void m1705e(String str) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(generateTag(), str);
    }

    /* renamed from: e */
    public static void m1706e(String str, Throwable th) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(generateTag(), str, th);
    }

    /* renamed from: i */
    public static void m1707i(String str) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i(generateTag(), str);
    }

    /* renamed from: i */
    public static void m1708i(String str, Throwable th) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i(generateTag(), str, th);
    }

    /* renamed from: v */
    public static void m1709v(String str) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.v(generateTag(), str);
    }

    /* renamed from: v */
    public static void m1710v(String str, Throwable th) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.v(generateTag(), str, th);
    }

    /* renamed from: w */
    public static void m1711w(String str) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w(generateTag(), str);
    }

    /* renamed from: w */
    public static void m1712w(String str, Throwable th) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w(generateTag(), str, th);
    }

    /* renamed from: w */
    public static void m1713w(Throwable th) {
        if (isDebug) {
            return;
        }
        Log.w(generateTag(), th);
    }

    public static void wtf(String str) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.wtf(generateTag(), str);
    }

    public static void wtf(String str, Throwable th) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.wtf(generateTag(), str, th);
    }

    public static void wtf(Throwable th) {
        if (isDebug) {
            return;
        }
        Log.wtf(generateTag(), th);
    }
}