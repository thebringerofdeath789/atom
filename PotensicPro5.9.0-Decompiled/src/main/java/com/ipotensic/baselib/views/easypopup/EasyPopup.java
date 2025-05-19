package com.ipotensic.baselib.views.easypopup;

import android.content.Context;
import android.view.View;

/* loaded from: classes2.dex */
public class EasyPopup extends BasePopup<EasyPopup> {
    private OnViewListener mOnViewListener;

    public interface OnViewListener {
        void initViews(View view, EasyPopup easyPopup);
    }

    @Override // com.ipotensic.baselib.views.easypopup.BasePopup
    protected void initAttributes() {
    }

    public static EasyPopup create() {
        return new EasyPopup();
    }

    public static EasyPopup create(Context context) {
        return new EasyPopup(context);
    }

    public EasyPopup() {
    }

    public EasyPopup(Context context) {
        setContext(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ipotensic.baselib.views.easypopup.BasePopup
    public void initViews(View view, EasyPopup easyPopup) {
        OnViewListener onViewListener = this.mOnViewListener;
        if (onViewListener != null) {
            onViewListener.initViews(view, easyPopup);
        }
    }

    public EasyPopup setOnViewListener(OnViewListener onViewListener) {
        this.mOnViewListener = onViewListener;
        return this;
    }
}
