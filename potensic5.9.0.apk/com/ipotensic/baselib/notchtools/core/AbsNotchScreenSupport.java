package com.ipotensic.baselib.notchtools.core;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import com.ipotensic.baselib.notchtools.helper.NotchStatusBarUtils;

/* loaded from: classes2.dex */
public abstract class AbsNotchScreenSupport implements INotchSupport {
    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public int getStatusHeight(Window window) {
        return NotchStatusBarUtils.getStatusBarHeight(window.getContext());
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenDontUseStatus(Activity activity, OnNotchCallBack onNotchCallBack) {
        NotchStatusBarUtils.setFullScreenWithSystemUi(activity.getWindow(), false);
        onBindCallBackWithNotchProperty(activity, onNotchCallBack);
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenDontUseStatusForPortrait(Activity activity, OnNotchCallBack onNotchCallBack) {
        fullScreenDontUseStatus(activity, onNotchCallBack);
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenDontUseStatusForLandscape(Activity activity, OnNotchCallBack onNotchCallBack) {
        fullScreenDontUseStatus(activity, onNotchCallBack);
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenUseStatus(Activity activity, OnNotchCallBack onNotchCallBack) {
        NotchStatusBarUtils.setFullScreenWithSystemUi(activity.getWindow(), false);
        onBindCallBackWithNotchProperty(activity, getNotchHeight(activity.getWindow()), onNotchCallBack);
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenUseStatus(Dialog dialog, OnNotchCallBack onNotchCallBack) {
        NotchStatusBarUtils.setFullScreenWithSystemUiDialog(dialog.getWindow(), false);
        onBindCallBackWithNotchProperty(dialog, getNotchHeight(dialog.getWindow()), onNotchCallBack);
    }

    protected void onBindCallBackWithNotchProperty(Activity activity, OnNotchCallBack onNotchCallBack) {
        if (onNotchCallBack != null) {
            NotchProperty notchProperty = new NotchProperty();
            notchProperty.setNotchHeight(getNotchHeight(activity.getWindow()));
            notchProperty.setNotch(isNotchScreen(activity.getWindow()));
            if (onNotchCallBack != null) {
                onNotchCallBack.onNotchPropertyCallback(notchProperty);
            }
        }
    }

    protected void onBindCallBackWithNotchProperty(Activity activity, int i, OnNotchCallBack onNotchCallBack) {
        if (onNotchCallBack != null) {
            NotchProperty notchProperty = new NotchProperty();
            notchProperty.setNotchHeight(getNotchHeight(activity.getWindow()));
            notchProperty.setNotch(isNotchScreen(activity.getWindow()));
            notchProperty.setMarginTop(i);
            if (onNotchCallBack != null) {
                onNotchCallBack.onNotchPropertyCallback(notchProperty);
            }
        }
    }

    protected void onBindCallBackWithNotchProperty(Dialog dialog, int i, OnNotchCallBack onNotchCallBack) {
        if (onNotchCallBack != null) {
            NotchProperty notchProperty = new NotchProperty();
            notchProperty.setNotchHeight(getNotchHeight(dialog.getWindow()));
            notchProperty.setNotch(isNotchScreen(dialog.getWindow()));
            notchProperty.setMarginTop(i);
            if (onNotchCallBack != null) {
                onNotchCallBack.onNotchPropertyCallback(notchProperty);
            }
        }
    }
}