package com.hjq.permissions;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
class PermissionDelegateImplV31 extends PermissionDelegateImplV30 {
    PermissionDelegateImplV31() {
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.SCHEDULE_EXACT_ALARM)) {
            return isGrantedAlarmPermission(context);
        }
        if (PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_SCAN) || PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_CONNECT) || PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_ADVERTISE)) {
            return PermissionUtils.checkSelfPermission(context, str);
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(Activity activity, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.SCHEDULE_EXACT_ALARM)) {
            return false;
        }
        if (PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_SCAN) || PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_CONNECT) || PermissionUtils.equalsPermission(str, Permission.BLUETOOTH_ADVERTISE)) {
            return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        if (activity.getApplicationInfo().targetSdkVersion < 31 || !PermissionUtils.equalsPermission(str, Permission.ACCESS_BACKGROUND_LOCATION)) {
            return super.isPermissionPermanentDenied(activity, str);
        }
        return (PermissionUtils.checkSelfPermission(activity, Permission.ACCESS_FINE_LOCATION) || PermissionUtils.checkSelfPermission(activity, Permission.ACCESS_COARSE_LOCATION)) ? (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true : (PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.ACCESS_FINE_LOCATION) || PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.ACCESS_COARSE_LOCATION)) ? false : true;
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionIntent(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.SCHEDULE_EXACT_ALARM)) {
            return getAlarmPermissionIntent(context);
        }
        return super.getPermissionIntent(context, str);
    }

    private static boolean isGrantedAlarmPermission(Context context) {
        return ((AlarmManager) context.getSystemService(AlarmManager.class)).canScheduleExactAlarms();
    }

    private static Intent getAlarmPermissionIntent(Context context) {
        Intent intent = new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
        intent.setData(PermissionUtils.getPackageNameUri(context));
        return !PermissionUtils.areActivityIntent(context, intent) ? PermissionIntentManager.getApplicationDetailsIntent(context) : intent;
    }
}
