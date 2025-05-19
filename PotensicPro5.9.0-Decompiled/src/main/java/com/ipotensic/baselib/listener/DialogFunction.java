package com.ipotensic.baselib.listener;

/* loaded from: classes2.dex */
public interface DialogFunction {

    public interface OnShowListener {
        void onDismiss();

        void onShow();
    }

    void dismiss();

    void isShowing();

    void setOnShowListener(OnShowListener onShowListener);

    void show();
}
