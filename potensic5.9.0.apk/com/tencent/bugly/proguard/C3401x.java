package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.x */
/* loaded from: classes3.dex */
public final class C3401x {

    /* renamed from: a */
    public static String f3473a = "CrashReport";

    /* renamed from: b */
    public static boolean f3474b = false;

    /* renamed from: c */
    private static String f3475c = "CrashReportInfo";

    /* renamed from: a */
    private static boolean m2244a(int i, String str, Object... objArr) {
        if (!f3474b) {
            return false;
        }
        if (str == null) {
            str = "null";
        } else if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        if (i == 0) {
            Log.i(f3473a, str);
            return true;
        }
        if (i == 1) {
            Log.d(f3473a, str);
            return true;
        }
        if (i == 2) {
            Log.w(f3473a, str);
            return true;
        }
        if (i == 3) {
            Log.e(f3473a, str);
            return true;
        }
        if (i != 5) {
            return false;
        }
        Log.i(f3475c, str);
        return true;
    }

    /* renamed from: a */
    public static boolean m2246a(String str, Object... objArr) {
        return m2244a(0, str, objArr);
    }

    /* renamed from: a */
    public static boolean m2245a(Class cls, String str, Object... objArr) {
        return m2244a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: b */
    public static boolean m2249b(String str, Object... objArr) {
        return m2244a(5, str, objArr);
    }

    /* renamed from: c */
    public static boolean m2251c(String str, Object... objArr) {
        return m2244a(1, str, objArr);
    }

    /* renamed from: b */
    public static boolean m2248b(Class cls, String str, Object... objArr) {
        return m2244a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: d */
    public static boolean m2252d(String str, Object... objArr) {
        return m2244a(2, str, objArr);
    }

    /* renamed from: a */
    public static boolean m2247a(Throwable th) {
        if (f3474b) {
            return m2244a(2, C3403z.m2282a(th), new Object[0]);
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m2253e(String str, Object... objArr) {
        return m2244a(3, str, objArr);
    }

    /* renamed from: b */
    public static boolean m2250b(Throwable th) {
        if (f3474b) {
            return m2244a(3, C3403z.m2282a(th), new Object[0]);
        }
        return false;
    }
}