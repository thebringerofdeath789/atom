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

    public static void e(String str) {
        getMethodNames(new Throwable().getStackTrace());
        int length = str.length();
        if (length < 2500) {
            DDLog.e(className, createLog("1-1:" + str));
            return;
        }
        int i = (length / DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS) + 1;
        int i2 = 0;
        while (i2 < i) {
            String str2 = className;
            int i3 = i2 + 1;
            StringBuilder append = new StringBuilder().append(i).append("-").append(i3).append(":");
            int i4 = i2 * DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
            DDLog.e(str2, createLog(append.append(str.substring(i4, Math.min(i4 + DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, length))).toString()));
            i2 = i3;
        }
    }

    public static void i(String str) {
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

    public static void d(String str) {
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

    public static void v(String str) {
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

    public static void w(String str) {
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