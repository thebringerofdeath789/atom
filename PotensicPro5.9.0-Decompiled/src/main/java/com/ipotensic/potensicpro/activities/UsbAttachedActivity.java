package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.os.Bundle;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public class UsbAttachedActivity extends BaseActivity {
    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (!ActivityHelper.getInstance().isActivityRunning(SplashActivity.class) && !ActivityHelper.getInstance().isActivityRunning(MainActivity.class)) {
            startActivity(new Intent(this, (Class<?>) SplashActivity.class));
        }
        super.onCreate(bundle);
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.colorTransparent));
        DDLog.e("UsbAttachedActivity onCreate");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        finish();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
