package com.gyf.immersionbar;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes2.dex */
class FitsKeyboard implements ViewTreeObserver.OnGlobalLayoutListener {
    private final int mActionBarHeight;
    private Activity mActivity;
    private View mChildView;
    private View mContentView;
    private View mDecorView;
    private ImmersionBar mImmersionBar;
    private boolean mIsAddListener;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private final int mStatusBarHeight;
    private int mTempKeyboardHeight;
    private Window mWindow;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View] */
    FitsKeyboard(ImmersionBar immersionBar, Activity activity, Window window) {
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mImmersionBar = immersionBar;
        this.mActivity = activity;
        this.mWindow = window;
        View decorView = window.getDecorView();
        this.mDecorView = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(android.R.id.content);
        View childAt = frameLayout.getChildAt(0);
        this.mChildView = childAt;
        if (childAt != null) {
            if (childAt instanceof DrawerLayout) {
                this.mChildView = ((DrawerLayout) childAt).getChildAt(0);
            }
            View view = this.mChildView;
            if (view != null) {
                this.mPaddingLeft = view.getPaddingLeft();
                this.mPaddingTop = this.mChildView.getPaddingTop();
                this.mPaddingRight = this.mChildView.getPaddingRight();
                this.mPaddingBottom = this.mChildView.getPaddingBottom();
            }
        }
        ?? r3 = this.mChildView;
        this.mContentView = r3 != 0 ? r3 : frameLayout;
        BarConfig barConfig = new BarConfig(this.mActivity);
        this.mStatusBarHeight = barConfig.getStatusBarHeight();
        this.mActionBarHeight = barConfig.getActionBarHeight();
    }

    void enable(int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.mWindow.setSoftInputMode(i);
            if (this.mIsAddListener) {
                return;
            }
            this.mDecorView.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.mIsAddListener = true;
        }
    }

    void disable() {
        if (Build.VERSION.SDK_INT < 19 || !this.mIsAddListener) {
            return;
        }
        if (this.mChildView != null) {
            this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        } else {
            this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), this.mImmersionBar.getPaddingBottom());
        }
    }

    void cancel() {
        if (Build.VERSION.SDK_INT < 19 || !this.mIsAddListener) {
            return;
        }
        this.mDecorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.mIsAddListener = false;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar == null || immersionBar.getBarParams() == null || !this.mImmersionBar.getBarParams().keyboardEnable) {
            return;
        }
        int navigationBarHeight = ImmersionBar.getNavigationBarHeight(this.mActivity);
        Rect rect = new Rect();
        this.mDecorView.getWindowVisibleDisplayFrame(rect);
        int height = this.mContentView.getHeight() - rect.bottom;
        if (height != this.mTempKeyboardHeight) {
            this.mTempKeyboardHeight = height;
            boolean z = true;
            if (ImmersionBar.checkFitsSystemWindows(this.mWindow.getDecorView().findViewById(android.R.id.content))) {
                height -= navigationBarHeight;
                if (height <= navigationBarHeight) {
                    z = false;
                }
            } else if (this.mChildView != null) {
                if (this.mImmersionBar.getBarParams().isSupportActionBar) {
                    height += this.mActionBarHeight + this.mStatusBarHeight;
                }
                if (this.mImmersionBar.getBarParams().fits) {
                    height += this.mStatusBarHeight;
                }
                if (height > navigationBarHeight) {
                    i = this.mPaddingBottom + height;
                } else {
                    i = 0;
                    z = false;
                }
                this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, i);
            } else {
                int paddingBottom = this.mImmersionBar.getPaddingBottom();
                height -= navigationBarHeight;
                if (height > navigationBarHeight) {
                    paddingBottom = height + navigationBarHeight;
                } else {
                    z = false;
                }
                this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), paddingBottom);
            }
            int i2 = height >= 0 ? height : 0;
            if (this.mImmersionBar.getBarParams().onKeyboardListener != null) {
                this.mImmersionBar.getBarParams().onKeyboardListener.onKeyboardChange(z, i2);
            }
        }
    }
}