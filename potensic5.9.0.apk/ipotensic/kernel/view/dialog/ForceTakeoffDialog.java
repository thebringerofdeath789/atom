package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class ForceTakeoffDialog extends BaseSyncDialog {
    public ForceTakeoffDialog(Context context) {
        super(context, R.layout.dialog_force_takeoff);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.ForceTakeoffDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForceTakeoffDialog.this.dismiss();
            }
        });
        findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.ForceTakeoffDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ForceTakeoffDialog.this.dismiss();
                EventDispatcher.get().sendEvent(EventID.FLIGHT_TAKE_OFF);
            }
        });
    }
}