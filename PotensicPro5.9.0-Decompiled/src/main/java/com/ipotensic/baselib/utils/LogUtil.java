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

    public static void d(String str) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.d(generateTag(), str);
    }

    public static void d(String str, Throwable th) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.d(generateTag(), str, th);
    }

    public static void e(String str) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(generateTag(), str);
    }

    public static void e(String str, Throwable th) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(generateTag(), str, th);
    }

    public static void i(String str) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i(generateTag(), str);
    }

    public static void i(String str, Throwable th) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i(generateTag(), str, th);
    }

    public static void v(String str) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.v(generateTag(), str);
    }

    public static void v(String str, Throwable th) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.v(generateTag(), str, th);
    }

    public static void w(String str) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w(generateTag(), str);
    }

    public static void w(String str, Throwable th) {
        if (isDebug || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w(generateTag(), str, th);
    }

    public static void w(Throwable th) {
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
