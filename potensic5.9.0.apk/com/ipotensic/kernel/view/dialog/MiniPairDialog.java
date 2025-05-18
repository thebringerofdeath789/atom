package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.C1965R;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.type.Flight;

/* loaded from: classes2.dex */
public class MiniPairDialog extends BaseSyncDialog {
    private boolean isPairing;
    private ImageView ivClose;
    private ImageView ivCodeGif;
    private ConstraintLayout layout_mini_code;
    private TextView tvCodeStep;
    private TextView tvCodeStepTwo;
    private TextView tvCodeTitle;

    public MiniPairDialog(Context context) {
        super(context, C1965R.layout.view_dialog_mini_pair);
        this.isPairing = false;
        getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.95d), -2);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        this.layout_mini_code = (ConstraintLayout) findViewById(C1965R.id.constraint_layout);
        this.ivClose = (ImageView) findViewById(C1965R.id.iv_code_close);
        this.tvCodeTitle = (TextView) findViewById(C1965R.id.tv_code_title);
        this.ivCodeGif = (ImageView) findViewById(C1965R.id.iv_mini_code_gif);
        this.tvCodeStep = (TextView) findViewById(C1965R.id.tv_code_step);
        this.tvCodeStepTwo = (TextView) findViewById(C1965R.id.tv_code_step_two);
        int i = C1965R.drawable.gif_mini_pair;
        Flight remoterType = FlightRevData.get().getFlightRevFpvData().getRemoterType();
        if (remoterType != null) {
            if (FlightConfig.isAtomPanTilt(remoterType)) {
                i = C1965R.drawable.gif_atom_pair;
            } else if (FlightConfig.isAtomLT(remoterType)) {
                i = C1965R.drawable.gif_atomlt_pair;
            }
        }
        this.tvCodeStep.setText(getContext().getString(FlightConfig.isAtomLT() ? C1965R.string.atom_lt_frequency_pairing_mode_tips1 : C1965R.string.mini_code_step_one));
        this.tvCodeStepTwo.setText(getContext().getString(FlightConfig.isAtomLT() ? C1965R.string.atom_lt_frequency_pairing_mode_tips2 : C1965R.string.mini_code_step_two));
        Glide.with(context).load(Integer.valueOf(i)).asGif().diskCacheStrategy(DiskCacheStrategy.NONE).into(this.ivCodeGif);
        this.ivClose.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.view.dialog.MiniPairDialog.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                MiniPairDialog.this.dismiss();
            }
        });
    }

    public void success() {
        this.tvCodeTitle.setText(getContext().getString(C1965R.string.repair_mode));
        this.tvCodeStep.setText(getContext().getString(C1965R.string.repair_will_complete));
        this.tvCodeStep.setCompoundDrawables(null, null, null, null);
        this.tvCodeStepTwo.setVisibility(8);
        new Handler().postDelayed(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.MiniPairDialog.2
            @Override // java.lang.Runnable
            public void run() {
                MiniPairDialog.this.dismiss();
            }
        }, 4000L);
    }
}