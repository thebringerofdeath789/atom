package com.ipotensic.baselib.xtoast;

import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class ToastDismissRunnable extends WeakReference<XToast> implements Runnable {
    ToastDismissRunnable(XToast xToast) {
        super(xToast);
    }

    @Override // java.lang.Runnable
    public void run() {
        XToast xToast = (XToast) get();
        if (xToast == null || !xToast.isShow()) {
            return;
        }
        xToast.cancel();
    }
}
