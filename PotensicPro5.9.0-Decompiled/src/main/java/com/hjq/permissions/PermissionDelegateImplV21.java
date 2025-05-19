package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
class PermissionDelegateImplV21 extends PermissionDelegateImplV19 {
    PermissionDelegateImplV21() {
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.PACKAGE_USAGE_STATS)) {
            return isGrantedPackagePermission(context);
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(Activity activity, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.PACKAGE_USAGE_STATS)) {
            return false;
        }
        return super.isPermissionPermanentDenied(activity, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionIntent(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.PACKAGE_USAGE_STATS)) {
            return getPackagePermissionIntent(context);
        }
        return super.getPermissionIntent(context, str);
    }

    private static boolean isGrantedPackagePermission(Context context) {
        return PermissionUtils.checkOpNoThrow(context, "android:get_usage_stats");
    }

    private static Intent getPackagePermissionIntent(Context context) {
        Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
        if (AndroidVersion.isAndroid10()) {
            intent.setData(PermissionUtils.getPackageNameUri(context));
        }
        return !PermissionUtils.areActivityIntent(context, intent) ? PermissionIntentManager.getApplicationDetailsIntent(context) : intent;
    }
}
