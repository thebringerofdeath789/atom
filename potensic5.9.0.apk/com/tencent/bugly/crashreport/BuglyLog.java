package com.tencent.bugly.crashreport;

import android.util.Log;
import com.tencent.bugly.C3329b;
import com.tencent.bugly.proguard.C3402y;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class BuglyLog {
    /* renamed from: v */
    public static void m1810v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C3329b.f2869c) {
            Log.v(str, str2);
        }
        C3402y.m2257a("V", str, str2);
    }

    /* renamed from: d */
    public static void m1806d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C3329b.f2869c) {
            Log.d(str, str2);
        }
        C3402y.m2257a("D", str, str2);
    }

    /* renamed from: i */
    public static void m1809i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C3329b.f2869c) {
            Log.i(str, str2);
        }
        C3402y.m2257a("I", str, str2);
    }

    /* renamed from: w */
    public static void m1811w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C3329b.f2869c) {
            Log.w(str, str2);
        }
        C3402y.m2257a("W", str, str2);
    }

    /* renamed from: e */
    public static void m1807e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C3329b.f2869c) {
            Log.e(str, str2);
        }
        C3402y.m2257a("E", str, str2);
    }

    /* renamed from: e */
    public static void m1808e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (C3329b.f2869c) {
            Log.e(str, str2, th);
        }
        C3402y.m2258a("E", str, th);
    }

    public static void setCache(int i) {
        C3402y.m2255a(i);
    }
}