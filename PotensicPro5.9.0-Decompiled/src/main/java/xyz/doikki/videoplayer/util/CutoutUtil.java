package xyz.doikki.videoplayer.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.view.WindowManager;

/* loaded from: classes6.dex */
public final class CutoutUtil {
    private CutoutUtil() {
    }

    public static boolean allowDisplayToCutout(Activity activity) {
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT < 28) {
            return hasCutoutHuawei(activity) || hasCutoutOPPO(activity) || hasCutoutVIVO(activity) || hasCutoutXIAOMI(activity);
        }
        WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
        return (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || displayCutout.getBoundingRects().size() <= 0) ? false : true;
    }

    private static boolean hasCutoutHuawei(Activity activity) {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            return false;
        }
        try {
            Class<?> loadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            if (loadClass != null) {
                return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean hasCutoutOPPO(Activity activity) {
        if (Build.MANUFACTURER.equalsIgnoreCase("oppo")) {
            return activity.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        }
        return false;
    }

    private static boolean hasCutoutVIVO(Activity activity) {
        if (!Build.MANUFACTURER.equalsIgnoreCase("vivo")) {
            return false;
        }
        try {
            Class<?> loadClass = activity.getClassLoader().loadClass("android.util.FtFeature");
            if (loadClass != null) {
                return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean hasCutoutXIAOMI(Activity activity) {
        if (!Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
            return false;
        }
        try {
            Class<?> loadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void adaptCutoutAboveAndroidP(Context context, boolean z) {
        Activity scanForActivity = PlayerUtils.scanForActivity(context);
        if (scanForActivity != null && Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = scanForActivity.getWindow().getAttributes();
            if (z) {
                attributes.layoutInDisplayCutoutMode = 1;
            } else {
                attributes.layoutInDisplayCutoutMode = 0;
            }
            scanForActivity.getWindow().setAttributes(attributes);
        }
    }
}
