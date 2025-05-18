package com.ipotensic.kernel.activitys;

import android.os.Bundle;

/* loaded from: classes2.dex */
public class PhotoViewerLandActivity extends PhotoViewerActivity {
    @Override // com.ipotensic.kernel.activitys.PhotoViewerActivity, com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.layoutTop.setPadding(0, 0, 0, 0);
        this.layoutBottom.setPadding(0, 0, 0, 0);
    }
}