package com.hjq.permissions;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

/* loaded from: classes2.dex */
final class WindowPermissionCompat {
    private static final int OP_SYSTEM_ALERT_WINDOW_DEFAULT_VALUE = 24;
    private static final String OP_SYSTEM_ALERT_WINDOW_FIELD_NAME = "OP_SYSTEM_ALERT_WINDOW";

    WindowPermissionCompat() {
    }

    static boolean isGrantedPermission(Context context) {
        if (AndroidVersion.isAndroid6()) {
            return Settings.canDrawOverlays(context);
        }
        if (AndroidVersion.isAndroid4_4()) {
            return PermissionUtils.checkOpNoThrow(context, OP_SYSTEM_ALERT_WINDOW_FIELD_NAME, 24);
        }
        return true;
    }

    static Intent getPermissionIntent(Context context) {
        if (AndroidVersion.isAndroid6()) {
            if (AndroidVersion.isAndroid11() && PhoneRomUtils.isMiui() && PhoneRomUtils.isMiuiOptimization()) {
                return StartActivityManager.addSubIntentToMainIntent(PermissionIntentManager.getMiuiPermissionPageIntent(context), PermissionIntentManager.getApplicationDetailsIntent(context));
            }
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(PermissionUtils.getPackageNameUri(context));
            return PermissionUtils.areActivityIntent(context, intent) ? intent : PermissionIntentManager.getApplicationDetailsIntent(context);
        }
        if (PhoneRomUtils.isEmui()) {
            return StartActivityManager.addSubIntentToMainIntent(PermissionIntentManager.getEmuiWindowPermissionPageIntent(context), PermissionIntentManager.getApplicationDetailsIntent(context));
        }
        if (PhoneRomUtils.isMiui()) {
            return StartActivityManager.addSubIntentToMainIntent(PhoneRomUtils.isMiuiOptimization() ? PermissionIntentManager.getMiuiWindowPermissionPageIntent(context) : null, PermissionIntentManager.getApplicationDetailsIntent(context));
        }
        if (PhoneRomUtils.isColorOs()) {
            return StartActivityManager.addSubIntentToMainIntent(PermissionIntentManager.getColorOsWindowPermissionPageIntent(context), PermissionIntentManager.getApplicationDetailsIntent(context));
        }
        if (PhoneRomUtils.isOriginOs()) {
            return StartActivityManager.addSubIntentToMainIntent(PermissionIntentManager.getOriginOsWindowPermissionPageIntent(context), PermissionIntentManager.getApplicationDetailsIntent(context));
        }
        if (PhoneRomUtils.isOneUi()) {
            return StartActivityManager.addSubIntentToMainIntent(PermissionIntentManager.getOneUiWindowPermissionPageIntent(context), PermissionIntentManager.getApplicationDetailsIntent(context));
        }
        return PermissionIntentManager.getApplicationDetailsIntent(context);
    }
}
