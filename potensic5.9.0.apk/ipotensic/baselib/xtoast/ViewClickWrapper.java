package com.ipotensic.baselib.xtoast;

import android.view.View;

/* loaded from: classes2.dex */
final class ViewClickWrapper implements View.OnClickListener {
    private final OnClickListener mListener;
    private final XToast mToast;

    ViewClickWrapper(XToast xToast, View view, OnClickListener onClickListener) {
        this.mToast = xToast;
        this.mListener = onClickListener;
        view.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.mListener.onClick(this.mToast, view);
    }
}