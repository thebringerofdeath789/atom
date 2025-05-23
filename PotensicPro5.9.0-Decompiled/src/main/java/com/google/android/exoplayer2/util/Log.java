package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes.dex */
public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 2;
    private static int logLevel = 0;
    private static boolean logStackTraces = true;

    private Log() {
    }

    @Pure
    public static int getLogLevel() {
        return logLevel;
    }

    @Pure
    public boolean getLogStackTraces() {
        return logStackTraces;
    }

    public static void setLogLevel(int i) {
        logLevel = i;
    }

    public static void setLogStackTraces(boolean z) {
        logStackTraces = z;
    }

    @Pure
    public static void d(String str, String str2) {
        if (logLevel == 0) {
            android.util.Log.d(str, str2);
        }
    }

    @Pure
    public static void d(String str, String str2, Throwable th) {
        d(str, appendThrowableString(str2, th));
    }

    @Pure
    public static void i(String str, String str2) {
        if (logLevel <= 1) {
            android.util.Log.i(str, str2);
        }
    }

    @Pure
    public static void i(String str, String str2, Throwable th) {
        i(str, appendThrowableString(str2, th));
    }

    @Pure
    public static void w(String str, String str2) {
        if (logLevel <= 2) {
            android.util.Log.w(str, str2);
        }
    }

    @Pure
    public static void w(String str, String str2, Throwable th) {
        w(str, appendThrowableString(str2, th));
    }

    @Pure
    public static void e(String str, String str2) {
        if (logLevel <= 3) {
            android.util.Log.e(str, str2);
        }
    }

    @Pure
    public static void e(String str, String str2, Throwable th) {
        e(str, appendThrowableString(str2, th));
    }

    @Pure
    public static String getThrowableString(Throwable th) {
        if (th == null) {
            return null;
        }
        if (isCausedByUnknownHostException(th)) {
            return "UnknownHostException (no network)";
        }
        if (!logStackTraces) {
            return th.getMessage();
        }
        return android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
    }

    @Pure
    private static String appendThrowableString(String str, Throwable th) {
        String throwableString = getThrowableString(th);
        if (TextUtils.isEmpty(throwableString)) {
            return str;
        }
        String valueOf = String.valueOf(str);
        String replace = throwableString.replace("\n", "\n  ");
        return new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(replace).length()).append(valueOf).append("\n  ").append(replace).append('\n').toString();
    }

    @Pure
    private static boolean isCausedByUnknownHostException(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }
}
