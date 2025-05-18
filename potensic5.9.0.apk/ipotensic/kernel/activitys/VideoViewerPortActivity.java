package com.ipotensic.kernel.activitys;

import android.content.res.Configuration;
import android.os.Bundle;
import com.ipotensic.baselib.DDLog;

/* loaded from: classes2.dex */
public class VideoViewerPortActivity extends VideoViewerLandActivity {
    private final int TOP_PADDING = 80;

    @Override // com.ipotensic.kernel.activitys.VideoViewerLandActivity, com.ipotensic.baselib.base.BaseActivity
    public boolean isNewFullScreenPage() {
        return false;
    }

    @Override // com.ipotensic.kernel.activitys.VideoViewerLandActivity, com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.isLandActivity = false;
        super.onCreate(bundle);
        setStateBarShow(true, true);
        this.layoutMain.setPadding(0, 80, 0, 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.layoutMain.setPadding(0, 0, 0, 0);
            setFullscreen();
            DDLog.e("\u6a2a\u5c4f");
        } else {
            DDLog.e("\u7ad6\u5c4f");
            this.layoutMain.setPadding(0, 80, 0, 0);
            setStateBarShow(true, false);
        }
    }
}