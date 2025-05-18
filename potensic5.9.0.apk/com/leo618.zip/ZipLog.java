package com.leo618.zip;

import android.util.Log;

/* loaded from: classes2.dex */
final class ZipLog {
    private static boolean DEBUG = false;
    private static final String TAG = "ZipLog";

    ZipLog() {
    }

    static void config(boolean z) {
        DEBUG = z;
    }

    static void debug(String str) {
        if (DEBUG) {
            Log.d(TAG, str);
        }
    }
}