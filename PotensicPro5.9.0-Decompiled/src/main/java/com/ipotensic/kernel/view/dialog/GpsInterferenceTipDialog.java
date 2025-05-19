package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.baselib.utils.SoundPoolPlayer;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class GpsInterferenceTipDialog extends BaseSyncDialog {
    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public GpsInterferenceTipDialog(Context context) {
        super(context, R.layout.view_dialog_gps_interference_tip);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        setSize((int) (ScreenUtils.getScreenWidth(getContext()) * 0.48d), -2);
        findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GpsInterferenceTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GpsInterferenceTipDialog.this.dismiss();
            }
        });
    }

    @Override // com.ipotensic.baselib.base.BaseSyncDialog, com.ipotensic.baselib.base.BaseDialog, android.app.Dialog
    public void show() {
        super.show();
        SoundPoolPlayer.getInstance().playVoice(getContext(), SoundPoolPlayer.GPS_INTERFERENCE_ID);
    }
}
