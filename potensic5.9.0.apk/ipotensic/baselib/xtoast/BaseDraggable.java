package com.ipotensic.baselib.xtoast;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: classes2.dex */
public abstract class BaseDraggable implements View.OnTouchListener {
    private View mRootView;
    private XToast mToast;
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mWindowParams;

    public void start(XToast xToast) {
        this.mToast = xToast;
        this.mRootView = xToast.getView();
        this.mWindowManager = xToast.getWindowManager();
        this.mWindowParams = xToast.getWindowParams();
        this.mRootView.setOnTouchListener(this);
    }

    protected XToast getXToast() {
        return this.mToast;
    }

    protected WindowManager getWindowManager() {
        return this.mWindowManager;
    }

    protected WindowManager.LayoutParams getWindowParams() {
        return this.mWindowParams;
    }

    protected View getRootView() {
        return this.mRootView;
    }

    protected int getStatusBarHeight() {
        Rect rect = new Rect();
        getRootView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public void updateLocation(float f, float f2) {
        updateLocation((int) f, (int) f2);
    }

    public void updateLocation(int i, int i2) {
        if (this.mWindowParams.x == i && this.mWindowParams.y == i2) {
            return;
        }
        this.mWindowParams.x = i;
        this.mWindowParams.y = i2;
        this.mWindowParams.gravity = BadgeDrawable.TOP_START;
        this.mWindowManager.updateViewLayout(this.mRootView, this.mWindowParams);
    }
}