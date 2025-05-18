package com.ipotensic.baselib.notchtools.phone;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.Window;
import com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport;
import com.ipotensic.baselib.notchtools.core.OnNotchCallBack;
import com.ipotensic.baselib.notchtools.helper.NotchStatusBarUtils;
import com.ipotensic.baselib.notchtools.helper.SystemProperties;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class MiuiNotchScreen extends AbsNotchScreenSupport {
    private static final String TAG = "MiuiNotchScreen";

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public boolean isNotchScreen(Window window) {
        return "1".equals(SystemProperties.getInstance().get("ro.miui.notch"));
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public int getNotchHeight(Window window) {
        if (!isNotchScreen(window) || window == null) {
            return 0;
        }
        Context context = window.getContext();
        if (isHideNotch(window.getContext())) {
            return NotchStatusBarUtils.getStatusBarHeight(context);
        }
        return getRealNotchHeight(context);
    }

    private int getRealNotchHeight(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Override // com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport, com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenDontUseStatus(Activity activity, OnNotchCallBack onNotchCallBack) {
        super.fullScreenDontUseStatus(activity, onNotchCallBack);
        if (Build.VERSION.SDK_INT < 26 || !isNotchScreen(activity.getWindow())) {
            return;
        }
        try {
            Method method = Window.class.getMethod("addExtraFlags", Integer.TYPE);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(activity.getWindow(), 1280);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport, com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenUseStatus(Activity activity, OnNotchCallBack onNotchCallBack) {
        super.fullScreenUseStatus(activity, onNotchCallBack);
        if (Build.VERSION.SDK_INT < 26 || !isNotchScreen(activity.getWindow())) {
            return;
        }
        try {
            Method method = Window.class.getMethod("addExtraFlags", Integer.TYPE);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(activity.getWindow(), 1792);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport, com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenUseStatus(Dialog dialog, OnNotchCallBack onNotchCallBack) {
        super.fullScreenUseStatus(dialog, onNotchCallBack);
        if (Build.VERSION.SDK_INT < 26 || !isNotchScreen(dialog.getWindow())) {
            return;
        }
        try {
            Method method = Window.class.getMethod("addExtraFlags", Integer.TYPE);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(dialog.getWindow(), 1792);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isHideNotch(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "force_black", 0) == 1;
    }
}