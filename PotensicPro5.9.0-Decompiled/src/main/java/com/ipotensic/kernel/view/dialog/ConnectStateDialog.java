package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class ConnectStateDialog extends BaseSyncDialog {
    private ImageButton btnClose;
    private TextView tvContent;
    private TextView tvTitle;

    public ConnectStateDialog(Context context, String str, String str2) {
        super(context, R.layout.dialog_connect_state_tip);
        this.tvTitle.setText(str);
        this.tvContent.setText(str2);
        this.btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.ConnectStateDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConnectStateDialog.this.dismiss();
            }
        });
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        this.tvTitle = (TextView) findViewById(R.id.tv_code_title);
        this.tvContent = (TextView) findViewById(R.id.tv_content);
        this.btnClose = (ImageButton) findViewById(R.id.btn_close);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        if (getContext().getResources().getConfiguration().orientation == 2) {
            getWindow().setLayout((int) (ScreenUtils.getScreenHeight(getContext()) * 0.8d), -2);
        } else {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(getContext()) * 0.8d), -2);
        }
        setCanceledOnTouchOutside(true);
    }
}
