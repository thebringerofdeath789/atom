package com.hjq.permissions;

import android.content.Context;
import android.os.Build;

/* loaded from: classes2.dex */
final class AndroidVersion {
    static final int ANDROID_10 = 29;
    static final int ANDROID_11 = 30;
    static final int ANDROID_12 = 31;
    static final int ANDROID_12_L = 32;
    static final int ANDROID_13 = 33;
    static final int ANDROID_4_0 = 14;
    static final int ANDROID_4_1 = 16;
    static final int ANDROID_4_2 = 17;
    static final int ANDROID_4_3 = 18;
    static final int ANDROID_4_4 = 19;
    static final int ANDROID_5 = 21;
    static final int ANDROID_5_1 = 22;
    static final int ANDROID_6 = 23;
    static final int ANDROID_7 = 24;
    static final int ANDROID_7_1 = 25;
    static final int ANDROID_8 = 26;
    static final int ANDROID_8_1 = 27;
    static final int ANDROID_9 = 28;

    AndroidVersion() {
    }

    static int getAndroidVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    static int getTargetSdkVersionCode(Context context) {
        return context.getApplicationInfo().targetSdkVersion;
    }

    static boolean isAndroid13() {
        return Build.VERSION.SDK_INT >= 33;
    }

    static boolean isAndroid12() {
        return Build.VERSION.SDK_INT >= 31;
    }

    static boolean isAndroid11() {
        return Build.VERSION.SDK_INT >= 30;
    }

    static boolean isAndroid10() {
        return Build.VERSION.SDK_INT >= 29;
    }

    static boolean isAndroid9() {
        return Build.VERSION.SDK_INT >= 28;
    }

    static boolean isAndroid8() {
        return Build.VERSION.SDK_INT >= 26;
    }

    static boolean isAndroid7_1() {
        return Build.VERSION.SDK_INT >= 25;
    }

    static boolean isAndroid7() {
        return Build.VERSION.SDK_INT >= 24;
    }

    static boolean isAndroid6() {
        return Build.VERSION.SDK_INT >= 23;
    }

    static boolean isAndroid5_1() {
        return Build.VERSION.SDK_INT >= 22;
    }

    static boolean isAndroid5() {
        return Build.VERSION.SDK_INT >= 21;
    }

    static boolean isAndroid4_4() {
        return Build.VERSION.SDK_INT >= 19;
    }

    static boolean isAndroid4_3() {
        return Build.VERSION.SDK_INT >= 18;
    }

    static boolean isAndroid4_2() {
        return Build.VERSION.SDK_INT >= 17;
    }

    static boolean isAndroid4() {
        return Build.VERSION.SDK_INT >= 14;
    }
}
