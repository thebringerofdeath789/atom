package com.baidu.lbsapi.auth;

import android.util.Log;

/* compiled from: BLog.java */
/* renamed from: com.baidu.lbsapi.auth.b */
/* loaded from: classes.dex */
class C0621b {

    /* renamed from: a */
    public static boolean f226a = false;

    /* renamed from: b */
    private static String f227b = "BaiduApiAuth";

    /* renamed from: a */
    public static void m177a(String str) {
        if (!f226a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.d(f227b, m176a() + ";" + str);
    }

    /* renamed from: b */
    public static void m178b(String str) {
        if (Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.i(f227b, str);
    }

    /* renamed from: c */
    public static void m179c(String str) {
        if (!f226a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.e(f227b, m176a() + ";" + str);
    }

    /* renamed from: a */
    public static String m176a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + "[" + stackTraceElement.getLineNumber() + "]";
    }
}