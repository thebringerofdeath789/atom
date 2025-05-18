package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.MiniTakeoffSlideUnlockView;

/* loaded from: classes2.dex */
public class MiniTakeoffSlideUnlockDialog extends BaseSyncDialog implements View.OnClickListener {
    private boolean isTakeOff;
    private SlideUnlockListener listener;
    private MiniTakeoffSlideUnlockView takeoffSlideUnlockView;
    private TextView tvContent;
    private TextView tvTitle;

    public interface SlideUnlockListener {
        void takeOff(boolean z);
    }

    public MiniTakeoffSlideUnlockDialog(Context context, String str, String str2, boolean z, boolean z2, SlideUnlockListener slideUnlockListener) {
        super(context, R.layout.view_dialog_mini_slide_takeoff);
        this.listener = slideUnlockListener;
        setLayoutParam();
        setCanceledOnTouchOutside(false);
        getWindow().setDimAmount(0.5f);
        this.tvTitle.setText(str);
        this.tvContent.setText(str2);
        this.takeoffSlideUnlockView.setTakeOff(z, z2);
        this.isTakeOff = z;
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        this.tvTitle = (TextView) findViewById(R.id.tv_mini_takeoff_title);
        this.tvContent = (TextView) findViewById(R.id.tv_mini_takeoff_content);
        findViewById(R.id.btn_close_takeoff).setOnClickListener(this);
        MiniTakeoffSlideUnlockView miniTakeoffSlideUnlockView = (MiniTakeoffSlideUnlockView) findViewById(R.id.btn_mini_slide_unlock_takeoff);
        this.takeoffSlideUnlockView = miniTakeoffSlideUnlockView;
        miniTakeoffSlideUnlockView.setSlideProgressListener(new MiniTakeoffSlideUnlockView.SlideProgressListener() { // from class: com.ipotensic.kernel.view.dialog.MiniTakeoffSlideUnlockDialog.1
            @Override // com.ipotensic.kernel.view.MiniTakeoffSlideUnlockView.SlideProgressListener
            public void onProgressChanged(int i) {
                MiniTakeoffSlideUnlockDialog.this.dismiss();
                if (MiniTakeoffSlideUnlockDialog.this.listener != null) {
                    MiniTakeoffSlideUnlockDialog.this.listener.takeOff(MiniTakeoffSlideUnlockDialog.this.isTakeOff);
                }
            }
        });
    }

    public void setTextChange(String str, String str2, boolean z, boolean z2) {
        TextView textView = this.tvTitle;
        if (textView == null || this.tvContent == null) {
            return;
        }
        this.isTakeOff = z;
        textView.setText(str);
        this.tvContent.setText(str2);
        this.takeoffSlideUnlockView.setTakeOff(z, z2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
    }

    private void setLayoutParam() {
        Window window = getWindow();
        window.setLayout((int) (ScreenUtils.getScreenWidth(getContext()) * 0.55d), -2);
        window.setGravity(17);
    }
}