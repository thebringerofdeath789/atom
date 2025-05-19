package xyz.doikki.videoplayer.util;

import android.util.Log;
import xyz.doikki.videoplayer.player.VideoViewManager;

/* loaded from: classes6.dex */
public final class L {
    private static final String TAG = "DKPlayer";
    private static boolean isDebug = VideoViewManager.getConfig().mIsEnableLog;

    private L() {
    }

    public static void d(String str) {
        if (isDebug) {
            Log.d(TAG, str);
        }
    }

    public static void e(String str) {
        if (isDebug) {
            Log.e(TAG, str);
        }
    }

    public static void i(String str) {
        if (isDebug) {
            Log.i(TAG, str);
        }
    }

    public static void w(String str) {
        if (isDebug) {
            Log.w(TAG, str);
        }
    }

    public static void setDebug(boolean z) {
        isDebug = z;
    }
}
