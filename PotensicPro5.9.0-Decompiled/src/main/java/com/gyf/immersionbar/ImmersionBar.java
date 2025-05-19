package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.net.bsd.RCommandClient;

/* loaded from: classes2.dex */
public final class ImmersionBar implements ImmersionCallback {
    private int mActionBarHeight;
    private Activity mActivity;
    private BarConfig mBarConfig;
    private BarParams mBarParams;
    private ViewGroup mContentView;
    private ViewGroup mDecorView;
    private Dialog mDialog;
    private FitsKeyboard mFitsKeyboard;
    private int mFitsStatusBarType;
    private Fragment mFragment;
    private boolean mInitialized;
    private boolean mIsActivity;
    private boolean mIsDialog;
    private boolean mIsFragment;
    private boolean mKeyboardTempEnable;
    private int mNavigationBarHeight;
    private int mNavigationBarWidth;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private androidx.fragment.app.Fragment mSupportFragment;
    private Map<String, BarParams> mTagMap;
    private Window mWindow;

    public static ImmersionBar with(Activity activity) {
        return getRetriever().get(activity);
    }

    public static ImmersionBar with(androidx.fragment.app.Fragment fragment) {
        return getRetriever().get(fragment);
    }

    public static ImmersionBar with(Fragment fragment) {
        return getRetriever().get(fragment);
    }

    public static ImmersionBar with(DialogFragment dialogFragment) {
        return getRetriever().get(dialogFragment);
    }

    public static ImmersionBar with(android.app.DialogFragment dialogFragment) {
        return getRetriever().get(dialogFragment);
    }

    public static ImmersionBar with(Activity activity, Dialog dialog) {
        return getRetriever().get(activity, dialog);
    }

    public static void destroy(Activity activity, Dialog dialog) {
        getRetriever().destroy(activity, dialog);
    }

    ImmersionBar(Activity activity) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsActivity = true;
        this.mActivity = activity;
        initCommonParameter(activity.getWindow());
    }

    ImmersionBar(androidx.fragment.app.Fragment fragment) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsFragment = true;
        this.mActivity = fragment.getActivity();
        this.mSupportFragment = fragment;
        checkInitWithActivity();
        initCommonParameter(this.mActivity.getWindow());
    }

    ImmersionBar(Fragment fragment) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsFragment = true;
        this.mActivity = fragment.getActivity();
        this.mFragment = fragment;
        checkInitWithActivity();
        initCommonParameter(this.mActivity.getWindow());
    }

    ImmersionBar(DialogFragment dialogFragment) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsDialog = true;
        this.mActivity = dialogFragment.getActivity();
        this.mSupportFragment = dialogFragment;
        this.mDialog = dialogFragment.getDialog();
        checkInitWithActivity();
        initCommonParameter(this.mDialog.getWindow());
    }

    ImmersionBar(android.app.DialogFragment dialogFragment) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsDialog = true;
        this.mActivity = dialogFragment.getActivity();
        this.mFragment = dialogFragment;
        this.mDialog = dialogFragment.getDialog();
        checkInitWithActivity();
        initCommonParameter(this.mDialog.getWindow());
    }

    ImmersionBar(Activity activity, Dialog dialog) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsDialog = true;
        this.mActivity = activity;
        this.mDialog = dialog;
        checkInitWithActivity();
        initCommonParameter(this.mDialog.getWindow());
    }

    private void checkInitWithActivity() {
        if (with(this.mActivity).initialized()) {
            return;
        }
        with(this.mActivity).init();
    }

    private void initCommonParameter(Window window) {
        this.mWindow = window;
        this.mBarParams = new BarParams();
        ViewGroup viewGroup = (ViewGroup) this.mWindow.getDecorView();
        this.mDecorView = viewGroup;
        this.mContentView = (ViewGroup) viewGroup.findViewById(android.R.id.content);
    }

    public ImmersionBar transparentStatusBar() {
        this.mBarParams.statusBarColor = 0;
        return this;
    }

    public ImmersionBar transparentNavigationBar() {
        this.mBarParams.navigationBarColor = 0;
        this.mBarParams.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentBar() {
        this.mBarParams.statusBarColor = 0;
        this.mBarParams.navigationBarColor = 0;
        this.mBarParams.fullScreen = true;
        return this;
    }

    public ImmersionBar statusBarColor(int i) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar statusBarColor(int i, float f) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, i), f);
    }

    public ImmersionBar statusBarColor(int i, int i2, float f) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar statusBarColor(String str) {
        return statusBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColor(String str, float f) {
        return statusBarColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar statusBarColor(String str, String str2, float f) {
        return statusBarColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar statusBarColorInt(int i) {
        this.mBarParams.statusBarColor = i;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i, float f) {
        this.mBarParams.statusBarColor = i;
        this.mBarParams.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i, int i2, float f) {
        this.mBarParams.statusBarColor = i;
        this.mBarParams.statusBarColorTransform = i2;
        this.mBarParams.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarColor(int i) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar navigationBarColor(int i, float f) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, i), f);
    }

    public ImmersionBar navigationBarColor(int i, int i2, float f) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar navigationBarColor(String str) {
        return navigationBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColor(String str, float f) {
        return navigationBarColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar navigationBarColor(String str, String str2, float f) {
        return navigationBarColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar navigationBarColorInt(int i) {
        this.mBarParams.navigationBarColor = i;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i, float f) {
        this.mBarParams.navigationBarColor = i;
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i, int i2, float f) {
        this.mBarParams.navigationBarColor = i;
        this.mBarParams.navigationBarColorTransform = i2;
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barColor(int i) {
        return barColorInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar barColor(int i, float f) {
        return barColorInt(ContextCompat.getColor(this.mActivity, i), i);
    }

    public ImmersionBar barColor(int i, int i2, float f) {
        return barColorInt(ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar barColor(String str) {
        return barColorInt(Color.parseColor(str));
    }

    public ImmersionBar barColor(String str, float f) {
        return barColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar barColor(String str, String str2, float f) {
        return barColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar barColorInt(int i) {
        this.mBarParams.statusBarColor = i;
        this.mBarParams.navigationBarColor = i;
        return this;
    }

    public ImmersionBar barColorInt(int i, float f) {
        this.mBarParams.statusBarColor = i;
        this.mBarParams.navigationBarColor = i;
        this.mBarParams.statusBarAlpha = f;
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barColorInt(int i, int i2, float f) {
        this.mBarParams.statusBarColor = i;
        this.mBarParams.navigationBarColor = i;
        this.mBarParams.statusBarColorTransform = i2;
        this.mBarParams.navigationBarColorTransform = i2;
        this.mBarParams.statusBarAlpha = f;
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar statusBarColorTransform(int i) {
        return statusBarColorTransformInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar statusBarColorTransform(String str) {
        return statusBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColorTransformInt(int i) {
        this.mBarParams.statusBarColorTransform = i;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(int i) {
        return navigationBarColorTransformInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar navigationBarColorTransform(String str) {
        return navigationBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColorTransformInt(int i) {
        this.mBarParams.navigationBarColorTransform = i;
        return this;
    }

    public ImmersionBar barColorTransform(int i) {
        return barColorTransformInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar barColorTransform(String str) {
        return barColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar barColorTransformInt(int i) {
        this.mBarParams.statusBarColorTransform = i;
        this.mBarParams.navigationBarColorTransform = i;
        return this;
    }

    public ImmersionBar addViewSupportTransformColor(View view) {
        return addViewSupportTransformColorInt(view, this.mBarParams.statusBarColorTransform);
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i, int i2) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2));
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str));
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str, String str2) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str), Color.parseColor(str2));
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(this.mBarParams.statusBarColor), Integer.valueOf(i));
        this.mBarParams.viewMap.put(view, hashMap);
        return this;
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i, int i2) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
        this.mBarParams.viewMap.put(view, hashMap);
        return this;
    }

    public ImmersionBar viewAlpha(float f) {
        this.mBarParams.viewAlpha = f;
        return this;
    }

    public ImmersionBar removeSupportView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        Map<Integer, Integer> map = this.mBarParams.viewMap.get(view);
        if (map != null && map.size() != 0) {
            this.mBarParams.viewMap.remove(view);
        }
        return this;
    }

    public ImmersionBar removeSupportAllView() {
        if (this.mBarParams.viewMap.size() != 0) {
            this.mBarParams.viewMap.clear();
        }
        return this;
    }

    public ImmersionBar fullScreen(boolean z) {
        this.mBarParams.fullScreen = z;
        return this;
    }

    public ImmersionBar statusBarAlpha(float f) {
        this.mBarParams.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarAlpha(float f) {
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barAlpha(float f) {
        this.mBarParams.statusBarAlpha = f;
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar autoDarkModeEnable(boolean z) {
        return autoDarkModeEnable(z, 0.0f);
    }

    public ImmersionBar autoDarkModeEnable(boolean z, float f) {
        this.mBarParams.autoStatusBarDarkModeEnable = z;
        this.mBarParams.autoStatusBarDarkModeAlpha = f;
        this.mBarParams.autoNavigationBarDarkModeEnable = z;
        this.mBarParams.autoNavigationBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z) {
        return autoStatusBarDarkModeEnable(z, 0.0f);
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z, float f) {
        this.mBarParams.autoStatusBarDarkModeEnable = z;
        this.mBarParams.autoStatusBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z) {
        return autoNavigationBarDarkModeEnable(z, 0.0f);
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z, float f) {
        this.mBarParams.autoNavigationBarDarkModeEnable = z;
        this.mBarParams.autoNavigationBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean z) {
        return statusBarDarkFont(z, 0.0f);
    }

    public ImmersionBar statusBarDarkFont(boolean z, float f) {
        this.mBarParams.statusBarDarkFont = z;
        if (z && !isSupportStatusBarDarkFont()) {
            this.mBarParams.statusBarAlpha = f;
        } else {
            this.mBarParams.flymeOSStatusBarFontColor = 0;
            this.mBarParams.statusBarAlpha = 0.0f;
        }
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean z) {
        return navigationBarDarkIcon(z, 0.0f);
    }

    public ImmersionBar navigationBarDarkIcon(boolean z, float f) {
        this.mBarParams.navigationBarDarkIcon = z;
        if (z && !isSupportNavigationIconDark()) {
            this.mBarParams.navigationBarAlpha = f;
        } else {
            this.mBarParams.navigationBarAlpha = 0.0f;
        }
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(int i) {
        this.mBarParams.flymeOSStatusBarFontColor = ContextCompat.getColor(this.mActivity, i);
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(String str) {
        this.mBarParams.flymeOSStatusBarFontColor = Color.parseColor(str);
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColorInt(int i) {
        this.mBarParams.flymeOSStatusBarFontColor = i;
        return this;
    }

    public ImmersionBar hideBar(BarHide barHide) {
        this.mBarParams.barHide = barHide;
        if (Build.VERSION.SDK_INT == 19 || OSUtils.isEMUI3_x()) {
            if (this.mBarParams.barHide == BarHide.FLAG_HIDE_NAVIGATION_BAR || this.mBarParams.barHide == BarHide.FLAG_HIDE_BAR) {
                this.mBarParams.hideNavigationBar = true;
            } else {
                this.mBarParams.hideNavigationBar = false;
            }
        }
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z) {
        this.mBarParams.fits = z;
        if (this.mBarParams.fits) {
            if (this.mFitsStatusBarType == 0) {
                this.mFitsStatusBarType = 4;
            }
        } else {
            this.mFitsStatusBarType = 0;
        }
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i, int i2, float f) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i) {
        return fitsSystemWindowsInt(z, i, ViewCompat.MEASURED_STATE_MASK, 0.0f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i, int i2, float f) {
        this.mBarParams.fits = z;
        this.mBarParams.contentColor = i;
        this.mBarParams.contentColorTransform = i2;
        this.mBarParams.contentAlpha = f;
        if (this.mBarParams.fits) {
            if (this.mFitsStatusBarType == 0) {
                this.mFitsStatusBarType = 4;
            }
        } else {
            this.mFitsStatusBarType = 0;
        }
        this.mContentView.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.contentColor, this.mBarParams.contentColorTransform, this.mBarParams.contentAlpha));
        return this;
    }

    public ImmersionBar statusBarView(View view) {
        if (view == null) {
            return this;
        }
        this.mBarParams.statusBarView = view;
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 3;
        }
        return this;
    }

    public ImmersionBar statusBarView(int i) {
        return statusBarView(this.mActivity.findViewById(i));
    }

    public ImmersionBar statusBarView(int i, View view) {
        return statusBarView(view.findViewById(i));
    }

    public ImmersionBar titleBar(View view) {
        return view == null ? this : titleBar(view, true);
    }

    public ImmersionBar titleBar(View view, boolean z) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 1;
        }
        this.mBarParams.titleBarView = view;
        this.mBarParams.statusBarColorEnabled = z;
        return this;
    }

    public ImmersionBar titleBar(int i) {
        return titleBar(i, true);
    }

    public ImmersionBar titleBar(int i, boolean z) {
        androidx.fragment.app.Fragment fragment = this.mSupportFragment;
        if (fragment != null && fragment.getView() != null) {
            return titleBar(this.mSupportFragment.getView().findViewById(i), z);
        }
        Fragment fragment2 = this.mFragment;
        if (fragment2 != null && fragment2.getView() != null) {
            return titleBar(this.mFragment.getView().findViewById(i), z);
        }
        return titleBar(this.mActivity.findViewById(i), z);
    }

    public ImmersionBar titleBar(int i, View view) {
        return titleBar(view.findViewById(i), true);
    }

    public ImmersionBar titleBar(int i, View view, boolean z) {
        return titleBar(view.findViewById(i), z);
    }

    public ImmersionBar titleBarMarginTop(int i) {
        androidx.fragment.app.Fragment fragment = this.mSupportFragment;
        if (fragment != null && fragment.getView() != null) {
            return titleBarMarginTop(this.mSupportFragment.getView().findViewById(i));
        }
        Fragment fragment2 = this.mFragment;
        if (fragment2 != null && fragment2.getView() != null) {
            return titleBarMarginTop(this.mFragment.getView().findViewById(i));
        }
        return titleBarMarginTop(this.mActivity.findViewById(i));
    }

    public ImmersionBar titleBarMarginTop(int i, View view) {
        return titleBarMarginTop(view.findViewById(i));
    }

    public ImmersionBar titleBarMarginTop(View view) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 2;
        }
        this.mBarParams.titleBarView = view;
        return this;
    }

    public ImmersionBar supportActionBar(boolean z) {
        this.mBarParams.isSupportActionBar = z;
        return this;
    }

    public ImmersionBar statusBarColorTransformEnable(boolean z) {
        this.mBarParams.statusBarColorEnabled = z;
        return this;
    }

    public ImmersionBar reset() {
        this.mBarParams = new BarParams();
        this.mFitsStatusBarType = 0;
        return this;
    }

    public ImmersionBar addTag(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        this.mTagMap.put(str, this.mBarParams.m20clone());
        return this;
    }

    public ImmersionBar getTag(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        BarParams barParams = this.mTagMap.get(str);
        if (barParams != null) {
            this.mBarParams = barParams.m20clone();
        }
        return this;
    }

    public ImmersionBar keyboardEnable(boolean z) {
        return keyboardEnable(z, this.mBarParams.keyboardMode);
    }

    public ImmersionBar keyboardEnable(boolean z, int i) {
        this.mBarParams.keyboardEnable = z;
        this.mBarParams.keyboardMode = i;
        this.mKeyboardTempEnable = z;
        return this;
    }

    public ImmersionBar keyboardMode(int i) {
        this.mBarParams.keyboardMode = i;
        return this;
    }

    public ImmersionBar setOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        if (this.mBarParams.onKeyboardListener == null) {
            this.mBarParams.onKeyboardListener = onKeyboardListener;
        }
        return this;
    }

    public ImmersionBar setOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener != null) {
            if (this.mBarParams.onNavigationBarListener == null) {
                this.mBarParams.onNavigationBarListener = onNavigationBarListener;
                NavigationBarObserver.getInstance().addOnNavigationBarListener(this.mBarParams.onNavigationBarListener);
            }
        } else if (this.mBarParams.onNavigationBarListener != null) {
            NavigationBarObserver.getInstance().removeOnNavigationBarListener(this.mBarParams.onNavigationBarListener);
            this.mBarParams.onNavigationBarListener = null;
        }
        return this;
    }

    public ImmersionBar setOnBarListener(OnBarListener onBarListener) {
        if (onBarListener != null) {
            if (this.mBarParams.onBarListener == null) {
                this.mBarParams.onBarListener = onBarListener;
            }
        } else if (this.mBarParams.onBarListener != null) {
            this.mBarParams.onBarListener = null;
        }
        return this;
    }

    public ImmersionBar navigationBarEnable(boolean z) {
        this.mBarParams.navigationBarEnable = z;
        return this;
    }

    public ImmersionBar navigationBarWithKitkatEnable(boolean z) {
        this.mBarParams.navigationBarWithKitkatEnable = z;
        return this;
    }

    public ImmersionBar navigationBarWithEMUI3Enable(boolean z) {
        if (OSUtils.isEMUI3_x()) {
            this.mBarParams.navigationBarWithEMUI3Enable = z;
            this.mBarParams.navigationBarWithKitkatEnable = z;
        }
        return this;
    }

    public ImmersionBar barEnable(boolean z) {
        this.mBarParams.barEnable = z;
        return this;
    }

    public void init() {
        if (this.mBarParams.barEnable) {
            updateBarParams();
            setBar();
            fitsWindows();
            fitsKeyboard();
            transformView();
            this.mInitialized = true;
        }
    }

    void destroy() {
        ImmersionBar with;
        cancelListener();
        if (this.mIsDialog && (with = with(this.mActivity)) != null) {
            with.mBarParams.keyboardEnable = with.mKeyboardTempEnable;
        }
        this.mInitialized = false;
    }

    private void updateBarParams() {
        ImmersionBar with;
        ImmersionBar with2;
        adjustDarkModeParams();
        if (Build.VERSION.SDK_INT >= 19) {
            this.mBarConfig = new BarConfig(this.mActivity);
            if (!initialized()) {
                this.mActionBarHeight = this.mBarConfig.getActionBarHeight();
            }
            if (this.mIsFragment && (with2 = with(this.mActivity)) != null) {
                with2.mBarParams = this.mBarParams;
            }
            if (this.mIsDialog && (with = with(this.mActivity)) != null && with.mKeyboardTempEnable) {
                with.mBarParams.keyboardEnable = false;
            }
        }
    }

    private void setBar() {
        if (Build.VERSION.SDK_INT >= 19) {
            int i = 256;
            if (Build.VERSION.SDK_INT >= 21 && !OSUtils.isEMUI3_x()) {
                fitsNotchScreen();
                i = setNavigationIconDark(setStatusBarDarkFont(initBarAboveLOLLIPOP(256)));
            } else {
                initBarBelowLOLLIPOP();
            }
            this.mDecorView.setSystemUiVisibility(hideBar(i));
        }
        if (OSUtils.isMIUI6Later()) {
            setMIUIBarDark(this.mWindow, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", this.mBarParams.statusBarDarkFont);
            if (this.mBarParams.navigationBarEnable) {
                setMIUIBarDark(this.mWindow, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", this.mBarParams.navigationBarDarkIcon);
            }
        }
        if (OSUtils.isFlymeOS4Later()) {
            if (this.mBarParams.flymeOSStatusBarFontColor != 0) {
                FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(this.mActivity, this.mBarParams.flymeOSStatusBarFontColor);
            } else {
                FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(this.mActivity, this.mBarParams.statusBarDarkFont);
            }
        }
        if (this.mBarParams.onNavigationBarListener != null) {
            NavigationBarObserver.getInstance().register(this.mActivity.getApplication());
        }
    }

    private void fitsNotchScreen() {
        if (Build.VERSION.SDK_INT < 28 || initialized()) {
            return;
        }
        WindowManager.LayoutParams attributes = this.mWindow.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        this.mWindow.setAttributes(attributes);
    }

    private int initBarAboveLOLLIPOP(int i) {
        if (!initialized()) {
            this.mBarParams.defaultNavigationBarColor = this.mWindow.getNavigationBarColor();
        }
        int i2 = i | 1024;
        if (this.mBarParams.fullScreen && this.mBarParams.navigationBarEnable) {
            i2 |= 512;
        }
        this.mWindow.clearFlags(67108864);
        if (this.mBarConfig.hasNavigationBar()) {
            this.mWindow.clearFlags(134217728);
        }
        this.mWindow.addFlags(Integer.MIN_VALUE);
        if (this.mBarParams.statusBarColorEnabled) {
            this.mWindow.setStatusBarColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, this.mBarParams.statusBarColorTransform, this.mBarParams.statusBarAlpha));
        } else {
            this.mWindow.setStatusBarColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, 0, this.mBarParams.statusBarAlpha));
        }
        if (this.mBarParams.navigationBarEnable) {
            this.mWindow.setNavigationBarColor(ColorUtils.blendARGB(this.mBarParams.navigationBarColor, this.mBarParams.navigationBarColorTransform, this.mBarParams.navigationBarAlpha));
        } else {
            this.mWindow.setNavigationBarColor(this.mBarParams.defaultNavigationBarColor);
        }
        return i2;
    }

    private void initBarBelowLOLLIPOP() {
        this.mWindow.addFlags(67108864);
        setupStatusBarView();
        if (this.mBarConfig.hasNavigationBar() || OSUtils.isEMUI3_x()) {
            if (this.mBarParams.navigationBarEnable && this.mBarParams.navigationBarWithKitkatEnable) {
                this.mWindow.addFlags(134217728);
            } else {
                this.mWindow.clearFlags(134217728);
            }
            if (this.mNavigationBarHeight == 0) {
                this.mNavigationBarHeight = this.mBarConfig.getNavigationBarHeight();
            }
            if (this.mNavigationBarWidth == 0) {
                this.mNavigationBarWidth = this.mBarConfig.getNavigationBarWidth();
            }
            setupNavBarView();
        }
    }

    private void setupStatusBarView() {
        View findViewById = this.mDecorView.findViewById(Constants.IMMERSION_ID_STATUS_BAR_VIEW);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.getStatusBarHeight());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(Constants.IMMERSION_ID_STATUS_BAR_VIEW);
            this.mDecorView.addView(findViewById);
        }
        if (this.mBarParams.statusBarColorEnabled) {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, this.mBarParams.statusBarColorTransform, this.mBarParams.statusBarAlpha));
        } else {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, 0, this.mBarParams.statusBarAlpha));
        }
    }

    private void setupNavBarView() {
        FrameLayout.LayoutParams layoutParams;
        View findViewById = this.mDecorView.findViewById(Constants.IMMERSION_ID_NAVIGATION_BAR_VIEW);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            findViewById.setId(Constants.IMMERSION_ID_NAVIGATION_BAR_VIEW);
            this.mDecorView.addView(findViewById);
        }
        if (this.mBarConfig.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.mBarConfig.getNavigationBarWidth(), -1);
            layoutParams.gravity = GravityCompat.END;
        }
        findViewById.setLayoutParams(layoutParams);
        findViewById.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.navigationBarColor, this.mBarParams.navigationBarColorTransform, this.mBarParams.navigationBarAlpha));
        if (this.mBarParams.navigationBarEnable && this.mBarParams.navigationBarWithKitkatEnable && !this.mBarParams.hideNavigationBar) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    private void adjustDarkModeParams() {
        if (this.mBarParams.autoStatusBarDarkModeEnable && this.mBarParams.statusBarColor != 0) {
            statusBarDarkFont(this.mBarParams.statusBarColor > -4539718, this.mBarParams.autoStatusBarDarkModeAlpha);
        }
        if (!this.mBarParams.autoNavigationBarDarkModeEnable || this.mBarParams.navigationBarColor == 0) {
            return;
        }
        navigationBarDarkIcon(this.mBarParams.navigationBarColor > -4539718, this.mBarParams.autoNavigationBarDarkModeAlpha);
    }

    /* renamed from: com.gyf.immersionbar.ImmersionBar$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$gyf$immersionbar$BarHide;

        static {
            int[] iArr = new int[BarHide.values().length];
            $SwitchMap$com$gyf$immersionbar$BarHide = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$gyf$immersionbar$BarHide[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$gyf$immersionbar$BarHide[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$gyf$immersionbar$BarHide[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private int hideBar(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            int i2 = AnonymousClass2.$SwitchMap$com$gyf$immersionbar$BarHide[this.mBarParams.barHide.ordinal()];
            if (i2 == 1) {
                i |= 518;
            } else if (i2 == 2) {
                i |= AnalyticsListener.EVENT_VIDEO_SIZE_CHANGED;
            } else if (i2 == 3) {
                i |= RCommandClient.DEFAULT_PORT;
            } else if (i2 == 4) {
                i |= 0;
            }
        }
        return i | 4096;
    }

    void fitsWindows() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.mBarConfig = new BarConfig(this.mActivity);
            if (Build.VERSION.SDK_INT >= 21 && !OSUtils.isEMUI3_x()) {
                fitsWindowsAboveLOLLIPOP();
            } else {
                fitsWindowsBelowLOLLIPOP();
                if (!this.mIsFragment && OSUtils.isEMUI3_x()) {
                    fitsWindowsEMUI();
                }
            }
            fitsLayoutOverlap();
        }
    }

    private void fitsWindowsAboveLOLLIPOP() {
        if (checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content))) {
            if (this.mBarParams.isSupportActionBar) {
                setPadding(0, this.mActionBarHeight, 0, 0);
            }
        } else {
            int statusBarHeight = (this.mBarParams.fits && this.mFitsStatusBarType == 4) ? this.mBarConfig.getStatusBarHeight() : 0;
            if (this.mBarParams.isSupportActionBar) {
                statusBarHeight = this.mBarConfig.getStatusBarHeight() + this.mActionBarHeight;
            }
            setPadding(0, statusBarHeight, 0, 0);
        }
    }

    private void fitsWindowsBelowLOLLIPOP() {
        int i;
        int i2;
        if (checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content))) {
            if (this.mBarParams.isSupportActionBar) {
                setPadding(0, this.mActionBarHeight, 0, 0);
                return;
            }
            return;
        }
        int statusBarHeight = (this.mBarParams.fits && this.mFitsStatusBarType == 4) ? this.mBarConfig.getStatusBarHeight() : 0;
        if (this.mBarParams.isSupportActionBar) {
            statusBarHeight = this.mBarConfig.getStatusBarHeight() + this.mActionBarHeight;
        }
        if (this.mBarConfig.hasNavigationBar() && this.mBarParams.navigationBarEnable && this.mBarParams.navigationBarWithKitkatEnable) {
            if (this.mBarParams.fullScreen) {
                i = 0;
                i2 = 0;
            } else if (this.mBarConfig.isNavigationAtBottom()) {
                i2 = this.mBarConfig.getNavigationBarHeight();
                i = 0;
            } else {
                i = this.mBarConfig.getNavigationBarWidth();
                i2 = 0;
            }
            if (this.mBarParams.hideNavigationBar) {
                if (this.mBarConfig.isNavigationAtBottom()) {
                    i2 = 0;
                } else {
                    i = 0;
                }
            } else if (!this.mBarConfig.isNavigationAtBottom()) {
                i = this.mBarConfig.getNavigationBarWidth();
            }
        } else {
            i = 0;
            i2 = 0;
        }
        setPadding(0, statusBarHeight, i, i2);
    }

    private void fitsWindowsEMUI() {
        View findViewById = this.mDecorView.findViewById(Constants.IMMERSION_ID_NAVIGATION_BAR_VIEW);
        if (!this.mBarParams.navigationBarEnable || !this.mBarParams.navigationBarWithKitkatEnable) {
            EMUI3NavigationBarObserver.getInstance().removeOnNavigationBarListener(this);
            findViewById.setVisibility(8);
        } else if (findViewById != null) {
            EMUI3NavigationBarObserver.getInstance().addOnNavigationBarListener(this);
            EMUI3NavigationBarObserver.getInstance().register(this.mActivity.getApplication());
        }
    }

    @Override // com.gyf.immersionbar.OnNavigationBarListener
    public void onNavigationBarChange(boolean z) {
        View findViewById = this.mDecorView.findViewById(Constants.IMMERSION_ID_NAVIGATION_BAR_VIEW);
        if (findViewById != null) {
            this.mBarConfig = new BarConfig(this.mActivity);
            int paddingBottom = this.mContentView.getPaddingBottom();
            int paddingRight = this.mContentView.getPaddingRight();
            if (!z) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
                if (!checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content))) {
                    if (this.mNavigationBarHeight == 0) {
                        this.mNavigationBarHeight = this.mBarConfig.getNavigationBarHeight();
                    }
                    if (this.mNavigationBarWidth == 0) {
                        this.mNavigationBarWidth = this.mBarConfig.getNavigationBarWidth();
                    }
                    if (!this.mBarParams.hideNavigationBar) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                        if (this.mBarConfig.isNavigationAtBottom()) {
                            layoutParams.gravity = 80;
                            layoutParams.height = this.mNavigationBarHeight;
                            paddingBottom = !this.mBarParams.fullScreen ? this.mNavigationBarHeight : 0;
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = GravityCompat.END;
                            layoutParams.width = this.mNavigationBarWidth;
                            paddingRight = !this.mBarParams.fullScreen ? this.mNavigationBarWidth : 0;
                            paddingBottom = 0;
                        }
                        findViewById.setLayoutParams(layoutParams);
                    }
                    setPadding(0, this.mContentView.getPaddingTop(), paddingRight, paddingBottom);
                }
            }
            paddingBottom = 0;
            paddingRight = 0;
            setPadding(0, this.mContentView.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    private int setStatusBarDarkFont(int i) {
        return (Build.VERSION.SDK_INT < 23 || !this.mBarParams.statusBarDarkFont) ? i : i | 8192;
    }

    private int setNavigationIconDark(int i) {
        return (Build.VERSION.SDK_INT < 26 || !this.mBarParams.navigationBarDarkIcon) ? i : i | 16;
    }

    private void setMIUIBarDark(Window window, String str, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField(str).getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
            } catch (Exception unused) {
            }
        }
    }

    private void fitsLayoutOverlap() {
        int i = this.mFitsStatusBarType;
        if (i == 1) {
            setTitleBar(this.mActivity, this.mBarParams.titleBarView);
        } else if (i == 2) {
            setTitleBarMarginTop(this.mActivity, this.mBarParams.titleBarView);
        } else {
            if (i != 3) {
                return;
            }
            setStatusBarView(this.mActivity, this.mBarParams.statusBarView);
        }
    }

    private void transformView() {
        if (this.mBarParams.viewMap.size() != 0) {
            for (Map.Entry<View, Map<Integer, Integer>> entry : this.mBarParams.viewMap.entrySet()) {
                View key = entry.getKey();
                Map<Integer, Integer> value = entry.getValue();
                Integer valueOf = Integer.valueOf(this.mBarParams.statusBarColor);
                Integer valueOf2 = Integer.valueOf(this.mBarParams.statusBarColorTransform);
                for (Map.Entry<Integer, Integer> entry2 : value.entrySet()) {
                    Integer key2 = entry2.getKey();
                    valueOf2 = entry2.getValue();
                    valueOf = key2;
                }
                if (key != null) {
                    if (Math.abs(this.mBarParams.viewAlpha - 0.0f) == 0.0f) {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.mBarParams.statusBarAlpha));
                    } else {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.mBarParams.viewAlpha));
                    }
                }
            }
        }
    }

    private void cancelListener() {
        if (this.mActivity != null) {
            FitsKeyboard fitsKeyboard = this.mFitsKeyboard;
            if (fitsKeyboard != null) {
                fitsKeyboard.cancel();
                this.mFitsKeyboard = null;
            }
            EMUI3NavigationBarObserver.getInstance().removeOnNavigationBarListener(this);
            NavigationBarObserver.getInstance().removeOnNavigationBarListener(this.mBarParams.onNavigationBarListener);
        }
    }

    private void fitsKeyboard() {
        if (Build.VERSION.SDK_INT >= 19) {
            if (!this.mIsFragment) {
                if (this.mBarParams.keyboardEnable) {
                    if (this.mFitsKeyboard == null) {
                        this.mFitsKeyboard = new FitsKeyboard(this, this.mActivity, this.mWindow);
                    }
                    this.mFitsKeyboard.enable(this.mBarParams.keyboardMode);
                    return;
                } else {
                    FitsKeyboard fitsKeyboard = this.mFitsKeyboard;
                    if (fitsKeyboard != null) {
                        fitsKeyboard.disable();
                        return;
                    }
                    return;
                }
            }
            ImmersionBar with = with(this.mActivity);
            if (with != null) {
                if (with.mBarParams.keyboardEnable) {
                    if (with.mFitsKeyboard == null) {
                        with.mFitsKeyboard = new FitsKeyboard(with, with.mActivity, with.mWindow);
                    }
                    with.mFitsKeyboard.enable(with.mBarParams.keyboardMode);
                } else {
                    FitsKeyboard fitsKeyboard2 = with.mFitsKeyboard;
                    if (fitsKeyboard2 != null) {
                        fitsKeyboard2.disable();
                    }
                }
            }
        }
    }

    boolean isFragment() {
        return this.mIsFragment;
    }

    boolean initialized() {
        return this.mInitialized;
    }

    public BarParams getBarParams() {
        return this.mBarParams;
    }

    private void setPadding(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup != null) {
            viewGroup.setPadding(i, i2, i3, i4);
        }
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    int getPaddingTop() {
        return this.mPaddingTop;
    }

    int getPaddingRight() {
        return this.mPaddingRight;
    }

    int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    Activity getActivity() {
        return this.mActivity;
    }

    public static boolean isSupportStatusBarDarkFont() {
        return OSUtils.isMIUI6Later() || OSUtils.isFlymeOS4Later() || Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportNavigationIconDark() {
        return OSUtils.isMIUI6Later() || Build.VERSION.SDK_INT >= 26;
    }

    public static void setTitleBar(Activity activity, View... viewArr) {
        for (final View view : viewArr) {
            if (activity == null || view == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                final int statusBarHeight = getStatusBarHeight(activity);
                final Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != statusBarHeight) {
                    final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, -2);
                    }
                    if (layoutParams.height == -2 || layoutParams.height == -1) {
                        view.post(new Runnable() { // from class: com.gyf.immersionbar.ImmersionBar.1
                            @Override // java.lang.Runnable
                            public void run() {
                                layoutParams.height = (view.getHeight() + statusBarHeight) - num.intValue();
                                View view2 = view;
                                view2.setPadding(view2.getPaddingLeft(), (view.getPaddingTop() + statusBarHeight) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                                view.setLayoutParams(layoutParams);
                                view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(statusBarHeight));
                            }
                        });
                    } else {
                        layoutParams.height += statusBarHeight - num.intValue();
                        view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + statusBarHeight) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                        view.setLayoutParams(layoutParams);
                        view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(statusBarHeight));
                    }
                }
            }
        }
    }

    public static void setTitleBar(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBar(fragment.getActivity(), viewArr);
    }

    public static void setTitleBar(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBar(fragment.getActivity(), viewArr);
    }

    public static void setTitleBarMarginTop(Activity activity, View... viewArr) {
        for (View view : viewArr) {
            if (activity == null || view == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                int statusBarHeight = getStatusBarHeight(activity);
                Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != statusBarHeight) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (marginLayoutParams.topMargin + statusBarHeight) - num.intValue(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setLayoutParams(marginLayoutParams);
                    view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(statusBarHeight));
                }
            }
        }
    }

    public static void setTitleBarMarginTop(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBarMarginTop(fragment.getActivity(), viewArr);
    }

    public static void setTitleBarMarginTop(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBarMarginTop(fragment.getActivity(), viewArr);
    }

    public static void setStatusBarView(Activity activity, View view) {
        if (activity == null || view == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        int statusBarHeight = getStatusBarHeight(activity);
        Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
        if (num == null) {
            num = 0;
        }
        if (num.intValue() != statusBarHeight) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, 0);
            }
            layoutParams.height = statusBarHeight;
            view.setLayoutParams(layoutParams);
            view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(statusBarHeight));
        }
    }

    public static void setStatusBarView(androidx.fragment.app.Fragment fragment, View view) {
        if (fragment == null) {
            return;
        }
        setStatusBarView(fragment.getActivity(), view);
    }

    public static void setStatusBarView(Fragment fragment, View view) {
        if (fragment == null) {
            return;
        }
        setStatusBarView(fragment.getActivity(), view);
    }

    public static void setFitsSystemWindows(Activity activity) {
        if (activity == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ViewGroup) && !(childAt instanceof DrawerLayout)) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    public static void setFitsSystemWindows(androidx.fragment.app.Fragment fragment) {
        if (fragment == null) {
            return;
        }
        setFitsSystemWindows(fragment.getActivity());
    }

    public static void setFitsSystemWindows(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        setFitsSystemWindows(fragment.getActivity());
    }

    public static boolean checkFitsSystemWindows(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (((childAt instanceof DrawerLayout) && checkFitsSystemWindows(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasNavigationBar(Activity activity) {
        return new BarConfig(activity).hasNavigationBar();
    }

    public static boolean hasNavigationBar(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNavigationBar(fragment.getActivity());
    }

    public static boolean hasNavigationBar(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNavigationBar(fragment.getActivity());
    }

    public static int getNavigationBarHeight(Activity activity) {
        return new BarConfig(activity).getNavigationBarHeight();
    }

    public static int getNavigationBarHeight(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarHeight(fragment.getActivity());
    }

    public static int getNavigationBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarHeight(fragment.getActivity());
    }

    public static int getNavigationBarWidth(Activity activity) {
        return new BarConfig(activity).getNavigationBarWidth();
    }

    public static int getNavigationBarWidth(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarWidth(fragment.getActivity());
    }

    public static int getNavigationBarWidth(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarWidth(fragment.getActivity());
    }

    public static boolean isNavigationAtBottom(Activity activity) {
        return new BarConfig(activity).isNavigationAtBottom();
    }

    public static boolean isNavigationAtBottom(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return isNavigationAtBottom(fragment.getActivity());
    }

    public static boolean isNavigationAtBottom(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return isNavigationAtBottom(fragment.getActivity());
    }

    public static int getStatusBarHeight(Activity activity) {
        return new BarConfig(activity).getStatusBarHeight();
    }

    public static int getStatusBarHeight(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getStatusBarHeight(fragment.getActivity());
    }

    public static int getStatusBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getStatusBarHeight(fragment.getActivity());
    }

    public static int getActionBarHeight(Activity activity) {
        return new BarConfig(activity).getActionBarHeight();
    }

    public static int getActionBarHeight(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getActionBarHeight(fragment.getActivity());
    }

    public static int getActionBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getActionBarHeight(fragment.getActivity());
    }

    public static boolean hasNotchScreen(Activity activity) {
        return NotchUtils.hasNotchScreen(activity);
    }

    public static boolean hasNotchScreen(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNotchScreen(fragment.getActivity());
    }

    public static boolean hasNotchScreen(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNotchScreen(fragment.getActivity());
    }

    public static boolean hasNotchScreen(View view) {
        return NotchUtils.hasNotchScreen(view);
    }

    public static int getNotchHeight(Activity activity) {
        if (hasNotchScreen(activity)) {
            return NotchUtils.getNotchHeight(activity);
        }
        return 0;
    }

    public static int getNotchHeight(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNotchHeight(fragment.getActivity());
    }

    public static int getNotchHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNotchHeight(fragment.getActivity());
    }

    public static void hideStatusBar(Window window) {
        window.setFlags(1024, 1024);
    }

    public static void showStatusBar(Window window) {
        window.clearFlags(1024);
    }

    private static RequestManagerRetriever getRetriever() {
        return RequestManagerRetriever.getInstance();
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
}
