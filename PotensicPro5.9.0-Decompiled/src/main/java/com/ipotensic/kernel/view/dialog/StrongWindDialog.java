package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class StrongWindDialog extends BaseSyncDialog {
    private ConfirmListener confirmListener;
    private Runnable countDownTimer;
    private Handler handler;
    private int time;

    public interface ConfirmListener {
        void onConfirm();
    }

    static /* synthetic */ int access$006(StrongWindDialog strongWindDialog) {
        int i = strongWindDialog.time - 1;
        strongWindDialog.time = i;
        return i;
    }

    public StrongWindDialog(Context context, String str, ConfirmListener confirmListener) {
        super(context, R.layout.dialog_strong_wind);
        this.countDownTimer = new Runnable() { // from class: com.ipotensic.kernel.view.dialog.StrongWindDialog.1
            @Override // java.lang.Runnable
            public void run() {
                StrongWindDialog.access$006(StrongWindDialog.this);
                if (StrongWindDialog.this.time > 0) {
                    StrongWindDialog.this.handler.postDelayed(this, 1000L);
                } else if (StrongWindDialog.this.confirmListener != null) {
                    StrongWindDialog.this.confirmListener.onConfirm();
                }
            }
        };
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.5d), -2);
        Handler handler = new Handler();
        this.handler = handler;
        this.time = 10;
        handler.post(this.countDownTimer);
        this.confirmListener = confirmListener;
        ((TextView) findViewById(R.id.tv_content)).setText(str);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.StrongWindDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StrongWindDialog.this.confirmListener != null) {
                    StrongWindDialog.this.confirmListener.onConfirm();
                }
            }
        });
    }

    @Override // com.ipotensic.baselib.base.BaseSyncDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.handler.removeCallbacks(this.countDownTimer);
    }
}
