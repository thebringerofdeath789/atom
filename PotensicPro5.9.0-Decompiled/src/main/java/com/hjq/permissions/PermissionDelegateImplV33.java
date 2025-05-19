package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
class PermissionDelegateImplV33 extends PermissionDelegateImplV31 {
    PermissionDelegateImplV33() {
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV31, com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.BODY_SENSORS_BACKGROUND)) {
            return PermissionUtils.checkSelfPermission(context, Permission.BODY_SENSORS) && PermissionUtils.checkSelfPermission(context, Permission.BODY_SENSORS_BACKGROUND);
        }
        if (PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS) || PermissionUtils.equalsPermission(str, Permission.NEARBY_WIFI_DEVICES) || PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_IMAGES) || PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_VIDEO) || PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_AUDIO)) {
            return PermissionUtils.checkSelfPermission(context, str);
        }
        if (AndroidVersion.getTargetSdkVersionCode(context) >= 33) {
            if (PermissionUtils.equalsPermission(str, Permission.WRITE_EXTERNAL_STORAGE)) {
                return true;
            }
            if (PermissionUtils.equalsPermission(str, Permission.READ_EXTERNAL_STORAGE)) {
                return PermissionUtils.checkSelfPermission(context, Permission.READ_MEDIA_IMAGES) && PermissionUtils.checkSelfPermission(context, Permission.READ_MEDIA_VIDEO) && PermissionUtils.checkSelfPermission(context, Permission.READ_MEDIA_AUDIO);
            }
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV31, com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isPermissionPermanentDenied(Activity activity, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.BODY_SENSORS_BACKGROUND)) {
            if (PermissionUtils.checkSelfPermission(activity, Permission.BODY_SENSORS)) {
                return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
            }
            return !PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.BODY_SENSORS);
        }
        if (PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS) || PermissionUtils.equalsPermission(str, Permission.NEARBY_WIFI_DEVICES) || PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_IMAGES) || PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_VIDEO) || PermissionUtils.equalsPermission(str, Permission.READ_MEDIA_AUDIO)) {
            return (PermissionUtils.checkSelfPermission(activity, str) || PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        if (AndroidVersion.getTargetSdkVersionCode(activity) >= 33) {
            if (PermissionUtils.equalsPermission(str, Permission.WRITE_EXTERNAL_STORAGE)) {
                return false;
            }
            if (PermissionUtils.equalsPermission(str, Permission.READ_EXTERNAL_STORAGE)) {
                return (PermissionUtils.checkSelfPermission(activity, Permission.READ_MEDIA_IMAGES) || PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.READ_MEDIA_IMAGES) || PermissionUtils.checkSelfPermission(activity, Permission.READ_MEDIA_VIDEO) || PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.READ_MEDIA_VIDEO) || PermissionUtils.checkSelfPermission(activity, Permission.READ_MEDIA_AUDIO) || PermissionUtils.shouldShowRequestPermissionRationale(activity, Permission.READ_MEDIA_AUDIO)) ? false : true;
            }
        }
        return super.isPermissionPermanentDenied(activity, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV31, com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public Intent getPermissionIntent(Context context, String str) {
        if (PermissionUtils.equalsPermission(str, Permission.POST_NOTIFICATIONS)) {
            return NotificationPermissionCompat.getPermissionIntent(context);
        }
        return super.getPermissionIntent(context, str);
    }
}
