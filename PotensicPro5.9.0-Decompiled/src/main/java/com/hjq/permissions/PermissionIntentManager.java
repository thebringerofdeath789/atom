package com.hjq.permissions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes2.dex */
final class PermissionIntentManager {
    private static final String COLOR_OS_SAFE_CENTER_APP_PACKAGE_NAME_1 = "com.oppo.safe";
    private static final String COLOR_OS_SAFE_CENTER_APP_PACKAGE_NAME_2 = "com.color.safecenter";
    private static final String COLOR_OS_SAFE_CENTER_APP_PACKAGE_NAME_3 = "com.oplus.safecenter";
    private static final String EMUI_MOBILE_MANAGER_APP_PACKAGE_NAME = "com.huawei.systemmanager";
    private static final String MIUI_MOBILE_MANAGER_APP_PACKAGE_NAME = "com.miui.securitycenter";
    private static final String ORIGIN_OS_MOBILE_MANAGER_APP_PACKAGE_NAME = "com.iqoo.secure";

    PermissionIntentManager() {
    }

    static Intent getEmuiWindowPermissionPageIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName(EMUI_MOBILE_MANAGER_APP_PACKAGE_NAME, "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        Intent intent2 = new Intent();
        intent2.setClassName(EMUI_MOBILE_MANAGER_APP_PACKAGE_NAME, "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
        Intent huaWeiMobileManagerAppIntent = getHuaWeiMobileManagerAppIntent(context);
        String romVersionName = PhoneRomUtils.getRomVersionName();
        if (romVersionName == null) {
            romVersionName = "";
        }
        if (romVersionName.startsWith("3.0")) {
            if (!PermissionUtils.areActivityIntent(context, intent2)) {
                intent2 = null;
            }
            if (PermissionUtils.areActivityIntent(context, intent)) {
                intent2 = StartActivityManager.addSubIntentToMainIntent(intent2, intent);
            }
        } else {
            if (!PermissionUtils.areActivityIntent(context, intent)) {
                intent = null;
            }
            intent2 = PermissionUtils.areActivityIntent(context, intent2) ? StartActivityManager.addSubIntentToMainIntent(intent, intent2) : intent;
        }
        return PermissionUtils.areActivityIntent(context, huaWeiMobileManagerAppIntent) ? StartActivityManager.addSubIntentToMainIntent(intent2, huaWeiMobileManagerAppIntent) : intent2;
    }

    static Intent getMiuiWindowPermissionPageIntent(Context context) {
        return getMiuiPermissionPageIntent(context);
    }

    static Intent getColorOsWindowPermissionPageIntent(Context context) {
        Intent intent = new Intent("com.oppo.safe.permission.PermissionTopActivity");
        Intent oppoSafeCenterAppIntent = getOppoSafeCenterAppIntent(context);
        if (!PermissionUtils.areActivityIntent(context, intent)) {
            intent = null;
        }
        return PermissionUtils.areActivityIntent(context, oppoSafeCenterAppIntent) ? StartActivityManager.addSubIntentToMainIntent(intent, oppoSafeCenterAppIntent) : intent;
    }

    static Intent getOriginOsWindowPermissionPageIntent(Context context) {
        Intent vivoMobileManagerAppIntent = getVivoMobileManagerAppIntent(context);
        if (PermissionUtils.areActivityIntent(context, vivoMobileManagerAppIntent)) {
            return vivoMobileManagerAppIntent;
        }
        return null;
    }

    static Intent getOneUiWindowPermissionPageIntent(Context context) {
        return getOneUiPermissionPageIntent(context);
    }

    static Intent getMiuiPermissionPageIntent(Context context) {
        Intent putExtra = new Intent().setAction("miui.intent.action.APP_PERM_EDITOR").putExtra("extra_pkgname", context.getPackageName());
        Intent xiaoMiMobileManagerAppIntent = getXiaoMiMobileManagerAppIntent(context);
        if (!PermissionUtils.areActivityIntent(context, putExtra)) {
            putExtra = null;
        }
        return PermissionUtils.areActivityIntent(context, xiaoMiMobileManagerAppIntent) ? StartActivityManager.addSubIntentToMainIntent(putExtra, xiaoMiMobileManagerAppIntent) : putExtra;
    }

    static Intent getOriginOsPermissionPageIntent(Context context) {
        Intent intent = new Intent("permission.intent.action.softPermissionDetail");
        intent.putExtra("packagename", context.getPackageName());
        if (PermissionUtils.areActivityIntent(context, intent)) {
            return intent;
        }
        return null;
    }

    static Intent getOneUiPermissionPageIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$AppOpsDetailsActivity");
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        intent.putExtra(":settings:show_fragment_args", bundle);
        intent.setData(PermissionUtils.getPackageNameUri(context));
        if (PermissionUtils.areActivityIntent(context, intent)) {
            return intent;
        }
        return null;
    }

    static Intent getHuaWeiMobileManagerAppIntent(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(EMUI_MOBILE_MANAGER_APP_PACKAGE_NAME);
        if (PermissionUtils.areActivityIntent(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    static Intent getXiaoMiMobileManagerAppIntent(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(MIUI_MOBILE_MANAGER_APP_PACKAGE_NAME);
        if (PermissionUtils.areActivityIntent(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    static Intent getOppoSafeCenterAppIntent(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(COLOR_OS_SAFE_CENTER_APP_PACKAGE_NAME_1);
        if (PermissionUtils.areActivityIntent(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        Intent launchIntentForPackage2 = context.getPackageManager().getLaunchIntentForPackage(COLOR_OS_SAFE_CENTER_APP_PACKAGE_NAME_2);
        if (PermissionUtils.areActivityIntent(context, launchIntentForPackage2)) {
            return launchIntentForPackage2;
        }
        Intent launchIntentForPackage3 = context.getPackageManager().getLaunchIntentForPackage(COLOR_OS_SAFE_CENTER_APP_PACKAGE_NAME_3);
        if (PermissionUtils.areActivityIntent(context, launchIntentForPackage3)) {
            return launchIntentForPackage3;
        }
        return null;
    }

    static Intent getVivoMobileManagerAppIntent(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(ORIGIN_OS_MOBILE_MANAGER_APP_PACKAGE_NAME);
        if (PermissionUtils.areActivityIntent(context, launchIntentForPackage)) {
            return launchIntentForPackage;
        }
        return null;
    }

    static Intent getApplicationDetailsIntent(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(PermissionUtils.getPackageNameUri(context));
        if (PermissionUtils.areActivityIntent(context, intent)) {
            return intent;
        }
        Intent intent2 = new Intent("android.settings.APPLICATION_SETTINGS");
        if (PermissionUtils.areActivityIntent(context, intent2)) {
            return intent2;
        }
        Intent intent3 = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
        return PermissionUtils.areActivityIntent(context, intent3) ? intent3 : getAndroidSettingAppIntent();
    }

    static Intent getAndroidSettingAppIntent() {
        return new Intent("android.settings.SETTINGS");
    }
}
