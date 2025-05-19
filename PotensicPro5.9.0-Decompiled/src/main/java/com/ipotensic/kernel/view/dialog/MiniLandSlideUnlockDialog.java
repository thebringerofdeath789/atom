package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.MiniLandSlideUnlockView;
import com.logan.flight.DataManager;
import com.logan.flight.enums.CtrlType;

/* loaded from: classes2.dex */
public class MiniLandSlideUnlockDialog extends BaseSyncDialog implements View.OnClickListener {
    private CountDownTimer countDownTimer;
    private ImageButton ibClose;
    private boolean isCountdown;
    private MiniLandSlideUnlockView landSlideUnlockView;
    private SlideUnlockListener listener;
    private final TextView textCountDown;

    public interface SlideUnlockListener {
        void onKeyLand();

        void onKeyReturn();
    }

    public MiniLandSlideUnlockDialog(Context context, SlideUnlockListener slideUnlockListener, boolean z) {
        super(context, R.layout.view_dialog_mini_slide_land);
        this.isCountdown = false;
        this.listener = slideUnlockListener;
        setCanceledOnTouchOutside(false);
        getWindow().setDimAmount(0.5f);
        this.isCountdown = z;
        TextView textView = (TextView) findViewById(R.id.tv_count_down);
        this.textCountDown = textView;
        this.landSlideUnlockView.switchCenterCircleBpToNoContent(z);
        String string = getContext().getString(R.string.dialog_mini_land_content);
        if (z) {
            if (PhoneConfig.isFt) {
                string = String.format(getContext().getString(R.string.short_distance_land_notice), "66ft", "16ft");
            } else {
                string = String.format(getContext().getString(R.string.short_distance_land_notice), "20m", "5m");
            }
        }
        ((TextView) findViewById(R.id.tv_mini_takeoff_content)).setText(string);
        textView.setVisibility(z ? 0 : 8);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.btn_close_land);
        this.ibClose = imageButton;
        imageButton.setOnClickListener(this);
        MiniLandSlideUnlockView miniLandSlideUnlockView = (MiniLandSlideUnlockView) findViewById(R.id.btn_mini_slide_unlock_land);
        this.landSlideUnlockView = miniLandSlideUnlockView;
        miniLandSlideUnlockView.setSlideProgressListener(new MiniLandSlideUnlockView.SlideProgressListener() { // from class: com.ipotensic.kernel.view.dialog.-$$Lambda$MiniLandSlideUnlockDialog$v0Lp5GxwJDJ0s0mAd22k_KbkFVI
            @Override // com.ipotensic.kernel.view.MiniLandSlideUnlockView.SlideProgressListener
            public final void onProgressChanged(int i) {
                MiniLandSlideUnlockDialog.this.lambda$initView$0$MiniLandSlideUnlockDialog(i);
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$MiniLandSlideUnlockDialog(int i) {
        dismiss();
        SlideUnlockListener slideUnlockListener = this.listener;
        if (slideUnlockListener == null) {
            return;
        }
        if (i == 100) {
            slideUnlockListener.onKeyReturn();
        } else if (i == -100) {
            slideUnlockListener.onKeyLand();
        }
    }

    public void updateCountDownView(int i) {
        this.textCountDown.setText(i + "s");
    }

    public void setNoClose() {
        this.ibClose.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.isCountdown) {
            DataManager.getInstance().sendCtrlData(CtrlType.TYPE_CANCEL_AUTO_FLY);
        }
        dismiss();
    }
}
