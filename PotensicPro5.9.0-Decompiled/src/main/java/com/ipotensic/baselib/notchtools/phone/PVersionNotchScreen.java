package com.ipotensic.baselib.notchtools.phone;

import android.app.Activity;
import android.app.Dialog;
import android.view.DisplayCutout;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport;
import com.ipotensic.baselib.notchtools.core.OnNotchCallBack;
import com.ipotensic.baselib.notchtools.helper.NotchStatusBarUtils;

/* loaded from: classes2.dex */
public class PVersionNotchScreen extends AbsNotchScreenSupport {
    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public boolean isNotchScreen(Window window) {
        DisplayCutout displayCutout;
        WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
        return (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || displayCutout.getBoundingRects() == null) ? false : true;
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public int getNotchHeight(Window window) {
        DisplayCutout displayCutout;
        WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
        if (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || displayCutout.getBoundingRects() == null) {
            return 0;
        }
        return displayCutout.getSafeInsetTop();
    }

    @Override // com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport, com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenDontUseStatus(Activity activity, OnNotchCallBack onNotchCallBack) {
        super.fullScreenDontUseStatus(activity, onNotchCallBack);
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        activity.getWindow().setAttributes(attributes);
        NotchStatusBarUtils.setFakeNotchView(activity.getWindow());
    }

    @Override // com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport, com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenUseStatus(Activity activity, OnNotchCallBack onNotchCallBack) {
        super.fullScreenUseStatus(activity, onNotchCallBack);
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        activity.getWindow().setAttributes(attributes);
    }

    @Override // com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport, com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenUseStatus(Dialog dialog, OnNotchCallBack onNotchCallBack) {
        super.fullScreenUseStatus(dialog, onNotchCallBack);
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        dialog.getWindow().setAttributes(attributes);
    }
}
