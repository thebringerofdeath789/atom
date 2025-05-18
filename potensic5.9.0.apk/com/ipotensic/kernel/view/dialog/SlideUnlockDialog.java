package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.SlideUnlockButton;

/* loaded from: classes2.dex */
public class SlideUnlockDialog extends BaseSyncDialog implements View.OnClickListener {
    private TextView messageView;
    private SlideUnlockButton slideUnlockButton;
    private TextView titleView;

    public interface SlideResultListener {
        void dealEvent();
    }

    public SlideUnlockDialog(Context context, String str, String str2, final SlideResultListener slideResultListener) {
        super(context, C1965R.layout.view_dialog_slide_unlock);
        getWindow().setGravity(17);
        getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.45d), -2);
        getWindow().setDimAmount(0.5f);
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
        SlideUnlockButton slideUnlockButton = this.slideUnlockButton;
        if (slideUnlockButton != null) {
            slideUnlockButton.setProgressListener(new SlideUnlockButton.SlideProgressListener() { // from class: com.ipotensic.kernel.view.dialog.SlideUnlockDialog.1
                @Override // com.ipotensic.kernel.view.SlideUnlockButton.SlideProgressListener
                public void onProgressChanged(int i) {
                    SlideUnlockDialog.this.dismiss();
                    slideResultListener.dealEvent();
                }
            });
        }
    }

    public void setShow(String str, String str2) {
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(str2);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        this.titleView = (TextView) findViewById(C1965R.id.tv_dialog_title);
        this.messageView = (TextView) findViewById(C1965R.id.tv_dialog_message);
        this.slideUnlockButton = (SlideUnlockButton) findViewById(C1965R.id.btn_slide_unlock);
        findViewById(C1965R.id.btn_cancel).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C1965R.id.btn_cancel) {
            dismiss();
        }
    }
}