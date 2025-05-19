package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes2.dex */
class PermissionDelegateImplV28 extends PermissionDelegateImplV26 {
    PermissionDelegateImplV28() {
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.ACCEPT_HANDOVER)) {
            return PermissionUtils.checkSelfPermission(context, str);
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(Activity activity, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.ACCEPT_HANDOVER)) {
            return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        return super.isPermissionPermanentDenied(activity, str);
    }
}
