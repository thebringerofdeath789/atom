package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class LandConfirmDialog extends BaseSyncDialog {
    private OnConfirmListener listener;

    public interface OnConfirmListener {
        void onCancel();

        void onConfirm();
    }

    public LandConfirmDialog(Context context, OnConfirmListener onConfirmListener) {
        super(context, R.layout.dialog_landing_confirm);
        getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.5d), -2);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.listener = onConfirmListener;
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        final TextView textView = (TextView) findViewById(R.id.tv_upgrade_finished_count_down);
        final CountDownRunnable countDownRunnable = new CountDownRunnable(textView);
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.LandConfirmDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                textView.removeCallbacks(countDownRunnable);
                LandConfirmDialog.this.dismiss();
                if (LandConfirmDialog.this.listener != null) {
                    LandConfirmDialog.this.listener.onCancel();
                }
            }
        });
        findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.LandConfirmDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                textView.removeCallbacks(countDownRunnable);
                LandConfirmDialog.this.dismiss();
                if (LandConfirmDialog.this.listener != null) {
                    LandConfirmDialog.this.listener.onConfirm();
                }
            }
        });
    }

    private class CountDownRunnable implements Runnable {
        private int time = 15;
        private final TextView view;

        public CountDownRunnable(TextView textView) {
            this.view = textView;
            textView.postDelayed(this, 1000L);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.time;
            if (i > 0) {
                int i2 = i - 1;
                this.time = i2;
                this.view.setText(String.format("%s%d%s", "(", Integer.valueOf(i2), "s)"));
                this.view.postDelayed(this, 1000L);
                return;
            }
            this.view.removeCallbacks(this);
            LandConfirmDialog.this.dismiss();
            if (LandConfirmDialog.this.listener != null) {
                LandConfirmDialog.this.listener.onConfirm();
            }
        }
    }
}
