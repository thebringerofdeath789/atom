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

    /* renamed from: v */
    public static void m1729v(String str, String str2) {
        if (isDebug) {
            Log.v(str, str2);
        }
    }

    /* renamed from: d */
    public static void m1723d(String str, String str2) {
        if (isDebug) {
            Log.d(str, str2);
        }
    }

    /* renamed from: i */
    public static void m1727i(String str, String str2) {
        if (isDebug) {
            Log.i(str, str2);
        }
    }

    /* renamed from: w */
    public static void m1731w(String str, String str2) {
        if (isDebug) {
            Log.w(str, str2);
        }
    }

    /* renamed from: e */
    public static void m1725e(String str, String str2) {
        if (isDebug) {
            Log.e(str, str2);
        }
    }

    /* renamed from: v */
    public static void m1728v(String str) {
        if (isDebug) {
            Log.v(DEFAULT_TAG, str);
        }
    }

    /* renamed from: d */
    public static void m1722d(String str) {
        if (isDebug) {
            Log.d(DEFAULT_TAG, str);
        }
    }

    /* renamed from: i */
    public static void m1726i(String str) {
        if (isDebug) {
            Log.i(DEFAULT_TAG, str);
        }
    }

    /* renamed from: w */
    public static void m1730w(String str) {
        if (isDebug) {
            Log.w(DEFAULT_TAG, str);
        }
    }

    /* renamed from: e */
    public static void m1724e(String str) {
        if (isDebug) {
            Log.e(DEFAULT_TAG, str);
        }
    }
}