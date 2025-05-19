package com.ipotensic.baselib.base;

import android.content.Context;
import android.content.DialogInterface;
import com.ipotensic.baselib.DDLog;

/* loaded from: classes2.dex */
public abstract class BaseSyncDialog extends BaseDialog {
    public static volatile boolean isShow = false;

    public BaseSyncDialog(Context context, int i) {
        super(context, i);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ipotensic.baselib.base.BaseSyncDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                BaseSyncDialog.isShow = false;
            }
        });
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(final DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ipotensic.baselib.base.BaseSyncDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                BaseSyncDialog.isShow = false;
                DialogInterface.OnDismissListener onDismissListener2 = onDismissListener;
                if (onDismissListener2 != null) {
                    onDismissListener2.onDismiss(BaseSyncDialog.this);
                }
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
            isShow = false;
        } catch (Exception e) {
            DDLog.e("dialog error: " + e);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog
    public void show() {
        super.show();
        isShow = true;
    }
}
