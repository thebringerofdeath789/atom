package com.hjq.permissions;

/* loaded from: classes2.dex */
public interface OnPermissionPageCallback {
    default void onDenied() {
    }

    void onGranted();
}
