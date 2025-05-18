package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class LowPowerReturningDialog extends BaseSyncDialog {
    private ConfirmListener confirmListener;

    public interface ConfirmListener {
        void onConfirm();
    }

    public LowPowerReturningDialog(Context context, ConfirmListener confirmListener) {
        super(context, C1965R.layout.dialog_low_power_returning);
        this.confirmListener = confirmListener;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.5d), -2);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        findViewById(C1965R.id.btn_ok).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.LowPowerReturningDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LowPowerReturningDialog.this.confirmListener != null) {
                    LowPowerReturningDialog.this.confirmListener.onConfirm();
                }
            }
        });
    }
}