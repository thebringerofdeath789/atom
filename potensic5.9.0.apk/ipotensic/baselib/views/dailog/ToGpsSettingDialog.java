package com.ipotensic.baselib.views.dailog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.ipotensic.baselib.R;
import com.ipotensic.baselib.base.BaseSyncDialog;

/* loaded from: classes2.dex */
public class ToGpsSettingDialog extends BaseSyncDialog {

    public interface ResultListener<T> {
        void onResult(Dialog dialog, T t);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public ToGpsSettingDialog(Context context, final ResultListener<Boolean> resultListener) {
        super(context, R.layout.view_dialog_to_gps_setting);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.baselib.views.dailog.ToGpsSettingDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToGpsSettingDialog.this.dismiss();
                resultListener.onResult(ToGpsSettingDialog.this, false);
            }
        });
        findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.baselib.views.dailog.ToGpsSettingDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                resultListener.onResult(ToGpsSettingDialog.this, true);
            }
        });
    }
}