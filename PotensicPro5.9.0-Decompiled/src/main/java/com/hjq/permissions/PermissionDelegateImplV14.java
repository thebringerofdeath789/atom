package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;

/* loaded from: classes2.dex */
class PermissionDelegateImplV14 implements PermissionDelegate {
    @Override // com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(Activity activity, String str) {
        return false;
    }

    PermissionDelegateImplV14() {
    }

    @Override // com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.BIND_VPN_SERVICE)) {
            return isGrantedVpnPermission(context);
        }
        return true;
    }

    @Override // com.hjq.permissions.PermissionDelegate
    public Intent getPermissionIntent(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.BIND_VPN_SERVICE)) {
            return getVpnPermissionIntent(context);
        }
        return PermissionIntentManager.getApplicationDetailsIntent(context);
    }

    private static boolean isGrantedVpnPermission(Context context) {
        return VpnService.prepare(context) == null;
    }

    private static Intent getVpnPermissionIntent(Context context) {
        Intent prepare = VpnService.prepare(context);
        return !PermissionUtils.areActivityIntent(context, prepare) ? PermissionIntentManager.getApplicationDetailsIntent(context) : prepare;
    }
}
