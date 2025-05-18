package com.ipotensic.baselib.xtoast;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes2.dex */
final class ToastLifecycle implements Application.ActivityLifecycleCallbacks {
    private Activity mActivity;
    private XToast mToast;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    ToastLifecycle(XToast xToast, Activity activity) {
        this.mActivity = activity;
        this.mToast = xToast;
    }

    void register() {
        this.mActivity.getApplication().registerActivityLifecycleCallbacks(this);
    }

    void unregister() {
        this.mActivity.getApplication().unregisterActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.mActivity == activity && activity.isFinishing() && this.mToast.isShow()) {
            this.mToast.cancel();
        }
    }
}