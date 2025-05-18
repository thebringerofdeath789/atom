package com.hjq.permissions;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public interface IPermissionInterceptor {
    default void finishPermissionRequest(Activity activity, List<String> list, boolean z, OnPermissionCallback onPermissionCallback) {
    }

    default void launchPermissionRequest(Activity activity, List<String> list, OnPermissionCallback onPermissionCallback) {
        PermissionFragment.launch(activity, new ArrayList(list), this, onPermissionCallback);
    }

    default void grantedPermissionRequest(Activity activity, List<String> list, List<String> list2, boolean z, OnPermissionCallback onPermissionCallback) {
        if (onPermissionCallback == null) {
            return;
        }
        onPermissionCallback.onGranted(list2, z);
    }

    default void deniedPermissionRequest(Activity activity, List<String> list, List<String> list2, boolean z, OnPermissionCallback onPermissionCallback) {
        if (onPermissionCallback == null) {
            return;
        }
        onPermissionCallback.onDenied(list2, z);
    }
}