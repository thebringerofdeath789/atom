package com.ipotensic.baselib.notchtools.phone;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport;
import com.ipotensic.baselib.notchtools.core.OnNotchCallBack;
import com.ipotensic.baselib.notchtools.helper.NotchStatusBarUtils;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class VivoNotchScreen extends AbsNotchScreenSupport {
    private static final String TAG = "VivoNotchScreen";
    private Class mClass;
    private Method mMethod;

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public boolean isNotchScreen(Window window) {
        if (window == null) {
            return false;
        }
        try {
            Class<?> loadClass = window.getContext().getClassLoader().loadClass("android.util.FtFeature");
            this.mClass = loadClass;
            Method method = loadClass.getMethod("isFeatureSupport", Integer.TYPE);
            this.mMethod = method;
            return ((Boolean) method.invoke(this.mClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
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