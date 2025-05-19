package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
class PermissionDelegateImplV19 extends PermissionDelegateImplV18 {
    PermissionDelegateImplV19() {
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.SYSTEM_ALERT_WINDOW)) {
            return WindowPermissionCompat.isGrantedPermission(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.GET_INSTALLED_APPS)) {
            return GetInstalledAppsPermissionCompat.isGrantedPermission(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.NOTIFICATION_SERVICE)) {
            return NotificationPermissionCompat.isGrantedPermission(context);
        }
        if (!AndroidVersion.isAndroid13() && PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS)) {
            return NotificationPermissionCompat.isGrantedPermission(context);
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(Activity activity, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.SYSTEM_ALERT_WINDOW)) {
            return false;
        }
        if (PermissionUtils.equalsPermission(str, Permission.GET_INSTALLED_APPS)) {
            return GetInstalledAppsPermissionCompat.isPermissionPermanentDenied(activity);
        }
        if (PermissionUtils.equalsPermission(str, Permission.NOTIFICATION_SERVICE)) {
            return false;
        }
        if (AndroidVersion.isAndroid13() || !PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS)) {
            return super.isPermissionPermanentDenied(activity, str);
        }
        return false;
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionIntent(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.SYSTEM_ALERT_WINDOW)) {
            return WindowPermissionCompat.getPermissionIntent(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.GET_INSTALLED_APPS)) {
            return GetInstalledAppsPermissionCompat.getPermissionIntent(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.NOTIFICATION_SERVICE)) {
            return NotificationPermissionCompat.getPermissionIntent(context);
        }
        if (!AndroidVersion.isAndroid13() && PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS)) {
            return NotificationPermissionCompat.getPermissionIntent(context);
        }
        return super.getPermissionIntent(context, str);
    }
}
