package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class GeneralOneButtonDialog extends BaseSyncDialog {
    private boolean isAutoDismiss;
    private View.OnClickListener listener;
    private TextView tvConfirm;
    private TextView tvContent;
    private TextView tvTitle;

    public GeneralOneButtonDialog(Context context) {
        super(context, R.layout.dialog_common_one_button);
        this.isAutoDismiss = true;
        setCanceledOnTouchOutside(false);
    }

    public GeneralOneButtonDialog setTitle(String str) {
        this.tvTitle.setText(str);
        return this;
    }

    public GeneralOneButtonDialog setTitleId(int i) {
        this.tvTitle.setText(i);
        return this;
    }

    public GeneralOneButtonDialog setContent(String str) {
        this.tvContent.setText(str);
        return this;
    }

    public GeneralOneButtonDialog setContent(int i) {
        this.tvContent.setText(i);
        return this;
    }

    public GeneralOneButtonDialog setConfirmStr(String str) {
        this.tvConfirm.setText(str);
        return this;
    }

    public GeneralOneButtonDialog setConfirmStr(int i) {
        this.tvConfirm.setText(i);
        return this;
    }

    public GeneralOneButtonDialog setAutoDismiss(Boolean bool) {
        this.isAutoDismiss = bool.booleanValue();
        return this;
    }

    public GeneralOneButtonDialog setConfirmListener(View.OnClickListener onClickListener) {
        this.listener = onClickListener;
        return this;
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        this.tvTitle = (TextView) findViewById(R.id.tv_dialog_title);
        this.tvContent = (TextView) findViewById(R.id.tv_content);
        TextView textView = (TextView) findViewById(R.id.btn_ok);
        this.tvConfirm = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.-$$Lambda$GeneralOneButtonDialog$-QjLt6KoNTRwwiECDgvhKH6sXpU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeneralOneButtonDialog.this.lambda$initView$0$GeneralOneButtonDialog(view);
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$GeneralOneButtonDialog(View view) {
        if (this.isAutoDismiss) {
            dismiss();
        }
        View.OnClickListener onClickListener = this.listener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        if (getContext().getResources().getConfiguration().orientation == 2) {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(getContext()) * 0.45d), -2);
        } else {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(getContext()) * 0.7d), -2);
        }
    }
}
