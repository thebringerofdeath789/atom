package com.danikula.videocache;

import android.util.Log;

/* loaded from: classes.dex */
public final class Logger {
    private static boolean IS_DEBUG = false;
    private static final String TAG = "VideoCache";

    public static void setDebug(boolean z) {
        IS_DEBUG = z;
    }

    public static void debug(String str) {
        if (IS_DEBUG) {
            Log.d(TAG, str);
        }
    }

    public static void info(String str) {
        if (IS_DEBUG) {
            Log.i(TAG, str);
        }
    }

    public static void warn(String str) {
        if (IS_DEBUG) {
            Log.w(TAG, str);
        }
    }

    public static void error(String str) {
        if (IS_DEBUG) {
            Log.e(TAG, str);
        }
    }
}