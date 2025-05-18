package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class DisclaimerDialog extends BaseSyncDialog implements View.OnClickListener {
    private TextView tvContent;

    public DisclaimerDialog(Context context) {
        super(context, C1965R.layout.view_dialog_battery_disclaimer);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        findViewById(C1965R.id.btn_confirm).setOnClickListener(this);
        this.tvContent = (TextView) findViewById(C1965R.id.tv_detail);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C1965R.id.btn_confirm) {
            dismiss();
        }
    }

    public void updateContent(String str) {
        this.tvContent.setText(str);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        if (getContext().getResources().getConfiguration().orientation == 2) {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(getContext()) * 0.5d), -2);
        } else {
            getWindow().setLayout((int) (ScreenUtils.getScreenHeight(getContext()) * 0.5d), -2);
        }
        getWindow().setGravity(17);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
}