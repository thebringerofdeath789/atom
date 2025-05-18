package com.ipotensic.baselib.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LoadingDialog;
import com.ipotensic.baselib.R;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.notchtools.NotchTools;
import com.ipotensic.baselib.utils.MediaFileUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseActivity extends AppCompatActivity {
    private ActivityResultLauncher<IntentSenderRequest> deleteLauncher;
    private MediaFileUtils.OnDeleteResultListener deleteResultListener = null;
    private boolean isStatusBarShow;
    public LoadingDialog loadingDialog;
    private ActivityResultLauncher<Intent> resultLauncher;
    private SimpleResultListener<ActivityResult> resultListener;

    public boolean isNewFullScreenPage() {
        return false;
    }

    public void registerActivityForResult(Intent intent, SimpleResultListener<ActivityResult> simpleResultListener) {
        this.resultListener = simpleResultListener;
        this.resultLauncher.launch(intent);
    }

    public void registerDeleteForResult(IntentSenderRequest intentSenderRequest, MediaFileUtils.OnDeleteResultListener onDeleteResultListener) {
        this.deleteResultListener = onDeleteResultListener;
        this.deleteLauncher.launch(intentSenderRequest);
    }

    public boolean hasDialogShowing() {
        try {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            for (int i = 0; i < fragments.size(); i++) {
                Fragment fragment = fragments.get(i);
                if ((fragment instanceof DialogFragment) && fragment.isResumed()) {
                    return true;
                }
            }
        } catch (Exception e) {
            DDLog.e("\u83b7\u53d6\u5f39\u7a97\u663e\u793a\u72b6\u6001\u51fa\u95191:" + e.getMessage());
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if ("V1818A".equals(Build.MODEL.trim())) {
            if (getResources().getConfiguration().orientation == 2) {
                requestWindowFeature(1);
                getWindow().setFlags(1024, 1024);
            }
            setTheme(R.style.NoAnimActivityStyle);
        }
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT == 26 && isTranslucentOrFloating()) {
            DDLog.w("onCreate fixOrientation when Oreo, result = " + fixOrientation());
        }
        this.resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.ipotensic.baselib.base.BaseActivity.1
            AnonymousClass1() {
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(ActivityResult activityResult) {
                DDLog.e("result:" + activityResult);
                if (BaseActivity.this.resultListener != null) {
                    BaseActivity.this.resultListener.onResult(activityResult);
                }
            }
        });
        this.deleteLauncher = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.ipotensic.baselib.base.BaseActivity.2
            AnonymousClass2() {
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(ActivityResult activityResult) {
                DDLog.e("delete result:" + activityResult);
                if (BaseActivity.this.deleteResultListener != null) {
                    BaseActivity.this.deleteResultListener.onResult(activityResult.getResultCode() == -1);
                }
            }
        });
        if (!isNewFullScreenPage()) {
            initNotch();
            initWindow();
            setStateBarShow(false);
        } else {
            hideSystemUI();
            initWindow();
        }
    }

    /* renamed from: com.ipotensic.baselib.base.BaseActivity$1 */
    class AnonymousClass1 implements ActivityResultCallback<ActivityResult> {
        AnonymousClass1() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(ActivityResult activityResult) {
            DDLog.e("result:" + activityResult);
            if (BaseActivity.this.resultListener != null) {
                BaseActivity.this.resultListener.onResult(activityResult);
            }
        }
    }

    /* renamed from: com.ipotensic.baselib.base.BaseActivity$2 */
    class AnonymousClass2 implements ActivityResultCallback<ActivityResult> {
        AnonymousClass2() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(ActivityResult activityResult) {
            DDLog.e("delete result:" + activityResult);
            if (BaseActivity.this.deleteResultListener != null) {
                BaseActivity.this.deleteResultListener.onResult(activityResult.getResultCode() == -1);
            }
        }
    }

    protected void hideSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private void initWindow() {
        Window window = getWindow();
        window.setFormat(4);
        window.setFlags(128, 128);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && isNewFullScreenPage()) {
            hideSystemUI();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            if (resources.getConfiguration().fontScale != 1.0f) {
                configuration.fontScale = 1.0f;
            }
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    private int getDefaultDisplayDensity() {
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Method method = cls.getMethod("getWindowManagerService", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(cls, new Object[0]);
            Method method2 = invoke.getClass().getMethod("getInitialDisplayDensity", Integer.TYPE);
            method2.setAccessible(true);
            return ((Integer) method2.invoke(invoke, 0)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    protected void initNotch() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                NotchTools.getFullScreenTools().fullScreenUseStatus(this);
            } catch (Exception unused) {
            }
        }
    }

    public void setFullscreen() {
        setBarState(true, false, false);
    }

    public void setStateBarShow(boolean z, boolean z2) {
        setBarState(false, z, z2);
    }

    public void setStateBarShow(boolean z) {
        setBarState(false, z, true);
    }

    private void setBarState(boolean z, boolean z2, boolean z3) {
        this.isStatusBarShow = z2;
        if (z) {
            ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_BAR).init();
        } else {
            ImmersionBar.with(this).hideBar(!z2 ? BarHide.FLAG_HIDE_STATUS_BAR : BarHide.FLAG_SHOW_BAR).statusBarDarkFont(z3).navigationBarColor(R.color.color_nav_gray).init();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            hideKeyboard(motionEvent, getCurrentFocus(), this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void showLoadingDialog() {
        if (this.loadingDialog == null) {
            LoadingDialog loadingDialog = new LoadingDialog(this);
            this.loadingDialog = loadingDialog;
            if (this.isStatusBarShow) {
                loadingDialog.controlWindow(false);
            }
        }
        this.loadingDialog.setCanceledOnTouchOutside(true);
        this.loadingDialog.show();
    }

    public void showLoadingDialog(boolean z) {
        if (this.loadingDialog == null) {
            this.loadingDialog = new LoadingDialog(this);
        }
        if (this.isStatusBarShow) {
            this.loadingDialog.controlWindow(false);
        }
        this.loadingDialog.setCanceledOnTouchOutside(z);
        this.loadingDialog.show();
    }

    public void dismissLoadingDialog() {
        if (isFinishing()) {
            return;
        }
        try {
            LoadingDialog loadingDialog = this.loadingDialog;
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public static void hideKeyboard(MotionEvent motionEvent, View view, Activity activity) {
        if (view != null) {
            try {
                if (view instanceof EditText) {
                    int[] iArr = {0, 0};
                    view.getLocationInWindow(iArr);
                    int i = iArr[0];
                    int i2 = iArr[1];
                    int width = view.getWidth() + i;
                    int height = view.getHeight() + i2;
                    if (motionEvent.getRawX() < i || motionEvent.getRawX() > width || motionEvent.getY() < i2 || motionEvent.getRawY() > height) {
                        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        PhoneConfig.runningActivity = this;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (PhoneConfig.runningActivity != this) {
            PhoneConfig.runningActivity = null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.resultListener = null;
        this.deleteResultListener = null;
        ToastUtil.clear();
    }

    private boolean isTranslucentOrFloating() {
        boolean z;
        Exception e;
        try {
            TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            z = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e3) {
            z = false;
            e = e3;
        }
        return z;
    }

    private boolean fixOrientation() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}