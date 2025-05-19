package com.mapbox.android.core.permissions;

import java.util.List;

/* loaded from: classes3.dex */
public interface PermissionsListener {
    void onExplanationNeeded(List<String> list);

    void onPermissionResult(boolean z);
}
