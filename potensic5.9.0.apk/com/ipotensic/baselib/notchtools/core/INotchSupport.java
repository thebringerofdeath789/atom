package com.ipotensic.baselib.notchtools.core;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;

/* loaded from: classes2.dex */
public interface INotchSupport {
    void fullScreenDontUseStatus(Activity activity, OnNotchCallBack onNotchCallBack);

    void fullScreenDontUseStatusForLandscape(Activity activity, OnNotchCallBack onNotchCallBack);

    void fullScreenDontUseStatusForPortrait(Activity activity, OnNotchCallBack onNotchCallBack);

    void fullScreenUseStatus(Activity activity, OnNotchCallBack onNotchCallBack);

    void fullScreenUseStatus(Dialog dialog, OnNotchCallBack onNotchCallBack);

    int getNotchHeight(Window window);

    int getStatusHeight(Window window);

    boolean isNotchScreen(Window window);
}