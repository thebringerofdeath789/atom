package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

/* loaded from: classes2.dex */
class ImmersionDelegate implements Runnable {
    private BarProperties mBarProperties;
    private ImmersionBar mImmersionBar;
    private int mNotchHeight;
    private OnBarListener mOnBarListener;
    private int mStatusBarHeight;

    ImmersionDelegate(Object obj) {
        this.mStatusBarHeight = 0;
        if (obj instanceof Activity) {
            if (this.mImmersionBar == null) {
                Activity activity = (Activity) obj;
                this.mImmersionBar = new ImmersionBar(activity);
                this.mStatusBarHeight = ImmersionBar.getStatusBarHeight(activity);
                return;
            }
            return;
        }
        if (obj instanceof Fragment) {
            if (this.mImmersionBar == null) {
                if (obj instanceof DialogFragment) {
                    this.mImmersionBar = new ImmersionBar((DialogFragment) obj);
                } else {
                    this.mImmersionBar = new ImmersionBar((Fragment) obj);
                }
                this.mStatusBarHeight = ImmersionBar.getStatusBarHeight((Fragment) obj);
                return;
            }
            return;
        }
        if ((obj instanceof android.app.Fragment) && this.mImmersionBar == null) {
            if (obj instanceof android.app.DialogFragment) {
                this.mImmersionBar = new ImmersionBar((android.app.DialogFragment) obj);
            } else {
                this.mImmersionBar = new ImmersionBar((android.app.Fragment) obj);
            }
            this.mStatusBarHeight = ImmersionBar.getStatusBarHeight((android.app.Fragment) obj);
        }
    }

    ImmersionDelegate(Activity activity, Dialog dialog) {
        this.mStatusBarHeight = 0;
        if (this.mImmersionBar == null) {
            this.mImmersionBar = new ImmersionBar(activity, dialog);
            this.mStatusBarHeight = ImmersionBar.getStatusBarHeight(activity);
        }
    }

    public ImmersionBar get() {
        return this.mImmersionBar;
    }

    void onActivityCreated(Configuration configuration) {
        barChanged(configuration);
    }

    void onResume() {
        if (this.mImmersionBar != null && OSUtils.isEMUI3_x() && this.mImmersionBar.initialized() && !this.mImmersionBar.isFragment() && this.mImmersionBar.getBarParams().navigationBarWithEMUI3Enable) {
            reinitialize();
        }
    }

    void onDestroy() {
        this.mBarProperties = null;
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null) {
            immersionBar.destroy();
            this.mImmersionBar = null;
        }
    }

    void onConfigurationChanged(Configuration configuration) {
        if (this.mImmersionBar != null) {
            if (OSUtils.isEMUI3_x() || Build.VERSION.SDK_INT == 19) {
                if (this.mImmersionBar.initialized() && !this.mImmersionBar.isFragment() && this.mImmersionBar.getBarParams().navigationBarWithKitkatEnable) {
                    reinitialize();
                } else {
                    fitsWindows();
                }
            } else {
                fitsWindows();
            }
            barChanged(configuration);
        }
    }

    private void reinitialize() {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null) {
            immersionBar.init();
        }
    }

    private void fitsWindows() {
        int statusBarHeight = ImmersionBar.getStatusBarHeight(this.mImmersionBar.getActivity());
        if (this.mStatusBarHeight != statusBarHeight) {
            this.mImmersionBar.fitsWindows();
            this.mStatusBarHeight = statusBarHeight;
        }
    }

    private void barChanged(Configuration configuration) {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar == null || !immersionBar.initialized() || Build.VERSION.SDK_INT < 19) {
            return;
        }
        OnBarListener onBarListener = this.mImmersionBar.getBarParams().onBarListener;
        this.mOnBarListener = onBarListener;
        if (onBarListener != null) {
            Activity activity = this.mImmersionBar.getActivity();
            if (this.mBarProperties == null) {
                this.mBarProperties = new BarProperties();
            }
            this.mBarProperties.setPortrait(configuration.orientation == 1);
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == 1) {
                this.mBarProperties.setLandscapeLeft(true);
                this.mBarProperties.setLandscapeRight(false);
            } else if (rotation == 3) {
                this.mBarProperties.setLandscapeLeft(false);
                this.mBarProperties.setLandscapeRight(true);
            } else {
                this.mBarProperties.setLandscapeLeft(false);
                this.mBarProperties.setLandscapeRight(false);
            }
            activity.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity = this.mImmersionBar.getActivity();
        BarConfig barConfig = new BarConfig(activity);
        this.mBarProperties.setStatusBarHeight(barConfig.getStatusBarHeight());
        this.mBarProperties.setNavigationBar(barConfig.hasNavigationBar());
        this.mBarProperties.setNavigationBarHeight(barConfig.getNavigationBarHeight());
        this.mBarProperties.setNavigationBarWidth(barConfig.getNavigationBarWidth());
        boolean hasNotchScreen = NotchUtils.hasNotchScreen(activity);
        this.mBarProperties.setNotchScreen(hasNotchScreen);
        if (hasNotchScreen && this.mNotchHeight == 0) {
            int notchHeight = NotchUtils.getNotchHeight(activity);
            this.mNotchHeight = notchHeight;
            this.mBarProperties.setNotchHeight(notchHeight);
        }
        this.mOnBarListener.onBarChange(this.mBarProperties);
    }
}