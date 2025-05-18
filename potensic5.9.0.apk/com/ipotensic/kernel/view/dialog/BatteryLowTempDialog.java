package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class BatteryLowTempDialog extends BaseSyncDialog implements View.OnClickListener {
    public BatteryLowTempDialog(Context context) {
        super(context, C1965R.layout.view_dialog_battery_low_temp);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        findViewById(C1965R.id.btn_confirm).setOnClickListener(this);
        ((TextView) findViewById(C1965R.id.tv_error_code)).setText(context.getString(C1965R.string.txt_error_code, "16"));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C1965R.id.btn_confirm) {
            dismiss();
        }
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