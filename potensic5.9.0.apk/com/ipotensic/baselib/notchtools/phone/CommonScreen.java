package com.ipotensic.baselib.notchtools.phone;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport;
import com.ipotensic.baselib.notchtools.core.OnNotchCallBack;

/* loaded from: classes2.dex */
public class CommonScreen extends AbsNotchScreenSupport {
    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public int getNotchHeight(Window window) {
        return 0;
    }

    @Override // com.ipotensic.baselib.notchtools.core.INotchSupport
    public boolean isNotchScreen(Window window) {
        return false;
    }

    @Override // com.ipotensic.baselib.notchtools.core.AbsNotchScreenSupport, com.ipotensic.baselib.notchtools.core.INotchSupport
    public void fullScreenDontUseStatus(Activity activity, OnNotchCallBack onNotchCallBack) {
        super.fullScreenDontUseStatus(activity, onNotchCallBack);
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