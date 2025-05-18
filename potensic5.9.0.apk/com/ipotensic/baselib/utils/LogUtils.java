package com.ipotensic.baselib.utils;

import android.util.Log;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.ipotensic.baselib.DDLog;

/* loaded from: classes2.dex */
public class LogUtils {
    static String className;
    static int lineNumber;
    static String methodName;

    private LogUtils() {
    }

    private static String createLog(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("BasicLogTag:--->");
        stringBuffer.append(methodName);
        stringBuffer.append("(").append(className).append(":").append(lineNumber).append(")");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private static void getMethodNames(StackTraceElement[] stackTraceElementArr) {
        className = stackTraceElementArr[1].getFileName();
        methodName = stackTraceElementArr[1].getMethodName();
        lineNumber = stackTraceElementArr[1].getLineNumber();
    }

    /* renamed from: e */
    public static void m1715e(String str) {
        getMethodNames(new Throwable().getStackTrace());
        int length = str.length();
        if (length < 2500) {
            DDLog.m1685e(className, createLog("1-1:" + str));
            return;
        }
        int i = (length / DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS) + 1;
        int i2 = 0;
        while (i2 < i) {
            String str2 = className;
            int i3 = i2 + 1;
            StringBuilder append = new StringBuilder().append(i).append("-").append(i3).append(":");
            int i4 = i2 * DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
            DDLog.m1685e(str2, createLog(append.append(str.substring(i4, Math.min(i4 + DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, length))).toString()));
            i2 = i3;
        }
    }

    /* renamed from: i */
    public static void m1716i(String str) {
        getMethodNames(new Throwable().getStackTrace());
        int length = str.length();
        if (length < 2500) {
            Log.i(className, createLog("1-1:" + str));
            return;
        }
        int i = (length / DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS) + 1;
        int i2 = 0;
        while (i2 < i) {
            String str2 = className;
            int i3 = i2 + 1;
            StringBuilder append = new StringBuilder().append(i).append("-").append(i3).append(":");
            int i4 = i2 * DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
            Log.i(str2, createLog(append.append(str.substring(i4, Math.min(i4 + DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, length))).toString()));
            i2 = i3;
        }
    }

    /* renamed from: d */
    public static void m1714d(String str) {
        getMethodNames(new Throwable().getStackTrace());
        int length = str.length();
        if (length < 2500) {
            Log.d(className, createLog("1-1:" + str));
            return;
        }
        int i = (length / DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS) + 1;
        int i2 = 0;
        while (i2 < i) {
            String str2 = className;
            int i3 = i2 + 1;
            StringBuilder append = new StringBuilder().append(i).append("-").append(i3).append(":");
            int i4 = i2 * DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
            Log.d(str2, createLog(append.append(str.substring(i4, Math.min(i4 + DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, length))).toString()));
            i2 = i3;
        }
    }

    /* renamed from: v */
    public static void m1717v(String str) {
        getMethodNames(new Throwable().getStackTrace());
        int length = str.length();
        if (length < 2500) {
            Log.v(className, createLog("1-1:" + str));
            return;
        }
        int i = (length / DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS) + 1;
        int i2 = 0;
        while (i2 < i) {
            String str2 = className;
            int i3 = i2 + 1;
            StringBuilder append = new StringBuilder().append(i).append("-").append(i3).append(":");
            int i4 = i2 * DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
            Log.v(str2, createLog(append.append(str.substring(i4, Math.min(i4 + DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, length))).toString()));
            i2 = i3;
        }
    }

    /* renamed from: w */
    public static void m1718w(String str) {
        getMethodNames(new Throwable().getStackTrace());
        int length = str.length();
        if (length < 2500) {
            Log.w(className, createLog("1-1:" + str));
            return;
        }
        int i = (length / DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS) + 1;
        int i2 = 0;
        while (i2 < i) {
            String str2 = className;
            int i3 = i2 + 1;
            StringBuilder append = new StringBuilder().append(i).append("-").append(i3).append(":");
            int i4 = i2 * DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
            Log.w(str2, createLog(append.append(str.substring(i4, Math.min(i4 + DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, length))).toString()));
            i2 = i3;
        }
    }

    public static void wtf(String str) {
        getMethodNames(new Throwable().getStackTrace());
        int length = str.length();
        if (length < 2500) {
            Log.wtf(className, createLog("1-1:" + str));
            return;
        }
        int i = (length / DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS) + 1;
        int i2 = 0;
        while (i2 < i) {
            String str2 = className;
            int i3 = i2 + 1;
            StringBuilder append = new StringBuilder().append(i).append("-").append(i3).append(":");
            int i4 = i2 * DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
            Log.wtf(str2, createLog(append.append(str.substring(i4, Math.min(i4 + DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, length))).toString()));
            i2 = i3;
        }
    }
}