package com.ipotensic.baselib.notchtools.phone;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport;
import com.ipotensic.baselib.notchtools.core.OnNotchCallBack;
import com.ipotensic.baselib.notchtools.helper.NotchStatusBarUtils;

/* loaded from: classes2.dex */
public class OppoNotchScreen extends AbsNotchScreenSupport {
    private static final String TAG = "OppoNotchScreen";

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public boolean isNotchScreen(Window window) {
        if (window == null) {
            return false;
        }
        return window.getContext().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public int getNotchHeight(Window window) {
        if (isNotchScreen(window)) {
            return NotchStatusBarUtils.getStatusBarHeight(window.getContext());
        }
        return 0;
    }

    @Override // com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport, com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenDontUseStatus(Activity activity, OnNotchCallBack onNotchCallBack) {
        super.fullScreenDontUseStatus(activity, onNotchCallBack);
        if (isNotchScreen(activity.getWindow())) {
            NotchStatusBarUtils.setFakeNotchView(activity.getWindow());
        }
    }

    @Override // com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport, com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenDontUseStatusForPortrait(Activity activity, OnNotchCallBack onNotchCallBack) {
        fullScreenDontUseStatus(activity, onNotchCallBack);
    }

    @Override // com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport, com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenDontUseStatusForLandscape(Activity activity, OnNotchCallBack onNotchCallBack) {
        super.fullScreenDontUseStatusForLandscape(activity, onNotchCallBack);
        if (isNotchScreen(activity.getWindow())) {
            NotchStatusBarUtils.removeFakeNotchView(activity.getWindow());
        }
    }

    @Override // com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport, com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenUseStatus(Activity activity, OnNotchCallBack onNotchCallBack) {
        super.fullScreenUseStatus(activity, onNotchCallBack);
    }

    @Override // com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport, com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenUseStatus(Dialog dialog, OnNotchCallBack onNotchCallBack) {
        super.fullScreenUseStatus(dialog, onNotchCallBack);
    }
}