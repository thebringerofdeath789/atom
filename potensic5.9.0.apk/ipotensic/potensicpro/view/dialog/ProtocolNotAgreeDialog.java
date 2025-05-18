package com.ipotensic.potensicpro.view.dialog;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public class ProtocolNotAgreeDialog extends BaseSyncDialog {
    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public ProtocolNotAgreeDialog(Context context) {
        super(context, R.layout.view_dialog_protocol_tip);
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.ProtocolNotAgreeDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ProtocolNotAgreeDialog.this.dismiss();
            }
        });
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            if (getContext().getResources().getConfiguration().orientation == 2) {
                attributes.width = -2;
                attributes.height = (int) (ScreenUtils.getScreenHeight(getContext()) * 0.8d);
            } else {
                attributes.width = (int) (ScreenUtils.getScreenWidth(getContext()) * 0.83d);
                attributes.height = -2;
            }
        }
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }
}