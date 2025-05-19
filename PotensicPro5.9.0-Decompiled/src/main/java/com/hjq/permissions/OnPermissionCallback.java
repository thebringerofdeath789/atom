package com.hjq.permissions;

import java.util.List;

/* loaded from: classes2.dex */
public interface OnPermissionCallback {
    default void onDenied(List<String> list, boolean z) {
    }

    void onGranted(List<String> list, boolean z);
}
