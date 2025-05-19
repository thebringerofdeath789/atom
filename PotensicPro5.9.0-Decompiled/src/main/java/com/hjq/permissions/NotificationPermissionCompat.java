package com.hjq.permissions;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
final class NotificationPermissionCompat {
    private static final int OP_POST_NOTIFICATION_DEFAULT_VALUE = 11;
    private static final String OP_POST_NOTIFICATION_FIELD_NAME = "OP_POST_NOTIFICATION";

    NotificationPermissionCompat() {
    }

    static boolean isGrantedPermission(Context context) {
        if (AndroidVersion.isAndroid7()) {
            return ((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled();
        }
        if (AndroidVersion.isAndroid4_4()) {
            return PermissionUtils.checkOpNoThrow(context, OP_POST_NOTIFICATION_FIELD_NAME, 11);
        }
        return true;
    }

    static Intent getPermissionIntent(Context context) {
        Intent intent;
        if (AndroidVersion.isAndroid8()) {
            intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        } else if (AndroidVersion.isAndroid5()) {
            intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", context.getPackageName());
            intent.putExtra("app_uid", context.getApplicationInfo().uid);
        } else {
            intent = null;
        }
        return !PermissionUtils.areActivityIntent(context, intent) ? PermissionIntentManager.getApplicationDetailsIntent(context) : intent;
    }
}
