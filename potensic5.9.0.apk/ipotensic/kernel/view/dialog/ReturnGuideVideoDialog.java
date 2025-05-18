package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class ReturnGuideVideoDialog extends BaseSyncDialog {

    public interface OnGuideVideoListener {
        void onPlay();
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public ReturnGuideVideoDialog(Context context, final OnGuideVideoListener onGuideVideoListener) {
        super(context, R.layout.view_dialog_return_guide_video);
        int screenHeight = (int) (ScreenUtils.getScreenHeight(getContext()) * 0.6f);
        setSize((int) (screenHeight * 1.6f), screenHeight);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        findViewById(R.id.btn_rth_guide_play).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.ReturnGuideVideoDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReturnGuideVideoDialog.this.dismiss();
                onGuideVideoListener.onPlay();
            }
        });
    }
}