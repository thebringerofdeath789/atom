package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class MiniPairFailDialog extends BaseSyncDialog {
    private OnClickListener onClickListener;

    public interface OnClickListener {
        void onConfirm();
    }

    public MiniPairFailDialog(Context context, int i, OnClickListener onClickListener) {
        super(context, i);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.onClickListener = onClickListener;
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        findViewById(R.id.btn_ok).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.view.dialog.MiniPairFailDialog.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                MiniPairFailDialog.this.dismiss();
                if (MiniPairFailDialog.this.onClickListener != null) {
                    MiniPairFailDialog.this.onClickListener.onConfirm();
                }
            }
        });
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        if (getContext().getResources().getConfiguration().orientation == 2) {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(getContext()) * 0.45f), (int) (ScreenUtils.getScreenHeight(getContext()) * 0.8f));
        } else {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(getContext()) * 0.9f), -2);
        }
    }
}