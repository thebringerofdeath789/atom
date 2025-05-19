package com.logan.nativeapp;

import android.util.Log;

/* loaded from: classes3.dex */
public class DDLog {
    private static final String DEFAULT_TAG = "------DDLog------";
    private static boolean isDebug = false;
    private static boolean isShowDetail = true;

    public static void setDebug(boolean z) {
        isDebug = z;
    }

    public static void showDetail(boolean z) {
        isShowDetail = z;
    }

    public static void v(String str, String str2) {
        if (isDebug) {
            Log.v(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (isDebug) {
            Log.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (isDebug) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (isDebug) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (isDebug) {
            Log.e(str, str2);
        }
    }

    public static void v(String str) {
        if (isDebug) {
            Log.v(DEFAULT_TAG, str);
        }
    }

    public static void d(String str) {
        if (isDebug) {
            Log.d(DEFAULT_TAG, str);
        }
    }

    public static void i(String str) {
        if (isDebug) {
            Log.i(DEFAULT_TAG, str);
        }
    }

    public static void w(String str) {
        if (isDebug) {
            Log.w(DEFAULT_TAG, str);
        }
    }

    public static void e(String str) {
        if (isDebug) {
            Log.e(DEFAULT_TAG, str);
        }
    }
}
