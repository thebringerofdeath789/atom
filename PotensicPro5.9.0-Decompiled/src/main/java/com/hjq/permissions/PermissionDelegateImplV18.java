package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
class PermissionDelegateImplV18 extends PermissionDelegateImplV14 {
    PermissionDelegateImplV18() {
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.BIND_NOTIFICATION_LISTENER_SERVICE)) {
            return NotificationListenerPermissionCompat.isGrantedPermission(context);
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(Activity activity, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.BIND_NOTIFICATION_LISTENER_SERVICE)) {
            return false;
        }
        return super.isPermissionPermanentDenied(activity, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionIntent(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.BIND_NOTIFICATION_LISTENER_SERVICE)) {
            return NotificationListenerPermissionCompat.getPermissionIntent(context);
        }
        return super.getPermissionIntent(context, str);
    }
}
