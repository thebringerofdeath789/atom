package com.ipotensic.baselib.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.graphics.Point;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.ipotensic.baselib.configs.PhoneConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class CommonUtil {
    public static String getAppVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAppName() {
        try {
            return String.valueOf(PhoneConfig.applicationContext.getPackageManager().getApplicationLabel(PhoneConfig.applicationContext.getApplicationInfo()));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getAppVersion() {
        return TextUtils.isEmpty("V6.9.0") ? "" : "6.9.0";
    }

    public static String getFileProviderAuthority(Context context) {
        try {
            ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
            if (providerInfoArr.length > 0) {
                return providerInfoArr[0].authority;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeAndroidPDialog() {
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void toSystemWifiSetting(Context context) {
        try {
            try {
                try {
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.net.wifi.PICK_WIFI_NETWORK");
                        context.startActivity(intent);
                    } catch (Exception unused) {
                        context.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                    }
                } catch (Exception unused2) {
                    Intent intent2 = new Intent();
                    if (Build.VERSION.SDK_INT >= 11) {
                        intent2.setClassName("com.android.settings", "com.android.settings.Settings$WifiSettingsActivity");
                    } else {
                        intent2.setClassName("com.android.settings", "com.android.settings.wifi.WifiSettings");
                    }
                    context.startActivity(intent2);
                }
            } catch (Exception unused3) {
            }
        } catch (Exception unused4) {
            context.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        }
    }

    public static boolean hasNewVersion(String str, String str2) {
        if (str == null) {
            return false;
        }
        try {
            String[] split = str.replace("V", "").replace("v", "").split("\\.");
            String[] split2 = str2.replace("V", "").replace("v", "").split("\\.");
            for (int i = 0; i < split2.length && Integer.parseInt(split[i]) <= Integer.parseInt(split2[i]); i++) {
                if (Integer.parseInt(split[i]) < Integer.parseInt(split2[i])) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean hasLowestVersion(String str, String str2) {
        try {
            String[] split = str.replace("V", "").replace("v", "").split("\\.");
            String[] split2 = str2.replace("V", "").replace("v", "").split("\\.");
            for (int i = 0; i < split2.length; i++) {
                if (Integer.parseInt(split[i]) > Integer.parseInt(split2[i])) {
                    return false;
                }
                if (Integer.parseInt(split[i]) < Integer.parseInt(split2[i])) {
                    return true;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long getSDFreeSize() {
        return (new StatFs(Environment.getExternalStorageDirectory().getPath()).getFreeBytes() / 1024) / 1024;
    }

    public static int getDistanceOfTwoPoint(Point point, Point point2) {
        int abs = Math.abs(point.x - point2.x);
        int abs2 = Math.abs(point.y - point2.y);
        return (int) Math.sqrt((abs * abs) + (abs2 * abs2));
    }
}